package com.wowotou.payservice.param;

public class GoodsEntity {
    /**
     * sku_number : 1
     * goods_id : 42763057954
     * sku_id : 351600868588
     */
    private int sku_number;
    private String goods_id;
    private long sku_id;

    public void setSku_number(int sku_number) {
        this.sku_number = sku_number;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public void setSku_id(long sku_id) {
        this.sku_id = sku_id;
    }

    public int getSku_number() {
        return sku_number;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public long getSku_id() {
        return sku_id;
    }

}
