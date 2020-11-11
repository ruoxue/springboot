package com.wowotou.payservice.nx;

import java.io.Serializable;

public class RetModel implements Serializable {
    private ResultMapBean resultMap;

    public ResultMapBean getResultMap() {
        return resultMap;
    }

    public void setResultMap(ResultMapBean resultMap) {
        this.resultMap = resultMap;
    }

}
