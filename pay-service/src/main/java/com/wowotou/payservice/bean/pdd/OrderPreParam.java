package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;

public class OrderPreParam implements Serializable {

    /**
     * pay_app_id : 9
     * return_url : https://mobile.yangkeduo.com/transac_wappay_callback.html?order_sn=191219-364136039193090
     * version : 3
     * attribute_fields : {"forbid_pappay":"1","paid_times":0,"forbid_contractcode":"1"}
     * order_sn : 191219-364136039193090
     */
    private int pay_app_id;
    private String return_url;
    private int version;
    private Attribute_fieldsEntity attribute_fields=new Attribute_fieldsEntity() ;
    private String order_sn;

    public void setPay_app_id(int pay_app_id) {
        this.pay_app_id = pay_app_id;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setAttribute_fields(Attribute_fieldsEntity attribute_fields) {
        this.attribute_fields = attribute_fields;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public int getPay_app_id() {
        return pay_app_id;
    }

    public String getReturn_url() {
        return return_url;
    }

    public int getVersion() {
        return version;
    }

    public Attribute_fieldsEntity getAttribute_fields() {
        return attribute_fields;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public class Attribute_fieldsEntity {
        /**
         * forbid_pappay : 1
         * paid_times : 0
         * forbid_contractcode : 1
         */
        private String forbid_pappay="1";
        private int paid_times=0;
        private String forbid_contractcode="1";

        public void setForbid_pappay(String forbid_pappay) {
            this.forbid_pappay = forbid_pappay;
        }

        public void setPaid_times(int paid_times) {
            this.paid_times = paid_times;
        }

        public void setForbid_contractcode(String forbid_contractcode) {
            this.forbid_contractcode = forbid_contractcode;
        }

        public String getForbid_pappay() {
            return forbid_pappay;
        }

        public int getPaid_times() {
            return paid_times;
        }

        public String getForbid_contractcode() {
            return forbid_contractcode;
        }
    }
}
