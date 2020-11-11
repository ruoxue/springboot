//package com.wowotou.payservice.util;
//
//import com.alibaba.fastjson.JSON;
//import com.google.gson.Gson;
//
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.*;
//
//public class Pdd {
//
//
//    /**
//     * getOrder
//     */
//
//    public static void getOrder(QueryModel map, PayMissOrderService service) {
//
//
//        String url = "https://mms.pinduoduo.com/express_waybill/shop/orderList";
//        String p = "{\"orderOnlineType\":0,\"groupEndTime\":" + System.currentTimeMillis() / 1000 + ",\"groupStartTime\":" + (System.currentTimeMillis() / 1000 - 24 * 60 * 60) +
//                ",\"pageNumber\":1,\"pageSize\":50,\"afterSaleType\":0}";
//        System.out.println(p);
//
//        Map<String, String> proxyIp = ProxyUtil.getProxyIp("北京");
//        Map<String, String> orderHeader = new HashMap<>();
//        orderHeader.put("Origin", "https://mms.pinduoduo.com");
//        orderHeader.put("Host", "mms.pinduoduo.com");
//
//        String s = FetchUtil.PostForm(url, map.getExtra(), null, p, "https://mms.pinduoduo.com/finance/payment-bills/index", orderHeader,USERAGENT.ALIPAYUA);
//        System.out.println(s);
//
//        PddOrderListModel pddOrderListModel = new Gson().fromJson(s, PddOrderListModel.class);
//
//        if (pddOrderListModel.isSuccess()) {
//
//            if (pddOrderListModel.getResult().getTotalItemNum() > 0) {
//
//
//                for (PddOrderListModel.ResultEntity.PageItemsEntity pageItemsEntity : pddOrderListModel.getResult().getPageItems()) {
//                    String orderSn = pageItemsEntity.getOrder_sn();
//
//                    PayCanAccount saleAccount = service.getAccountByUserId(map.getUserId());//卖家
//
//
//                    PayQueue queue = service.getQueueByTradeNo(orderSn);
//                    if (queue == null) {
//                        return;
//                    }
//                    PayCanAccount buyUser = service.getAccountByUserId(queue.getToUserId()); //买家
//                    if (buyUser == null) {
//                        return;
//                    }
//
//
//                    PayQueueExtraModel payQueueExtraModel = service.getQueueExtraByName(pageItemsEntity.getOrder_sn());//name
//                    if (payQueueExtraModel == null || payQueueExtraModel.getIs_deleted() == 1) {
//                        send(pageItemsEntity, map.getExtra(), buyUser, service);
//                    }
//
//                }
//
//
//            }
//
//
//        }
//
//
//    }
//
//    /**
//     * 查询收款情况
//     *
//     * @param map
//     * @param service
//     */
//    public static void queryUserDefinedBill(QueryModel map, PayMissOrderService service, String cookie) {
//
//        String url = "https://mms.pinduoduo.com/uranus/api/bill/queryUserDefinedBill";
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.HOUR_OF_DAY, 24);
//        c.set(Calendar.MINUTE, 0);
//        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND, 0);
//        long end = c.getTimeInMillis() / 1000;
//        System.out.println("3、当天凌晨(毫秒)" + end);
//
//        c.add(Calendar.DAY_OF_MONTH, -1);
//
//        long start = c.getTimeInMillis() / 1000;
//        System.out.println("4、当天凌晨(毫秒)" + start);
//        String p = "{\"classList\":[],\"groupType\":0,\"beginTime\":" + start + " ,\"endTime\":" + end + ",\"minAmount\":null,\"maxAmount\":null,\"orderSn\":null,\"offset\":0,\"limit\":20}";
//        Map<String, String> refundAddressHeader = new HashMap<>();
//        refundAddressHeader.put("Origin", "https://mms.pinduoduo.com");
//        refundAddressHeader.put("Host", "mms.pinduoduo.com");
//        Map<String, String> 北京 = ProxyUtil.getProxyIp("北京");
//
//        String s = FetchUtil.PostForm(url, cookie, 北京, p, "https://mms.pinduoduo.com/finance/payment-bills/index", refundAddressHeader,
//                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
//        System.out.println(s);
//
//        PddPayRetModel pddOrderListModel = new Gson().fromJson(s, PddPayRetModel.class);
//
//        if (pddOrderListModel.isSuccess()) {
//
//            if (pddOrderListModel.getResult().getTotal() > 0) {
//                for (PddPayRetModel.ResultEntity.DataEntity pageItemsEntity : pddOrderListModel.getResult().getData()) {
//                    if (pageItemsEntity.getType() == 1) {
//
//
//                        Map<String, String> param = new HashMap<>();
//                        param.put("money", String.valueOf(pageItemsEntity.getAmount() / 100));
//                        param.put("mark", pageItemsEntity.getOrderSn());
//                        param.put("queueChannel", pageItemsEntity.getOrderSn());
//                        param.put("no", pageItemsEntity.getRelatedId() + "");
//                        param.put("userId", pageItemsEntity.getMallId() + "");
//                        param.put("time", String.valueOf(pageItemsEntity.getCreatedAt()));
//                        try {
//                            param.put("extra", URLEncoder.encode(JSON.toJSONString(pageItemsEntity), "utf-8"));
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
//                        param.put("token", map.getAdminToken());
//                        param.put("appSign", "d979f620e90ddcec573ed24508227831e892e6a2");
//                        System.out.println(param);
//                        Notify.notify(param, service);
//
//
//                    }
//                }
//
//
//            }
//
//
//        }
//
//
//    }
//
//
//    private static void send(PddOrderListModel.ResultEntity.PageItemsEntity orderDetailModel, String cookie, PayCanAccount buyUser, PayMissOrderService service) {
//
//
//        Map<String, String> refundAddressHeader = new HashMap<>();
//        refundAddressHeader.put("Origin", "https://mms.pinduoduo.com");
//        refundAddressHeader.put("Host", "mms.pinduoduo.com");
//        String refundAddressUrl = "https://mms.pinduoduo.com/antis/api/refundAddress/list";
//        String refundAddressRet = FetchUtil.PostJson(refundAddressUrl, cookie, null, null, "https://mms.pinduoduo.com/express/expressOnline", refundAddressHeader,USERAGENT.NORMALUA);
//        System.out.println(refundAddressRet);
//
//        SalePddAddressModel salePddAddressModel = new Gson().fromJson(refundAddressRet, SalePddAddressModel.class);
//        if (!salePddAddressModel.isSuccess() || salePddAddressModel.getResult() == null || salePddAddressModel.getResult().isEmpty() || salePddAddressModel.getResult().get(0) == null) {
//            System.out.println("未设置退货地址");
//            return;
//        }
//
//        Map<String, String> mmsHeader = new HashMap<>();
//        mmsHeader.put("Origin", "https://mms.pinduoduo.com");
//        mmsHeader.put("Host", "mms.pinduoduo.com");
//        String mmsUrl = "https://mms.pinduoduo.com/express_base/shipping_list/mms";
//        String mmsRet = FetchUtil.GetJson(mmsUrl, cookie, null, "https://mms.pinduoduo.com/express/expressOnline", mmsHeader,USERAGENT.NORMALUA);
//        System.out.println(mmsRet);
//        PddMmsMOdel pddMmsMOdel = new Gson().fromJson(mmsRet, PddMmsMOdel.class);
//        if (!pddMmsMOdel.isSuccess()) {
//            System.out.println("未取到快递信息");
//            return;
//        }
//
//
//        KbReqParam kbOrderBean = new KbReqParam();
//        KbReqParam.ItemsEntity raddressEntity = new KbReqParam.ItemsEntity();
//
//        KbReqParam.InfoEntity infoEntity = new KbReqParam.InfoEntity();
//
//        KbReqParam.PostAddrItemEntity postAddrItemEntity = new KbReqParam.PostAddrItemEntity();
//
//        raddressEntity.setMsg(orderDetailModel.getReceive_name() + " , " + orderDetailModel.getReceive_mobile() + " , "
//                + orderDetailModel.getProvince_name() + " "
//                + orderDetailModel.getCity_name() + " "
//                + orderDetailModel.getDistrict_name() + " "
//                + orderDetailModel.getShipping_address() + " " + "," + " "
//                + "000000");
//
//        String sid = System.currentTimeMillis() + "";
//        infoEntity.setSid(sid);
//        infoEntity.setSign(KbUtil.MD5("xiaoming" + KbUtil.MD5("123465", "16") + sid, "32"));
//        infoEntity.setUsername("xiaoming");
//        kbOrderBean.setInfo(infoEntity);
//
//
//        PddMmsMOdel.ResultEntity resultEntity1 = new PddMmsMOdel.ResultEntity();
//
//        KdRetModel.KdPriceEntity kbCan = KbUtil.getKd();
//
//
//        for (PddMmsMOdel.ResultEntity resultEntity : pddMmsMOdel.getResult()) {
//            if (resultEntity.getShipping_name().contains(kbCan.getKdName().replace("(拼多多-专用)", ""))) {
//                resultEntity1 = resultEntity;
//            }
//        }
//
//        raddressEntity.setPid(kbCan.getKdId() + "");
//        List<KbReqParam.ItemsEntity> mList = new ArrayList<>();
//        mList.add(raddressEntity);
//
//
//        SalePddAddressModel.ResultEntity resultEntity = salePddAddressModel.getResult().get(0);
//
//
//        // {"area":"东城区","province":"北京","postPhone":"13421304686","city":"北京市","postName":"李逍遥","addr":"紫禁城"}
//        postAddrItemEntity.setAddr(resultEntity.getRefundAddress());
//        postAddrItemEntity.setArea(resultEntity.getDistrictName());
//
//        postAddrItemEntity.setPostName(resultEntity.getRefundName());
//        postAddrItemEntity.setCity(resultEntity.getCityName());
//        postAddrItemEntity.setPostPhone(resultEntity.getRefundPhone());
//        postAddrItemEntity.setProvince(resultEntity.getProvinceName());
//        kbOrderBean.setPostAddrItem(postAddrItemEntity);
//        kbOrderBean.setItems(mList);
//        kbOrderBean.setKdid(kbCan.getKdId());
//        kbOrderBean.setNum(1);
//        kbOrderBean.setKg("1");
//
//        String s = KbUtil.addKd(kbOrderBean);
//        System.out.println(s);
//
//        KbKdRetModel kbRetModel = new Gson().fromJson(s, KbKdRetModel.class);
//        if (!kbRetModel.getStatus().equals("ok")) {
//            return;
//        }
//        KbKdRetModel.KddhsEntity dataEntity = kbRetModel.getKddhs().get(0);
//
//
//        SendChatParam sendChatParam = new SendChatParam();
//
//        SendChatParam.Order_shipping_listEntity order_shipping_listEntity = new SendChatParam.Order_shipping_listEntity();
//        order_shipping_listEntity.setOrder_sn(orderDetailModel.getOrder_sn());
//        order_shipping_listEntity.setShipping_id(resultEntity1.getShipping_id() + "");
//        order_shipping_listEntity.setShipping_name(resultEntity1.getShipping_name());
//        order_shipping_listEntity.setTracking_num(dataEntity.getNum());
//
//        List<SendChatParam.Order_shipping_listEntity> listEntities = new ArrayList<>();
//        listEntities.add(order_shipping_listEntity);
//
//        sendChatParam.setOrder_shipping_list(listEntities);
//
//        String sendUrl = "https://mms.pinduoduo.com/chats/shipping";
//        Map<String, String> sendHeader = new HashMap<>();
//        sendHeader.put("Origin", "https://mms.pinduoduo.com");
//        sendHeader.put("Host", "mms.pinduoduo.com");
//        String sendRet = FetchUtil.PostForm(sendUrl, cookie, null, new Gson().toJson(sendChatParam),
//                "https://mms.pinduoduo.com/express/expressOnline", sendHeader,USERAGENT.NORMALUA);
//        System.out.println(sendRet);
//        SendChatRetModel sendRetModel = new Gson().fromJson(sendRet, SendChatRetModel.class);
//
//
//        try {
//            PayQueueExtraModel extraModel = new PayQueueExtraModel();
//            extraModel.setName(orderDetailModel.getOrder_sn());
//            extraModel.setExtra(dataEntity.getNum());
//            extraModel.setIs_deleted(0);
//            extraModel.setStatus(1);
//
//            PayQueue queueByTradeNo = service.getQueueByTradeNo(orderDetailModel.getOrder_sn());
//            if (queueByTradeNo != null) {
//                extraModel.setUid(queueByTradeNo.getuId());
//                extraModel.setmTime(System.currentTimeMillis()/1000+"");
//                extraModel.setQueueId(queueByTradeNo.getId() + "");
//                service.addQueueExtra(extraModel);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        if (sendRetModel.isResult()) {
//
//            gotoDelivery(orderDetailModel.getOrder_sn(), orderDetailModel.getGoods_id() + "", buyUser.getExtra());
//
//
//        }
//
//
//    }
//
//    /**
//     * 买家收货
//     */
//    public static void gotoDelivery(String order_sn, String goodsId, String buyCookie) {
//        Map<String, String> map = MapUtil.StrToMap(buyCookie);
//        System.out.println(map);
//
//        for (Map.Entry<String, String> e : map.entrySet()
//        ) {
//
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
//        }
//
//
//        String url = "https://mobile.yangkeduo.com/proxy/api/order/" + order_sn + "/received?pdduid=" + MapUtil.StrToMapTrim(buyCookie).get("pdd_user_id") + "&is_back=1";
//        String p = "{\"anti_content\":\"0anAfxnUXycYY9TaqWIOVxJmlBtv1Vgt_IjlhDk7ZSGYTKwfzjt_4Bbzzhhl5sAWrwjQURmcQ9tQ9KP8GCCr_1r9kH9oUAUyEqiHLRRkBE3990J9ux6coVj99p2QHKNGXs5cBJYmQVf9bK3TQcKCEXWBS43gHAcgSiditGgwYjaQBxa2yRDLlmjcoQWEwKR-qunzpry5toPgxMYGmOM1A0GTSitq4C1G1KkMqAeWneH_isD8dIgSCKtnVn2q5GVFoSSmZDD6oM8pExaBe5gukVKUM3RD8U26N07SRs13YLkmf8RVIHO1N7ReLdfPm6sz0IMINLlYKhcW1ECxDMEiGZDyg6PSOT89DCGbvoOAgr0uN30Vq9w0RIgN4x6zIDMjFCyWQt81AyCVJP5l9RvZmgaq4wxPJ1bLTCZEZil6nnFCKccwEzGcAvJs2q4wupe1Iw5tV82qTt1X3bCP3IIEKuPxTxZEN_D1nBtuEyBOr5gl5b01c0Eej55j4WSAvFtXw6VXBUXEI-3bk0ArQGjicSdx_Tv3tzPYcPg7mxIPVlB_8zHzNT-cUhw-XzH_h3Jo4MmyIyKxuNfpXQKJCjDUcUCGotrOlQ2ep9LWq6Yc2xOfJlI-bzZFryRYLr9KT1I29\"}";
//
//        Map<String, String> header = new HashMap<>();
//        header.put("AccessToken", MapUtil.StrToMapTrim(buyCookie).get("PDDAccessToken"));
//        header.put("Origin", " https://mobile.yangkeduo.com");
//        header.put("Host", "cmta.yangkeduo.com");
//
//        String s = FetchUtil.PostForm(url, buyCookie, null, p,
//                "https://mobile.yangkeduo.com/order.html?order_sn=" + order_sn
//                        + "&refer_page_name=my_order&refer_page_id=10032_1559633809791_7xRmNCRtwU&refer_page_sn=10032&page_id=10038_1559633933143_qqlZkNbj08&is_back=1"
//                ,
//                header,USERAGENT.ALIPAYUA);
//
//        BuyOrderModel buyOrderModel = new Gson().fromJson(s, BuyOrderModel.class);
//        if (buyOrderModel.getServer_time() > 0) {
//            comment(order_sn, goodsId, buyCookie);
//        }
////        comment();
//
//
//    }
//
//
//    public static void comment(String order_sn, String goodsId, String buyCookie) {
//        String url = "http://apiv4.yangkeduo.com/v2/order/goods/review?pdduid=" + MapUtil.StrToMapTrim(buyCookie).get("pdd_user_id");
//        System.out.println(url);
//        CommentModel commentModel = new CommentModel();
//        Map<String, String> header = new HashMap<>();
//
//        header.put("AccessToken", MapUtil.StrToMapTrim(buyCookie).get("PDDAccessToken"));
//        header.put("Origin", " https://mobile.yangkeduo.com");
//        header.put("Host", "cmta.yangkeduo.com");
//        commentModel.setGoods_id(goodsId);
//        commentModel.setOrder_sn(order_sn);
//
//
//        String s = FetchUtil.PostForm(url, buyCookie, null, new Gson().toJson(commentModel),
//                "https://mobile.yangkeduo.com/orders.html?page_id=10032_1563375302751_2UJWGfB9JX&order_index=0&is_back=1&type=0", header,USERAGENT.NORMALUA);
//        System.out.println(s);
//
//
//    }
//
//
//}
