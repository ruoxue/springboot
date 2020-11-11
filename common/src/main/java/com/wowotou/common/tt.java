package com.wowotou.common;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class tt {

   // private static final String userName = "18057157990";
    // static String ua="Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Mobile Safari/537.36";


    public static void main(String[] args) throws Exception {
//
//        Map<String,String> headers=new HashMap<>();
//        String ip="8.129.221.61";
//        headers.put("HTTP_VIA", ip);
//        headers.put("HTTP_X_FORWARDED_FOR", ip);
//        headers.put("x-forwarded-for", ip);
//        headers.put("Proxy-Client-IP", ip);
//        String body = Jsoup.connect("http://webapi.http.zhimacangku.com/getip?num=5&type=2&pro=0&city=0&yys=0&port=1&time=1&ts=1&ys=0&cs=0&lb=1&sb=0&pb=45&mr=1&regions=&username=chukou01")
//                .headers(headers)
//                .method(Connection.Method.GET)
//                .execute().body();
//        System.out.println(body);
//
//        JsonObject o = new JsonUtil<JsonObject>().fromJson(body, JsonObject.class);
//        JsonObject data = o.getAsJsonArray("data").get(0).getAsJsonObject();
//        String ip1 = data.get("ip").getAsString();
//        int port = data.get("port").getAsInt();



//        loadFlag("001");

        Connection.Response execute = Jsoup.connect("https://login.10086.cn/genqr.htm")
                .validateTLSCertificates(false)
                .method(Connection.Method.GET)
//                .proxy(ip1,port)
                .userAgent(UA.WEB_UA).execute();


        Connection.Response execute1 = Jsoup.connect("https://login.10086.cn/loadSendflag.htm?timestamp="+System.currentTimeMillis())
                .method(Connection.Method.GET)
                .validateTLSCertificates(false)
               // .proxy(ip1,port)

                .userAgent(UA.WEB_UA).execute();

        Map<String, String> cookies = execute.cookies();
        cookies.putAll(execute1.cookies());

        String userName="15157157902";
        loadFlag(userName);
//        System.out.println(cookies);

        //https://login.10086.cn/loadSendflag.htm?timestamp=


//        Map<String, String> cookies=new HashMap<>();
        checkNeedSms(userName,cookies,"ip1",0);
//        String xa = loadToken("001");
//        fistSendSms("001", xa);


//        login("001", "420584");
    }


    private static void loadFlag(String uid) throws Exception {
        String url = "https://login.10086.cn/loadSendflag.htm?timestamp=";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Host", "login.10086.cn");
        headers.put("Referer", "https://login.10086.cn/login.html?channelID=12002");
        headers.put("Sec-Fetch-Mode", "no-cors");
        headers.put("Sec-Fetch-Site", "same-origin");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
//        String ip="8.129.221.61";
//        headers.put("HTTP_VIA", ip);
//        headers.put("HTTP_X_FORWARDED_FOR", ip);
//        headers.put("x-forwarded-for", ip);
//        headers.put("Proxy-Client-IP", ip);

        HttpCustomResponse response = HttpClientPoolingCrawler.custom().context(HttpContextUtil.getContext(uid)).url(url).headers(headers).get();

        HttpContext context = HttpContextUtil.getContext(uid);

      //  log.info("loadFlag response:{}", response.getResponseBody());

    }


    private static void checkNeedSms(String userName,Map<String,String> cookie,String ip,int port) throws Exception {

        String url="https://login.10086.cn/chkNumberAction.action";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Host", "login.10086.cn");
        headers.put("Referer", "https://login.10086.cn/");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-origin");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
//        headers.put("HTTP_VIA", ip);
//        headers.put("HTTP_X_FORWARDED_FOR", ip);
//        headers.put("x-forwarded-for", ip);
//        headers.put("Proxy-Client-IP", ip);
        Connection.Response execute = Jsoup.connect(url)
                .userAgent(UA.WEB_UA)
                .cookies(cookie)
                .referrer("https://login.10086.cn/html/login/login.html?channelID=12002&backUrl=https%3A%2F%2Fshop.10086.cn%2Fmall_571_571.html%3Fforcelogin%3D1")
                .requestBody("userName=" + userName + "&loginMode=01&channelID=12002")
                .ignoreContentType(true)
                .ignoreContentType(true)
                .validateTLSCertificates(false)
               // .proxy(ip,port)

                .method(Connection.Method.POST)
                .execute();
        System.out.println(execute.body());
        if (execute.body().equalsIgnoreCase("true")){
            loadToken(userName,cookie,ip,port);
        }


        // log.info("checkNeedSms response:{}", response.getResponseBody());
    }


    private static void loadToken(String userName,Map<String,String> cookie,String ip,int port) throws Exception {
        String url = "https://login.10086.cn/loadToken.action";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Host", "login.10086.cn");
        headers.put("Referer", "https://login.10086.cn/login.html?channelID=12002");
        headers.put("Sec-Fetch-Mode", "no-cors");
        headers.put("Sec-Fetch-Site", "same-origin");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://login.10086.cn/html/login/login.html?channelID=12002&backUrl=https%3A%2F%2Fshop.10086.cn%2Fmall_571_571.html%3Fforcelogin%3D1");
//
//        headers.put("HTTP_VIA", ip);
//        headers.put("HTTP_X_FORWARDED_FOR", ip);
//        headers.put("x-forwarded-for", ip);
//        headers.put("Proxy-Client-IP", ip);

        Connection.Response execute = Jsoup.connect(url).userAgent(UA.WEB_UA)
                .requestBody("userName=" + userName )
                .cookies(cookie)
                .ignoreContentType(true)
                .ignoreContentType(true)
                .validateTLSCertificates(false)
              //  .proxy(ip,port)


                .referrer("https://login.10086.cn/")
               .method(Connection.Method.POST)
                .execute();


        Map<String,String> loadTokenResponse = new JsonUtil<Map>().fromJson(execute.body(), Map.class);
        System.out.println(loadTokenResponse);
        if ("0000".equalsIgnoreCase(loadTokenResponse.get("code"))){
            fistSendSms(userName,loadTokenResponse.get("result"),  cookie,ip,port);
        }

    }


    private static void fistSendSms(String userName, String xa,Map<String,String> cookie,String ip,int port) throws Exception {
        String url = "https://login.10086.cn/sendRandomCodeAction.action";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Host", "login.10086.cn");
        headers.put("Referer", "https://login.10086.cn/login.html?channelID=12002");
        headers.put("Sec-Fetch-Dest", "empty");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-origin");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://login.10086.cn");
        headers.put("Xa-before", xa);
//
//        headers.put("HTTP_VIA", ip);
//        headers.put("HTTP_X_FORWARDED_FOR", ip);
//        headers.put("x-forwarded-for", ip);
//        headers.put("Proxy-Client-IP", ip);

        Connection.Response response = Jsoup.connect(url).userAgent(UA.WEB_UA)
                .requestBody("userName=" + userName )
                .ignoreContentType(true)
                .cookies(cookie)
                .ignoreContentType(true)
           //     .proxy(ip,port)
                .validateTLSCertificates(false)

                .requestBody("userName="+userName+"&type=01&channelID=12002")
                .cookies(cookie)
                .referrer("https://login.10086.cn/html/login/login.html?channelID=12002&backUrl=https%3A%2F%2Fshop.10086.cn%2Fmall_571_571.html%3Fforcelogin%3D1")
                .method(Connection.Method.POST)
                .execute();

         System.out.println(response.body());
        System.out.println(xa);
     //   log.info("sendSms response:{}", response.getResponseBody());

    }


    private static void login(String uid, String pwd) throws Exception {
        String url = "https://login.10086.cn/login.htm";//inputCode

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Host", "login.10086.cn");
//        headers.put("X-Requested-With","XMLHttpRequest");
        // headers.put("Referer", "https://login.10086.cn/login.html?channelID=12002");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-origin");
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://login.10086.cn");
        headers.put("HOST", "login.10086.cn");
        headers.put("Referer", "https://login.10086.cn/login.html?channelID=12002&backUrl=https://shop.10086.cn/i/?f=home&welcome=1546843416406");
        //  String ip="220.249.149.101";
        //headers.put("X-Real-IP",ip);

//accountType=01&pwdType=02&account=13355782669&password=LatH0xTV4tVfaa2FOM25RE7KxPz%2BG7HMG7RCW6GEYYmEgVf4ZgtW7sLH57m4j2j4xDgEnT3IxlhbaqGJVwV%2Bq6Le%2F%2Fy9Gfj7ACLWztv0eQa8%2BjSDEuJXtqLyHs4Y6dDg3jWe2SfXt2W5ZJ1Tk%2F5sTtime0Ix3oLK3T4LNU4q4BpDEmj6Uz3UcAqQZLHbIQAFKqYIXgYpZs7%2BPzCwrrGQOP%2FDpfR3UgShy1Yl5MFwnQUWO%2FCSxgfl1kSsU%2Fauf2v8i%2FGQanBJC1gAtfTVd1A9Tf5Y7gEtNpJQaraoxzn6AfXouMq82KkNP%2FUjQaJvu7H93homOlKAoFHztAxzWnM94Q%3D%3D&inputCode=&backUrl=http%3A%2F%2Ftouch.10086.cn%2Fi&rememberMe=1&channelID=12014&loginMode=03&protocol=https%3A&timestamp=1592804513398
        // headers.put("Cookie", "collect_id=6k2qemxhxwlyyfah029jaorcf0k93s2i; lgToken=bd3f56ef39c0447185f97e372423e660; cmccssotoken=481fdcbb02024d98a33606da74808f31@.10086.cn; CmLocation=571|571; key4IE89=89E1CC6406EDC178C994A8A648D72740540C254C436495DD305D3163A82D33505B150953F1F26F5B1B95FED14C0A14D9; CmProvid=zj; WT_FPC=id=2de1b19d05bb837f6d41592559623382:lv=1592792692217:ss=1592791754031; sendflag=20200622121006651952; c=null");



        String pubkey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsgDq4OqxuEisnk2F0EJFmw4xKa5IrcqEYHvqxPs2CHEg2kolhfWA2SjNuGAHxyDDE5MLtOvzuXjBx/5YJtc9zj2xR/0moesS+Vi/xtG1tkVaTCba+TV+Y5C61iyr3FGqr+KOD4/XECu0Xky1W9ZmmaFADmZi7+6gO9wjgVpU9aLcBcw/loHOeJrCqjp7pA98hRJRY+MML8MK15mnC4ebooOva+mJlstW6t/1lghR8WNV8cocxgcHHuXBxgns2MlACQbSdJ8c6Z3RQeRZBzyjfey6JCCfbEKouVrWIUuPphBL3OANfgp0B+QG31bapvePTfXU48TYK0M5kE+8LgbbWQIDAQAB";
        String encrypt = RsaUtil.encrypt(pwd, pubkey);
//        datas.put("password", encrypt);
//        datas.put("account", userName);
//        datas.put("channelID", "12002");
//        datas.put("backUrl", "http://touch.10086.cn/i");
//        datas.put("rememberMe", "1");
//        datas.put("protocol", "https:");
//        datas.put("timestamp", String.valueOf(System.currentTimeMillis()));

        String p = "accountType=01&account=" + "15157157902" + "&password=" + URLEncoder.encode(encrypt) + "&pwdType=02&smsPwd=&inputCode=&backUrl=https%3A%2F%2Fshop.10086.cn%2Fi%2F&rememberMe=1&channelID=12002&loginMode=01&protocol=https%3A&timestamp=" + System.currentTimeMillis();
        System.out.println(p);

        Connection.Response execute = Jsoup.connect(url).headers(headers).timeout(10000).ignoreContentType(true)
                .ignoreHttpErrors(true).validateTLSCertificates(false)
                .userAgent("Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Mobile Safari/537.36")
                .requestBody(p)
                .referrer("https://login.10086.cn/login.html?channelID=12002").method(Connection.Method.POST)
                .execute();
        System.out.println(execute.body());
        System.out.println(execute.cookies());


//
//        HttpCustomResponse response = HttpClientPoolingCrawler.custom()
//                .context(HttpContextUtil.getContext(uid))
//                .url(url).headers(headers).data(datas).post();
//        System.out.println(response.getResponseBody());
        // log.info("sendSms response:{}", response.getResponseBody());

    }

    private static class LoadTokenResponse {
        private String result;
        private String code;
        private String desc;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
