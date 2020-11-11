package com.wowotou.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.wowotou.common.JsonUtil;
import com.wowotou.common.MapUtil;
import com.wowotou.common.RsaUtil;
import com.wowotou.payservice.downloader.OnYoutubeDownloadListener;
import com.wowotou.payservice.downloader.YoutubeDownloader;
import com.wowotou.payservice.downloader.YoutubeException;
import com.wowotou.payservice.downloader.model.YoutubeVideo;
import com.wowotou.payservice.downloader.model.quality.AudioQuality;
import com.wowotou.payservice.downloader.model.quality.VideoQuality;
import com.wowotou.payservice.service.OrderService;
import com.wowotou.service.MiChannelTypeService;
import com.wowotou.service.MiPayAccountService;
import com.wowotou.service.MiPayChannelService;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SpringBootTest(classes = com.wowotou.api.ApiApplication.class)
class ApiApplicationTests {
    @Resource
    MiPayChannelService miPayChannelService;

    @Resource
    OrderService orderService;
    @Resource
    MiChannelTypeService miChannelTypeService;
    @Resource
    MongoTemplate mongoTemplate;

    @Resource
    MiPayAccountService miPayAccountService;

    //https://lm.189.cn/wapLogin.do?functionType=wap&confirm=no
//    @Test
//    void t() {
//
//
//        //   miPayAccountService.deleteById("0");
////
////        MiPayAccount miPayAccount=new MiPayAccount();
////        miPayAccount.setMtime(Instant.now().getEpochSecond());
////        miPayAccount.setCtime(Instant.now().getEpochSecond());
////        miPayAccount.setAdminid("");
////        miPayAccount.setStatus(0);
////
////        miPayAccount.setUserid("20022");
////        miPayAccount.setChannelid("5ede435b71a3180dea3c3d15");
////        miPayAccountService.update(miPayAccount);
////
//        miPayChannelService.queryAllByLimit(0, 0).stream().forEach(v -> {
//            v.setTypeId2("5ede6b70feb875486111e38e");
//            miPayChannelService.update(v);
//
//            if (!v.getId().equalsIgnoreCase("5ede435b71a3180dea3c3d15")) {
//                miPayChannelService.deleteById(v.getId());
//
//            }
//        });
//
//
////
////        DeleteResult deleteResult = miPayChannelService.deleteById("5ede4486fda7ad780efd9ed6");
////        System.out.println(deleteResult);
////
////
//
//        orderService.createOrder(UUID.randomUUID().toString(), "1", 20D,
//                (short) 1, Instant.now().toString());
//    }
//
//
//    @Test
//    void contextLoads() {
//
//
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.lookup("mi_channel_type",
//                        "typeId2",
//                        "_id",
//                        "type")
//
////        Aggregation.match(Criteria.where("type.type").is(1))
//        );
//
//        AggregationResults<Map> mi_pay_channel = mongoTemplate.aggregate(aggregation,
//                "mi_pay_channel", Map.class);
//        System.out.println(mi_pay_channel.getMappedResults());
//    }
//

    @Test
    public void  tt99() throws Exception {

        YoutubeVideo video = null;

        String url ="nMlncN6nKSY";// asString.replace("/watch?v=", "").replace("https://youtu.be/", "");
        System.out.println(url);//SWZWLFUQTmc
        //Q9VfiY-p4Xo
        //Omf_pbBeLJ4
        //y2PnsIwBwV8

        try {
            video = new YoutubeDownloader().getVideo(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (video!=null){

            try{
                System.out.println("videoFormats"+video.audioFormats().get(0).toString());
                video.download(video.audioFormats().get(0), new File("/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/test/java/com/wowotou/api")
                );
            }catch (Exception e){

            }
        }

    }
    @Test
    void contextLoads9933() throws Exception, IOException, YoutubeException {
//PLVREj0ErAxKLTH193E-IdBzmndoWYkoqB
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(100);

        Document parse = Jsoup.parse(new URL("https://www.youtube.com/playlist?list=PLKLeFHp2zp5YlQ5j4Zk_MgUXF3K4L73IO")
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


//        elementsByClass.forEach(v -> {
//
//            try {
//
//                YoutubeVideo video = null;
//
//                String url = v.parent().parent().attr("href").replace("/watch?v=", "").replace("https://youtu.be/", "");
//                System.out.println(url);
//
//                video = new YoutubeDownloader().getVideo(url);
//                video.download(video.formats().get(0), new File("/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/test/java/com/wowotou/api"));
//
//                System.out.println(video.details());
//            } catch (YoutubeException | IOException e) {
//                e.printStackTrace();
//            }
//
//        });


    }

    @Test
    void contextLoads99() throws Exception, IOException, YoutubeException {
//PLVREj0ErAxKLTH193E-IdBzmndoWYkoqB
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(100);

        Document parse = Jsoup.parse(new URL("https://www.youtube.com/playlist?list=PLCJYftw7IGGxCusjDnp31pXxbYHzxb69i")
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


//        elementsByClass.forEach(v -> {
//
//            try {
//
//                YoutubeVideo video = null;
//
//                String url = v.parent().parent().attr("href").replace("/watch?v=", "").replace("https://youtu.be/", "");
//                System.out.println(url);
//
//                video = new YoutubeDownloader().getVideo(url);
//                video.download(video.formats().get(0), new File("/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/test/java/com/wowotou/api"));
//
//                System.out.println(video.details());
//            } catch (YoutubeException | IOException e) {
//                e.printStackTrace();
//            }
//
//        });


    }




    @Test
    void contextLoads9() throws IOException {

//        fetch("https://login.10086.cn/chkNumberAction.action", {
//                "headers": {
//            "accept": "application/json, text/javascript, */*; q=0.01",
//                    "accept-language": "zh-CN,zh;q=0.9",
//                    "content-type": "application/x-www-form-urlencoded; charset=UTF-8",
//                    "sec-fetch-dest": "empty",
//                    "sec-fetch-mode": "cors",
//                    "sec-fetch-site": "same-origin",
//                    "x-requested-with": "XMLHttpRequest"
//        },
//        "referrer": "https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html",
//                "referrerPolicy": "no-referrer-when-downgrade",
//                "body": "userName=13355782661&loginMode=03&channelID=12014",
//                "method": "POST",
//                "mode": "cors",
//                "credentials": "include"
//});
//

        String ua = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36";

        Map<String, String> m = new HashMap<>();
        m.put("accept", "application/json, text/javascript, */*; q=0.01");
        m.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        m.put("Sec-Fetch-Site", "same-origin");
        m.put("Sec-Fetch-Dest", "empty");
        m.put("Sec-Fetch-Mode", "cors");

//
//        Sec-Fetch-Dest: empty
//        Sec-Fetch-Mode: cors
//        Sec-Fetch-Site: same-origin
        m.put("Origin", "https://login.10086.cn");
        m.put("Host", "login.10086.cn");


        m.put("x-requested-with", "XMLHttpRequest");
        String phone = "15890976090";
//        Document document = Jsoup.connect("https://login.10086.cn/sendflag.htm?timestamp="
//                + System.currentTimeMillis()).get();


        Document post = Jsoup.connect("https://login.10086.cn/chkNumberAction.action")
                .headers(m)
                .userAgent(ua)
                .ignoreHttpErrors(true)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .referrer("https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html")
                .requestBody("userName=" + phone + "&loginMode=03&channelID=12014")
                .post();
        System.out.println(post.text());
        if (!post.text().contains("true")) {
            System.out.println("err");
        }


        Document post2 = Jsoup.connect("https://login.10086.cn/loadToken.action")
                .headers(m)
                .userAgent(ua)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .validateTLSCertificates(false)
                .referrer("https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html")
                .requestBody("userName=" + phone)
                .post();
        System.out.println(post2.text());
        String result = new Gson().fromJson(post2.text().trim(), Map.class).get("result").toString();
        System.out.println(result);
        m.put("Xa-before", result);
//        m.put("DNT", "1");
//        m.put("X-Requested-With", "XMLHttpRequest");
//        m.put("Referrer Policy", "no-referrer-when-downgrade");
//        m.put("Accept-Language", "zh-CN,zh;q=0.9");
//        m.put("Accept-Encoding", "gzip, deflate, br");


        Document post3 = Jsoup.connect("https://login.10086.cn/sendRandomCodeAction.action")
                .headers(m)
                .userAgent(ua)
                .ignoreHttpErrors(true)
                .timeout(100000)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                //  .cookies(MapUtil.Str2Map("collect_id=6k2qemxhxwlyyfah029jaorcf0k93s2i; lgToken=bd3f56ef39c0447185f97e372423e660; cmccssotoken=481fdcbb02024d98a33606da74808f31@.10086.cn; c=481fdcbb02024d98a33606da74808f31; CmLocation=571|571; key4IE89=89E1CC6406EDC178C994A8A648D72740540C254C436495DD305D3163A82D33505B150953F1F26F5B1B95FED14C0A14D9; CmProvid=zj; sendflag=20200622102239837933; WT_FPC=id=2de1b19d05bb837f6d41592559623382:lv=1592792692217:ss=1592791754031"))
                .referrer("https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html")
                .requestBody("userName=" + phone + "&type=01&channelID=12014")
                .post();
        System.out.println(post3.text());


    }

    @Test
    void contextLoads10() throws IOException {

//        fetch("https://login.10086.cn/chkNumberAction.action", {
//                "headers": {
//            "accept": "application/json, text/javascript, */*; q=0.01",
//                    "accept-language": "zh-CN,zh;q=0.9",
//                    "content-type": "application/x-www-form-urlencoded; charset=UTF-8",
//                    "sec-fetch-dest": "empty",
//                    "sec-fetch-mode": "cors",
//                    "sec-fetch-site": "same-origin",
//                    "x-requested-with": "XMLHttpRequest"
//        },
//        "referrer": "https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html",
//                "referrerPolicy": "no-referrer-when-downgrade",
//                "body": "userName=13355782661&loginMode=03&channelID=12014",
//                "method": "POST",
//                "mode": "cors",
//                "credentials": "include"
//});
//

        String ua = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36";

        Map<String, String> m = new HashMap<>();
        m.put("accept", "application/json, text/javascript, */*; q=0.01");
        m.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        m.put("Sec-Fetch-Site", "same-origin");
        m.put("Sec-Fetch-Dest", "empty");
        m.put("Sec-Fetch-Mode", "cors");

//
//        Sec-Fetch-Dest: empty
//        Sec-Fetch-Mode: cors
//        Sec-Fetch-Site: same-origin
        m.put("Origin", "https://login.10086.cn");
        m.put("Host", "login.10086.cn");


        m.put("x-requested-with", "XMLHttpRequest");
        String phone = "15890976090";
//        Document document = Jsoup.connect("https://login.10086.cn/sendflag.htm?timestamp="
//                + System.currentTimeMillis()).get();


        Document post = Jsoup.connect("https://login.10086.cn/chkNumberAction.action")
                .headers(m)
                .userAgent(ua)
                .ignoreHttpErrors(true)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                .referrer("https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html")
                .requestBody("userName=" + phone + "&loginMode=03&channelID=12014")
                .post();
        System.out.println(post.text());
        if (!post.text().contains("true")) {
            System.out.println("err");
        }


        Document post2 = Jsoup.connect("https://login.10086.cn/loadToken.action")
                .headers(m)
                .userAgent(ua)
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .validateTLSCertificates(false)
                .referrer("https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html")
                .requestBody("userName=" + phone)
                .post();
        System.out.println(post2.text());
        String result = new Gson().fromJson(post2.text().trim(), Map.class).get("result").toString();
        System.out.println(result);
        m.put("Xa-before", result);
//        m.put("DNT", "1");
//        m.put("X-Requested-With", "XMLHttpRequest");
//        m.put("Referrer Policy", "no-referrer-when-downgrade");
//        m.put("Accept-Language", "zh-CN,zh;q=0.9");
//        m.put("Accept-Encoding", "gzip, deflate, br");


        Document post3 = Jsoup.connect("https://login.10086.cn/sendRandomCodeAction.action")
                .headers(m)
                .userAgent(ua)
                .ignoreHttpErrors(true)
                .timeout(100000)
                .validateTLSCertificates(false)
                .ignoreContentType(true)
                //  .cookies(MapUtil.Str2Map("collect_id=6k2qemxhxwlyyfah029jaorcf0k93s2i; lgToken=bd3f56ef39c0447185f97e372423e660; cmccssotoken=481fdcbb02024d98a33606da74808f31@.10086.cn; c=481fdcbb02024d98a33606da74808f31; CmLocation=571|571; key4IE89=89E1CC6406EDC178C994A8A648D72740540C254C436495DD305D3163A82D33505B150953F1F26F5B1B95FED14C0A14D9; CmProvid=zj; sendflag=20200622102239837933; WT_FPC=id=2de1b19d05bb837f6d41592559623382:lv=1592792692217:ss=1592791754031"))
                .referrer("https://login.10086.cn/html/login/touch.html?channelID=12014&backUrl=https%3A%2F%2Ftouch.10086.cn%2Fi%2Fmobile%2Frechargecredit.html")
                .requestBody("userName=" + phone + "&type=01&channelID=12014")
                .post();
        System.out.println(post3.text());


    }

    @Test
    public void tt() {


        try {
//            byte[] encrypt = RsaUtil.Dencrypt("Z7+Bl7KvHfCvfJsNWgS8p/Wyqh+CoZ10GyizIIlI/+JUPOSYeByWXMxbaDNjlbWK".getBytes());
//            System.out.println(encrypt);


            String url = "https://shop.10086.cn/i/v1/pay/saveorder/15157157902?provinceId=571";

            Map<String, String> m = new HashMap<>();
            m.put("payPhoneNo", "15157157902");
            m.put("Origin", "https://shop.10086.cn");
            m.put("accept", "application/json, text/javascript, */*; q=0.01");

            m.put("Content-Type", "application/json");

            m.put("Sec-Fetch-Site", "same-origin");
            m.put("Host", "shop.10086.cn");
            m.put("Sec-Fetch-Mode", "cors");
            m.put("Sec-Fetch-Dest", "empty");

            Map<String, String> cc = MapUtil.StrToMap(
                    "inx=myorders; inx2=returnorderqry; ssologinprovince=571; collect_id=6k2qemxhxwlyyfah029jaorcf0k93s2i; mobile=; cart_code_key=cnpaaifis42onpb3m1r69r9a71; PHPSESSID=8r250vfdguolmrnbh73j4bam97; footprint_key=8r250vfdguolmrnbh73j4bam97; jsessionid-echd-cpt-cmcc-jt=nFE13F2FBD107ED3520829C5E2EFB120F-1; lgToken=bd3f56ef39c0447185f97e372423e660; sendflag=20200622003359661471; cmccssotoken=481fdcbb02024d98a33606da74808f31@.10086.cn; is_login=true; c=481fdcbb02024d98a33606da74808f31; CmLocation=571|571; chargeresource=s%3D~e%3D~c%3D~taskId%3D; key4IE89=89E1CC6406EDC178C994A8A648D72740540C254C436495DD305D3163A82D33505B150953F1F26F5B1B95FED14C0A14D9; CmProvid=bj; WT_FPC=id=2de1b19d05bb837f6d41592559623382:lv=1592758198471:ss=" + System.currentTimeMillis());
            Document post = Jsoup.connect(url).headers(m)
                    .referrer("https://shop.10086.cn/i/")
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36")
                    .timeout(30000)
                    .cookies(cc)
                    .validateTLSCertificates(false)
                    .requestBody(
                            "{\"channel\":\"00\",\"amount\":9.98,\"chargeMoney\":10,\"choseMoney\":10,\"operateId\":3216,\"homeProv\":\"571\",\"source\":\"\",\"numFlag\":\"0\"}")
                    .post();
            System.out.println(post);


//            POST https://shop.10086.cn/i/v1/pay/saveorder/15157157902?provinceId=571 HTTP/1.1
//            Host: shop.10086.cn
//            Connection: keep-alive
//            Content-Length: 123
//            Accept: application/json, text/javascript, */*; q=0.01


//https://pay.it.10086.cn/payprod-format/h5/dup_submit

            //https://pay.shop.10086.cn/paygw/mobileAndBankPayH5

//            POST https://pay.shop.10086.cn/paygw/mobileAndBankPayH5 HTTP/1.1
//            Host: pay.shop.10086.cn
//            Connection: keep-alive
//            Content-Length: 138
//            Cache-Control: max-age=0
//            Origin: https://pay.shop.10086.cn
//            Upgrade-Insecure-Requests: 1
//            DNT: 1
//            Content-Type: application/x-www-form-urlencoded
//            User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36
//          Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*
            /*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: https://pay.shop.10086.cn/paygw/485486658178290861-1592760259026-0755d43028c1f6cde47b940b9313c96a-20.html
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cookie: JSESSIONID=9474BDCFBD726DE3CE3FCF5F921A009B; collect_id=6k2qemxhxwlyyfah029jaorcf0k93s2i; mobile=; cart_code_key=cnpaaifis42onpb3m1r69r9a71; footprint_key=8r250vfdguolmrnbh73j4bam97; lgToken=bd3f56ef39c0447185f97e372423e660; sendflag=20200622003359661471; cmccssotoken=481fdcbb02024d98a33606da74808f31@.10086.cn; c=481fdcbb02024d98a33606da74808f31; CmLocation=571|571; key4IE89=89E1CC6406EDC178C994A8A648D72740540C254C436495DD305D3163A82D33505B150953F1F26F5B1B95FED14C0A14D9; CmProvid=bj; WT_FPC=id=2de1b19d05bb837f6d41592559623382:lv=1592760742696:ss=1592757018490

bankAbbr=WXPAY&orderId=485486658178290861&type=C&ipAddress=47.57.0.126&ts=1592760259026&hmac=0755d43028c1f6cde47b940b9313c96a&channelId=20
bankAbbr=ALPAY&orderId=485486658178290861&type=C&ipAddress=47.57.0.126&ts=1592760259026&hmac=0755d43028c1f6cde47b940b9313c96a&channelId=20

//{"data":{"orderId":"485486658178290861","serialNo":"20200622012419343137988192478496","payTime":"2020/06/22 01:24:19","amount":"9.98","chargeMoney":"10","payUrl":"https://pay.shop.10086.cn/paygw/485486658178290861-1592760259026-0755d43028c1f6cde47b940b9313c96a-20.html","payWay":"WWW","accountType":null,"associatedNum":null},"retCode":"000000","retMsg":"保存订单成功","sOperTime":null}


*/

            String pubkey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsgDq4OqxuEisnk2F0EJFmw4xKa5IrcqEYHvqxPs2CHEg2kolhfWA2SjNuGAHxyDDE5MLtOvzuXjBx/5YJtc9zj2xR/0moesS+Vi/xtG1tkVaTCba+TV+Y5C61iyr3FGqr+KOD4/XECu0Xky1W9ZmmaFADmZi7+6gO9wjgVpU9aLcBcw/loHOeJrCqjp7pA98hRJRY+MML8MK15mnC4ebooOva+mJlstW6t/1lghR8WNV8cocxgcHHuXBxgns2MlACQbSdJ8c6Z3RQeRZBzyjfey6JCCfbEKouVrWIUuPphBL3OANfgp0B+QG31bapvePTfXU48TYK0M5kE+8LgbbWQIDAQAB";
            String encrypt = RsaUtil.encrypt("8098", pubkey);
            System.out.println(encrypt);//fBJHwdiLY0MswnjwXENKJCkgBdvIa2EFrJMO0fhfASgNgEmVy8Z


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t1t() throws IOException {
        String cookie = "__jdc=122270672; __jdv=122270672|direct|-|none|-|1593267343535; __jdu=15932673435311264717599; _fbp=fb.1.1593267345397.33124286; areaId=52993; ipLoc-djd=52993-52994-0-0; wxa_level=1; webp=1; mba_muid=15932673435311264717599; visitkey=5328703092905118; shshshfpa=94f7ffaf-97de-e625-9d41-db0cc536e4d5-1593267371; 3AB9D23F7A4B3C9B=QKBWW7BYYSX6QVWTENQ5UGEIJY2JIJLRT64FMSASJJC7GSJKR4I4AFK5JWHCF3CRWZBFJK6VRUNGYTZ267ZJIHKDO4; jcap_dvzw_fp=2a9ae426bfd3f34c38dbbc6bc358944a$785313775375; TrackerID=VKLIok1D9k-WohlMFAetkJGrsIk8aOYYm1oUKNTGm0F2Tc6Q4Z9LFcIEuaeQweyb_gA_MsyoTARHtVvVMtRNX5Z7uAh6Mpq0p396BdoFSTERJbGDInqIZ1wX2tGSgLwQ; pt_key=AAJe91THADBGSJeOTwxQvqFVMLhZOABZqI0Er7rrUI1rlxqUsS8FlEHRox1YgfhwQC20qvIUbPQ; pt_pin=jd_4bdeda7ea4910; pt_token=8xz4ov30; pwdt_id=jd_4bdeda7ea4910; whwswswws=; sc_width=320; shshshfpb=jsrbLIXRDY4kpTK%20QKVLHrA%3D%3D; wxmall_ptype=2; block_call_jdapp=11; addrId_1=794195623; wq_addr=794195623%7C15_1213_3411_52667%7C%u6D59%u6C5F_%u676D%u5DDE%u5E02_%u897F%u6E56%u533A_%u57CE%u533A%7C%u6D59%u6C5F%u676D%u5DDE%u5E02%u897F%u6E56%u533A%u57CE%u533A%u4E30%u6F6D%u8DEF%u4E0E%u6587%u4E00%u897F%u8DEF%u4EA4%u53C9%u53E3%u76CA%u4E50%u65B0%u6751%u5317%u533A6-6%7C120109200%2C30287294; mitemAddrId=15_1213_3411_52667; mitemAddrName=%u6D59%u6C5F%u676D%u5DDE%u5E02%u897F%u6E56%u533A%u57CE%u533A%u4E30%u6F6D%u8DEF%u4E0E%u6587%u4E00%u897F%u8DEF%u4EA4%u53C9%u53E3%u76CA%u4E50%u65B0%u6751%u5317%u533A6-6; __tak=a93f50dca486024187a61108afa765933290606a3de1f6559461c06b579e19bfde8e75f6f3cd5f44b24bfac1467ebeffa4a7186d378c8be5f16909af17bf4df73009e99ad85896b78009a0bd5b0eb619; qd_uid=KBYM7ERJ-DHBUHTE75QIFLEMOT25W; qd_fs=1593321034863; qd_ls=1593321034863; downloadAppPlugIn_pgDownCloseDate=1593339067024_21600000; jxsid=15934359199544214780; sbx_hot_h=null; cd_eid=QKBWW7BYYSX6QVWTENQ5UGEIJY2JIJLRT64FMSASJJC7GSJKR4I4AFK5JWHCF3CRWZBFJK6VRUNGYTZ267ZJIHKDO4; _mkjdcnsl=110; commonAddress=794195623; regionAddress=794195623; mobilev=html5; downloadAppPlugIn_downCloseDate=1593448052388_21600000; qd_ad=mjrpay.jd.com%7C-%7Cjd%7C-%7C0; qd_ts=1593451945711; qd_sq=2; __jda=122270672.15932673435311264717599.1593267344.1593451829.1593495695.13; autoOpenApp_downCloseDate_auto=1593495697109_21600000; mt_xid=V2_52007VwMWWl9bVVwdTBtYB2cDEVVYXlJcG0ERbAZvBkZaXgtTRh5IHloZYlcRVEFQUloaVUlVDWYCE1UOCFEKG3kaXQZmHxNVQVpTSx9LElkGbAIRYl9oUmocSR5aBGUFEVdaaFJZHEs%3D; _modc=098f6bcd4621d373cade4e832627b4f6; wqmnx=1bcd1c43jdm356a3e3a6hpea2b4e4130; retina=1; warehistory=\"200107996940,69819667618,10111208865,35811205841,1143810101,1177082807,200108001214,200130082757,69117048907,64120081697,\"; sk_history=200107996940%2C69819667618%2C10111208865%2C35811205841%2C1143810101%2C1177082807%2C200108001214%2C200130082757%2C69117048907%2C64120081697%2C; wq_logid=1593496016.104183277; __wga=1593496018421.1593495686893.1593451830130.1593267474393.15.14; PPRD_P=UUID.15932673435311264717599-CT.138561.2.1-LOGID.1593496018446.1064159686; string123=D7781D168635ACB4AFD822425DFE13C7a163RA; shshshfp=5e9378801ca86f321fd3f427733d41b3; cid=3; wqmnx1=MDEyNjM4Ny9tNzVsKEE1R2kxZTVLaW9lMU1hNzM3YTVXRFUp; _mkjdcn=2663b80cc43baf2d08896382f3a4cee2; __jdb=122270672.20.15932673435311264717599|13.1593495695; mba_sid=15934956954375501500791905152.20; __jd_ref_cls=JDReact_StartReactModule; shshshsID=59e5f94697bff688203e52d384b64dc7_17_1593497520922";
        String url = "https://api.m.jd.com/client.action?functionId=oilcardSubmitOrder&body=%7B%22userPin%22%3A%22jd_4bdeda7ea4910%22%2C%22source%22%3A8%2C%22callId%22%3A%227f695719-f7f5-fa45-48f6-667062e3ab50%22%2C%22voiceCode%22%3Anull%2C%22promotionDiscount%22%3A210%2C%22dongCouponPay%22%3A0%2C%22balancePay%22%3A0%2C%22phone%22%3A%2213282105927%22%2C%22salePrice%22%3A50000%2C%22promoRfId%22%3A%2274855150131%22%2C%22onlinePay%22%3A49790%2C%22jingdouPay%22%3A0%2C%22skuId%22%3A%22200107996940%22%2C%22payType%22%3A1%2C%22couponIds%22%3A%5B%5D%2C%22cardNum%22%3A%221000113200031149563%22%2C%22brand%22%3A%222%22%2C%22jingCouponPay%22%3A0%2C%22facePrice%22%3A50000%7D&appid=youka_H5&client=youka_H5&clientVersion=1.0.0&jsonp=jsonp_1593497525735_28808";
        Connection.Response execute = Jsoup.connect(url)

                .cookies(MapUtil.StrToMapTrim(cookie))
                .method(Connection.Method.GET)
                .referrer("https://oilcard.m.jd.com/?skuId=200107996940&skuName=%E4%B8%AD%E7%9F%B3%E5%8C%96%E5%8A%A0%E6%B2%B9%E5%8D%A1500%E5%85%83%20%E5%8A%A0%E6%B2%B9%E5%8D%A1%E5%85%85%E5%80%BC%E5%85%A8%E5%9B%BD%E9%80%9A%E7%94%A8%E4%BE%BF%E6%B0%91%E7%BC%B4%E8%B4%B9%20500%E5%85%83&skuPrice=497.90&chargeType=14410&sceneval=2&jxsid=15934359199544214780")
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .execute();
        String body = execute.body();

        System.out.println("=====" + body);
    }

    @Test
    public void ttttt() throws IOException {
        String cookie = "__jdc=122270672; __jdv=122270672|direct|-|none|-|1593267343535; __jdu=15932673435311264717599; _fbp=fb.1.1593267345397.33124286; areaId=52993; ipLoc-djd=52993-52994-0-0; wxa_level=1; webp=1; mba_muid=15932673435311264717599; visitkey=5328703092905118; shshshfpa=94f7ffaf-97de-e625-9d41-db0cc536e4d5-1593267371; 3AB9D23F7A4B3C9B=QKBWW7BYYSX6QVWTENQ5UGEIJY2JIJLRT64FMSASJJC7GSJKR4I4AFK5JWHCF3CRWZBFJK6VRUNGYTZ267ZJIHKDO4; jcap_dvzw_fp=2a9ae426bfd3f34c38dbbc6bc358944a$785313775375; TrackerID=VKLIok1D9k-WohlMFAetkJGrsIk8aOYYm1oUKNTGm0F2Tc6Q4Z9LFcIEuaeQweyb_gA_MsyoTARHtVvVMtRNX5Z7uAh6Mpq0p396BdoFSTERJbGDInqIZ1wX2tGSgLwQ; pt_key=AAJe91THADBGSJeOTwxQvqFVMLhZOABZqI0Er7rrUI1rlxqUsS8FlEHRox1YgfhwQC20qvIUbPQ; pt_pin=jd_4bdeda7ea4910; pt_token=8xz4ov30; pwdt_id=jd_4bdeda7ea4910; whwswswws=; sc_width=320; shshshfpb=jsrbLIXRDY4kpTK%20QKVLHrA%3D%3D; wxmall_ptype=2; block_call_jdapp=11; addrId_1=794195623; wq_addr=794195623%7C15_1213_3411_52667%7C%u6D59%u6C5F_%u676D%u5DDE%u5E02_%u897F%u6E56%u533A_%u57CE%u533A%7C%u6D59%u6C5F%u676D%u5DDE%u5E02%u897F%u6E56%u533A%u57CE%u533A%u4E30%u6F6D%u8DEF%u4E0E%u6587%u4E00%u897F%u8DEF%u4EA4%u53C9%u53E3%u76CA%u4E50%u65B0%u6751%u5317%u533A6-6%7C120109200%2C30287294; mitemAddrId=15_1213_3411_52667; mitemAddrName=%u6D59%u6C5F%u676D%u5DDE%u5E02%u897F%u6E56%u533A%u57CE%u533A%u4E30%u6F6D%u8DEF%u4E0E%u6587%u4E00%u897F%u8DEF%u4EA4%u53C9%u53E3%u76CA%u4E50%u65B0%u6751%u5317%u533A6-6; __tak=a93f50dca486024187a61108afa765933290606a3de1f6559461c06b579e19bfde8e75f6f3cd5f44b24bfac1467ebeffa4a7186d378c8be5f16909af17bf4df73009e99ad85896b78009a0bd5b0eb619; qd_uid=KBYM7ERJ-DHBUHTE75QIFLEMOT25W; qd_fs=1593321034863; qd_ls=1593321034863; downloadAppPlugIn_pgDownCloseDate=1593339067024_21600000; jxsid=15934359199544214780; sbx_hot_h=null; cd_eid=QKBWW7BYYSX6QVWTENQ5UGEIJY2JIJLRT64FMSASJJC7GSJKR4I4AFK5JWHCF3CRWZBFJK6VRUNGYTZ267ZJIHKDO4; _mkjdcnsl=110; commonAddress=794195623; regionAddress=794195623; mobilev=html5; downloadAppPlugIn_downCloseDate=1593448052388_21600000; qd_ad=mjrpay.jd.com%7C-%7Cjd%7C-%7C0; qd_ts=1593451945711; qd_sq=2; __jda=122270672.15932673435311264717599.1593267344.1593451829.1593495695.13; autoOpenApp_downCloseDate_auto=1593495697109_21600000; mt_xid=V2_52007VwMWWl9bVVwdTBtYB2cDEVVYXlJcG0ERbAZvBkZaXgtTRh5IHloZYlcRVEFQUloaVUlVDWYCE1UOCFEKG3kaXQZmHxNVQVpTSx9LElkGbAIRYl9oUmocSR5aBGUFEVdaaFJZHEs%3D; _modc=098f6bcd4621d373cade4e832627b4f6; wqmnx=1bcd1c43jdm356a3e3a6hpea2b4e4130; retina=1; warehistory=\"200107996940,69819667618,10111208865,35811205841,1143810101,1177082807,200108001214,200130082757,69117048907,64120081697,\"; sk_history=200107996940%2C69819667618%2C10111208865%2C35811205841%2C1143810101%2C1177082807%2C200108001214%2C200130082757%2C69117048907%2C64120081697%2C; wq_logid=1593496016.104183277; __wga=1593496018421.1593495686893.1593451830130.1593267474393.15.14; PPRD_P=UUID.15932673435311264717599-CT.138561.2.1-LOGID.1593496018446.1064159686; string123=D7781D168635ACB4AFD822425DFE13C7a163RA; shshshfp=5e9378801ca86f321fd3f427733d41b3; cid=3; wqmnx1=MDEyNjM4Ny9tNzVsKEE1R2kxZTVLaW9lMU1hNzM3YTVXRFUp; _mkjdcn=2663b80cc43baf2d08896382f3a4cee2; __jdb=122270672.20.15932673435311264717599|13.1593495695; mba_sid=15934956954375501500791905152.20; __jd_ref_cls=JDReact_StartReactModule; shshshsID=59e5f94697bff688203e52d384b64dc7_17_1593497520922";
        String payId = "0777f40a6a924eaf97810abddb52f4aa";
        /**
         * functionId: wapWeiXinPay
         * body: {"appId":"jd_m_pay","payId":"0777f40a6a924eaf97810abddb52f4aa"}
         * appId: jd_m_pay
         * payId: 0777f40a6a924eaf97810abddb52f4aa
         * _format_: JSON
         */

        Map<String, String> param = new HashMap<>();

        param.put("functionId", "wapWeiXinPay");
        param.put("appId", "jd_m_pay");
        param.put("_format_", "JSON");
        param.put("payId", payId);

        Map<String, String> body = new HashMap<>();
        body.put("appId", "jd_m_pay");
        body.put("payId", payId);


        param.put("body", URLEncoder.encode(new JsonUtil().toJsonStr(body)));
        //https://pay.m.jd.com/index.action?_format_=JSON&appId=jd_m_pay&body=appId%3Djd_m_pay%26payId%3D0777f40a6a924eaf97810abddb52f4aa&functionId=wapWeiXinPay&payId=0777f40a6a924eaf97810abddb52f4aa

        //https://pay.m.jd.com/index.action?functionId=wapWeiXinPay&body=%7B%22appId%22%3A%22jd_m_pay%22%2C%22payId%22%3A%22d9f550efee4d4c01861f7d31c3de5eca%22%7D&appId=jd_m_pay&payId=d9f550efee4d4c01861f7d31c3de5eca&_format_=JSON
//https://pay.m.jd.com/index.action?_format_%3DJSON%26appId%3Djd_m_pay%26body%3DappId%3Djd_m_pay%26payId%3D0777f40a6a924eaf97810abddb52f4aa%26functionId%3DwapWeiXinPay%26payId%3D0777f40a6a924eaf97810abddb52f4aa
        String url = "https://pay.m.jd.com/index.action?" + (MapUtil.getParamStr(param));
        System.out.println(url);
        Connection.Response execute = Jsoup.connect(url)

                .cookies(MapUtil.StrToMapTrim(cookie))
                .method(Connection.Method.GET)
                .referrer("https://pay.m.jd.com/cpay/newPay-index.html?payId=" + payId + "&appId=jd_m_pay")
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .execute();
        String body1 = execute.body();

        System.out.println("=====" + body1);
    }

    @Test
    public void t1t2() throws IOException {
        String cookie = "__jdc=122270672; __jdv=122270672|direct|-|none|-|1593267343535; __jdu=15932673435311264717599; _fbp=fb.1.1593267345397.33124286; areaId=52993; ipLoc-djd=52993-52994-0-0; wxa_level=1; webp=1; mba_muid=15932673435311264717599; visitkey=5328703092905118; shshshfpa=94f7ffaf-97de-e625-9d41-db0cc536e4d5-1593267371; 3AB9D23F7A4B3C9B=QKBWW7BYYSX6QVWTENQ5UGEIJY2JIJLRT64FMSASJJC7GSJKR4I4AFK5JWHCF3CRWZBFJK6VRUNGYTZ267ZJIHKDO4; jcap_dvzw_fp=2a9ae426bfd3f34c38dbbc6bc358944a$785313775375; TrackerID=VKLIok1D9k-WohlMFAetkJGrsIk8aOYYm1oUKNTGm0F2Tc6Q4Z9LFcIEuaeQweyb_gA_MsyoTARHtVvVMtRNX5Z7uAh6Mpq0p396BdoFSTERJbGDInqIZ1wX2tGSgLwQ; pt_key=AAJe91THADBGSJeOTwxQvqFVMLhZOABZqI0Er7rrUI1rlxqUsS8FlEHRox1YgfhwQC20qvIUbPQ; pt_pin=jd_4bdeda7ea4910; pt_token=8xz4ov30; pwdt_id=jd_4bdeda7ea4910; whwswswws=; sc_width=320; shshshfpb=jsrbLIXRDY4kpTK%20QKVLHrA%3D%3D; wxmall_ptype=2; block_call_jdapp=11; addrId_1=794195623; wq_addr=794195623%7C15_1213_3411_52667%7C%u6D59%u6C5F_%u676D%u5DDE%u5E02_%u897F%u6E56%u533A_%u57CE%u533A%7C%u6D59%u6C5F%u676D%u5DDE%u5E02%u897F%u6E56%u533A%u57CE%u533A%u4E30%u6F6D%u8DEF%u4E0E%u6587%u4E00%u897F%u8DEF%u4EA4%u53C9%u53E3%u76CA%u4E50%u65B0%u6751%u5317%u533A6-6%7C120109200%2C30287294; mitemAddrId=15_1213_3411_52667; mitemAddrName=%u6D59%u6C5F%u676D%u5DDE%u5E02%u897F%u6E56%u533A%u57CE%u533A%u4E30%u6F6D%u8DEF%u4E0E%u6587%u4E00%u897F%u8DEF%u4EA4%u53C9%u53E3%u76CA%u4E50%u65B0%u6751%u5317%u533A6-6; __tak=a93f50dca486024187a61108afa765933290606a3de1f6559461c06b579e19bfde8e75f6f3cd5f44b24bfac1467ebeffa4a7186d378c8be5f16909af17bf4df73009e99ad85896b78009a0bd5b0eb619; qd_uid=KBYM7ERJ-DHBUHTE75QIFLEMOT25W; qd_fs=1593321034863; qd_ls=1593321034863; downloadAppPlugIn_pgDownCloseDate=1593339067024_21600000; jxsid=15934359199544214780; sbx_hot_h=null; cd_eid=QKBWW7BYYSX6QVWTENQ5UGEIJY2JIJLRT64FMSASJJC7GSJKR4I4AFK5JWHCF3CRWZBFJK6VRUNGYTZ267ZJIHKDO4; _mkjdcnsl=110; commonAddress=794195623; regionAddress=794195623; mobilev=html5; downloadAppPlugIn_downCloseDate=1593448052388_21600000; qd_ad=mjrpay.jd.com%7C-%7Cjd%7C-%7C0; qd_ts=1593451945711; qd_sq=2; __jda=122270672.15932673435311264717599.1593267344.1593451829.1593495695.13; autoOpenApp_downCloseDate_auto=1593495697109_21600000; mt_xid=V2_52007VwMWWl9bVVwdTBtYB2cDEVVYXlJcG0ERbAZvBkZaXgtTRh5IHloZYlcRVEFQUloaVUlVDWYCE1UOCFEKG3kaXQZmHxNVQVpTSx9LElkGbAIRYl9oUmocSR5aBGUFEVdaaFJZHEs%3D; _modc=098f6bcd4621d373cade4e832627b4f6; wqmnx=1bcd1c43jdm356a3e3a6hpea2b4e4130; retina=1; warehistory=\"200107996940,69819667618,10111208865,35811205841,1143810101,1177082807,200108001214,200130082757,69117048907,64120081697,\"; sk_history=200107996940%2C69819667618%2C10111208865%2C35811205841%2C1143810101%2C1177082807%2C200108001214%2C200130082757%2C69117048907%2C64120081697%2C; wq_logid=1593496016.104183277; __wga=1593496018421.1593495686893.1593451830130.1593267474393.15.14; PPRD_P=UUID.15932673435311264717599-CT.138561.2.1-LOGID.1593496018446.1064159686; string123=D7781D168635ACB4AFD822425DFE13C7a163RA; shshshfp=5e9378801ca86f321fd3f427733d41b3; cid=3; wqmnx1=MDEyNjM4Ny9tNzVsKEE1R2kxZTVLaW9lMU1hNzM3YTVXRFUp; _mkjdcn=2663b80cc43baf2d08896382f3a4cee2; __jdb=122270672.20.15932673435311264717599|13.1593495695; mba_sid=15934956954375501500791905152.20; __jd_ref_cls=JDReact_StartReactModule; shshshsID=59e5f94697bff688203e52d384b64dc7_17_1593497520922";
        String url = "https://wq.jd.com/bases/orderlist/deallist?order_type=6&start_page=1&page_size=10&last_page=0&callback=dealListCbA&isoldpin=0&callersource=mainorder&traceid=947665370121190734&t=1593522769766&sceneval=2&g_ty=ls&g_tk=538122";
        url = "https://wq.jd.com/bases/orderdetail/detailview?deal_id=125888250221&callersource=mainorder&callback=detailFirCbA&traceid=947669673678392128&t=1593523270859&g_ty=ls&g_tk=5381&isoldpin=0&sceneval=2\n";
        Connection.Response execute = Jsoup.connect(url)

                .cookies(MapUtil.StrToMapTrim(cookie))
                .method(Connection.Method.GET)
                .referrer("https://oilcard.m.jd.com/?skuId=200107996940&skuName=%E4%B8%AD%E7%9F%B3%E5%8C%96%E5%8A%A0%E6%B2%B9%E5%8D%A1500%E5%85%83%20%E5%8A%A0%E6%B2%B9%E5%8D%A1%E5%85%85%E5%80%BC%E5%85%A8%E5%9B%BD%E9%80%9A%E7%94%A8%E4%BE%BF%E6%B0%91%E7%BC%B4%E8%B4%B9%20500%E5%85%83&skuPrice=497.90&chargeType=14410&sceneval=2&jxsid=15934359199544214780")
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .execute();
        String body = execute.body();

        System.out.println("=====" + body);


        //https://wq.jd.com/bases/orderdetail/detailview?deal_id=125888250221&callersource=mainorder&callback=detailFirCbA&traceid=947669673678392128&t=1593523270859&g_ty=ls&g_tk=5381&isoldpin=0&sceneval=2
    }


    @Test
    public void t1t222() throws IOException {

        String cardNum = "1000113200031149563";
        String phone = "13282105927";
        String userPinyin = null;
        String skuId = "200108054100";


        String cookie = "wxa_level=1; retina=1; webp=1; __jdv=122270672%7Cdirect%7C-%7Cnone%7C-%7C1593451272128; mba_muid=1593451272126325109065; visitkey=25533968715227916; shshshfpa=6c16a609-adc1-5426-40c1-7ed823cc0e8e-1593451280; shshshfpb=k%2FMrlEggHDZds79j5X2ewtw%3D%3D; __jdc=76161171; __jdu=1593451272126325109065; areaId=15; ipLoc-djd=15-1213-3411-0; PCSYCityID=CN_330000_330100_330106; 3AB9D23F7A4B3C9B=5GICHS7RQPT5OMGDO73DLL5M5BCYZ7XXUW7HAKLX2QAH552FHADDQ3YA4ILDF3CCCXI7QGAFHPPBLIV53OEGBJZDFE; TrackerID=RuyQIvlE6rUTD5npiSCneZtlHWXFvfnwuUROA8e3lBbhusU6FN3dBHZG4X8ogfdrhEpKNk9cy4GEEf-CHgWBMJPM2O2V8EAM-0SeGKDh8siKJVxMAzmR6E8lCRhHMfcBBotBZ0ZFXTYMBbWOg9poJg; pt_key=AAJe-yVhADA0eMeEd-Ya4T1J_crBCuT0ngmW85xgeRIRnKKSmNOL_taB2Y9DXpJ-l7uts9djnF8; pt_pin=18328583309_p; pt_token=l1mzyv36; pwdt_id=18328583309_p; sc_width=360; jxsid=15935174281138704945; sbx_hot_h=null; sk_history=200130082757%2C; _modc=098f6bcd4621d373cade4e832627b4f6; string123=4EA6B32484DB807E2C84184BE8A5633Aab1212cd; wqmnx=1bcd1c43jdm356a3e3a6hpea2b4e4130; _mkjdcnsl=110; wq_logid=1593518021.1234558106; PPRD_P=UUID.1593451272126325109065-LOGID.1593518023085.1311854522; shshshfp=4acd1a11c932df07657cc97d85aa38b2; cid=9; __jda=76161171.1593451272126325109065.1593451272.1593515945.1593526109.3; _mkjdcn=f58b8a7a671f1a88bfa34b39b8ba09d4; wqmnx1=MDEyNjM3NHNtbXNhaz0lOTUlODAlc3JyMT01NzFsKCBkU1AvKVc1KCBlaDMzb2EzNllmLTRZRCMoSA%3D%3D; __jdb=76161171.4.1593451272126325109065|3.1593526109; mba_sid=15935261091549425700045285082.4; __wga=1593526133791.1593526110075.1593517424647.1593517424647.3.2; shshshsID=ec723450385c85240f20df60a87c56f9_3_1593526134517; __jd_ref_cls=MList_RecommendSearchExpo";
        String url = "https://wq.jd.com/bases/orderlist/deallist?order_type=6&start_page=1&page_size=10&last_page=0&callback=dealListCbA&isoldpin=0&callersource=mainorder&traceid=947665370121190734&t=1593522769766&sceneval=2&g_ty=ls&g_tk=538122";
        url = "https://mapi.m.jd.com/config/display.action";
        Map<String, String> param = new HashMap<>();
        param.put("_format_", "json");
        param.put("skuId", skuId);
        param.put("skuPrice", "98.89");
        param.put("chargeType", "14410");
        param.put("sceneval", "2");
        param.put("jxsid", String.valueOf(System.currentTimeMillis()));

        param.put("skuName", "中石化加油卡充值100元圈存加油 100元");

        String body3 = Jsoup.connect("https://api.m.jd.com/client.action?appid=JDReactToWeb&functionId=getLoginPin&body=%5Bobject%20Object%5D&t=" + System.currentTimeMillis() + "&jsonp=jsonp_" + System.currentTimeMillis() + "_22424")
                .cookies(MapUtil.StrToMapTrim(cookie))
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .method(Connection.Method.GET)
                .execute().body();
        body3 = body3.substring(body3.indexOf("{"), body3.lastIndexOf("}") + 1);
        System.out.println(body3);

        JsonObject bodyBody = new JsonUtil<JsonObject>().fromJson(body3, JsonObject.class);
        userPinyin = bodyBody.get("data").getAsString();


        Connection.Response execute = Jsoup.connect(url)

                .cookies(MapUtil.StrToMapTrim(cookie))
                .method(Connection.Method.POST)
                .referrer("https://oilcard.m.jd.com/?skuId=200134500875&skuName=%E4%B8%AD%E7%9F%B3%E5%8C%96%E5%8A%A0%E6%B2%B9%E5%8D%A1%E5%85%85%E5%80%BC100%E5%85%83%E5%9C%88%E5%AD%98%E5%8A%A0%E6%B2%B9%20100%E5%85%83&skuPrice=98.89&chargeType=14410&sceneval=2&jxsid=15935226813710745816")
                .ignoreContentType(true)
                .data(param)
                .ignoreHttpErrors(true)
                .execute();
        String body = execute.body();

        System.out.println("=====" + body);

        Map<String, String> param2 = new HashMap<>();
        param2.put("functionId", "getOilcardSkuInfo");
        param2.put("appid", "youka_H5");
        param2.put("client", "youka_H5");
        param2.put("clientVersion", "1.0.0");
        param2.put("jsonp", "jsonp_" + System.currentTimeMillis() + "_4726");
        String uid = UUID.randomUUID().toString();
        Map<String, String> body1 = new HashMap<>();
        body1.put("skuId", skuId);
        body1.put("callId", uid);
        body1.put("source", "8");

        param2.put("body", URLEncoder.encode(new JsonUtil().toJsonStr(body1)));
        String execute1 = Jsoup.connect("https://api.m.jd.com/client.action?" + MapUtil.getParamStr(param2))
                .method(Connection.Method.GET)
                .ignoreHttpErrors(true)
                .cookies(MapUtil.StrToMapTrim(cookie))
                .ignoreContentType(true)
                .execute().body();
        System.out.println(execute1);

        String substring = execute1.substring(execute1.indexOf("{"), execute1.lastIndexOf("}") + 1);
        System.out.println(substring);

        JsonObject jsonObject = new JsonUtil<JsonObject>().fromJson(substring, JsonObject.class);
        if (!jsonObject.get("success").getAsBoolean()) {

        }

        JsonObject data = jsonObject.getAsJsonObject("data");


        DecimalFormat df = new DecimalFormat("######0");

        Map<String, String> param3 = new HashMap<>();
        param3.put("functionId", "oilcardSubmitOrder");
        param3.put("appid", "youka_H5");
        param3.put("client", "youka_H5");
        param3.put("clientVersion", "1.0.0");
        param3.put("jsonp", "jsonp_" + System.currentTimeMillis() + "_56549");
        uid = UUID.randomUUID().toString();
        Map<String, String> body2 = new HashMap<>();
        body2.put("userPin", userPinyin);

        body2.put("callId", UUID.randomUUID().toString());
        body2.put("promotionDiscount", data.get("promotionDiscount") == null ? "0" : df.format(data.get("promotionDiscount").getAsDouble() * 100));
        body2.put("source", "8");
        body2.put("dongCouponPay", "0");
        body2.put("balancePay", "0");
        body2.put("couponIds", new ArrayList().toString());


        body2.put("cardNum", cardNum);
        body2.put("jingCouponPay", "0");
        body2.put("facePrice", data.get("facePrice") == null ? "0" : df.format(data.get("facePrice").getAsDouble() * 100));


        body2.put("payType", "1");
        body2.put("salePrice", data.get("skuPrice") == null ? "0" : df.format(data.get("skuPrice").getAsDouble() * 100));
        body2.put("promoRfId", data.get("promoRfId") == null ? "0" : data.get("promoRfId").getAsString());
        body2.put("onlinePay", data.get("promotionPrice") == null ? "0" : df.format(data.get("promotionPrice").getAsDouble() * 100));
        body2.put("jingdouPay", "0");
        body2.put("skuId", data.get("skuId").getAsString());


        body2.put("voiceCode", "null");


        body2.put("phone", phone);


        param3.put("body", URLEncoder.encode(new JsonUtil().toJsonStr(body2)));


        String u = "https://api.m.jd.com/client.action?functionId=oilcardSubmitOrder&" +
                "body=%7B%22userPin%22%3A%22" + body2.get("userPin") + "%22%2C%22source%22%3A8%2C%22callId%22%3A%22" + UUID.randomUUID().toString() + "%22%2C%22voiceCode%22%3Anull" +
                "%2C%22promotionDiscount%22%3A" + body2.get("promotionDiscount") + "%2C%22dongCouponPay%22%3A0%2C%22balancePay%22%3A0%2C%22phone%22%3A%22"
                + body2.get("phone") + "%22%2C%22salePrice%22%3A" + body2.get("salePrice") + "%2C%22promoRfId%22%3A%22"
                + body2.get("promoRfId") + "%22%2C%22onlinePay%22%3A" + body2.get("onlinePay") +
                "%2C%22jingdouPay%22%3A0%2C%22skuId%22%3A%22" + body2.get("skuId") + "%22%2C%22payType%22%3A1%2C%22couponIds%22%3A%5B%5D%2C%22cardNum%22%3A%22" + body2.get("cardNum") +
                "%22%2C%22brand%22%3A%22" + data.get("brand").getAsString()
                + "%22%2C%22jingCouponPay%22%3A0%2C%22facePrice%22%3A" + body2.get("facePrice") + "%7D&appid=youka_H5&client=youka_H5&clientVersion=1.0.0&jsonp=jsonp_" + System.currentTimeMillis() + "_60329";
        //  u="https://api.m.jd.com/client.action?functionId=oilcardSubmitOrder&body=%7B%22userPin%22%3A%22jd_4bdeda7ea4910%22%2C%22source%22%3A8%2C%22callId%22%3A%22"+uid+"%22%2C%22voiceCode%22%3Anull%2C%22promotionDiscount%22%3A111.00000000000001%2C%22dongCouponPay%22%3A0%2C%22balancePay%22%3A0%2C%22phone%22%3A%2213282105927%22%2C%22salePrice%22%3A10000%2C%22promoRfId%22%3A%2274864998905%22%2C%22onlinePay%22%3A9889%2C%22jingdouPay%22%3A0%2C%22skuId%22%3A%22200134500875%22%2C%22payType%22%3A1%2C%22couponIds%22%3A%5B%5D%2C%22cardNum%22%3A%221000113200031149563%22%2C%22brand%22%3A%222%22%2C%22jingCouponPay%22%3A0%2C%22facePrice%22%3A10000%7D&appid=youka_H5&client=youka_H5&clientVersion=1.0.0&jsonp=jsonp_1593528471854_78846";
        // u="https://api.m.jd.com/client.action?functionId=oilcardSubmitOrder&body=%7B%22userPin%22%3A%22jd_4bdeda7ea4910%22%2C%22source%22%3A8%2C%22callId%22%3A%22df12dbb7-b098-e736-f186-6ec1416c8a88%22%2C%22voiceCode%22%3Anull%2C%22promotionDiscount%22%3A211%2C%22dongCouponPay%22%3A0%2C%22balancePay%22%3A0%2C%22phone%22%3A%2213282105927%22%2C%22salePrice%22%3A50000%2C%22promoRfId%22%3A%2274864998110%22%2C%22onlinePay%22%3A49789%2C%22jingdouPay%22%3A0%2C%22skuId%22%3A%22200108054100%22%2C%22payType%22%3A1%2C%22couponIds%22%3A%5B%5D%2C%22cardNum%22%3A%221000113200031149563%22%2C%22brand%22%3A%222%22%2C%22jingCouponPay%22%3A0%2C%22facePrice%22%3A50000%7D&appid=youka_H5&client=youka_H5&clientVersion=1.0.0&jsonp=jsonp_1593535491391_89917";
        System.out.println(u);
        String execute3 = Jsoup.connect(u)
                .method(Connection.Method.GET)
                .ignoreHttpErrors(true)
                .referrer("https://oilcard.m.jd.com/?skuId=" + skuId + "&skuName=%E4%B8%AD%E7%9F%B3%E5%8C%96%E5%8A%A0%E6%B2%B9%E5%8D%A1%E5%85%85%E5%80%BC100%E5%85%83%E5%9C%88%E5%AD%98%E5%8A%A0%E6%B2%B9%20100%E5%85%83&skuPrice=98.89&chargeType=14410&sceneval=2&jxsid=15935226813710745816")

                .cookies(MapUtil.StrToMapTrim(cookie))
                .ignoreContentType(true)
                .execute().body();
        System.out.println(execute3);
    }


    @Test
    public void getHostIP() {
        try {
            // 打开连接
            Document doc = Jsoup.connect("http://chaipip.com/").get();
            Elements eles = doc.select("#ip");
            String ip = eles.attr("value");
            System.out.println(ip);
        } catch (IOException e) {
            e.printStackTrace();

//        System.out.println(ip);
        }


    }


    public static void main(String[] a) throws Exception, MalformedURLException {


        long time = System.currentTimeMillis();
        System.out.println(time);
        System.setProperty("webdriver.chrome.driver", "/Users/ruo/android/Ruoxue/uni/uni516/pay/api/src/main/resources/chromedriver");//下载的chromedriver位置

        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, String> mobileEmulation = new HashMap<String, String>();
//        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("permissions.default.stylesheet=2");

        mobileEmulation.put("deviceName", "Nexus 5");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        chromeOptions.addArguments("Accept-Encoding=gzip, deflate, sdch");
        chromeOptions.addArguments("Accept-Language=zh-CN,zh;q=0.8");
        chromeOptions.addArguments("Connection=keep-alive");
        chromeOptions.addArguments("Host=activityunion-marketing.meituan.com");
        chromeOptions.addArguments("Upgrade-Insecure-Requests=1");
        chromeOptions.addArguments("User-Agent=Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4");


        WebDriver driver = new ChromeDriver(chromeOptions);//实例化ChromeDriver对象


        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();


        String url = "http://wapzt.189.cn/wap/index.html";
        driver.get(url);//打开指定网站


        Thread.sleep(1000);
        // driver.manage().
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/ul/li[2]/div"));
        element.click();

        WebElement teleValidCode = driver.findElement(By.id("teleValidCode"));
        String imgurl = getImgUrl(teleValidCode);
        System.out.println(imgurl);
        String result = getImgCode(imgurl);

        WebElement indexRecNum = driver.findElement(By.id("indexRecNum"));
        indexRecNum.sendKeys("13355782661");

        Thread.sleep(100);

        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"indexRecharMoney\"]/p[3]/input"));
        element4.click();
        element4.sendKeys("90");
        Thread.sleep(100);

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"indexVerification\"]/input"));
        element1.sendKeys(result);

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"indexMenuCont\"]/div[2]/div[1]/p[2]"));
        element2.click();
        System.out.println(driver.getPageSource().indexOf("验证码输入错误") != -1);


        if (driver.getPageSource().indexOf("验证码输入错误") != -1) {
            int times = 0;
            while (times < 6) {
                System.out.println("times" + times);
                times++;
//            System.out.println(driver.getPageSource());
                if (driver.getPageSource().indexOf("验证码输入错误") != -1) {
                    imgurl = getImgUrl(driver.findElement(By.id("teleValidCode")));
                    result = getImgCode(imgurl);
                    element1 = driver.findElement(By.xpath("//*[@id=\"indexVerification\"]/input"));

                    if (element1 != null) {
                        element1.clear();
                        element1.sendKeys(result);
                    }

                    element2.click();

                } else {
                    break;
                }
            }
        }

        if (driver.getPageSource().indexOf("验证码输入错误") != -1) {
            System.out.println("下单失败");

            driver.close();
            driver.quit();

        } else {

            Thread.sleep(1200);

            System.out.println(driver.getCurrentUrl());


            JavascriptExecutor jse = (JavascriptExecutor) driver; //实例化JavascriptExecutor对象


            String lastname2 = (String) jse.executeScript("return sessionStorage.wap;"); //获取存储在SessionStorage中的lastname的值
            System.out.println(lastname2);

            JsonObject jsonObject1 = new Gson().fromJson(lastname2, JsonObject.class);
            String payUrl = jsonObject1.get("payUrl").getAsString();
            String orderPrice = jsonObject1.get("orderPrice").getAsString();
            String payPhoneNumber = jsonObject1.get("payPhoneNumber").getAsString();

            String orderId = jsonObject1.get("orderId").getAsString();

            String payAmount = jsonObject1.get("payAmount").getAsString();

            System.out.println(payUrl);
            driver.navigate().to(payUrl);
            System.out.println(driver.getCurrentUrl());
            System.out.println(System.currentTimeMillis() - time);

//https://wappay.189.cn/pay/toPay.do?bankCode=ZFB001&sessionid=680ce08ceafe4796a1d3934709eb2b2e&state=
            //https://wappay.189.cn/pay/toPay.do?bankCode=WX001&sessionid=680ce08ceafe4796a1d3934709eb2b2e&state= HTTP/1.1


            jse.executeScript("sessionStorage.clear()"); //清除SessionStorage的值


            driver.close();
            driver.quit();
        }
        if (true) {
            return;
        }
        //找到id为kw的元素，输入java+selenium
        //driver.findElement(By.id("kw")).sendKeys("java+selenium");
        //点击id为su的元素
        //driver.findElement(By.id("su")).click();

        //隐式等待，针对页面加载，一旦设置，这个隐式等待会在WebDriver对象实例的整个生命周期起作用，
        //它不针对某一个元素，是全局元素等待，即在定位元素时，需要等待页面全部元素加载完成，
        //才会执行下一个语句。如果超出了设置时间的则抛出异常。
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //显示等待是等待指定元素设置的等待时间 推荐
//        WebElement we = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"qrcode\"]/div/div[2]")));

        //获取浏览器当前网页标题与地址
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //获取单个元素
//        WebElement element = driver.findElement(By.id("su"));
//        System.out.println("单个元素：" + element.getAttribute("class"));
//
//        //获取多个元素
//        List<WebElement> eList = driver.findElements(By.tagName("input"));
//        for (WebElement e : eList) {
//            System.out.println("获取多个元素：" + e.getAttribute("name"));
//        }
//
//        //css定位层级元素
//        WebElement e = driver.findElement(By.cssSelector("div.qrcode-text"));
//        List<WebElement> list = e.findElements(By.tagName("p"));
//        for (WebElement e1 : list) {
//            System.out.println("css定位层级元素:" + e1.getAttribute("class"));
//        }
//        //xpath定位层级元素
//        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"qrcode\"]/div/div[2]"));
//        List<WebElement> list2 = e.findElements(By.tagName("p"));
//        for (WebElement e1 : list) {
//            System.out.println("xpath定位层级元素:" + e1.getAttribute("class"));
//        }
//
//
//        //获取当前的窗口
//        String currentWindow = driver.getWindowHandle();
//        System.out.println(currentWindow);
//
//        //获取所有的窗口
//        Set<String> handles = driver.getWindowHandles();
//        for (String s : handles) {
//            System.out.println(s);
//        }
//
//        //遍历窗口
//        Iterator<String> iterator = handles.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();//这里iterator.next()只能用一次，否则会产生越界
//            if (currentWindow.equals(next))
//                continue;
//            //跳转到弹出的窗口
//            WebDriver driver2 = driver.switchTo().window(next);
//            driver2.getTitle();
//
//        }
//
//        //执行JS脚本
//        String jsString = "alert('Hello')";
//        try {
////            ((JavascriptExecutor) driver).executeScript(jsString);
//        } catch (Exception ex) {
//            //TODO Auto-generated catch block
//            ex.printStackTrace();
//        }
//
//        //处理弹出框
//        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
//        //alert.dismiss();//相当于点击取消
//        alert.accept();//相当于点击确认
//        //alert.sendKeys("testing");//输入值,如果可以
//
//
//        //处理下拉列表
//       /* Select select = new Select(driver.findElement(By.id("select")));
//        select.selectByIndex(1);
//        select.selectByValue("Value");
//        select.selectByVisibleText("Text");
//        //获取下拉框的全部选项
//        List<WebElement> list3 = select.getOptions();
//        for (WebElement webElement : list3) {
//            webElement.click();//点击下拉框
//        }*/
//
//        //处理cookie
//        //添加一个cookie
//        Cookie cookie = new Cookie("sessionId", "DF2334DFSDFOIFDFD221131");
//        driver.manage().addCookie(cookie);
//
//        //获取cookie
//        Set<Cookie> cookieSet = driver.manage().getCookies();
//        Iterator<Cookie> iteratorCookie = cookieSet.iterator();
//        while (iteratorCookie.hasNext()) {
//            Cookie c = iteratorCookie.next();
//            System.out.println(c.getName());
//            System.out.println(c.getValue());
//        }

        //driver.manage().deleteAllCookies();删除所有cookie
        //driver.manage().deleteCookie(cookie);删除cookie这个对象
        //driver.manage().deleteCookieNamed("COOKIE");删除name为COOKIE的cookie

        //鼠标操作
//        Actions action = new Actions(driver);
//        //移动到元素上双击 加上perform()才生效
//        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"su\"]"))).doubleClick().perform();
//        //移动到元素上右击
//        action.moveToElement(driver.findElement(By.cssSelector("input#kw"))).contextClick().perform();

//        driver.quit();//退出浏览器
    }

    private static String getImgUrl(WebElement teleValidCode) {

        String style = teleValidCode.getAttribute("style");
        System.out.println(style);


        String r = "getPicRandomCode.do(.*?)type=2";

        Pattern pattern = Pattern.compile(r);
        Matcher matcher = pattern.matcher(style);
        System.out.println(matcher.find());
        String sessionid = matcher.group(0);
        System.out.println(sessionid);
        String imgurl = "http://wapzt.189.cn/wap/" + sessionid;
        return imgurl;
    }

    private static String getImgCode(String imgurl) throws Exception {


        String username = "ruoshuisixue";
        //密码
        String password = "964056989";
        //验证码类型(默认数英混合),1:纯数字, 2:纯英文，其他:数英混合：可空
        String typeid = "1";
        //备注字段: 可以不写
        String remark = "输出计算结果";
        InputStream inputStream = null;
        //你需要识别的1:图片地址，2:也可以是一个文件
        //1:这是远程url的图片地址
        //String url = "https://ningge.oss-cn-shanghai.aliyuncs.com/recordImage/0000008bd2134152aa5fad036a802a89.jpg";
        URL u = new URL(imgurl);
        inputStream = u.openStream();
        //2:这是本地文件
//        File needRecoImage=new File("C:/Users/Administrator/Desktop/ck.png");
//        inputStream=new FileInputStream(needRecoImage);

        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);
        data.put("typeid", typeid);
        data.put("remark", remark);

        String resultString = Jsoup.connect("http://api.ttshitu.com/create.json")
                .data(data).data("image", "test.jpg", inputStream)
                .ignoreContentType(true)
                .post().text();
        JSONObject jsonObject = new JSONObject(resultString);
        System.out.println(jsonObject);
        String result = "";
        if (jsonObject.getBoolean("success")) {
            result = jsonObject.getJSONObject("data").getString("result");
//            System.out.println("识别成功结果为:"+result);
            return result;
        } else {
            System.out.println("识别失败原因为:" + jsonObject.getString("message"));
        }
        return null;
    }


}
