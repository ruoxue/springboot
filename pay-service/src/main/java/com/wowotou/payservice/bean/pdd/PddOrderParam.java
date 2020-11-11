package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class PddOrderParam implements Serializable {

    /**
     * pay_app_id : 9
     * is_app : 0
     * source_channel : 0
     * duoduo_type : 0
     * biz_type : 0
     * address_id : 13060888504
     * anti_content : 0anAfxnUmNcYY9Ta5WIdCbmc4lTVv4d_HvAjLOA-xK4C411K4y4OgKcy1b86ecHhELRngylCXTGr4Cr4UR2zr9BmZC801QwRGbheUAq9o99R9EHcg82EL5cGB2NOo0r9_aornUgXi4Gtw3uBFMocRGQcRG7oTsmeIRxI1hDs3bDkFJS3zaEOvVtYzHMykzIBxBDfXyFcOwNbiwu1v3jxqJKa2V5gFB4PJ1ZmGVSusRh12R_Z444m2Cnsy1GuCmK5ElEw03Fe9iIhc_xB7h0-ZyUU5z36tnVPqQqj2rZF_aFyE8DSFSS-W2iXjay83p_LXt1_1KRLwdIbW5he4gLv1ZLSFM9Tr50ZduSBst4Rn26WMGuZ5VMLosJ9svcLhGT9hmRCkAoUgNoJ26Wwy3XtWsa5fLhloXRT9Z2TbVql90CB_xvLzsfAwIgPdsmSgaUQlzdVqpqe4_Pmui018_oXzMGp01gOxHPPGZ2MzocNGeTZIMgTWeSvFw4IyhLrHIjUPnlD9n4WBGWVh5PWF77_HJUMaku_oG12tgN-Kbu7eoWj3KE_hhOLSllL0AbckwYkAoCfJCamzVHWj9ekJKNsqZB-8EYIrv6VzPi7yjqleFQtKjC6-ApHjpaiMTk47zbMU8l8NYEuNRNORH8sD1rBC
     * goods : [{"sku_number":1,"goods_id":"77939582775","sku_id":445875487086}]
     * source_type : 0
     * attribute_fields : {"create_order_token":"d20aa679-3d52-4a51-b1da-b093427c1ffb","page_from":0,"create_order_check":"5r_3TmSdVLKKHL6QuTTdNwdbayz_PCXe6Va48C7m1I4_xGwTP-jRNy310ZLyK7YF","original_front_env":0,"current_front_env":1}
     * version : 1
     * page_id : 10004_1576675329129_eTWw89I0iK
     * group_id : 26785050468
     */
    private int pay_app_id=9;
    private String is_app="0";
    private String source_channel="0";
    private int duoduo_type=0;
    private int biz_type=0;
    private long address_id;
    private String anti_content;
    private List<GoodsEntity> goods;
    private int source_type=0;
    private Attribute_fieldsEntity attribute_fields;
    private int version=1;
    private String page_id;
    private String group_id;

    public void setPay_app_id(int pay_app_id) {
        this.pay_app_id = pay_app_id;
    }

    public void setIs_app(String is_app) {
        this.is_app = is_app;
    }

    public void setSource_channel(String source_channel) {
        this.source_channel = source_channel;
    }

    public void setDuoduo_type(int duoduo_type) {
        this.duoduo_type = duoduo_type;
    }

    public void setBiz_type(int biz_type) {
        this.biz_type = biz_type;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public void setAnti_content(String anti_content) {
        this.anti_content = anti_content;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }

    public void setAttribute_fields(Attribute_fieldsEntity attribute_fields) {
        this.attribute_fields = attribute_fields;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public int getPay_app_id() {
        return pay_app_id;
    }

    public String getIs_app() {
        return is_app;
    }

    public String getSource_channel() {
        return source_channel;
    }

    public int getDuoduo_type() {
        return duoduo_type;
    }

    public int getBiz_type() {
        return biz_type;
    }

    public long getAddress_id() {
        return address_id;
    }

    public String getAnti_content() {
        return anti_content;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public int getSource_type() {
        return source_type;
    }

    public Attribute_fieldsEntity getAttribute_fields() {
        return attribute_fields;
    }

    public int getVersion() {
        return version;
    }

    public String getPage_id() {
        return page_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public static class GoodsEntity {
        /**
         * sku_number : 1
         * goods_id : 77939582775
         * sku_id : 445875487086
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

    public static  class Attribute_fieldsEntity {
        /**
         * create_order_token : d20aa679-3d52-4a51-b1da-b093427c1ffb
         * page_from : 0
         * create_order_check : 5r_3TmSdVLKKHL6QuTTdNwdbayz_PCXe6Va48C7m1I4_xGwTP-jRNy310ZLyK7YF
         * original_front_env : 0
         * current_front_env : 1
         */
        private String create_order_token;
        private int page_from;
        private String create_order_check;
        private int original_front_env=0;
        private int current_front_env=1;

        public void setCreate_order_token(String create_order_token) {
            this.create_order_token = create_order_token;
        }

        public void setPage_from(int page_from) {
            this.page_from = page_from;
        }

        public void setCreate_order_check(String create_order_check) {
            this.create_order_check = create_order_check;
        }

        public void setOriginal_front_env(int original_front_env) {
            this.original_front_env = original_front_env;
        }

        public void setCurrent_front_env(int current_front_env) {
            this.current_front_env = current_front_env;
        }

        public String getCreate_order_token() {
            return create_order_token;
        }

        public int getPage_from() {
            return page_from;
        }

        public String getCreate_order_check() {
            return create_order_check;
        }

        public int getOriginal_front_env() {
            return original_front_env;
        }

        public int getCurrent_front_env() {
            return current_front_env;
        }
    }
}
