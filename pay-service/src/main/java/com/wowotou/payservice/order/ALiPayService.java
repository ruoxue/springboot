package com.wowotou.payservice.order;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.wowotou.common.JsonUtil;
import com.wowotou.common.MapUtil;
import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.payservice.annotation.APIShow;
import com.wowotou.payservice.service.AliUtil;
import com.wowotou.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * alipay
 */
@APIShow(value = "alipay")
@Service(value = "alipay")
public class ALiPayService implements IOrderService {

    @Resource
    MiPayChannelService payChannelService;
    @Resource
    AliUtil aliUtil;
    @Resource
    MiOrderPayService payQueueService;
    @Resource
    MiPayAccountService miPayAccountService;
    @Resource
    MiOrderService payOrderService;

    @Override
    public Map<String, String> getCodeUrl(MiOrderPay queue,MiPayAccount miPayAccount
            ,MiPayChannel miPayChannel) {

        Map<String, String> ret = new HashMap<>();

        if (queue == null) {
            ret.put("code", "0");
            ret.put("msg", queue + "不存在");
            return ret;
        }

        if (queue != null) {
            String param = miPayChannel.getParam();
            Map<String, String> mapParam = new JsonUtil<Map>().
                    fromJson(param,Map.class);
                  
            AlipayClient alipayClient = new DefaultAlipayClient(
                    miPayChannel.getGateway()
                    , miPayAccount.getUserid()
                    , miPayAccount.getToken() //{"format":"json","charset":"UTF-8","signType":"RSA"}
                    , mapParam.get("format"),
                    mapParam.get("charset"),
                    miPayAccount.getExtra(),
                    mapParam.get("signType")); //获得初始化的AlipayClient
            AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
            alipayRequest.setReturnUrl(miPayChannel.getReturnUrl().
                    replace("{mark}", 
                    queue.getMark()).replace("{api}",
                    this.getClass().getSimpleName()));
            alipayRequest.setNotifyUrl(miPayChannel.getNotifyUrl()
                    .replace("{mark}", 
                    queue.getMark()).replace("{api}", 
                    this.getClass().getSimpleName()));//在公共参数中设置回跳和通知地址
            alipayRequest.setBizContent("{" +
                    " \"out_trade_no\":\"" + queue.getMark() + "\"," +
                    " \"total_amount\":\"" + queue.getTrademoney() + "\"," +
                    " \"subject\":\"" + queue.getShow() + "\"," +
                    " \"body\":\"" + queue.getShow() + "\"," +
                    " \"timeout_express\":\"" + mapParam.get("timeout_express") + "\"," +
                    " \"quit_url\":\"" + miPayChannel.getReturnUrl() + "\"," +
                    " \"passback_params\":\"" + 0 + "\"," +
                    " \"goods_type\":\"" + 0 + "\"," +
                    " \"product_code\":\"" + mapParam.get("product_code") + "\"" +
                    " }");//填充业务参数
            String form = "";
            try {
                form = alipayClient.pageExecute(alipayRequest).
                        getBody(); //调用SDK生成表单

            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            ret.put("code", "1");
            ret.put("info", form);
        }
        return ret;
    }


    @Override
    public void query(MiOrderPay map) {

    }


    public Map<String, String> unBindMainAccount(int id) {
        return aliUtil.relationUnbind(String.valueOf(id));


    }

    @Override
    public Map<String, String> login(MiPayAccount param) {
        return null;
    }

    @Override
    public Map<String, String> sendLoginSms(MiPayAccount param) {
        return null;
    }

    public Map<String, String> bindMainAccount(int id) {
        return aliUtil.relationBind(String.valueOf(id));

    }


    public Map<String, String> query(int id,String ip) {
        return aliUtil.query(id,ip);

    }


    @Override
    public String payNotify(Map<String, String> params,String ip) {
        try { 

            MiPayAccount account = miPayAccountService.queryByUserid(
                    String.valueOf(params.get("app_id")));
 
            String out_trade_no = new String(params.get("out_trade_no").
                    getBytes("ISO-8859-1"),
                    "UTF-8");

            if (out_trade_no==null){
                return "err";
            }
            //支付宝交易号

            String trade_no = new String(params.get("trade_no")
                    .getBytes("ISO-8859-1"), 
                    "UTF-8");
            
            //交易状态
            String trade_status = new String(params.get("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            //计算得出通知验证结果
            boolean verify_result = AlipaySignature.rsaCheckV1(params,
                    account.getExtra(), "utf-8", "RSA2");

            if (verify_result && trade_status.equals("TRADE_SUCCESS")) {

                MiPayChannel channel = payChannelService.queryById(account.getChannelid());


                double money = Double.valueOf(params.get("total_amount"))
                        * (1 - channel.getRate());

                double money2 = Math.ceil(money * 100) / 100;
                try {

                    MiOrderPay queueType = payQueueService.getByRemark((out_trade_no));
                    if (queueType != null) {

                        aliUtil.orderSettle(params.get("app_id"),
                                money2
                                , trade_no, out_trade_no, queueType.getShow());
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
                payOrderService.resultSuccess(
                        out_trade_no, trade_no, trade_no, account.getUserid(),
                        MapUtil.getParamStr(params),ip);

                return "success";
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

        Map<String, String> map = new HashMap<>();
        MiOrderPay queueType = payQueueService.getByRemark(mark);
        if (queueType == null || queueType.getIspay() == 0) {
            map.put("code", "0");
            map.put("msg", "未支付");
            return map;
        }

        MiPayChannel channel = payChannelService.queryById(queueType.getChannelid());

        if (channel == null) {
            map.put("code", "0");
            map.put("msg", "通道失败");
            return map;
        }
        double money = Double.valueOf(queueType.getTrademoney())
                * (1 - channel.getRate());

        double money2 = Math.ceil(money * 100) / 100;

        return aliUtil.orderSettle(queueType.getUserid(),
                money2, tradeNo, queueType.getMark(), queueType.getShow());
    }


}
