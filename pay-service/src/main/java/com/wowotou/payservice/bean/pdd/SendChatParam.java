package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class SendChatParam implements Serializable {

    /**
     * order_shipping_list : [{"shipping_id":"0","tracking_num":"1719195840","shipping_name":"加运美","order_sn":"191221-662575186993090"}]
     */
    private List<Order_shipping_listEntity> order_shipping_list;

    public void setOrder_shipping_list(List<Order_shipping_listEntity> order_shipping_list) {
        this.order_shipping_list = order_shipping_list;
    }

    public List<Order_shipping_listEntity> getOrder_shipping_list() {
        return order_shipping_list;
    }

    public static class Order_shipping_listEntity {
        /**
         * shipping_id : 0
         * tracking_num : 1719195840
         * shipping_name : 加运美
         * order_sn : 191221-662575186993090
         */
        private String shipping_id;
        private String tracking_num;
        private String shipping_name;
        private String order_sn;

        public void setShipping_id(String shipping_id) {
            this.shipping_id = shipping_id;
        }

        public void setTracking_num(String tracking_num) {
            this.tracking_num = tracking_num;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getShipping_id() {
            return shipping_id;
        }

        public String getTracking_num() {
            return tracking_num;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public String getOrder_sn() {
            return order_sn;
        }
    }
}
