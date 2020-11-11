package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class SalePddAddressModel implements Serializable {

    /**
     * result : [{"refundName":"bob li","districtCode":null,"districtName":"东城区","isLegal":true,"mallId":834542590,"provinceCode":null,"cityCode":null,"cityId":52,"refundTel":"010-0000000","provinceId":2,"refundAddress":"杭州oooo","isDefault":"Y","districtId":500,"isValidated":true,"cityName":"北京市","id":101408478,"provinceName":"北京市","refundId":"1_1_834542590","refundPhone":"15657171691"}]
     * success : true
     * errorCode : 0
     * errorMsg : 成功
     */
    private List<ResultEntity> result;
    private boolean success;
    private int errorCode;
    private String errorMsg;

    public void setResult(List<ResultEntity> result) {
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

    public List<ResultEntity> getResult() {
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
         * refundName : bob li
         * districtCode : null
         * districtName : 东城区
         * isLegal : true
         * mallId : 834542590
         * provinceCode : null
         * cityCode : null
         * cityId : 52
         * refundTel : 010-0000000
         * provinceId : 2
         * refundAddress : 杭州oooo
         * isDefault : Y
         * districtId : 500
         * isValidated : true
         * cityName : 北京市
         * id : 101408478
         * provinceName : 北京市
         * refundId : 1_1_834542590
         * refundPhone : 15657171691
         */
        private String refundName;
        private String districtCode;
        private String districtName;
        private boolean isLegal;
        private int mallId;
        private String provinceCode;
        private String cityCode;
        private int cityId;
        private String refundTel;
        private int provinceId;
        private String refundAddress;
        private String isDefault;
        private int districtId;
        private boolean isValidated;
        private String cityName;
        private int id;
        private String provinceName;
        private String refundId;
        private String refundPhone;

        public void setRefundName(String refundName) {
            this.refundName = refundName;
        }

        public void setDistrictCode(String districtCode) {
            this.districtCode = districtCode;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public void setIsLegal(boolean isLegal) {
            this.isLegal = isLegal;
        }

        public void setMallId(int mallId) {
            this.mallId = mallId;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public void setRefundTel(String refundTel) {
            this.refundTel = refundTel;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public void setRefundAddress(String refundAddress) {
            this.refundAddress = refundAddress;
        }

        public void setIsDefault(String isDefault) {
            this.isDefault = isDefault;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }

        public void setIsValidated(boolean isValidated) {
            this.isValidated = isValidated;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public void setRefundPhone(String refundPhone) {
            this.refundPhone = refundPhone;
        }

        public String getRefundName() {
            return refundName;
        }

        public String getDistrictCode() {
            return districtCode;
        }

        public String getDistrictName() {
            return districtName;
        }

        public boolean isIsLegal() {
            return isLegal;
        }

        public int getMallId() {
            return mallId;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public int getCityId() {
            return cityId;
        }

        public String getRefundTel() {
            return refundTel;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public String getRefundAddress() {
            return refundAddress;
        }

        public String getIsDefault() {
            return isDefault;
        }

        public int getDistrictId() {
            return districtId;
        }

        public boolean isIsValidated() {
            return isValidated;
        }

        public String getCityName() {
            return cityName;
        }

        public int getId() {
            return id;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public String getRefundId() {
            return refundId;
        }

        public String getRefundPhone() {
            return refundPhone;
        }
    }
}
