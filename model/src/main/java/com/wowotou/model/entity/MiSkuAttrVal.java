package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmSkuAttrVal)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:01
 */
@Document("mi_sku_attr_val")
public class MiSkuAttrVal implements Serializable {
    private static final long serialVersionUID = -49545610989518450L;
    @Id
    private String id;

    private Integer goodsId;
    /**
     * 属性编码
     */
    private Integer symbol;
    /**
     * 属性值
     */
    private String value;

    private Integer attrId;

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

    public Integer getSymbol() {
        return symbol;
    }

    public void setSymbol(Integer symbol) {
        this.symbol = symbol;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

}