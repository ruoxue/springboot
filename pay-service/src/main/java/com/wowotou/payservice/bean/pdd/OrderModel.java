package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;

public class OrderModel implements Serializable {

    /**
     * server_time : 1576757497
     * fp_id : 8YsLFTFaOtdjHAW8erKSmy_8GlEbZha2-jsZYSQ91dU
     * group_order_id : 978640590480113090
     * order_amount : 11000
     * order_sn : 191219-640590480113090
     */
    private int server_time;
    private String fp_id;
    private String group_order_id;
    private int order_amount;
    private String order_sn;

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public void setFp_id(String fp_id) {
        this.fp_id = fp_id;
    }

    public void setGroup_order_id(String group_order_id) {
        this.group_order_id = group_order_id;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public int getServer_time() {
        return server_time;
    }

    public String getFp_id() {
        return fp_id;
    }

    public String getGroup_order_id() {
        return group_order_id;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public String getOrder_sn() {
        return order_sn;
    }
}
