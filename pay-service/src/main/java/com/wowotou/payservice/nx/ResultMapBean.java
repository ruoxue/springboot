package com.wowotou.payservice.nx;

import java.io.Serializable;
import java.util.List;

public class ResultMapBean implements Serializable {

    /**
     * _MCSJnlNo : 0
     * _ResponseSystemId : EWM
     * _RejCode : 02
     * _RejMsg : EWM.02:{0}
     * _MCHJnlNo : 000000
     * _TransactionId : scan.QryEWMFlowwater
     * _MCHTimestamp : 2019-04-13 15:38:42.821
     * _AuthenticateType : 000000
     * _LocalProcessFlag : false
     * _ProcessState :
     * totalAcctAmt : 0.01
     * RspMsg : 查询成功
     * totalFee : 0.00
     * totalAmt : 0.01
     * txnCount : 1
     * RspCode : 02
     * list : [{"Remark":"mi10005","PayType":"14","TxnTm":"092815","Fee":"0.00","PayAccessType":"02","MerOrDt":"20190413","MerOrderId":"TC2334942805","TxnSeqId":"T02334942807","ResDesc":"交易成功","acctNo":"6230910199064356377","merId":"801599810912771","MerOrTm":"092814","TxnSta":"02","ReceivedAmount":"0.01","SettleDate":"2019-04-13 09:28","TxnDt":"20190413","TradeAmount":"0.01"}]
     * resultCode : 200
     * currentIndex : 0
     * recordNumber : 1
     */

    private String _MCSJnlNo;
    private String _ResponseSystemId;
    private String _RejCode;
    private String _RejMsg;
    private String _MCHJnlNo;
    private String _TransactionId;
    private String _MCHTimestamp;
    private String _AuthenticateType;
    private String _LocalProcessFlag;
    private String _ProcessState;
    private String totalAcctAmt;
    private String RspMsg;
    private String totalFee;
    private String totalAmt;
    private String txnCount;
    private String RspCode;
    private String resultCode;
    private String currentIndex;
    private String recordNumber;
    private List<ListBean> list;

    public String get_MCSJnlNo() {
        return _MCSJnlNo;
    }

    public void set_MCSJnlNo(String _MCSJnlNo) {
        this._MCSJnlNo = _MCSJnlNo;
    }

    public String get_ResponseSystemId() {
        return _ResponseSystemId;
    }

    public void set_ResponseSystemId(String _ResponseSystemId) {
        this._ResponseSystemId = _ResponseSystemId;
    }

    public String get_RejCode() {
        return _RejCode;
    }

    public void set_RejCode(String _RejCode) {
        this._RejCode = _RejCode;
    }

    public String get_RejMsg() {
        return _RejMsg;
    }

    public void set_RejMsg(String _RejMsg) {
        this._RejMsg = _RejMsg;
    }

    public String get_MCHJnlNo() {
        return _MCHJnlNo;
    }

    public void set_MCHJnlNo(String _MCHJnlNo) {
        this._MCHJnlNo = _MCHJnlNo;
    }

    public String get_TransactionId() {
        return _TransactionId;
    }

    public void set_TransactionId(String _TransactionId) {
        this._TransactionId = _TransactionId;
    }

    public String get_MCHTimestamp() {
        return _MCHTimestamp;
    }

    public void set_MCHTimestamp(String _MCHTimestamp) {
        this._MCHTimestamp = _MCHTimestamp;
    }

    public String get_AuthenticateType() {
        return _AuthenticateType;
    }

    public void set_AuthenticateType(String _AuthenticateType) {
        this._AuthenticateType = _AuthenticateType;
    }

    public String get_LocalProcessFlag() {
        return _LocalProcessFlag;
    }

    public void set_LocalProcessFlag(String _LocalProcessFlag) {
        this._LocalProcessFlag = _LocalProcessFlag;
    }

    public String get_ProcessState() {
        return _ProcessState;
    }

    public void set_ProcessState(String _ProcessState) {
        this._ProcessState = _ProcessState;
    }

    public String getTotalAcctAmt() {
        return totalAcctAmt;
    }

    public void setTotalAcctAmt(String totalAcctAmt) {
        this.totalAcctAmt = totalAcctAmt;
    }

    public String getRspMsg() {
        return RspMsg;
    }

    public void setRspMsg(String rspMsg) {
        RspMsg = rspMsg;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getTxnCount() {
        return txnCount;
    }

    public void setTxnCount(String txnCount) {
        this.txnCount = txnCount;
    }

    public String getRspCode() {
        return RspCode;
    }

    public void setRspCode(String rspCode) {
        RspCode = rspCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(String currentIndex) {
        this.currentIndex = currentIndex;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }
}
