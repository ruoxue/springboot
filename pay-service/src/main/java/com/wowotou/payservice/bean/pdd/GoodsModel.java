package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class GoodsModel implements Serializable {

    /**
     * result : {"total":1,"goods_list":[{"thumb_url":"http://t00img.yangkeduo.com/goods/images/2019-12-18/688684c1d7272584148490e8c975e55b.jpeg","is_group_pre_sale":false,"reject_status":null,"goods_info_score_dto":{"long_graph_scr_flag":true,"goods_info_scr":"2.0","gallery_desc":null,"props_scr_flag":true,"goods_info_score_update_info_hint":null,"material_scr_flag":null,"title_scr_flag":false,"white_graph_scr_flag":false,"title_desc":null,"props_desc":null,"gallery_scr_flag":false,"gallery_video_scr_flag":true},"shipment_limit_second":172800,"created_at":1576654127,"market_labels":null,"hd_thumb_url":"http://t00img.yangkeduo.com/goods/images/2019-12-18/30dc364cac516d80d49b0ddcd35ff01a.jpeg","pre_sale_time":0,"is_onsale":true,"sold_quantity":0,"multi_treasure_status":0,"score":0,"event_type":0,"share_desc":null,"cat_id":5890,"tag_category_list":[],"over_sell":false,"id":77939582775,"origin_sku_group_price":[10000,10000],"sold_quantity_for_thirty_days":0,"activity_title":null,"goods_name":"键盘 惠普键盘 快速打字","quantity":1,"onsale_check":null,"resource":"","cat_name":"键盘","off_sale_check":null,"image_url":"","fav_cnt":0,"multi_treasure":false,"goods_sn":"1912187939582775","if_new_goods":false,"display_priority":"1","goods_desc":null,"guide_target":10001,"reject_reason":null,"priority":null,"labels":[],"edit_check":null,"sku_group_price":[10000,10000],"out_goods_sn":"","gray_goods_high_quality_refund":false,"is_card_secret":false,"sku_price":[11000,11000],"promotion_goods":null,"market_price":11100,"goods_type":1}]}
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
         * total : 1
         * goods_list : [{"thumb_url":"http://t00img.yangkeduo.com/goods/images/2019-12-18/688684c1d7272584148490e8c975e55b.jpeg","is_group_pre_sale":false,"reject_status":null,"goods_info_score_dto":{"long_graph_scr_flag":true,"goods_info_scr":"2.0","gallery_desc":null,"props_scr_flag":true,"goods_info_score_update_info_hint":null,"material_scr_flag":null,"title_scr_flag":false,"white_graph_scr_flag":false,"title_desc":null,"props_desc":null,"gallery_scr_flag":false,"gallery_video_scr_flag":true},"shipment_limit_second":172800,"created_at":1576654127,"market_labels":null,"hd_thumb_url":"http://t00img.yangkeduo.com/goods/images/2019-12-18/30dc364cac516d80d49b0ddcd35ff01a.jpeg","pre_sale_time":0,"is_onsale":true,"sold_quantity":0,"multi_treasure_status":0,"score":0,"event_type":0,"share_desc":null,"cat_id":5890,"tag_category_list":[],"over_sell":false,"id":77939582775,"origin_sku_group_price":[10000,10000],"sold_quantity_for_thirty_days":0,"activity_title":null,"goods_name":"键盘 惠普键盘 快速打字","quantity":1,"onsale_check":null,"resource":"","cat_name":"键盘","off_sale_check":null,"image_url":"","fav_cnt":0,"multi_treasure":false,"goods_sn":"1912187939582775","if_new_goods":false,"display_priority":"1","goods_desc":null,"guide_target":10001,"reject_reason":null,"priority":null,"labels":[],"edit_check":null,"sku_group_price":[10000,10000],"out_goods_sn":"","gray_goods_high_quality_refund":false,"is_card_secret":false,"sku_price":[11000,11000],"promotion_goods":null,"market_price":11100,"goods_type":1}]
         */
        private int total;
        private List<Goods_listEntity> goods_list;

        public void setTotal(int total) {
            this.total = total;
        }

        public void setGoods_list(List<Goods_listEntity> goods_list) {
            this.goods_list = goods_list;
        }

        public int getTotal() {
            return total;
        }

        public List<Goods_listEntity> getGoods_list() {
            return goods_list;
        }

        public class Goods_listEntity {
            @Override
            public String toString() {
                return "Goods_listEntity{" +
                        "thumb_url='" + thumb_url + '\'' +
                        ", is_group_pre_sale=" + is_group_pre_sale +
                        ", reject_status='" + reject_status + '\'' +
                        ", goods_info_score_dto=" + goods_info_score_dto +
                        ", shipment_limit_second=" + shipment_limit_second +
                        ", created_at=" + created_at +
                        ", market_labels='" + market_labels + '\'' +
                        ", hd_thumb_url='" + hd_thumb_url + '\'' +
                        ", pre_sale_time=" + pre_sale_time +
                        ", is_onsale=" + is_onsale +
                        ", sold_quantity=" + sold_quantity +
                        ", multi_treasure_status=" + multi_treasure_status +
                        ", score=" + score +
                        ", event_type=" + event_type +
                        ", share_desc='" + share_desc + '\'' +
                        ", cat_id=" + cat_id +
                        ", tag_category_list=" + tag_category_list +
                        ", over_sell=" + over_sell +
                        ", id=" + id +
                        ", origin_sku_group_price=" + origin_sku_group_price +
                        ", sold_quantity_for_thirty_days=" + sold_quantity_for_thirty_days +
                        ", activity_title='" + activity_title + '\'' +
                        ", goods_name='" + goods_name + '\'' +
                        ", quantity=" + quantity +
                        ", onsale_check='" + onsale_check + '\'' +
                        ", resource='" + resource + '\'' +
                        ", cat_name='" + cat_name + '\'' +
                        ", off_sale_check='" + off_sale_check + '\'' +
                        ", image_url='" + image_url + '\'' +
                        ", fav_cnt=" + fav_cnt +
                        ", multi_treasure=" + multi_treasure +
                        ", goods_sn='" + goods_sn + '\'' +
                        ", if_new_goods=" + if_new_goods +
                        ", display_priority='" + display_priority + '\'' +
                        ", goods_desc='" + goods_desc + '\'' +
                        ", guide_target=" + guide_target +
                        ", reject_reason='" + reject_reason + '\'' +
                        ", priority='" + priority + '\'' +
                        ", labels=" + labels +
                        ", edit_check='" + edit_check + '\'' +
                        ", sku_group_price=" + sku_group_price +
                        ", out_goods_sn='" + out_goods_sn + '\'' +
                        ", gray_goods_high_quality_refund=" + gray_goods_high_quality_refund +
                        ", is_card_secret=" + is_card_secret +
                        ", sku_price=" + sku_price +
                        ", promotion_goods='" + promotion_goods + '\'' +
                        ", market_price=" + market_price +
                        ", goods_type=" + goods_type +
                        '}';
            }

            /**
             * thumb_url : http://t00img.yangkeduo.com/goods/images/2019-12-18/688684c1d7272584148490e8c975e55b.jpeg
             * is_group_pre_sale : false
             * reject_status : null
             * goods_info_score_dto : {"long_graph_scr_flag":true,"goods_info_scr":"2.0","gallery_desc":null,"props_scr_flag":true,"goods_info_score_update_info_hint":null,"material_scr_flag":null,"title_scr_flag":false,"white_graph_scr_flag":false,"title_desc":null,"props_desc":null,"gallery_scr_flag":false,"gallery_video_scr_flag":true}
             * shipment_limit_second : 172800
             * created_at : 1576654127
             * market_labels : null
             * hd_thumb_url : http://t00img.yangkeduo.com/goods/images/2019-12-18/30dc364cac516d80d49b0ddcd35ff01a.jpeg
             * pre_sale_time : 0
             * is_onsale : true
             * sold_quantity : 0
             * multi_treasure_status : 0
             * score : 0.0
             * event_type : 0
             * share_desc : null
             * cat_id : 5890
             * tag_category_list : []
             * over_sell : false
             * id : 77939582775
             * origin_sku_group_price : [10000,10000]
             * sold_quantity_for_thirty_days : 0
             * activity_title : null
             * goods_name : 键盘 惠普键盘 快速打字
             * quantity : 1
             * onsale_check : null
             * resource :
             * cat_name : 键盘
             * off_sale_check : null
             * image_url :
             * fav_cnt : 0
             * multi_treasure : false
             * goods_sn : 1912187939582775
             * if_new_goods : false
             * display_priority : 1
             * goods_desc : null
             * guide_target : 10001
             * reject_reason : null
             * priority : null
             * labels : []
             * edit_check : null
             * sku_group_price : [10000,10000]
             * out_goods_sn :
             * gray_goods_high_quality_refund : false
             * is_card_secret : false
             * sku_price : [11000,11000]
             * promotion_goods : null
             * market_price : 11100
             * goods_type : 1
             */
            private String thumb_url;
            private boolean is_group_pre_sale;
            private String reject_status;
            private Goods_info_score_dtoEntity goods_info_score_dto;
            private int shipment_limit_second;
            private int created_at;
            private String market_labels;
            private String hd_thumb_url;
            private int pre_sale_time;
            private boolean is_onsale;
            private int sold_quantity;
            private int multi_treasure_status;
            private double score;
            private int event_type;
            private String share_desc;
            private int cat_id;
            private List<?> tag_category_list;
            private boolean over_sell;
            private long id;
            private List<Integer> origin_sku_group_price;
            private int sold_quantity_for_thirty_days;
            private String activity_title;
            private String goods_name;
            private int quantity;
            private String onsale_check;
            private String resource;
            private String cat_name;
            private String off_sale_check;
            private String image_url;
            private int fav_cnt;
            private boolean multi_treasure;
            private String goods_sn;
            private boolean if_new_goods;
            private String display_priority;
            private String goods_desc;
            private int guide_target;
            private String reject_reason;
            private String priority;
            private List<?> labels;
            private String edit_check;
            private List<Integer> sku_group_price;
            private String out_goods_sn;
            private boolean gray_goods_high_quality_refund;
            private boolean is_card_secret;
            private List<Integer> sku_price;
            private String promotion_goods;
            private int market_price;
            private int goods_type;

            public void setThumb_url(String thumb_url) {
                this.thumb_url = thumb_url;
            }

            public void setIs_group_pre_sale(boolean is_group_pre_sale) {
                this.is_group_pre_sale = is_group_pre_sale;
            }

            public void setReject_status(String reject_status) {
                this.reject_status = reject_status;
            }

            public void setGoods_info_score_dto(Goods_info_score_dtoEntity goods_info_score_dto) {
                this.goods_info_score_dto = goods_info_score_dto;
            }

            public void setShipment_limit_second(int shipment_limit_second) {
                this.shipment_limit_second = shipment_limit_second;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setMarket_labels(String market_labels) {
                this.market_labels = market_labels;
            }

            public void setHd_thumb_url(String hd_thumb_url) {
                this.hd_thumb_url = hd_thumb_url;
            }

            public void setPre_sale_time(int pre_sale_time) {
                this.pre_sale_time = pre_sale_time;
            }

            public void setIs_onsale(boolean is_onsale) {
                this.is_onsale = is_onsale;
            }

            public void setSold_quantity(int sold_quantity) {
                this.sold_quantity = sold_quantity;
            }

            public void setMulti_treasure_status(int multi_treasure_status) {
                this.multi_treasure_status = multi_treasure_status;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public void setEvent_type(int event_type) {
                this.event_type = event_type;
            }

            public void setShare_desc(String share_desc) {
                this.share_desc = share_desc;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }

            public void setTag_category_list(List<?> tag_category_list) {
                this.tag_category_list = tag_category_list;
            }

            public void setOver_sell(boolean over_sell) {
                this.over_sell = over_sell;
            }

            public void setId(long id) {
                this.id = id;
            }

            public void setOrigin_sku_group_price(List<Integer> origin_sku_group_price) {
                this.origin_sku_group_price = origin_sku_group_price;
            }

            public void setSold_quantity_for_thirty_days(int sold_quantity_for_thirty_days) {
                this.sold_quantity_for_thirty_days = sold_quantity_for_thirty_days;
            }

            public void setActivity_title(String activity_title) {
                this.activity_title = activity_title;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public void setOnsale_check(String onsale_check) {
                this.onsale_check = onsale_check;
            }

            public void setResource(String resource) {
                this.resource = resource;
            }

            public void setCat_name(String cat_name) {
                this.cat_name = cat_name;
            }

            public void setOff_sale_check(String off_sale_check) {
                this.off_sale_check = off_sale_check;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public void setFav_cnt(int fav_cnt) {
                this.fav_cnt = fav_cnt;
            }

            public void setMulti_treasure(boolean multi_treasure) {
                this.multi_treasure = multi_treasure;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public void setIf_new_goods(boolean if_new_goods) {
                this.if_new_goods = if_new_goods;
            }

            public void setDisplay_priority(String display_priority) {
                this.display_priority = display_priority;
            }

            public void setGoods_desc(String goods_desc) {
                this.goods_desc = goods_desc;
            }

            public void setGuide_target(int guide_target) {
                this.guide_target = guide_target;
            }

            public void setReject_reason(String reject_reason) {
                this.reject_reason = reject_reason;
            }

            public void setPriority(String priority) {
                this.priority = priority;
            }

            public void setLabels(List<?> labels) {
                this.labels = labels;
            }

            public void setEdit_check(String edit_check) {
                this.edit_check = edit_check;
            }

            public void setSku_group_price(List<Integer> sku_group_price) {
                this.sku_group_price = sku_group_price;
            }

            public void setOut_goods_sn(String out_goods_sn) {
                this.out_goods_sn = out_goods_sn;
            }

            public void setGray_goods_high_quality_refund(boolean gray_goods_high_quality_refund) {
                this.gray_goods_high_quality_refund = gray_goods_high_quality_refund;
            }

            public void setIs_card_secret(boolean is_card_secret) {
                this.is_card_secret = is_card_secret;
            }

            public void setSku_price(List<Integer> sku_price) {
                this.sku_price = sku_price;
            }

            public void setPromotion_goods(String promotion_goods) {
                this.promotion_goods = promotion_goods;
            }

            public void setMarket_price(int market_price) {
                this.market_price = market_price;
            }

            public void setGoods_type(int goods_type) {
                this.goods_type = goods_type;
            }

            public String getThumb_url() {
                return thumb_url;
            }

            public boolean isIs_group_pre_sale() {
                return is_group_pre_sale;
            }

            public String getReject_status() {
                return reject_status;
            }

            public Goods_info_score_dtoEntity getGoods_info_score_dto() {
                return goods_info_score_dto;
            }

            public int getShipment_limit_second() {
                return shipment_limit_second;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getMarket_labels() {
                return market_labels;
            }

            public String getHd_thumb_url() {
                return hd_thumb_url;
            }

            public int getPre_sale_time() {
                return pre_sale_time;
            }

            public boolean isIs_onsale() {
                return is_onsale;
            }

            public int getSold_quantity() {
                return sold_quantity;
            }

            public int getMulti_treasure_status() {
                return multi_treasure_status;
            }

            public double getScore() {
                return score;
            }

            public int getEvent_type() {
                return event_type;
            }

            public String getShare_desc() {
                return share_desc;
            }

            public int getCat_id() {
                return cat_id;
            }

            public List<?> getTag_category_list() {
                return tag_category_list;
            }

            public boolean isOver_sell() {
                return over_sell;
            }

            public long getId() {
                return id;
            }

            public List<Integer> getOrigin_sku_group_price() {
                return origin_sku_group_price;
            }

            public int getSold_quantity_for_thirty_days() {
                return sold_quantity_for_thirty_days;
            }

            public String getActivity_title() {
                return activity_title;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public int getQuantity() {
                return quantity;
            }

            public String getOnsale_check() {
                return onsale_check;
            }

            public String getResource() {
                return resource;
            }

            public String getCat_name() {
                return cat_name;
            }

            public String getOff_sale_check() {
                return off_sale_check;
            }

            public String getImage_url() {
                return image_url;
            }

            public int getFav_cnt() {
                return fav_cnt;
            }

            public boolean isMulti_treasure() {
                return multi_treasure;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public boolean isIf_new_goods() {
                return if_new_goods;
            }

            public String getDisplay_priority() {
                return display_priority;
            }

            public String getGoods_desc() {
                return goods_desc;
            }

            public int getGuide_target() {
                return guide_target;
            }

            public String getReject_reason() {
                return reject_reason;
            }

            public String getPriority() {
                return priority;
            }

            public List<?> getLabels() {
                return labels;
            }

            public String getEdit_check() {
                return edit_check;
            }

            public List<Integer> getSku_group_price() {
                return sku_group_price;
            }

            public String getOut_goods_sn() {
                return out_goods_sn;
            }

            public boolean isGray_goods_high_quality_refund() {
                return gray_goods_high_quality_refund;
            }

            public boolean isIs_card_secret() {
                return is_card_secret;
            }

            public List<Integer> getSku_price() {
                return sku_price;
            }

            public String getPromotion_goods() {
                return promotion_goods;
            }

            public int getMarket_price() {
                return market_price;
            }

            public int getGoods_type() {
                return goods_type;
            }

            public class Goods_info_score_dtoEntity {
                /**
                 * long_graph_scr_flag : true
                 * goods_info_scr : 2.0
                 * gallery_desc : null
                 * props_scr_flag : true
                 * goods_info_score_update_info_hint : null
                 * material_scr_flag : null
                 * title_scr_flag : false
                 * white_graph_scr_flag : false
                 * title_desc : null
                 * props_desc : null
                 * gallery_scr_flag : false
                 * gallery_video_scr_flag : true
                 */
                private boolean long_graph_scr_flag;
                private String goods_info_scr;
                private String gallery_desc;
                private boolean props_scr_flag;
                private String goods_info_score_update_info_hint;
                private String material_scr_flag;
                private boolean title_scr_flag;
                private boolean white_graph_scr_flag;
                private String title_desc;
                private String props_desc;
                private boolean gallery_scr_flag;
                private boolean gallery_video_scr_flag;

                public void setLong_graph_scr_flag(boolean long_graph_scr_flag) {
                    this.long_graph_scr_flag = long_graph_scr_flag;
                }

                public void setGoods_info_scr(String goods_info_scr) {
                    this.goods_info_scr = goods_info_scr;
                }

                public void setGallery_desc(String gallery_desc) {
                    this.gallery_desc = gallery_desc;
                }

                public void setProps_scr_flag(boolean props_scr_flag) {
                    this.props_scr_flag = props_scr_flag;
                }

                public void setGoods_info_score_update_info_hint(String goods_info_score_update_info_hint) {
                    this.goods_info_score_update_info_hint = goods_info_score_update_info_hint;
                }

                public void setMaterial_scr_flag(String material_scr_flag) {
                    this.material_scr_flag = material_scr_flag;
                }

                public void setTitle_scr_flag(boolean title_scr_flag) {
                    this.title_scr_flag = title_scr_flag;
                }

                public void setWhite_graph_scr_flag(boolean white_graph_scr_flag) {
                    this.white_graph_scr_flag = white_graph_scr_flag;
                }

                public void setTitle_desc(String title_desc) {
                    this.title_desc = title_desc;
                }

                public void setProps_desc(String props_desc) {
                    this.props_desc = props_desc;
                }

                public void setGallery_scr_flag(boolean gallery_scr_flag) {
                    this.gallery_scr_flag = gallery_scr_flag;
                }

                public void setGallery_video_scr_flag(boolean gallery_video_scr_flag) {
                    this.gallery_video_scr_flag = gallery_video_scr_flag;
                }

                public boolean isLong_graph_scr_flag() {
                    return long_graph_scr_flag;
                }

                public String getGoods_info_scr() {
                    return goods_info_scr;
                }

                public String getGallery_desc() {
                    return gallery_desc;
                }

                public boolean isProps_scr_flag() {
                    return props_scr_flag;
                }

                public String getGoods_info_score_update_info_hint() {
                    return goods_info_score_update_info_hint;
                }

                public String getMaterial_scr_flag() {
                    return material_scr_flag;
                }

                public boolean isTitle_scr_flag() {
                    return title_scr_flag;
                }

                public boolean isWhite_graph_scr_flag() {
                    return white_graph_scr_flag;
                }

                public String getTitle_desc() {
                    return title_desc;
                }

                public String getProps_desc() {
                    return props_desc;
                }

                public boolean isGallery_scr_flag() {
                    return gallery_scr_flag;
                }

                public boolean isGallery_video_scr_flag() {
                    return gallery_video_scr_flag;
                }
            }
        }
    }
}
