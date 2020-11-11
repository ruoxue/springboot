package com.wowotou.payservice.bean.zhuanzhuan;

import java.io.Serializable;
import java.util.List;

public class ZhuanPayModel implements Serializable {


    /**
     * respData : {"returnCode":"SUCCESS","returnMsg":"OK","thirdPayInfodata":[{"payMethod":"2","payData":{"mchId":"1001","form":"<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?charset=UTF-8&method=alipay.trade.wap.pay&sign=NDfu2zmPTX%2BenzMPmGmKyHvdXQrHfoITMxy0Wlm1dyQ4AbaA7atmntN1veBjoNsIoSnKof8a%2FgEVChentjCfH3q3hmbFa7lKKmpYU8gPnXZcuLirjijocyO8lqtVqbl6AXDRaFrr9sUIaNHfOhoEOkR6DRfNeFn0NnsnoDWU%2B%2FQiC71SQyYjdnurAB7yeFroioBPtkQUXUgdwIDNO4u%2Ft%2BkaOhVZP%2FzEqec5yA5ozR9GuNHoGtuzrVaT2%2FWxazrb5uLCQvUHWO7ObLSp%2Ba6MYi%2FC4QNfdq6qlr1XoLmVSGtj%2F5PqEm9pD08hUsgbknOs3xgGLXLwv1wrJn7to%2B76LA%3D%3D&return_url=https%3A%2F%2Fzhuan.58.com%2Fzz%2Fredirect%2FgetJdPaySuccessUrl%3FzzReturnUrl%3Dhttps%253A%252F%252Fm.zhuanzhuan.com%252Fyoupin%252Fwebsite%252Fservice%252Fordersuccee.html%253ForderId%253D1196789921064561630%26payId%3Dnull%26bizMchId%3Dnull&notify_url=http%3A%2F%2Fwww.zhuanzhuan.com%2Fpay%2Falicallback&version=1.0&app_id=2017102309467559&sign_type=RSA2&timestamp=2019-11-19+21%3A59%3A10&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json\">\n<input type=\"hidden\" name=\"biz_content\" value=\"{&quot;disable_pay_channels&quot;:&quot;credit_group&quot;,&quot;goods_type&quot;:&quot;1&quot;,&quot;out_trade_no&quot;:&quot;1196790017729495051&quot;,&quot;product_code&quot;:&quot;QUICK_WAP_WAY&quot;,&quot;subject&quot;:&quot;转转，订单号：1196789921064561630&quot;,&quot;time_expire&quot;:&quot;2019-11-19 22:13&quot;,&quot;total_amount&quot;:&quot;1.00&quot;}\">\n<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n<\/form>\n<script>document.forms[0].submit();<\/script>","qrCode":"","payId":"1196789921064561629"},"tradeType":"MWEB2"}]}
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
         * returnCode : SUCCESS
         * returnMsg : OK
         * thirdPayInfodata : [{"payMethod":"2","payData":{"mchId":"1001","form":"<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?charset=UTF-8&method=alipay.trade.wap.pay&sign=NDfu2zmPTX%2BenzMPmGmKyHvdXQrHfoITMxy0Wlm1dyQ4AbaA7atmntN1veBjoNsIoSnKof8a%2FgEVChentjCfH3q3hmbFa7lKKmpYU8gPnXZcuLirjijocyO8lqtVqbl6AXDRaFrr9sUIaNHfOhoEOkR6DRfNeFn0NnsnoDWU%2B%2FQiC71SQyYjdnurAB7yeFroioBPtkQUXUgdwIDNO4u%2Ft%2BkaOhVZP%2FzEqec5yA5ozR9GuNHoGtuzrVaT2%2FWxazrb5uLCQvUHWO7ObLSp%2Ba6MYi%2FC4QNfdq6qlr1XoLmVSGtj%2F5PqEm9pD08hUsgbknOs3xgGLXLwv1wrJn7to%2B76LA%3D%3D&return_url=https%3A%2F%2Fzhuan.58.com%2Fzz%2Fredirect%2FgetJdPaySuccessUrl%3FzzReturnUrl%3Dhttps%253A%252F%252Fm.zhuanzhuan.com%252Fyoupin%252Fwebsite%252Fservice%252Fordersuccee.html%253ForderId%253D1196789921064561630%26payId%3Dnull%26bizMchId%3Dnull&notify_url=http%3A%2F%2Fwww.zhuanzhuan.com%2Fpay%2Falicallback&version=1.0&app_id=2017102309467559&sign_type=RSA2&timestamp=2019-11-19+21%3A59%3A10&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json\">\n<input type=\"hidden\" name=\"biz_content\" value=\"{&quot;disable_pay_channels&quot;:&quot;credit_group&quot;,&quot;goods_type&quot;:&quot;1&quot;,&quot;out_trade_no&quot;:&quot;1196790017729495051&quot;,&quot;product_code&quot;:&quot;QUICK_WAP_WAY&quot;,&quot;subject&quot;:&quot;转转，订单号：1196789921064561630&quot;,&quot;time_expire&quot;:&quot;2019-11-19 22:13&quot;,&quot;total_amount&quot;:&quot;1.00&quot;}\">\n<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n<\/form>\n<script>document.forms[0].submit();<\/script>","qrCode":"","payId":"1196789921064561629"},"tradeType":"MWEB2"}]
         */
        private String returnCode;
        private String returnMsg;
        private List<ThirdPayInfodataEntity> thirdPayInfodata;

        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }

        public void setReturnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
        }

        public void setThirdPayInfodata(List<ThirdPayInfodataEntity> thirdPayInfodata) {
            this.thirdPayInfodata = thirdPayInfodata;
        }

        public String getReturnCode() {
            return returnCode;
        }

        public String getReturnMsg() {
            return returnMsg;
        }

        public List<ThirdPayInfodataEntity> getThirdPayInfodata() {
            return thirdPayInfodata;
        }

        public class ThirdPayInfodataEntity {
            /**
             * payMethod : 2
             * payData : {"mchId":"1001","form":"<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?charset=UTF-8&method=alipay.trade.wap.pay&sign=NDfu2zmPTX%2BenzMPmGmKyHvdXQrHfoITMxy0Wlm1dyQ4AbaA7atmntN1veBjoNsIoSnKof8a%2FgEVChentjCfH3q3hmbFa7lKKmpYU8gPnXZcuLirjijocyO8lqtVqbl6AXDRaFrr9sUIaNHfOhoEOkR6DRfNeFn0NnsnoDWU%2B%2FQiC71SQyYjdnurAB7yeFroioBPtkQUXUgdwIDNO4u%2Ft%2BkaOhVZP%2FzEqec5yA5ozR9GuNHoGtuzrVaT2%2FWxazrb5uLCQvUHWO7ObLSp%2Ba6MYi%2FC4QNfdq6qlr1XoLmVSGtj%2F5PqEm9pD08hUsgbknOs3xgGLXLwv1wrJn7to%2B76LA%3D%3D&return_url=https%3A%2F%2Fzhuan.58.com%2Fzz%2Fredirect%2FgetJdPaySuccessUrl%3FzzReturnUrl%3Dhttps%253A%252F%252Fm.zhuanzhuan.com%252Fyoupin%252Fwebsite%252Fservice%252Fordersuccee.html%253ForderId%253D1196789921064561630%26payId%3Dnull%26bizMchId%3Dnull&notify_url=http%3A%2F%2Fwww.zhuanzhuan.com%2Fpay%2Falicallback&version=1.0&app_id=2017102309467559&sign_type=RSA2&timestamp=2019-11-19+21%3A59%3A10&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json\">\n<input type=\"hidden\" name=\"biz_content\" value=\"{&quot;disable_pay_channels&quot;:&quot;credit_group&quot;,&quot;goods_type&quot;:&quot;1&quot;,&quot;out_trade_no&quot;:&quot;1196790017729495051&quot;,&quot;product_code&quot;:&quot;QUICK_WAP_WAY&quot;,&quot;subject&quot;:&quot;转转，订单号：1196789921064561630&quot;,&quot;time_expire&quot;:&quot;2019-11-19 22:13&quot;,&quot;total_amount&quot;:&quot;1.00&quot;}\">\n<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n<\/form>\n<script>document.forms[0].submit();<\/script>","qrCode":"","payId":"1196789921064561629"}
             * tradeType : MWEB2
             */
            private String payMethod;
            private PayDataEntity payData;
            private String tradeType;

            public void setPayMethod(String payMethod) {
                this.payMethod = payMethod;
            }

            public void setPayData(PayDataEntity payData) {
                this.payData = payData;
            }

            public void setTradeType(String tradeType) {
                this.tradeType = tradeType;
            }

            public String getPayMethod() {
                return payMethod;
            }

            public PayDataEntity getPayData() {
                return payData;
            }

            public String getTradeType() {
                return tradeType;
            }

            public class PayDataEntity {
                /**
                 * mchId : 1001
                 * form : <form name="punchout_form" method="post" action="https://openapi.alipay.com/gateway.do?charset=UTF-8&method=alipay.trade.wap.pay&sign=NDfu2zmPTX%2BenzMPmGmKyHvdXQrHfoITMxy0Wlm1dyQ4AbaA7atmntN1veBjoNsIoSnKof8a%2FgEVChentjCfH3q3hmbFa7lKKmpYU8gPnXZcuLirjijocyO8lqtVqbl6AXDRaFrr9sUIaNHfOhoEOkR6DRfNeFn0NnsnoDWU%2B%2FQiC71SQyYjdnurAB7yeFroioBPtkQUXUgdwIDNO4u%2Ft%2BkaOhVZP%2FzEqec5yA5ozR9GuNHoGtuzrVaT2%2FWxazrb5uLCQvUHWO7ObLSp%2Ba6MYi%2FC4QNfdq6qlr1XoLmVSGtj%2F5PqEm9pD08hUsgbknOs3xgGLXLwv1wrJn7to%2B76LA%3D%3D&return_url=https%3A%2F%2Fzhuan.58.com%2Fzz%2Fredirect%2FgetJdPaySuccessUrl%3FzzReturnUrl%3Dhttps%253A%252F%252Fm.zhuanzhuan.com%252Fyoupin%252Fwebsite%252Fservice%252Fordersuccee.html%253ForderId%253D1196789921064561630%26payId%3Dnull%26bizMchId%3Dnull&notify_url=http%3A%2F%2Fwww.zhuanzhuan.com%2Fpay%2Falicallback&version=1.0&app_id=2017102309467559&sign_type=RSA2&timestamp=2019-11-19+21%3A59%3A10&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json">
                 <input type="hidden" name="biz_content" value="{&quot;disable_pay_channels&quot;:&quot;credit_group&quot;,&quot;goods_type&quot;:&quot;1&quot;,&quot;out_trade_no&quot;:&quot;1196790017729495051&quot;,&quot;product_code&quot;:&quot;QUICK_WAP_WAY&quot;,&quot;subject&quot;:&quot;转转，订单号：1196789921064561630&quot;,&quot;time_expire&quot;:&quot;2019-11-19 22:13&quot;,&quot;total_amount&quot;:&quot;1.00&quot;}">
                 <input type="submit" value="立即支付" style="display:none" >
                 </form>
                 <script>document.forms[0].submit();</script>
                 * qrCode :
                 * payId : 1196789921064561629
                 */
                private String mchId;
                private String form;
                private String qrCode;
                private String payId;

                public void setMchId(String mchId) {
                    this.mchId = mchId;
                }

                public void setForm(String form) {
                    this.form = form;
                }

                public void setQrCode(String qrCode) {
                    this.qrCode = qrCode;
                }

                public void setPayId(String payId) {
                    this.payId = payId;
                }

                public String getMchId() {
                    return mchId;
                }

                public String getForm() {
                    return form;
                }

                public String getQrCode() {
                    return qrCode;
                }

                public String getPayId() {
                    return payId;
                }
            }
        }
    }
}
