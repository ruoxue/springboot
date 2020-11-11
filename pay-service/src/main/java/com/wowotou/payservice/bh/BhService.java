package com.wowotou.payservice.bh;//package com.mfypay.pay.bh;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.TypeReference;
//import com.mfypay.pay.hhh.BaseModel;
//import com.mfypay.service.util.NetUtil;
//import com.mfypay.model.model.PayCanAccount;
//import com.mfypay.model.model.PayQueue;
//import com.mfypay.service.service.PayAccountService;
//import com.mfypay.service.service.PayQueueService;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.DecimalFormat;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//@Service
//public class BhService {
//    @Autowired
//    PayAccountService payAccountService;
//
//    @Autowired
//    PayQueueService payQueueService;
//
//    /**
//     * login
//     *
//     * @param accountId
//     * @return
//     */
//    public Map<String, String> login(int accountId) {
//        Map<String, String> map = new HashMap<>();
//        PayCanAccount account = payAccountService.getAccountById(String.valueOf(accountId));
//        if (account != null) {
//            String url = "http://api.shanglianchuangfu.com/app-login";
//            Map<String, String> param = new HashMap<>();
//
//            param.put("_mchid", "00010001");
//            param.put("username", account.getUserId().substring(2));
//            param.put("password", account.getPayPwd());
//            param.put("mac", String.valueOf(new Random().nextInt(1000000000)));
//            System.out.println(param);
//            String s = NetUtil.POSTObj(url, param);
//            BaseModel<BhLoginBean> model = JSONObject.parseObject(s, new TypeReference<BaseModel<BhLoginBean>>() {
//            });
//            if (model.getCode() == 1) {
//                payAccountService.updateToken(model.getData().getToken(), accountId, JSONObject.toJSONString(model.getData()), model.getData().getShopname());
//
//                map.put("code", "ok");
//            }
//
//
//        }
//
//
//        return map;
//    }
//
//
//    public Map<String, String> getCodeUrl(int queueId) {
//
//
//        PayQueue payQueue = payQueueService.getQueuebyId(queueId);
//
//
//        Map<String, String> ret = new HashMap<>();
//
//        if (payQueue == null) {
//            ret.put("code", "0");
//            ret.put("msg", queueId + "不存在");
//            return ret;
//        }
//        PayCanAccount account = payAccountService.getAccountById(String.valueOf(payQueue.getaId()));
//        if (account != null && account.getStatus() == 1) {
//            Map<String, String> map = new HashMap<>();
//
//
//            DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
//            map.put("price", decimalFormat.format((payQueue.getTradeMoney())));
//            map.put("access_token", account.getToken());
//
//            JSONObject extra = JSONObject.parseObject(StringEscapeUtils.unescapeHtml4(account.getExtra()));
//
//            map.put("_mchid", extra.getString("mchid").substring(0, 8));
//            String url = null;
////1001
//            url = "http://api.shanglianchuangfu.com/app-channel/pay";
//
//            Map<String, String> channel = getPayChannel(account, payQueue.getSubType());
//            map.put("paykind", channel.get("id"));
//            map.put("code", channel.get("code"));
//
//
//            String s = NetUtil.POSTObj(url, map);
//
//            BaseModel<BhCodeBean> baseModel = JSONObject.parseObject(s, new TypeReference<BaseModel<BhCodeBean>>() {
//            });
//            if (baseModel.getCode() == 1001) {
//                login(account.getId());
//                ret.put("code", "0");
//                return ret;
//            } else if (baseModel.getCode() == 1) {
//                ret.put("url", baseModel.getData().getUrl());
//                ret.put("thirdNo", baseModel.getData().getOrderno());
//                ret.put("code", "1");
//                ret.put("extra", JSONObject.toJSONString(baseModel.getData()));
//            }
//
//        }
//        return ret;
//    }
//
//    /**
//     * @param account
//     * @return
//     */
//    public Map<String, String> getPayChannel(PayCanAccount account, int type) {
//
//        Map<String, String> map = new HashMap<>();
//        String url = "http://api.shanglianchuangfu.com/app-channel";
//        map.put("access_token", account.getToken());
//
//        JSONObject extra = JSONObject.parseObject(StringEscapeUtils.unescapeHtml4(account.getExtra()));
//
//        map.put("_mchid", extra.getString("mchid").substring(0, 8));
//
//        String s = NetUtil.POSTObj(url, map);
//
//        BaseModel<List<BhPayChannelBean>> baseModel = JSONObject.parseObject(s, new TypeReference<BaseModel<List<BhPayChannelBean>>>() {
//        });
//        Map<String, String> ret = new HashMap<>();
//        if (baseModel.getCode() == 1) {
//
//            for (BhPayChannelBean bhPayChannelBean : baseModel.getData()) {
//
//                if (bhPayChannelBean.getIco().indexOf("alipay") != -1 && (type == 1 || type == 2)) {
//
//                    ret.put("", String.valueOf(bhPayChannelBean.getId()));
//                    ret.put("code", String.valueOf(bhPayChannelBean.getCode()));
//
//                }
//                if (bhPayChannelBean.getIco().indexOf("wechat") != -1 && (type == 3 || type == 4)) {
//                    ret.put("", String.valueOf(bhPayChannelBean.getId()));
//                    ret.put("code", String.valueOf(bhPayChannelBean.getCode()));
//
//
//                }
//                if (bhPayChannelBean.getIco().indexOf("qq") != -1 && (type == 5 || type == 6)) {
//
//                    ret.put("", String.valueOf(bhPayChannelBean.getId()));
//                    ret.put("code", String.valueOf(bhPayChannelBean.getCode()));
//
//                }
//                if (bhPayChannelBean.getIco().indexOf("upay") != -1 && (type == 7 || type == 8)) {
//                    ret.put("", String.valueOf(bhPayChannelBean.getId()));
//                    ret.put("code", String.valueOf(bhPayChannelBean.getCode()));
//
//
//                }
//
//
//            }
//
//        }
//
//
//        return ret;
//    }
//
//
//}
