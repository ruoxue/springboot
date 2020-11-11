package com.wowotou.payservice.bean;

import java.io.Serializable;

public class HHBean implements Serializable {


    private String accessToken;
    private String aliPay;
    private String instId;
    private String merNum;
    private String newmername;
    private String qqpay;
    private String shanghu;
    private String state;
    private String topInstId;
    private String username;
    private String userword;
    private String weixinpay;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAliPay(String aliPay) {
        this.aliPay = aliPay;
    }

    public String getAliPay() {
        return aliPay;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getInstId() {
        return instId;
    }

    public void setMerNum(String merNum) {
        this.merNum = merNum;
    }

    public String getMerNum() {
        return merNum;
    }

    public void setNewmername(String newmername) {
        this.newmername = newmername;
    }

    public String getNewmername() {
        return newmername;
    }

    public void setQqpay(String qqpay) {
        this.qqpay = qqpay;
    }

    public String getQqpay() {
        return qqpay;
    }

    public void setShanghu(String shanghu) {
        this.shanghu = shanghu;
    }

    public String getShanghu() {
        return shanghu;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setTopInstId(String topInstId) {
        this.topInstId = topInstId;
    }

    public String getTopInstId() {
        return topInstId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserword(String userword) {
        this.userword = userword;
    }

    public String getUserword() {
        return userword;
    }

    public void setWeixinpay(String weixinpay) {
        this.weixinpay = weixinpay;
    }

    public String getWeixinpay() {
        return weixinpay;
    }

}
