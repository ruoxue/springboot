package com.wowotou.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信公众号获取粉丝列表(LmWxFans)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:02
 */
@Document("mi_wx_fans")
public class MiWxFans implements Serializable {
    private static final long serialVersionUID = -53043948420150621L;
    /**
     * 粉丝ID
     */
    private Integer fansId;
    /**
     * 微信账户id
     */
    private Integer wxAid;
    /**
     * 会员编号ID
     */
    private Integer uid;
    /**
     * 推广人uid
     */
    private Integer sourceUid;
    /**
     * 店铺ID
     */
    private Integer storeId;
    /**
     * 昵称
     */
    private String nickname;

    private String nicknameEncode;
    /**
     * 头像
     */
    private String headimgurl;
    /**
     * 性别
     */
    private Object sex;
    /**
     * 用户语言
     */
    private String language;
    /**
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 行政区/县
     */
    private String district;
    /**
     * 用户的标识，对当前公众号唯一     用户的唯一身份ID
     */
    private String openid;
    /**
     * 粉丝unionid
     */
    private String unionid;
    /**
     * 粉丝所在组id
     */
    private Integer groupid;
    /**
     * 是否订阅
     */
    private Object subscribe;
    /**
     * 订阅场景
     */
    private String subscribeScene;
    /**
     * 备注
     */
    private String remark;
    /**
     * 标签
     */
    private String tag;
    /**
     * 标签列表
     */
    private String tagidList;
    /**
     * 订阅时间
     */
    private Integer subscribeTime;
    /**
     * 解订阅时间
     */
    private Integer unsubscribeTime;
    /**
     * 二维码扫码场景（开发者自定义）
     */
    private String qrScene;
    /**
     * 二维码扫码场景描述（开发者自定义）
     */
    private String qrSceneStr;

    private Object status;
    /**
     * 粉丝信息最后更新时间
     */
    private Long mTime;

    private Long cTime;


    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }

    public Integer getWxAid() {
        return wxAid;
    }

    public void setWxAid(Integer wxAid) {
        this.wxAid = wxAid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSourceUid() {
        return sourceUid;
    }

    public void setSourceUid(Integer sourceUid) {
        this.sourceUid = sourceUid;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNicknameEncode() {
        return nicknameEncode;
    }

    public void setNicknameEncode(String nicknameEncode) {
        this.nicknameEncode = nicknameEncode;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Object getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Object subscribe) {
        this.subscribe = subscribe;
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagidList() {
        return tagidList;
    }

    public void setTagidList(String tagidList) {
        this.tagidList = tagidList;
    }

    public Integer getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Integer subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Integer getUnsubscribeTime() {
        return unsubscribeTime;
    }

    public void setUnsubscribeTime(Integer unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    public String getQrScene() {
        return qrScene;
    }

    public void setQrScene(String qrScene) {
        this.qrScene = qrScene;
    }

    public String getQrSceneStr() {
        return qrSceneStr;
    }

    public void setQrSceneStr(String qrSceneStr) {
        this.qrSceneStr = qrSceneStr;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }


    public Long getmTime() {
        return mTime;
    }

    public void setmTime(Long mTime) {
        this.mTime = mTime;
    }

    public Long getcTime() {
        return cTime;
    }

    public void setcTime(Long cTime) {
        this.cTime = cTime;
    }
}