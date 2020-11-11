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
public class PromotionInfo {

    private MallCoupon mallCoupon;
    private PlatformCoupon platformCoupon;
    private String depositCoupon;
    public void setMallCoupon(MallCoupon mallCoupon) {
         this.mallCoupon = mallCoupon;
     }
     public MallCoupon getMallCoupon() {
         return mallCoupon;
     }

    public void setPlatformCoupon(PlatformCoupon platformCoupon) {
         this.platformCoupon = platformCoupon;
     }
     public PlatformCoupon getPlatformCoupon() {
         return platformCoupon;
     }

    public void setDepositCoupon(String depositCoupon) {
         this.depositCoupon = depositCoupon;
     }
     public String getDepositCoupon() {
         return depositCoupon;
     }

}