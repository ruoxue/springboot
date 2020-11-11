//package com.wowotou.payservicecom.wowotou.api.controller//package com.mfypay.pay.com.wowotou.apicom.wowotou.api.controller
////
////import com.mfypay.pay.param.PddOrderParam;
////import com.mfypay.service.service.PayOrderService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotypecom.wowotou.api.controller
////
////@Controller(value = "/order")
////public class Order {
////
////    @Autowired
////    private PayOrderService payOrderService;
////    /**
////     * 订单回调
////     * @return
////     */
////    public  String  orderNotify(PddOrderParam param){
////if(param.getType()==0){
////
////    payOrderService.orderNotify(param);
////}else {
////
////    payOrderService.orderByMoneyNotify(param);
////}
////
////
////        return  "ok";
////    }
////}
