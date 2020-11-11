package com.wowotou.payservice.param;

import com.alibaba.fastjson.annotation.JSONField;

public class AttributeParam {

    /**
     * create_order_token : a647925c-221b-4c3a-8f7d-9f0d8cc9c954
     * create_order_check : afFJVnFjcg-r1hSSNz3FFjSaQ_R_lKgRS83gs6sCCFBFn24kGf9EHkgXjwqgSsOA
     * original_front_env : 0
     * current_front_env : 1
     * PTRACER-TRACE-UUID : 70126706000000000000000#1568105372783#st2-glb-39
     */
    private String create_order_token;
    private String create_order_check;
    private int original_front_env;
    private int current_front_env;
    @JSONField(name = "PTRACER-TRACE-UUID")
    private  String PTRACER;

    public String getPTRACER() {
        return PTRACER;
    }

    public void setPTRACER(String PTRACER) {
        this.PTRACER = PTRACER;
    }

    public String getCreate_order_token() {
        return create_order_token;
    }

    public void setCreate_order_token(String create_order_token) {
        this.create_order_token = create_order_token;
    }

    public String getCreate_order_check() {
        return create_order_check;
    }

    public void setCreate_order_check(String create_order_check) {
        this.create_order_check = create_order_check;
    }

    public int getOriginal_front_env() {
        return original_front_env;
    }

    public void setOriginal_front_env(int original_front_env) {
        this.original_front_env = original_front_env;
    }

    public int getCurrent_front_env() {
        return current_front_env;
    }

    public void setCurrent_front_env(int current_front_env) {
        this.current_front_env = current_front_env;
    }
}
