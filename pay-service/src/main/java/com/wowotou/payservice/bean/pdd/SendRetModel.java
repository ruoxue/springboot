package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class SendRetModel  implements Serializable {

    /**
     * result : {"orderShipResultList":[{"shippingResultMsg":"","orderSn":"191220-384685998833090","warningInfo":"","shippingResultCode":100}]}
     * success : true
     * errorCode : 1000000
     * errorMsg : null
     */
    private ResultEntity result;
    private boolean success;
    private int errorCode;
    private String errorMsg;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResultEntity getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public class ResultEntity {
        /**
         * orderShipResultList : [{"shippingResultMsg":"","orderSn":"191220-384685998833090","warningInfo":"","shippingResultCode":100}]
         */
        private List<OrderShipResultListEntity> orderShipResultList;

        public void setOrderShipResultList(List<OrderShipResultListEntity> orderShipResultList) {
            this.orderShipResultList = orderShipResultList;
        }

        public List<OrderShipResultListEntity> getOrderShipResultList() {
            return orderShipResultList;
        }

        public class OrderShipResultListEntity {
            /**
             * shippingResultMsg :
             * orderSn : 191220-384685998833090
             * warningInfo :
             * shippingResultCode : 100
             */
            private String shippingResultMsg;
            private String orderSn;
            private String warningInfo;
            private int shippingResultCode;

            public void setShippingResultMsg(String shippingResultMsg) {
                this.shippingResultMsg = shippingResultMsg;
            }

            public void setOrderSn(String orderSn) {
                this.orderSn = orderSn;
            }

            public void setWarningInfo(String warningInfo) {
                this.warningInfo = warningInfo;
            }

            public void setShippingResultCode(int shippingResultCode) {
                this.shippingResultCode = shippingResultCode;
            }

            public String getShippingResultMsg() {
                return shippingResultMsg;
            }

            public String getOrderSn() {
                return orderSn;
            }

            public String getWarningInfo() {
                return warningInfo;
            }

            public int getShippingResultCode() {
                return shippingResultCode;
            }
        }
    }
}
