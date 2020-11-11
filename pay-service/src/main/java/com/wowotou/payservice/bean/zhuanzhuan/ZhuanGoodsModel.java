package com.wowotou.payservice.bean.zhuanzhuan;

import java.io.Serializable;
import java.util.List;

public class ZhuanGoodsModel implements Serializable {

    /**
     * respData : [{"diagnoseOn":"-1","infoId":"1197078345982787603","operationButtonInfo":{"operate":"jump","businessType":"0","jumpUrl":"https://m.zhuanzhuan.com/biz/zzmflow/index.html?bizResourceId=biz_10004","desc":"开启加速"},"serviceWindow":{"style":"2","iconUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v29b2af63ea2dc4b55a94be3fb6e8ef835.png","title":"快卖小技巧：","content":"宝贝图片大于3张能卖更快～快点击「编辑」去添加吧"},"infoLabels":[],"video":{"picUrl":""},"title":"鼠标","content":" 请走转转担保交易，喜欢的话就赶快联系我吧。","nowPrice":"10","abtest":"1","infoType":"9","infoUrl":"http://zhuanzhuan.58.com/zz/redirect/inforurlredirect?infoId=1197078345982787603","viewCount":"4","infoEditable":"1","pics":"n_v23f0f8c9a96b74403b4af029fe9e9f164.jpg","zhuanDesc":"宝贝还有$remindDays$天展示机会，到期后会自动下架；您可以通过\u201c转起来\u201d重新获得90天展示，已下架宝贝也可以通过\u201c重新上架\u201d再次开卖","isSupportQuickHint":"0","remindDays":"87","collectCount":"0","nowPrice_f":"1000","canZhuan":"1","commentCount":"0","oriPrice":"0","oriPrice_f":"0","metric":"KPsp7P4JxIWUcrWVUQ4LQQd11231lv","cateId":"2103007","status":"1"}]
     * respCode : 0
     */
    private List<RespDataEntity> respData;
    private String respCode;

    public void setRespData(List<RespDataEntity> respData) {
        this.respData = respData;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public List<RespDataEntity> getRespData() {
        return respData;
    }

    public String getRespCode() {
        return respCode;
    }

    public class RespDataEntity {
        /**
         * diagnoseOn : -1
         * infoId : 1197078345982787603
         * operationButtonInfo : {"operate":"jump","businessType":"0","jumpUrl":"https://m.zhuanzhuan.com/biz/zzmflow/index.html?bizResourceId=biz_10004","desc":"开启加速"}
         * serviceWindow : {"style":"2","iconUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v29b2af63ea2dc4b55a94be3fb6e8ef835.png","title":"快卖小技巧：","content":"宝贝图片大于3张能卖更快～快点击「编辑」去添加吧"}
         * infoLabels : []
         * video : {"picUrl":""}
         * title : 鼠标
         * content :  请走转转担保交易，喜欢的话就赶快联系我吧。
         * nowPrice : 10
         * abtest : 1
         * infoType : 9
         * infoUrl : http://zhuanzhuan.58.com/zz/redirect/inforurlredirect?infoId=1197078345982787603
         * viewCount : 4
         * infoEditable : 1
         * pics : n_v23f0f8c9a96b74403b4af029fe9e9f164.jpg
         * zhuanDesc : 宝贝还有$remindDays$天展示机会，到期后会自动下架；您可以通过“转起来”重新获得90天展示，已下架宝贝也可以通过“重新上架”再次开卖
         * isSupportQuickHint : 0
         * remindDays : 87
         * collectCount : 0
         * nowPrice_f : 1000
         * canZhuan : 1
         * commentCount : 0
         * oriPrice : 0
         * oriPrice_f : 0
         * metric : KPsp7P4JxIWUcrWVUQ4LQQd11231lv
         * cateId : 2103007
         * status : 1
         */
        private String diagnoseOn;
        private String infoId;
        private OperationButtonInfoEntity operationButtonInfo;
        private ServiceWindowEntity serviceWindow;
        private List<?> infoLabels;
        private VideoEntity video;
        private String title;
        private String content;
        private String nowPrice;
        private String abtest;
        private String infoType;
        private String infoUrl;
        private String viewCount;
        private String infoEditable;
        private String pics;
        private String zhuanDesc;
        private String isSupportQuickHint;
        private String remindDays;
        private String collectCount;
        private String nowPrice_f;
        private String canZhuan;
        private String commentCount;
        private String oriPrice;
        private String oriPrice_f;
        private String metric;
        private String cateId;
        private String status;

        public void setDiagnoseOn(String diagnoseOn) {
            this.diagnoseOn = diagnoseOn;
        }

        public void setInfoId(String infoId) {
            this.infoId = infoId;
        }

        public void setOperationButtonInfo(OperationButtonInfoEntity operationButtonInfo) {
            this.operationButtonInfo = operationButtonInfo;
        }

        public void setServiceWindow(ServiceWindowEntity serviceWindow) {
            this.serviceWindow = serviceWindow;
        }

        public void setInfoLabels(List<?> infoLabels) {
            this.infoLabels = infoLabels;
        }

        public void setVideo(VideoEntity video) {
            this.video = video;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setNowPrice(String nowPrice) {
            this.nowPrice = nowPrice;
        }

        public void setAbtest(String abtest) {
            this.abtest = abtest;
        }

        public void setInfoType(String infoType) {
            this.infoType = infoType;
        }

        public void setInfoUrl(String infoUrl) {
            this.infoUrl = infoUrl;
        }

        public void setViewCount(String viewCount) {
            this.viewCount = viewCount;
        }

        public void setInfoEditable(String infoEditable) {
            this.infoEditable = infoEditable;
        }

        public void setPics(String pics) {
            this.pics = pics;
        }

        public void setZhuanDesc(String zhuanDesc) {
            this.zhuanDesc = zhuanDesc;
        }

        public void setIsSupportQuickHint(String isSupportQuickHint) {
            this.isSupportQuickHint = isSupportQuickHint;
        }

        public void setRemindDays(String remindDays) {
            this.remindDays = remindDays;
        }

        public void setCollectCount(String collectCount) {
            this.collectCount = collectCount;
        }

        public void setNowPrice_f(String nowPrice_f) {
            this.nowPrice_f = nowPrice_f;
        }

        public void setCanZhuan(String canZhuan) {
            this.canZhuan = canZhuan;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public void setOriPrice(String oriPrice) {
            this.oriPrice = oriPrice;
        }

        public void setOriPrice_f(String oriPrice_f) {
            this.oriPrice_f = oriPrice_f;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDiagnoseOn() {
            return diagnoseOn;
        }

        public String getInfoId() {
            return infoId;
        }

        @Override
        public String toString() {
            return "RespDataEntity{" +
                    "diagnoseOn='" + diagnoseOn + '\'' +
                    ", infoId='" + infoId + '\'' +
                    ", operationButtonInfo=" + operationButtonInfo +
                    ", serviceWindow=" + serviceWindow +
                    ", infoLabels=" + infoLabels +
                    ", video=" + video +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", nowPrice='" + nowPrice + '\'' +
                    ", abtest='" + abtest + '\'' +
                    ", infoType='" + infoType + '\'' +
                    ", infoUrl='" + infoUrl + '\'' +
                    ", viewCount='" + viewCount + '\'' +
                    ", infoEditable='" + infoEditable + '\'' +
                    ", pics='" + pics + '\'' +
                    ", zhuanDesc='" + zhuanDesc + '\'' +
                    ", isSupportQuickHint='" + isSupportQuickHint + '\'' +
                    ", remindDays='" + remindDays + '\'' +
                    ", collectCount='" + collectCount + '\'' +
                    ", nowPrice_f='" + nowPrice_f + '\'' +
                    ", canZhuan='" + canZhuan + '\'' +
                    ", commentCount='" + commentCount + '\'' +
                    ", oriPrice='" + oriPrice + '\'' +
                    ", oriPrice_f='" + oriPrice_f + '\'' +
                    ", metric='" + metric + '\'' +
                    ", cateId='" + cateId + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }

        public OperationButtonInfoEntity getOperationButtonInfo() {
            return operationButtonInfo;
        }

        public ServiceWindowEntity getServiceWindow() {
            return serviceWindow;
        }

        public List<?> getInfoLabels() {
            return infoLabels;
        }

        public VideoEntity getVideo() {
            return video;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getNowPrice() {
            return nowPrice;
        }

        public String getAbtest() {
            return abtest;
        }

        public String getInfoType() {
            return infoType;
        }

        public String getInfoUrl() {
            return infoUrl;
        }

        public String getViewCount() {
            return viewCount;
        }

        public String getInfoEditable() {
            return infoEditable;
        }

        public String getPics() {
            return pics;
        }

        public String getZhuanDesc() {
            return zhuanDesc;
        }

        public String getIsSupportQuickHint() {
            return isSupportQuickHint;
        }

        public String getRemindDays() {
            return remindDays;
        }

        public String getCollectCount() {
            return collectCount;
        }

        public String getNowPrice_f() {
            return nowPrice_f;
        }

        public String getCanZhuan() {
            return canZhuan;
        }

        public String getCommentCount() {
            return commentCount;
        }

        public String getOriPrice() {
            return oriPrice;
        }

        public String getOriPrice_f() {
            return oriPrice_f;
        }

        public String getMetric() {
            return metric;
        }

        public String getCateId() {
            return cateId;
        }

        public String getStatus() {
            return status;
        }

        public class OperationButtonInfoEntity {
            /**
             * operate : jump
             * businessType : 0
             * jumpUrl : https://m.zhuanzhuan.com/biz/zzmflow/index.html?bizResourceId=biz_10004
             * desc : 开启加速
             */
            private String operate;
            private String businessType;
            private String jumpUrl;
            private String desc;

            public void setOperate(String operate) {
                this.operate = operate;
            }

            public void setBusinessType(String businessType) {
                this.businessType = businessType;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getOperate() {
                return operate;
            }

            public String getBusinessType() {
                return businessType;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public String getDesc() {
                return desc;
            }
        }

        public class ServiceWindowEntity {
            /**
             * style : 2
             * iconUrl : http://pic1.zhuanstatic.com/zhuanzh/n_v29b2af63ea2dc4b55a94be3fb6e8ef835.png
             * title : 快卖小技巧：
             * content : 宝贝图片大于3张能卖更快～快点击「编辑」去添加吧
             */
            private String style;
            private String iconUrl;
            private String title;
            private String content;

            public void setStyle(String style) {
                this.style = style;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getStyle() {
                return style;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }
        }

        public class VideoEntity {
            /**
             * picUrl :
             */
            private String picUrl;

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getPicUrl() {
                return picUrl;
            }
        }
    }
}
