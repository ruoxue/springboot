package com.wowotou.payservice.downloader.parser;

/*-
 * #
 * Java youtube video and audio downloader
 *
 * Copyright (C) 2020 Igor Kiulian
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wowotou.payservice.downloader.YoutubeException;
import com.wowotou.payservice.downloader.cipher.CachedCipherFactory;
import com.wowotou.payservice.downloader.cipher.Cipher;
import com.wowotou.payservice.downloader.cipher.CipherFactory;
import com.wowotou.payservice.downloader.extractor.DefaultExtractor;
import com.wowotou.payservice.downloader.extractor.Extractor;
import com.wowotou.payservice.downloader.model.Itag;
import com.wowotou.payservice.downloader.model.VideoDetails;
import com.wowotou.payservice.downloader.model.formats.AudioFormat;
import com.wowotou.payservice.downloader.model.formats.AudioVideoFormat;
import com.wowotou.payservice.downloader.model.formats.Format;
import com.wowotou.payservice.downloader.model.formats.VideoFormat;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class DefaultParser implements Parser {

    private Extractor extractor;
    private CipherFactory cipherFactory;

    public DefaultParser() {
        this.extractor = new DefaultExtractor();
        this.cipherFactory = new CachedCipherFactory(extractor);
    }

    @Override
    public Extractor getExtractor() {
        return extractor;
    }

    @Override
    public CipherFactory getCipherFactory() {
        return cipherFactory;
    }

    @Override
    public JSONObject getPlayerConfig(String htmlUrl) throws YoutubeException {
        String html = extractor.loadUrl(htmlUrl);
//        System.out.println(html);
        String ytPlayerConfig = extractor.extractYtPlayerConfig(html);
//        System.out.println(ytPlayerConfig);


        try {
            return JSON.parseObject(ytPlayerConfig);
        } catch (Exception e) {
            throw new YoutubeException.BadPageException("Could not parse player config json");
        }
    }

    @Override
    public String getJsUrl(JSONObject config) throws YoutubeException {
        if (!config.containsKey("assets"))
            throw new YoutubeException.BadPageException("Could not extract js url: assets not found");
        return "https://youtube.com" + config.getJSONObject("assets").getString("js");
    }

    @Override
    public VideoDetails getVideoDetails(JSONObject config) {
        JSONObject args = config.getJSONObject("args");
        JSONObject playerResponse = args.getJSONObject("player_response");
        String uploadDate = "";
        if (playerResponse.containsKey("microformat")){
            JSONObject microformat = playerResponse.getJSONObject("microformat");
            if(microformat.containsKey("playerMicroformatRenderer")){
                JSONObject playerMicroformatRenderer = microformat.getJSONObject("playerMicroformatRenderer");
                uploadDate = playerMicroformatRenderer.getString("uploadDate");
            }
        }

        if (playerResponse.containsKey("videoDetails")) {
            JSONObject videoDetails = playerResponse.getJSONObject("videoDetails");
            videoDetails.put("uploadDate",uploadDate);
            return new VideoDetails(videoDetails);
        }

        return new VideoDetails();
    }

    @Override
    public List<Format> parseFormats(JSONObject config) throws YoutubeException {
        JSONObject args = config.getJSONObject("args");
        JSONObject playerResponse = args.getJSONObject("player_response");

        if (!playerResponse.containsKey("streamingData")) {
            throw new YoutubeException.BadPageException("Streaming data not found");
        }

        JSONObject streamingData = playerResponse.getJSONObject("streamingData");
        JSONArray jsonFormats = new JSONArray();
        if (streamingData.containsKey("formats")) {
            jsonFormats.addAll(streamingData.getJSONArray("formats"));
        }
        if (streamingData.containsKey("adaptiveFormats")) {
            jsonFormats.addAll(streamingData.getJSONArray("adaptiveFormats"));
        }

        List<Format> formats = new ArrayList<>(jsonFormats.size());
        for (int i = 0; i < jsonFormats.size(); i++) {
            JSONObject json = jsonFormats.getJSONObject(i);
            try {
                Format format = parseFormat(json, config);
                formats.add(format);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return formats;
    }

    private Format parseFormat(JSONObject json, JSONObject config) throws YoutubeException {
        if (json.containsKey("cipher")) {
            JSONObject jsonCipher = new JSONObject();
            String[] cipherData = json.getString("cipher").replace("\\u0026", "&").split("&");
            for (String s : cipherData) {
                String[] keyValue = s.split("=");
                jsonCipher.put(keyValue[0], keyValue[1]);
            }
            if (!jsonCipher.containsKey("url")) {
                throw new YoutubeException.BadPageException("Could not found url in cipher data");
            }
            String urlWithSig = jsonCipher.getString("url");

            try {
                urlWithSig = URLDecoder.decode(urlWithSig, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (urlWithSig.contains("signature")
                    || (!jsonCipher.containsKey("s") && (urlWithSig.contains("&sig=") || urlWithSig.contains("&lsig=")))) {
                // do nothing, this is pre-signed videos with signature
            } else {
                String s = jsonCipher.getString("s");
                try {
                    s = URLDecoder.decode(s, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String jsUrl = getJsUrl(config);
                Cipher cipher = cipherFactory.createCipher(jsUrl);

                String signature = cipher.getSignature(s);
                String decipheredUrl = urlWithSig + "&sig=" + signature;
                json.put("url", decipheredUrl);
            }
        }else   if (json.containsKey("signatureCipher")) {


            String signatureCipher = StringUtils.substringBetween(json.getString("signatureCipher"), "url=");

            json.put("url", signatureCipher);
        }

        Itag itag = Itag.valueOf("i" + json.getInteger("itag"));
        if (itag.isVideo() && itag.isAudio()){

            try {
                AudioVideoFormat audioVideoFormat = new AudioVideoFormat(json);
                return audioVideoFormat;

            }catch (Exception e){
                e.printStackTrace();
                return  null;
            }

        }
        else if (itag.isVideo())
            return new VideoFormat(json);

        return new AudioFormat(json);
    }
}
