package com.wowotou.common;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.util.StringUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.util.Map;

public class JsoupUtil {


    public static Connection.Response
    getHtmlFollowRedirects(String url, Map<String, String> map, String cookie, String proxy, int port) {
        Connection.Response execute = null;
        try {
            execute = Jsoup.connect(url)
                    //                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .cookies(MapUtil.StrToMap(cookie))
                    .followRedirects(true) //s_fid=6489456DAC272097-35C554466561E329; lvid=3259838be834c715f32f8397f81f581f;
                    .validateTLSCertificates(false)
                    .ignoreContentType(true)
                    .referrer("http://wapzt.189.cn/wap/index.html")
                    //                .userAgent("Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Mobile Safari/537.36")
                    .headers(map)
                    .timeout(60000)
                    .proxy(proxy, port)
                    .ignoreHttpErrors(true)
//                    .userAgent(UnicomConfig.Web_User_Agent)
                    .method(Connection.Method.GET).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return execute;
    }


    static HostnameVerifier hv = new HostnameVerifier() {
        public boolean verify(String urlHostName, SSLSession session) {
            System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
            return true;
        }
    };

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }


    public static Connection.Response getHtmlNoFollowRedirects(String url, Map<String, String> map, String proxy, int port) throws IOException {
        try {
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection.Response execute = Jsoup.connect(url)
//                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")

                .followRedirects(false) //s_fid=6489456DAC272097-35C554466561E329; lvid=3259838be834c715f32f8397f81f581f;
//                .validateTLSCertificates(false)
                .ignoreContentType(true)


                .referrer("http://wapzt.189.cn/wap/index.html")
//                .userAgent("Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Mobile Safari/537.36")
                .headers(map)
                .timeout(60000)
                .ignoreHttpErrors(true)
//                .userAgent(UnicomConfig.JD_User_Agent)
                .method(Connection.Method.GET).execute();
//        if (proxy != null && !"".equals(proxy)) {
//            method.proxy(proxy, port);
//        }


        return execute;
    }


    public static Connection.Response getHtmlNoFollowRedirects(String url, Map<String, String> map, String refer, String proxy, int port) throws IOException {
        Connection.Response execute = Jsoup.connect(url)
//                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")

                .followRedirects(false) //s_fid=6489456DAC272097-35C554466561E329; lvid=3259838be834c715f32f8397f81f581f;
//                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .referrer(refer)
//                .userAgent("Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Mobile Safari/537.36")
                .headers(map)
                .timeout(60000)
                .ignoreHttpErrors(true)
//                .userAgent(UnicomConfig.JD_User_Agent)
                .method(Connection.Method.GET).execute();
        return execute;
    }


    public static Connection.Response postHtml(String url,
                                               Map<String, String> header,
                                               String param,
                                               String proxy, int port) throws IOException {
        Connection method = Jsoup.connect(url)
                .headers(header)
                .validateTLSCertificates(false)
//                .cookies(MapUtil.StrToMap(" guide=true; upay_user=7934c1238c41e536dca093827e798317; _n3fa_cid=42ae1d26bf1940ffb23dce1949c94f62; _n3fa_ext=ft=1588051977; clientid=98|0; piw=%7B%22login_name%22%3A%22156****1691%22%2C%22nickName%22%3A%22%E6%9D%8E%E4%B8%8A%E5%87%A1%22%2C%22rme%22%3A%7B%22ac%22%3A%22%22%2C%22at%22%3A%22%22%2C%22pt%22%3A%2201%22%2C%22u%22%3A%2215657171691%22%7D%2C%22verifyState%22%3A%22%22%7D; _n3fa_lvt_a9e72dfe4a54a20c3d6e671b3bad01d9=1594278849,1594474661,1594476532,1594893637; _n3fa_lpvt_a9e72dfe4a54a20c3d6e671b3bad01d9=1594893652; WT_FPC=id=200f4df80f1be36e62e1591091042049:lv=1594910621774:ss=1594910621765; HISPAGE=default"))

                .ignoreHttpErrors(true)
                .ignoreContentType(true)
//                .userAgent(UnicomConfig.JD_User_Agent)
//                .proxy(proxy,port)

                .timeout(60000)
                .requestBody(param)
                .method(Connection.Method.POST);
        if (proxy != null && !"".equals(proxy) && port != 0) {
            method.proxy(proxy, port);
        }
        if (proxy != null && !"".equals(proxy) && port == 0) {
            method.header("HTTP_VIA", proxy);
            method.header("HTTP_X_FORWARDED_FOR", proxy);
            method.header("x-forwarded-for", proxy);
            method.header("Proxy-Client-IP", proxy);
            method.header("CLIENT-IP", proxy);
            method.header("X-Real-IP", proxy);

        }

        return method.execute();
    }


    public static Connection.Response
    getHtmlNoFollowRedirectsCookie(
            String url,
            Map<String, String> header,
            String cookie,
            String proxy,
            int port) throws IOException {
        try {
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection method = Jsoup.connect(url)

                .followRedirects(true)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .referrer(header.get("refer"))
                .headers(header)
                .timeout(60000)
                .cookies(MapUtil.StrToMap(cookie))
                .ignoreHttpErrors(true)
                .userAgent(header.get("User-Agent"))
                .method(Connection.Method.GET);
        if (proxy != null && !"".equals(proxy) && port != 0) {
            method.proxy(proxy, port);
        }
        if (proxy != null && !"".equals(proxy) && port == 0) {
            method.header("HTTP_VIA", proxy);
            method.header("HTTP_X_FORWARDED_FOR", proxy);
            method.header("x-forwarded-for", proxy);
            method.header("Proxy-Client-IP", proxy);
            method.header("CLIENT-IP", proxy);
            method.header("X-Real-IP", proxy);

        }

        return method.execute();
    }


    public static Connection.Response postHtmlCookie(String url,
                                                     Map<String, String> header,
                                                     String param, String cookie
            , String proxy, int port) throws IOException {


        Connection method = Jsoup.connect(url)
                .headers(header)
                .validateTLSCertificates(false)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .followRedirects(false)
                .referrer(header.get("refer"))
//                .userAgent(UnicomConfig.JD_User_Agent)
                .cookies(MapUtil.StrToMap(cookie))
                .timeout(60000)

                .requestBody(param)
                .method(Connection.Method.POST);
        if (!StringUtils.isEmpty(proxy)&& port != 0) {
            method.proxy(proxy, port);
        }
        if (proxy != null && !"".equals(proxy) && port == 0) {
            method.header("HTTP_VIA", proxy);
            method.header("HTTP_X_FORWARDED_FOR", proxy);
            method.header("x-forwarded-for", proxy);
            method.header("Proxy-Client-IP", proxy);
            method.header("CLIENT-IP", proxy);
            method.header("X-Real-IP", proxy);

        }
        return method.execute();
    }



    public static Connection.Response postHtmlCookie(String url,
                                                     Map<String, String> header,
                                                     String param,  Map<String, String> cookie
            , String proxy, int port) throws IOException {


        Connection method = Jsoup.connect(url)
                .headers(header)
                .validateTLSCertificates(false)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .followRedirects(false)
                .referrer(header.get("refer"))
//                .userAgent(UnicomConfig.JD_User_Agent)
                .cookies( (cookie))
                .timeout(60000)

                .requestBody(param)
                .method(Connection.Method.POST);
        if (!StringUtils.isEmpty(proxy)&& port != 0) {
            method.proxy(proxy, port);
        }
        if (proxy != null && !"".equals(proxy) && port == 0) {
            method.header("HTTP_VIA", proxy);
            method.header("HTTP_X_FORWARDED_FOR", proxy);
            method.header("x-forwarded-for", proxy);
            method.header("Proxy-Client-IP", proxy);
            method.header("CLIENT-IP", proxy);
            method.header("X-Real-IP", proxy);

        }
        return method.execute();
    }


    public static Connection.Response postHtmlCookie(String url,
                                                     Map<String, String> header,
                                                     Map<String, String> param, String cookie
            , String proxy, int port) throws IOException {


        Connection method = Jsoup.connect(url)
                .headers(header)
                .validateTLSCertificates(false)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .followRedirects(false)
                .referrer(header.get("refer"))
//                .userAgent(UnicomConfig.JD_User_Agent)
                .cookies(MapUtil.StrToMap(cookie))
                .timeout(60000)

                .data(param)
                .method(Connection.Method.POST);
        if (!StringUtils.isEmpty(proxy)&& port != 0) {
            method.proxy(proxy, port);
        }
        if (proxy != null && !"".equals(proxy) && port == 0) {
            method.header("HTTP_VIA", proxy);
            method.header("HTTP_X_FORWARDED_FOR", proxy);
            method.header("x-forwarded-for", proxy);
            method.header("Proxy-Client-IP", proxy);
            method.header("CLIENT-IP", proxy);
            method.header("X-Real-IP", proxy);

        }
        return method.execute();
    }


    public static Connection.Response postHtmlCookie(String url,
                                                     Map<String, String> header,
                                                     Map<String, String> param,  Map<String, String> cookie
            , String proxy, int port) throws IOException {


        Connection method = Jsoup.connect(url)
                .headers(header)
                .validateTLSCertificates(false)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .followRedirects(false)
                .referrer(header.get("refer"))
//                .userAgent(UnicomConfig.JD_User_Agent)
                .cookies((cookie))
                .timeout(60000)

                .data(param)
                .method(Connection.Method.POST);
        if (!StringUtils.isEmpty(proxy)&& port != 0) {
            method.proxy(proxy, port);
        }
        if (proxy != null && !"".equals(proxy) && port == 0) {
            method.header("HTTP_VIA", proxy);
            method.header("HTTP_X_FORWARDED_FOR", proxy);
            method.header("x-forwarded-for", proxy);
            method.header("Proxy-Client-IP", proxy);
            method.header("CLIENT-IP", proxy);
            method.header("X-Real-IP", proxy);

        }
        return method.execute();
    }




    public static Connection.Response
    getHtmlFollowRedirectsCookie(
            String url,
            Map<String, String> header,
            String cookie,
            String proxy,
            int port) throws IOException {
        try {
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection method = Jsoup.connect(url)

                .followRedirects(true)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .referrer(header.get("refer"))
                .headers(header)

                .timeout(60000)
                .cookies(MapUtil.StrToMap(cookie))
                .ignoreHttpErrors(true)
                .userAgent(header.get("User-Agent"))
                .method(Connection.Method.GET);
        if (proxy != null && !"".equals(proxy)&& port != 0) {
            method.proxy(proxy, port);
        }
        if (proxy != null && !"".equals(proxy) && port == 0) {
            method.header("HTTP_VIA", proxy);
            method.header("HTTP_X_FORWARDED_FOR", proxy);
            method.header("x-forwarded-for", proxy);
            method.header("Proxy-Client-IP", proxy);
            method.header("CLIENT-IP", proxy);
            method.header("X-Real-IP", proxy);

        }

        return method.execute();
    }
}
