package com.wowotou.payservice.param;

import java.util.List;

public class PddParem {

    /**
     * pay_app_id : 9
     * is_app : 0
     * source_channel : 0
     * duoduo_type : 0
     * biz_type : 0
     * address_id : 13060888504
     * anti_content : 0anAfxnUmOcgqgEVwYMs4TUa9c9GP_Zv4SqOcu111V1tY_vNPfgdDPDAzErFrEqMHxFkDfZo_HCn-oTtbJ_6nKsjG63bAim8qJ3LCg9JsWTVbHPhP4IOCrB8RH9WCsNm6xZ0LrCi9EBJnMKvXOac4hR8fvRN9eoUWqljIe18KK-Smfm4-Qnx8TVJUJeU_KXvmAZ01fXw9hvOdDzshtSz7w26SrOVLCEi3LhiQJoIvv7D_UFF0IdSbwS1spmDtsnQuW45HmmioBz7wBtAUxBsdNsUn_1BlnVGwGNjsrZK4VgjE3DhgxF4XfcQzadvYu4eisFtA_RNKP7EMaRmxakMHOudTmCB2XLPPLIgjowkOhg4Y1Mbsm12A9KFfMcb7UWQQJX7HsmhGTPN1VjXrtoap2NmLRKz2LsBPXN-Pzo2r2IzgCdYpZUFHHEgb3PtGgpgItEXik_V4Tw9JRCXc1ONuVoQeL9c3dcWir0zXszn2u1UYhfpmW9k0pGxyZOBMwb5TCjr46_oGdQYeyIL3Q51KfZfHfK8KS3ZBBbk0TNcLJJQY9x7o5YWhOsiiCYYyYtY8XnDsCieCkatQIPgyLM0jhC9t3DYDxtDxw-J7qbZmiuikwd9ALHe6PzK4WhKMJHGyAqxWMvI7e8L7iLRo4w0Lxx
     * goods : [{"sku_number":1,"goods_id":"42763057954","sku_id":351600868588}]
     * source_type : 0
     * attribute_fields : {"create_order_token":"a647925c-221b-4c3a-8f7d-9f0d8cc9c954","create_order_check":"afFJVnFjcg-r1hSSNz3FFjSaQ_R_lKgRS83gs6sCCFBFn24kGf9EHkgXjwqgSsOA","original_front_env":0,"current_front_env":1,"PTRACER-TRACE-UUID":"70126706000000000000000#1568105372783#st2-glb-39"}
     * version : 1
     * page_id : 10004_1568105373630_XCUTl1gR5d
     * group_id : 21225272218
     */
    private  String group_id;
    private  String anti_content;
    private  int  duoduo_type;
    private  int biz_type;
private  String page_id;
private  AttributeParam attribute_fields;

    public AttributeParam getAttribute_fields() {
        return attribute_fields;
    }

    public void setAttribute_fields(AttributeParam attribute_fields) {
        this.attribute_fields = attribute_fields;
    }

    public String getPage_id() {
        return page_id;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    private  int  version;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private int pay_app_id;
    private String is_app;
    private String source_channel;

    private long address_id;

    private List<GoodsEntity> goods;
    private int source_type;

    public int getPay_app_id() {
        return pay_app_id;
    }

    public void setPay_app_id(int pay_app_id) {
        this.pay_app_id = pay_app_id;
    }

    public String getIs_app() {
        return is_app;
    }

    public void setIs_app(String is_app) {
        this.is_app = is_app;
    }

    public String getSource_channel() {
        return source_channel;
    }

    public void setSource_channel(String source_channel) {
        this.source_channel = source_channel;
    }

    public int getDuoduo_type() {
        return duoduo_type;
    }

    public void setDuoduo_type(int duoduo_type) {
        this.duoduo_type = duoduo_type;
    }

    public int getBiz_type() {
        return biz_type;
    }

    public void setBiz_type(int biz_type) {
        this.biz_type = biz_type;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getAnti_content() {
        return anti_content;
    }

    public void setAnti_content(String anti_content) {
        this.anti_content = anti_content;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }

    public int getSource_type() {
        return source_type;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }



}
