package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * (LmPayChannel)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:01
 */
@Document("mi_pay_channel")
public class MiPayChannel implements Serializable {
    private static final long serialVersionUID = 503793267162432632L;

    @Id
    private String id;
    /**
     * 名称
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
     * img
     */
    private String img;

    private Long cTime;

    private Long mTime;

    private String icon;

    private String link;

    private short isDeleted;

    private  String typeId;
    private  Object typeId2;

    @Indexed(unique = true)
    private String api;
    @Indexed(unique = true)
    private String api2;

    private String param;

    private String gateway;

    private String notifyUrl;

    private String returnUrl;

    private Double rate;

    private Integer strategy;

    private Integer cango;

    private Integer issocket;
    /**
     * pc
     */
    private String query;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getApi2() {
        return api2;
    }

    public void setApi2(String api2) {
        this.api2 = api2;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }

    public Integer getCango() {
        return cango;
    }

    public void setCango(Integer cango) {
        this.cango = cango;
    }

    public Integer getIssocket() {
        return issocket;
    }

    public void setIssocket(Integer issocket) {
        this.issocket = issocket;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "MiPayChannel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", titleAlias='" + titleAlias + '\'' +
                ", titleType=" + titleType +
                ", pid=" + pid +
                ", showInNav=" + showInNav +
                ", status=" + status +
                ", sort=" + sort +
                ", catDesc='" + catDesc + '\'' +
                ", img='" + img + '\'' +
                ", cTime=" + cTime +
                ", mTime=" + mTime +
                ", icon='" + icon + '\'' +
                ", link='" + link + '\'' +
                ", isDeleted=" + isDeleted +
                ", typeId='" + typeId + '\'' +
                ", api='" + api + '\'' +
                ", api2='" + api2 + '\'' +
                ", param='" + param + '\'' +
                ", gateway='" + gateway + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", rate=" + rate +
                ", strategy=" + strategy +
                ", cango=" + cango +
                ", issocket=" + issocket +
                ", query='" + query + '\'' +
                '}';
    }

    public Object getTypeId2() {
        return typeId2;
    }

    public void setTypeId2(Object typeId2) {
        this.typeId2 = typeId2;
    }
}