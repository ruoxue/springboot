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
public class OrderInfo {

    private int payPrice;
    private String payTitle;
    private String payContent;
    private String orderPrice;
    private int couponPrice;
    public void setPayPrice(int payPrice) {
         this.payPrice = payPrice;
     }
     public int getPayPrice() {
         return payPrice;
     }

    public void setPayTitle(String payTitle) {
         this.payTitle = payTitle;
     }
     public String getPayTitle() {
         return payTitle;
     }

    public void setPayContent(String payContent) {
         this.payContent = payContent;
     }
     public String getPayContent() {
         return payContent;
     }

    public void setOrderPrice(String orderPrice) {
         this.orderPrice = orderPrice;
     }
     public String getOrderPrice() {
         return orderPrice;
     }

    public void setCouponPrice(int couponPrice) {
         this.couponPrice = couponPrice;
     }
     public int getCouponPrice() {
         return couponPrice;
     }

}