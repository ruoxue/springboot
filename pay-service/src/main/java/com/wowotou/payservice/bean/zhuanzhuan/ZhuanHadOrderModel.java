package com.wowotou.payservice.bean.zhuanzhuan;

import java.io.Serializable;
import java.util.List;

public class ZhuanHadOrderModel implements Serializable {

    /**
     * respData : {"orderList":[{"infoId":"1197820996566761474","infoTitle":"小米鼠标  请走转转担保交易，喜欢的话就赶快联系我吧。","statusInfo":"支付成功，待发货","orderId":"1197821314527029547","payTime":"0","userPic":"http://img.58cdn.com.cn/zhuanzhuan/defaulth-head-image-bear@3x.png","actualPayMoneyDesc":"支付总价","platformType":"1","processItems":[{"processStateId":"hasCreate","processStateText":"已拍下"},{"processStateId":"hasPay","processStateText":"已付款"},{"processStateId":"waitSend","processStateText":"待发货"},{"processStateId":"waitReceive","processStateText":"待收货"}],"allFreight":"0","actualPayMoney_f":"100","payType":"10","btnTextContract":"联系买家","price":"1","userNickName":"落花j7x4ullc","infoTotalPrice":"1","canEvaulate":"0","eveluationStatus":"3","orderStructure":"1","picLabels":[],"availableServices":[],"detailInfo":"支付成功，待卖家发货","payTypeTitle":"支付宝支付","packAmount":"0","isBuyer":"0","buyerPayTime":"1574417877192","productInfo":[{"price":"￥1","name":"商品总额"},{"price":"+ ￥0","name":"运费","priceKind":"8"}],"packId":"0","discountInfo":[],"infoCountDesc":"共1件商品","cateId":"2101020","payId":"1197821314527029546","businessLineId":"1301000","status":"3","refund":"0","sumPrice":"1","operationInfo":[{"arg":{"sheetInfo":{"cancel":"取消","contentList":["商品在其他地方已出售","需要修改价格后买家重新拍下","买家拍下后迟迟不付款","与买家价格未协商一致","与买家邮费未协商一致","联系不到买家","不想卖了","与买家协商一致","其他原因"]}},"operationId":"refuseOrder","text":"取消订单"},{"operationInfos":[{"arg":{},"operationId":"shipDeliverGood","text":"快递发货"},{"arg":{"alertInfo":{"cancel":"取消","sure":"继续","title":"\"当面交易\"提醒","content":"当面交易时，在买家验货无误后，请要求买家当面点击\"确认收货\"按钮，以免钱货两失。"}},"operationId":"faceDeliverGood","text":"当面交易"}],"arg":{},"operationId":"deliver","text":"确认发货"}],"addressHidden":"0","freight":"0","refundStatus":"0","ifEveluation":"1","infoDescription":"","latestOpTime":"1574417877192","middleOperationList":[{"operationId":"getKuaiDiPhone","text":"预约快递"},{"arg":{"uid":"279472457185040640"},"operationId":"contactServicer","text":"联系买家"}],"cateParentId":"101","actualPayMoney":"1","logisticsCompany":"","statusInfo1":"<font color=\"#f48260\">支付成功，待发货<\/font>","jumpOrderDetail":"zhuanzhuan://jump/core/orderDetail/jump?orderId=1197821314527029547","isGoodPhone":"0","deliverTime":"0","orderSource":"0","address":"{\"mobile\":\"18017975073\",\"city\":\"杭州市 西湖区\",\"detail\":\"云溪香山121\",\"name\":\"曹总\",\"province\":\"浙江省\"}","leftOperationList":[{"arg":{"uid":"279472457185040640"},"operationId":"contactServicer","text":"联系买家"}],"ArbitrationStatue":"0","userTel":"139****7007","isFinish":"0","userId":"279472457185040640","orderUnDelMsg":"订单尚未结束，不支持删除哦","infoPics":"n_v28f9b2ce435b64225a6d76afd03f4f43f.jpg","isFullRefund":"1","oriPrice":"0","statusDescription":"待您发货","createTime":"1574417830604","metric":"OrderDetail","infoList":[{"operationList":[],"infoId":"1197820996566761474","buyNum":"1","canNotApplyRefund":"0","isClipping":"0","metric":"OrderDetail","price":"1.00","childOrderId":"1197821314527029547","title":"小米鼠标","pics":"n_v28f9b2ce435b64225a6d76afd03f4f43f.jpg","content":" 请走转转担保交易，喜欢的话就赶快联系我吧。"}],"orderCategory":"0","userLink":"zhuanzhuan://jump/core/personHome/jump?uid=279472457185040640"}]}
     * respCode : 0
     */
    private RespDataEntity respData;
    private String respCode;

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
        /**
         * orderList : [{"infoId":"1197820996566761474","infoTitle":"小米鼠标  请走转转担保交易，喜欢的话就赶快联系我吧。","statusInfo":"支付成功，待发货","orderId":"1197821314527029547","payTime":"0","userPic":"http://img.58cdn.com.cn/zhuanzhuan/defaulth-head-image-bear@3x.png","actualPayMoneyDesc":"支付总价","platformType":"1","processItems":[{"processStateId":"hasCreate","processStateText":"已拍下"},{"processStateId":"hasPay","processStateText":"已付款"},{"processStateId":"waitSend","processStateText":"待发货"},{"processStateId":"waitReceive","processStateText":"待收货"}],"allFreight":"0","actualPayMoney_f":"100","payType":"10","btnTextContract":"联系买家","price":"1","userNickName":"落花j7x4ullc","infoTotalPrice":"1","canEvaulate":"0","eveluationStatus":"3","orderStructure":"1","picLabels":[],"availableServices":[],"detailInfo":"支付成功，待卖家发货","payTypeTitle":"支付宝支付","packAmount":"0","isBuyer":"0","buyerPayTime":"1574417877192","productInfo":[{"price":"￥1","name":"商品总额"},{"price":"+ ￥0","name":"运费","priceKind":"8"}],"packId":"0","discountInfo":[],"infoCountDesc":"共1件商品","cateId":"2101020","payId":"1197821314527029546","businessLineId":"1301000","status":"3","refund":"0","sumPrice":"1","operationInfo":[{"arg":{"sheetInfo":{"cancel":"取消","contentList":["商品在其他地方已出售","需要修改价格后买家重新拍下","买家拍下后迟迟不付款","与买家价格未协商一致","与买家邮费未协商一致","联系不到买家","不想卖了","与买家协商一致","其他原因"]}},"operationId":"refuseOrder","text":"取消订单"},{"operationInfos":[{"arg":{},"operationId":"shipDeliverGood","text":"快递发货"},{"arg":{"alertInfo":{"cancel":"取消","sure":"继续","title":"\"当面交易\"提醒","content":"当面交易时，在买家验货无误后，请要求买家当面点击\"确认收货\"按钮，以免钱货两失。"}},"operationId":"faceDeliverGood","text":"当面交易"}],"arg":{},"operationId":"deliver","text":"确认发货"}],"addressHidden":"0","freight":"0","refundStatus":"0","ifEveluation":"1","infoDescription":"","latestOpTime":"1574417877192","middleOperationList":[{"operationId":"getKuaiDiPhone","text":"预约快递"},{"arg":{"uid":"279472457185040640"},"operationId":"contactServicer","text":"联系买家"}],"cateParentId":"101","actualPayMoney":"1","logisticsCompany":"","statusInfo1":"<font color=\"#f48260\">支付成功，待发货<\/font>","jumpOrderDetail":"zhuanzhuan://jump/core/orderDetail/jump?orderId=1197821314527029547","isGoodPhone":"0","deliverTime":"0","orderSource":"0","address":"{\"mobile\":\"18017975073\",\"city\":\"杭州市 西湖区\",\"detail\":\"云溪香山121\",\"name\":\"曹总\",\"province\":\"浙江省\"}","leftOperationList":[{"arg":{"uid":"279472457185040640"},"operationId":"contactServicer","text":"联系买家"}],"ArbitrationStatue":"0","userTel":"139****7007","isFinish":"0","userId":"279472457185040640","orderUnDelMsg":"订单尚未结束，不支持删除哦","infoPics":"n_v28f9b2ce435b64225a6d76afd03f4f43f.jpg","isFullRefund":"1","oriPrice":"0","statusDescription":"待您发货","createTime":"1574417830604","metric":"OrderDetail","infoList":[{"operationList":[],"infoId":"1197820996566761474","buyNum":"1","canNotApplyRefund":"0","isClipping":"0","metric":"OrderDetail","price":"1.00","childOrderId":"1197821314527029547","title":"小米鼠标","pics":"n_v28f9b2ce435b64225a6d76afd03f4f43f.jpg","content":" 请走转转担保交易，喜欢的话就赶快联系我吧。"}],"orderCategory":"0","userLink":"zhuanzhuan://jump/core/personHome/jump?uid=279472457185040640"}]
         */
        private List<OrderListEntity> orderList;

        public void setOrderList(List<OrderListEntity> orderList) {
            this.orderList = orderList;
        }

        public List<OrderListEntity> getOrderList() {
            return orderList;
        }

        public class OrderListEntity {
            /**
             * infoId : 1197820996566761474
             * infoTitle : 小米鼠标  请走转转担保交易，喜欢的话就赶快联系我吧。
             * statusInfo : 支付成功，待发货
             * orderId : 1197821314527029547
             * payTime : 0
             * userPic : http://img.58cdn.com.cn/zhuanzhuan/defaulth-head-image-bear@3x.png
             * actualPayMoneyDesc : 支付总价
             * platformType : 1
             * processItems : [{"processStateId":"hasCreate","processStateText":"已拍下"},{"processStateId":"hasPay","processStateText":"已付款"},{"processStateId":"waitSend","processStateText":"待发货"},{"processStateId":"waitReceive","processStateText":"待收货"}]
             * allFreight : 0
             * actualPayMoney_f : 100
             * payType : 10
             * btnTextContract : 联系买家
             * price : 1
             * userNickName : 落花j7x4ullc
             * infoTotalPrice : 1
             * canEvaulate : 0
             * eveluationStatus : 3
             * orderStructure : 1
             * picLabels : []
             * availableServices : []
             * detailInfo : 支付成功，待卖家发货
             * payTypeTitle : 支付宝支付
             * packAmount : 0
             * isBuyer : 0
             * buyerPayTime : 1574417877192
             * productInfo : [{"price":"￥1","name":"商品总额"},{"price":"+ ￥0","name":"运费","priceKind":"8"}]
             * packId : 0
             * discountInfo : []
             * infoCountDesc : 共1件商品
             * cateId : 2101020
             * payId : 1197821314527029546
             * businessLineId : 1301000
             * status : 3
             * refund : 0
             * sumPrice : 1
             * operationInfo : [{"arg":{"sheetInfo":{"cancel":"取消","contentList":["商品在其他地方已出售","需要修改价格后买家重新拍下","买家拍下后迟迟不付款","与买家价格未协商一致","与买家邮费未协商一致","联系不到买家","不想卖了","与买家协商一致","其他原因"]}},"operationId":"refuseOrder","text":"取消订单"},{"operationInfos":[{"arg":{},"operationId":"shipDeliverGood","text":"快递发货"},{"arg":{"alertInfo":{"cancel":"取消","sure":"继续","title":"\"当面交易\"提醒","content":"当面交易时，在买家验货无误后，请要求买家当面点击\"确认收货\"按钮，以免钱货两失。"}},"operationId":"faceDeliverGood","text":"当面交易"}],"arg":{},"operationId":"deliver","text":"确认发货"}]
             * addressHidden : 0
             * freight : 0
             * refundStatus : 0
             * ifEveluation : 1
             * infoDescription :
             * latestOpTime : 1574417877192
             * middleOperationList : [{"operationId":"getKuaiDiPhone","text":"预约快递"},{"arg":{"uid":"279472457185040640"},"operationId":"contactServicer","text":"联系买家"}]
             * cateParentId : 101
             * actualPayMoney : 1
             * logisticsCompany :
             * statusInfo1 : <font color="#f48260">支付成功，待发货</font>
             * jumpOrderDetail : zhuanzhuan://jump/core/orderDetail/jump?orderId=1197821314527029547
             * isGoodPhone : 0
             * deliverTime : 0
             * orderSource : 0
             * address : {"mobile":"18017975073","city":"杭州市 西湖区","detail":"云溪香山121","name":"曹总","province":"浙江省"}
             * leftOperationList : [{"arg":{"uid":"279472457185040640"},"operationId":"contactServicer","text":"联系买家"}]
             * ArbitrationStatue : 0
             * userTel : 139****7007
             * isFinish : 0
             * userId : 279472457185040640
             * orderUnDelMsg : 订单尚未结束，不支持删除哦
             * infoPics : n_v28f9b2ce435b64225a6d76afd03f4f43f.jpg
             * isFullRefund : 1
             * oriPrice : 0
             * statusDescription : 待您发货
             * createTime : 1574417830604
             * metric : OrderDetail
             * infoList : [{"operationList":[],"infoId":"1197820996566761474","buyNum":"1","canNotApplyRefund":"0","isClipping":"0","metric":"OrderDetail","price":"1.00","childOrderId":"1197821314527029547","title":"小米鼠标","pics":"n_v28f9b2ce435b64225a6d76afd03f4f43f.jpg","content":" 请走转转担保交易，喜欢的话就赶快联系我吧。"}]
             * orderCategory : 0
             * userLink : zhuanzhuan://jump/core/personHome/jump?uid=279472457185040640
             */
            private String infoId;
            private String infoTitle;
            private String statusInfo;
            private String orderId;
            private String payTime;
            private String userPic;
            private String actualPayMoneyDesc;
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
            private String ArbitrationStatue;
            private String userTel;
            private String isFinish;
            private String userId;
            private String orderUnDelMsg;
            private String infoPics;
            private String isFullRefund;
            private String oriPrice;
            private String statusDescription;
            private String createTime;
            private String metric;
            private List<InfoListEntity> infoList;
            private String orderCategory;
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

            public String getUserLink() {
                return userLink;
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

            public class ProductInfoEntity {
                /**
                 * price : ￥1
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
                 * arg : {"sheetInfo":{"cancel":"取消","contentList":["商品在其他地方已出售","需要修改价格后买家重新拍下","买家拍下后迟迟不付款","与买家价格未协商一致","与买家邮费未协商一致","联系不到买家","不想卖了","与买家协商一致","其他原因"]}}
                 * operationId : refuseOrder
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
                     * sheetInfo : {"cancel":"取消","contentList":["商品在其他地方已出售","需要修改价格后买家重新拍下","买家拍下后迟迟不付款","与买家价格未协商一致","与买家邮费未协商一致","联系不到买家","不想卖了","与买家协商一致","其他原因"]}
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
                         * contentList : ["商品在其他地方已出售","需要修改价格后买家重新拍下","买家拍下后迟迟不付款","与买家价格未协商一致","与买家邮费未协商一致","联系不到买家","不想卖了","与买家协商一致","其他原因"]
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
                 * operationId : getKuaiDiPhone
                 * text : 预约快递
                 */
                private String operationId;
                private String text;

                public void setOperationId(String operationId) {
                    this.operationId = operationId;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getOperationId() {
                    return operationId;
                }

                public String getText() {
                    return text;
                }
            }

            public class LeftOperationListEntity {
                /**
                 * arg : {"uid":"279472457185040640"}
                 * operationId : contactServicer
                 * text : 联系买家
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
                     * uid : 279472457185040640
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
                 * operationList : []
                 * infoId : 1197820996566761474
                 * buyNum : 1
                 * canNotApplyRefund : 0
                 * isClipping : 0
                 * metric : OrderDetail
                 * price : 1.00
                 * childOrderId : 1197821314527029547
                 * title : 小米鼠标
                 * pics : n_v28f9b2ce435b64225a6d76afd03f4f43f.jpg
                 * content :  请走转转担保交易，喜欢的话就赶快联系我吧。
                 */
                private List<?> operationList;
                private String infoId;
                private String buyNum;
                private String canNotApplyRefund;
                private String isClipping;
                private String metric;
                private String price;
                private String childOrderId;
                private String title;
                private String pics;
                private String content;

                public void setOperationList(List<?> operationList) {
                    this.operationList = operationList;
                }

                public void setInfoId(String infoId) {
                    this.infoId = infoId;
                }

                public void setBuyNum(String buyNum) {
                    this.buyNum = buyNum;
                }

                public void setCanNotApplyRefund(String canNotApplyRefund) {
                    this.canNotApplyRefund = canNotApplyRefund;
                }

                public void setIsClipping(String isClipping) {
                    this.isClipping = isClipping;
                }

                public void setMetric(String metric) {
                    this.metric = metric;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public void setChildOrderId(String childOrderId) {
                    this.childOrderId = childOrderId;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setPics(String pics) {
                    this.pics = pics;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public List<?> getOperationList() {
                    return operationList;
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

                public String getIsClipping() {
                    return isClipping;
                }

                public String getMetric() {
                    return metric;
                }

                public String getPrice() {
                    return price;
                }

                public String getChildOrderId() {
                    return childOrderId;
                }

                public String getTitle() {
                    return title;
                }

                public String getPics() {
                    return pics;
                }

                public String getContent() {
                    return content;
                }
            }
        }
    }
}
