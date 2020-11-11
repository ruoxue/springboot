/**
  * Copyright 2019 bejson.com 
  */
package com.wowotou.payservice.bean.pdd.order;

/**
 * Auto-generated: 2019-12-19 21:57:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ActivityParams {

    private int duoduo_type;
    private int biz_type;
    private String pid;
    private String cps_sign;
    private String out_group_order_id;
    public void setDuoduo_type(int duoduo_type) {
         this.duoduo_type = duoduo_type;
     }
     public int getDuoduo_type() {
         return duoduo_type;
     }

    public void setBiz_type(int biz_type) {
         this.biz_type = biz_type;
     }
     public int getBiz_type() {
         return biz_type;
     }

    public void setPid(String pid) {
         this.pid = pid;
     }
     public String getPid() {
         return pid;
     }

    public void setCps_sign(String cps_sign) {
         this.cps_sign = cps_sign;
     }
     public String getCps_sign() {
         return cps_sign;
     }

    public void setOut_group_order_id(String out_group_order_id) {
         this.out_group_order_id = out_group_order_id;
     }
     public String getOut_group_order_id() {
         return out_group_order_id;
     }

}