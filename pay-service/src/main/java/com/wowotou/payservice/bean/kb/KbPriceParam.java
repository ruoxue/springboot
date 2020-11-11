package com.wowotou.payservice.bean.kb;

import java.io.Serializable;

public class KbPriceParam implements Serializable {

    /**
     * Platform : allkd
     * Adminikey : 51113
     */
    private String Platform="allkd";
    private String Adminikey="";

    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }

    public void setAdminikey(String Adminikey) {
        this.Adminikey = Adminikey;
    }

    public String getPlatform() {
        return Platform;
    }

    public String getAdminikey() {
        return Adminikey;
    }
}
