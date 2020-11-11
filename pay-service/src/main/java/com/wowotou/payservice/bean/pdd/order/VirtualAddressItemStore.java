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
public class VirtualAddressItemStore {

    private String mobileInputNumber;
    private boolean isFocused;
    private boolean showNativeMobileSelect;
    private boolean hasInitMobile;
    private List<String> recordList;
    private String mobileNumber;
    private String mobileOwner;
    public void setMobileInputNumber(String mobileInputNumber) {
         this.mobileInputNumber = mobileInputNumber;
     }
     public String getMobileInputNumber() {
         return mobileInputNumber;
     }

    public void setIsFocused(boolean isFocused) {
         this.isFocused = isFocused;
     }
     public boolean getIsFocused() {
         return isFocused;
     }

    public void setShowNativeMobileSelect(boolean showNativeMobileSelect) {
         this.showNativeMobileSelect = showNativeMobileSelect;
     }
     public boolean getShowNativeMobileSelect() {
         return showNativeMobileSelect;
     }

    public void setHasInitMobile(boolean hasInitMobile) {
         this.hasInitMobile = hasInitMobile;
     }
     public boolean getHasInitMobile() {
         return hasInitMobile;
     }

    public void setRecordList(List<String> recordList) {
         this.recordList = recordList;
     }
     public List<String> getRecordList() {
         return recordList;
     }

    public void setMobileNumber(String mobileNumber) {
         this.mobileNumber = mobileNumber;
     }
     public String getMobileNumber() {
         return mobileNumber;
     }

    public void setMobileOwner(String mobileOwner) {
         this.mobileOwner = mobileOwner;
     }
     public String getMobileOwner() {
         return mobileOwner;
     }

}