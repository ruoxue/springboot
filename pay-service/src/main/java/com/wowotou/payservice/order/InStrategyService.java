//package com.wowotou.payservice.order;
//
//import com.mfypay.dao.dao.AdminDao;
//import com.mfypay.dao.dao.PayAccountDao;
//import com.mfypay.dao.dao.PayMissOrderDao;
//import com.mfypay.model.NeedLoginModel;
//import com.mfypay.model.model.*;
//import com.mfypay.pay.annotation.APIShow;
//import com.mfypay.service.service.AdminService;
//import com.mfypay.service.service.PayMissOrderService;
//import com.mfypay.service.service.PayOrderService;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@APIShow(value = "InStrategy")
//@Service(value = "InStrategy")
//public class InStrategyService implements IOrderService {
//    @Resource
//    private AdminService adminService;
//    @Resource
//    PayOrderService payOrderService;
//    @Resource
//    private PayMissOrderService payMissOrderService;
//
//    @Resource
//    PayAccountDao payAccountDao;
//
//    @Override
//    public Map<String, String> getCodeUrl(QueueType queue) {
//        return null;
//    }
//
//    @Override
//    public void query(QueryModel map) {
//
//    }
//
//    @Override
//    public Map<String, String> query(int id, String ip) {
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
//        return null;
//    }
//
//    @Override
//    public Map<String, String> sendLoginSms(NeedLoginModel param) {
//        return null;
//    }
//
//    @Override
//    public String payNotify(Map<String, String> params, String ip) {
//
//        String sign2 = com.mfypay.service.util.Md5.md5(com.mfypay.service.util.MapUtil.getParamStr(params));
//        String sign = params.get("sign");
//
//        params.remove("sign");
//        boolean verify_result = sign.equalsIgnoreCase(sign2);
//        if (!verify_result){
//            System.out.println("{\"code\":0}");
//
//        }
//
//        try {
//            long pub_time=System.currentTimeMillis();
//            try {
//                pub_time=Long.valueOf(params.get("pub_time"));
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//            String out_trade_no = params.get("mark");
//            PayCanAccount account = null;
//
//
//            if (out_trade_no == null || "".equalsIgnoreCase(out_trade_no) ||
//                    "".equalsIgnoreCase(out_trade_no.trim()) ||
//                    "null".equalsIgnoreCase(out_trade_no.trim())) {
//
//                long times = pub_time/1000;
//
//                String token = (params.get("token"));
//
//                AdminModel adminModel = adminService.getAdminByToken(token);
//                if (adminModel == null) {
//                    return "err2";
//                }
//                Map<String,String> param=new HashMap<>();
//                param.put("userId",params.get("userId"));
//                account=payAccountDao.getAccountByUserId(param);
//                if (account==null){
//                    return  "账号不存在" ;
//                }
//
//                PayQueue payQueue = payOrderService.getStrategyQueue(Double.valueOf(params.get("money")),
//                        times, adminModel.getId(), params.get("userId"), account.getUnit());
//
//
//                if (payQueue == null ) {
//
//
//                    Map<String, String> map = new HashMap<>();
//                    //mark,channelOrderId,userId,extra\
///**
// * extra {"actions":[{"name":"","url":""},{"name":"查看详情","url":"alipays://platformapi/startapp?appId=20000003
// * mark
// * money 0.02
// * no 20200520200040011100980021175417
// * pub_time 1589956200000
// * sign 9ef4e0b86ae12e1c507d82f060646371
// * token 6
// * tradeNO 20200520200040011100980021175417,20200520200040011100980021175417,20200520200040011100980021175417
// * trade_status SUCCESS
// * userId 2088531877295146
// * username null
// */
//
//                    map.put("mark", params.get("no") );
//                    map.put("channelOrderId", params.get("no"));
//                    map.put("userId", account.getUserId());
//                    map.put("extra", params.get("extra"));
//                    map.put("ip", ip);
//                    map.put("money",params.get("money"));
//                    map.put("mTime",String.valueOf(times));
//                    map.put("cTime",String.valueOf(pub_time));
//                    payMissOrderService.addMissOrder(map);
//
//
//                    return "e";
//                }
//
//
//
//
//
//
//                out_trade_no = payQueue.getMark();
//            }
//            //支付宝交易号
//
//            String trade_no = new String(params.get("no").getBytes("ISO-8859-1"),
//                    "UTF-8");
//
//            //交易状态
//            String trade_status = new String(params.get("trade_status")
//                    .getBytes("ISO-8859-1"), "UTF-8");
//
//
//
//
//
//            if ( trade_status.equals("SUCCESS")) {
//                payOrderService.resultSuccess(out_trade_no, trade_no, trade_no,
//                        account.getUserId(), params.get("extra"), ip);
//
//                return params.get("mark");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "err4";
//
//
//
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
//}
