package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 管理员分组(LmAuthGroup)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:59
 */
@Document("mi_auth_group")
public class MiAuthGroup implements Serializable {
    private static final long serialVersionUID = 310821111183542619L;
    /**
     * 分组id
     */
    @Id
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 状态
     */
    private Object status;
    /**
     * 规则
     */
    private Object rules;
    /**
     * 添加时间
     */
    private Integer cTime;

    private Integer mTime;

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

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getRules() {
        return rules;
    }

    public void setRules(Object rules) {
        this.rules = rules;
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
}