package com.wowotou.payservice.nx;

import java.io.Serializable;

public class ListBean implements Serializable {
    /**
     * Remark : mi10005
     * PayType : 14
     * TxnTm : 092815
     * Fee : 0.00
     * PayAccessType : 02
     * MerOrDt : 20190413
     * MerOrderId : TC2334942805
     * TxnSeqId : T02334942807
     * ResDesc : 交易成功
     * acctNo : 6230910199064356377
     * merId : 801599810912771
     * MerOrTm : 092814
     * TxnSta : 02
     * ReceivedAmount : 0.01
     * SettleDate : 2019-04-13 09:28
     * TxnDt : 20190413
     * TradeAmount : 0.01
     */

    private String Remark;
    private String PayType;
    private String TxnTm;
    private String Fee;
    private String PayAccessType;
    private String MerOrDt;
    private String MerOrderId;
    private String TxnSeqId;
    private String ResDesc;
    private String acctNo;
    private String merId;
    private String MerOrTm;
    private String TxnSta;
    private String ReceivedAmount;
    private String SettleDate;
    private String TxnDt;
    private String TradeAmount;

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    public String getTxnTm() {
        return TxnTm;
    }

    public void setTxnTm(String txnTm) {
        TxnTm = txnTm;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    public String getPayAccessType() {
        return PayAccessType;
    }

    public void setPayAccessType(String payAccessType) {
        PayAccessType = payAccessType;
    }

    public String getMerOrDt() {
        return MerOrDt;
    }

    public void setMerOrDt(String merOrDt) {
        MerOrDt = merOrDt;
    }

    public String getMerOrderId() {
        return MerOrderId;
    }

    public void setMerOrderId(String merOrderId) {
        MerOrderId = merOrderId;
    }

    public String getTxnSeqId() {
        return TxnSeqId;
    }

    public void setTxnSeqId(String txnSeqId) {
        TxnSeqId = txnSeqId;
    }

    public String getResDesc() {
        return ResDesc;
    }

    public void setResDesc(String resDesc) {
        ResDesc = resDesc;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getMerOrTm() {
        return MerOrTm;
    }

    public void setMerOrTm(String merOrTm) {
        MerOrTm = merOrTm;
    }

    public String getTxnSta() {
        return TxnSta;
    }

    public void setTxnSta(String txnSta) {
        TxnSta = txnSta;
    }

    public String getReceivedAmount() {
        return ReceivedAmount;
    }

    public void setReceivedAmount(String receivedAmount) {
        ReceivedAmount = receivedAmount;
    }

    public String getSettleDate() {
        return SettleDate;
    }

    public void setSettleDate(String settleDate) {
        SettleDate = settleDate;
    }

    public String getTxnDt() {
        return TxnDt;
    }

    public void setTxnDt(String txnDt) {
        TxnDt = txnDt;
    }

    public String getTradeAmount() {
        return TradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        TradeAmount = tradeAmount;
    }
}
