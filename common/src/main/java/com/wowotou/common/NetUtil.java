package com.wowotou.common;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

public class NetUtil {

    public static String GET(String url,Map<String,String> map,String ua,boolean isGo){
        try {
            Connection.Response execute = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
                    .validateTLSCertificates(false)
                    .headers(map)
                    .userAgent(ua)
                    .followRedirects(isGo)
                    .method(Connection.Method.GET)
                    .execute();
            if (isGo){
                return  execute.header("location");
            }else {
                return  execute.body();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }


}
