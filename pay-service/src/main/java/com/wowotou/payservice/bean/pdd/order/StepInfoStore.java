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
public class StepInfoStore {

    private int depositPrice;
    private int inflatePrice;
    private int stepPrice;
    private int stepPayStartTime;
    public void setDepositPrice(int depositPrice) {
         this.depositPrice = depositPrice;
     }
     public int getDepositPrice() {
         return depositPrice;
     }

    public void setInflatePrice(int inflatePrice) {
         this.inflatePrice = inflatePrice;
     }
     public int getInflatePrice() {
         return inflatePrice;
     }

    public void setStepPrice(int stepPrice) {
         this.stepPrice = stepPrice;
     }
     public int getStepPrice() {
         return stepPrice;
     }

    public void setStepPayStartTime(int stepPayStartTime) {
         this.stepPayStartTime = stepPayStartTime;
     }
     public int getStepPayStartTime() {
         return stepPayStartTime;
     }

}