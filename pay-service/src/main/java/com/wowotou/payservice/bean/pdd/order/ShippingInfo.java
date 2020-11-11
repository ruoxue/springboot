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
public class ShippingInfo {

    private String title;
    private int cost;
    private String shippingPrice;
    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setCost(int cost) {
         this.cost = cost;
     }
     public int getCost() {
         return cost;
     }

    public void setShippingPrice(String shippingPrice) {
         this.shippingPrice = shippingPrice;
     }
     public String getShippingPrice() {
         return shippingPrice;
     }

}