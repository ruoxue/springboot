//package com.wowotou.payservice.util;
//
//import com.alibaba.fastjson.JSON;
//
//
//import java.net.URLEncoder;
//import java.util.Map;
//
//public class Notify {
//
//
//    public static void notify(Map<String, String> param, PayMissOrderService payMissOrderService) {
//        try {
//
//            String no = param.get("no");
//
//            PayMissOrder missOrderByChannelId = payMissOrderService.getMissOrderByChannelId(no);
//
//
//            if (missOrderByChannelId != null) {
//                System.out.println("已存在");
//                return;
//            }
//
//
//
//            String mark = param.remove("mark");
//            param.put("mark", URLEncoder.encode(mark == null ? "" : mark, "utf-8"));
//            String post = NetUtil.POST("http://pay.wowotou01.com/api/app_pay/notify", param);
//
//
//            if (post.indexOf("已回调") == -1) {
//
//                LGU.D(JSON.toJSONString(param) + "====>" + post);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void notify2(Map<String, String> param, PayMissOrderService payMissOrderService) {
//        try {
//
//            String no = param.get("no");
//
//            PayMissOrder missOrderByChannelId = payMissOrderService.getMissOrderByChannelId(no);
//
//
//            if (missOrderByChannelId != null) {
//                System.out.println("已存在");
//                return;
//            }
//
//            String post = NetUtil.POST("http://pay.wowotou01.com//api/app_pay/notify", param);
//
//
//            if (post.indexOf("已回调") == -1) {
//
//                LGU.D(JSON.toJSONString(param) + "====>" + post);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
