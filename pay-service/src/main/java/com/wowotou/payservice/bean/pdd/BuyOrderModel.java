package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;

public class BuyOrderModel implements Serializable  {

    /**
     * server_time : 1576943843
     * quantity : null
     * nickname : 133****2661
     * share_code : null
     */
    private int server_time;
    private String quantity;
    private String nickname;
    private String share_code;

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setShare_code(String share_code) {
        this.share_code = share_code;
    }

    public int getServer_time() {
        return server_time;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getNickname() {
        return nickname;
    }

    public String getShare_code() {
        return share_code;
    }
}
