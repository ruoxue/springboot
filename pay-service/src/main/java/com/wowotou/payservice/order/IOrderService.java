package com.wowotou.payservice.order;


import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.model.entity.MiPayChannel;

import java.util.Map;

public interface IOrderService {
    Map<String, String> getCodeUrl(MiOrderPay queue, MiPayAccount miPayAccount
            , MiPayChannel miPayChannel);

    void query(MiOrderPay queue);

    Map<String, String> query(int id,String ip);

    Map<String, String> bindMainAccount(int id  );

    Map<String, String> unBindMainAccount(int id   );

    Map<String, String> login(MiPayAccount miPayAccount);
    public  Map<String,String> sendLoginSms(MiPayAccount param);

    String payNotify(Map<String, String> request,String ip);

    Map<String, String> addAccount(Map<String, String> request);

    Map<String, String> updateAccount(Map<String, String> request);


    Map<String,String> orderSettle(String mark,String tradeNo);
}
