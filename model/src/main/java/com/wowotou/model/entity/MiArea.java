package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 地区表(LmArea)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:59
 */
@Document("mi_area")
public class MiArea implements Serializable {
    private static final long serialVersionUID = 433634091932526738L;
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 简称
     */
    private String shortname;
    /**
     * 名称
     */
    private String name;
    /**
     * 全称
     */
    private String mergename;
    /**
     * 层级 0 1 2 省市区县
     */
    private Object level;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * 长途区号
     */
    private String code;
    /**
     * 邮编
     */
    private String zip;
    /**
     * 首字母
     */
    private String first;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMergename() {
        return mergename;
    }

    public void setMergename(String mergename) {
        this.mergename = mergename;
    }

    public Object getLevel() {
        return level;
    }

    public void setLevel(Object level) {
        this.level = level;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}