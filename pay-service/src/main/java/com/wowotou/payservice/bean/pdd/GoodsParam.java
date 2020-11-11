package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GoodsParam implements Serializable {

    /**
     * pre_sale_type : 4
     * size : 10
     * sku_price_range : [10000,10000]
     * sold_out : 0
     * out_goods_sn_list : []
     * page : 1
     * goods_id_list : []
     * sold_quantity : []
     * is_onsale : 1
     */
    private int pre_sale_type=4;
    private int size=10;
    private List<Integer> sku_price_range;
    private int sold_out=0;
    private List<?> out_goods_sn_list=new ArrayList<>();
    private int page=1;
    private List<?> goods_id_list=new ArrayList<>();
    private List<?> sold_quantity=new ArrayList<>();
    private int is_onsale=1;

    public void setPre_sale_type(int pre_sale_type) {
        this.pre_sale_type = pre_sale_type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSku_price_range(List<Integer> sku_price_range) {
        this.sku_price_range = sku_price_range;
    }

    public void setSold_out(int sold_out) {
        this.sold_out = sold_out;
    }

    public void setOut_goods_sn_list(List<?> out_goods_sn_list) {
        this.out_goods_sn_list = out_goods_sn_list;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setGoods_id_list(List<?> goods_id_list) {
        this.goods_id_list = goods_id_list;
    }

    public void setSold_quantity(List<?> sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public void setIs_onsale(int is_onsale) {
        this.is_onsale = is_onsale;
    }

    public int getPre_sale_type() {
        return pre_sale_type;
    }

    public int getSize() {
        return size;
    }

    public List<Integer> getSku_price_range() {
        return sku_price_range;
    }

    public int getSold_out() {
        return sold_out;
    }

    public List<?> getOut_goods_sn_list() {
        return out_goods_sn_list;
    }

    public int getPage() {
        return page;
    }

    public List<?> getGoods_id_list() {
        return goods_id_list;
    }

    public List<?> getSold_quantity() {
        return sold_quantity;
    }

    public int getIs_onsale() {
        return is_onsale;
    }
}
