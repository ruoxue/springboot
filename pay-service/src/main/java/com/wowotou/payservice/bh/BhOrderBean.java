package com.wowotou.payservice.bh;

import java.io.Serializable;

public class BhOrderBean implements Serializable {


    /**
     * amount : ￥12.00元
     * createtime : 2019-04-03 22:56:40
     * orderno : 订单编号: 2479jpzfbQ155430339928de
     * totalamount : 12.00
     * status : 已完成
     * text : 支付宝扫码
     * source : source://image/ico/alipay.png
     * time : 订单时间: 04-03 22:56/实际到账: 10.44
     * _time : 订单时间: 04-03 22:56
     * _amount : 实际到账: 10.44
     * scolor : 35D5DEFF
     */

    private String amount;
    private String createtime;
    private String orderno;
    private String totalamount;
    private String status;
    private String text;
    private String source;
    private String time;
    private String _time;
    private String _amount;
    private String scolor;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String get_time() {
        return _time;
    }

    public void set_time(String _time) {
        this._time = _time;
    }

    public String get_amount() {
        return _amount;
    }

    public void set_amount(String _amount) {
        this._amount = _amount;
    }

    public String getScolor() {
        return scolor;
    }

    public void setScolor(String scolor) {
        this.scolor = scolor;
    }
}
