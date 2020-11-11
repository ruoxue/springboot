package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;

public class SendChatRetModel implements Serializable {

    /**
     * result : true
     */
    private boolean result;

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
}
