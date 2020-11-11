package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmGoodsSkutype)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:00
 */
@Document("mi_goods_sku_type")
public class MiGoodsSkutype implements Serializable {
    private static final long serialVersionUID = -55548446866312558L;

    @Id
    private String id;
    /**
     * 类别名称
     */
    private String title;
    /**
     * 别名
     */
    private String titleAlias;
    /**
     * 默认分组
     */
    private Object titleType;
    /**
     * 上级ID
     */
    private Object pid;
    /**
     * 是否导航显示
     */
    private Object showInNav;
    /**
     * 状态
     */
    private Object status;
    /**
     * 排序
     */
    private Object sort;
    /**
     * 分类描述
     */
    private String catDesc;
    /**
     * 搜索关键词
     */
    private String keywords;

    private Integer createTime;

    private Integer updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleAlias() {
        return titleAlias;
    }

    public void setTitleAlias(String titleAlias) {
        this.titleAlias = titleAlias;
    }

    public Object getTitleType() {
        return titleType;
    }

    public void setTitleType(Object titleType) {
        this.titleType = titleType;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public Object getShowInNav() {
        return showInNav;
    }

    public void setShowInNav(Object showInNav) {
        this.showInNav = showInNav;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getSort() {
        return sort;
    }

    public void setSort(Object sort) {
        this.sort = sort;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

}