package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 序列管理(LmOrderPay)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:01
 */
@Document("mi_order_pay")
public class MiOrderPay implements Serializable {
    private static final long serialVersionUID = 116321502175582079L;
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 交易金额
     */
    private Double trademoney;
    /**
     * 备注
     */
    private String mark;
    /**
     * 状态
     */
    private Object status;
    /**
     * ios链接
     */
    private String payUrl;
    /**
     * 订单号
     */
    private String  orderid;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * 使用时间
     */
    private Long mtime;
    /**
     * 用户id
     */
    private String adminid;
    /**
     * 账号标识
     */
    private String userid;
    /**
     * 账号id
     */
    private String aid;
    /**
     * 类型
     */
    private String channelid;
    /**
     * 安卓链接
     */
    private String payUrlAndroid;
    /**
     * 发送标识
     */
    private String senduserid;
    /**
     * 接受标识
     */
    private String touserid;
    /**
     * 是否发送
     */
    private Integer isneedsend;
    /**
     * 序列通道号
     */
    private String queuechannel;

    private String info;
    /**
     * 是否支付
     */
    private Integer ispay;
    /**
     * 子类型
     */
    private Integer subtype;
    /**
     * 三方订单号
     */
    private String thirdno;
    /**
     * 支付ip
     */
    private String payip;
    /**
     * 协议
     */
    private String useragent;
    /**
     * 来源于
     */
    private String referer;
    /**
     * 真实ip
     */
    private String realip;

    private Integer isDeleted;
    /**
     * 交易号
     */
    private String tradeno;

    private Integer strategy;

    private String show;

    private Integer cango;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTrademoney() {
        return trademoney;
    }

    public void setTrademoney(Double trademoney) {
        this.trademoney = trademoney;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getPayUrlAndroid() {
        return payUrlAndroid;
    }

    public void setPayUrlAndroid(String payUrlAndroid) {
        this.payUrlAndroid = payUrlAndroid;
    }

    public String getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(String senduserid) {
        this.senduserid = senduserid;
    }

    public String getTouserid() {
        return touserid;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid;
    }

    public Integer getIsneedsend() {
        return isneedsend;
    }

    public void setIsneedsend(Integer isneedsend) {
        this.isneedsend = isneedsend;
    }

    public String getQueuechannel() {
        return queuechannel;
    }

    public void setQueuechannel(String queuechannel) {
        this.queuechannel = queuechannel;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }

    public Integer getSubtype() {
        return subtype;
    }

    public void setSubtype(Integer subtype) {
        this.subtype = subtype;
    }

    public String getThirdno() {
        return thirdno;
    }

    public void setThirdno(String thirdno) {
        this.thirdno = thirdno;
    }

    public String getPayip() {
        return payip;
    }

    public void setPayip(String payip) {
        this.payip = payip;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getRealip() {
        return realip;
    }

    public void setRealip(String realip) {
        this.realip = realip;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public Integer getCango() {
        return cango;
    }

    public void setCango(Integer cango) {
        this.cango = cango;
    }

}