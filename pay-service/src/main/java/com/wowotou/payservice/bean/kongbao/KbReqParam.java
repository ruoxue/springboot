package com.wowotou.payservice.bean.kongbao;

import java.io.Serializable;
import java.util.List;

public class KbReqParam implements Serializable {

    /**
     * kdid : 8
     * num : 5
     * kg : null
     * items : [{"msg":"张无忌，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","pid":"1608032354010100"},{"msg":"张无忌，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","pid":"1608032354010101"},{"msg":"张无忌，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006","pid":"1608032354010102"}]
     * info : {"sign":"3f88b4c651fc7e05fd6e590097107790","sid":"87799f9c-2c73-4cbc-8982-01f5c256c3c0","username":"linguikun"}
     * postAddrItem : {"area":"东城区","province":"北京","postPhone":"13421304686","city":"北京市","postName":"李逍遥","addr":"紫禁城"}
     */
    private int kdid;
    private int num;
    private String kg;
    private List<ItemsEntity> items;
    private InfoEntity info;
    private PostAddrItemEntity postAddrItem;

    public void setKdid(int kdid) {
        this.kdid = kdid;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public void setPostAddrItem(PostAddrItemEntity postAddrItem) {
        this.postAddrItem = postAddrItem;
    }

    public int getKdid() {
        return kdid;
    }

    public int getNum() {
        return num;
    }

    public String getKg() {
        return kg;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public InfoEntity getInfo() {
        return info;
    }

    public PostAddrItemEntity getPostAddrItem() {
        return postAddrItem;
    }

    public static class ItemsEntity {
        /**
         * msg : 张无忌，15888888888，广东省 广州市 番禺区 岭南大道321号 ，330006
         * pid : 1608032354010100
         */
        private String msg;
        private String pid;

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getMsg() {
            return msg;
        }

        public String getPid() {
            return pid;
        }
    }

    public static class InfoEntity {
        /**
         * sign : 3f88b4c651fc7e05fd6e590097107790
         * sid : 87799f9c-2c73-4cbc-8982-01f5c256c3c0
         * username : linguikun
         */
        private String sign;
        private String sid;
        private String username;

        public void setSign(String sign) {
            this.sign = sign;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSign() {
            return sign;
        }

        public String getSid() {
            return sid;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class PostAddrItemEntity {
        /**
         * area : 东城区
         * province : 北京
         * postPhone : 13421304686
         * city : 北京市
         * postName : 李逍遥
         * addr : 紫禁城
         */
        private String area;
        private String province;
        private String postPhone;
        private String city;
        private String postName;
        private String addr;

        public void setArea(String area) {
            this.area = area;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setPostPhone(String postPhone) {
            this.postPhone = postPhone;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getArea() {
            return area;
        }

        public String getProvince() {
            return province;
        }

        public String getPostPhone() {
            return postPhone;
        }

        public String getCity() {
            return city;
        }

        public String getPostName() {
            return postName;
        }

        public String getAddr() {
            return addr;
        }
    }
}
