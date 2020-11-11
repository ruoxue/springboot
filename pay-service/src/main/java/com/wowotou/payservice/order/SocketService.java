//package com.wowotou.payservice.order;
//
//
//import com.wowotou.model.entity.MiOrderPay;
//import com.wowotou.payservice.annotation.APIShow;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * socket
// */
//@APIShow(value = "socket")
//@Service
//public class SocketService implements IOrderService {
//
//
//
//    @Override
//    public Map<String, String> getCodeUrl(MiOrderPay queue) {
//       // messageEventHandler.sendBuyLogEvent(String.valueOf(queue.getId()));
//
//
//        String url = getUrl(queue.getId(), 0);
//        Map<String, String> map = new HashMap<>();
//        map.put("url", url);
//        map.put("code", "1");
//        return map;
//    }
//
//    @Override
//    public void query(QueryModel map) {
//
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
//    public Map<String, String> login(NeedLoginModel param) {
//
//
//
//
//
//        return null;
//    }
//
//    @Override
//    public Map<String, String> sendLoginSms(NeedLoginModel param) {
//        return null;
//    }
//
//    @Override
//    public String payNotify(Map<String, String> params,String ip) {
//
//        try {
//
//            String out_trade_no = new String(params.get("mark").
//                    getBytes("ISO-8859-1"),
//                    "UTF-8");
//            //支付宝交易号
//
//            String trade_no = new String(params.get("no").getBytes("ISO-8859-1"),
//                    "UTF-8");
//
//            //交易状态
//            String trade_status = new String(params.get("trade_status")
//                    .getBytes("ISO-8859-1"), "UTF-8");
//
//            String sign=params.get("sign");
//
//            params.remove("sign");
//
//           String sign2= com.mfypay.service.util.Md5.md5(com.mfypay.service.util.MapUtil.getParamStr(params));
//
//            boolean verify_result =sign.equalsIgnoreCase(sign2);
//
//            if (verify_result && trade_status.equals("SUCCESS")) {
//                payOrderService.resultSuccess(out_trade_no,trade_no,trade_no,params.get("userId"),params.get("extra"),ip);
//
//                return params.get("mark");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "err";
//
//
//    }
//
//    @Override
//    public Map<String, String> addAccount(Map<String, String> request) {
//        String userId = request.get("userId");
//        Map<String, String> ret = new HashMap<>();
//        AdminModel adminModel = adminService.getAdminByToken(request.get("token"));
//        if (adminModel == null) {
//            ret.put("code", "0");
//            ret.put("msg", "账号不存在");
//            return ret;
//        }
//
//
//        PayCanAccount account = payAccountService.getAccountByUserSingleUseId(userId);
//        MsgModel msgModel = new MsgModel();
//        if (account == null) {
//
//        } else {
//
//
//        }
//
//
//
//
//
//
//        return ret;
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
//    private String getUrl(String  qId, int time) {
//
//        MiOrderPay queuebyId = payQueueService.getQueuebyId(qId);
//        String url = queuebyId.getPay_url();
//        if (url != null && !"".equalsIgnoreCase(url)) {
//            return url;
//        }
//        if (time > 10) {
//            return url;
//        }
//        try {
//            Thread.sleep(1 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return getUrl(qId, time + 1);
//
//
//    }
//
//
//}
