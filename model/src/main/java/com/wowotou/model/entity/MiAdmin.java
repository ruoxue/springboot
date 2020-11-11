package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 后台管理员(LmAdmin)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:55
 */
@Document("mi_admin")
public class MiAdmin implements Serializable {
    private static final long serialVersionUID = -45894668038569265L;
    /**
     * 管理员ID
     */
    @Id
    private String id;
    /**
     * 管理员用户名
     */
    private String username;
    /**
     * 管理员密码
     */
    private String password;
    /**
     * 分组ID
     */
    private Object groupId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 电话号码
     */
    private String mobile;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 传递修改密码参数加密
     */
    private String mdemail;
    /**
     * 审核状态
     */
    private Object status;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 添加时间
     */
    private Integer createTime;

    private Integer updateTime;

    private Integer pid;

    private Double rate;

    private Double money;

    private Double freezemoney;

    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Object getGroupId() {
        return groupId;
    }

    public void setGroupId(Object groupId) {
        this.groupId = groupId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMdemail() {
        return mdemail;
    }

    public void setMdemail(String mdemail) {
        this.mdemail = mdemail;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getFreezemoney() {
        return freezemoney;
    }

    public void setFreezemoney(Double freezemoney) {
        this.freezemoney = freezemoney;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "MiAdmin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", groupId=" + groupId +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", ip='" + ip + '\'' +
                ", mdemail='" + mdemail + '\'' +
                ", status=" + status +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", pid=" + pid +
                ", rate=" + rate +
                ", money=" + money +
                ", freezemoney=" + freezemoney +
                ", token='" + token + '\'' +
                '}';
    }
}