package com.wowotou.payservice.bean.zhuanzhuan;

public class BaseZhuanModel<T> {
    private  int respCode;
    private  T data;

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
