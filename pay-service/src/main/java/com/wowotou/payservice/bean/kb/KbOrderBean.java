package com.wowotou.payservice.bean.kb;

import java.io.Serializable;
import java.util.List;

public class KbOrderBean implements Serializable {

    /**
     * 拼多多优速快递（拼多多专用）1.25元/代理1.05元/我价格1.25元
     * SendAddress : 岭南大道321号
     * Platform : 百世
     * SendContact : 发件人
     * Raddress : [{"OfficePhone":"15888888888","Address":"岭南大道321号","State":"广东省","CellPhone":"15888888888","OrderNo":"T100001111","City":"广州市","District":"番禺区","Contact":"收货人1"},{"OfficePhone":"15888888888","Address":" 岭南大道321号","State":"广东省","CellPhone":"15888888888","OrderNo":"T100002","City":"广州市","District":"番禺区","Contact":"收货人2"}]
     * SendDistrict : 番禺区
     * SendState : 广东省
     * ProductTitle : 衣服
     * SendCellPhone : 15888888888
     * SendCity : 广州市
     * Weight : 2
     * SendOfficePhone : 15888888888
     */
    private String SendAddress="岭南大道321号";
    private String Platform="拼多多优速快递";
    private String SendContact="发件人";
    private List<RaddressEntity> Raddress;
    private String SendDistrict;
    private String SendState;
    private String ProductTitle;
    private String SendCellPhone;
    private String SendCity;
    private String Weight;
    private String SendOfficePhone;

    public void setSendAddress(String SendAddress) {
        this.SendAddress = SendAddress;
    }

    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }

    public void setSendContact(String SendContact) {
        this.SendContact = SendContact;
    }

    public void setRaddress(List<RaddressEntity> Raddress) {
        this.Raddress = Raddress;
    }

    public void setSendDistrict(String SendDistrict) {
        this.SendDistrict = SendDistrict;
    }

    public void setSendState(String SendState) {
        this.SendState = SendState;
    }

    public void setProductTitle(String ProductTitle) {
        this.ProductTitle = ProductTitle;
    }

    public void setSendCellPhone(String SendCellPhone) {
        this.SendCellPhone = SendCellPhone;
    }

    public void setSendCity(String SendCity) {
        this.SendCity = SendCity;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    public void setSendOfficePhone(String SendOfficePhone) {
        this.SendOfficePhone = SendOfficePhone;
    }

    public String getSendAddress() {
        return SendAddress;
    }

    public String getPlatform() {
        return Platform;
    }

    public String getSendContact() {
        return SendContact;
    }

    public List<RaddressEntity> getRaddress() {
        return Raddress;
    }

    public String getSendDistrict() {
        return SendDistrict;
    }

    public String getSendState() {
        return SendState;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public String getSendCellPhone() {
        return SendCellPhone;
    }

    public String getSendCity() {
        return SendCity;
    }

    public String getWeight() {
        return Weight;
    }

    public String getSendOfficePhone() {
        return SendOfficePhone;
    }

    public static class RaddressEntity {
        /**
         * OfficePhone : 15888888888
         * Address : 岭南大道321号
         * State : 广东省
         * CellPhone : 15888888888
         * OrderNo : T100001111
         * City : 广州市
         * District : 番禺区
         * Contact : 收货人1
         */
        private String OfficePhone;
        private String Address;
        private String State;
        private String CellPhone;
        private String OrderNo;
        private String City;
        private String District;
        private String Contact;

        public void setOfficePhone(String OfficePhone) {
            this.OfficePhone = OfficePhone;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public void setState(String State) {
            this.State = State;
        }

        public void setCellPhone(String CellPhone) {
            this.CellPhone = CellPhone;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public void setCity(String City) {
            this.City = City;
        }

        public void setDistrict(String District) {
            this.District = District;
        }

        public void setContact(String Contact) {
            this.Contact = Contact;
        }

        public String getOfficePhone() {
            return OfficePhone;
        }

        public String getAddress() {
            return Address;
        }

        public String getState() {
            return State;
        }

        public String getCellPhone() {
            return CellPhone;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public String getCity() {
            return City;
        }

        public String getDistrict() {
            return District;
        }

        public String getContact() {
            return Contact;
        }
    }
}
