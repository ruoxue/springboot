//package com.wowotou.payservice.order;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.wowotou.model.entity.MiOrderPay;
//import com.wowotou.model.entity.MiPayAccount;
//import com.wowotou.model.entity.MiPayChannel;
//import com.wowotou.payservice.annotation.APIShow;
//import com.wowotou.payservice.nx.ListBean;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 浙江农信
// * IOrderService
// */
//@APIShow(value = "浙江农信")
//@Service
//public class ZjNxService  implements  IOrderService{
//
//
//    @Override
//    public Map<String, String> getCodeUrl(MiOrderPay queue, MiPayAccount miPayAccount, MiPayChannel miPayChannel) {
//        return null;
//    }
//
//    @Override
//    public void query(MiOrderPay map) {
//
//        String extra = map.getInfo();
//        String query = extra.trim();
//        if (query.indexOf("?") != -1) {
//            query = query.split("\\?")[1];
//        }
//
//        String[] split = query.split("&");
//
//
//        Date date = new Date();
//        if (date.getHours() == 0 && date.getMinutes() < 1 && date.getSeconds() < 20) {
//            date.setMinutes(-3);
//        }
//
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        String format = simpleDateFormat.format(date);
//
//        StringBuilder sb = new StringBuilder();
//        for (String s : split) {
//
//            String[] split1 = s.split("=");
//            if (split1.length > 1) {
//
//                if (split1[0].indexOf("endDate") != -1 || split1[0].indexOf("startDate") != -1) {
//                    sb.append(split1[0]).append("=").append(format).append("&");
//                } else if (split1[0].indexOf("pageSize") != -1) {
//                    sb.append(split1[0]).append("=").append(String.valueOf(map.getPage())).append("&");
//                } else {
//                    sb.append(split1[0]).append("=").append(split1[1]).append("&");
//                }
//            }
//
//
//        }
//
//        if (sb == null || sb.length() == 0) {
//            System.out.println(map + ":参数null");
//            return;
//        }
//
//        // order=desc&limit=10&page=1&sort=id&search=&token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXlsb2FkIjp7ImlkIjo2NDQzMywic2hvcG5hbWUiOiJcdTU5MjlcdTU5MjlcdTU1NDZcdThkODUiLCJ1bmFtZSI6IlZJUFx1NzUyOFx1NjIzNyIsInVsZXZlbCI6NiwibWNoaWQiOiIwMDAxMDAwMTAwMDAwMDA0MTIwNiIsInBob25lIjoiMTM1MDE4Nzc4MTYiLCJpc3ZlcmZpeSI6MSwibWFjIjoiNjE0Njc2MzkwNDk0NTMyIn0sImlhdCI6MTU1NDY0NTY5MCwiZXhwIjoxNTU1MjUwNDkwfQ
//        String url = "https://o2o.zj96596.com/bmp/qryEWMTransFlowWater.do?" + StringEscapeUtils.unescapeHtml4(sb.substring(0, sb.length() - 1).toString());
//        System.out.println(url);
//        if (map.getToken() == null || "".equalsIgnoreCase(map.getToken())) {
//            return;
//        }
//
//
//        String s = NetUtil.GetObjCookie(url, map.getToken()," Mozilla/5.0 (iPhone; CPU iPhone OS 12_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148");
//        System.out.println(s);
//        if (s.indexOf("jsonError") != -1) {
//
//            return;
//        }
//
//
//        RetModel baseModel = JSONObject.parseObject(s, RetModel.class);
//
//        if (baseModel == null) {
//            return;
//        }
//
//
//        if (baseModel.getResultMap().getResultCode().equalsIgnoreCase("200") && "查询成功".equalsIgnoreCase(baseModel.getResultMap().getRspMsg())) {
//
//            List<ListBean> list = baseModel.getResultMap().getList();
//
//
//            for (ListBean bean : list) {
//
//                if (!bean.getResDesc().trim().equalsIgnoreCase("交易成功")) {
//                    continue;
//                }
//
//                Map<String, String> param = new HashMap<>();
//                param.put("money", String.valueOf(bean.getTradeAmount()));
//                param.put("mark", String.valueOf(bean.getRemark()));
//                param.put("queueChannel", bean.getTxnSeqId().replace("订单编号:", "").trim());
//                param.put("no", bean.getTxnSeqId().replace("订单编号:", "").trim());
//                param.put("userId", map.getUserId());
//                param.put("time", String.valueOf(0));
//                try {
//                    param.put("extra", URLEncoder.encode(JSON.toJSONString(bean), "utf-8"));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//                param.put("token", map.getAdminToken());
//                param.put("appSign", "d979f620e90ddcec573ed24508227831e892e6a2");
//                Notify.notify(param, payMissOrderService);
//
//
//            }
//
//
//        }
//    }
//
//    @Override
//    public Map<String, String> query(int id,String ip) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> bindMainAccount(int id) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> unBindMainAccount(int id) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> login(MiPayAccount miPayAccount) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> sendLoginSms(MiPayAccount param) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> login(NeedLoginModel param) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> sendLoginSms(NeedLoginModel param) {
//        return null;
//    }
//
//
//    @Override
//    public String payNotify(Map<String, String> request,String ip) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> addAccount(Map<String, String> request) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> updateAccount(Map<String, String> request) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> orderSettle(String mark, String tradeNo) {
//        return null;
//    }
//
//
//}
