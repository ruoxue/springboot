package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 用户表(LmUser)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:01
 */
@Document("mi_user")
public class MiUser implements Serializable {
    private static final long serialVersionUID = 139946165295819360L;
    /**
     * 表id
     */
    @Id
    private String id;

    private Integer storeId;
    /**
     * 邮件
     */
    private String email;

    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 支付密码
     */
    private String paypwd;
    /**
     * 0 保密 1 男 2 女
     */
    private Object sex;
    /**
     * 生日
     */
    private Integer birthday;
    /**
     * 用户金额
     */
    private Double userMoney;
    /**
     * 冻结金额
     */
    private Double frozenMoney;
    /**
     * 累积分佣金额
     */
    private Double distributMoney;
    /**
     * 用户下线总数
     */
    private Integer underlingNumber;
    /**
     * 消费积分
     */
    private Object payPoints;
    /**
     * 默认收货地址
     */
    private Object addressId;
    /**
     * 注册时间
     */
    private Object createTime;

    private Integer updateTime;
    /**
     * 最后登录时间
     */
    private Object lastLogin;
    /**
     * 登录次数
     */
    private Integer loginNum;
    /**
     * 最后登录ip
     */
    private String lastIp;
    /**
     * QQ
     */
    private String qq;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 是否验证手机
     */
    private Object mobileValidated;
    /**
     * 第三方来源 wx weibo alipay qq
     */
    private String oauth;
    /**
     * 第三方唯一标示
     */
    private String openid;

    private String unionid;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 省份
     */
    private Integer province;
    /**
     * 市区
     */
    private Integer city;
    /**
     * 县
     */
    private Integer district;
    /**
     * 是否验证电子邮箱
     */
    private Object emailValidated;
    /**
     * 第三方返回昵称
     */
    private String nickname;
    /**
     * 会员等级
     */
    private Object levelId;
    /**
     * 会员折扣，默认1不享受
     */
    private Double discount;
    /**
     * 消费累计额度
     */
    private Double totalAmount;
    /**
     * 是否被锁定冻结 0 冻结，1 正常
     */
    private Object status;
    /**
     * 是否为分销商 0 否 1 是
     */
    private Object isDistribut;
    /**
     * 第一个上级
     */
    private Integer firstLeader;
    /**
     * 第二个上级
     */
    private Integer secondLeader;
    /**
     * 第三个上级
     */
    private Integer thirdLeader;
    /**
     * 用于app 授权类似于session_id
     */
    private String token;
    /**
     * 消息掩码
     */
    private Object messageMask;
    /**
     * 推送id
     */
    private String pushId;
    /**
     * 分销商等级
     */
    private Object distributLevel;
    /**
     * 是否为VIP ：0不是，1是
     */
    private Object isVip;
    /**
     * 小程序专属二维码
     */
    private String minQrcode;
    /**
     * 专属推广海报
     */
    private String poster;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    public Double getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(Double frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public Double getDistributMoney() {
        return distributMoney;
    }

    public void setDistributMoney(Double distributMoney) {
        this.distributMoney = distributMoney;
    }

    public Integer getUnderlingNumber() {
        return underlingNumber;
    }

    public void setUnderlingNumber(Integer underlingNumber) {
        this.underlingNumber = underlingNumber;
    }

    public Object getPayPoints() {
        return payPoints;
    }

    public void setPayPoints(Object payPoints) {
        this.payPoints = payPoints;
    }

    public Object getAddressId() {
        return addressId;
    }

    public void setAddressId(Object addressId) {
        this.addressId = addressId;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Object getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getMobileValidated() {
        return mobileValidated;
    }

    public void setMobileValidated(Object mobileValidated) {
        this.mobileValidated = mobileValidated;
    }

    public String getOauth() {
        return oauth;
    }

    public void setOauth(String oauth) {
        this.oauth = oauth;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Object getEmailValidated() {
        return emailValidated;
    }

    public void setEmailValidated(Object emailValidated) {
        this.emailValidated = emailValidated;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Object getLevelId() {
        return levelId;
    }

    public void setLevelId(Object levelId) {
        this.levelId = levelId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getIsDistribut() {
        return isDistribut;
    }

    public void setIsDistribut(Object isDistribut) {
        this.isDistribut = isDistribut;
    }

    public Integer getFirstLeader() {
        return firstLeader;
    }

    public void setFirstLeader(Integer firstLeader) {
        this.firstLeader = firstLeader;
    }

    public Integer getSecondLeader() {
        return secondLeader;
    }

    public void setSecondLeader(Integer secondLeader) {
        this.secondLeader = secondLeader;
    }

    public Integer getThirdLeader() {
        return thirdLeader;
    }

    public void setThirdLeader(Integer thirdLeader) {
        this.thirdLeader = thirdLeader;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getMessageMask() {
        return messageMask;
    }

    public void setMessageMask(Object messageMask) {
        this.messageMask = messageMask;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public Object getDistributLevel() {
        return distributLevel;
    }

    public void setDistributLevel(Object distributLevel) {
        this.distributLevel = distributLevel;
    }

    public Object getIsVip() {
        return isVip;
    }

    public void setIsVip(Object isVip) {
        this.isVip = isVip;
    }

    public String getMinQrcode() {
        return minQrcode;
    }

    public void setMinQrcode(String minQrcode) {
        this.minQrcode = minQrcode;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}