/**
  * Copyright 2019 bejson.com 
  */
package com.wowotou.payservice.bean.pdd.order;
import java.util.List;

/**
 * Auto-generated: 2019-12-19 21:57:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PaymentInfoStore {

    private String appPaymentEnv;
    private AppIdSet appIdSet;
    private List<PayChannelList> payChannelList;
    private boolean paymentNavToApp;
    private boolean isHBEnvironment;
    private boolean canWechatDirectPay;
    private List<PayMethods> payMethods;
    private List<String> installmentList;
    private String paymentType;
    private boolean orderNonAddress;
    private boolean lockTerm;
    private int termIndex;
    private boolean aliFolded;
    private boolean foldedSwitch;
    private boolean showRepayModifyPanel;
    private long repayModifyCountdown;
    public void setAppPaymentEnv(String appPaymentEnv) {
         this.appPaymentEnv = appPaymentEnv;
     }
     public String getAppPaymentEnv() {
         return appPaymentEnv;
     }

    public void setAppIdSet(AppIdSet appIdSet) {
         this.appIdSet = appIdSet;
     }
     public AppIdSet getAppIdSet() {
         return appIdSet;
     }

    public void setPayChannelList(List<PayChannelList> payChannelList) {
         this.payChannelList = payChannelList;
     }
     public List<PayChannelList> getPayChannelList() {
         return payChannelList;
     }

    public void setPaymentNavToApp(boolean paymentNavToApp) {
         this.paymentNavToApp = paymentNavToApp;
     }
     public boolean getPaymentNavToApp() {
         return paymentNavToApp;
     }

    public void setIsHBEnvironment(boolean isHBEnvironment) {
         this.isHBEnvironment = isHBEnvironment;
     }
     public boolean getIsHBEnvironment() {
         return isHBEnvironment;
     }

    public void setCanWechatDirectPay(boolean canWechatDirectPay) {
         this.canWechatDirectPay = canWechatDirectPay;
     }
     public boolean getCanWechatDirectPay() {
         return canWechatDirectPay;
     }

    public void setPayMethods(List<PayMethods> payMethods) {
         this.payMethods = payMethods;
     }
     public List<PayMethods> getPayMethods() {
         return payMethods;
     }

    public void setInstallmentList(List<String> installmentList) {
         this.installmentList = installmentList;
     }
     public List<String> getInstallmentList() {
         return installmentList;
     }

    public void setPaymentType(String paymentType) {
         this.paymentType = paymentType;
     }
     public String getPaymentType() {
         return paymentType;
     }

    public void setOrderNonAddress(boolean orderNonAddress) {
         this.orderNonAddress = orderNonAddress;
     }
     public boolean getOrderNonAddress() {
         return orderNonAddress;
     }

    public void setLockTerm(boolean lockTerm) {
         this.lockTerm = lockTerm;
     }
     public boolean getLockTerm() {
         return lockTerm;
     }

    public void setTermIndex(int termIndex) {
         this.termIndex = termIndex;
     }
     public int getTermIndex() {
         return termIndex;
     }

    public void setAliFolded(boolean aliFolded) {
         this.aliFolded = aliFolded;
     }
     public boolean getAliFolded() {
         return aliFolded;
     }

    public void setFoldedSwitch(boolean foldedSwitch) {
         this.foldedSwitch = foldedSwitch;
     }
     public boolean getFoldedSwitch() {
         return foldedSwitch;
     }

    public void setShowRepayModifyPanel(boolean showRepayModifyPanel) {
         this.showRepayModifyPanel = showRepayModifyPanel;
     }
     public boolean getShowRepayModifyPanel() {
         return showRepayModifyPanel;
     }

    public void setRepayModifyCountdown(long repayModifyCountdown) {
         this.repayModifyCountdown = repayModifyCountdown;
     }
     public long getRepayModifyCountdown() {
         return repayModifyCountdown;
     }

}