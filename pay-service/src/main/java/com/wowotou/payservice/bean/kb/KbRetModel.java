package com.wowotou.payservice.bean.kb;

import java.io.Serializable;
import java.util.List;

public class KbRetModel implements Serializable {

    /**
     * msg : 下单成功
     * code : 0
     * Data : [{"Trackingno":"336141134842","OrderNo":"T100001111","WaybillSn":""},{"Trackingno":"336141134843","OrderNo":"T100002","WaybillSn":""}]
     */
    private String msg;
    private String code;
    private List<DataEntity> Data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(List<DataEntity> Data) {
        this.Data = Data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return Data;
    }

    public class DataEntity {
        /**
         * Trackingno : 336141134842
         * OrderNo : T100001111
         * WaybillSn :
         */
        private String Trackingno;
        private String OrderNo;
        private String WaybillSn;

        public void setTrackingno(String Trackingno) {
            this.Trackingno = Trackingno;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public void setWaybillSn(String WaybillSn) {
            this.WaybillSn = WaybillSn;
        }

        public String getTrackingno() {
            return Trackingno;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public String getWaybillSn() {
            return WaybillSn;
        }
    }
}
