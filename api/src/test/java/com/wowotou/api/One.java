package com.wowotou.api;

import com.wowotou.payservice.downloader.YoutubeDownloader;
import com.wowotou.payservice.downloader.model.YoutubeVideo;

import java.io.File;
import java.util.Arrays;

public class One {
    public static void main(String[] s) {


        String[] s2 = new String[]{"8F1l_UFA42o"};


        Arrays.asList(s2).forEach(url -> {


            YoutubeVideo video = null;

            try {
                video = new YoutubeDownloader().getVideo(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (video != null) {

                try {
//                    System.out.println("videoFormats" + formats.audioFormats().get(0).mimeType());
                    video.download(video.formats().get(0), new File("/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/test/java/com/wowotou/api")
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });


    }
}
