package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmPayAccount)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:01
 */
@Document("mi_pay_account")
public class MiPayAccount implements Serializable {
    private static final long serialVersionUID = 896069158204850781L;
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 修改时间
     */
    private Long mtime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 使用次数
     */
    private Integer usetime;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * 区域
     */
    private String area;
    /**
     * 最小值
     */
    private Integer min;
    /**
     * 最大值
     */
    private Integer max;
    /**
     * 当天最大
     */
    private Integer daymax;
    /**
     * 银行id
     */
    private Integer bankid;
    /**
     * 身份证
     */
    private String idcard;
    /**
     * 卡号
     */
    private String banknum;
    /**
     * 链接id
     */
    private String socketId;
    /**
     * 手机(登录)号
     */
    private String mobilenumber;
    /**
     * 登录号
     */
    private String logonid;
    /**
     * 真实姓名
     */
    private String realnamed;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 登录时间
     */
    private String logintime;
    /**
     * appID
     */
    private String userid;
    /**
     * 展示名
     */
    private String title;

    private Double thirddaymoney;
    /**
     * 用户名
     */
    private String username;
    /**
     * 删除
     */
    private Integer isDeleted;
    /**
     * 头像
     */
    private String useravatar;
    /**
     * 单位时间
     */
    private Integer unit;
    /**
     * 单位时间收单
     */
    private Integer unittime;

    private Object rate;
    /**
     * ip
     */
    private Integer ipid;

    private Integer issend;
    /**
     * 密码
     */
    private String paypwd;
    /**
     * 扩展，公钥
     */
    private String extra;
    /**
     * token,私钥
     */
    private String token;

    private Integer pid;
    /**
     * 类型
     */
    private String channelid;
    /**
     * 单用户收单
     */
    private Object usertime;
    /**
     * 收单金额
     */
    private String amount;

    private String adminid;

    private Integer premoney;

    private String verCode;

    private String deviceNum;

    private Integer verTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUsetime() {
        return usetime;
    }

    public void setUsetime(Integer usetime) {
        this.usetime = usetime;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getDaymax() {
        return daymax;
    }

    public void setDaymax(Integer daymax) {
        this.daymax = daymax;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getBanknum() {
        return banknum;
    }

    public void setBanknum(String banknum) {
        this.banknum = banknum;
    }

    public String getSocketId() {
        return socketId;
    }

    public void setSocketId(String socketId) {
        this.socketId = socketId;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getLogonid() {
        return logonid;
    }

    public void setLogonid(String logonid) {
        this.logonid = logonid;
    }

    public String getRealnamed() {
        return realnamed;
    }

    public void setRealnamed(String realnamed) {
        this.realnamed = realnamed;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getThirddaymoney() {
        return thirddaymoney;
    }

    public void setThirddaymoney(Double thirddaymoney) {
        this.thirddaymoney = thirddaymoney;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getUnittime() {
        return unittime;
    }

    public void setUnittime(Integer unittime) {
        this.unittime = unittime;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public Integer getIpid() {
        return ipid;
    }

    public void setIpid(Integer ipid) {
        this.ipid = ipid;
    }

    public Integer getIssend() {
        return issend;
    }

    public void setIssend(Integer issend) {
        this.issend = issend;
    }

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public Object getUsertime() {
        return usertime;
    }

    public void setUsertime(Object usertime) {
        this.usertime = usertime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public Integer getPremoney() {
        return premoney;
    }

    public void setPremoney(Integer premoney) {
        this.premoney = premoney;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }

    public Integer getVerTime() {
        return verTime;
    }

    public void setVerTime(Integer verTime) {
        this.verTime = verTime;
    }

}