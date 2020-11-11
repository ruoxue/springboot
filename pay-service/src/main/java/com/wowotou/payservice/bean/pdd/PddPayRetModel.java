package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class PddPayRetModel implements Serializable {

    /**
     * result : {"total":2,"data":[{"createdAt":1576911603,"note":"-","amount":1100,"classId":1,"orderSn":"191220-384685998833090","mallId":834542590,"financeId":1,"id":2002398637,"type":1,"relatedId":979384685998833090,"extraInfo":null},{"createdAt":1576911603,"note":"-","amount":-7,"classId":5,"orderSn":"191220-384685998833090","mallId":834542590,"financeId":10,"id":2002398636,"type":9,"relatedId":979384685998833090,"extraInfo":null}]}
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
         * total : 2
         * data : [{"createdAt":1576911603,"note":"-","amount":1100,"classId":1,"orderSn":"191220-384685998833090","mallId":834542590,"financeId":1,"id":2002398637,"type":1,"relatedId":979384685998833090,"extraInfo":null},{"createdAt":1576911603,"note":"-","amount":-7,"classId":5,"orderSn":"191220-384685998833090","mallId":834542590,"financeId":10,"id":2002398636,"type":9,"relatedId":979384685998833090,"extraInfo":null}]
         */
        private int total;
        private List<DataEntity> data;

        public void setTotal(int total) {
            this.total = total;
        }

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public int getTotal() {
            return total;
        }

        public List<DataEntity> getData() {
            return data;
        }

        public class DataEntity {
            /**
             * createdAt : 1576911603
             * note : -
             * amount : 1100
             * classId : 1
             * orderSn : 191220-384685998833090
             * mallId : 834542590
             * financeId : 1
             * id : 2002398637
             * type : 1
             * relatedId : 979384685998833090
             * extraInfo : null
             */
            private int createdAt;
            private String note;
            private int amount;
            private int classId;
            private String orderSn;
            private int mallId;
            private int financeId;
            private int id;
            private int type;
            private long relatedId;
            private String extraInfo;

            public void setCreatedAt(int createdAt) {
                this.createdAt = createdAt;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public void setClassId(int classId) {
                this.classId = classId;
            }

            public void setOrderSn(String orderSn) {
                this.orderSn = orderSn;
            }

            public void setMallId(int mallId) {
                this.mallId = mallId;
            }

            public void setFinanceId(int financeId) {
                this.financeId = financeId;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setRelatedId(long relatedId) {
                this.relatedId = relatedId;
            }

            public void setExtraInfo(String extraInfo) {
                this.extraInfo = extraInfo;
            }

            public int getCreatedAt() {
                return createdAt;
            }

            public String getNote() {
                return note;
            }

            public int getAmount() {
                return amount;
            }

            public int getClassId() {
                return classId;
            }

            public String getOrderSn() {
                return orderSn;
            }

            public int getMallId() {
                return mallId;
            }

            public int getFinanceId() {
                return financeId;
            }

            public int getId() {
                return id;
            }

            public int getType() {
                return type;
            }

            public long getRelatedId() {
                return relatedId;
            }

            public String getExtraInfo() {
                return extraInfo;
            }
        }
    }
}
