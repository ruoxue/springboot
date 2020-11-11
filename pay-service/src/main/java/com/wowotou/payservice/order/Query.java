//package com.wowotou.payservice.order;
//
//import com.alibaba.fastjson.JSON;
//import com.mfypay.dao.dao.PayAccountDao;
//import com.mfypay.model.NeedLoginModel;
//import com.mfypay.model.model.QueryModel;
//import com.mfypay.pay.SpringContextUtil;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
//public class Query {
//
//
//    @Resource
//    PayAccountDao payAccountDao;
//
//    public void queryOrder() {
//        try {
//
//            List<QueryModel> maps = payAccountDao.queryNoPayOrder(
//                    System.currentTimeMillis() / 1000 - 10 * 60);
//            System.out.println(maps);
//            for (QueryModel m : maps) {
//                System.out.println(m);
//                System.out.println(JSON.toJSONString(m));
//                if (m.getApi2() != null && !"".equals(m.getApi2())) {
//                    IOrderService service  =
//                            (IOrderService) SpringContextUtil.getBean(Class.forName(m.getApi2()));
//                    service.query(m);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//    public void login(int aId) {
//        //  payAccountDao.getAccountById()
//    }
//    public void login() throws ClassNotFoundException {
//        List<NeedLoginModel> needLoginModels = payAccountDao.needLogin(-1);
//
//        if (needLoginModels==null||needLoginModels.isEmpty()){
//            return;
//        }
//
//        for (NeedLoginModel m:needLoginModels) {
//
//            if (m.getApi2() != null && !"".equals(m.getApi2())) {
//                IOrderService service  =
//                        (IOrderService)
//                                SpringContextUtil.getBean
//                                        (Class.forName(m.getApi2()));
//                service.login(m);
//            }
//
//        }
//
//
//
//
//    }
//
//
//
//    public void sendLoginSms() throws ClassNotFoundException {
//        List<NeedLoginModel> needLoginModels = payAccountDao.needLogin(-2);
//
//        if (needLoginModels==null||needLoginModels.isEmpty()){
//            return;
//        }
//
//        for (NeedLoginModel m:needLoginModels) {
//
//            if (m.getApi2() != null && !"".equals(m.getApi2())) {
//                IOrderService service  =
//                        (IOrderService)
//                                SpringContextUtil.getBean
//                                        (Class.forName(m.getApi2()));
//                service.sendLoginSms(m);
//            }
//
//        }
//
//
//
//
//    }
//
//}
