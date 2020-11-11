package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 商品(LmGoodsSku)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:00
 */
@Document("mi_goods_sku")
public class MiGoodsSku implements Serializable {
    private static final long serialVersionUID = -77021687733241462L;

    @Id
    private String id;
    /**
     * 类别ID
     */
    private String pid;
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

    private Object clazzType;
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

    private Integer hot;

    private Integer home;

    private Double price;

    private Integer goodsid;

    private Integer stock;

    private Integer adminid;

    private Double rebate;

    private Integer attrSymbol;


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

    public Object getClazzType() {
        return clazzType;
    }

    public void setClazzType(Object clazzType) {
        this.clazzType = clazzType;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    public Integer getAttrSymbol() {
        return attrSymbol;
    }

    public void setAttrSymbol(Integer attrSymbol) {
        this.attrSymbol = attrSymbol;
    }

}