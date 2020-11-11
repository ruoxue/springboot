//package com.wowotou.payservice.service;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.google.gson.Gson;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///***
// *
// */
//public class ZhuanZhuan {
//
//
//    public Map<String,String>  getLinkByQueue(QueueType queue, PayQueueService service) {
//        PayCanAccount saleAccount = service.getAccountByUserId(queue.getUserId());//卖家
//        PayCanAccount buyAccount = service.getAccountByUserId(queue.getToUserId());//买家
//        ZhuanGoodsModel.RespDataEntity goods = getGoods(saleAccount, queue.getTradeMoney(), 0);
//
//        ZhuanOrderModel order = new ZhuanZhuan().createOrder(goods, buyAccount);
//        System.out.println(order);
//        Map<String,String> ret=new HashMap<>();
//        if (!order.getRespData().equals("0")){
//            ret.put("orderId","订单空");
//        }
//
//
//        ZhuanPayMethodModel.RespDataEntity.PayInfoConfigListEntity payInfoConfigListEntity = new ZhuanZhuan().getpayMethod(order.getRespData().getPayId(), queue.getSubType(), buyAccount);
//        System.out.println(payInfoConfigListEntity);
//        if (payInfoConfigListEntity==null){
//            ret.put("orderId","地址空");
//        }
//
//        String pay = new ZhuanZhuan().pay(order, payInfoConfigListEntity, buyAccount,queue.getSubType());
//
//
//        ret.put("link",pay);
//        ret.put("mark",order.getRespData().getPayId());
//        ret.put("orderId",order.getRespData().getOrderId());
//        ret.put("money",order.getRespData().getActualPayMoney());
//
//
//       return  ret;
//    }
//
//
//    /**
//     * 获取符合的商品
//     *
//     * @param saleAccont
//     * @param tradeMoney
//     */
//    public ZhuanGoodsModel.RespDataEntity getGoods(PayCanAccount saleAccont, double tradeMoney, int page) {
//
//
//        String url = "https://app.zhuanzhuan.com/zzmerchant/transfer/getmyinfos?length=10&status=0&offset=0";
//        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
//        multiValueMap.add("length", "10");
//        multiValueMap.add("status", "0");
//        multiValueMap.add("offset", String.valueOf(page));
//        try {
//            String ret = NetUtil.POST(url, multiValueMap, saleAccont.getExtra());
//            ZhuanGoodsModel zhuanGoodsModel = new Gson().fromJson(ret, ZhuanGoodsModel.class);
//            if (zhuanGoodsModel == null || !zhuanGoodsModel.getRespCode().equalsIgnoreCase("0")) {
//                return null;
//            }
//            if (zhuanGoodsModel.getRespData().isEmpty()) {
//                return null;
//            }
//            for (ZhuanGoodsModel.RespDataEntity entity : zhuanGoodsModel.getRespData()) {
//                if (entity.getStatus().equalsIgnoreCase("1") && tradeMoney == Double.parseDouble(entity.getNowPrice())) {
//                    return entity;
//                }
//            }
//
//
//            if (zhuanGoodsModel.getRespData().size() == 10) {
//                page++;
//                return getGoods(saleAccont, tradeMoney, page);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//
//    }
//
//
//    public ZhuanUserInfoModel getUserInfo(PayCanAccount buyAccount) {
//        Map<String, String> map = MapUtil.Str2Map(buyAccount.getExtra().toLowerCase());
//        String uid = map.get("uid");
//        String url = "https://app.zhuanzhuan.com/zz/transfer/query?getUid=" + uid;
//        try {
//            return  new Gson().fromJson(NetUtil.GetObjCookie(url, buyAccount.getExtra(), " Mozilla/5.0 (iPhone; CPU iPhone OS 12_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 58zhuanzhuan"), ZhuanUserInfoModel.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    public ZhuanOrderModel createOrder(ZhuanGoodsModel.RespDataEntity goods, PayCanAccount buyAccount) {
//
//        ZhuanUserInfoModel userInfo = getUserInfo(buyAccount);
//        if (userInfo == null) {
//            return null;
//        }
//        System.out.println(userInfo);
//
//
//        String url = "https://app.zhuanzhuan.com/zzx/transfer/createOrder";
//
//        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
//
//        multiValueMap.add("saleIds", "");
//        multiValueMap.add("pointInfos", "");
//        multiValueMap.add("metric", goods.getMetric());
//        multiValueMap.add("mutiProduct", "1");
//
//        multiValueMap.add("payActionType", "1");
//        multiValueMap.add("supportCent", "1");
//        multiValueMap.add("shoppingCart", "null");
//        multiValueMap.add("packIds", "");
//
//        JSONObject product = new JSONObject();
//        product.put("infoId", goods.getInfoId());
//        product.put("infoNum", "1");
//        product.put("metric", goods.getMetric());
//        product.put("serviceList", new ArrayList<>());
//
//        List<JSONObject> array = new ArrayList<>();
//        array.add(product);
//        multiValueMap.add("address", JSONObject.toJSONString(userInfo.getRespData().getAddressDetail()));
//        multiValueMap.add("productStr", JSONObject.toJSONString(array));
//        multiValueMap.add("addressId", userInfo.getRespData().getAddressDetail().getId());
//
//        try {
//            String s1 = NetUtil.POST(url, multiValueMap,
//                    buyAccount.getExtra());
//            ZhuanOrderModel zhuanOrderModel = new Gson().fromJson(s1, ZhuanOrderModel.class);
//            //  ZhuanPayMethodModel zhuanPayMethodModel = getpayMethod(zhuanOrderModel.getRespData().getPayId(), type);
//            return zhuanOrderModel;
//
//
//            //  pay(zhuanOrderModel.getRespData().getPayId(), zhuanOrderModel.getRespData().getActualPayMoney_f(), zhuanPayMethodModel);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//
//    }
//
//
//    public String pay(ZhuanOrderModel orderModel, ZhuanPayMethodModel.RespDataEntity.PayInfoConfigListEntity zhuanPayMethodModel, PayCanAccount buyAccount,int type) {
//
//        if (orderModel.getRespData().getStatus().equalsIgnoreCase("1")) {
//
//
//            String url = "https://zhuan.58.com/zz/transfer/saveCashierDeskInfo";
//
//            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//
//            map.add("mchId", "1001");
////            map.add("payId", "1198957498443657387");
//              map.add("payId", orderModel.getRespData().getPayId());
//            //
//            map.add("payList", "[{\"money\":\"" + orderModel.getRespData().getActualPayMoney_f() + "\",\"payMethod\":\"" + zhuanPayMethodModel.getPayMethod() + "\",\"tradeType\":\"" + zhuanPayMethodModel.getTradeType() + "\",\"extendParam\":{\"cmbToken\":\"\",\"payConfigId\":\"" + zhuanPayMethodModel.getPayConfigId() + "\",\"frontEndType\":\"3\",\"appName\":\"转转官网\",\"appBundleId\":\"https://m.zhuanzhuan.58.com\",\"instalmentNum\":0}}]");
//            map.add("reqSource", "1");
////map.add("payList","[{\"money\":\"175000\",\"payMethod\":\"2\",\"tradeType\":\"ALI_PC2\",\"extendParam\":{\"frontEndType\":\"3\",\"payConfigId\":\"23\"}}]");
//
//            try {
//                String ret = NetUtil.POST(url, map, buyAccount.getExtra());
//                System.out.println(ret);
//                ZhuanPayModel zhuanPayModel =  new Gson().fromJson(ret, ZhuanPayModel.class);
//                if (zhuanPayModel.getRespCode().equalsIgnoreCase("0")) {
//                 if (type<3)
//                    return zhuanPayModel.getRespData().getThirdPayInfodata().get(0).getPayData().getForm();
//                 else
//                     return ret;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }
//
//
//    public ZhuanPayMethodModel.RespDataEntity.PayInfoConfigListEntity getpayMethod(String payId, int type, PayCanAccount buyAccount) {
//
//
//        String url = "https://app.zhuanzhuan.com/zz/transfer/queryPayMethod?payId=" + payId + "&mchId=1001&t=" + System.currentTimeMillis() + "&reqSource=1";
//        String s = NetUtil.GetObjCookie(url,
//                buyAccount.getExtra().replaceAll("t=37", "t=15").replaceAll("t=25", "t=15")
//                , "Mozilla/5.0 (iPhone; CPU iPhone OS 12_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148");
//
//        ZhuanPayMethodModel zhuanPayMethodModel =  new Gson().fromJson(s, ZhuanPayMethodModel.class);
//        List<ZhuanPayMethodModel.RespDataEntity.PayInfoConfigListEntity> payInfoConfigList = zhuanPayMethodModel.getRespData().getPayInfoConfigList();
//
//        for (ZhuanPayMethodModel.RespDataEntity.PayInfoConfigListEntity entity : payInfoConfigList) {
//            if (type == 1 || type == 2) {
//                if (entity.getGeneralConfig().getPayTypeTitle().equalsIgnoreCase("支付宝支付")) {
//                    return entity;
//                }
//            }
//            if (type == 3 || type == 4) {
//                if (entity.getGeneralConfig().getPayTypeTitle().equalsIgnoreCase("微信支付")) {
//                    return entity;
//                }
//            }
//        }
//
//        return null;
//    }
//
//
//}
