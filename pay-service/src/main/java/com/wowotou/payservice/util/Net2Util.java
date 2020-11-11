//package com.wowotou.payservice.util;
//
//import com.mfypay.common.Constant;
//import org.apache.http.HttpResponse;
//import org.apache.http.ProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.LaxRedirectStrategy;
//import org.apache.http.protocol.HttpContext;
//import org.springframework.http.*;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//
//public class Net2Util {
//
//    public static String REDIRECT(String url) {
//
//        final RestTemplate restTemplate = new RestTemplate();
//
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        HttpClient httpClient = HttpClientBuilder.create()
//                .setRedirectStrategy(new LaxRedirectStrategy())
//                .build();
//        factory.setHttpClient(httpClient);
//        restTemplate.setRequestFactory(factory);
//
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setAccept(Arrays.asList(MediaType.ALL));
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        headers.set(HttpHeaders.REFERER, "https://m.zhuanzhuan.com/wechat/m-pay.html?metric=vd1BG9VWO7aNyCZNR8yfrga11281zxe&payid=1201355425828989249&mchid=1001&webview=zzn&pageid=1610678272&isFrom=1#/home");
////            payQueue.setSubType(4);
//
//
//        headers.set(HttpHeaders.USER_AGENT, "android");
//
//
//        headers.set(HttpHeaders.ORIGIN, "http://nxt.nongxinyin.com");
//        headers.set(HttpHeaders.HOST, "ipos.lakala.com");
//        headers.set("X-Requested-With", "XMLHttpRequest");
//        RestTemplate client = new RestTemplate();
//
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<String> exchange = client.exchange(url, HttpMethod.GET, requestEntity, String.class);
//        return exchange.getBody();
//
//
//    }
//
//    public static String REDIRECTALIPAY(String url) {
//        return REDIRECTALIPAY(url, Constant.ALIPAY_UA);
//    }
//
//    public static String REDIRECTALIPAY(String url, String ua) {
//        final String[] url2 = {""};
//
//        final RestTemplate client = new RestTemplate();
//
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        HttpClient httpClient = HttpClientBuilder.create()
//                .setRedirectStrategy(new LaxRedirectStrategy() {
//                    @Override
//                    public boolean isRedirected(org.apache.http.HttpRequest request, HttpResponse response,
//                                                HttpContext context) throws ProtocolException {
//                        if (super.isRedirected(request, response, context)) {
//                            int statusCode = response.getStatusLine().getStatusCode();
//                            String redirectURL = response.getFirstHeader("Location").getValue();
//                            System.out.println("redirectURL: " + redirectURL);
//                            url2[0] = redirectURL;
//                            return true;
//                        }
//                        return false;
//                    }
//                })
//                .build();
//        factory.setHttpClient(httpClient);
//        client.setRequestFactory(factory);
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setAccept(Arrays.asList(MediaType.ALL));
//
//        headers.set(HttpHeaders.USER_AGENT, ua);
//
//        headers.set(HttpHeaders.UPGRADE, "1");
////        headers.set(HttpHeaders.ORIGIN, "http://nxt.nongxinyin.com");
////        headers.set(HttpHeaders.HOST, "gateway.starpos.com.cn");
//
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<String> exchange = client.exchange(url, HttpMethod.GET, requestEntity, String.class);
//        return url2[0];
//
//
//    }
//
//
//    public static String GETALIPAY(String url, String ua) {
//
//        final RestTemplate client = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.ALL));
//
//        headers.set(HttpHeaders.USER_AGENT, ua);
//
//        headers.set(HttpHeaders.UPGRADE, "1");
//
//        headers.set(HttpHeaders.HOST, "sdpayweb.js96008.com");
//
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<String> exchange = client.exchange(url, HttpMethod.GET, requestEntity, String.class);
//        return exchange.getBody();
//
//
//    }
//
//    public static String GETSQB(String url, MultiValueMap<String, String> map) {
//
//
//        final RestTemplate client = new RestTemplate();
//
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
//        headers.setOrigin("https://qr.shouqianba.com");
//
//        headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16C50 NebulaSDK/1.8.100112 Nebula PSDType(1) AlipayDefined(nt:WIFI,ws:320|504|2.0) AliApp(AP/10.1.52.6006) AlipayClient/10.1.52.6006 Alipay Language/zh-Hans");
//
//        headers.set("X-LOG-ID", "0175694125-d96c2520-7e1f-11e9-a24f-11519be8aaab");
//
//        headers.set("X-OPEN-ID", "2088802641694981");
//        headers.set("X-QRCODE-ID", "19040200405144509123");
//        headers.set("X-Requested-With", "XMLHttpRequest");
//
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);
//
//        ResponseEntity<String> exchange = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
//        return exchange.getBody();
//
//
//    }
//
//
//}
