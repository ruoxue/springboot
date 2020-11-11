package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信回复表(LmWxReply)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:03
 */
@Document("mi_wx_reply")
public class MiWxReply implements Serializable {
    private static final long serialVersionUID = 856473425132503382L;
    /**
     * 微信关键词回复表
     */
    @Id
    private String id;
    /**
     * 店铺id
     */
    private Integer storeId;

    private Integer wxAid;
    /**
     * 规则名
     */
    private String rule;

    private String keyword;
    /**
     * 查询类型keyword,subscribe,default
     */
    private String type;
    /**
     * 回复消息类型  文本（text ）图片（image）、视频（video）、语音 （voice）、图文（news） 音乐（music）
     */
    private String msgType;
    /**
     * text使用该自动存储文本
     */
    private String data;
    /**
     * news、video voice image music的素材id等
     */
    private Object materialId;

    private Object status;

    private Long cTime;

    private Long mTime;

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

    public Integer getWxAid() {
        return wxAid;
    }

    public void setWxAid(Integer wxAid) {
        this.wxAid = wxAid;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Object materialId) {
        this.materialId = materialId;
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