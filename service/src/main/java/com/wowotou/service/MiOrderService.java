package com.wowotou.service;


import com.wowotou.model.entity.MiOrder;

import java.util.List;

/**
 * (MiOrder)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
public interface MiOrderService extends  BaseMongoService<MiOrder> {


    boolean resultSuccess(String out_trade_no, String trade_no, String trade_no1, String userid, String paramStr, String ip);

    MiOrder queryByOrderId(String orderId, String uid);
}