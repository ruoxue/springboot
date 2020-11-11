package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmAdv)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:55
 */
@Document("mi_adv")
public class MiAdv implements Serializable {
    private static final long serialVersionUID = 363459181057472885L;
    /**
     * 广告id
     */
    @Id
    private String id;
    /**
     * 广告位置ID
     */
    private Object pid;
    /**
     * 广告类型
     */
    private Object mediaType;
    /**
     * 广告名称
     */
    private String adName;
    /**
     * 链接地址
     */
    private String adLink;
    /**
     * 图片地址
     */
    private Object adImage;
    /**
     * 投放时间
     */
    private Integer startTime;
    /**
     * 结束时间
     */
    private Integer endTime;
    /**
     * 添加人
     */
    private String linkAdmin;
    /**
     * 添加人邮箱
     */
    private String linkEmail;
    /**
     * 添加人联系电话
     */
    private String linkPhone;
    /**
     * 点击量
     */
    private Object clickCount;

    private Integer sort;
    /**
     * 是否显示
     */
    private Object status;
    /**
     * 排序
     */
    private Object orderby;
    /**
     * 是否开启浏览器新窗口
     */
    private Object target;
    /**
     * 背景颜色
     */
    private String bgcolor;

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

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public Object getMediaType() {
        return mediaType;
    }

    public void setMediaType(Object mediaType) {
        this.mediaType = mediaType;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdLink() {
        return adLink;
    }

    public void setAdLink(String adLink) {
        this.adLink = adLink;
    }

    public Object getAdImage() {
        return adImage;
    }

    public void setAdImage(Object adImage) {
        this.adImage = adImage;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getLinkAdmin() {
        return linkAdmin;
    }

    public void setLinkAdmin(String linkAdmin) {
        this.linkAdmin = linkAdmin;
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Object getClickCount() {
        return clickCount;
    }

    public void setClickCount(Object clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getOrderby() {
        return orderby;
    }

    public void setOrderby(Object orderby) {
        this.orderby = orderby;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }


}