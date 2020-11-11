package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmAdvPosition)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:55
 */
@Document("mi_adv_position")
public class MiAdvPosition implements Serializable {
    private static final long serialVersionUID = -30926166266524446L;
    /**
     * 表id
     */
    @Id
    private String id;
    /**
     * 广告位置名称
     */
    private String positionName;
    /**
     * 广告位宽度
     */
    private Object adWidth;
    /**
     * 广告位高度
     */
    private Object adHeight;
    /**
     * 广告描述
     */
    private String positionDesc;
    /**
     * 模板
     */
    private Object positionStyle;
    /**
     * 0关闭1开启
     */
    private Object status;

    private Integer createTime;

    private Integer updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Object getAdWidth() {
        return adWidth;
    }

    public void setAdWidth(Object adWidth) {
        this.adWidth = adWidth;
    }

    public Object getAdHeight() {
        return adHeight;
    }

    public void setAdHeight(Object adHeight) {
        this.adHeight = adHeight;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public Object getPositionStyle() {
        return positionStyle;
    }

    public void setPositionStyle(Object positionStyle) {
        this.positionStyle = positionStyle;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
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