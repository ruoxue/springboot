package com.wowotou.payservice.bean.zhuanzhuan;

import java.io.Serializable;
import java.util.List;

public class ZhuanOrderModel implements Serializable {


    /**
     * respData : {"infoId":"1196055358674796562","infoTitle":"苹果手机 可以玩消消乐  请走转转担保交易，喜欢的话就赶快联系我吧。","statusInfo":"拍下成功，待支付","orderId":"1196402494755973215","payTime":"899933","userPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK0T6vLiaoYeh2z5mbia2DNU3IvwxIedYeLiasVo6GeKjP7F6iavrBrK1QBND79WJGWHxWjUPiacH9ny2g/132","actualPayMoneyDesc":"应付款","bannerInfo":{"bannerType":"1","dataBanner":{"imgUrl":"https://pic2.zhuanstatic.com/zhuanzh/n_v2864dd907c2b949f191d93f961b74b5e9.png","mostValuableUrl":"https://pic6.zhuanstatic.com/zhuanzh/n_v25e971922085e437ea6827a2e73ad106f.png","bannerBgUrl":"","sellPhoneBtnText":"立即卖钱","isFillet":"1","btnJumpUrl":"https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq","highestSale":"比回收平均多卖","phoneName":"手机即刻变现","phonePrice":"42%"},"imageBanner":{"jumpUrl":"https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq"}},"platformType":"1","processItems":[{"processStateId":"hasCreate","processStateText":"已拍下"},{"processStateId":"waitPay","processStateText":"待付款"},{"processStateId":"waitSend","processStateText":"待发货"},{"processStateId":"waitReceive","processStateText":"待收货"}],"allFreight":"0","actualPayMoney_f":"500000","payType":"0","btnTextContract":"联系卖家","price":"5000","userNickName":"夏虫不可q49qin78","infoTotalPrice":"5000","canEvaulate":"0","priceStructure":[{"price":"￥5000.00","name":"商品总额"},{"price":"+ ￥0.00","name":"运费"}],"eveluationStatus":"3","orderStructure":"1","picLabels":[],"availableServices":[],"detailInfo":"拍下成功，待买家支付。","payTypeTitle":"收银台（未支付）","packAmount":"0","isBuyer":"1","buyerPayTime":"0","productInfo":[{"price":"￥5000","name":"商品总额"},{"price":"+ ￥0","name":"运费","priceKind":"8"}],"packId":"0","discountInfo":[],"infoCountDesc":"共1件商品","cateId":"2101018","payId":"1196402494755973214","businessLineId":"1301000","status":"1","refund":"0","sumPrice":"5000","operationInfo":[{"arg":{"sheetInfo":{"cancel":"取消","contentList":["订单信息有误","需要卖家修改价格后重新拍下","与卖家价格未协商一致","与卖家邮费未协商一致","联系不到卖家","不想买了","其他原因"]}},"operationId":"cancelOrder","text":"取消订单"},{"arg":{"payInfo":{"nativeMPay":"0","payType":"0","mchId":"1001","payActionType":"1"}},"operationId":"getPay","text":"确认支付"}],"addressHidden":"0","freight":"0","refundStatus":"0","ifEveluation":"1","infoDescription":"","latestOpTime":"1574079557584","middleOperationList":[{"arg":{"uid":"114221879899917952"},"operationId":"contactServicer","text":"联系卖家"}],"cateParentId":"101","actualPayMoney":"5000","logisticsCompany":"","statusInfo1":"<font color=\"#f48260\">请您支付<\/font>","jumpOrderDetail":"zhuanzhuan://jump/core/orderDetail/jump?orderId=1196402494755973215","isGoodPhone":"0","deliverTime":"0","orderSource":"0","address":"{\"mobile\":\"15657171691\",\"city\":\"杭州市 西湖区\",\"detail\":\"益乐新村区\",\"name\":\"李小\",\"province\":\"浙江省\"}","leftOperationList":[{"arg":{"uid":"114221879899917952"},"operationId":"contactServicer","text":"联系卖家"}],"detailInfo1":"后未支付，订单将自动关闭。","ArbitrationStatue":"0","userTel":"156****1691","isFinish":"0","userId":"114221879899917952","orderUnDelMsg":"订单尚未结束，不支持删除哦","infoPics":"n_v2c3048cb33ff34fdfafdd745e509ea0c8.jpg","btnTextLeft":"取消订单","isFullRefund":"1","oriPrice":"0","statusDescription":"待您支付","createTime":"1574079557584","metric":"7NWm88fl27dwZpP2zm8pGwf11171svm","infoList":[{"infoId":"1196055358674796562","buyNum":"1","canNotApplyRefund":"0","title":"苹果手机 可以玩消消乐","content":" 请走转转担保交易，喜欢的话就赶快联系我吧。","operationList":[],"isClipping":"0","metric":"7NWm88fl27dwZpP2zm8pGwf11171svm","labelPosition":{"infoIdLabels":["1185095687549747211","1185105759193530379"],"infoIdLableEntitys":[{"styleHight":"28","styleWidth":"88","labelID":"201910181524001","positionID":"20019","labelShowID":"1185095687549747211","isDelete":"0","updateTime":"1572092755515","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v25c0d909240034427b0a47b5514b8a7cb.png"},{"styleHight":"28","styleWidth":"88","labelID":"201910181607001","positionID":"20019","labelShowID":"1185105759193530379","isDelete":"0","updateTime":"1572087768519","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v242bdf011950e446eaa4937d04e3f68f7.png"}]},"price":"5000.00","productSpuDesc":"","childOrderId":"1196402494755973215","pics":"n_v2c3048cb33ff34fdfafdd745e509ea0c8.jpg"}],"orderCategory":"0","btnTextRight":"安心支付","userLink":"zhuanzhuan://jump/core/personHome/jump?uid=114221879899917952"}
     * respCode : 0
     */
    private RespDataEntity respData;
    private String respCode;


    @Override
    public String toString() {
        return "ZhuanOrderModel{" +
                "respData=" + respData +
                ", respCode='" + respCode + '\'' +
                '}';
    }

    public void setRespData(RespDataEntity respData) {
        this.respData = respData;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public RespDataEntity getRespData() {
        return respData;
    }

    public String getRespCode() {
        return respCode;
    }

    public class RespDataEntity {
        @Override
        public String toString() {
            return "RespDataEntity{" +
                    "infoId='" + infoId + '\'' +
                    ", infoTitle='" + infoTitle + '\'' +
                    ", statusInfo='" + statusInfo + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", payTime='" + payTime + '\'' +
                    ", userPic='" + userPic + '\'' +
                    ", actualPayMoneyDesc='" + actualPayMoneyDesc + '\'' +
                    ", bannerInfo=" + bannerInfo +
                    ", platformType='" + platformType + '\'' +
                    ", processItems=" + processItems +
                    ", allFreight='" + allFreight + '\'' +
                    ", actualPayMoney_f='" + actualPayMoney_f + '\'' +
                    ", payType='" + payType + '\'' +
                    ", btnTextContract='" + btnTextContract + '\'' +
                    ", price='" + price + '\'' +
                    ", userNickName='" + userNickName + '\'' +
                    ", infoTotalPrice='" + infoTotalPrice + '\'' +
                    ", canEvaulate='" + canEvaulate + '\'' +
                    ", priceStructure=" + priceStructure +
                    ", eveluationStatus='" + eveluationStatus + '\'' +
                    ", orderStructure='" + orderStructure + '\'' +
                    ", picLabels=" + picLabels +
                    ", availableServices=" + availableServices +
                    ", detailInfo='" + detailInfo + '\'' +
                    ", payTypeTitle='" + payTypeTitle + '\'' +
                    ", packAmount='" + packAmount + '\'' +
                    ", isBuyer='" + isBuyer + '\'' +
                    ", buyerPayTime='" + buyerPayTime + '\'' +
                    ", productInfo=" + productInfo +
                    ", packId='" + packId + '\'' +
                    ", discountInfo=" + discountInfo +
                    ", infoCountDesc='" + infoCountDesc + '\'' +
                    ", cateId='" + cateId + '\'' +
                    ", payId='" + payId + '\'' +
                    ", businessLineId='" + businessLineId + '\'' +
                    ", status='" + status + '\'' +
                    ", refund='" + refund + '\'' +
                    ", sumPrice='" + sumPrice + '\'' +
                    ", operationInfo=" + operationInfo +
                    ", addressHidden='" + addressHidden + '\'' +
                    ", freight='" + freight + '\'' +
                    ", refundStatus='" + refundStatus + '\'' +
                    ", ifEveluation='" + ifEveluation + '\'' +
                    ", infoDescription='" + infoDescription + '\'' +
                    ", latestOpTime='" + latestOpTime + '\'' +
                    ", middleOperationList=" + middleOperationList +
                    ", cateParentId='" + cateParentId + '\'' +
                    ", actualPayMoney='" + actualPayMoney + '\'' +
                    ", logisticsCompany='" + logisticsCompany + '\'' +
                    ", statusInfo1='" + statusInfo1 + '\'' +
                    ", jumpOrderDetail='" + jumpOrderDetail + '\'' +
                    ", isGoodPhone='" + isGoodPhone + '\'' +
                    ", deliverTime='" + deliverTime + '\'' +
                    ", orderSource='" + orderSource + '\'' +
                    ", address='" + address + '\'' +
                    ", leftOperationList=" + leftOperationList +
                    ", detailInfo1='" + detailInfo1 + '\'' +
                    ", ArbitrationStatue='" + ArbitrationStatue + '\'' +
                    ", userTel='" + userTel + '\'' +
                    ", isFinish='" + isFinish + '\'' +
                    ", userId='" + userId + '\'' +
                    ", orderUnDelMsg='" + orderUnDelMsg + '\'' +
                    ", infoPics='" + infoPics + '\'' +
                    ", btnTextLeft='" + btnTextLeft + '\'' +
                    ", isFullRefund='" + isFullRefund + '\'' +
                    ", oriPrice='" + oriPrice + '\'' +
                    ", statusDescription='" + statusDescription + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", metric='" + metric + '\'' +
                    ", infoList=" + infoList +
                    ", orderCategory='" + orderCategory + '\'' +
                    ", btnTextRight='" + btnTextRight + '\'' +
                    ", userLink='" + userLink + '\'' +
                    '}';
        }

        /**
         * infoId : 1196055358674796562
         * infoTitle : 苹果手机 可以玩消消乐  请走转转担保交易，喜欢的话就赶快联系我吧。
         * statusInfo : 拍下成功，待支付
         * orderId : 1196402494755973215
         * payTime : 899933
         * userPic : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK0T6vLiaoYeh2z5mbia2DNU3IvwxIedYeLiasVo6GeKjP7F6iavrBrK1QBND79WJGWHxWjUPiacH9ny2g/132
         * actualPayMoneyDesc : 应付款
         * bannerInfo : {"bannerType":"1","dataBanner":{"imgUrl":"https://pic2.zhuanstatic.com/zhuanzh/n_v2864dd907c2b949f191d93f961b74b5e9.png","mostValuableUrl":"https://pic6.zhuanstatic.com/zhuanzh/n_v25e971922085e437ea6827a2e73ad106f.png","bannerBgUrl":"","sellPhoneBtnText":"立即卖钱","isFillet":"1","btnJumpUrl":"https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq","highestSale":"比回收平均多卖","phoneName":"手机即刻变现","phonePrice":"42%"},"imageBanner":{"jumpUrl":"https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq"}}
         * platformType : 1
         * processItems : [{"processStateId":"hasCreate","processStateText":"已拍下"},{"processStateId":"waitPay","processStateText":"待付款"},{"processStateId":"waitSend","processStateText":"待发货"},{"processStateId":"waitReceive","processStateText":"待收货"}]
         * allFreight : 0
         * actualPayMoney_f : 500000
         * payType : 0
         * btnTextContract : 联系卖家
         * price : 5000
         * userNickName : 夏虫不可q49qin78
         * infoTotalPrice : 5000
         * canEvaulate : 0
         * priceStructure : [{"price":"￥5000.00","name":"商品总额"},{"price":"+ ￥0.00","name":"运费"}]
         * eveluationStatus : 3
         * orderStructure : 1
         * picLabels : []
         * availableServices : []
         * detailInfo : 拍下成功，待买家支付。
         * payTypeTitle : 收银台（未支付）
         * packAmount : 0
         * isBuyer : 1
         * buyerPayTime : 0
         * productInfo : [{"price":"￥5000","name":"商品总额"},{"price":"+ ￥0","name":"运费","priceKind":"8"}]
         * packId : 0
         * discountInfo : []
         * infoCountDesc : 共1件商品
         * cateId : 2101018
         * payId : 1196402494755973214
         * businessLineId : 1301000
         * status : 1
         * refund : 0
         * sumPrice : 5000
         * operationInfo : [{"arg":{"sheetInfo":{"cancel":"取消","contentList":["订单信息有误","需要卖家修改价格后重新拍下","与卖家价格未协商一致","与卖家邮费未协商一致","联系不到卖家","不想买了","其他原因"]}},"operationId":"cancelOrder","text":"取消订单"},{"arg":{"payInfo":{"nativeMPay":"0","payType":"0","mchId":"1001","payActionType":"1"}},"operationId":"getPay","text":"确认支付"}]
         * addressHidden : 0
         * freight : 0
         * refundStatus : 0
         * ifEveluation : 1
         * infoDescription :
         * latestOpTime : 1574079557584
         * middleOperationList : [{"arg":{"uid":"114221879899917952"},"operationId":"contactServicer","text":"联系卖家"}]
         * cateParentId : 101
         * actualPayMoney : 5000
         * logisticsCompany :
         * statusInfo1 : <font color="#f48260">请您支付</font>
         * jumpOrderDetail : zhuanzhuan://jump/core/orderDetail/jump?orderId=1196402494755973215
         * isGoodPhone : 0
         * deliverTime : 0
         * orderSource : 0
         * address : {"mobile":"15657171691","city":"杭州市 西湖区","detail":"益乐新村区","name":"李小","province":"浙江省"}
         * leftOperationList : [{"arg":{"uid":"114221879899917952"},"operationId":"contactServicer","text":"联系卖家"}]
         * detailInfo1 : 后未支付，订单将自动关闭。
         * ArbitrationStatue : 0
         * userTel : 156****1691
         * isFinish : 0
         * userId : 114221879899917952
         * orderUnDelMsg : 订单尚未结束，不支持删除哦
         * infoPics : n_v2c3048cb33ff34fdfafdd745e509ea0c8.jpg
         * btnTextLeft : 取消订单
         * isFullRefund : 1
         * oriPrice : 0
         * statusDescription : 待您支付
         * createTime : 1574079557584
         * metric : 7NWm88fl27dwZpP2zm8pGwf11171svm
         * infoList : [{"infoId":"1196055358674796562","buyNum":"1","canNotApplyRefund":"0","title":"苹果手机 可以玩消消乐","content":" 请走转转担保交易，喜欢的话就赶快联系我吧。","operationList":[],"isClipping":"0","metric":"7NWm88fl27dwZpP2zm8pGwf11171svm","labelPosition":{"infoIdLabels":["1185095687549747211","1185105759193530379"],"infoIdLableEntitys":[{"styleHight":"28","styleWidth":"88","labelID":"201910181524001","positionID":"20019","labelShowID":"1185095687549747211","isDelete":"0","updateTime":"1572092755515","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v25c0d909240034427b0a47b5514b8a7cb.png"},{"styleHight":"28","styleWidth":"88","labelID":"201910181607001","positionID":"20019","labelShowID":"1185105759193530379","isDelete":"0","updateTime":"1572087768519","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v242bdf011950e446eaa4937d04e3f68f7.png"}]},"price":"5000.00","productSpuDesc":"","childOrderId":"1196402494755973215","pics":"n_v2c3048cb33ff34fdfafdd745e509ea0c8.jpg"}]
         * orderCategory : 0
         * btnTextRight : 安心支付
         * userLink : zhuanzhuan://jump/core/personHome/jump?uid=114221879899917952
         */
        private String infoId;
        private String infoTitle;
        private String statusInfo;
        private String orderId;
        private String payTime;
        private String userPic;
        private String actualPayMoneyDesc;
        private BannerInfoEntity bannerInfo;
        private String platformType;
        private List<ProcessItemsEntity> processItems;
        private String allFreight;
        private String actualPayMoney_f;
        private String payType;
        private String btnTextContract;
        private String price;
        private String userNickName;
        private String infoTotalPrice;
        private String canEvaulate;
        private List<PriceStructureEntity> priceStructure;
        private String eveluationStatus;
        private String orderStructure;
        private List<?> picLabels;
        private List<?> availableServices;
        private String detailInfo;
        private String payTypeTitle;
        private String packAmount;
        private String isBuyer;
        private String buyerPayTime;
        private List<ProductInfoEntity> productInfo;
        private String packId;
        private List<?> discountInfo;
        private String infoCountDesc;
        private String cateId;
        private String payId;
        private String businessLineId;
        private String status;
        private String refund;
        private String sumPrice;
        private List<OperationInfoEntity> operationInfo;
        private String addressHidden;
        private String freight;
        private String refundStatus;
        private String ifEveluation;
        private String infoDescription;
        private String latestOpTime;
        private List<MiddleOperationListEntity> middleOperationList;
        private String cateParentId;
        private String actualPayMoney;
        private String logisticsCompany;
        private String statusInfo1;
        private String jumpOrderDetail;
        private String isGoodPhone;
        private String deliverTime;
        private String orderSource;
        private String address;
        private List<LeftOperationListEntity> leftOperationList;
        private String detailInfo1;
        private String ArbitrationStatue;
        private String userTel;
        private String isFinish;
        private String userId;
        private String orderUnDelMsg;
        private String infoPics;
        private String btnTextLeft;
        private String isFullRefund;
        private String oriPrice;
        private String statusDescription;
        private String createTime;
        private String metric;
        private List<InfoListEntity> infoList;
        private String orderCategory;
        private String btnTextRight;
        private String userLink;

        public void setInfoId(String infoId) {
            this.infoId = infoId;
        }

        public void setInfoTitle(String infoTitle) {
            this.infoTitle = infoTitle;
        }

        public void setStatusInfo(String statusInfo) {
            this.statusInfo = statusInfo;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public void setPayTime(String payTime) {
            this.payTime = payTime;
        }

        public void setUserPic(String userPic) {
            this.userPic = userPic;
        }

        public void setActualPayMoneyDesc(String actualPayMoneyDesc) {
            this.actualPayMoneyDesc = actualPayMoneyDesc;
        }

        public void setBannerInfo(BannerInfoEntity bannerInfo) {
            this.bannerInfo = bannerInfo;
        }

        public void setPlatformType(String platformType) {
            this.platformType = platformType;
        }

        public void setProcessItems(List<ProcessItemsEntity> processItems) {
            this.processItems = processItems;
        }

        public void setAllFreight(String allFreight) {
            this.allFreight = allFreight;
        }

        public void setActualPayMoney_f(String actualPayMoney_f) {
            this.actualPayMoney_f = actualPayMoney_f;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public void setBtnTextContract(String btnTextContract) {
            this.btnTextContract = btnTextContract;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setUserNickName(String userNickName) {
            this.userNickName = userNickName;
        }

        public void setInfoTotalPrice(String infoTotalPrice) {
            this.infoTotalPrice = infoTotalPrice;
        }

        public void setCanEvaulate(String canEvaulate) {
            this.canEvaulate = canEvaulate;
        }

        public void setPriceStructure(List<PriceStructureEntity> priceStructure) {
            this.priceStructure = priceStructure;
        }

        public void setEveluationStatus(String eveluationStatus) {
            this.eveluationStatus = eveluationStatus;
        }

        public void setOrderStructure(String orderStructure) {
            this.orderStructure = orderStructure;
        }

        public void setPicLabels(List<?> picLabels) {
            this.picLabels = picLabels;
        }

        public void setAvailableServices(List<?> availableServices) {
            this.availableServices = availableServices;
        }

        public void setDetailInfo(String detailInfo) {
            this.detailInfo = detailInfo;
        }

        public void setPayTypeTitle(String payTypeTitle) {
            this.payTypeTitle = payTypeTitle;
        }

        public void setPackAmount(String packAmount) {
            this.packAmount = packAmount;
        }

        public void setIsBuyer(String isBuyer) {
            this.isBuyer = isBuyer;
        }

        public void setBuyerPayTime(String buyerPayTime) {
            this.buyerPayTime = buyerPayTime;
        }

        public void setProductInfo(List<ProductInfoEntity> productInfo) {
            this.productInfo = productInfo;
        }

        public void setPackId(String packId) {
            this.packId = packId;
        }

        public void setDiscountInfo(List<?> discountInfo) {
            this.discountInfo = discountInfo;
        }

        public void setInfoCountDesc(String infoCountDesc) {
            this.infoCountDesc = infoCountDesc;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public void setPayId(String payId) {
            this.payId = payId;
        }

        public void setBusinessLineId(String businessLineId) {
            this.businessLineId = businessLineId;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setRefund(String refund) {
            this.refund = refund;
        }

        public void setSumPrice(String sumPrice) {
            this.sumPrice = sumPrice;
        }

        public void setOperationInfo(List<OperationInfoEntity> operationInfo) {
            this.operationInfo = operationInfo;
        }

        public void setAddressHidden(String addressHidden) {
            this.addressHidden = addressHidden;
        }

        public void setFreight(String freight) {
            this.freight = freight;
        }

        public void setRefundStatus(String refundStatus) {
            this.refundStatus = refundStatus;
        }

        public void setIfEveluation(String ifEveluation) {
            this.ifEveluation = ifEveluation;
        }

        public void setInfoDescription(String infoDescription) {
            this.infoDescription = infoDescription;
        }

        public void setLatestOpTime(String latestOpTime) {
            this.latestOpTime = latestOpTime;
        }

        public void setMiddleOperationList(List<MiddleOperationListEntity> middleOperationList) {
            this.middleOperationList = middleOperationList;
        }

        public void setCateParentId(String cateParentId) {
            this.cateParentId = cateParentId;
        }

        public void setActualPayMoney(String actualPayMoney) {
            this.actualPayMoney = actualPayMoney;
        }

        public void setLogisticsCompany(String logisticsCompany) {
            this.logisticsCompany = logisticsCompany;
        }

        public void setStatusInfo1(String statusInfo1) {
            this.statusInfo1 = statusInfo1;
        }

        public void setJumpOrderDetail(String jumpOrderDetail) {
            this.jumpOrderDetail = jumpOrderDetail;
        }

        public void setIsGoodPhone(String isGoodPhone) {
            this.isGoodPhone = isGoodPhone;
        }

        public void setDeliverTime(String deliverTime) {
            this.deliverTime = deliverTime;
        }

        public void setOrderSource(String orderSource) {
            this.orderSource = orderSource;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setLeftOperationList(List<LeftOperationListEntity> leftOperationList) {
            this.leftOperationList = leftOperationList;
        }

        public void setDetailInfo1(String detailInfo1) {
            this.detailInfo1 = detailInfo1;
        }

        public void setArbitrationStatue(String ArbitrationStatue) {
            this.ArbitrationStatue = ArbitrationStatue;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public void setIsFinish(String isFinish) {
            this.isFinish = isFinish;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setOrderUnDelMsg(String orderUnDelMsg) {
            this.orderUnDelMsg = orderUnDelMsg;
        }

        public void setInfoPics(String infoPics) {
            this.infoPics = infoPics;
        }

        public void setBtnTextLeft(String btnTextLeft) {
            this.btnTextLeft = btnTextLeft;
        }

        public void setIsFullRefund(String isFullRefund) {
            this.isFullRefund = isFullRefund;
        }

        public void setOriPrice(String oriPrice) {
            this.oriPrice = oriPrice;
        }

        public void setStatusDescription(String statusDescription) {
            this.statusDescription = statusDescription;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public void setInfoList(List<InfoListEntity> infoList) {
            this.infoList = infoList;
        }

        public void setOrderCategory(String orderCategory) {
            this.orderCategory = orderCategory;
        }

        public void setBtnTextRight(String btnTextRight) {
            this.btnTextRight = btnTextRight;
        }

        public void setUserLink(String userLink) {
            this.userLink = userLink;
        }

        public String getInfoId() {
            return infoId;
        }

        public String getInfoTitle() {
            return infoTitle;
        }

        public String getStatusInfo() {
            return statusInfo;
        }

        public String getOrderId() {
            return orderId;
        }

        public String getPayTime() {
            return payTime;
        }

        public String getUserPic() {
            return userPic;
        }

        public String getActualPayMoneyDesc() {
            return actualPayMoneyDesc;
        }

        public BannerInfoEntity getBannerInfo() {
            return bannerInfo;
        }

        public String getPlatformType() {
            return platformType;
        }

        public List<ProcessItemsEntity> getProcessItems() {
            return processItems;
        }

        public String getAllFreight() {
            return allFreight;
        }

        public String getActualPayMoney_f() {
            return actualPayMoney_f;
        }

        public String getPayType() {
            return payType;
        }

        public String getBtnTextContract() {
            return btnTextContract;
        }

        public String getPrice() {
            return price;
        }

        public String getUserNickName() {
            return userNickName;
        }

        public String getInfoTotalPrice() {
            return infoTotalPrice;
        }

        public String getCanEvaulate() {
            return canEvaulate;
        }

        public List<PriceStructureEntity> getPriceStructure() {
            return priceStructure;
        }

        public String getEveluationStatus() {
            return eveluationStatus;
        }

        public String getOrderStructure() {
            return orderStructure;
        }

        public List<?> getPicLabels() {
            return picLabels;
        }

        public List<?> getAvailableServices() {
            return availableServices;
        }

        public String getDetailInfo() {
            return detailInfo;
        }

        public String getPayTypeTitle() {
            return payTypeTitle;
        }

        public String getPackAmount() {
            return packAmount;
        }

        public String getIsBuyer() {
            return isBuyer;
        }

        public String getBuyerPayTime() {
            return buyerPayTime;
        }

        public List<ProductInfoEntity> getProductInfo() {
            return productInfo;
        }

        public String getPackId() {
            return packId;
        }

        public List<?> getDiscountInfo() {
            return discountInfo;
        }

        public String getInfoCountDesc() {
            return infoCountDesc;
        }

        public String getCateId() {
            return cateId;
        }

        public String getPayId() {
            return payId;
        }

        public String getBusinessLineId() {
            return businessLineId;
        }

        public String getStatus() {
            return status;
        }

        public String getRefund() {
            return refund;
        }

        public String getSumPrice() {
            return sumPrice;
        }

        public List<OperationInfoEntity> getOperationInfo() {
            return operationInfo;
        }

        public String getAddressHidden() {
            return addressHidden;
        }

        public String getFreight() {
            return freight;
        }

        public String getRefundStatus() {
            return refundStatus;
        }

        public String getIfEveluation() {
            return ifEveluation;
        }

        public String getInfoDescription() {
            return infoDescription;
        }

        public String getLatestOpTime() {
            return latestOpTime;
        }

        public List<MiddleOperationListEntity> getMiddleOperationList() {
            return middleOperationList;
        }

        public String getCateParentId() {
            return cateParentId;
        }

        public String getActualPayMoney() {
            return actualPayMoney;
        }

        public String getLogisticsCompany() {
            return logisticsCompany;
        }

        public String getStatusInfo1() {
            return statusInfo1;
        }

        public String getJumpOrderDetail() {
            return jumpOrderDetail;
        }

        public String getIsGoodPhone() {
            return isGoodPhone;
        }

        public String getDeliverTime() {
            return deliverTime;
        }

        public String getOrderSource() {
            return orderSource;
        }

        public String getAddress() {
            return address;
        }

        public List<LeftOperationListEntity> getLeftOperationList() {
            return leftOperationList;
        }

        public String getDetailInfo1() {
            return detailInfo1;
        }

        public String getArbitrationStatue() {
            return ArbitrationStatue;
        }

        public String getUserTel() {
            return userTel;
        }

        public String getIsFinish() {
            return isFinish;
        }

        public String getUserId() {
            return userId;
        }

        public String getOrderUnDelMsg() {
            return orderUnDelMsg;
        }

        public String getInfoPics() {
            return infoPics;
        }

        public String getBtnTextLeft() {
            return btnTextLeft;
        }

        public String getIsFullRefund() {
            return isFullRefund;
        }

        public String getOriPrice() {
            return oriPrice;
        }

        public String getStatusDescription() {
            return statusDescription;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getMetric() {
            return metric;
        }

        public List<InfoListEntity> getInfoList() {
            return infoList;
        }

        public String getOrderCategory() {
            return orderCategory;
        }

        public String getBtnTextRight() {
            return btnTextRight;
        }

        public String getUserLink() {
            return userLink;
        }

        public class BannerInfoEntity {
            /**
             * bannerType : 1
             * dataBanner : {"imgUrl":"https://pic2.zhuanstatic.com/zhuanzh/n_v2864dd907c2b949f191d93f961b74b5e9.png","mostValuableUrl":"https://pic6.zhuanstatic.com/zhuanzh/n_v25e971922085e437ea6827a2e73ad106f.png","bannerBgUrl":"","sellPhoneBtnText":"立即卖钱","isFillet":"1","btnJumpUrl":"https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq","highestSale":"比回收平均多卖","phoneName":"手机即刻变现","phonePrice":"42%"}
             * imageBanner : {"jumpUrl":"https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq"}
             */
            private String bannerType;
            private DataBannerEntity dataBanner;
            private ImageBannerEntity imageBanner;

            public void setBannerType(String bannerType) {
                this.bannerType = bannerType;
            }

            public void setDataBanner(DataBannerEntity dataBanner) {
                this.dataBanner = dataBanner;
            }

            public void setImageBanner(ImageBannerEntity imageBanner) {
                this.imageBanner = imageBanner;
            }

            public String getBannerType() {
                return bannerType;
            }

            public DataBannerEntity getDataBanner() {
                return dataBanner;
            }

            public ImageBannerEntity getImageBanner() {
                return imageBanner;
            }

            public class DataBannerEntity {
                /**
                 * imgUrl : https://pic2.zhuanstatic.com/zhuanzh/n_v2864dd907c2b949f191d93f961b74b5e9.png
                 * mostValuableUrl : https://pic6.zhuanstatic.com/zhuanzh/n_v25e971922085e437ea6827a2e73ad106f.png
                 * bannerBgUrl :
                 * sellPhoneBtnText : 立即卖钱
                 * isFillet : 1
                 * btnJumpUrl : https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq
                 * highestSale : 比回收平均多卖
                 * phoneName : 手机即刻变现
                 * phonePrice : 42%
                 */
                private String imgUrl;
                private String mostValuableUrl;
                private String bannerBgUrl;
                private String sellPhoneBtnText;
                private String isFillet;
                private String btnJumpUrl;
                private String highestSale;
                private String phoneName;
                private String phonePrice;

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public void setMostValuableUrl(String mostValuableUrl) {
                    this.mostValuableUrl = mostValuableUrl;
                }

                public void setBannerBgUrl(String bannerBgUrl) {
                    this.bannerBgUrl = bannerBgUrl;
                }

                public void setSellPhoneBtnText(String sellPhoneBtnText) {
                    this.sellPhoneBtnText = sellPhoneBtnText;
                }

                public void setIsFillet(String isFillet) {
                    this.isFillet = isFillet;
                }

                public void setBtnJumpUrl(String btnJumpUrl) {
                    this.btnJumpUrl = btnJumpUrl;
                }

                public void setHighestSale(String highestSale) {
                    this.highestSale = highestSale;
                }

                public void setPhoneName(String phoneName) {
                    this.phoneName = phoneName;
                }

                public void setPhonePrice(String phonePrice) {
                    this.phonePrice = phonePrice;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public String getMostValuableUrl() {
                    return mostValuableUrl;
                }

                public String getBannerBgUrl() {
                    return bannerBgUrl;
                }

                public String getSellPhoneBtnText() {
                    return sellPhoneBtnText;
                }

                public String getIsFillet() {
                    return isFillet;
                }

                public String getBtnJumpUrl() {
                    return btnJumpUrl;
                }

                public String getHighestSale() {
                    return highestSale;
                }

                public String getPhoneName() {
                    return phoneName;
                }

                public String getPhonePrice() {
                    return phonePrice;
                }
            }

            public class ImageBannerEntity {
                /**
                 * jumpUrl : https://m.zhuanzhuan.com/u/bmmain/helpsale/correlate?xinghaoId=2101018012&cateId=101&showProgress=true&channel=2012&smark=appddxq
                 */
                private String jumpUrl;

                public void setJumpUrl(String jumpUrl) {
                    this.jumpUrl = jumpUrl;
                }

                public String getJumpUrl() {
                    return jumpUrl;
                }
            }
        }

        public class ProcessItemsEntity {
            /**
             * processStateId : hasCreate
             * processStateText : 已拍下
             */
            private String processStateId;
            private String processStateText;

            public void setProcessStateId(String processStateId) {
                this.processStateId = processStateId;
            }

            public void setProcessStateText(String processStateText) {
                this.processStateText = processStateText;
            }

            public String getProcessStateId() {
                return processStateId;
            }

            public String getProcessStateText() {
                return processStateText;
            }
        }

        public class PriceStructureEntity {
            /**
             * price : ￥5000.00
             * name : 商品总额
             */
            private String price;
            private String name;

            public void setPrice(String price) {
                this.price = price;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public String getName() {
                return name;
            }
        }

        public class ProductInfoEntity {
            /**
             * price : ￥5000
             * name : 商品总额
             */
            private String price;
            private String name;

            public void setPrice(String price) {
                this.price = price;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public String getName() {
                return name;
            }
        }

        public class OperationInfoEntity {
            /**
             * arg : {"sheetInfo":{"cancel":"取消","contentList":["订单信息有误","需要卖家修改价格后重新拍下","与卖家价格未协商一致","与卖家邮费未协商一致","联系不到卖家","不想买了","其他原因"]}}
             * operationId : cancelOrder
             * text : 取消订单
             */
            private ArgEntity arg;
            private String operationId;
            private String text;

            public void setArg(ArgEntity arg) {
                this.arg = arg;
            }

            public void setOperationId(String operationId) {
                this.operationId = operationId;
            }

            public void setText(String text) {
                this.text = text;
            }

            public ArgEntity getArg() {
                return arg;
            }

            public String getOperationId() {
                return operationId;
            }

            public String getText() {
                return text;
            }

            public class ArgEntity {
                /**
                 * sheetInfo : {"cancel":"取消","contentList":["订单信息有误","需要卖家修改价格后重新拍下","与卖家价格未协商一致","与卖家邮费未协商一致","联系不到卖家","不想买了","其他原因"]}
                 */
                private SheetInfoEntity sheetInfo;

                public void setSheetInfo(SheetInfoEntity sheetInfo) {
                    this.sheetInfo = sheetInfo;
                }

                public SheetInfoEntity getSheetInfo() {
                    return sheetInfo;
                }

                public class SheetInfoEntity {
                    /**
                     * cancel : 取消
                     * contentList : ["订单信息有误","需要卖家修改价格后重新拍下","与卖家价格未协商一致","与卖家邮费未协商一致","联系不到卖家","不想买了","其他原因"]
                     */
                    private String cancel;
                    private List<String> contentList;

                    public void setCancel(String cancel) {
                        this.cancel = cancel;
                    }

                    public void setContentList(List<String> contentList) {
                        this.contentList = contentList;
                    }

                    public String getCancel() {
                        return cancel;
                    }

                    public List<String> getContentList() {
                        return contentList;
                    }
                }
            }
        }

        public class MiddleOperationListEntity {
            /**
             * arg : {"uid":"114221879899917952"}
             * operationId : contactServicer
             * text : 联系卖家
             */
            private ArgEntity arg;
            private String operationId;
            private String text;

            public void setArg(ArgEntity arg) {
                this.arg = arg;
            }

            public void setOperationId(String operationId) {
                this.operationId = operationId;
            }

            public void setText(String text) {
                this.text = text;
            }

            public ArgEntity getArg() {
                return arg;
            }

            public String getOperationId() {
                return operationId;
            }

            public String getText() {
                return text;
            }

            public class ArgEntity {
                /**
                 * uid : 114221879899917952
                 */
                private String uid;

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public String getUid() {
                    return uid;
                }
            }
        }

        public class LeftOperationListEntity {
            /**
             * arg : {"uid":"114221879899917952"}
             * operationId : contactServicer
             * text : 联系卖家
             */
            private ArgEntity arg;
            private String operationId;
            private String text;

            public void setArg(ArgEntity arg) {
                this.arg = arg;
            }

            public void setOperationId(String operationId) {
                this.operationId = operationId;
            }

            public void setText(String text) {
                this.text = text;
            }

            public ArgEntity getArg() {
                return arg;
            }

            public String getOperationId() {
                return operationId;
            }

            public String getText() {
                return text;
            }

            public class ArgEntity {
                /**
                 * uid : 114221879899917952
                 */
                private String uid;

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public String getUid() {
                    return uid;
                }
            }
        }

        public class InfoListEntity {
            /**
             * infoId : 1196055358674796562
             * buyNum : 1
             * canNotApplyRefund : 0
             * title : 苹果手机 可以玩消消乐
             * content :  请走转转担保交易，喜欢的话就赶快联系我吧。
             * operationList : []
             * isClipping : 0
             * metric : 7NWm88fl27dwZpP2zm8pGwf11171svm
             * labelPosition : {"infoIdLabels":["1185095687549747211","1185105759193530379"],"infoIdLableEntitys":[{"styleHight":"28","styleWidth":"88","labelID":"201910181524001","positionID":"20019","labelShowID":"1185095687549747211","isDelete":"0","updateTime":"1572092755515","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v25c0d909240034427b0a47b5514b8a7cb.png"},{"styleHight":"28","styleWidth":"88","labelID":"201910181607001","positionID":"20019","labelShowID":"1185105759193530379","isDelete":"0","updateTime":"1572087768519","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v242bdf011950e446eaa4937d04e3f68f7.png"}]}
             * price : 5000.00
             * productSpuDesc :
             * childOrderId : 1196402494755973215
             * pics : n_v2c3048cb33ff34fdfafdd745e509ea0c8.jpg
             */
            private String infoId;
            private String buyNum;
            private String canNotApplyRefund;
            private String title;
            private String content;
            private List<?> operationList;
            private String isClipping;
            private String metric;
            private LabelPositionEntity labelPosition;
            private String price;
            private String productSpuDesc;
            private String childOrderId;
            private String pics;

            public void setInfoId(String infoId) {
                this.infoId = infoId;
            }

            public void setBuyNum(String buyNum) {
                this.buyNum = buyNum;
            }

            public void setCanNotApplyRefund(String canNotApplyRefund) {
                this.canNotApplyRefund = canNotApplyRefund;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setOperationList(List<?> operationList) {
                this.operationList = operationList;
            }

            public void setIsClipping(String isClipping) {
                this.isClipping = isClipping;
            }

            public void setMetric(String metric) {
                this.metric = metric;
            }

            public void setLabelPosition(LabelPositionEntity labelPosition) {
                this.labelPosition = labelPosition;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public void setProductSpuDesc(String productSpuDesc) {
                this.productSpuDesc = productSpuDesc;
            }

            public void setChildOrderId(String childOrderId) {
                this.childOrderId = childOrderId;
            }

            public void setPics(String pics) {
                this.pics = pics;
            }

            public String getInfoId() {
                return infoId;
            }

            public String getBuyNum() {
                return buyNum;
            }

            public String getCanNotApplyRefund() {
                return canNotApplyRefund;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public List<?> getOperationList() {
                return operationList;
            }

            public String getIsClipping() {
                return isClipping;
            }

            public String getMetric() {
                return metric;
            }

            public LabelPositionEntity getLabelPosition() {
                return labelPosition;
            }

            public String getPrice() {
                return price;
            }

            public String getProductSpuDesc() {
                return productSpuDesc;
            }

            public String getChildOrderId() {
                return childOrderId;
            }

            public String getPics() {
                return pics;
            }

            public class LabelPositionEntity {
                /**
                 * infoIdLabels : ["1185095687549747211","1185105759193530379"]
                 * infoIdLableEntitys : [{"styleHight":"28","styleWidth":"88","labelID":"201910181524001","positionID":"20019","labelShowID":"1185095687549747211","isDelete":"0","updateTime":"1572092755515","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v25c0d909240034427b0a47b5514b8a7cb.png"},{"styleHight":"28","styleWidth":"88","labelID":"201910181607001","positionID":"20019","labelShowID":"1185105759193530379","isDelete":"0","updateTime":"1572087768519","labelUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v242bdf011950e446eaa4937d04e3f68f7.png"}]
                 */
                private List<String> infoIdLabels;
                private List<InfoIdLableEntitysEntity> infoIdLableEntitys;

                public void setInfoIdLabels(List<String> infoIdLabels) {
                    this.infoIdLabels = infoIdLabels;
                }

                public void setInfoIdLableEntitys(List<InfoIdLableEntitysEntity> infoIdLableEntitys) {
                    this.infoIdLableEntitys = infoIdLableEntitys;
                }

                public List<String> getInfoIdLabels() {
                    return infoIdLabels;
                }

                public List<InfoIdLableEntitysEntity> getInfoIdLableEntitys() {
                    return infoIdLableEntitys;
                }

                public class InfoIdLableEntitysEntity {
                    /**
                     * styleHight : 28
                     * styleWidth : 88
                     * labelID : 201910181524001
                     * positionID : 20019
                     * labelShowID : 1185095687549747211
                     * isDelete : 0
                     * updateTime : 1572092755515
                     * labelUrl : http://pic1.zhuanstatic.com/zhuanzh/n_v25c0d909240034427b0a47b5514b8a7cb.png
                     */
                    private String styleHight;
                    private String styleWidth;
                    private String labelID;
                    private String positionID;
                    private String labelShowID;
                    private String isDelete;
                    private String updateTime;
                    private String labelUrl;

                    public void setStyleHight(String styleHight) {
                        this.styleHight = styleHight;
                    }

                    public void setStyleWidth(String styleWidth) {
                        this.styleWidth = styleWidth;
                    }

                    public void setLabelID(String labelID) {
                        this.labelID = labelID;
                    }

                    public void setPositionID(String positionID) {
                        this.positionID = positionID;
                    }

                    public void setLabelShowID(String labelShowID) {
                        this.labelShowID = labelShowID;
                    }

                    public void setIsDelete(String isDelete) {
                        this.isDelete = isDelete;
                    }

                    public void setUpdateTime(String updateTime) {
                        this.updateTime = updateTime;
                    }

                    public void setLabelUrl(String labelUrl) {
                        this.labelUrl = labelUrl;
                    }

                    public String getStyleHight() {
                        return styleHight;
                    }

                    public String getStyleWidth() {
                        return styleWidth;
                    }

                    public String getLabelID() {
                        return labelID;
                    }

                    public String getPositionID() {
                        return positionID;
                    }

                    public String getLabelShowID() {
                        return labelShowID;
                    }

                    public String getIsDelete() {
                        return isDelete;
                    }

                    public String getUpdateTime() {
                        return updateTime;
                    }

                    public String getLabelUrl() {
                        return labelUrl;
                    }
                }
            }
        }
    }
}
