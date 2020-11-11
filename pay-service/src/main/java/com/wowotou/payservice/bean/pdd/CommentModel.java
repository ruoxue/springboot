package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommentModel implements Serializable {
private  String goods_id;
    private  String order_sn;
    private  String comment="好评，不错下次再来。";
    private  int  desc_score=5;
    private  int  service_score=5;
    private  int  logistics_score=5;
    private List<String> pictures=new ArrayList<>();

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDesc_score() {
        return desc_score;
    }

    public void setDesc_score(int desc_score) {
        this.desc_score = desc_score;
    }

    public int getService_score() {
        return service_score;
    }

    public void setService_score(int service_score) {
        this.service_score = service_score;
    }

    public int getLogistics_score() {
        return logistics_score;
    }

    public void setLogistics_score(int logistics_score) {
        this.logistics_score = logistics_score;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
