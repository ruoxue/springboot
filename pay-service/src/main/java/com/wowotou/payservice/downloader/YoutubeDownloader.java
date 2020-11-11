package com.wowotou.payservice.downloader;

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


import com.alibaba.fastjson.JSONObject;
import com.alipay.api.domain.Video;
import com.wowotou.payservice.downloader.cipher.CipherFunction;
import com.wowotou.payservice.downloader.model.VideoDetails;
import com.wowotou.payservice.downloader.model.YoutubeVideo;
import com.wowotou.payservice.downloader.model.formats.Format;
import com.wowotou.payservice.downloader.model.formats.VideoFormat;
import com.wowotou.payservice.downloader.model.quality.VideoQuality;
import com.wowotou.payservice.downloader.parser.DefaultParser;
import com.wowotou.payservice.downloader.parser.Parser;

import java.io.IOException;
import java.util.List;

public class YoutubeDownloader {

    private Parser parser;

    public YoutubeDownloader() {
        this.parser = new DefaultParser();
    }

    public YoutubeDownloader(Parser parser) {
        this.parser = parser;
    }

    public void setParserRequestProperty(String key, String value) {
        parser.getExtractor().setRequestProperty(key, value);
    }

    public void setParserRetryOnFailure(int retryOnFailure) {
        parser.getExtractor().setRetryOnFailure(retryOnFailure);
    }

    public void addCipherFunctionPattern(int priority, String regex) {
        parser.getCipherFactory().addInitialFunctionPattern(priority, regex);
    }

    public void addCipherFunctionEquivalent(String regex, CipherFunction function) {
        parser.getCipherFactory().addFunctionEquivalent(regex, function);
    }

    public YoutubeVideo getVideo(String videoId)   {
       try {
           String htmlUrl = "https://www.youtube.com/watch?v=" + videoId;

           JSONObject ytPlayerConfig = parser.getPlayerConfig(htmlUrl);

           VideoDetails videoDetails = parser.getVideoDetails(ytPlayerConfig);

           List<Format> formats = parser.parseFormats(ytPlayerConfig);
           return new YoutubeVideo(videoDetails, formats);
       }catch (Exception e){
           return  null;
       }
    }





}
