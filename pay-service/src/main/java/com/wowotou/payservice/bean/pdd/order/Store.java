/**
  * Copyright 2019 bejson.com 
  */
package com.wowotou.payservice.bean.pdd.order;
import java.util.List;

/**
 * Auto-generated: 2019-12-19 21:57:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Store {

    private String $http;
    private Services services;
    private String uid;
    private int frontEnv;
    private int pageFrom;
    private int frontVersion;
    private int isApp;
    private String goodsId;
    private long groupId;
    private String skuId;
    private int type;
    private boolean isPay;
    private String orderServicePath;
    private String customMorganUrl;
    private TrackingContext trackingContext;
    private AttrMap attrMap;
    private ExtendMap extendMap;
    private String fastReturn;
    private boolean orderNonAddress;
    private boolean orderRefresh;
    private boolean isWechatMiniProgram;
    private String chaosOrderSn;
    private String renderError;
    private String renderWarning;
    private $$pSubstoreMap $$pSubstoreMap;
    private GoodsInfoStore goodsInfoStore;
    private GroupStore groupStore;
    private GoodsItemStore goodsItemStore;
    private VirtualAddressItemStore virtualAddressItemStore;
    private StepInfoStore stepInfoStore;
    private AddressInfo addressInfo;
    private IdCardInfo idCardInfo;
    private CouponEmphasizeStore couponEmphasizeStore;
    private PaymentInfoStore paymentInfoStore;
    private DeliveryInfoStore deliveryInfoStore;
    private ServerTimeStore serverTimeStore;
    private CellBarStore cellBarStore;
    private boolean isServerRendered;
    private boolean isFinishInitLoading;
    private String accessToken;
    private String errorRedirectUrl;
    private boolean isPreRender;
    private boolean shouldShowFSComponent;
    private boolean actionDisable;
    private boolean userActionDisable;
    private int unreachableRec;
    private int goodsNumber;
    private int orderAmount;
    private boolean isCouponToReceiving;
    private ReturnDialogVo returnDialogVo;
    private String unpayDialogVo;
    private OrderInfo orderInfo;
    private PriceInfo priceInfo;
    private int btnStatus;
    private GoodsInfo goodsInfo;
    private MallInfo mallInfo;
    private List<String> payMethods;
    private ShippingInfo shippingInfo;
    private PromotionInfo promotionInfo;
    private List<String> receivingMallCouponList;
    private MallCouponList mallCouponList;
    private PlatformCouponList platformCouponList;
    private RepeatedCoupon repeatedCoupon;
    private String promotionEvent;
    private boolean showMorePlatformCoupon;
    private boolean showNoMoreHint;
    private int usePriority;
    private boolean disallowGoodsNumberChange;
    private ActivityParams activityParams;
    private boolean isWeChatPlatform;
    private String promotionEventInfo;
    public void set$http(String $http) {
         this.$http = $http;
     }
     public String get$http() {
         return $http;
     }

    public void setServices(Services services) {
         this.services = services;
     }
     public Services getServices() {
         return services;
     }

    public void setUid(String uid) {
         this.uid = uid;
     }
     public String getUid() {
         return uid;
     }

    public void setFrontEnv(int frontEnv) {
         this.frontEnv = frontEnv;
     }
     public int getFrontEnv() {
         return frontEnv;
     }

    public void setPageFrom(int pageFrom) {
         this.pageFrom = pageFrom;
     }
     public int getPageFrom() {
         return pageFrom;
     }

    public void setFrontVersion(int frontVersion) {
         this.frontVersion = frontVersion;
     }
     public int getFrontVersion() {
         return frontVersion;
     }

    public void setIsApp(int isApp) {
         this.isApp = isApp;
     }
     public int getIsApp() {
         return isApp;
     }

    public void setGoodsId(String goodsId) {
         this.goodsId = goodsId;
     }
     public String getGoodsId() {
         return goodsId;
     }

    public void setGroupId(long groupId) {
         this.groupId = groupId;
     }
     public long getGroupId() {
         return groupId;
     }

    public void setSkuId(String skuId) {
         this.skuId = skuId;
     }
     public String getSkuId() {
         return skuId;
     }

    public void setType(int type) {
         this.type = type;
     }
     public int getType() {
         return type;
     }

    public void setIsPay(boolean isPay) {
         this.isPay = isPay;
     }
     public boolean getIsPay() {
         return isPay;
     }

    public void setOrderServicePath(String orderServicePath) {
         this.orderServicePath = orderServicePath;
     }
     public String getOrderServicePath() {
         return orderServicePath;
     }

    public void setCustomMorganUrl(String customMorganUrl) {
         this.customMorganUrl = customMorganUrl;
     }
     public String getCustomMorganUrl() {
         return customMorganUrl;
     }

    public void setTrackingContext(TrackingContext trackingContext) {
         this.trackingContext = trackingContext;
     }
     public TrackingContext getTrackingContext() {
         return trackingContext;
     }

    public void setAttrMap(AttrMap attrMap) {
         this.attrMap = attrMap;
     }
     public AttrMap getAttrMap() {
         return attrMap;
     }

    public void setExtendMap(ExtendMap extendMap) {
         this.extendMap = extendMap;
     }
     public ExtendMap getExtendMap() {
         return extendMap;
     }

    public void setFastReturn(String fastReturn) {
         this.fastReturn = fastReturn;
     }
     public String getFastReturn() {
         return fastReturn;
     }

    public void setOrderNonAddress(boolean orderNonAddress) {
         this.orderNonAddress = orderNonAddress;
     }
     public boolean getOrderNonAddress() {
         return orderNonAddress;
     }

    public void setOrderRefresh(boolean orderRefresh) {
         this.orderRefresh = orderRefresh;
     }
     public boolean getOrderRefresh() {
         return orderRefresh;
     }

    public void setIsWechatMiniProgram(boolean isWechatMiniProgram) {
         this.isWechatMiniProgram = isWechatMiniProgram;
     }
     public boolean getIsWechatMiniProgram() {
         return isWechatMiniProgram;
     }

    public void setChaosOrderSn(String chaosOrderSn) {
         this.chaosOrderSn = chaosOrderSn;
     }
     public String getChaosOrderSn() {
         return chaosOrderSn;
     }

    public void setRenderError(String renderError) {
         this.renderError = renderError;
     }
     public String getRenderError() {
         return renderError;
     }

    public void setRenderWarning(String renderWarning) {
         this.renderWarning = renderWarning;
     }
     public String getRenderWarning() {
         return renderWarning;
     }

    public void set$$pSubstoreMap($$pSubstoreMap $$pSubstoreMap) {
         this.$$pSubstoreMap = $$pSubstoreMap;
     }
     public $$pSubstoreMap get$$pSubstoreMap() {
         return $$pSubstoreMap;
     }

    public void setGoodsInfoStore(GoodsInfoStore goodsInfoStore) {
         this.goodsInfoStore = goodsInfoStore;
     }
     public GoodsInfoStore getGoodsInfoStore() {
         return goodsInfoStore;
     }

    public void setGroupStore(GroupStore groupStore) {
         this.groupStore = groupStore;
     }
     public GroupStore getGroupStore() {
         return groupStore;
     }

    public void setGoodsItemStore(GoodsItemStore goodsItemStore) {
         this.goodsItemStore = goodsItemStore;
     }
     public GoodsItemStore getGoodsItemStore() {
         return goodsItemStore;
     }

    public void setVirtualAddressItemStore(VirtualAddressItemStore virtualAddressItemStore) {
         this.virtualAddressItemStore = virtualAddressItemStore;
     }
     public VirtualAddressItemStore getVirtualAddressItemStore() {
         return virtualAddressItemStore;
     }

    public void setStepInfoStore(StepInfoStore stepInfoStore) {
         this.stepInfoStore = stepInfoStore;
     }
     public StepInfoStore getStepInfoStore() {
         return stepInfoStore;
     }

    public void setAddressInfo(AddressInfo addressInfo) {
         this.addressInfo = addressInfo;
     }
     public AddressInfo getAddressInfo() {
         return addressInfo;
     }

    public void setIdCardInfo(IdCardInfo idCardInfo) {
         this.idCardInfo = idCardInfo;
     }
     public IdCardInfo getIdCardInfo() {
         return idCardInfo;
     }

    public void setCouponEmphasizeStore(CouponEmphasizeStore couponEmphasizeStore) {
         this.couponEmphasizeStore = couponEmphasizeStore;
     }
     public CouponEmphasizeStore getCouponEmphasizeStore() {
         return couponEmphasizeStore;
     }

    public void setPaymentInfoStore(PaymentInfoStore paymentInfoStore) {
         this.paymentInfoStore = paymentInfoStore;
     }
     public PaymentInfoStore getPaymentInfoStore() {
         return paymentInfoStore;
     }

    public void setDeliveryInfoStore(DeliveryInfoStore deliveryInfoStore) {
         this.deliveryInfoStore = deliveryInfoStore;
     }
     public DeliveryInfoStore getDeliveryInfoStore() {
         return deliveryInfoStore;
     }

    public void setServerTimeStore(ServerTimeStore serverTimeStore) {
         this.serverTimeStore = serverTimeStore;
     }
     public ServerTimeStore getServerTimeStore() {
         return serverTimeStore;
     }

    public void setCellBarStore(CellBarStore cellBarStore) {
         this.cellBarStore = cellBarStore;
     }
     public CellBarStore getCellBarStore() {
         return cellBarStore;
     }

    public void setIsServerRendered(boolean isServerRendered) {
         this.isServerRendered = isServerRendered;
     }
     public boolean getIsServerRendered() {
         return isServerRendered;
     }

    public void setIsFinishInitLoading(boolean isFinishInitLoading) {
         this.isFinishInitLoading = isFinishInitLoading;
     }
     public boolean getIsFinishInitLoading() {
         return isFinishInitLoading;
     }

    public void setAccessToken(String accessToken) {
         this.accessToken = accessToken;
     }
     public String getAccessToken() {
         return accessToken;
     }

    public void setErrorRedirectUrl(String errorRedirectUrl) {
         this.errorRedirectUrl = errorRedirectUrl;
     }
     public String getErrorRedirectUrl() {
         return errorRedirectUrl;
     }

    public void setIsPreRender(boolean isPreRender) {
         this.isPreRender = isPreRender;
     }
     public boolean getIsPreRender() {
         return isPreRender;
     }

    public void setShouldShowFSComponent(boolean shouldShowFSComponent) {
         this.shouldShowFSComponent = shouldShowFSComponent;
     }
     public boolean getShouldShowFSComponent() {
         return shouldShowFSComponent;
     }

    public void setActionDisable(boolean actionDisable) {
         this.actionDisable = actionDisable;
     }
     public boolean getActionDisable() {
         return actionDisable;
     }

    public void setUserActionDisable(boolean userActionDisable) {
         this.userActionDisable = userActionDisable;
     }
     public boolean getUserActionDisable() {
         return userActionDisable;
     }

    public void setUnreachableRec(int unreachableRec) {
         this.unreachableRec = unreachableRec;
     }
     public int getUnreachableRec() {
         return unreachableRec;
     }

    public void setGoodsNumber(int goodsNumber) {
         this.goodsNumber = goodsNumber;
     }
     public int getGoodsNumber() {
         return goodsNumber;
     }

    public void setOrderAmount(int orderAmount) {
         this.orderAmount = orderAmount;
     }
     public int getOrderAmount() {
         return orderAmount;
     }

    public void setIsCouponToReceiving(boolean isCouponToReceiving) {
         this.isCouponToReceiving = isCouponToReceiving;
     }
     public boolean getIsCouponToReceiving() {
         return isCouponToReceiving;
     }

    public void setReturnDialogVo(ReturnDialogVo returnDialogVo) {
         this.returnDialogVo = returnDialogVo;
     }
     public ReturnDialogVo getReturnDialogVo() {
         return returnDialogVo;
     }

    public void setUnpayDialogVo(String unpayDialogVo) {
         this.unpayDialogVo = unpayDialogVo;
     }
     public String getUnpayDialogVo() {
         return unpayDialogVo;
     }

    public void setOrderInfo(OrderInfo orderInfo) {
         this.orderInfo = orderInfo;
     }
     public OrderInfo getOrderInfo() {
         return orderInfo;
     }

    public void setPriceInfo(PriceInfo priceInfo) {
         this.priceInfo = priceInfo;
     }
     public PriceInfo getPriceInfo() {
         return priceInfo;
     }

    public void setBtnStatus(int btnStatus) {
         this.btnStatus = btnStatus;
     }
     public int getBtnStatus() {
         return btnStatus;
     }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
         this.goodsInfo = goodsInfo;
     }
     public GoodsInfo getGoodsInfo() {
         return goodsInfo;
     }

    public void setMallInfo(MallInfo mallInfo) {
         this.mallInfo = mallInfo;
     }
     public MallInfo getMallInfo() {
         return mallInfo;
     }

    public void setPayMethods(List<String> payMethods) {
         this.payMethods = payMethods;
     }
     public List<String> getPayMethods() {
         return payMethods;
     }

    public void setShippingInfo(ShippingInfo shippingInfo) {
         this.shippingInfo = shippingInfo;
     }
     public ShippingInfo getShippingInfo() {
         return shippingInfo;
     }

    public void setPromotionInfo(PromotionInfo promotionInfo) {
         this.promotionInfo = promotionInfo;
     }
     public PromotionInfo getPromotionInfo() {
         return promotionInfo;
     }

    public void setReceivingMallCouponList(List<String> receivingMallCouponList) {
         this.receivingMallCouponList = receivingMallCouponList;
     }
     public List<String> getReceivingMallCouponList() {
         return receivingMallCouponList;
     }

    public void setMallCouponList(MallCouponList mallCouponList) {
         this.mallCouponList = mallCouponList;
     }
     public MallCouponList getMallCouponList() {
         return mallCouponList;
     }

    public void setPlatformCouponList(PlatformCouponList platformCouponList) {
         this.platformCouponList = platformCouponList;
     }
     public PlatformCouponList getPlatformCouponList() {
         return platformCouponList;
     }

    public void setRepeatedCoupon(RepeatedCoupon repeatedCoupon) {
         this.repeatedCoupon = repeatedCoupon;
     }
     public RepeatedCoupon getRepeatedCoupon() {
         return repeatedCoupon;
     }

    public void setPromotionEvent(String promotionEvent) {
         this.promotionEvent = promotionEvent;
     }
     public String getPromotionEvent() {
         return promotionEvent;
     }

    public void setShowMorePlatformCoupon(boolean showMorePlatformCoupon) {
         this.showMorePlatformCoupon = showMorePlatformCoupon;
     }
     public boolean getShowMorePlatformCoupon() {
         return showMorePlatformCoupon;
     }

    public void setShowNoMoreHint(boolean showNoMoreHint) {
         this.showNoMoreHint = showNoMoreHint;
     }
     public boolean getShowNoMoreHint() {
         return showNoMoreHint;
     }

    public void setUsePriority(int usePriority) {
         this.usePriority = usePriority;
     }
     public int getUsePriority() {
         return usePriority;
     }

    public void setDisallowGoodsNumberChange(boolean disallowGoodsNumberChange) {
         this.disallowGoodsNumberChange = disallowGoodsNumberChange;
     }
     public boolean getDisallowGoodsNumberChange() {
         return disallowGoodsNumberChange;
     }

    public void setActivityParams(ActivityParams activityParams) {
         this.activityParams = activityParams;
     }
     public ActivityParams getActivityParams() {
         return activityParams;
     }

    public void setIsWeChatPlatform(boolean isWeChatPlatform) {
         this.isWeChatPlatform = isWeChatPlatform;
     }
     public boolean getIsWeChatPlatform() {
         return isWeChatPlatform;
     }

    public void setPromotionEventInfo(String promotionEventInfo) {
         this.promotionEventInfo = promotionEventInfo;
     }
     public String getPromotionEventInfo() {
         return promotionEventInfo;
     }

}