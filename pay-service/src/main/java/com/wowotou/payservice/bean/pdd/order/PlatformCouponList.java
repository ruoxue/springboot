/**
  * Copyright 2019 bejson.com 
  */
package com.wowotou.payservice.bean.pdd.order;
import java.util.List;

/**
 * Auto-generated: 2019-12-19 21:57:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PlatformCouponList {

    private List<String> enableCoupons;
    private List<String> disableCoupons;
    public void setEnableCoupons(List<String> enableCoupons) {
         this.enableCoupons = enableCoupons;
     }
     public List<String> getEnableCoupons() {
         return enableCoupons;
     }

    public void setDisableCoupons(List<String> disableCoupons) {
         this.disableCoupons = disableCoupons;
     }
     public List<String> getDisableCoupons() {
         return disableCoupons;
     }

}