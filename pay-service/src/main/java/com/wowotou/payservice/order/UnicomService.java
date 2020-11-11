package com.wowotou.payservice.order;

import com.alibaba.fastjson.JSONObject;
import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.payservice.annotation.APIShow;
import org.bouncycastle.jcajce.provider.asymmetric.RSA;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service("unicom")
@APIShow("unicom")
public class UnicomService implements  IOrderService{
    @Override
    public Map<String, String>
    getCodeUrl(MiOrderPay queue,
               MiPayAccount miPayAccount,
               MiPayChannel miPayChannel) {




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
    public Map<String, String> sendLoginSms(MiPayAccount account) {

//
//
//        String param = "send_flag=&mobile=" + RSA.unicomEncryption(phone) + "&version=" + UnicomConfig.version + "&keyVersion=";
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Host", "m.client.10010.com");
//        headers.put("User-Agent", UnicomConfig.User_Agent);
//        Response res = Http.create(UnicomConfig.SEND_LOGIN_SMS_SERVER).proxy(proxyIp, proxyProt).heads(headers).bodys(param).requestType(Http.RequestType.FORM).post().send().getResponse();
//        String body = res.getResult();
//        if (res.getStatus() == 0 || StringUtils.isEmpty(body)) {
//
//            logger.info("手机号：" + phone + ",登录验证码代理ip错误");
//            dao.addProxyFailTimes(cardId);
//            return false;
//        }
//        logger.info("手机号：" + phone + ",登录验证码发送结果:" + body);
//
//        if (!JSONUtil.isJson(body)) {
//            dao.addProxyFailTimes(cardId);
//            logger.info("手机号：" + phone + ",登录验证码发送错误:" + body);
//            return false;
//        }
//
//        JSONObject json = JSONObject.fromObject(body);
//
//        if ("0000".equals(json.getString("rsp_code"))) {
//            CardBean updateModel = new CardBean();
//            updateModel.setCard_status(-1);
//            updateModel.setId(cardId);
//            updateModel.setVer_code("");
//            updateModel.setUpdate_time(System.currentTimeMillis() / 1000);
//            dao.update(updateModel);
//            return true;
//        } else if ("7096".equals(json.getString("rsp_code"))) {
//
//            return false;
//        } else {
//            CardBean updateModel = new CardBean();
//            updateModel.setCard_status(2);
//            updateModel.setId(cardId);
//            updateModel.setUpdate_time(System.currentTimeMillis() / 1000);
//            dao.update(updateModel);
//            return false;
//        }


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
