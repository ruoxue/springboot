package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class SendParam implements Serializable {

    /**
     * orderShipRequestList : [{"returnAddressId":"1_1_834542590","shippingId":"1","shippingName":"申通快递","orderSn":"191220-384685998833090","deliveryType":0,"trackingNumber":"1234555","importTime":0}]
     * isVirtualGoods : false
     * functionType : 3
     * operateFrom : MMS
     * overWrite : 1
     * isSingleShipment : 1
     *
     * {"isVirtualGoods":false,"orderShipRequestList":[{"orderSn":"191220-384685998833090","shippingId":"1","shippingName":"申通快递","trackingNumber":"1234555",
     *         // "deliveryType":0,"returnAddressId":"1_1_834542590","importTime":0}],"functionType":3,"overWrite":1,"isSingleShipment":1,"operateFrom":"MMS"}
     */
    private List<OrderShipRequestListEntity> orderShipRequestList;
    private boolean isVirtualGoods=false;
    private int functionType=3;
    private String operateFrom="MMS";
    private int overWrite=1;
    private int isSingleShipment=1;

    public void setOrderShipRequestList(List<OrderShipRequestListEntity> orderShipRequestList) {
        this.orderShipRequestList = orderShipRequestList;
    }

    public void setIsVirtualGoods(boolean isVirtualGoods) {
        this.isVirtualGoods = isVirtualGoods;
    }

    public void setFunctionType(int functionType) {
        this.functionType = functionType;
    }

    public void setOperateFrom(String operateFrom) {
        this.operateFrom = operateFrom;
    }

    public void setOverWrite(int overWrite) {
        this.overWrite = overWrite;
    }

    public void setIsSingleShipment(int isSingleShipment) {
        this.isSingleShipment = isSingleShipment;
    }

    public List<OrderShipRequestListEntity> getOrderShipRequestList() {
        return orderShipRequestList;
    }

    public boolean isIsVirtualGoods() {
        return isVirtualGoods;
    }

    public int getFunctionType() {
        return functionType;
    }

    public String getOperateFrom() {
        return operateFrom;
    }

    public int getOverWrite() {
        return overWrite;
    }

    public int getIsSingleShipment() {
        return isSingleShipment;
    }

    public static class OrderShipRequestListEntity {
        /**
         * returnAddressId : 1_1_834542590
         * shippingId : 1
         * shippingName : 申通快递
         * orderSn : 191220-384685998833090
         * deliveryType : 0
         * trackingNumber : 1234555
         * importTime : 0
         */
        private String returnAddressId;
        private String shippingId;
        private String shippingName;
        private String orderSn;
        private int deliveryType;
        private String trackingNumber;
        private int importTime;

        public void setReturnAddressId(String returnAddressId) {
            this.returnAddressId = returnAddressId;
        }

        public void setShippingId(String shippingId) {
            this.shippingId = shippingId;
        }

        public void setShippingName(String shippingName) {
            this.shippingName = shippingName;
        }

        public void setOrderSn(String orderSn) {
            this.orderSn = orderSn;
        }

        public void setDeliveryType(int deliveryType) {
            this.deliveryType = deliveryType;
        }

        public void setTrackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
        }

        public void setImportTime(int importTime) {
            this.importTime = importTime;
        }

        public String getReturnAddressId() {
            return returnAddressId;
        }

        public String getShippingId() {
            return shippingId;
        }

        public String getShippingName() {
            return shippingName;
        }

        public String getOrderSn() {
            return orderSn;
        }

        public int getDeliveryType() {
            return deliveryType;
        }

        public String getTrackingNumber() {
            return trackingNumber;
        }

        public int getImportTime() {
            return importTime;
        }
    }
}
