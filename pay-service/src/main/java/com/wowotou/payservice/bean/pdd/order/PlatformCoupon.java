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
public class PlatformCoupon {

    private String batchId;
    private String couponId;
    private int promotionStatus;
    private String discount;
    private String displayType;
    private String displayName;
    private String isReachMinAmount;
    private String minAmount;
    private String notUse;
    private String isSuperpositionCoupon;
    private int superpositionCouponNumber;
    private boolean isPlatformCouponForbidden;
    private String category;
    public void setBatchId(String batchId) {
         this.batchId = batchId;
     }
     public String getBatchId() {
         return batchId;
     }

    public void setCouponId(String couponId) {
         this.couponId = couponId;
     }
     public String getCouponId() {
         return couponId;
     }

    public void setPromotionStatus(int promotionStatus) {
         this.promotionStatus = promotionStatus;
     }
     public int getPromotionStatus() {
         return promotionStatus;
     }

    public void setDiscount(String discount) {
         this.discount = discount;
     }
     public String getDiscount() {
         return discount;
     }

    public void setDisplayType(String displayType) {
         this.displayType = displayType;
     }
     public String getDisplayType() {
         return displayType;
     }

    public void setDisplayName(String displayName) {
         this.displayName = displayName;
     }
     public String getDisplayName() {
         return displayName;
     }

    public void setIsReachMinAmount(String isReachMinAmount) {
         this.isReachMinAmount = isReachMinAmount;
     }
     public String getIsReachMinAmount() {
         return isReachMinAmount;
     }

    public void setMinAmount(String minAmount) {
         this.minAmount = minAmount;
     }
     public String getMinAmount() {
         return minAmount;
     }

    public void setNotUse(String notUse) {
         this.notUse = notUse;
     }
     public String getNotUse() {
         return notUse;
     }

    public void setIsSuperpositionCoupon(String isSuperpositionCoupon) {
         this.isSuperpositionCoupon = isSuperpositionCoupon;
     }
     public String getIsSuperpositionCoupon() {
         return isSuperpositionCoupon;
     }

    public void setSuperpositionCouponNumber(int superpositionCouponNumber) {
         this.superpositionCouponNumber = superpositionCouponNumber;
     }
     public int getSuperpositionCouponNumber() {
         return superpositionCouponNumber;
     }

    public void setIsPlatformCouponForbidden(boolean isPlatformCouponForbidden) {
         this.isPlatformCouponForbidden = isPlatformCouponForbidden;
     }
     public boolean getIsPlatformCouponForbidden() {
         return isPlatformCouponForbidden;
     }

    public void setCategory(String category) {
         this.category = category;
     }
     public String getCategory() {
         return category;
     }

}