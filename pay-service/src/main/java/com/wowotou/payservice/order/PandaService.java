package com.wowotou.payservice.order;


import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.payservice.annotation.APIShow;
import org.springframework.stereotype.Service;

import java.util.Map;

@APIShow(value = "panda")
@Service(value = "panda")
public class PandaService implements  IOrderService {


    @Override
    public Map<String, String> getCodeUrl(MiOrderPay queue, MiPayAccount miPayAccount, MiPayChannel miPayChannel) {
        return null;
    }

    @Override
    public void query(MiOrderPay queue) {

    }

    @Override
    public Map<String, String> query(int id, String ip) {
        return null;
    }

    @Override
    public Map<String, String> bindMainAccount(int id) {
        return null;
    }

    @Override
    public Map<String, String> unBindMainAccount(int id) {
        return null;
    }

    @Override
    public Map<String, String> login(MiPayAccount miPayAccount) {
        return null;
    }

    @Override
    public Map<String, String> sendLoginSms(MiPayAccount param) {
        return null;
    }

    @Override
    public String payNotify(Map<String, String> request, String ip) {
        return null;
    }

    @Override
    public Map<String, String> addAccount(Map<String, String> request) {
        return null;
    }

    @Override
    public Map<String, String> updateAccount(Map<String, String> request) {
        return null;
    }

    @Override
    public Map<String, String> orderSettle(String mark, String tradeNo) {
        return null;
    }
}
