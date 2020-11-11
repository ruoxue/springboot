package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;

public class PddPayModel implements Serializable {

    /**
     * server_time : 1576758631
     * gateway_url : https://mapi.alipay.com/gateway.do
     * query : {"subject":"订单编号191219-618262365333090","_input_charset":"utf-8","sign":"SFNsbMO6AGtMnup59PGK5yTniys/SVusnMZHh44xoscQ2QOoE5IBpvB05X78pIFE7xNDJkKe0COSf0MxhrHVvHdliRd/vXM4eE+XWCp7ZmChfytj3vU7MPpf1z5SE5wZJO33p4ww4rxELhxd2LvU+WAP17n53Fe6U867ttN0T2E=","notify_url":"http://payv3.yangkeduo.com/notify/9","payment_type":"1","out_trade_no":"XP0019121920200806851021007848","partner":"2088911201740274","service":"alipay.wap.create.direct.pay.by.user","total_fee":"100","return_url":"https://mobile.yangkeduo.com/transac_wappay_callback.html?order_sn=191219-618262365333090","goods_type":"1","sign_type":"RSA","seller_id":"pddzhifubao@yiran.com"}
     * status : 10000
     */
    private int server_time;
    private String gateway_url;
    private QueryEntity query;
    private int status;

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public void setGateway_url(String gateway_url) {
        this.gateway_url = gateway_url;
    }

    public void setQuery(QueryEntity query) {
        this.query = query;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getServer_time() {
        return server_time;
    }

    public String getGateway_url() {
        return gateway_url;
    }

    public QueryEntity getQuery() {
        return query;
    }

    public int getStatus() {
        return status;
    }

    public class QueryEntity {
        /**
         * subject : 订单编号191219-618262365333090
         * _input_charset : utf-8
         * sign : SFNsbMO6AGtMnup59PGK5yTniys/SVusnMZHh44xoscQ2QOoE5IBpvB05X78pIFE7xNDJkKe0COSf0MxhrHVvHdliRd/vXM4eE+XWCp7ZmChfytj3vU7MPpf1z5SE5wZJO33p4ww4rxELhxd2LvU+WAP17n53Fe6U867ttN0T2E=
         * notify_url : http://payv3.yangkeduo.com/notify/9
         * payment_type : 1
         * out_trade_no : XP0019121920200806851021007848
         * partner : 2088911201740274
         * service : alipay.wap.create.direct.pay.by.user
         * total_fee : 100
         * return_url : https://mobile.yangkeduo.com/transac_wappay_callback.html?order_sn=191219-618262365333090
         * goods_type : 1
         * sign_type : RSA
         * seller_id : pddzhifubao@yiran.com
         */
        private String subject;
        private String _input_charset;
        private String sign;
        private String notify_url;
        private String payment_type;
        private String out_trade_no;
        private String partner;
        private String service;
        private String total_fee;
        private String return_url;
        private String goods_type;
        private String sign_type;
        private String seller_id;

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void set_input_charset(String _input_charset) {
            this._input_charset = _input_charset;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public void setNotify_url(String notify_url) {
            this.notify_url = notify_url;
        }

        public void setPayment_type(String payment_type) {
            this.payment_type = payment_type;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public void setService(String service) {
            this.service = service;
        }

        public void setTotal_fee(String total_fee) {
            this.total_fee = total_fee;
        }

        public void setReturn_url(String return_url) {
            this.return_url = return_url;
        }

        public void setGoods_type(String goods_type) {
            this.goods_type = goods_type;
        }

        public void setSign_type(String sign_type) {
            this.sign_type = sign_type;
        }

        public void setSeller_id(String seller_id) {
            this.seller_id = seller_id;
        }

        public String getSubject() {
            return subject;
        }

        public String get_input_charset() {
            return _input_charset;
        }

        public String getSign() {
            return sign;
        }

        public String getNotify_url() {
            return notify_url;
        }

        public String getPayment_type() {
            return payment_type;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public String getPartner() {
            return partner;
        }

        public String getService() {
            return service;
        }

        public String getTotal_fee() {
            return total_fee;
        }

        public String getReturn_url() {
            return return_url;
        }

        public String getGoods_type() {
            return goods_type;
        }

        public String getSign_type() {
            return sign_type;
        }

        public String getSeller_id() {
            return seller_id;
        }
    }
}
