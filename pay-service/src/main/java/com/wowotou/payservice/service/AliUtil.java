package com.wowotou.payservice.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.RoyaltyEntity;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.google.gson.Gson;
import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.service.MiOrderPayService;
import com.wowotou.service.MiOrderService;
import com.wowotou.service.MiPayAccountService;
import com.wowotou.service.MiPayChannelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AliUtil {

    @Resource
    MiPayAccountService payAccountService;
    @Resource
    MiPayChannelService payChannelService;
    @Resource
    MiOrderPayService payQueueService;
    @Resource
    MiOrderService payOrderService;

    /**
     * 分账关系绑定
     * <p>
     * <p>
     * 账单详情 * ￥ 1.00 当前状态 已收款 收 款 时 间 2020-03-08 15:55:39 订 单 金 额 1.00 更多 交 易 说 明 L20200308152503127 收款单号 2020030822001494981434840812 商 家 订 单 号 45836541393802641694981 收 款 方 式 * 133******61 发起退款 在线帮助
     */
    public Map<String, String> relationBind(String aChildId
    ) {
        Map<String, String> map = new HashMap();


        MiPayAccount childAccount = payAccountService.queryById(aChildId);
        MiPayAccount mainAccount = payAccountService.queryById(
                String.valueOf(childAccount.getPid()));
        MiPayChannel channel = payChannelService.queryById(
                String.valueOf(childAccount.getChannelid()));
        String param = channel.getParam();
        Map<String, String> mapParam = new Gson().fromJson(param, Map.class);
        try {
            AlipayClient alipayClient =
                    new DefaultAlipayClient(
                            channel.getGateway(),
                            mainAccount.getUserid(),
                            mainAccount.getToken()
                            , mapParam.get("format"),
                            "GBK",
                            mainAccount.getExtra(),
                            mapParam.get("signType"));
            AlipayTradeRoyaltyRelationBindRequest request =
                    new AlipayTradeRoyaltyRelationBindRequest();
            request.setBizContent("{" +
                    "      \"receiver_list\":[{" +
                    "        \"type\":\"loginName\"," +
                    "\"account\":\"" + childAccount.getLogonid() + "\"," +
                    "\"name\":\"" + childAccount.getRealnamed() + "\"," +
                    "\"memo\":\"" + childAccount.getLogonid() + "\"" +
                    "        }]," +
                    "\"out_request_no\":\"" + System.currentTimeMillis() + "\"" +
                    "  }");

            AlipayTradeRoyaltyRelationBindResponse response = alipayClient.execute(request);
            map.put("msg", response.getBody());
            map.put("req", request.getBizContent());
            if (response.isSuccess()) {
                map.put("code", "1");

            } else {
                map.put("code", "0");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;


    }

    /**
     *
     */
    public Map<String, String> relationUnbind(String aChildId) {
        Map<String, String> map = new HashMap<>();
        MiPayAccount childAccount = payAccountService.queryById(aChildId);
        MiPayAccount mainAccount = payAccountService.queryById(
                String.valueOf(childAccount.getPid()));
        MiPayChannel channel = payChannelService.queryById(
                String.valueOf(childAccount.getChannelid()));
        String param = channel.getParam();
        Map<String, String> mapParam = new Gson().fromJson(param, Map.class);

        AlipayClient alipayClient =
                new DefaultAlipayClient(
                        channel.getGateway(),
                        mainAccount.getUserid(),
                        mainAccount.getToken()
                        , mapParam.get("format"),
                        mapParam.get("charset"),
                        mainAccount.getExtra(),
                        mapParam.get("signType"));
        AlipayTradeRoyaltyRelationUnbindRequest request =
                new AlipayTradeRoyaltyRelationUnbindRequest();
        request.setBizContent("{" +
                "      \"receiver_list\":[{" +
                "        \"type\":\"loginName\"," +
                "\"account\":\"" + childAccount.getLogonid() + "\"," +
                "\"name\":\"" + childAccount.getRealnamed() + "\"," +
                "\"memo\":\"" + childAccount.getRealnamed() + "解绑\"" +
                "        }]," +
                "\"out_request_no\":\"" + System.currentTimeMillis() + "\"" +
                "  }");
        AlipayTradeRoyaltyRelationUnbindResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        map.put("msg", response.getBody());
        map.put("req", request.getBizContent());
        if (response.isSuccess()) {
            map.put("code", "1");
            System.out.println("调用成功");
        } else {
            map.put("code", "0");
            System.out.println("调用失败");
        }
        return map;

    }

    /**
     * 分账关系查询
     *
     * @throws AlipayApiException
     */
    public List<RoyaltyEntity> relationBatchquery(String userId) {

        MiPayAccount mainAccount = payAccountService.queryById(
                userId);
        MiPayChannel channel = payChannelService.queryById(String.valueOf(mainAccount.getChannelid()));
        String param = channel.getParam();
        Map<String, String> mapParam = new Gson().fromJson(param, Map.class);

        AlipayClient alipayClient =
                new DefaultAlipayClient(
                        channel.getGateway(),
                        mainAccount.getUserid(),
                        mainAccount.getToken()
                        , mapParam.get("format"),
                        mapParam.get("charset"),
                        mainAccount.getExtra(),
                        mapParam.get("signType"));
        AlipayTradeRoyaltyRelationBatchqueryRequest request = new AlipayTradeRoyaltyRelationBatchqueryRequest();
        request.setBizContent("{" +
                "\"page_num\":1," +
                "\"page_size\":20," +
                "\"out_request_no\":\"" + System.currentTimeMillis() + "\"" +
                "  }");
        AlipayTradeRoyaltyRelationBatchqueryResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.printf(response.getBody());

        if (response.isSuccess()) {
            return response.getReceiverList();
            // System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            return null;
        }

    }

    /**
     * 商家分账
     *
     * @param appId
     * @param money
     */
    public Map<String, String> orderSettle(String appId,
                                           double money,
                                           String tradeNo,
                                           String mark,
                                           String show) {

        MiPayAccount mainAccount = payAccountService.queryByUserid(appId);
        MiPayAccount childrenAccount = payAccountService.queryById(mainAccount.getId());
        if (childrenAccount == null) {
            System.out.println("childrenAccount:isnull");
            return null;
        }
        childrenAccount.setMtime(Instant.now().getEpochSecond());
        payAccountService.updateAccountmTime(childrenAccount.getId());// 更新

        MiPayChannel channel = payChannelService.queryById(String.valueOf(childrenAccount.getChannelid()));
        String param = channel.getParam();
        Map<String, String> mapParam = new Gson().fromJson(param, Map.class);

        AlipayClient alipayClient =
                new DefaultAlipayClient(
                        channel.getGateway(),
                        mainAccount.getUserid(),
                        mainAccount.getToken()
                        , mapParam.get("format"),
                        mapParam.get("charset"),
                        mainAccount.getExtra(),
                        mapParam.get("signType"));

        AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
        request.setBizContent("{" +
                "\"out_request_no\":\"" + System.currentTimeMillis() + "\"," +
                "\"trade_no\":\"" + tradeNo + "\"," +
                "      \"royalty_parameters\":[{" +
                "        \"royalty_type\":\"transfer\"," +

                "\"trans_in_type\":\"userId\"," +
                "\"trans_in\":\"" + childrenAccount.getUserid() + "\"," +
                "\"amount\":" + money + "," +
                "\"desc\":\"" + "补" + tradeNo + show + "\"" +
                "        }]," +
                "\"operator_id\":\"" + mainAccount.getRealnamed() + "\"" +
                "  }");
        AlipayTradeOrderSettleResponse response = null;
        try {
            response = alipayClient.execute(request);

        } catch (AlipayApiException e) {
            System.out.println("eee:" + e);
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        if (response!=null&&response.isSuccess()) {

            try {
//                payQueueService.updateQueueTardeNoToUserByMark(
//                        childrenAccount.getUserId(),
//                        response.getTradeNo(),
//                        mark
//                );

            } catch (Exception e) {
                e.printStackTrace();
            }

            map.put("msg", response.getMsg());
            map.put("ret", "ok");
            map.put("body", response.getBody());
            map.put("toUserId", childrenAccount.getUserid());
        } else {
            map.put("msg", response.getSubMsg());
            map.put("ret", "err");
            map.put("toUserId", "分账失败");
        }

        map.put("req", request.getBizContent());
        return map;


    }

    /**
     * 交易查询
     */
//    public Map<String, String> tradeQuery(MiOrderPay queue) {
//        Map<String, String> map = new HashMap<>();
//
//        String param = queue.getParam();
//        Map<String, String> mapParam = new Gson().fromJson(param, Map.class);
//
//        AlipayClient alipayClient =
//                new DefaultAlipayClient(
//                        queue.getGateway(),
//                        queue.getUserId(),
//                        queue.getAccountExtra()
//                        , mapParam.get("format"),
//                        mapParam.get("charset"),
//                        queue.getAccountExtra(),
//                        mapParam.get("signType"));
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//
//        request.setBizContent("{" +
//                "\"out_trade_no\":\"" + queue.getMark() + "\"," +
//                "\"trade_no\":\"\"," +
//                "\"org_pid\":\"2088101117952222\"," +
//                "      \"query_options\":[" +
//                "        \"TRADE_SETTLE_INFO\"" +
//                "      ]" +
//                "  }");
//        AlipayTradeQueryResponse response = null;
//        try {
//            response = alipayClient.execute(request);
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        if (response.isSuccess()) {
//            if (response.getTradeStatus().equals("TRADE_SUCCESS")) {
//                map.put("code", "1");
//                map.put("msg", response.getBody());
//
//
//            }
//
//            System.out.println("调用成功");
//        } else {
//            map.put("code", "0");
//            System.out.println("调用失败");
//        }
//        return map;
//    }


    public Map<String, String> query(int id, String ip) {
//        QueueType queue = payQueueService.getQueueTypebyId((id));
//
//        String param = queue.getParam();
//        Map<String, String> mapParam = new Gson().fromJson(param, Map.class);
//
//        AlipayClient alipayClient =
//                new DefaultAlipayClient(
//                        queue.getGateway(),
//                        queue.getUserId(),
//                        queue.getAccountToken()
//                        , mapParam.get("format"),
//                        mapParam.get("charset"),
//                        queue.getAccountExtra(),
//                        mapParam.get("signType"));
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//
//        PayCanAccount mainAccount = payAccountService.getAccountById(String.valueOf(queue.getaId()));
//
//
//        request.setBizContent("{" +
//                "\"out_trade_no\":\"" + queue.getMark() + "\"," +
////                "\"trade_no\":\" 073956707\"," +
////                "\"org_pid\":\"2088101117952222\"," +
//                "      \"query_options\":[" +
//                "        \"TRADE_SETTLE_INFO\"" +
//                "      ]" +
//                "  }");
//        AlipayTradeQueryResponse response = null;
//        try {
//            response = alipayClient.execute(request);
//
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//
//            if (response.getTradeStatus().equals("TRADE_SUCCESS")) {
//
//
//                PayChannel channel = payChannelService.getChannelById(queue.getChannelId());
//
//
//                double money = Double.valueOf(response.getTotalAmount())
//                        * (1 - channel.getRate());
//
//                double money2 = Math.ceil(money * 100) / 100;
//                Map<String, String> respMap = new HashMap<>();
//                if (queue.getToUserId().equalsIgnoreCase(queue.getUserId())) {
//                    respMap = orderSettle(mainAccount.getUserId(), money2
//
//                            , response.getTradeNo(), queue.getMark(), queue.getShow());
//
//                    try {
//                        payQueueService.updateQueueTardeNoToUserByMark(respMap.get("toUserId"),
//                                response.getTradeNo(),
//                                response.getOutTradeNo());
//
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                payOrderService.resultSuccess(
//                        response.getOutTradeNo(), response.getTradeNo(), response.getTradeNo(),
//                        queue.getUserId(),
//                        MapUtil.getParamStr(response.getParams()), ip);
//
//
//            }
//
//
//        } else {
//            System.out.println("调用失败");
//        }
        Map<String, String> map = new HashMap<>();
       // response.getTradeStatus();
        return map;
    }


    public void settle2(String tradeNo, double tradeMoney) {


        String money = String.valueOf(tradeMoney - (tradeMoney * 0.018));
        String transIn = "2088012756148020";
        String show = "补" + tradeNo;


        AlipayClient alipayClient =
                new DefaultAlipayClient(
                        "https://openapi.alipay.com/gateway.do",
                        "2017062807593271",
                        "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDg7d4dtpN6JPGXxpPNk778uxDFY15VlyvmVKnW5at2cbd3/p8MzfcOQ9TdS3xxYZY5xR2kp3gQI3mYs4Y/NM6EftTuS4A/hL6RV8XWCQXOxJUhQWWvMEqlj+M138FxT26V5ADbtaHE4HENRFDjb2ZWG12wdZZ4XPuMs+0HW37vRyVFBD7XsuRpPVpjzAovJ6RC/c96BNT1nq/kjjCmQYMSG8WVZt0ifKV/+GP3NwN0JMT3dcWA4c2lWmWsM2cq1VBoOlPLOriHZevH0ka0T/3cKcgQU5b5WgiK1hfE6Z87Hq18WgPkF57RrXohlf0i4Rsrc7r8jc56Kgjhn7fIgFFpAgMBAAECggEBALcPoQiZwWlVi/K0wTI9HuFd9gZQG0SZpjbtjNTDU0swvdtBNX0cXAgWGLaKaxt0Cum1jaymR8cKuDoZUhc7CSE4gF/4vsXzaY2s2+yYp0tjHuRT70gni3k3o/oCw9NOjHgder1WE/TBngDoKtUPo0BNQXEOIoqPUoNvJGgqhSKDRAV3+jaOf7ltx0AjUiCFlKw3uH4j3Rw/rBFg7wjMtUXktLjUfSe9X9iwtCR+lYIF+d6kLDMglqqSOAaqa8j4x5hBULz2++I6t6ghahZupsM4jlii344I+F0QGsHpUmh48geIcK8h8v3ArdZ2hPPyjIeF88cZQvjC/nYpYntnA+kCgYEA9vh4f6WPVQUcKDaf5hTDCcd/S/eR9FyYLRgCKfYrK+ZT3sEs4AWeNX/P1APwwtiNxytX+GnlzvMMjbYEcR0TByGcYVWmQS4epKT0zBszTAMP2mXRkl6aUa4C9pbb2Lh9qRCCfk3yLLDnMipnNG+KuEbyFB+TlPUghAidQIJoj2MCgYEA6ScZfVVdScJZCmhUTXnqZoEAkb7r9vkNOpRZQ4dSJJcUk6oDYRFWd6adZjeMvS7JKq4XDIPJfDC6+TzZrhd9YXhpvfq2R6xp81nEZ6P3Fs2Tcjv8pXZ9hrQVaaTVXBDwiz054iTG83pnSi/kk1/9hktA6KkPaOG+/DUsAguKU8MCgYAzevW7PeqTwV3uL/zCvB8vwasSTcfZ1RdPhwqkbpDvNLLU4xWUmPcylbLfsfaU1wkutCVBPenOarF6NK/WWEYoHWR4kZ73RULT9SKmDSFzPcwnLUQzK48laY1qk2W+Vi6zeCKLa3oIwNNgjKA4uOuEoB1D/pUH3tTpUNZepRBgmwKBgGTnSg3HAv+n/7cUXd/F8p74F5H8Cc0yDfqbN2KVTwSM6hfaDWpWAZD458fUJLG/bMpu24TMCEgaIuE455CDk/y6CzFwLrEoOhZadDjSal5RDA31Tish88N3bojxEHGu1xu7nLB1cDDxeYBO5+KsOWGEcgv/Fq8ye+BU9r3P1sbXAoGBAPCE2pqZz1SnsYan3Ac6Es6dXoejyHGxQFk2AdoWUe2hAP2guoihhBykirY0xcNJZc3Qa/pnLY7YZH+iI3gPizwlDMSW2FT4tFCdf9pZdZZJUcXFRwfl867doWoUobXC11bTjPSKrtmcroE4Tx6fy7QDPnISFW/A401Jn1lJKOJC"
                        , "json",
                        "UTF-8",
                        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh1HvNLpz2MEa6Sqqu4s1ncmONhPJlZsBrQnx+U4gNc4YpgOIp3gRqlGL4yTGo68Spa5TIiqFN32lpiGxa89v51Xzpvj/ZTT6ktAa/dY9S3LLUYJmLGj6gwMKIesKmsa5uCBPBP10PNHbku0OPfzlcPfAzij8GrDidpdrhlP0aPvYi5ASG+uG7avYAthW+Llr/bwW0JVVeK1JedUVRTlk3CzQhVhb+otNrN/0jEy8KLTaj5Q2dZDgAEiH3VlGhju+FpaSAjstVSgQfoYvf+KB9YrfMtKs3UkdAynGHrtrQdr1MSgNhk8X72gDJsLK1/x05WsAg3l9/Bm/09BG9ZPOuQIDAQAB",
                        "RSA2");

        AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
        request.setBizContent("{" +
                "\"out_request_no\":\"" + System.currentTimeMillis() + "\"," +
                "\"trade_no\":\"" + tradeNo + "\"," +
                "      \"royalty_parameters\":[{" +
                "        \"royalty_type\":\"transfer\"," +

                "\"trans_in_type\":\"userId\"," +
                "\"trans_in\":\"" + transIn + "\"," +
                "\"amount\":" + money + "," +
                "\"desc\":\"" + show + "\"" +
                "        }]," +
                "\"operator_id\":\"" + show + "\"" +
                "  }");
        AlipayTradeOrderSettleResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        System.out.printf(tradeNo + ":" + response.getBody());
        if (response.isSuccess()) {

            System.out.println(response);

        } else {
            map.put("msg", response.getMsg());
            map.put("ret", "err");
            map.put("toUserId", "分账失败");
        }


    }


    public void query2(String trandNo) {

        String mark = "L202003311425493230";
        AlipayClient alipayClient =
                new DefaultAlipayClient(
                        "https://openapi.alipay.com/gateway.do",
                        "2017062807593271",
                        "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDg7d4dtpN6JPGXxpPNk778uxDFY15VlyvmVKnW5at2cbd3/p8MzfcOQ9TdS3xxYZY5xR2kp3gQI3mYs4Y/NM6EftTuS4A/hL6RV8XWCQXOxJUhQWWvMEqlj+M138FxT26V5ADbtaHE4HENRFDjb2ZWG12wdZZ4XPuMs+0HW37vRyVFBD7XsuRpPVpjzAovJ6RC/c96BNT1nq/kjjCmQYMSG8WVZt0ifKV/+GP3NwN0JMT3dcWA4c2lWmWsM2cq1VBoOlPLOriHZevH0ka0T/3cKcgQU5b5WgiK1hfE6Z87Hq18WgPkF57RrXohlf0i4Rsrc7r8jc56Kgjhn7fIgFFpAgMBAAECggEBALcPoQiZwWlVi/K0wTI9HuFd9gZQG0SZpjbtjNTDU0swvdtBNX0cXAgWGLaKaxt0Cum1jaymR8cKuDoZUhc7CSE4gF/4vsXzaY2s2+yYp0tjHuRT70gni3k3o/oCw9NOjHgder1WE/TBngDoKtUPo0BNQXEOIoqPUoNvJGgqhSKDRAV3+jaOf7ltx0AjUiCFlKw3uH4j3Rw/rBFg7wjMtUXktLjUfSe9X9iwtCR+lYIF+d6kLDMglqqSOAaqa8j4x5hBULz2++I6t6ghahZupsM4jlii344I+F0QGsHpUmh48geIcK8h8v3ArdZ2hPPyjIeF88cZQvjC/nYpYntnA+kCgYEA9vh4f6WPVQUcKDaf5hTDCcd/S/eR9FyYLRgCKfYrK+ZT3sEs4AWeNX/P1APwwtiNxytX+GnlzvMMjbYEcR0TByGcYVWmQS4epKT0zBszTAMP2mXRkl6aUa4C9pbb2Lh9qRCCfk3yLLDnMipnNG+KuEbyFB+TlPUghAidQIJoj2MCgYEA6ScZfVVdScJZCmhUTXnqZoEAkb7r9vkNOpRZQ4dSJJcUk6oDYRFWd6adZjeMvS7JKq4XDIPJfDC6+TzZrhd9YXhpvfq2R6xp81nEZ6P3Fs2Tcjv8pXZ9hrQVaaTVXBDwiz054iTG83pnSi/kk1/9hktA6KkPaOG+/DUsAguKU8MCgYAzevW7PeqTwV3uL/zCvB8vwasSTcfZ1RdPhwqkbpDvNLLU4xWUmPcylbLfsfaU1wkutCVBPenOarF6NK/WWEYoHWR4kZ73RULT9SKmDSFzPcwnLUQzK48laY1qk2W+Vi6zeCKLa3oIwNNgjKA4uOuEoB1D/pUH3tTpUNZepRBgmwKBgGTnSg3HAv+n/7cUXd/F8p74F5H8Cc0yDfqbN2KVTwSM6hfaDWpWAZD458fUJLG/bMpu24TMCEgaIuE455CDk/y6CzFwLrEoOhZadDjSal5RDA31Tish88N3bojxEHGu1xu7nLB1cDDxeYBO5+KsOWGEcgv/Fq8ye+BU9r3P1sbXAoGBAPCE2pqZz1SnsYan3Ac6Es6dXoejyHGxQFk2AdoWUe2hAP2guoihhBykirY0xcNJZc3Qa/pnLY7YZH+iI3gPizwlDMSW2FT4tFCdf9pZdZZJUcXFRwfl867doWoUobXC11bTjPSKrtmcroE4Tx6fy7QDPnISFW/A401Jn1lJKOJC"
                        , "json",
                        "UTF-8",
                        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh1HvNLpz2MEa6Sqqu4s1ncmONhPJlZsBrQnx+U4gNc4YpgOIp3gRqlGL4yTGo68Spa5TIiqFN32lpiGxa89v51Xzpvj/ZTT6ktAa/dY9S3LLUYJmLGj6gwMKIesKmsa5uCBPBP10PNHbku0OPfzlcPfAzij8GrDidpdrhlP0aPvYi5ASG+uG7avYAthW+Llr/bwW0JVVeK1JedUVRTlk3CzQhVhb+otNrN/0jEy8KLTaj5Q2dZDgAEiH3VlGhju+FpaSAjstVSgQfoYvf+KB9YrfMtKs3UkdAynGHrtrQdr1MSgNhk8X72gDJsLK1/x05WsAg3l9/Bm/09BG9ZPOuQIDAQAB",
                        "RSA2");

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
//                "\"out_trade_no\":\"" + mark + "\"," +
                "\"trade_no\":\"" + trandNo + "\"," +
//                "\"org_pid\":\"2088101117952222\"," +
                "      \"query_options\":[" +
                "        \"TRADE_SETTLE_INFO\"" +
                "      ]" +
                "  }");
        AlipayTradeQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
            System.out.println(response.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }


    }


    public void load(String time) throws AlipayApiException {

        AlipayClient alipayClient =
                new DefaultAlipayClient(
                        "https://openapi.alipay.com/gateway.do",
                        "2017062807593271",
                        "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDg7d4dtpN6JPGXxpPNk778uxDFY15VlyvmVKnW5at2cbd3/p8MzfcOQ9TdS3xxYZY5xR2kp3gQI3mYs4Y/NM6EftTuS4A/hL6RV8XWCQXOxJUhQWWvMEqlj+M138FxT26V5ADbtaHE4HENRFDjb2ZWG12wdZZ4XPuMs+0HW37vRyVFBD7XsuRpPVpjzAovJ6RC/c96BNT1nq/kjjCmQYMSG8WVZt0ifKV/+GP3NwN0JMT3dcWA4c2lWmWsM2cq1VBoOlPLOriHZevH0ka0T/3cKcgQU5b5WgiK1hfE6Z87Hq18WgPkF57RrXohlf0i4Rsrc7r8jc56Kgjhn7fIgFFpAgMBAAECggEBALcPoQiZwWlVi/K0wTI9HuFd9gZQG0SZpjbtjNTDU0swvdtBNX0cXAgWGLaKaxt0Cum1jaymR8cKuDoZUhc7CSE4gF/4vsXzaY2s2+yYp0tjHuRT70gni3k3o/oCw9NOjHgder1WE/TBngDoKtUPo0BNQXEOIoqPUoNvJGgqhSKDRAV3+jaOf7ltx0AjUiCFlKw3uH4j3Rw/rBFg7wjMtUXktLjUfSe9X9iwtCR+lYIF+d6kLDMglqqSOAaqa8j4x5hBULz2++I6t6ghahZupsM4jlii344I+F0QGsHpUmh48geIcK8h8v3ArdZ2hPPyjIeF88cZQvjC/nYpYntnA+kCgYEA9vh4f6WPVQUcKDaf5hTDCcd/S/eR9FyYLRgCKfYrK+ZT3sEs4AWeNX/P1APwwtiNxytX+GnlzvMMjbYEcR0TByGcYVWmQS4epKT0zBszTAMP2mXRkl6aUa4C9pbb2Lh9qRCCfk3yLLDnMipnNG+KuEbyFB+TlPUghAidQIJoj2MCgYEA6ScZfVVdScJZCmhUTXnqZoEAkb7r9vkNOpRZQ4dSJJcUk6oDYRFWd6adZjeMvS7JKq4XDIPJfDC6+TzZrhd9YXhpvfq2R6xp81nEZ6P3Fs2Tcjv8pXZ9hrQVaaTVXBDwiz054iTG83pnSi/kk1/9hktA6KkPaOG+/DUsAguKU8MCgYAzevW7PeqTwV3uL/zCvB8vwasSTcfZ1RdPhwqkbpDvNLLU4xWUmPcylbLfsfaU1wkutCVBPenOarF6NK/WWEYoHWR4kZ73RULT9SKmDSFzPcwnLUQzK48laY1qk2W+Vi6zeCKLa3oIwNNgjKA4uOuEoB1D/pUH3tTpUNZepRBgmwKBgGTnSg3HAv+n/7cUXd/F8p74F5H8Cc0yDfqbN2KVTwSM6hfaDWpWAZD458fUJLG/bMpu24TMCEgaIuE455CDk/y6CzFwLrEoOhZadDjSal5RDA31Tish88N3bojxEHGu1xu7nLB1cDDxeYBO5+KsOWGEcgv/Fq8ye+BU9r3P1sbXAoGBAPCE2pqZz1SnsYan3Ac6Es6dXoejyHGxQFk2AdoWUe2hAP2guoihhBykirY0xcNJZc3Qa/pnLY7YZH+iI3gPizwlDMSW2FT4tFCdf9pZdZZJUcXFRwfl867doWoUobXC11bTjPSKrtmcroE4Tx6fy7QDPnISFW/A401Jn1lJKOJC"
                        , "json",
                        "UTF-8",
                        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh1HvNLpz2MEa6Sqqu4s1ncmONhPJlZsBrQnx+U4gNc4YpgOIp3gRqlGL4yTGo68Spa5TIiqFN32lpiGxa89v51Xzpvj/ZTT6ktAa/dY9S3LLUYJmLGj6gwMKIesKmsa5uCBPBP10PNHbku0OPfzlcPfAzij8GrDidpdrhlP0aPvYi5ASG+uG7avYAthW+Llr/bwW0JVVeK1JedUVRTlk3CzQhVhb+otNrN/0jEy8KLTaj5Q2dZDgAEiH3VlGhju+FpaSAjstVSgQfoYvf+KB9YrfMtKs3UkdAynGHrtrQdr1MSgNhk8X72gDJsLK1/x05WsAg3l9/Bm/09BG9ZPOuQIDAQAB",
                        "RSA2");
        AlipayDataDataserviceBillDownloadurlQueryRequest request
                = new AlipayDataDataserviceBillDownloadurlQueryRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"bill_type\":\"trade\"," +
                "    \"bill_date\":\"" + time + "\"}"); //设置业务参数
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        System.out.println(response.getBody());
        System.out.println(response.getBillDownloadUrl());
        download(response.getBillDownloadUrl(),time);
    }

    public void download(String urlStr,String fileName) {
        //   String urlStr = "http://dwbillcenter.alipay.com/downloadBillFile.resource?bizType=X&userId=X&fileType=X&bizDates=X&downloadFileName=X&fileId=X";
//指定希望保存的文件路径
        String filePath = "/Users/ruo/Downloads/fund_bill_" + fileName + ".zip";
        URL url = null;
        HttpURLConnection httpUrlConnection = null;
        InputStream fis = null;
        FileOutputStream fos = null;
        try {
            url = new URL(urlStr);
            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setConnectTimeout(5 * 1000);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.setRequestProperty("Charsert", "UTF-8");
            httpUrlConnection.connect();
            fis = httpUrlConnection.getInputStream();
            byte[] temp = new byte[1024];
            int b;
            fos = new FileOutputStream(new File(filePath));
            while ((b = fis.read(temp)) != -1) {
                fos.write(temp, 0, b);
                fos.flush();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
                if (httpUrlConnection != null) httpUrlConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




//    public  Map<String,String> getUserId(String code ,String appId){
//
//        PayCanAccount mainAccount = payAccountService.getAccountByUserId(
//                String.valueOf(appId));
//
//
//        PayChannel channel = payChannelService.getChannel(String.valueOf(mainAccount.getChannelId()));
//        String param = channel.getParam();
//        Map<String, String> mapParam = new Gson().fromJson(param, Map.class);
//
//        AlipayClient alipayClient =
//                new DefaultAlipayClient(
//                        channel.getGateway(),
//                        mainAccount.getUserId(),
//                        mainAccount.getToken()
//                        , mapParam.get("format"),
//                        mapParam.get("charset"),
//                        mainAccount.getExtra(),
//                        mapParam.get("signType"));
//
//
//        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
//        request.setCode(code);
//        request.setGrantType("authorization_code");
//        Map<String,String> map=new HashMap<>();
//        try {
//            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
//            System.out.println(oauthTokenResponse.getAccessToken());
//            map.put("alipayUserId",oauthTokenResponse.getAlipayUserId());
//            map.put("userId",oauthTokenResponse.getUserId());
//            map.put("info",oauthTokenResponse.getBody());
//        } catch (AlipayApiException e) {
//            //处理异常
//            e.printStackTrace();
//        }
//
//
//
//        return  map;
//    }

}
