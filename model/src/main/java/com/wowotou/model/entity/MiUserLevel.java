package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 用户等级表(LmUserLevel)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:02
 */
@Document("mi_user_level")
public class MiUserLevel implements Serializable {
    private static final long serialVersionUID = -96256701733628755L;
    /**
     * 表id
     */
    @Id
    private String id;
    /**
     * 头衔名称
     */
    private String levelName;
    /**
     * 等级必要金额
     */
    private Double amount;
    /**
     * 折扣
     */
    private Object discount;

    private Object status;

    private Integer sort;
    /**
     * 头街 描述
     */
    private String description;

    private Long cTime;

    private Long mTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Object getDiscount() {
        return discount;
    }

    public void setDiscount(Object discount) {
        this.discount = discount;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}