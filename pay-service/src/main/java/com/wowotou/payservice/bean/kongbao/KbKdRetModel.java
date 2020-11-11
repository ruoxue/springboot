package com.wowotou.payservice.bean.kongbao;

import java.io.Serializable;
import java.util.List;

public class KbKdRetModel implements Serializable {

    /**
     * kddhs : [{"takeAddr":"李四，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","price":1,"num":"1223154156456","pid":"100100100100"},{"takeAddr":"李四，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","price":1,"num":"1223154156456","pid":"100100100101"},{"takeAddr":"李四，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","price":1,"num":"1223154156456","pid":"100100100102"},{"takeAddr":"李四，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","price":1,"num":"1223154156456","pid":"100100100103"},{"takeAddr":"李四，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","price":1,"num":"1223154156456","pid":"100100100104"}]
     * status : ok
     */
    private List<KddhsEntity> kddhs;
    private String status;

    public void setKddhs(List<KddhsEntity> kddhs) {
        this.kddhs = kddhs;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<KddhsEntity> getKddhs() {
        return kddhs;
    }

    public String getStatus() {
        return status;
    }

    public class KddhsEntity {
        /**
         * takeAddr : 李四，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006
         * price : 1
         * num : 1223154156456
         * pid : 100100100100
         */
        private String takeAddr;
        private double price;
        private String num;
        private String pid;

        public void setTakeAddr(String takeAddr) {
            this.takeAddr = takeAddr;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getTakeAddr() {
            return takeAddr;
        }

        public double getPrice() {
            return price;
        }

        public String getNum() {
            return num;
        }

        public String getPid() {
            return pid;
        }
    }
}
