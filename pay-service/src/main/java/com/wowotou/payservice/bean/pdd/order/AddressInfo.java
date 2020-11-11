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
public class AddressInfo {

    private boolean cantReceiveSupported;
    private boolean wechatFetchAvail;
    private long addressId;
    private String name;
    private String provice;
    private int provinceId;
    private String city;
    private String district;
    private String address;
    private String mobile;
    private boolean isGoodsSoldHere;
    private List<String> addressLabels;
    private String noAddressTip;
    private String province;
    public void setCantReceiveSupported(boolean cantReceiveSupported) {
         this.cantReceiveSupported = cantReceiveSupported;
     }
     public boolean getCantReceiveSupported() {
         return cantReceiveSupported;
     }

    public void setWechatFetchAvail(boolean wechatFetchAvail) {
         this.wechatFetchAvail = wechatFetchAvail;
     }
     public boolean getWechatFetchAvail() {
         return wechatFetchAvail;
     }

    public void setAddressId(long addressId) {
         this.addressId = addressId;
     }
     public long getAddressId() {
         return addressId;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setProvice(String provice) {
         this.provice = provice;
     }
     public String getProvice() {
         return provice;
     }

    public void setProvinceId(int provinceId) {
         this.provinceId = provinceId;
     }
     public int getProvinceId() {
         return provinceId;
     }

    public void setCity(String city) {
         this.city = city;
     }
     public String getCity() {
         return city;
     }

    public void setDistrict(String district) {
         this.district = district;
     }
     public String getDistrict() {
         return district;
     }

    public void setAddress(String address) {
         this.address = address;
     }
     public String getAddress() {
         return address;
     }

    public void setMobile(String mobile) {
         this.mobile = mobile;
     }
     public String getMobile() {
         return mobile;
     }

    public void setIsGoodsSoldHere(boolean isGoodsSoldHere) {
         this.isGoodsSoldHere = isGoodsSoldHere;
     }
     public boolean getIsGoodsSoldHere() {
         return isGoodsSoldHere;
     }

    public void setAddressLabels(List<String> addressLabels) {
         this.addressLabels = addressLabels;
     }
     public List<String> getAddressLabels() {
         return addressLabels;
     }

    public void setNoAddressTip(String noAddressTip) {
         this.noAddressTip = noAddressTip;
     }
     public String getNoAddressTip() {
         return noAddressTip;
     }

    public void setProvince(String province) {
         this.province = province;
     }
     public String getProvince() {
         return province;
     }

}