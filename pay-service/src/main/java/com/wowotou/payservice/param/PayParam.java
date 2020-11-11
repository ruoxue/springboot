package com.wowotou.payservice.param;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PayParam implements Serializable {
    private int merId;
    private String orderId;
    private long orderDate;
    private String ip;
    private int type;
    private double orderMoney;
    private String returnUrl;
    private String notifyUrl;
    private String productName;
    private String bank;
    private String sign;

    public int getMerId() {
        return merId;
    }

    public void setMerId(int merId) {
        this.merId = merId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public boolean isValidate() {
        Map<String, String> map = new HashMap<>();
        map.put("merId", String.valueOf(merId));
        map.put("orderId", String.valueOf(orderId));
        map.put("orderDate", String.valueOf(orderDate));
        map.put("ip", String.valueOf(ip));
        map.put("type", String.valueOf(type));
        map.put("orderMoney", String.valueOf(orderMoney));
        map.put("returnUrl", String.valueOf(returnUrl));
        map.put("notifyUrl", String.valueOf(notifyUrl));
        map.put("productName", String.valueOf(productName));
        map.put("bank", String.valueOf(bank));
        return true;

    }
}
