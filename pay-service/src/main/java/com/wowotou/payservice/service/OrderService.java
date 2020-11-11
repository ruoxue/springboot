package com.wowotou.payservice.service;

import com.wowotou.common.LogUtil;
import com.wowotou.model.entity.*;
import com.wowotou.payservice.factory.ServiceFactory;
import com.wowotou.payservice.order.IOrderService;
import com.wowotou.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class OrderService {

    @Resource
    MiPayAccountService miPayAccountService;
    @Resource
    MiOrderPayService miOrderPayService;
    @Resource
    MiOrderService miOrderService;
    @Resource
    MiPayChannelService miPayChannelService;
    @Resource
    MiChannelTypeService miChannelTypeService;

    public void createOrder(String orderId, String uid
            , Double amount, short type, String orderdate
    ) {

        MiOrder exist = miOrderService.queryByOrderId(orderId, uid);
        if (exist != null) {
            LogUtil.log("order is exist orderId=>" + exist.getOrderid());
            //   logger.warning("order is exist orderId=>"+exist.getOrderid());
            return;
        }

        //写order

        MiOrder miOrder = new MiOrder();

        miOrder.setUid(uid);
        miOrder.setOrderid(orderId);
        miOrder.setOrderdate(orderdate);
        miOrder.setOrdermoney(amount);
        miOrder.setMtime(java.time.Instant.now().getEpochSecond());
        miOrder.setCtime(java.time.Instant.now().getEpochSecond());
        miOrder.setNum(1);
        miOrder.setType(type);
        miOrder.setStatus(Short.parseShort("0"));
        miOrderService.insert(miOrder);
        System.out.println(miOrder);

        createOrderPay(miOrder);

    }


    public void createOrderPay(MiOrder miOrder) {

        short type = miOrder.getType();
        MiChannelType channelType =
                miChannelTypeService.queryByType(miOrder.getType());


        MiPayChannel payChannel =
                miPayChannelService.queryByTypeId(channelType.getId());

        MiPayAccount miPayAccount =
                miPayAccountService.queryByChannelId(payChannel.getId());

        IOrderService payService =
                ServiceFactory.getInstance().getPayService(payChannel.getApi());

        MiOrderPay miOrderPay = new MiOrderPay();
        miOrderPay.setTrademoney(miOrder.getOrdermoney());
        miOrderPay.setChannelid(payChannel.getId());
        miOrderPay.setIspay(0);
        miOrderPay.setCtime(java.time.Instant.now().getEpochSecond());
        miOrderPay.setMtime(Instant.now().getEpochSecond());
        miOrderPay.setMark(miOrder.getOrderid());
        miOrderPay.setStatus(0);
        miOrderPay.setUserid(miPayAccount.getUserid());
        miOrderPayService.insert(miOrderPay);

        payService.getCodeUrl(miOrderPay, miPayAccount,payChannel);

    }


}
