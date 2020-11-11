package com.wowotou.payservice.bean.kb;

import java.io.Serializable;
import java.util.List;

public class KbPriceModel implements Serializable {

    /**
     * msg : 获取价格详情成功
     * code : 0
     * Data : [{"guilei":"1,2,3","Platform":"申通","pddtyp":"100","typ":1,"ddprice":2.15,"title":"申通快递（淘宝|天猫|阿里专用）","price3":1.95,"pddkuaidi":"申通快递","price1":2.15,"price2":2.05,"status":1},{"guilei":"1,2,3","Platform":"百世","pddtyp":"502","typ":1,"ddprice":2,"title":"百世快递（淘宝|天猫|阿里专用）","price3":1.8,"pddkuaidi":"百世快递","price1":2,"price2":1.9,"status":1},{"guilei":"1,2,3","Platform":"中通","pddtyp":"115","typ":1,"ddprice":2.15,"title":"中通快递（淘宝|天猫|阿里专用）","price3":1.95,"pddkuaidi":"中通快递","price1":2.15,"price2":2.05,"status":1},{"guilei":"1,2,3","Platform":"增益","pddtyp":"1208","typ":1,"ddprice":1.65,"title":"增益速递（淘宝|天猫|阿里专用）","price3":1.45,"pddkuaidi":"增益速递","price1":1.65,"price2":1.55,"status":1},{"guilei":"1,2,3","Platform":"优速","pddtyp":"1207","typ":1,"ddprice":1.8,"title":"优速快递（淘宝|天猫|阿里专用）","price3":1.6,"pddkuaidi":"优速快递","price1":1.8,"price2":1.7,"status":1},{"guilei":"1,2,3","Platform":"国通","pddtyp":"200143","typ":1,"ddprice":1.8,"title":"国通快递（淘宝|天猫|阿里专用）","price3":1.6,"pddkuaidi":"国通快递","price1":1.8,"price2":1.7,"status":1},{"guilei":"1,2","Platform":"安能","pddtyp":"5000000392288","typ":1,"ddprice":1.75,"title":"安能物流（淘宝|天猫专用）","price3":1.55,"pddkuaidi":"安能物流 ","price1":1.75,"price2":1.65,"status":1},{"guilei":"1,2","Platform":"速通","pddtyp":"1216000000139141","typ":1,"ddprice":1.6,"title":"速通物流(淘宝|天猫专用）","price3":1.4,"pddkuaidi":"速通物流","price1":1.6,"price2":1.5,"status":1},{"guilei":"1,2","Platform":"D速","pddtyp":"354","typ":1,"ddprice":1.3,"title":"D速物流（淘宝/天猫专用）","price3":1.1,"pddkuaidi":"D速物流","price1":1.3,"price2":1.2,"status":1},{"guilei":"5","Platform":"拼多多中通","pddtyp":"115","typ":1,"ddprice":1.5,"title":"拼多多中通快递（拼多多专用）","price3":1.3,"pddkuaidi":"中通快递","price1":1.5,"price2":1.4,"status":1},{"guilei":"5","Platform":"拼多多申通","pddtyp":"1","typ":1,"ddprice":1.45,"title":"拼多多申通快递（拼多多专用）","price3":1.25,"pddkuaidi":"申通快递","price1":1.45,"price2":1.35,"status":1},{"guilei":"5","Platform":"拼多多百世","pddtyp":"3","typ":1,"ddprice":1.45,"title":"拼多多百世快递（拼多多专用）","price3":1.25,"pddkuaidi":"百世快递","price1":1.45,"price2":1.35,"status":1},{"guilei":"5","Platform":"拼多多龙邦","pddtyp":"133","typ":1,"ddprice":1.35,"title":"拼多多龙邦快递（拼多多专用）","price3":1.15,"pddkuaidi":"龙邦快递","price1":1.35,"price2":1.25,"status":1},{"guilei":"5","Platform":"拼多多远成","pddtyp":"205","typ":1,"ddprice":1,"title":"拼多多远成快运（拼多多专用）","price3":0.8,"pddkuaidi":"远成快运","price1":1,"price2":0.9,"status":1},{"guilei":"6","Platform":"电子申通","pddtyp":"1","typ":1,"ddprice":1.4,"title":"拼多多申通快递（电子面单）","price3":1.2,"pddkuaidi":"申通快递","price1":1.4,"price2":1.3,"status":1},{"guilei":"6","Platform":"电子安迅","pddtyp":"352","typ":1,"ddprice":1.05,"title":"拼多多安迅物流（电子面单）","price3":0.85,"pddkuaidi":"安迅物流","price1":1.05,"price2":0.95,"status":1},{"guilei":"6","Platform":"电子宅急送","pddtyp":"129","typ":1,"ddprice":1.35,"title":"拼多多宅急送快递（电子面单）","price3":1.15,"pddkuaidi":"宅急送快递","price1":1.35,"price2":1.25,"status":1},{"guilei":"6","Platform":"电子圆通","pddtyp":null,"typ":1,"ddprice":1.4,"title":"拼多多圆通快递（电子面单）","price3":1.2,"pddkuaidi":"圆通快递","price1":1.4,"price2":1.3,"status":1},{"guilei":"6","Platform":"电子承诺达","pddtyp":"351","typ":1,"ddprice":1,"title":"拼多多承诺达特快（电子面单）","price3":0.8,"pddkuaidi":"承诺达特快","price1":1,"price2":0.9,"status":1},{"guilei":"5","Platform":"拼多多圆通","pddtyp":null,"typ":1,"ddprice":1.6,"title":"拼多多圆通速递（拼多多专用）","price3":1.4,"pddkuaidi":"圆通快递","price1":1.6,"price2":1.5,"status":1},{"guilei":"5","Platform":"拼多多亚风","pddtyp":"317","typ":1,"ddprice":1.15,"title":"拼多多亚风速递（拼多多专用）","price3":0.95,"pddkuaidi":"亚风速递","price1":1.15,"price2":1.05,"status":1},{"guilei":"5","Platform":"拼多多优速","pddtyp":"117","typ":1,"ddprice":1.25,"title":"拼多多优速快递（拼多多专用）","price3":1.05,"pddkuaidi":"优速快递","price1":1.25,"price2":1.15,"status":1},{"guilei":"4","Platform":"京东申通","pddtyp":null,"typ":1,"ddprice":1.6,"title":"京东申通（京东专用）","price3":1.4,"pddkuaidi":null,"price1":1.6,"price2":1.5,"status":1},{"guilei":"5","Platform":"拼多多加运美","pddtyp":"275","typ":1,"ddprice":1.05,"title":"拼多多加运美（拼多多专用）","price3":0.85,"pddkuaidi":"加运美","price1":1.05,"price2":0.95,"status":1},{"guilei":"5","Platform":"拼多多D速","pddtyp":"354","typ":1,"ddprice":1.05,"title":"拼多多D速物流（拼多多专用）","price3":0.85,"pddkuaidi":"D速物流","price1":1.05,"price2":0.95,"status":1},{"guilei":"5","Platform":"拼多多安迅","pddtyp":"352","typ":1,"ddprice":1.05,"title":"拼多多安迅物流（拼多多专用）","price3":0.85,"pddkuaidi":"安迅物流","price1":1.05,"price2":0.95,"status":1},{"guilei":"5","Platform":"拼多多京广","pddtyp":"281","typ":1,"ddprice":1.1,"title":"拼多多京广速递（拼多多专用）","price3":0.9,"pddkuaidi":"京广速递","price1":1.1,"price2":1,"status":1},{"guilei":"5","Platform":"拼多多宅急送","pddtyp":"129","typ":1,"ddprice":1.2,"title":"拼多多宅急送快递（拼多多专用）","price3":1,"pddkuaidi":"宅急送快递","price1":1.2,"price2":1.1,"status":1},{"guilei":"6","Platform":"电子亚风","pddtyp":"317","typ":1,"ddprice":1.05,"title":"拼多多亚风速递（电子面单）","price3":0.85,"pddkuaidi":"亚风速递","price1":1.05,"price2":0.95,"status":1},{"guilei":"4","Platform":"京东龙邦","pddtyp":null,"typ":1,"ddprice":1.4,"title":"京东龙邦速递（京东专用）","price3":1.2,"pddkuaidi":null,"price1":1.4,"price2":1.3,"status":1},{"guilei":"5","Platform":"拼多多天天","pddtyp":"119","typ":1,"ddprice":1.25,"title":"拼多多天天快递(拼多多专用）","price3":1.05,"pddkuaidi":"天天快递","price1":1.25,"price2":1.15,"status":1},{"guilei":"4","Platform":"京东全峰","pddtyp":null,"typ":1,"ddprice":1.2,"title":"京东全峰（京东专用）","price3":1,"pddkuaidi":null,"price1":1.2,"price2":1.1,"status":1},{"guilei":"6","Platform":"电子韵达","pddtyp":"121","typ":1,"ddprice":1.2,"title":"拼多多韵达快递（电子面单）","price3":1,"pddkuaidi":"韵达快递","price1":1.2,"price2":1.1,"status":1},{"guilei":"1,2","Platform":"菜鸟国通","pddtyp":"200143","typ":1,"ddprice":1.8,"title":"国通快递（菜鸟面单-全国到全国）","price3":1.6,"pddkuaidi":"国通快递","price1":1.8,"price2":1.7,"status":1},{"guilei":"5","Platform":"拼多多商桥","pddtyp":"364","typ":1,"ddprice":1,"title":"拼多多商桥物流（拼多多专用）","price3":0.8,"pddkuaidi":"商桥物流","price1":1,"price2":0.9,"status":1},{"guilei":"6","Platform":"电子中通快运","pddtyp":"343","typ":1,"ddprice":1.25,"title":"拼多多中通快运（电子面单,注意是快运）","price3":1.05,"pddkuaidi":"中通快运","price1":1.25,"price2":1.15,"status":1},{"guilei":"1,2,3","Platform":"中通快运","pddtyp":"1216000000125358 ","typ":1,"ddprice":1.7,"title":"中通快运(淘宝/天猫/阿里专用，注意是快运）","price3":1.5,"pddkuaidi":"中通快运","price1":1.7,"price2":1.6,"status":1},{"guilei":"1,2","Platform":"安迅","pddtyp":"1216000000135273","typ":1,"ddprice":1.55,"title":"安迅物流（仅限淘宝/天猫使用）","price3":1.35,"pddkuaidi":"安迅物流","price1":1.55,"price2":1.45,"status":1},{"guilei":"6","Platform":"电子优速","pddtyp":"117","typ":1,"ddprice":1.1,"title":"拼多多优速快递（电子面单）","price3":0.9,"pddkuaidi":"优速快递","price1":1.1,"price2":1,"status":1},{"guilei":"1,2,3","Platform":"菜鸟百世","pddtyp":"502","typ":1,"ddprice":2,"title":"百世快递（菜鸟面单-全国到全国）","price3":1.8,"pddkuaidi":"百世快递","price1":2,"price2":1.9,"status":1},{"guilei":"1,2,3","Platform":"菜鸟中通快运","pddtyp":"1216000000125358","typ":1,"ddprice":1.7,"title":"中通快运(菜鸟面单，全国，注意是快运）","price3":1.5,"pddkuaidi":"中通快运","price1":1.7,"price2":1.6,"status":1},{"guilei":"1,2,3","Platform":"菜鸟天天","pddtyp":"504","typ":1,"ddprice":1.8,"title":"天天快递（菜鸟面单-全国到全国）","price3":1.6,"pddkuaidi":"天天快递","price1":1.8,"price2":1.7,"status":1},{"guilei":"6","Platform":"电子中通","pddtyp":"115","typ":1,"ddprice":1.35,"title":"拼多多中通快递（电子面单）","price3":1.15,"pddkuaidi":"中通快递","price1":1.35,"price2":1.25,"status":1},{"guilei":"1,2,3","Platform":"圆通","pddtyp":"101","typ":1,"ddprice":2,"title":"圆通速递（淘宝|天猫专用）","price3":1.8,"pddkuaidi":"圆通速递","price1":2,"price2":1.9,"status":1},{"guilei":"6","Platform":"电子天天","pddtyp":"119","typ":1,"ddprice":1.25,"title":"拼多多天天快递（电子面单）","price3":1.05,"pddkuaidi":"天天快递","price1":1.25,"price2":1.15,"status":1},{"guilei":"4","Platform":"京东亚风","pddtyp":null,"typ":1,"ddprice":1.05,"title":"京东亚风速运（京东专用）","price3":0.85,"pddkuaidi":null,"price1":1.05,"price2":0.95,"status":1},{"guilei":"6","Platform":"电子百世","pddtyp":"3","typ":1,"ddprice":1.25,"title":"拼多多百世快递（电子面单）","price3":1.05,"pddkuaidi":"百世快递","price1":1.25,"price2":1.15,"status":1},{"guilei":"6","Platform":"电子京广","pddtyp":"281","typ":1,"ddprice":1.05,"title":"拼多多京广速递（电子面单）","price3":0.85,"pddkuaidi":"京广速递","price1":1.05,"price2":0.95,"status":1}]
     */
    private String msg;
    private String code;
    private List<DataEntity> Data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(List<DataEntity> Data) {
        this.Data = Data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return Data;
    }

    public class DataEntity {
        /**
         * guilei : 1,2,3
         * Platform : 申通
         * pddtyp : 100
         * typ : 1
         * ddprice : 2.15
         * title : 申通快递（淘宝|天猫|阿里专用）
         * price3 : 1.95
         * pddkuaidi : 申通快递
         * price1 : 2.15
         * price2 : 2.05
         * status : 1
         */
        private String guilei;
        private String Platform;
        private String pddtyp;
        private int typ;
        private double ddprice;
        private String title;
        private double price3;
        private String pddkuaidi;
        private double price1;
        private double price2;
        private int status;

        public void setGuilei(String guilei) {
            this.guilei = guilei;
        }

        public void setPlatform(String Platform) {
            this.Platform = Platform;
        }

        public void setPddtyp(String pddtyp) {
            this.pddtyp = pddtyp;
        }

        public void setTyp(int typ) {
            this.typ = typ;
        }

        public void setDdprice(double ddprice) {
            this.ddprice = ddprice;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPrice3(double price3) {
            this.price3 = price3;
        }

        public void setPddkuaidi(String pddkuaidi) {
            this.pddkuaidi = pddkuaidi;
        }

        public void setPrice1(double price1) {
            this.price1 = price1;
        }

        public void setPrice2(double price2) {
            this.price2 = price2;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getGuilei() {
            return guilei;
        }

        public String getPlatform() {
            return Platform;
        }

        public String getPddtyp() {
            return pddtyp;
        }

        public int getTyp() {
            return typ;
        }

        public double getDdprice() {
            return ddprice;
        }

        public String getTitle() {
            return title;
        }

        public double getPrice3() {
            return price3;
        }

        public String getPddkuaidi() {
            return pddkuaidi;
        }

        public double getPrice1() {
            return price1;
        }

        public double getPrice2() {
            return price2;
        }

        public int getStatus() {
            return status;
        }
    }
}
