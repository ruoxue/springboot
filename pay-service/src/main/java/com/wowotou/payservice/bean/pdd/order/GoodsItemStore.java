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
public class GoodsItemStore {

    private int goodsNumber;
    private boolean isShowGoodsNumber;
    private boolean showPlusMinusButton;
    private boolean increaseDisable;
    private long finalLimitNumber;
    private int finalLeastNumber;
    private boolean reduceDisable;
    private int limitStatus;
    public void setGoodsNumber(int goodsNumber) {
         this.goodsNumber = goodsNumber;
     }
     public int getGoodsNumber() {
         return goodsNumber;
     }

    public void setIsShowGoodsNumber(boolean isShowGoodsNumber) {
         this.isShowGoodsNumber = isShowGoodsNumber;
     }
     public boolean getIsShowGoodsNumber() {
         return isShowGoodsNumber;
     }

    public void setShowPlusMinusButton(boolean showPlusMinusButton) {
         this.showPlusMinusButton = showPlusMinusButton;
     }
     public boolean getShowPlusMinusButton() {
         return showPlusMinusButton;
     }

    public void setIncreaseDisable(boolean increaseDisable) {
         this.increaseDisable = increaseDisable;
     }
     public boolean getIncreaseDisable() {
         return increaseDisable;
     }

    public void setFinalLimitNumber(long finalLimitNumber) {
         this.finalLimitNumber = finalLimitNumber;
     }
     public long getFinalLimitNumber() {
         return finalLimitNumber;
     }

    public void setFinalLeastNumber(int finalLeastNumber) {
         this.finalLeastNumber = finalLeastNumber;
     }
     public int getFinalLeastNumber() {
         return finalLeastNumber;
     }

    public void setReduceDisable(boolean reduceDisable) {
         this.reduceDisable = reduceDisable;
     }
     public boolean getReduceDisable() {
         return reduceDisable;
     }

    public void setLimitStatus(int limitStatus) {
         this.limitStatus = limitStatus;
     }
     public int getLimitStatus() {
         return limitStatus;
     }

}