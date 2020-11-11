package com.wowotou.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 微信类型表(LmWxType)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:03
 */
@Document("mi_wx_type")
public class MiWxType implements Serializable {
    private static final long serialVersionUID = -10312533481875022L;

    private Object typeId;

    private String name;

    private Integer createTime;

    private Integer updateTime;


    public Object getTypeId() {
        return typeId;
    }

    public void setTypeId(Object typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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