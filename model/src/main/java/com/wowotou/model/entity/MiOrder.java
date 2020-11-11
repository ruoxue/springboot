package com.wowotou.model.entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单管理(LmOrder)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:00
 */
@Document("mi_order")
public class MiOrder implements Serializable {
    private static final long serialVersionUID = -69600625847908093L;
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 用户ID
     */
    private String uid;
    /**
     * 商户订单
     */
    private String orderid;
    /**
     * 订单日期
     */
    private String orderdate;
    /**
     * 交易金额
     */
    private BigDecimal trademoney;
    /**
     * 商户金额
     */
    private Double mermoney;
    /**
     * 通道金额
     */
    private Double channelmoney;
    /**
     * 订单金额
     */

    private Double ordermoney;
    /**
     * 产品名称
     */
    private String productname;
    /**
     * 回调地址
     */
    private String notifyurl;
    /**
     * 返回地址
     */
    private String returnurl;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * 支付时间
     */
    private Long mtime;
    /**
     * 状态
     */
    private short status;
    /**
     * 商户通道
     */
    private String merchannel;
    /**
     * 支付通道
     */
    private String channelid;
    /**
     * 三方单号
     */
    private String channelorderid;
    /**
     * 利润
     */
    private Double ratemoney;
    /**
     * 银行
     */
    private String bank;
    /**
     * 扩展
     */
    private String extra;
    /**
     * 返回时间
     */
    private Long resptime;
    /**
     * 返回状态
     */
    private Long respstatus;
    /**
     * 订单类型
     */
    private short ordertype;
    /**
     * 积分
     */
    private Integer point;
    /**
     * 规格
     */
    private String skuid;

    private String payUrl;
    /**
     * 类型
     */
    private short type;
    /**
     * ip
     */
    private String ip;
    /**
     * 提交IP
     */
    private String mip;
    /**
     * 代理利润
     */
    private Double agentratemoney;
    /**
     * 代理通道
     */
    private String acid;
    /**
     * 结算状态
     */
    private short settle;
    /**
     * 支付服务器
     */
    private String payIp;
    /**
     * 支付服务器
     */
    private Integer ipid;
    /**
     * 子类型
     */
    private short subtype;

    private Integer num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public BigDecimal getTrademoney() {
        return trademoney;
    }

    public void setTrademoney(BigDecimal trademoney) {
        this.trademoney = trademoney;
    }

    public Double getMermoney() {
        return mermoney;
    }

    public void setMermoney(Double mermoney) {
        this.mermoney = mermoney;
    }

    public Double getChannelmoney() {
        return channelmoney;
    }

    public void setChannelmoney(Double channelmoney) {
        this.channelmoney = channelmoney;
    }

    public Double getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Double ordermoney) {
        this.ordermoney = ordermoney;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl;
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

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getMerchannel() {
        return merchannel;
    }

    public void setMerchannel(String merchannel) {
        this.merchannel = merchannel;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getChannelorderid() {
        return channelorderid;
    }

    public void setChannelorderid(String channelorderid) {
        this.channelorderid = channelorderid;
    }

    public Double getRatemoney() {
        return ratemoney;
    }

    public void setRatemoney(Double ratemoney) {
        this.ratemoney = ratemoney;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Long getResptime() {
        return resptime;
    }

    public void setResptime(Long resptime) {
        this.resptime = resptime;
    }

    public Long getRespstatus() {
        return respstatus;
    }

    public void setRespstatus(Long respstatus) {
        this.respstatus = respstatus;
    }

    public short getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(short ordertype) {
        this.ordertype = ordertype;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMip() {
        return mip;
    }

    public void setMip(String mip) {
        this.mip = mip;
    }

    public Double getAgentratemoney() {
        return agentratemoney;
    }

    public void setAgentratemoney(Double agentratemoney) {
        this.agentratemoney = agentratemoney;
    }

    public String getAcid() {
        return acid;
    }

    public void setAcid(String acid) {
        this.acid = acid;
    }

    public short getSettle() {
        return settle;
    }

    public void setSettle(short settle) {
        this.settle = settle;
    }

    public String getPayIp() {
        return payIp;
    }

    public void setPayIp(String payIp) {
        this.payIp = payIp;
    }

    public Integer getIpid() {
        return ipid;
    }

    public void setIpid(Integer ipid) {
        this.ipid = ipid;
    }

    public short getSubtype() {
        return subtype;
    }

    public void setSubtype(short subtype) {
        this.subtype = subtype;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MiOrder{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", orderid='" + orderid + '\'' +
                ", orderdate='" + orderdate + '\'' +
                ", trademoney=" + trademoney +
                ", mermoney=" + mermoney +
                ", channelmoney=" + channelmoney +
                ", ordermoney=" + ordermoney +
                ", productname='" + productname + '\'' +
                ", notifyurl='" + notifyurl + '\'' +
                ", returnurl='" + returnurl + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                ", status=" + status +
                ", merchannel='" + merchannel + '\'' +
                ", channelid='" + channelid + '\'' +
                ", channelorderid='" + channelorderid + '\'' +
                ", ratemoney=" + ratemoney +
                ", bank='" + bank + '\'' +
                ", extra='" + extra + '\'' +
                ", resptime=" + resptime +
                ", respstatus=" + respstatus +
                ", ordertype=" + ordertype +
                ", point=" + point +
                ", skuid='" + skuid + '\'' +
                ", payUrl='" + payUrl + '\'' +
                ", type=" + type +
                ", ip='" + ip + '\'' +
                ", mip='" + mip + '\'' +
                ", agentratemoney=" + agentratemoney +
                ", acid='" + acid + '\'' +
                ", settle=" + settle +
                ", payIp='" + payIp + '\'' +
                ", ipid=" + ipid +
                ", subtype=" + subtype +
                ", num=" + num +
                '}';
    }
}