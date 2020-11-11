package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmWxMaterialInfo)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:02
 */
@Document("mi_wx_material_info")
public class MiWxMaterialInfo implements Serializable {
    private static final long serialVersionUID = 121241458080916391L;
    /**
     * id
     */
    @Id
    private String id;

    private Integer storeId;

    private Integer wxAid;

    private Integer materialId;
    /**
     * 图文消息的封面图片素材id（必须是永久mediaID）
     */
    private String thumbMediaId;

    private String localCover;
    /**
     * 图文消息封面
     */
    private String cover;

    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 是否显示封面
     */
    private Object showCover;
    /**
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     */
    private String digest;
    /**
     * 正文
     */
    private String content;
    /**
     * 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
     */
    private String url;
    /**
     * 图文消息的原文地址，即点击“阅读原文”后的URL
     */
    private String contentSourceUrl;
    /**
     * Uint32 是否打开评论，0不打开，1打开
     */
    private Object needOpenComment;
    /**
     * Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
     */
    private Object onlyFansCanComment;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 阅读次数
     */
    private Integer hits;

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

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getLocalCover() {
        return localCover;
    }

    public void setLocalCover(String localCover) {
        this.localCover = localCover;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getShowCover() {
        return showCover;
    }

    public void setShowCover(Object showCover) {
        this.showCover = showCover;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public Object getNeedOpenComment() {
        return needOpenComment;
    }

    public void setNeedOpenComment(Object needOpenComment) {
        this.needOpenComment = needOpenComment;
    }

    public Object getOnlyFansCanComment() {
        return onlyFansCanComment;
    }

    public void setOnlyFansCanComment(Object onlyFansCanComment) {
        this.onlyFansCanComment = onlyFansCanComment;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

}