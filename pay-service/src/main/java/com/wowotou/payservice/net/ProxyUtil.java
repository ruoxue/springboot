package com.wowotou.payservice.net;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProxyUtil {

    public static Map<String, String> getProxyIp(String address) {
        String url = "http://www.89ip.cn/tqdl.html?api=1&num=1&port=&address=" + address + "&isp=";

        try {
            Document document = Jsoup.connect(url).post();
            String trim = document.text().replaceAll("高效高匿名代理IP提取地址：http://www.qydaili.com/", "").trim();
            String[] split = trim.split(":");

            Map<String, String> map = new HashMap<>();
            map.put("ip", split[0]);
            map.put("port", split[1]);
            return null;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }
}
