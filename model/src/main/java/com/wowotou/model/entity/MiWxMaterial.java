package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信公众号素材(LmWxMaterial)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:02
 */
@Document("mi_wx_material")
public class MiWxMaterial implements Serializable {
    private static final long serialVersionUID = -70193100242608005L;
    /**
     * 微信公众号素材
     */
    @Id
    private String id;

    private Integer storeId;

    private Integer wxAid;
    /**
     * 微信媒体id
     */
    private String mediaId;
    /**
     * 视频文件名
     */
    private String fileName;

    private String mediaUrl;

    private String localCover;
    /**
     * 图片（image）、视频（video）、语音 （voice）、图文（news）音乐（music）
     */
    private String type;
    /**
     * 视频描述
     */
    private String des;

    private Long cTime;
    /**
     * 更新时间
     */
    private Long mTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getLocalCover() {
        return localCover;
    }

    public void setLocalCover(String localCover) {
        this.localCover = localCover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


}