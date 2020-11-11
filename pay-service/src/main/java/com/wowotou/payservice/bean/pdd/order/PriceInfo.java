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
public class PriceInfo {

    private int orderPrice;
    private int mallPromotionPrice;
    private int platformPromotionPrice;
    public void setOrderPrice(int orderPrice) {
         this.orderPrice = orderPrice;
     }
     public int getOrderPrice() {
         return orderPrice;
     }

    public void setMallPromotionPrice(int mallPromotionPrice) {
         this.mallPromotionPrice = mallPromotionPrice;
     }
     public int getMallPromotionPrice() {
         return mallPromotionPrice;
     }

    public void setPlatformPromotionPrice(int platformPromotionPrice) {
         this.platformPromotionPrice = platformPromotionPrice;
     }
     public int getPlatformPromotionPrice() {
         return platformPromotionPrice;
     }

}