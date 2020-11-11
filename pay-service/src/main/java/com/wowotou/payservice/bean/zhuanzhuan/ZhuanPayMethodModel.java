package com.wowotou.payservice.bean.zhuanzhuan;

import java.io.Serializable;
import java.util.List;

public class ZhuanPayMethodModel implements Serializable {


    /**
     * respData : {"payInfoConfigList":[{"payConfigId":"30","payMethod":"2","generalConfig":{"tagList":[],"payTypeIcon":"https://img.58cdn.com.cn/zhuanzhuan/images/zhifubao@3x.png","needAlert":"0","needStage":"0","payTypeContent":"有支付宝账户可选择使用","creditCardSwitch":"0","payTypeTitle":"支付宝支付"},"tradeType":"MWEB2"}],"returnCode":"SUCCESS","returnMsg":"OK","totalMoney":"100","goodsInfo":{"infoId":"1195971184114761736","infoTitle":"耳机，耳机","infoCount":"1","infoPics":"n_v21c30545179c640148ee6ded9dd4da98f.jpg","infoPrice":"100"}}
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
         * payInfoConfigList : [{"payConfigId":"30","payMethod":"2","generalConfig":{"tagList":[],"payTypeIcon":"https://img.58cdn.com.cn/zhuanzhuan/images/zhifubao@3x.png","needAlert":"0","needStage":"0","payTypeContent":"有支付宝账户可选择使用","creditCardSwitch":"0","payTypeTitle":"支付宝支付"},"tradeType":"MWEB2"}]
         * returnCode : SUCCESS
         * returnMsg : OK
         * totalMoney : 100
         * goodsInfo : {"infoId":"1195971184114761736","infoTitle":"耳机，耳机","infoCount":"1","infoPics":"n_v21c30545179c640148ee6ded9dd4da98f.jpg","infoPrice":"100"}
         */
        private List<PayInfoConfigListEntity> payInfoConfigList;
        private String returnCode;
        private String returnMsg;
        private String totalMoney;
        private GoodsInfoEntity goodsInfo;

        public void setPayInfoConfigList(List<PayInfoConfigListEntity> payInfoConfigList) {
            this.payInfoConfigList = payInfoConfigList;
        }

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public void setReturnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
        }

        public void setTotalMoney(String totalMoney) {
            this.totalMoney = totalMoney;
        }

        public void setGoodsInfo(GoodsInfoEntity goodsInfo) {
            this.goodsInfo = goodsInfo;
        }

        public List<PayInfoConfigListEntity> getPayInfoConfigList() {
            return payInfoConfigList;
        }

        public String getReturnCode() {
            return returnCode;
        }

        public String getReturnMsg() {
            return returnMsg;
        }

        public String getTotalMoney() {
            return totalMoney;
        }

        public GoodsInfoEntity getGoodsInfo() {
            return goodsInfo;
        }

        public class PayInfoConfigListEntity {
            /**
             * payConfigId : 30
             * payMethod : 2
             * generalConfig : {"tagList":[],"payTypeIcon":"https://img.58cdn.com.cn/zhuanzhuan/images/zhifubao@3x.png","needAlert":"0","needStage":"0","payTypeContent":"有支付宝账户可选择使用","creditCardSwitch":"0","payTypeTitle":"支付宝支付"}
             * tradeType : MWEB2
             */
            private String payConfigId;
            private String payMethod;
            private GeneralConfigEntity generalConfig;
            private String tradeType;

            @Override
            public String toString() {
                return "PayInfoConfigListEntity{" +
                        "payConfigId='" + payConfigId + '\'' +
                        ", payMethod='" + payMethod + '\'' +
                        ", generalConfig=" + generalConfig +
                        ", tradeType='" + tradeType + '\'' +
                        '}';
            }

            public void setPayConfigId(String payConfigId) {
                this.payConfigId = payConfigId;
            }

            public void setPayMethod(String payMethod) {
                this.payMethod = payMethod;
            }

            public void setGeneralConfig(GeneralConfigEntity generalConfig) {
                this.generalConfig = generalConfig;
            }

            public void setTradeType(String tradeType) {
                this.tradeType = tradeType;
            }

            public String getPayConfigId() {
                return payConfigId;
            }

            public String getPayMethod() {
                return payMethod;
            }

            public GeneralConfigEntity getGeneralConfig() {
                return generalConfig;
            }

            public String getTradeType() {
                return tradeType;
            }

            public class GeneralConfigEntity {
                /**
                 * tagList : []
                 * payTypeIcon : https://img.58cdn.com.cn/zhuanzhuan/images/zhifubao@3x.png
                 * needAlert : 0
                 * needStage : 0
                 * payTypeContent : 有支付宝账户可选择使用
                 * creditCardSwitch : 0
                 * payTypeTitle : 支付宝支付
                 */
                private List<?> tagList;
                private String payTypeIcon;
                private String needAlert;
                private String needStage;
                private String payTypeContent;
                private String creditCardSwitch;
                private String payTypeTitle;

                public void setTagList(List<?> tagList) {
                    this.tagList = tagList;
                }

                public void setPayTypeIcon(String payTypeIcon) {
                    this.payTypeIcon = payTypeIcon;
                }

                public void setNeedAlert(String needAlert) {
                    this.needAlert = needAlert;
                }

                public void setNeedStage(String needStage) {
                    this.needStage = needStage;
                }

                public void setPayTypeContent(String payTypeContent) {
                    this.payTypeContent = payTypeContent;
                }

                public void setCreditCardSwitch(String creditCardSwitch) {
                    this.creditCardSwitch = creditCardSwitch;
                }

                public void setPayTypeTitle(String payTypeTitle) {
                    this.payTypeTitle = payTypeTitle;
                }

                public List<?> getTagList() {
                    return tagList;
                }

                public String getPayTypeIcon() {
                    return payTypeIcon;
                }

                public String getNeedAlert() {
                    return needAlert;
                }

                public String getNeedStage() {
                    return needStage;
                }

                public String getPayTypeContent() {
                    return payTypeContent;
                }

                public String getCreditCardSwitch() {
                    return creditCardSwitch;
                }

                public String getPayTypeTitle() {
                    return payTypeTitle;
                }
            }
        }

        public class GoodsInfoEntity {
            /**
             * infoId : 1195971184114761736
             * infoTitle : 耳机，耳机
             * infoCount : 1
             * infoPics : n_v21c30545179c640148ee6ded9dd4da98f.jpg
             * infoPrice : 100
             */
            private String infoId;
            private String infoTitle;
            private String infoCount;
            private String infoPics;
            private String infoPrice;

            public void setInfoId(String infoId) {
                this.infoId = infoId;
            }

            public void setInfoTitle(String infoTitle) {
                this.infoTitle = infoTitle;
            }

            public void setInfoCount(String infoCount) {
                this.infoCount = infoCount;
            }

            public void setInfoPics(String infoPics) {
                this.infoPics = infoPics;
            }

            public void setInfoPrice(String infoPrice) {
                this.infoPrice = infoPrice;
            }

            public String getInfoId() {
                return infoId;
            }

            public String getInfoTitle() {
                return infoTitle;
            }

            public String getInfoCount() {
                return infoCount;
            }

            public String getInfoPics() {
                return infoPics;
            }

            public String getInfoPrice() {
                return infoPrice;
            }
        }
    }
}
