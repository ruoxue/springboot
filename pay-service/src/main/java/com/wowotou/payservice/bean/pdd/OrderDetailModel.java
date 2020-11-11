package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class OrderDetailModel implements Serializable {

    /**
     * result : {"shipping_id":0,"stockout_source_type":null,"customer_num":1,"order_time":1576847096,"type":0,"lucky_status":0,"platform_discount":0,"order_status":1,"number":null,"event_type":0,"promotion_events":null,"thrity_day_insurance":false,"fulfillment_mall_id":834542590,"is_card_or_activation_code":false,"id":0,"support_nation_warranty":false,"shipping_name":"","price_protect":false,"out_sku_sn":"","delivery_one_day":null,"delivery_install_value":0,"without_address_tip":null,"oversea_type":0,"goods_id":78701050546,"delivery_and_install":0,"new_user_without_address":false,"use_single_group_card":false,"shipping_status":0,"province_name":"浙江省","coupon_info":null,"buyer_nickname":"李小凡","free_pay_order_info":null,"id_card_no":"","goods_price":1100,"order_goods_tags":[],"international_clearance_id":"XP0019122021200839421801007446","promise_bad_fruit_claim":false,"risk_order":false,"chargeStatus":null,"delivery_home_value":0,"service_amount":0,"virtual_sim_info":null,"group_order_id":"979384685998833090","support_only_replacement_string":"不支持","self_contained":false,"shipping_amount":0,"event_discount":0,"hide_sensitive_info":null,"goods_number":1,"is_ota_virtual_card":false,"province_id":31,"schedule_end":null,"order_sn":"191220-384685998833090","buyer_uid":null,"refundId":"","group_status":1,"fulfillment_status":1,"discount_amount":0,"next_pay_timeout":1576933496,"chargeType":null,"step_pay_orders":null,"pre_delivery_status":null,"order_handle_status":null,"is_train_ticket":false,"spec":"","hs_code":null,"device_sn_list":null,"buyer_mobile":"13355782661","free_sf_express":false,"mall_id":834542590,"order_amount":1100,"payment_start_time":null,"receive_name":"李小凡","platformDiscountDetails":[],"mall_name":"夏虫不可语冰57","schedule_start":null,"goods_name":"蓝牙鼠标 可以连接ios系统","need_upload_idcard":false,"store_info":null,"ikids_mail_address":null,"receive_time":0,"expire_time":null,"success_time":1576847363,"pay_time":1576847363,"after_sales_id":null,"payment_end_time":null,"catId1":5851,"promise_lack_of_weight_return":false,"catId2":5883,"catId3":5897,"city_id":383,"catId4":0,"home_install_value":0,"thumb_url":"http://t00img.yangkeduo.com/goods/images/2019-12-20/2196e1c0c6b855071cc00f5542e53175.jpeg","send_single_group_card":2,"bizType":0,"merchant_discount":0,"close_group_type":0,"hide_sensitive_info_note":null,"customs_broker":null,"pre_sale_time":1577020163,"inner_transaction_id":"XP0019122021200839421801007446","district_name":"西湖区","pay_status":2,"city_name":"杭州市","refundAddressInfo":null,"train_ticket_info_list":[],"imei_list":null,"tracking_number":"","shipping_address":"益乐新村北6-6","buyer_memo":"","shipping_time":0,"freight_compensate":{"mmsAfterSaleDetailCompensateStatus":null,"can_compensate":false,"compensate_amount":null,"refuseReason":null,"status":null},"rapidDeliverSent":false,"after_sales_status":"无售后","receive_mobile":"13*******61","invoice_apply_status":0,"sub_depot":false,"id_card_name":"","order_status_str":"待发货","goods_amount":1100,"mobile":null,"merchantDiscountDetails":[],"confirm_time":1576847363,"origin_country":null,"support_only_replacement":0,"discountUrgeSent":false,"group_id":null,"is_exists_idcard_info":false,"trade_type":0,"district_id":3229,"goods_type":1,"group_time":1576847363,"virtualGoods":false}
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
         * shipping_id : 0
         * stockout_source_type : null
         * customer_num : 1
         * order_time : 1576847096
         * type : 0
         * lucky_status : 0
         * platform_discount : 0
         * order_status : 1
         * number : null
         * event_type : 0
         * promotion_events : null
         * thrity_day_insurance : false
         * fulfillment_mall_id : 834542590
         * is_card_or_activation_code : false
         * id : 0
         * support_nation_warranty : false
         * shipping_name :
         * price_protect : false
         * out_sku_sn :
         * delivery_one_day : null
         * delivery_install_value : 0
         * without_address_tip : null
         * oversea_type : 0
         * goods_id : 78701050546
         * delivery_and_install : 0
         * new_user_without_address : false
         * use_single_group_card : false
         * shipping_status : 0
         * province_name : 浙江省
         * coupon_info : null
         * buyer_nickname : 李小凡
         * free_pay_order_info : null
         * id_card_no :
         * goods_price : 1100
         * order_goods_tags : []
         * international_clearance_id : XP0019122021200839421801007446
         * promise_bad_fruit_claim : false
         * risk_order : false
         * chargeStatus : null
         * delivery_home_value : 0
         * service_amount : 0
         * virtual_sim_info : null
         * group_order_id : 979384685998833090
         * support_only_replacement_string : 不支持
         * self_contained : false
         * shipping_amount : 0
         * event_discount : 0
         * hide_sensitive_info : null
         * goods_number : 1
         * is_ota_virtual_card : false
         * province_id : 31
         * schedule_end : null
         * order_sn : 191220-384685998833090
         * buyer_uid : null
         * refundId :
         * group_status : 1
         * fulfillment_status : 1
         * discount_amount : 0
         * next_pay_timeout : 1576933496
         * chargeType : null
         * step_pay_orders : null
         * pre_delivery_status : null
         * order_handle_status : null
         * is_train_ticket : false
         * spec :
         * hs_code : null
         * device_sn_list : null
         * buyer_mobile : 13355782661
         * free_sf_express : false
         * mall_id : 834542590
         * order_amount : 1100
         * payment_start_time : null
         * receive_name : 李小凡
         * platformDiscountDetails : []
         * mall_name : 夏虫不可语冰57
         * schedule_start : null
         * goods_name : 蓝牙鼠标 可以连接ios系统
         * need_upload_idcard : false
         * store_info : null
         * ikids_mail_address : null
         * receive_time : 0
         * expire_time : null
         * success_time : 1576847363
         * pay_time : 1576847363
         * after_sales_id : null
         * payment_end_time : null
         * catId1 : 5851
         * promise_lack_of_weight_return : false
         * catId2 : 5883
         * catId3 : 5897
         * city_id : 383
         * catId4 : 0
         * home_install_value : 0
         * thumb_url : http://t00img.yangkeduo.com/goods/images/2019-12-20/2196e1c0c6b855071cc00f5542e53175.jpeg
         * send_single_group_card : 2
         * bizType : 0
         * merchant_discount : 0
         * close_group_type : 0
         * hide_sensitive_info_note : null
         * customs_broker : null
         * pre_sale_time : 1577020163
         * inner_transaction_id : XP0019122021200839421801007446
         * district_name : 西湖区
         * pay_status : 2
         * city_name : 杭州市
         * refundAddressInfo : null
         * train_ticket_info_list : []
         * imei_list : null
         * tracking_number :
         * shipping_address : 益乐新村北6-6
         * buyer_memo :
         * shipping_time : 0
         * freight_compensate : {"mmsAfterSaleDetailCompensateStatus":null,"can_compensate":false,"compensate_amount":null,"refuseReason":null,"status":null}
         * rapidDeliverSent : false
         * after_sales_status : 无售后
         * receive_mobile : 13*******61
         * invoice_apply_status : 0
         * sub_depot : false
         * id_card_name :
         * order_status_str : 待发货
         * goods_amount : 1100
         * mobile : null
         * merchantDiscountDetails : []
         * confirm_time : 1576847363
         * origin_country : null
         * support_only_replacement : 0
         * discountUrgeSent : false
         * group_id : null
         * is_exists_idcard_info : false
         * trade_type : 0
         * district_id : 3229
         * goods_type : 1
         * group_time : 1576847363
         * virtualGoods : false
         */
        private int shipping_id;
        private String stockout_source_type;
        private int customer_num;
        private int order_time;
        private int type;
        private int lucky_status;
        private int platform_discount;
        private int order_status;
        private String number;
        private int event_type;
        private String promotion_events;
        private boolean thrity_day_insurance;
        private int fulfillment_mall_id;
        private boolean is_card_or_activation_code;
        private int id;
        private boolean support_nation_warranty;
        private String shipping_name;
        private boolean price_protect;
        private String out_sku_sn;
        private String delivery_one_day;
        private int delivery_install_value;
        private String without_address_tip;
        private int oversea_type;
        private long goods_id;
        private int delivery_and_install;
        private boolean new_user_without_address;
        private boolean use_single_group_card;
        private int shipping_status;
        private String province_name;
        private String coupon_info;
        private String buyer_nickname;
        private String free_pay_order_info;
        private String id_card_no;
        private int goods_price;
        private List<?> order_goods_tags;
        private String international_clearance_id;
        private boolean promise_bad_fruit_claim;
        private boolean risk_order;
        private String chargeStatus;
        private int delivery_home_value;
        private int service_amount;
        private String virtual_sim_info;
        private String group_order_id;
        private String support_only_replacement_string;
        private boolean self_contained;
        private int shipping_amount;
        private int event_discount;
        private String hide_sensitive_info;
        private int goods_number;
        private boolean is_ota_virtual_card;
        private int province_id;
        private String schedule_end;
        private String order_sn;
        private String buyer_uid;
        private String refundId;
        private int group_status;
        private int fulfillment_status;
        private int discount_amount;
        private int next_pay_timeout;
        private String chargeType;
        private String step_pay_orders;
        private String pre_delivery_status;
        private String order_handle_status;
        private boolean is_train_ticket;
        private String spec;
        private String hs_code;
        private String device_sn_list;
        private String buyer_mobile;
        private boolean free_sf_express;
        private int mall_id;
        private int order_amount;
        private String payment_start_time;
        private String receive_name;
        private List<?> platformDiscountDetails;
        private String mall_name;
        private String schedule_start;
        private String goods_name;
        private boolean need_upload_idcard;
        private String store_info;
        private String ikids_mail_address;
        private int receive_time;
        private String expire_time;
        private int success_time;
        private int pay_time;
        private String after_sales_id;
        private String payment_end_time;
        private int catId1;
        private boolean promise_lack_of_weight_return;
        private int catId2;
        private int catId3;
        private int city_id;
        private int catId4;
        private int home_install_value;
        private String thumb_url;
        private int send_single_group_card;
        private int bizType;
        private int merchant_discount;
        private int close_group_type;
        private String hide_sensitive_info_note;
        private String customs_broker;
        private int pre_sale_time;
        private String inner_transaction_id;
        private String district_name;
        private int pay_status;
        private String city_name;
        private String refundAddressInfo;
        private List<?> train_ticket_info_list;
        private String imei_list;
        private String tracking_number;
        private String shipping_address;
        private String buyer_memo;
        private int shipping_time;
        private Freight_compensateEntity freight_compensate;
        private boolean rapidDeliverSent;
        private String after_sales_status;
        private String receive_mobile;
        private int invoice_apply_status;
        private boolean sub_depot;
        private String id_card_name;
        private String order_status_str;
        private int goods_amount;
        private String mobile;
        private List<?> merchantDiscountDetails;
        private int confirm_time;
        private String origin_country;
        private int support_only_replacement;
        private boolean discountUrgeSent;
        private String group_id;
        private boolean is_exists_idcard_info;
        private int trade_type;
        private int district_id;
        private int goods_type;
        private int group_time;
        private boolean virtualGoods;

        public void setShipping_id(int shipping_id) {
            this.shipping_id = shipping_id;
        }

        public void setStockout_source_type(String stockout_source_type) {
            this.stockout_source_type = stockout_source_type;
        }

        public void setCustomer_num(int customer_num) {
            this.customer_num = customer_num;
        }

        public void setOrder_time(int order_time) {
            this.order_time = order_time;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setLucky_status(int lucky_status) {
            this.lucky_status = lucky_status;
        }

        public void setPlatform_discount(int platform_discount) {
            this.platform_discount = platform_discount;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setEvent_type(int event_type) {
            this.event_type = event_type;
        }

        public void setPromotion_events(String promotion_events) {
            this.promotion_events = promotion_events;
        }

        public void setThrity_day_insurance(boolean thrity_day_insurance) {
            this.thrity_day_insurance = thrity_day_insurance;
        }

        public void setFulfillment_mall_id(int fulfillment_mall_id) {
            this.fulfillment_mall_id = fulfillment_mall_id;
        }

        public void setIs_card_or_activation_code(boolean is_card_or_activation_code) {
            this.is_card_or_activation_code = is_card_or_activation_code;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSupport_nation_warranty(boolean support_nation_warranty) {
            this.support_nation_warranty = support_nation_warranty;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public void setPrice_protect(boolean price_protect) {
            this.price_protect = price_protect;
        }

        public void setOut_sku_sn(String out_sku_sn) {
            this.out_sku_sn = out_sku_sn;
        }

        public void setDelivery_one_day(String delivery_one_day) {
            this.delivery_one_day = delivery_one_day;
        }

        public void setDelivery_install_value(int delivery_install_value) {
            this.delivery_install_value = delivery_install_value;
        }

        public void setWithout_address_tip(String without_address_tip) {
            this.without_address_tip = without_address_tip;
        }

        public void setOversea_type(int oversea_type) {
            this.oversea_type = oversea_type;
        }

        public void setGoods_id(long goods_id) {
            this.goods_id = goods_id;
        }

        public void setDelivery_and_install(int delivery_and_install) {
            this.delivery_and_install = delivery_and_install;
        }

        public void setNew_user_without_address(boolean new_user_without_address) {
            this.new_user_without_address = new_user_without_address;
        }

        public void setUse_single_group_card(boolean use_single_group_card) {
            this.use_single_group_card = use_single_group_card;
        }

        public void setShipping_status(int shipping_status) {
            this.shipping_status = shipping_status;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public void setCoupon_info(String coupon_info) {
            this.coupon_info = coupon_info;
        }

        public void setBuyer_nickname(String buyer_nickname) {
            this.buyer_nickname = buyer_nickname;
        }

        public void setFree_pay_order_info(String free_pay_order_info) {
            this.free_pay_order_info = free_pay_order_info;
        }

        public void setId_card_no(String id_card_no) {
            this.id_card_no = id_card_no;
        }

        public void setGoods_price(int goods_price) {
            this.goods_price = goods_price;
        }

        public void setOrder_goods_tags(List<?> order_goods_tags) {
            this.order_goods_tags = order_goods_tags;
        }

        public void setInternational_clearance_id(String international_clearance_id) {
            this.international_clearance_id = international_clearance_id;
        }

        public void setPromise_bad_fruit_claim(boolean promise_bad_fruit_claim) {
            this.promise_bad_fruit_claim = promise_bad_fruit_claim;
        }

        public void setRisk_order(boolean risk_order) {
            this.risk_order = risk_order;
        }

        public void setChargeStatus(String chargeStatus) {
            this.chargeStatus = chargeStatus;
        }

        public void setDelivery_home_value(int delivery_home_value) {
            this.delivery_home_value = delivery_home_value;
        }

        public void setService_amount(int service_amount) {
            this.service_amount = service_amount;
        }

        public void setVirtual_sim_info(String virtual_sim_info) {
            this.virtual_sim_info = virtual_sim_info;
        }

        public void setGroup_order_id(String group_order_id) {
            this.group_order_id = group_order_id;
        }

        public void setSupport_only_replacement_string(String support_only_replacement_string) {
            this.support_only_replacement_string = support_only_replacement_string;
        }

        public void setSelf_contained(boolean self_contained) {
            this.self_contained = self_contained;
        }

        public void setShipping_amount(int shipping_amount) {
            this.shipping_amount = shipping_amount;
        }

        public void setEvent_discount(int event_discount) {
            this.event_discount = event_discount;
        }

        public void setHide_sensitive_info(String hide_sensitive_info) {
            this.hide_sensitive_info = hide_sensitive_info;
        }

        public void setGoods_number(int goods_number) {
            this.goods_number = goods_number;
        }

        public void setIs_ota_virtual_card(boolean is_ota_virtual_card) {
            this.is_ota_virtual_card = is_ota_virtual_card;
        }

        public void setProvince_id(int province_id) {
            this.province_id = province_id;
        }

        public void setSchedule_end(String schedule_end) {
            this.schedule_end = schedule_end;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public void setBuyer_uid(String buyer_uid) {
            this.buyer_uid = buyer_uid;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public void setGroup_status(int group_status) {
            this.group_status = group_status;
        }

        public void setFulfillment_status(int fulfillment_status) {
            this.fulfillment_status = fulfillment_status;
        }

        public void setDiscount_amount(int discount_amount) {
            this.discount_amount = discount_amount;
        }

        public void setNext_pay_timeout(int next_pay_timeout) {
            this.next_pay_timeout = next_pay_timeout;
        }

        public void setChargeType(String chargeType) {
            this.chargeType = chargeType;
        }

        public void setStep_pay_orders(String step_pay_orders) {
            this.step_pay_orders = step_pay_orders;
        }

        public void setPre_delivery_status(String pre_delivery_status) {
            this.pre_delivery_status = pre_delivery_status;
        }

        public void setOrder_handle_status(String order_handle_status) {
            this.order_handle_status = order_handle_status;
        }

        public void setIs_train_ticket(boolean is_train_ticket) {
            this.is_train_ticket = is_train_ticket;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public void setHs_code(String hs_code) {
            this.hs_code = hs_code;
        }

        public void setDevice_sn_list(String device_sn_list) {
            this.device_sn_list = device_sn_list;
        }

        public void setBuyer_mobile(String buyer_mobile) {
            this.buyer_mobile = buyer_mobile;
        }

        public void setFree_sf_express(boolean free_sf_express) {
            this.free_sf_express = free_sf_express;
        }

        public void setMall_id(int mall_id) {
            this.mall_id = mall_id;
        }

        public void setOrder_amount(int order_amount) {
            this.order_amount = order_amount;
        }

        public void setPayment_start_time(String payment_start_time) {
            this.payment_start_time = payment_start_time;
        }

        public void setReceive_name(String receive_name) {
            this.receive_name = receive_name;
        }

        public void setPlatformDiscountDetails(List<?> platformDiscountDetails) {
            this.platformDiscountDetails = platformDiscountDetails;
        }

        public void setMall_name(String mall_name) {
            this.mall_name = mall_name;
        }

        public void setSchedule_start(String schedule_start) {
            this.schedule_start = schedule_start;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public void setNeed_upload_idcard(boolean need_upload_idcard) {
            this.need_upload_idcard = need_upload_idcard;
        }

        public void setStore_info(String store_info) {
            this.store_info = store_info;
        }

        public void setIkids_mail_address(String ikids_mail_address) {
            this.ikids_mail_address = ikids_mail_address;
        }

        public void setReceive_time(int receive_time) {
            this.receive_time = receive_time;
        }

        public void setExpire_time(String expire_time) {
            this.expire_time = expire_time;
        }

        public void setSuccess_time(int success_time) {
            this.success_time = success_time;
        }

        public void setPay_time(int pay_time) {
            this.pay_time = pay_time;
        }

        public void setAfter_sales_id(String after_sales_id) {
            this.after_sales_id = after_sales_id;
        }

        public void setPayment_end_time(String payment_end_time) {
            this.payment_end_time = payment_end_time;
        }

        public void setCatId1(int catId1) {
            this.catId1 = catId1;
        }

        public void setPromise_lack_of_weight_return(boolean promise_lack_of_weight_return) {
            this.promise_lack_of_weight_return = promise_lack_of_weight_return;
        }

        public void setCatId2(int catId2) {
            this.catId2 = catId2;
        }

        public void setCatId3(int catId3) {
            this.catId3 = catId3;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public void setCatId4(int catId4) {
            this.catId4 = catId4;
        }

        public void setHome_install_value(int home_install_value) {
            this.home_install_value = home_install_value;
        }

        public void setThumb_url(String thumb_url) {
            this.thumb_url = thumb_url;
        }

        public void setSend_single_group_card(int send_single_group_card) {
            this.send_single_group_card = send_single_group_card;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public void setMerchant_discount(int merchant_discount) {
            this.merchant_discount = merchant_discount;
        }

        public void setClose_group_type(int close_group_type) {
            this.close_group_type = close_group_type;
        }

        public void setHide_sensitive_info_note(String hide_sensitive_info_note) {
            this.hide_sensitive_info_note = hide_sensitive_info_note;
        }

        public void setCustoms_broker(String customs_broker) {
            this.customs_broker = customs_broker;
        }

        public void setPre_sale_time(int pre_sale_time) {
            this.pre_sale_time = pre_sale_time;
        }

        public void setInner_transaction_id(String inner_transaction_id) {
            this.inner_transaction_id = inner_transaction_id;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public void setRefundAddressInfo(String refundAddressInfo) {
            this.refundAddressInfo = refundAddressInfo;
        }

        public void setTrain_ticket_info_list(List<?> train_ticket_info_list) {
            this.train_ticket_info_list = train_ticket_info_list;
        }

        public void setImei_list(String imei_list) {
            this.imei_list = imei_list;
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

        public void setShipping_time(int shipping_time) {
            this.shipping_time = shipping_time;
        }

        public void setFreight_compensate(Freight_compensateEntity freight_compensate) {
            this.freight_compensate = freight_compensate;
        }

        public void setRapidDeliverSent(boolean rapidDeliverSent) {
            this.rapidDeliverSent = rapidDeliverSent;
        }

        public void setAfter_sales_status(String after_sales_status) {
            this.after_sales_status = after_sales_status;
        }

        public void setReceive_mobile(String receive_mobile) {
            this.receive_mobile = receive_mobile;
        }

        public void setInvoice_apply_status(int invoice_apply_status) {
            this.invoice_apply_status = invoice_apply_status;
        }

        public void setSub_depot(boolean sub_depot) {
            this.sub_depot = sub_depot;
        }

        public void setId_card_name(String id_card_name) {
            this.id_card_name = id_card_name;
        }

        public void setOrder_status_str(String order_status_str) {
            this.order_status_str = order_status_str;
        }

        public void setGoods_amount(int goods_amount) {
            this.goods_amount = goods_amount;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setMerchantDiscountDetails(List<?> merchantDiscountDetails) {
            this.merchantDiscountDetails = merchantDiscountDetails;
        }

        public void setConfirm_time(int confirm_time) {
            this.confirm_time = confirm_time;
        }

        public void setOrigin_country(String origin_country) {
            this.origin_country = origin_country;
        }

        public void setSupport_only_replacement(int support_only_replacement) {
            this.support_only_replacement = support_only_replacement;
        }

        public void setDiscountUrgeSent(boolean discountUrgeSent) {
            this.discountUrgeSent = discountUrgeSent;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public void setIs_exists_idcard_info(boolean is_exists_idcard_info) {
            this.is_exists_idcard_info = is_exists_idcard_info;
        }

        public void setTrade_type(int trade_type) {
            this.trade_type = trade_type;
        }

        public void setDistrict_id(int district_id) {
            this.district_id = district_id;
        }

        public void setGoods_type(int goods_type) {
            this.goods_type = goods_type;
        }

        public void setGroup_time(int group_time) {
            this.group_time = group_time;
        }

        public void setVirtualGoods(boolean virtualGoods) {
            this.virtualGoods = virtualGoods;
        }

        public int getShipping_id() {
            return shipping_id;
        }

        public String getStockout_source_type() {
            return stockout_source_type;
        }

        public int getCustomer_num() {
            return customer_num;
        }

        public int getOrder_time() {
            return order_time;
        }

        public int getType() {
            return type;
        }

        public int getLucky_status() {
            return lucky_status;
        }

        public int getPlatform_discount() {
            return platform_discount;
        }

        public int getOrder_status() {
            return order_status;
        }

        public String getNumber() {
            return number;
        }

        public int getEvent_type() {
            return event_type;
        }

        public String getPromotion_events() {
            return promotion_events;
        }

        public boolean isThrity_day_insurance() {
            return thrity_day_insurance;
        }

        public int getFulfillment_mall_id() {
            return fulfillment_mall_id;
        }

        public boolean isIs_card_or_activation_code() {
            return is_card_or_activation_code;
        }

        public int getId() {
            return id;
        }

        public boolean isSupport_nation_warranty() {
            return support_nation_warranty;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public boolean isPrice_protect() {
            return price_protect;
        }

        public String getOut_sku_sn() {
            return out_sku_sn;
        }

        public String getDelivery_one_day() {
            return delivery_one_day;
        }

        public int getDelivery_install_value() {
            return delivery_install_value;
        }

        public String getWithout_address_tip() {
            return without_address_tip;
        }

        public int getOversea_type() {
            return oversea_type;
        }

        public long getGoods_id() {
            return goods_id;
        }

        public int getDelivery_and_install() {
            return delivery_and_install;
        }

        public boolean isNew_user_without_address() {
            return new_user_without_address;
        }

        public boolean isUse_single_group_card() {
            return use_single_group_card;
        }

        public int getShipping_status() {
            return shipping_status;
        }

        public String getProvince_name() {
            return province_name;
        }

        public String getCoupon_info() {
            return coupon_info;
        }

        public String getBuyer_nickname() {
            return buyer_nickname;
        }

        public String getFree_pay_order_info() {
            return free_pay_order_info;
        }

        public String getId_card_no() {
            return id_card_no;
        }

        public int getGoods_price() {
            return goods_price;
        }

        public List<?> getOrder_goods_tags() {
            return order_goods_tags;
        }

        public String getInternational_clearance_id() {
            return international_clearance_id;
        }

        public boolean isPromise_bad_fruit_claim() {
            return promise_bad_fruit_claim;
        }

        public boolean isRisk_order() {
            return risk_order;
        }

        public String getChargeStatus() {
            return chargeStatus;
        }

        public int getDelivery_home_value() {
            return delivery_home_value;
        }

        public int getService_amount() {
            return service_amount;
        }

        public String getVirtual_sim_info() {
            return virtual_sim_info;
        }

        public String getGroup_order_id() {
            return group_order_id;
        }

        public String getSupport_only_replacement_string() {
            return support_only_replacement_string;
        }

        public boolean isSelf_contained() {
            return self_contained;
        }

        public int getShipping_amount() {
            return shipping_amount;
        }

        public int getEvent_discount() {
            return event_discount;
        }

        public String getHide_sensitive_info() {
            return hide_sensitive_info;
        }

        public int getGoods_number() {
            return goods_number;
        }

        public boolean isIs_ota_virtual_card() {
            return is_ota_virtual_card;
        }

        public int getProvince_id() {
            return province_id;
        }

        public String getSchedule_end() {
            return schedule_end;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public String getBuyer_uid() {
            return buyer_uid;
        }

        public String getRefundId() {
            return refundId;
        }

        public int getGroup_status() {
            return group_status;
        }

        public int getFulfillment_status() {
            return fulfillment_status;
        }

        public int getDiscount_amount() {
            return discount_amount;
        }

        public int getNext_pay_timeout() {
            return next_pay_timeout;
        }

        public String getChargeType() {
            return chargeType;
        }

        public String getStep_pay_orders() {
            return step_pay_orders;
        }

        public String getPre_delivery_status() {
            return pre_delivery_status;
        }

        public String getOrder_handle_status() {
            return order_handle_status;
        }

        public boolean isIs_train_ticket() {
            return is_train_ticket;
        }

        public String getSpec() {
            return spec;
        }

        public String getHs_code() {
            return hs_code;
        }

        public String getDevice_sn_list() {
            return device_sn_list;
        }

        public String getBuyer_mobile() {
            return buyer_mobile;
        }

        public boolean isFree_sf_express() {
            return free_sf_express;
        }

        public int getMall_id() {
            return mall_id;
        }

        public int getOrder_amount() {
            return order_amount;
        }

        public String getPayment_start_time() {
            return payment_start_time;
        }

        public String getReceive_name() {
            return receive_name;
        }

        public List<?> getPlatformDiscountDetails() {
            return platformDiscountDetails;
        }

        public String getMall_name() {
            return mall_name;
        }

        public String getSchedule_start() {
            return schedule_start;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public boolean isNeed_upload_idcard() {
            return need_upload_idcard;
        }

        public String getStore_info() {
            return store_info;
        }

        public String getIkids_mail_address() {
            return ikids_mail_address;
        }

        public int getReceive_time() {
            return receive_time;
        }

        public String getExpire_time() {
            return expire_time;
        }

        public int getSuccess_time() {
            return success_time;
        }

        public int getPay_time() {
            return pay_time;
        }

        public String getAfter_sales_id() {
            return after_sales_id;
        }

        public String getPayment_end_time() {
            return payment_end_time;
        }

        public int getCatId1() {
            return catId1;
        }

        public boolean isPromise_lack_of_weight_return() {
            return promise_lack_of_weight_return;
        }

        public int getCatId2() {
            return catId2;
        }

        public int getCatId3() {
            return catId3;
        }

        public int getCity_id() {
            return city_id;
        }

        public int getCatId4() {
            return catId4;
        }

        public int getHome_install_value() {
            return home_install_value;
        }

        public String getThumb_url() {
            return thumb_url;
        }

        public int getSend_single_group_card() {
            return send_single_group_card;
        }

        public int getBizType() {
            return bizType;
        }

        public int getMerchant_discount() {
            return merchant_discount;
        }

        public int getClose_group_type() {
            return close_group_type;
        }

        public String getHide_sensitive_info_note() {
            return hide_sensitive_info_note;
        }

        public String getCustoms_broker() {
            return customs_broker;
        }

        public int getPre_sale_time() {
            return pre_sale_time;
        }

        public String getInner_transaction_id() {
            return inner_transaction_id;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public int getPay_status() {
            return pay_status;
        }

        public String getCity_name() {
            return city_name;
        }

        public String getRefundAddressInfo() {
            return refundAddressInfo;
        }

        public List<?> getTrain_ticket_info_list() {
            return train_ticket_info_list;
        }

        public String getImei_list() {
            return imei_list;
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

        public int getShipping_time() {
            return shipping_time;
        }

        public Freight_compensateEntity getFreight_compensate() {
            return freight_compensate;
        }

        public boolean isRapidDeliverSent() {
            return rapidDeliverSent;
        }

        public String getAfter_sales_status() {
            return after_sales_status;
        }

        public String getReceive_mobile() {
            return receive_mobile;
        }

        public int getInvoice_apply_status() {
            return invoice_apply_status;
        }

        public boolean isSub_depot() {
            return sub_depot;
        }

        public String getId_card_name() {
            return id_card_name;
        }

        public String getOrder_status_str() {
            return order_status_str;
        }

        public int getGoods_amount() {
            return goods_amount;
        }

        public String getMobile() {
            return mobile;
        }

        public List<?> getMerchantDiscountDetails() {
            return merchantDiscountDetails;
        }

        public int getConfirm_time() {
            return confirm_time;
        }

        public String getOrigin_country() {
            return origin_country;
        }

        public int getSupport_only_replacement() {
            return support_only_replacement;
        }

        public boolean isDiscountUrgeSent() {
            return discountUrgeSent;
        }

        public String getGroup_id() {
            return group_id;
        }

        public boolean isIs_exists_idcard_info() {
            return is_exists_idcard_info;
        }

        public int getTrade_type() {
            return trade_type;
        }

        public int getDistrict_id() {
            return district_id;
        }

        public int getGoods_type() {
            return goods_type;
        }

        public int getGroup_time() {
            return group_time;
        }

        public boolean isVirtualGoods() {
            return virtualGoods;
        }

        public class Freight_compensateEntity {
            /**
             * mmsAfterSaleDetailCompensateStatus : null
             * can_compensate : false
             * compensate_amount : null
             * refuseReason : null
             * status : null
             */
            private String mmsAfterSaleDetailCompensateStatus;
            private boolean can_compensate;
            private String compensate_amount;
            private String refuseReason;
            private String status;

            public void setMmsAfterSaleDetailCompensateStatus(String mmsAfterSaleDetailCompensateStatus) {
                this.mmsAfterSaleDetailCompensateStatus = mmsAfterSaleDetailCompensateStatus;
            }

            public void setCan_compensate(boolean can_compensate) {
                this.can_compensate = can_compensate;
            }

            public void setCompensate_amount(String compensate_amount) {
                this.compensate_amount = compensate_amount;
            }

            public void setRefuseReason(String refuseReason) {
                this.refuseReason = refuseReason;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getMmsAfterSaleDetailCompensateStatus() {
                return mmsAfterSaleDetailCompensateStatus;
            }

            public boolean isCan_compensate() {
                return can_compensate;
            }

            public String getCompensate_amount() {
                return compensate_amount;
            }

            public String getRefuseReason() {
                return refuseReason;
            }

            public String getStatus() {
                return status;
            }
        }
    }
}
