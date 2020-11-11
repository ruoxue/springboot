package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmLink)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:00
 */
@Document("mi_link")
public class MiLink implements Serializable {
    private static final long serialVersionUID = -43441238486413644L;

    @Id
    private String id;
    /**
     * 链接名称
     */
    private String name;
    /**
     * 链接URL
     */
    private String url;
    /**
     * 所属栏目ID
     */
    private Object typeId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 联系QQ
     */
    private String qq;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 0禁用1启用
     */
    private int status;

    private Long cTime;

    private Long mTime;

    public String getId() {
        return id;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getTypeId() {
        return typeId;
    }

    public void setTypeId(Object typeId) {
        this.typeId = typeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


}