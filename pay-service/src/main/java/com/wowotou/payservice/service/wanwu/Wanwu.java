//package com.wowotou.payservice.service.wanwu;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.math.BigDecimal;
//import java.net.URLDecoder;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Logger;
//
//@Service
//public class Wanwu {
//    @Resource
//    PayQueueService payQueueService;
//    @Resource
//    PayOrderService payOrderService;
//    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
//    @Resource
//    PayAccountDao payAccountDao;
//
//    public Map<String, String> getHeader(String token,
//                                         String deviceNum,
//                                         String systemversion,
//                                         String appversion,
//                                         String deviceToken, String deviceinfo
//    ) {
//        Map<String, String> httpHeaders = new HashMap<>();
//
//        if (StringUtils.isEmpty(deviceNum)) {
//            deviceNum = "AFA926ED-1DBB-4F9A-8C69-25B61743706A";
//        }
//
//        String timestamp = String.valueOf(System.currentTimeMillis());
//        httpHeaders.put("deviceinfo", deviceinfo);
//        httpHeaders.put("appversion", appversion);
//        httpHeaders.put("systemversion", systemversion);
//        httpHeaders.put("timestamp", timestamp);
//        httpHeaders.put("deviceNum", deviceNum);
//        httpHeaders.put("deviceToken", deviceToken);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Android-");
//        stringBuilder.append("xiaomin");
//        httpHeaders.put("source", stringBuilder.toString());
//
//        stringBuilder = new StringBuilder();
//        stringBuilder.append("Android");
//        stringBuilder.append("-");
//        stringBuilder.append(appversion);
//        stringBuilder.append("-");
//        stringBuilder.append(systemversion);
//        stringBuilder.append("-");
//        stringBuilder.append(timestamp);
//        stringBuilder.append("-");
//        stringBuilder.append("zhuangdianwenhua!@#");
//        httpHeaders.put("sign", Md5.md5(stringBuilder.toString()));
//        StringBuilder stringBuilder1 = new StringBuilder();
//        if (!StringUtils.isEmpty(token)) {
//            stringBuilder1.append("Wwdz ");
//            stringBuilder1.append(token);
//            httpHeaders.put("Authorization", stringBuilder1.toString());
//        }
//
//        return httpHeaders;
//    }
//
//    @Resource
//    PayChannelService payChannelService;
//
//    public void login(String userId, String phone, String verCode,
//                      String deviceNum, int channelId,
//                      Map<String, String> proxy) {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("phone", phone);
//        hashMap.put("authCode", verCode);
//        PayChannel channel = payChannelService.getChannelById(channelId);
//        String param = channel.getParam();
//        JsonObject jsonObject = new Gson().fromJson(param, JsonObject.class);
//        //{"appversion":"2.7.5","systemversion":"13.2.3","deviceToken":"51903ee3kDMxwaSwGELmxhtGj7gIUADtWkntvTx3","deviceinfo":"Android"}
//
//        Map<String, String> header = getHeader("", deviceNum,
//                jsonObject.get("systemversion").getAsString(),
//                jsonObject.get("appversion").getAsString(),
//                jsonObject.get("deviceToken").getAsString(),
//                jsonObject.get("deviceinfo").getAsString()
//        );
//
//        try {
//            String post = FetchUtil.PostJson(
//                    channel.getGateway() + "/module-user/api/v1/user/v2/loginByPhoneAndAuthCode",
//                    "", proxy,
//                    (hashMap),
//                    USERAGENT.WANwu
//                    , header, USERAGENT.WANwu);
//            System.out.println(post);
//            JsonObject ret = new Gson().fromJson(post, JsonObject.class);
//            int code = ret.get("code").getAsInt();
//            if (code == 1001) {
//                payAccountDao.updateTokenbyLogin(post, userId);
//            } else if (code != 4006) {
//                payAccountDao.forbidenbyUserId(userId);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public void sendLoginSms(String userId, String phone,
//                             String deviceNum,
//                             int channelId,
//                             Map<String, String> proxy) {
//        PayChannel channel = payChannelService.getChannelById(channelId);
//
//        String param = channel.getParam();
//        JsonObject jsonObject = new Gson().fromJson(param, JsonObject.class);
//
//        Map<String, String> header = getHeader("", deviceNum,
//                jsonObject.get("systemversion").getAsString(),
//                jsonObject.get("appversion").getAsString(),
//                jsonObject.get("deviceToken").getAsString(),
//                jsonObject.get("deviceinfo").getAsString()
//        );
//
//
//        String post = FetchUtil.GetJson(
//                channel.getGateway()
//                        + "/module-user/api/v1/user/sendSmsAuthCode?phone=" + phone,
//                "", proxy,
//                USERAGENT.WANwu
//                , header, USERAGENT.WANwu);
//        System.out.println(channel.getGateway()
//                + "/module-user/api/v1/user/sendSmsAuthCode?phone=" + phone);
//        System.out.println(post);
//
//        JsonObject ret = new Gson().fromJson(post, JsonObject.class);
//        int code = ret.get("code").getAsInt();
//        if (code == 1001) {
//            payAccountDao.updateVerCodeTime(userId);
//        }
//
//    }
//
////alipay_sdk=alipay-sdk-java-3.6.0.ALL&app_id=2018121762562829&biz_content=%7B%22b
//// ody%22%3A%22%E4%BD%99%E9%A2%9D%E5%85%85%E5%80%BC%22%2C%22
//// disable_pay_channels%22%3A%22credit_group%22%2C%22out_trade_no%22%3A%22712472858995765248%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E4%BD%99%E9%A2%9D%E5%85%85%E5%80%BC%22%2C%22timeout_express%22%3A%2228m%22%2C%22total_amount%22%3A%221%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fapi.wanwudezhi.com%2Fapi%2Fpay%2Fnotify%2Fali%2Fpay%2Fmaster&sign=ZiiiZ%2FwV%2BE6B8O8qZZ4G8TN6JOU0WXZuA971RYcd1lbz1%2FU9qtOidzh1SzyG3TVvqcQUOrimtwuTG3zzSG%2FatfbAsIMpLuWT%2FkCWQRjPCWWIJmJgQW0W%2Fx%2FQ405xKdci67cMtF07qQTMz838Bg0keF0zwnTkJJ0ry6%2BF8Aj8Qh8JXyV%2F8Igb69K4HaeiFV6PK9K1E8POgT4J2uprOzQmQRoxAXUXSHRlVwnLDfbZenllmuCPQtBOt1oiHVIikxt%2BC%2FMJyU3qSTr7vHBZUf0oqPoey%2BC4LCNiDtOs37yWmK0mxzlWWNxqorQI%2BJnLkrsSH4YxUJX1DNf9rUqgI95x8Q%3D%3D&sign_type=RSA2&timestamp=2020-05-20+01%3A12%3A46&version=1.0
//    public int recharge(int queueId,
//                        String userId,
//                        String mark,
//                        String deviceNum,
//                        int channelId,
//                        double money,
//                        String tokens,
//                        Map<String, String> proxy) {
//        PayChannel channel = payChannelService.getChannelById(channelId);
//
//        String param = channel.getParam();
//        JsonObject jsonObject = new Gson().fromJson(param, JsonObject.class);
//        JsonObject tokenJson = new Gson().fromJson(tokens, JsonObject.class);
//        Map<String, String> httpHeaders = getHeader(tokenJson.get("result")
//                        .getAsJsonObject().get("token").getAsString(), deviceNum,
//                jsonObject.get("systemversion").getAsString(),
//                jsonObject.get("appversion").getAsString(),
//                jsonObject.get("deviceToken").getAsString(),
//                jsonObject.get("deviceinfo").getAsString()
//        );
//
//
//        HashMap<String, String> hashMap = new HashMap<String, String>();
//        hashMap.put("money", new BigDecimal(money * 100).intValue() + "");
//        hashMap.put("platformType", "3");
//        hashMap.put("source", "android_mall");
//        String post = FetchUtil.PostJson(
//                channel.getGateway() + "/api/pay/balance/recharge",
//                "", proxy, (hashMap), USERAGENT.WANwu
//                , httpHeaders, USERAGENT.WANwu);
//        System.out.println(post);
//
//        JsonObject rechargeJson = new Gson().fromJson(post, JsonObject.class);
//        if (rechargeJson.get("code").getAsInt() == 1001) {
//            String post2 = FetchUtil.GetJson(
//                    channel.getGateway() + "/api/v1/order/pay/getPayParam?orderNo=" +
//                            rechargeJson.get("result").getAsString() + "&platform=1&payMethod=4",
//                    "", null, USERAGENT.WANwu
//                    , httpHeaders, USERAGENT.WANwu);
//            System.out.println(post2);
//            JsonObject payParamJson = new Gson().fromJson(post2, JsonObject.class);
//
//            if (payParamJson.get("code").getAsInt() == 1001) {
//                String payParam = payParamJson.get("result")
//                        .getAsJsonObject().get("payParam")
//                        .getAsJsonObject().get("aliData").getAsString();
//                System.out.println("orderNo" +
//                        rechargeJson.get("result").getAsString() +
//                        "payParam+" + payParam);
//
//
//                Map<String, String> map = MapUtil.Str2Map(URLDecoder.decode(payParam));
//                JsonObject paramJson = new Gson().fromJson(map.get("biz_content"), JsonObject.class);
//
//
//                String orderNo = rechargeJson.get("result").getAsString();
//
//                String  out_trade_no = paramJson.get("out_trade_no").getAsString();
//                return payQueueService.updateQueueTradeNo(queueId, out_trade_no,
//                        orderNo, out_trade_no, payParam);
//
//            }
//
//        } else {
//            logger.info(post + "账号" + userId + "被禁用");
//            payAccountDao.forbidenbyUserId(userId);
//        }
//        return 0;
//
//    }
//
//    public void query(QueryModel map) {
//
//        PayChannel channel = payChannelService.getChannelById(map.getChannelId());
//
//        String param = channel.getParam();
//        JsonObject jsonObject = new Gson().fromJson(param, JsonObject.class);
//        JsonObject tokenJson = new Gson().fromJson(map.getToken(), JsonObject.class);
//        Map<String, String> httpHeaders = getHeader(tokenJson.get("result")
//                        .getAsJsonObject().get("token").getAsString(),
//                map.getDeviceNum(),
//                jsonObject.get("systemversion").getAsString(),
//                jsonObject.get("appversion").getAsString(),
//                jsonObject.get("deviceToken").getAsString(),
//                jsonObject.get("deviceinfo").getAsString()
//        );
//
//        try {
//            String post = FetchUtil.GetJson(channel.getGateway() +
//                            "/api/pay/balance/balance?type=3",
//                    "", null, USERAGENT.WANwu
//                    , httpHeaders, USERAGENT.WANwu);
//            System.out.println(post);
//
//
//            JsonObject blanceJson = new Gson().fromJson(post, JsonObject.class);
//
//            if (blanceJson.get("code").getAsInt() == 1001) {
//                payAccountDao.updateMoney(blanceJson.get("result").getAsJsonObject().get("balance").getAsString()
//                        , map.getUserId());
//
//
//                String post2 = FetchUtil.GetJson(channel.getGateway() +
//                                "/api/pay/balance/balanceDetailList?pageIndex=1&pageSize=20&subType=1",
//                        "", null, USERAGENT.WANwu
//                        , httpHeaders, USERAGENT.WANwu);
//                System.out.println(post2);
//                JsonObject detailJson = new Gson().fromJson(post2, JsonObject.class);
////https://api.wanwudezhi.com/api/pay/balance/balanceDetail?id=93784593
//
//                if (detailJson.get("code").getAsInt() == 1001) {
//                    JsonArray dataListJson =
//                            detailJson.get("result").getAsJsonObject().get("dataList").getAsJsonArray();
//
//                    System.out.println("datalist"+dataListJson);
//                    for (JsonElement  item: dataListJson   ) {
//
//
//                        String balanceDetail  = FetchUtil.GetJson(channel.getGateway() + "/api/pay/balance/balanceDetail?id=" + item.getAsJsonObject().get("id"),
//                                "", null, USERAGENT.WANwu, httpHeaders, USERAGENT.WANwu);
//
//                        JsonObject balanceJson = new Gson().fromJson(balanceDetail, JsonObject.class);
//
//                        if (balanceJson.get("code").getAsInt()==1001) {
//                            JsonObject detailRet = balanceJson.get("result").getAsJsonObject();
//
//                           if (detailRet.get("statusName").getAsString()
//                                   .equalsIgnoreCase("已完成")){
//                               String thirdId = tokenJson.get("result").getAsJsonObject()
//                                       .get("userInfo").getAsJsonObject()
//                                       .get("userId").getAsString();
//                               if (thirdId.equalsIgnoreCase(
//                                       detailRet.get("userId").getAsString())){
//                                   String money = detailRet.get("money").getAsString();
//                                   String tradeNo = detailRet.get("tradeNo").getAsString();
//                                   String orderNo = detailRet.get("orderNo").getAsString();
//                                   //String money = detailRet.get("money").getAsString();
//                                   payOrderService.resultSuccess(
//                                           tradeNo, tradeNo, tradeNo, map.getUserId(),
//                                           balanceDetail,"");
//                               }else {
//                                   System.out.println("账号不匹配");
//                               }
//                           }
//
//                        }
//                        System.out.println(item);
//                    }
//
//
//                }
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
