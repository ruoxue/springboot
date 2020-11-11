//package com.wowotou.payservice.net;
//
//import com.google.gson.Gson;
//import com.wowotou.common.MapUtil;
//import com.wowotou.payservice.util.USERAGENT;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * 网络请求
// */
//public class FetchUtil {
//    public static String userAgent = USERAGENT.NORMALUA;
//
//    /**
//     * get
//     * "https://mms.pinduoduo.com/goods/goods_list"
//     * .header("Origin", "https://mobile.yangkeduo.com")
//     * .header("AccessToken", URLDecoder.decode(MapUtil.StrToMapTrim(cookie).get("PDDAccessToken")))
//     */
//    public static Document Get(String url, String cookie, Map<String, String> proxy,
//                               String referrer, Map<String, String> header, String ua) {
//
//
//        System.out.println(ua);
//        Connection method = Jsoup.connect(url)
//                .cookies(MapUtil.StrToMap(cookie))
//
//                .timeout(1000 * 30)
//                .userAgent(ua) // User-Agent of Chrome 55
//                .referrer(referrer)
//                .ignoreContentType(true)
//
//                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
//                .header("Accept-Encoding", "gzip,deflate,sdch")
//                .header("Accept-Language", "zh-CN,zh;q=0.9")
//                .header("DNT", "1")
//                .header("Content-Type", "application/json; charset=UTF-8")
//
//
//                .header("Connection", "keep-alive")
//                .header("X-Requested-With", "XMLHttpRequest")
//                .maxBodySize(1024 * 1024 * 8)
//                .timeout(1000 * 10)
//                .method(Connection.Method.GET);
//        if (header != null) {
//            for (Map.Entry<String, String> entry : header.entrySet()) {
//                method = method.header(entry.getKey(), entry.getValue());
//            }
//        }
//
//
//        if (proxy != null) {
//            method.proxy(proxy.get("ip"), Integer.valueOf(proxy.get("port")));
//        }
//
//
//        try {
//            Document document = method.get();
//            return document;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//
//    }
//
//
//    public static String GetJson(String url, String cookie,
//                                 Map<String, String> proxy,
//                                 String referrer, Map<String, String> header, String ua) {
//        if (ua == null || "".equals(ua)) {
//            ua = userAgent;
//
//        }
//        Connection method = Jsoup.connect(url)
//                .cookies(MapUtil.StrToMap(cookie))
//
//                .timeout(1000 * 30)
//                .userAgent(ua) // User-Agent of Chrome 55
//                .referrer(referrer)
//                .ignoreHttpErrors(true)
//                .ignoreContentType(true)
//                .header("Content-Type", "application/json; charset=UTF-8")
////                .header("Accept", "text/html,application/xhtml+xml,application/xml")
//                .header("Accept-Encoding", "gzip, deflate, br")
//                .header("Accept-Language", "zh-CN,zh;q=0.9")
//                .header("Connection", "keep-alive")
//                .header("X-Requested-With", "XMLHttpRequest")
//                .maxBodySize(1024 * 1024 * 8)
//                .timeout(1000 * 10)
//                .method(Connection.Method.GET);
//
//        if (header != null) {
//            for (Map.Entry<String, String> entry : header.entrySet()) {
//                method = method.header(entry.getKey(), entry.getValue());
//            }
//        }
//
//        if (proxy != null) {
//          //  method.proxy(proxy.get("ip"), Integer.valueOf(proxy.get("port")));
//        }
//
//        try {
//            return method.execute().body();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//
//
//    }
//
//
//    /**
//     * post
//     */
//
//    public static String PostForm(String url, String cookie, Map<String, String> proxy, String param, String referrer, Map<String, String> header, String ua) {
//        if (referrer == null || "".equals(referrer)) {
//            referrer = "https://mobile.yangkeduo.com/order.html";
//        }
//        if (ua == null || "".equals(ua)) {
//            ua = userAgent;
//
//        }
//        Connection method = Jsoup.connect(url)
//                .cookies(MapUtil.StrToMap(cookie))
////                .proxy("113.194.31.161", 9999)
//                .timeout(1000 * 30)
//                .userAgent(ua) // User-Agent of Chrome 55
//                .referrer(referrer)
//                .ignoreHttpErrors(true)
//                .ignoreContentType(true)
//                .header("Accept-Encoding", "gzip,deflate,sdch")
////                  .header("Anti-Content", "0anAfxu5HNcy09TaZmlF9X77C2U9z18dKhEHe8Evszsg6iUOC5dSnYpvWbJ-L0lfIOajAoAg4mTGrBsloRBdj0wPhzPUgD3b5W3bKha994OodAD95wkzwRrq9WQ9aijhqIJbc2NrtEHqLpwVd8yEtFPEHdKPbPq__Gtf2mUgMNBPMez6rfWy3hW7TL866aarXn2mVr-1XahMnFfRhHXBuNXRCUv-UjGxO1cWatBpuX67pYhGyO7TugjEDHHNptSDBXA7W7NFex7j-ky4eye0Yuj8AF0qKpkLcA6vngSShHUpKwCFgvfoSCZ96Aw17xJumi6lbRVPkIy9YkF_2pVP1PfKe6ERRHRedKtjgfv55x9a3Caz2g1_38JOswks0-QXVsnwkBY56fsZVacSY7VIeyHXZuDksCCrl95HMKbj-b1ELfT29_QacLFuO75yx--f496j9yZWS46-lRZKyyMNs5MaLdn2dH4scQwrkhYNBTQ-81-rdOuqnKuRtakOSYlgazTC4Uc9ZMazpDnFh7yscxVupikuld6TbIsKGOE-l3bMtWM1iLuD6K4-hppZY8ivHLXbUPQqMyKRNMNBiEeK4X")
//
//                .header("Accept-Language", "zh-CN,zh;q=0.9")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("Accept", "application/json, text/plain, */*")
//                .header("Connection", "keep-alive")
//                .header("X-Requested-With", "XMLHttpRequest")
//
//                .requestBody(param)
//                .maxBodySize(100000)
//                .timeout(1000 * 10)
//                .method(Connection.Method.POST);
//
//
//        if (header != null) {
//            for (Map.Entry<String, String> entry : header.entrySet()) {
//                method = method.header(entry.getKey(), entry.getValue());
//            }
//        }
//
//
//        if (proxy != null) {
//            method = method.proxy(proxy.get("ip"), Integer.valueOf(proxy.get("port")));
//            System.out.println("proxy==" + proxy);
//            //     method = method.proxy("113.194.31.161", 9999);
//        }
//
//        Connection.Response execute = null;
//        try {
//          execute=  method.execute();
//            System.out.println(execute);
//            if (execute.statusCode() == 200) {
//
//
//                String body = execute.body();
//                System.out.println(body);
//                return body;
//            } else {
//
//                System.out.println(execute.statusMessage());
//                System.out.println(execute.statusCode());
//
//                return "";
//
//            }
//        } catch (IOException e) {
//
//
//            System.out.println(e.getMessage());
//            System.out.println(e.getLocalizedMessage());
//
//
//            e.printStackTrace();
//        }
//
//
//        return null;
//
//    }
//
//    /**
//     * .referrer("https://mms.pinduoduo.com/order.html")
//     *
//     * @param url
//     * @param cookie
//     * @param proxy
//     * @param param
//     * @param referrer
//     * @param header
//     * @return .header(" Host ", " mms.pinduoduo.com ")
//     */
//
//    public static String PostJson(String url,
//                                  String cookie,
//                                  Map<String, String> proxy,
//                                  Map<String, String> param,
//                                  String referrer,
//                                  Map<String, String> header,
//                                  String ua) {
//        if (ua == null || "".equals(ua)) {
//            ua = userAgent;
//
//        }
//
//
//        Connection method = Jsoup.connect(url)
//                .cookies(MapUtil.StrToMap(cookie))
////                .proxy("113.194.31.161", 9999)
//                .timeout(1000 * 30)
//                .userAgent(ua) // User-Agent of Chrome 55
//                .referrer(referrer)
//
//                .ignoreHttpErrors(true)
//                .ignoreContentType(true)
//                .header("Content-Type", "application/json; charset=UTF-8")
//                .header("Accept", "application/json, text/javascript, */*; q=0.01")
//                .header("Accept-Encoding", "gzip,deflate,sdch")
//                .header("Accept-Language", "zh-CN,zh;q=0.9")
//                .header("Connection", "keep-alive")
//                .header("X-Requested-With", "XMLHttpRequest")
//
//                .requestBody( new Gson().toJson(param))
//                .maxBodySize(100000)
//                .timeout(1000 * 10)
//
//                .method(Connection.Method.POST);
//
//
//        if (header != null) {
//            for (Map.Entry<String, String> entry : header.entrySet()) {
//                method = method.header(entry.getKey(), entry.getValue());
//            }
//        }
//
//
//        if (proxy != null) {
//            if (!StringUtils.isEmpty(proxy.get("ip"))
//                    &&StringUtils.isEmpty(proxy.get("port")))
//            method = method.proxy(proxy.get("ip"), Integer.valueOf(proxy.get("port")));
//            System.out.println("proxy==" + proxy);
//            //     method = method.proxy("113.194.31.161", 9999);
//            //"authCode\u003d317296\u0026phone\u003d13355782661\u0026source\u003dAndroid-xiaomi"
//        }
//
//        Connection.Response execute = null;
//        try {
//            execute = method.execute();
//            String body = execute.body();
//            System.out.println(body);
//            return body;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//}
