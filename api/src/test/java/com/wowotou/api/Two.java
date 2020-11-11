package com.wowotou.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.wowotou.common.JsonUtil;
import com.wowotou.payservice.downloader.YoutubeDownloader;
import com.wowotou.payservice.downloader.model.YoutubeVideo;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Two {
    public  static  void  main(String[] ss) throws Exception {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(100);

        Document parse = Jsoup.parse(new URL("https://www.youtube.com/playlist?list=PLyfU1Nr0inRn5UrJJ-sG5wXPc_A_Dp0La")
                , 1000 * 1000);
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Elements elementsByClass
                = parse.getElementsByTag("script");//.get(0).attr("data-video-id")
//        System.out.println(elementsByClass);

        elementsByClass.forEach(v -> {

            if (v.toString().contains("ytInitialData")) {

                String s = v.data().split(";")[0];

                s = s.substring(s.indexOf("{"), s.lastIndexOf("}") + 1);
//                System.out.printf(""+s);
                s = s.replace("'D'", "");
                s = s.replaceAll("\\\\\"", "\"");

                if (!s.contains("function")) {


                    JsonObject jsonObject = null;
                    try {
                        jsonObject = new JsonUtil<JsonObject>().fromJson(new JSONObject(s).toString(), JsonObject.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    JsonObject asJsonObject = jsonObject.get("contents").getAsJsonObject().get("twoColumnBrowseResultsRenderer").getAsJsonObject();
                    // System.out.println(asJsonObject);

                    JsonArray asJsonArray = asJsonObject.get("tabs").getAsJsonArray().get(0).getAsJsonObject()
                            .getAsJsonObject("tabRenderer").get("content").getAsJsonObject().get("sectionListRenderer").getAsJsonObject().getAsJsonArray("contents").get(0).getAsJsonObject().getAsJsonObject("itemSectionRenderer").getAsJsonArray("contents").get(0).getAsJsonObject().getAsJsonObject("playlistVideoListRenderer").getAsJsonArray("contents");


                    asJsonArray.forEach(vv -> {
                        String asString = vv.getAsJsonObject().getAsJsonObject("playlistVideoRenderer").get("videoId").getAsString();

//
//                    scheduledThreadPoolExecutor.execute(()->{
                        try {

                            YoutubeVideo video = null;

                            String url = asString.replace("/watch?v=", "").replace("https://youtu.be/", "");
                            System.out.println(url);

                            try {
                                video = new YoutubeDownloader().getVideo(url);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (video!=null){

                                try {
                                    video.download(video.audioFormats().get(0), new File("/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/test/java/com/wowotou/api")
                                    );
                                }catch (Exception e){

                                }
                            }
                            System.out.println(video.details());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                   });

                    });
                }
                System.out.println(s);
            }
        });

    }
    }
