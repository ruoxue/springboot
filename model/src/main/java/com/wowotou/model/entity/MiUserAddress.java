package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 收获地址(LmUserAddress)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:02
 */
@Document("mi_user_address")
public class MiUserAddress implements Serializable {
    private static final long serialVersionUID = 419593206472716266L;

    @Id
    private String id;

    private Integer areaid;

    private Integer uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}