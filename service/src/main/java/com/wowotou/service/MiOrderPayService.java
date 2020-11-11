package com.wowotou.service;


import com.wowotou.model.entity.MiOrderPay;

import java.util.List;

/**
 * (MiOrderPay)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
public interface MiOrderPayService extends  BaseMongoService<MiOrderPay> {

    public  void  pay(String payId);

    MiOrderPay getByRemark(String out_trade_no);

    boolean orderNotify(String orderId);
}