package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信用户标签表(LmWxTag)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:03
 */
@Document("mi_wx_tag")
public class MiWxTag implements Serializable {
    private static final long serialVersionUID = -98812567447243704L;
    @Id
    private String id;
    /**
     * tag id
     */
    private Integer tagId;
    /**
     * 标签名
     */
    private String name;
    /**
     * 店铺id
     */
    private Integer storeId;
    /**
     * 微信账号id
     */
    private Integer wxAid;

    private int status;

    private Integer cTime;

    private Integer mTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}