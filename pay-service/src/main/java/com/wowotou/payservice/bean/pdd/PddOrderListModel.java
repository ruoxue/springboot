package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class PddOrderListModel implements Serializable {

    /**
     * result : {"totalItemNum":1,"pageItems":[{"shipping_id":0,"group_status":1,"discount_amount":0,"stockout_source_type":null,"step_pay_orders":null,"pre_delivery_status":null,"order_time":1576919303,"type":0,"order_handle_status":null,"lucky_status":0,"spec":null,"platform_discount":null,"order_status":1,"event_type":0,"track_update_timeout_status":null,"order_amount":1100,"mall_id":834542590,"payment_start_time":null,"receive_name":"李小凡","order_attributes":"{\"17\":\"4\",\"3\":\"0\"}","favorite_status":null,"out_sku_sn":null,"goods_name":"蓝牙鼠标 可以连接ios系统","delivery_install_value":null,"biz_type":0,"goods_id":78701050546,"expire_time":null,"sku_id":447894428287,"success_time":null,"use_single_group_card":null,"pay_time":1576919392,"shipping_status":0,"province_name":"浙江省","after_sales_id":null,"payment_end_time":null,"is_exist_fine_info":null,"order_id":"980067953132773090","city_id":383,"home_install_value":null,"thumb_url":"http://t00img.yangkeduo.com/goods/images/2019-12-20/2196e1c0c6b855071cc00f5542e53175.jpeg","total_discount":null,"goods_price":1100,"merchant_discount":null,"created_at":1576919303,"delivery_home_value":null,"uid":1075676224530,"district_name":"西湖区","service_amount":0,"pay_status":2,"city_name":"杭州市","group_order_id":"980067953132773090","nickname":null,"tracking_number":null,"shipping_address":"益乐新村北6-6","buyer_memo":null,"is_pre_sale":null,"shipping_time":0,"after_sales_status":null,"receive_mobile":"133****2661","imei_status":0,"goods_amount":1100,"mobile":"133****2661","remark_status":null,"avatar":null,"confirm_time":1576919392,"shipping_amount":0,"out_goods_sn":null,"event_discount":null,"goods_number":1,"province_id":31,"promise_shipping_time":1577092192,"trade_type":0,"district_id":3229,"group_time":1576919392,"got_timeout_status":null,"order_sn":"191221-067953132773090"}]}
     * success : true
     * errorCode : 1000000
     * errorMsg : null
     */
    private ResultEntity result;
    private boolean success;
    private int errorCode;
    private String errorMsg;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResultEntity getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public class ResultEntity {
        /**
         * totalItemNum : 1
         * pageItems : [{"shipping_id":0,"group_status":1,"discount_amount":0,"stockout_source_type":null,"step_pay_orders":null,"pre_delivery_status":null,"order_time":1576919303,"type":0,"order_handle_status":null,"lucky_status":0,"spec":null,"platform_discount":null,"order_status":1,"event_type":0,"track_update_timeout_status":null,"order_amount":1100,"mall_id":834542590,"payment_start_time":null,"receive_name":"李小凡","order_attributes":"{\"17\":\"4\",\"3\":\"0\"}","favorite_status":null,"out_sku_sn":null,"goods_name":"蓝牙鼠标 可以连接ios系统","delivery_install_value":null,"biz_type":0,"goods_id":78701050546,"expire_time":null,"sku_id":447894428287,"success_time":null,"use_single_group_card":null,"pay_time":1576919392,"shipping_status":0,"province_name":"浙江省","after_sales_id":null,"payment_end_time":null,"is_exist_fine_info":null,"order_id":"980067953132773090","city_id":383,"home_install_value":null,"thumb_url":"http://t00img.yangkeduo.com/goods/images/2019-12-20/2196e1c0c6b855071cc00f5542e53175.jpeg","total_discount":null,"goods_price":1100,"merchant_discount":null,"created_at":1576919303,"delivery_home_value":null,"uid":1075676224530,"district_name":"西湖区","service_amount":0,"pay_status":2,"city_name":"杭州市","group_order_id":"980067953132773090","nickname":null,"tracking_number":null,"shipping_address":"益乐新村北6-6","buyer_memo":null,"is_pre_sale":null,"shipping_time":0,"after_sales_status":null,"receive_mobile":"133****2661","imei_status":0,"goods_amount":1100,"mobile":"133****2661","remark_status":null,"avatar":null,"confirm_time":1576919392,"shipping_amount":0,"out_goods_sn":null,"event_discount":null,"goods_number":1,"province_id":31,"promise_shipping_time":1577092192,"trade_type":0,"district_id":3229,"group_time":1576919392,"got_timeout_status":null,"order_sn":"191221-067953132773090"}]
         */
        private int totalItemNum;
        private List<PageItemsEntity> pageItems;

        public void setTotalItemNum(int totalItemNum) {
            this.totalItemNum = totalItemNum;
        }

        public void setPageItems(List<PageItemsEntity> pageItems) {
            this.pageItems = pageItems;
        }

        public int getTotalItemNum() {
            return totalItemNum;
        }

        public List<PageItemsEntity> getPageItems() {
            return pageItems;
        }

        public class PageItemsEntity {
            /**
             * shipping_id : 0
             * group_status : 1
             * discount_amount : 0
             * stockout_source_type : null
             * step_pay_orders : null
             * pre_delivery_status : null
             * order_time : 1576919303
             * type : 0
             * order_handle_status : null
             * lucky_status : 0
             * spec : null
             * platform_discount : null
             * order_status : 1
             * event_type : 0
             * track_update_timeout_status : null
             * order_amount : 1100
             * mall_id : 834542590
             * payment_start_time : null
             * receive_name : 李小凡
             * order_attributes : {"17":"4","3":"0"}
             * favorite_status : null
             * out_sku_sn : null
             * goods_name : 蓝牙鼠标 可以连接ios系统
             * delivery_install_value : null
             * biz_type : 0
             * goods_id : 78701050546
             * expire_time : null
             * sku_id : 447894428287
             * success_time : null
             * use_single_group_card : null
             * pay_time : 1576919392
             * shipping_status : 0
             * province_name : 浙江省
             * after_sales_id : null
             * payment_end_time : null
             * is_exist_fine_info : null
             * order_id : 980067953132773090
             * city_id : 383
             * home_install_value : null
             * thumb_url : http://t00img.yangkeduo.com/goods/images/2019-12-20/2196e1c0c6b855071cc00f5542e53175.jpeg
             * total_discount : null
             * goods_price : 1100
             * merchant_discount : null
             * created_at : 1576919303
             * delivery_home_value : null
             * uid : 1075676224530
             * district_name : 西湖区
             * service_amount : 0
             * pay_status : 2
             * city_name : 杭州市
             * group_order_id : 980067953132773090
             * nickname : null
             * tracking_number : null
             * shipping_address : 益乐新村北6-6
             * buyer_memo : null
             * is_pre_sale : null
             * shipping_time : 0
             * after_sales_status : null
             * receive_mobile : 133****2661
             * imei_status : 0
             * goods_amount : 1100
             * mobile : 133****2661
             * remark_status : null
             * avatar : null
             * confirm_time : 1576919392
             * shipping_amount : 0
             * out_goods_sn : null
             * event_discount : null
             * goods_number : 1
             * province_id : 31
             * promise_shipping_time : 1577092192
             * trade_type : 0
             * district_id : 3229
             * group_time : 1576919392
             * got_timeout_status : null
             * order_sn : 191221-067953132773090
             */
            private int shipping_id;
            private int group_status;
            private int discount_amount;
            private String stockout_source_type;
            private String step_pay_orders;
            private String pre_delivery_status;
            private int order_time;
            private int type;
            private String order_handle_status;
            private int lucky_status;
            private String spec;
            private String platform_discount;
            private int order_status;
            private int event_type;
            private String track_update_timeout_status;
            private int order_amount;
            private int mall_id;
            private String payment_start_time;
            private String receive_name;
            private String order_attributes;
            private String favorite_status;
            private String out_sku_sn;
            private String goods_name;
            private String delivery_install_value;
            private int biz_type;
            private long goods_id;
            private String expire_time;
            private long sku_id;
            private String success_time;
            private String use_single_group_card;
            private int pay_time;
            private int shipping_status;
            private String province_name;
            private String after_sales_id;
            private String payment_end_time;
            private String is_exist_fine_info;
            private String order_id;
            private int city_id;
            private String home_install_value;
            private String thumb_url;
            private String total_discount;
            private int goods_price;
            private String merchant_discount;
            private int created_at;
            private String delivery_home_value;
            private long uid;
            private String district_name;
            private int service_amount;
            private int pay_status;
            private String city_name;
            private String group_order_id;
            private String nickname;
            private String tracking_number;
            private String shipping_address;
            private String buyer_memo;
            private String is_pre_sale;
            private int shipping_time;
            private String after_sales_status;
            private String receive_mobile;
            private int imei_status;
            private int goods_amount;
            private String mobile;
            private String remark_status;
            private String avatar;
            private int confirm_time;
            private int shipping_amount;
            private String out_goods_sn;
            private String event_discount;
            private int goods_number;
            private int province_id;
            private int promise_shipping_time;
            private int trade_type;
            private int district_id;
            private int group_time;
            private String got_timeout_status;
            private String order_sn;

            public void setShipping_id(int shipping_id) {
                this.shipping_id = shipping_id;
            }

            public void setGroup_status(int group_status) {
                this.group_status = group_status;
            }

            public void setDiscount_amount(int discount_amount) {
                this.discount_amount = discount_amount;
            }

            public void setStockout_source_type(String stockout_source_type) {
                this.stockout_source_type = stockout_source_type;
            }

            public void setStep_pay_orders(String step_pay_orders) {
                this.step_pay_orders = step_pay_orders;
            }

            public void setPre_delivery_status(String pre_delivery_status) {
                this.pre_delivery_status = pre_delivery_status;
            }

            public void setOrder_time(int order_time) {
                this.order_time = order_time;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setOrder_handle_status(String order_handle_status) {
                this.order_handle_status = order_handle_status;
            }

            public void setLucky_status(int lucky_status) {
                this.lucky_status = lucky_status;
            }

            public void setSpec(String spec) {
                this.spec = spec;
            }

            public void setPlatform_discount(String platform_discount) {
                this.platform_discount = platform_discount;
            }

            public void setOrder_status(int order_status) {
                this.order_status = order_status;
            }

            public void setEvent_type(int event_type) {
                this.event_type = event_type;
            }

            public void setTrack_update_timeout_status(String track_update_timeout_status) {
                this.track_update_timeout_status = track_update_timeout_status;
            }

            public void setOrder_amount(int order_amount) {
                this.order_amount = order_amount;
            }

            public void setMall_id(int mall_id) {
                this.mall_id = mall_id;
            }

            public void setPayment_start_time(String payment_start_time) {
                this.payment_start_time = payment_start_time;
            }

            public void setReceive_name(String receive_name) {
                this.receive_name = receive_name;
            }

            public void setOrder_attributes(String order_attributes) {
                this.order_attributes = order_attributes;
            }

            public void setFavorite_status(String favorite_status) {
                this.favorite_status = favorite_status;
            }

            public void setOut_sku_sn(String out_sku_sn) {
                this.out_sku_sn = out_sku_sn;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public void setDelivery_install_value(String delivery_install_value) {
                this.delivery_install_value = delivery_install_value;
            }

            public void setBiz_type(int biz_type) {
                this.biz_type = biz_type;
            }

            public void setGoods_id(long goods_id) {
                this.goods_id = goods_id;
            }

            public void setExpire_time(String expire_time) {
                this.expire_time = expire_time;
            }

            public void setSku_id(long sku_id) {
                this.sku_id = sku_id;
            }

            public void setSuccess_time(String success_time) {
                this.success_time = success_time;
            }

            public void setUse_single_group_card(String use_single_group_card) {
                this.use_single_group_card = use_single_group_card;
            }

            public void setPay_time(int pay_time) {
                this.pay_time = pay_time;
            }

            public void setShipping_status(int shipping_status) {
                this.shipping_status = shipping_status;
            }

            public void setProvince_name(String province_name) {
                this.province_name = province_name;
            }

            public void setAfter_sales_id(String after_sales_id) {
                this.after_sales_id = after_sales_id;
            }

            public void setPayment_end_time(String payment_end_time) {
                this.payment_end_time = payment_end_time;
            }

            public void setIs_exist_fine_info(String is_exist_fine_info) {
                this.is_exist_fine_info = is_exist_fine_info;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public void setHome_install_value(String home_install_value) {
                this.home_install_value = home_install_value;
            }

            public void setThumb_url(String thumb_url) {
                this.thumb_url = thumb_url;
            }

            public void setTotal_discount(String total_discount) {
                this.total_discount = total_discount;
            }

            public void setGoods_price(int goods_price) {
                this.goods_price = goods_price;
            }

            public void setMerchant_discount(String merchant_discount) {
                this.merchant_discount = merchant_discount;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setDelivery_home_value(String delivery_home_value) {
                this.delivery_home_value = delivery_home_value;
            }

            public void setUid(long uid) {
                this.uid = uid;
            }

            public void setDistrict_name(String district_name) {
                this.district_name = district_name;
            }

            public void setService_amount(int service_amount) {
                this.service_amount = service_amount;
            }

            public void setPay_status(int pay_status) {
                this.pay_status = pay_status;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public void setGroup_order_id(String group_order_id) {
                this.group_order_id = group_order_id;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public void setTracking_number(String tracking_number) {
                this.tracking_number = tracking_number;
            }

            public void setShipping_address(String shipping_address) {
                this.shipping_address = shipping_address;
            }

            public void setBuyer_memo(String buyer_memo) {
                this.buyer_memo = buyer_memo;
            }

            public void setIs_pre_sale(String is_pre_sale) {
                this.is_pre_sale = is_pre_sale;
            }

            public void setShipping_time(int shipping_time) {
                this.shipping_time = shipping_time;
            }

            public void setAfter_sales_status(String after_sales_status) {
                this.after_sales_status = after_sales_status;
            }

            public void setReceive_mobile(String receive_mobile) {
                this.receive_mobile = receive_mobile;
            }

            public void setImei_status(int imei_status) {
                this.imei_status = imei_status;
            }

            public void setGoods_amount(int goods_amount) {
                this.goods_amount = goods_amount;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public void setRemark_status(String remark_status) {
                this.remark_status = remark_status;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public void setConfirm_time(int confirm_time) {
                this.confirm_time = confirm_time;
            }

            public void setShipping_amount(int shipping_amount) {
                this.shipping_amount = shipping_amount;
            }

            public void setOut_goods_sn(String out_goods_sn) {
                this.out_goods_sn = out_goods_sn;
            }

            public void setEvent_discount(String event_discount) {
                this.event_discount = event_discount;
            }

            public void setGoods_number(int goods_number) {
                this.goods_number = goods_number;
            }

            public void setProvince_id(int province_id) {
                this.province_id = province_id;
            }

            public void setPromise_shipping_time(int promise_shipping_time) {
                this.promise_shipping_time = promise_shipping_time;
            }

            public void setTrade_type(int trade_type) {
                this.trade_type = trade_type;
            }

            public void setDistrict_id(int district_id) {
                this.district_id = district_id;
            }

            public void setGroup_time(int group_time) {
                this.group_time = group_time;
            }

            public void setGot_timeout_status(String got_timeout_status) {
                this.got_timeout_status = got_timeout_status;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

            public int getShipping_id() {
                return shipping_id;
            }

            public int getGroup_status() {
                return group_status;
            }

            public int getDiscount_amount() {
                return discount_amount;
            }

            public String getStockout_source_type() {
                return stockout_source_type;
            }

            public String getStep_pay_orders() {
                return step_pay_orders;
            }

            public String getPre_delivery_status() {
                return pre_delivery_status;
            }

            public int getOrder_time() {
                return order_time;
            }

            public int getType() {
                return type;
            }

            public String getOrder_handle_status() {
                return order_handle_status;
            }

            public int getLucky_status() {
                return lucky_status;
            }

            public String getSpec() {
                return spec;
            }

            public String getPlatform_discount() {
                return platform_discount;
            }

            public int getOrder_status() {
                return order_status;
            }

            public int getEvent_type() {
                return event_type;
            }

            public String getTrack_update_timeout_status() {
                return track_update_timeout_status;
            }

            public int getOrder_amount() {
                return order_amount;
            }

            public int getMall_id() {
                return mall_id;
            }

            public String getPayment_start_time() {
                return payment_start_time;
            }

            public String getReceive_name() {
                return receive_name;
            }

            public String getOrder_attributes() {
                return order_attributes;
            }

            public String getFavorite_status() {
                return favorite_status;
            }

            public String getOut_sku_sn() {
                return out_sku_sn;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public String getDelivery_install_value() {
                return delivery_install_value;
            }

            public int getBiz_type() {
                return biz_type;
            }

            public long getGoods_id() {
                return goods_id;
            }

            public String getExpire_time() {
                return expire_time;
            }

            public long getSku_id() {
                return sku_id;
            }

            public String getSuccess_time() {
                return success_time;
            }

            public String getUse_single_group_card() {
                return use_single_group_card;
            }

            public int getPay_time() {
                return pay_time;
            }

            public int getShipping_status() {
                return shipping_status;
            }

            public String getProvince_name() {
                return province_name;
            }

            public String getAfter_sales_id() {
                return after_sales_id;
            }

            public String getPayment_end_time() {
                return payment_end_time;
            }

            public String getIs_exist_fine_info() {
                return is_exist_fine_info;
            }

            public String getOrder_id() {
                return order_id;
            }

            public int getCity_id() {
                return city_id;
            }

            public String getHome_install_value() {
                return home_install_value;
            }

            public String getThumb_url() {
                return thumb_url;
            }

            public String getTotal_discount() {
                return total_discount;
            }

            public int getGoods_price() {
                return goods_price;
            }

            public String getMerchant_discount() {
                return merchant_discount;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getDelivery_home_value() {
                return delivery_home_value;
            }

            public long getUid() {
                return uid;
            }

            public String getDistrict_name() {
                return district_name;
            }

            public int getService_amount() {
                return service_amount;
            }

            public int getPay_status() {
                return pay_status;
            }

            public String getCity_name() {
                return city_name;
            }

            public String getGroup_order_id() {
                return group_order_id;
            }

            public String getNickname() {
                return nickname;
            }

            public String getTracking_number() {
                return tracking_number;
            }

            public String getShipping_address() {
                return shipping_address;
            }

            public String getBuyer_memo() {
                return buyer_memo;
            }

            public String getIs_pre_sale() {
                return is_pre_sale;
            }

            public int getShipping_time() {
                return shipping_time;
            }

            public String getAfter_sales_status() {
                return after_sales_status;
            }

            public String getReceive_mobile() {
                return receive_mobile;
            }

            public int getImei_status() {
                return imei_status;
            }

            public int getGoods_amount() {
                return goods_amount;
            }

            public String getMobile() {
                return mobile;
            }

            public String getRemark_status() {
                return remark_status;
            }

            public String getAvatar() {
                return avatar;
            }

            public int getConfirm_time() {
                return confirm_time;
            }

            public int getShipping_amount() {
                return shipping_amount;
            }

            public String getOut_goods_sn() {
                return out_goods_sn;
            }

            public String getEvent_discount() {
                return event_discount;
            }

            public int getGoods_number() {
                return goods_number;
            }

            public int getProvince_id() {
                return province_id;
            }

            public int getPromise_shipping_time() {
                return promise_shipping_time;
            }

            public int getTrade_type() {
                return trade_type;
            }

            public int getDistrict_id() {
                return district_id;
            }

            public int getGroup_time() {
                return group_time;
            }

            public String getGot_timeout_status() {
                return got_timeout_status;
            }

            public String getOrder_sn() {
                return order_sn;
            }
        }
    }
}
