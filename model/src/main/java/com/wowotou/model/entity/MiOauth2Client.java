package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * oauth2_授权客户端(LmOauth2Client)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:00
 */
@Document("mi_oauth2_client")
public class MiOauth2Client implements Serializable {
    private static final long serialVersionUID = -19452959526081694L;
    @Id
    private String id;
    /**
     * 商户id
     */
    private Object storeId;
    /**
     * 标题
     */
    private String title;

    private String appid;

    private String appsecret;
    /**
     * 回调Url
     */
    private String redirectUri;
    /**
     * 备注
     */
    private String remark;
    /**
     * 组别
     */
    private String group;
    /**
     * 状态[0:禁用;1启用]
     */
    private Object status;
    /**
     * 创建时间
     */
    private Object createTime;
    /**
     * 修改时间
     */
    private Object updateTime;

    private Integer uid;

    private Integer adminid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getStoreId() {
        return storeId;
    }

    public void setStoreId(Object storeId) {
        this.storeId = storeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

}