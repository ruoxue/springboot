package com.wowotou.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.wowotou.payservice.downloader.YoutubeDownloader;
import com.wowotou.payservice.downloader.model.YoutubeVideo;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Three {
    public  static  void  main(String[] s) throws IOException {
        String s1 = FileUtils.readFileToString(new File("/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/test/java/com/wowotou/api/1.json"));

        JsonArray jsonElements = new Gson().fromJson(s1, JsonArray.class);

        jsonElements.forEach(v->{
            System.out.println(v);
            String asString = ((JsonObject) v).get("playlistVideoRenderer").getAsJsonObject().get("videoId").getAsString();

            YoutubeVideo video=null;
            try {
                video = new YoutubeDownloader().getVideo(asString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (video!=null){

                try{
                    System.out.println("videoFormats"+video.audioFormats().get(0).toString());
                    video.download(video.audioFormats().get(0), new File("/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/test/java/com/wowotou/api")
                    );
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });



//        System.out.println(s1);


    }
}
