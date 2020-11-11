package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信_历史记录表(LmWxMsgHistory)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:03
 */
@Document("mi_wx_msg_history")
public class MiWxMsgHistory implements Serializable {
    private static final long serialVersionUID = -77998656140682052L;

    @Id
    private String id;
    /**
     * 商户id
     */
    private Object storeId;
    /**
     * 微信账号id
     */
    private Integer wxAid;

    private Integer mediaId;
    /**
     * 关键字id
     */
    private Integer keywordId;
    /**
     * 昵称
     */
    private String nickname;

    private String openid;

    private String contentJson;
    /**
     * 微信消息
     */
    private String content;

    private String type;
    /**
     * 详细事件
     */
    private String event;
    /**
     * 状态0:禁用;1启用
     */
    private Object status;
    /**
     * 创建时间
     */
    private Long cTime;
    /**
     * 修改时间
     */
    private Long mTime;

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

    public Integer getWxAid() {
        return wxAid;
    }

    public void setWxAid(Integer wxAid) {
        this.wxAid = wxAid;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getContentJson() {
        return contentJson;
    }

    public void setContentJson(String contentJson) {
        this.contentJson = contentJson;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Long getcTime() {
        return cTime;
    }

    public void setcTime(Long cTime) {
        this.cTime = cTime;
    }

    public Long getmTime() {
        return mTime;
    }

    public void setmTime(Long mTime) {
        this.mTime = mTime;
    }
}