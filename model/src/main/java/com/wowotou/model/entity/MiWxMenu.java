package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信设置->微信菜单(LmWxMenu)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:02
 */
@Document("mi_wx_menu")
public class MiWxMenu implements Serializable {
    private static final long serialVersionUID = -81117980591619867L;
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 店铺id
     */
    private Integer storeId;

    private Integer wxAid;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜图标单
     */
    private String ico;
    /**
     * 父菜单
     */
    private Integer pid;
    /**
     * 1普通url 2 图文素材 3 功能
     */
    private Object menuEventType;
    /**
     * 图文消息ID
     */
    private Integer mediaId;
    /**
     * 菜单url
     */
    private String menuEventUrl;
    /**
     * 触发数
     */
    private Integer hits;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 创建日期
     */
    private Integer createTime;
    /**
     * 修改日期
     */
    private Integer updateTime;

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Object getMenuEventType() {
        return menuEventType;
    }

    public void setMenuEventType(Object menuEventType) {
        this.menuEventType = menuEventType;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getMenuEventUrl() {
        return menuEventUrl;
    }

    public void setMenuEventUrl(String menuEventUrl) {
        this.menuEventUrl = menuEventUrl;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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