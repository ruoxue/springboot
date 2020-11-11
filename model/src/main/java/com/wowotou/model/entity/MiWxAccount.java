package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信公共帐号(LmWxAccount)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:02
 */
@Document("mi_wx_account")
public class MiWxAccount implements Serializable {
    private static final long serialVersionUID = -73379206098775492L;
    /**
     * 表id
     */
    @Id
    private String id;
    /**
     * uid
     */
    private Integer storeId;
    /**
     * 公众号名称
     */
    private String wxname;
    /**
     * aeskey
     */
    private String aeskey;
    /**
     * encode
     */
    private Object encode;
    /**
     * appid
     */
    private String appId;
    /**
     * appsecret
     */
    private String appSecret;
    /**
     * 公众号原始ID
     */
    private String originId;
    /**
     * 微信号
     */
    private String weixin;
    /**
     * 头像地址
     */
    private String logo;
    /**
     * token
     */
    private String token;
    /**
     * 微信对接token
     */
    private String wToken;
    /**
     * 微信对接地址
     */
    private String related;
    /**
     * create_time
     */
    private Integer createTime;
    /**
     * updatetime
     */
    private Integer updateTime;
    /**
     * 内容模版ID
     */
    private String tplcontentid;
    /**
     * 分享ticket
     */
    private String shareTicket;
    /**
     * share_dated
     */
    private String shareDated;
    /**
     * authorizer_access_token
     */
    private String authorizerAccessToken;
    /**
     * authorizer_refresh_token
     */
    private String authorizerRefreshToken;
    /**
     * authorizer_expires
     */
    private String authorizerExpires;
    /**
     * 类型 1 普通订阅号2认证订阅号 3普通服务号 4认证服务号/认证媒体/政府订阅号
     */
    private Object type;
    /**
     * 网页授权token
     */
    private String webAccessToken;
    /**
     * web_refresh_token
     */
    private String webRefreshToken;
    /**
     * 过期时间
     */
    private Integer webExpires;
    /**
     * qr
     */
    private String qr;
    /**
     * 菜单
     */
    private Object menuConfig;
    /**
     * 微信接入状态,0待接入1已接入
     */
    private Object status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getwToken() {
        return wToken;
    }

    public void setwToken(String wToken) {
        this.wToken = wToken;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getWxname() {
        return wxname;
    }

    public void setWxname(String wxname) {
        this.wxname = wxname;
    }

    public String getAeskey() {
        return aeskey;
    }

    public void setAeskey(String aeskey) {
        this.aeskey = aeskey;
    }

    public Object getEncode() {
        return encode;
    }

    public void setEncode(Object encode) {
        this.encode = encode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWToken() {
        return wToken;
    }

    public void setWToken(String wToken) {
        this.wToken = wToken;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
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

    public String getTplcontentid() {
        return tplcontentid;
    }

    public void setTplcontentid(String tplcontentid) {
        this.tplcontentid = tplcontentid;
    }

    public String getShareTicket() {
        return shareTicket;
    }

    public void setShareTicket(String shareTicket) {
        this.shareTicket = shareTicket;
    }

    public String getShareDated() {
        return shareDated;
    }

    public void setShareDated(String shareDated) {
        this.shareDated = shareDated;
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    public String getAuthorizerExpires() {
        return authorizerExpires;
    }

    public void setAuthorizerExpires(String authorizerExpires) {
        this.authorizerExpires = authorizerExpires;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getWebAccessToken() {
        return webAccessToken;
    }

    public void setWebAccessToken(String webAccessToken) {
        this.webAccessToken = webAccessToken;
    }

    public String getWebRefreshToken() {
        return webRefreshToken;
    }

    public void setWebRefreshToken(String webRefreshToken) {
        this.webRefreshToken = webRefreshToken;
    }

    public Integer getWebExpires() {
        return webExpires;
    }

    public void setWebExpires(Integer webExpires) {
        this.webExpires = webExpires;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Object getMenuConfig() {
        return menuConfig;
    }

    public void setMenuConfig(Object menuConfig) {
        this.menuConfig = menuConfig;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

}