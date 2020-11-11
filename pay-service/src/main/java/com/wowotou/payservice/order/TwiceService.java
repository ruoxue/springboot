package com.wowotou.payservice.order;

import com.wowotou.common.MapUtil;
import com.wowotou.common.Md5;
import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.payservice.annotation.APIShow;
import com.wowotou.service.MiOrderPayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@APIShow("twice")
@Service("twice")
public class TwiceService implements IOrderService {

    @Resource
    MiOrderPayService payOrderService;


    @Override
    public Map<String, String> getCodeUrl(MiOrderPay queue, MiPayAccount miPayAccount, MiPayChannel miPayChannel) {
        return null;
    }

    @Override
    public void query(MiOrderPay queue) {

    }

    @Override
    public Map<String, String> query(int id,String ip) {
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
    public String payNotify(Map<String, String> params,String ip) {



        try {

            String out_trade_no = new String(params.get("mark").
                    getBytes("ISO-8859-1"),
                    "UTF-8");
            //支付宝交易号

            String trade_no = new String(params.get("no").getBytes("ISO-8859-1"),
                    "UTF-8");

            //交易状态
            String trade_status = new String(params.get("trade_status")
                    .getBytes("ISO-8859-1"), "UTF-8");

            String sign=params.get("sign");

            params.remove("sign");

            String sign2= Md5.md5( MapUtil.getParamStr(params));

            boolean verify_result =sign.equalsIgnoreCase(sign2);

            if (verify_result && trade_status.equals("SUCCESS")) {
                payOrderService.orderNotify(params.get("orderId"));

                return params.get("mark");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "err";
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
