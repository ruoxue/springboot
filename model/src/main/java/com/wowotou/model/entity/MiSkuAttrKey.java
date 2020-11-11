package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmSkuAttrKey)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:01
 */
@Document("mi_sku_attr_key")
public class MiSkuAttrKey implements Serializable {
    private static final long serialVersionUID = -62662047646757969L;

    @Id
    private String id;

    private Integer goodsId;
    /**
     * 属性
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}