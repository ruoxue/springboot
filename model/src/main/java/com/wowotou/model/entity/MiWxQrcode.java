package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信二维码(LmWxQrcode)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:03
 */
@Document("mi_wx_qrcode")
public class MiWxQrcode implements Serializable {
    private static final long serialVersionUID = 594923116258531464L;

    @Id
    private String id;

    private Integer storeId;

    private Integer wxAid;

    private String name;

    private String qrcode;

    private Integer sceneId;
    /**
     * 0 临时，1 永久
     */
    private Object type;

    private String ticket;

    private Integer expireSeconds;

    private String url;

    private Object status;

    private Integer cTime;

    private Integer mTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }

    public Integer getmTime() {
        return mTime;
    }

    public void setmTime(Integer mTime) {
        this.mTime = mTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }


}