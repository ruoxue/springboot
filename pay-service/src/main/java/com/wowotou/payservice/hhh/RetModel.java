package com.wowotou.payservice.hhh;

import java.util.List;

public class RetModel {
    /**
     * total : 4
     * message : ok
     * data : [{"bankInstId":"YC001027978","parentMerNum":null,"merNum":"MER1901000418","qrCode":null,"totalFee":700,"body":"古田秀色 微信用户扫码付款","payNo":null,"source":"微信网页端支付","deviceInfo":"YC001027978-MER1901000418","payType":null,"created":null,"acquirer":null,"sign":null,"limitCredit":null,"wxMerRate":null,"merName":"古田秀色","aliMerRate":null,"merId":null,"topInstId":null,"merStoreNo":null,"backEndUrl":null,"id":7257634,"actualPay":700,"discount":0,"paySerialNo":"CH20190329155222964873","payWeixinNo":"4200000297201903291203261322","orderType":3,"status":1,"openId":"oJAK7uDD2J_xAc--UXgkis4TLyOQ","nickName":null,"dbCreate":1553845949000,"strCreate":"2019-03-29 15:52:29","updated":1553845950000,"rate":0,"rateMoney":0,"queryCount":0,"operationName":null,"bankRateMoney":1,"remark":null,"activityId":null,"actDiscount":0,"cusAmount":null,"bankType":"CFT","settlementTotalFee":700,"transactionId":"4200000297201903291203261322","checkDate":null,"accountsDate":null,"webappPayNo":null,"payTuitionUserId":null,"creditRate":0,"creditRateMoney":0,"subAppId":null,"subOpenId":null},{"bankInstId":"YC001027978","parentMerNum":null,"merNum":"MER1901000418","qrCode":null,"totalFee":600,"body":"古田秀色 微信用户扫码付款","payNo":null,"source":"微信网页端支付","deviceInfo":"YC001027978-MER1901000418","payType":null,"created":null,"acquirer":null,"sign":null,"limitCredit":null,"wxMerRate":null,"merName":"古田秀色","aliMerRate":null,"merId":null,"topInstId":null,"merStoreNo":null,"backEndUrl":null,"id":7257608,"actualPay":600,"discount":0,"paySerialNo":"CH20190329155157691617","payWeixinNo":"4200000296201903295095459367","orderType":3,"status":1,"openId":"oJAK7uDD2J_xAc--UXgkis4TLyOQ","nickName":null,"dbCreate":1553845924000,"strCreate":"2019-03-29 15:52:04","updated":1553845925000,"rate":0,"rateMoney":0,"queryCount":0,"operationName":null,"bankRateMoney":1,"remark":null,"activityId":null,"actDiscount":0,"cusAmount":null,"bankType":"CFT","settlementTotalFee":600,"transactionId":"4200000296201903295095459367","checkDate":null,"accountsDate":null,"webappPayNo":null,"payTuitionUserId":null,"creditRate":0,"creditRateMoney":0,"subAppId":null,"subOpenId":null},{"bankInstId":"YC001027978","parentMerNum":null,"merNum":"MER1901000418","qrCode":null,"totalFee":500,"body":"古田秀色 微信用户扫码付款","payNo":null,"source":"微信网页端支付","deviceInfo":"YC001027978-MER1901000418","payType":null,"created":null,"acquirer":null,"sign":null,"limitCredit":null,"wxMerRate":null,"merName":"古田秀色","aliMerRate":null,"merId":null,"topInstId":null,"merStoreNo":null,"backEndUrl":null,"id":7257563,"actualPay":500,"discount":0,"paySerialNo":"CH20190329155123614264","payWeixinNo":"4200000293201903291925116515","orderType":3,"status":1,"openId":"oJAK7uDD2J_xAc--UXgkis4TLyOQ","nickName":null,"dbCreate":1553845890000,"strCreate":"2019-03-29 15:51:30","updated":1553845890000,"rate":0,"rateMoney":0,"queryCount":0,"operationName":null,"bankRateMoney":1,"remark":null,"activityId":null,"actDiscount":0,"cusAmount":null,"bankType":"CFT","settlementTotalFee":500,"transactionId":"4200000293201903291925116515","checkDate":null,"accountsDate":null,"webappPayNo":null,"payTuitionUserId":null,"creditRate":0,"creditRateMoney":0,"subAppId":null,"subOpenId":null},{"bankInstId":"YC001027978","parentMerNum":null,"merNum":"MER1901000418","qrCode":null,"totalFee":400,"body":"古田秀色 微信用户扫码付款","payNo":null,"source":"微信网页端支付","deviceInfo":"YC001027978-MER1901000418","payType":null,"created":null,"acquirer":null,"sign":null,"limitCredit":null,"wxMerRate":null,"merName":"古田秀色","aliMerRate":null,"merId":null,"topInstId":null,"merStoreNo":null,"backEndUrl":null,"id":7257543,"actualPay":400,"discount":0,"paySerialNo":"CH20190329155053306086","payWeixinNo":"4200000295201903290091113787","orderType":3,"status":1,"openId":"oJAK7uDD2J_xAc--UXgkis4TLyOQ","nickName":null,"dbCreate":1553845860000,"strCreate":"2019-03-29 15:51:00","updated":1553845861000,"rate":0,"rateMoney":0,"queryCount":0,"operationName":null,"bankRateMoney":1,"remark":null,"activityId":null,"actDiscount":0,"cusAmount":null,"bankType":"CFT","settlementTotalFee":400,"transactionId":"4200000295201903290091113787","checkDate":null,"accountsDate":null,"webappPayNo":null,"payTuitionUserId":null,"creditRate":0,"creditRateMoney":0,"subAppId":null,"subOpenId":null}]
     * code : 200
     */

    private int total;
    private String message;
    private int code;
    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bankInstId : YC001027978
         * parentMerNum : null
         * merNum : MER1901000418
         * qrCode : null
         * totalFee : 700
         * body : 古田秀色 微信用户扫码付款
         * payNo : null
         * source : 微信网页端支付
         * deviceInfo : YC001027978-MER1901000418
         * payType : null
         * created : null
         * acquirer : null
         * sign : null
         * limitCredit : null
         * wxMerRate : null
         * merName : 古田秀色
         * aliMerRate : null
         * merId : null
         * topInstId : null
         * merStoreNo : null
         * backEndUrl : null
         * id : 7257634
         * actualPay : 700
         * discount : 0
         * paySerialNo : CH20190329155222964873
         * payWeixinNo : 4200000297201903291203261322
         * orderType : 3
         * status : 1
         * openId : oJAK7uDD2J_xAc--UXgkis4TLyOQ
         * nickName : null
         * dbCreate : 1553845949000
         * strCreate : 2019-03-29 15:52:29
         * updated : 1553845950000
         * rate : 0
         * rateMoney : 0
         * queryCount : 0
         * operationName : null
         * bankRateMoney : 1
         * remark : null
         * activityId : null
         * actDiscount : 0
         * cusAmount : null
         * bankType : CFT
         * settlementTotalFee : 700
         * transactionId : 4200000297201903291203261322
         * checkDate : null
         * accountsDate : null
         * webappPayNo : null
         * payTuitionUserId : null
         * creditRate : 0
         * creditRateMoney : 0
         * subAppId : null
         * subOpenId : null
         */

        private String bankInstId;
        private Object parentMerNum;
        private String merNum;
        private Object qrCode;
        private int totalFee;
        private String body;
        private Object payNo;
        private String source;
        private String deviceInfo;
        private Object payType;
        private Object created;
        private Object acquirer;
        private Object sign;
        private Object limitCredit;
        private Object wxMerRate;
        private String merName;
        private Object aliMerRate;
        private Object merId;
        private Object topInstId;
        private Object merStoreNo;
        private Object backEndUrl;
        private int id;
        private int actualPay;
        private int discount;
        private String paySerialNo;
        private String payWeixinNo;
        private int orderType;
        private int status;
        private String openId;
        private Object nickName;
        private long dbCreate;
        private String strCreate;
        private long updated;
        private int rate;
        private int rateMoney;
        private int queryCount;
        private Object operationName;
        private int bankRateMoney;
        private String remark;
        private Object activityId;
        private int actDiscount;
        private Object cusAmount;
        private String bankType;
        private int settlementTotalFee;
        private String transactionId;
        private Object checkDate;
        private Object accountsDate;
        private Object webappPayNo;
        private Object payTuitionUserId;
        private int creditRate;
        private int creditRateMoney;
        private Object subAppId;
        private Object subOpenId;
        private String tradeNo;
        private String outTradeNo;
        private String buyerId;

        private int totalAmount;

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(String buyerId) {
            this.buyerId = buyerId;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getTradeNo() {
            return tradeNo;
        }

        public void setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
        }

        public String getBankInstId() {
            return bankInstId;
        }

        public void setBankInstId(String bankInstId) {
            this.bankInstId = bankInstId;
        }

        public Object getParentMerNum() {
            return parentMerNum;
        }

        public void setParentMerNum(Object parentMerNum) {
            this.parentMerNum = parentMerNum;
        }

        public String getMerNum() {
            return merNum;
        }

        public void setMerNum(String merNum) {
            this.merNum = merNum;
        }

        public Object getQrCode() {
            return qrCode;
        }

        public void setQrCode(Object qrCode) {
            this.qrCode = qrCode;
        }

        public int getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(int totalFee) {
            this.totalFee = totalFee;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Object getPayNo() {
            return payNo;
        }

        public void setPayNo(Object payNo) {
            this.payNo = payNo;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDeviceInfo() {
            return deviceInfo;
        }

        public void setDeviceInfo(String deviceInfo) {
            this.deviceInfo = deviceInfo;
        }

        public Object getPayType() {
            return payType;
        }

        public void setPayType(Object payType) {
            this.payType = payType;
        }

        public Object getCreated() {
            return created;
        }

        public void setCreated(Object created) {
            this.created = created;
        }

        public Object getAcquirer() {
            return acquirer;
        }

        public void setAcquirer(Object acquirer) {
            this.acquirer = acquirer;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public Object getLimitCredit() {
            return limitCredit;
        }

        public void setLimitCredit(Object limitCredit) {
            this.limitCredit = limitCredit;
        }

        public Object getWxMerRate() {
            return wxMerRate;
        }

        public void setWxMerRate(Object wxMerRate) {
            this.wxMerRate = wxMerRate;
        }

        public String getMerName() {
            return merName;
        }

        public void setMerName(String merName) {
            this.merName = merName;
        }

        public Object getAliMerRate() {
            return aliMerRate;
        }

        public void setAliMerRate(Object aliMerRate) {
            this.aliMerRate = aliMerRate;
        }

        public Object getMerId() {
            return merId;
        }

        public void setMerId(Object merId) {
            this.merId = merId;
        }

        public Object getTopInstId() {
            return topInstId;
        }

        public void setTopInstId(Object topInstId) {
            this.topInstId = topInstId;
        }

        public Object getMerStoreNo() {
            return merStoreNo;
        }

        public void setMerStoreNo(Object merStoreNo) {
            this.merStoreNo = merStoreNo;
        }

        public Object getBackEndUrl() {
            return backEndUrl;
        }

        public void setBackEndUrl(Object backEndUrl) {
            this.backEndUrl = backEndUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getActualPay() {
            return actualPay;
        }

        public void setActualPay(int actualPay) {
            this.actualPay = actualPay;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public String getPaySerialNo() {
            return paySerialNo;
        }

        public void setPaySerialNo(String paySerialNo) {
            this.paySerialNo = paySerialNo;
        }

        public String getPayWeixinNo() {
            return payWeixinNo;
        }

        public void setPayWeixinNo(String payWeixinNo) {
            this.payWeixinNo = payWeixinNo;
        }

        public int getOrderType() {
            return orderType;
        }

        public void setOrderType(int orderType) {
            this.orderType = orderType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public Object getNickName() {
            return nickName;
        }

        public void setNickName(Object nickName) {
            this.nickName = nickName;
        }

        public long getDbCreate() {
            return dbCreate;
        }

        public void setDbCreate(long dbCreate) {
            this.dbCreate = dbCreate;
        }

        public String getStrCreate() {
            return strCreate;
        }

        public void setStrCreate(String strCreate) {
            this.strCreate = strCreate;
        }

        public long getUpdated() {
            return updated;
        }

        public void setUpdated(long updated) {
            this.updated = updated;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getRateMoney() {
            return rateMoney;
        }

        public void setRateMoney(int rateMoney) {
            this.rateMoney = rateMoney;
        }

        public int getQueryCount() {
            return queryCount;
        }

        public void setQueryCount(int queryCount) {
            this.queryCount = queryCount;
        }

        public Object getOperationName() {
            return operationName;
        }

        public void setOperationName(Object operationName) {
            this.operationName = operationName;
        }

        public int getBankRateMoney() {
            return bankRateMoney;
        }

        public void setBankRateMoney(int bankRateMoney) {
            this.bankRateMoney = bankRateMoney;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getActivityId() {
            return activityId;
        }

        public void setActivityId(Object activityId) {
            this.activityId = activityId;
        }

        public int getActDiscount() {
            return actDiscount;
        }

        public void setActDiscount(int actDiscount) {
            this.actDiscount = actDiscount;
        }

        public Object getCusAmount() {
            return cusAmount;
        }

        public void setCusAmount(Object cusAmount) {
            this.cusAmount = cusAmount;
        }

        public String getBankType() {
            return bankType;
        }

        public void setBankType(String bankType) {
            this.bankType = bankType;
        }

        public int getSettlementTotalFee() {
            return settlementTotalFee;
        }

        public void setSettlementTotalFee(int settlementTotalFee) {
            this.settlementTotalFee = settlementTotalFee;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public Object getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(Object checkDate) {
            this.checkDate = checkDate;
        }

        public Object getAccountsDate() {
            return accountsDate;
        }

        public void setAccountsDate(Object accountsDate) {
            this.accountsDate = accountsDate;
        }

        public Object getWebappPayNo() {
            return webappPayNo;
        }

        public void setWebappPayNo(Object webappPayNo) {
            this.webappPayNo = webappPayNo;
        }

        public Object getPayTuitionUserId() {
            return payTuitionUserId;
        }

        public void setPayTuitionUserId(Object payTuitionUserId) {
            this.payTuitionUserId = payTuitionUserId;
        }

        public int getCreditRate() {
            return creditRate;
        }

        public void setCreditRate(int creditRate) {
            this.creditRate = creditRate;
        }

        public int getCreditRateMoney() {
            return creditRateMoney;
        }

        public void setCreditRateMoney(int creditRateMoney) {
            this.creditRateMoney = creditRateMoney;
        }

        public Object getSubAppId() {
            return subAppId;
        }

        public void setSubAppId(Object subAppId) {
            this.subAppId = subAppId;
        }

        public Object getSubOpenId() {
            return subOpenId;
        }

        public void setSubOpenId(Object subOpenId) {
            this.subOpenId = subOpenId;
        }
    }
}
