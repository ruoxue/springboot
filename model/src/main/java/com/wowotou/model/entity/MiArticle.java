package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 商品(LmArticle)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:59
 */
@Document("mi_article")
public class MiArticle implements Serializable {
    private static final long serialVersionUID = -45258062021840822L;

    @Id
    private String id;
    /**
     * 类别ID
     */
    private Object pid;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品摘要
     */
    private Object description;

    private Object content;
    /**
     * 商品作者
     */
    private String author;
    /**
     * 商品邮箱
     */
    private String authorEmail;
    /**
     * 关键字,用逗号隔开
     */
    private String keywords;
    /**
     * 是否显示,1:显示;0:不显示
     */
    private Object status;
    /**
     * 附件地址
     */
    private String fileUrl;

    private Object openType;
    /**
     * 链接地址
     */
    private String link;
    /**
     * 浏览量
     */
    private Integer click;
    /**
     * 文章预告发布时间
     */
    private Integer publishTime;

    private Object sort;
    /**
     * 文章缩略图
     */
    private String thumb;

    private String tags;

    private Object cTime;

    private Integer mTime;

    private Integer adminid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getcTime() {
        return cTime;
    }

    public void setcTime(Object cTime) {
        this.cTime = cTime;
    }

    public Integer getmTime() {
        return mTime;
    }

    public void setmTime(Integer mTime) {
        this.mTime = mTime;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Object getOpenType() {
        return openType;
    }

    public void setOpenType(Object openType) {
        this.openType = openType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }

    public Object getSort() {
        return sort;
    }

    public void setSort(Object sort) {
        this.sort = sort;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

}