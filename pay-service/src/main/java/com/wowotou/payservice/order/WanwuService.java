//package com.wowotou.payservice.order;
//
//import com.mfypay.common.util.StringUtils;
//import com.mfypay.model.NeedLoginModel;
//import com.mfypay.model.model.QueryModel;
//import com.mfypay.model.model.QueueType;
//import com.mfypay.pay.annotation.APIShow;
//import com.mfypay.pay.service.wanwu.Wanwu;
//import com.mfypay.pay.util.StrUtil;
//import com.mfypay.service.service.PayAccountService;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//import java.util.logging.Logger;
//
//@APIShow(value = "Wanwu")
//@Service(value = "Wanwu")
//public class WanwuService implements  IOrderService {
//    private Logger logger=Logger.getLogger(WanwuService.class.getSimpleName());
//    @Resource
//    Wanwu wanwu;
//    @Resource
//    PayAccountService payAccountService;
//    @Override
//    public Map<String, String> getCodeUrl(QueueType queue) {
//
//      int i=  wanwu.recharge(queue.getId(),queue.getUserId()
//                ,queue.getMark(),queue.getDeviceNum(),
//              queue.getChannelId(),queue.getTradeMoney(),
//                queue.getAccountToken(),null);
//        Map<String,String> ret=new HashMap<>();
//        ret.put("code",""+i);
//        return ret;
//    }
//
//    @Override
//    public void query(QueryModel map) {
//wanwu.query(map);
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
//
//
//    public  Map<String,String> sendLoginSms(NeedLoginModel param){
//
//
//        if (param.getVerTime()>System.currentTimeMillis()/1000-10*60){
//            return null;
//        }
//
//
//        String userId=param.getMobileNumber();
//        String deviceNum = param.getDeviceNum();
//        if (StringUtils.isEmpty(deviceNum))
//        {
//            deviceNum= UUID.randomUUID().toString();
//            payAccountService.updateDeviceNum(deviceNum,userId);
//        }
//        Map<String,String> proxy=new HashMap<>();
//        proxy.put("ip",param.getIp());
//        proxy.put("port",param.getPort());
//        wanwu.sendLoginSms(userId,param.getMobileNumber(),deviceNum,
//                Integer.valueOf(param.getChannelId()),proxy);
//
//
//        return  null;
//    }
//
//    @Override
//    public Map<String, String> login(NeedLoginModel param) {
//
//        String userId=param.getUserId();
//        String verCode=param.getVerCode();
//
//        if (StringUtils.isEmpty(verCode)){
//            logger.info(String.format("{0}验证吗不存在",userId));
//            return  null;
//        }
//
//        String deviceNum = param.getDeviceNum();
//        if (StringUtils.isEmpty(deviceNum))
//        {
//            deviceNum= UUID.randomUUID().toString();
//            payAccountService.updateDeviceNum(deviceNum,userId);
//        }
//
//
//        Map<String,String> proxy=new HashMap<>();
//        proxy.put("ip",param.getIp());
//        proxy.put("port",param.getPort());
//
//        wanwu.login(userId,param.getMobileNumber(),verCode,deviceNum,
//                Integer.valueOf(param.getChannelId()),proxy);
//
//
//
//
//
//
//
//
//
//        return null;
//    }
//
//    @Override
//    public String payNotify(Map<String, String> request, String ip) {
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
//}
