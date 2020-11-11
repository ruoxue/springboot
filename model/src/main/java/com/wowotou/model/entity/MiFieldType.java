package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 字段类型表(LmFieldType)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:59
 */
@Document("mi_field_type")
public class MiFieldType implements Serializable {
    private static final long serialVersionUID = -19861379727544857L;

    @Id
    private String id;
    /**
     * 字段类型
     */
    private String name;
    /**
     * 中文类型名
     */
    private String title;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 默认定义
     */
    private String defaultDefine;
    /**
     * 是否需要设置选项
     */
    private Object isoption;
    /**
     * 是否自由字符
     */
    private Object istring;
    /**
     * 验证规则
     */
    private String rules;

    public String getId() {
        return id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDefaultDefine() {
        return defaultDefine;
    }

    public void setDefaultDefine(String defaultDefine) {
        this.defaultDefine = defaultDefine;
    }

    public Object getIsoption() {
        return isoption;
    }

    public void setIsoption(Object isoption) {
        this.isoption = isoption;
    }

    public Object getIstring() {
        return istring;
    }

    public void setIstring(Object istring) {
        this.istring = istring;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

}