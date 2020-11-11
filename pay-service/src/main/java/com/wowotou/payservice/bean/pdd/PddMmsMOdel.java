package com.wowotou.payservice.bean.pdd;

import java.io.Serializable;
import java.util.List;

public class PddMmsMOdel implements Serializable {

    /**
     * result : [{"shipping_id":1,"phone":"95543","shipping_name":"申通快递"},{"shipping_id":3,"phone":"95320","shipping_name":"百世快递"},{"shipping_id":44,"phone":"95338","shipping_name":"顺丰快递"},{"shipping_id":85,"phone":"95554","shipping_name":"圆通快递"},{"shipping_id":115,"phone":"95311","shipping_name":"中通快递"},{"shipping_id":117,"phone":"95349","shipping_name":"优速快递"},{"shipping_id":118,"phone":"11183","shipping_name":"邮政EMS"},{"shipping_id":119,"phone":"400-188-8888","shipping_name":"天天快递"},{"shipping_id":120,"phone":"950616","shipping_name":"京东配送"},{"shipping_id":121,"phone":"95546","shipping_name":"韵达快递"},{"shipping_id":124,"phone":"95327","shipping_name":"国通快递"},{"shipping_id":129,"phone":"400-678-9000","shipping_name":"宅急送快递"},{"shipping_id":130,"phone":"4000106660","shipping_name":"如风达"},{"shipping_id":131,"phone":"95353","shipping_name":"德邦快递"},{"shipping_id":132,"phone":"11183","shipping_name":"邮政快递包裹"},{"shipping_id":133,"phone":"02159218889","shipping_name":"龙邦快递"},{"shipping_id":135,"phone":"400-886-1888","shipping_name":"联邦快递"},{"shipping_id":136,"phone":"400-619-9939","shipping_name":"九曳供应链"},{"shipping_id":148,"phone":"","shipping_name":"安达信"},{"shipping_id":155,"phone":"400-158-9888","shipping_name":"速尔快递"},{"shipping_id":156,"phone":"400-810-5666","shipping_name":"亚马逊物流"},{"shipping_id":157,"phone":"02151097665","shipping_name":"黑猫宅急便"},{"shipping_id":165,"phone":"","shipping_name":"汇通小红马"},{"shipping_id":180,"phone":"","shipping_name":"其他"},{"shipping_id":183,"phone":"95324","shipping_name":"跨越速运"},{"shipping_id":186,"phone":"1-800-275-8777","shipping_name":"usps"},{"shipping_id":187,"phone":"0532-68005985","shipping_name":"青岛安捷"},{"shipping_id":195,"phone":"021-60504200","shipping_name":"贝海国际速递"},{"shipping_id":197,"phone":"010-89198888","shipping_name":"环球速运"},{"shipping_id":201,"phone":"400-663-1111","shipping_name":"全一快递"},{"shipping_id":205,"phone":"400-168-1111","shipping_name":"远成快运"},{"shipping_id":210,"phone":"400-808-6666","shipping_name":"天地华宇"},{"shipping_id":211,"phone":"95-0404-69-277","shipping_name":"中邮速递"},{"shipping_id":213,"phone":"11183","shipping_name":"EMS-国际件"},{"shipping_id":214,"phone":"400-000-5566","shipping_name":"中铁物流"},{"shipping_id":216,"phone":"4008-000-222","shipping_name":"新邦物流"},{"shipping_id":217,"phone":"13375273507","shipping_name":"Flash Express"},{"shipping_id":226,"phone":"1300-09-6655","shipping_name":"EWE全球快递"},{"shipping_id":227,"phone":"400-800-9999","shipping_name":"日日顺物流"},{"shipping_id":228,"phone":"95315","shipping_name":"苏宁快递"},{"shipping_id":229,"phone":"400-8856-561","shipping_name":"百世快运"},{"shipping_id":230,"phone":"95353","shipping_name":"德邦物流"},{"shipping_id":232,"phone":"021-26139188","shipping_name":"AAE全球专递"},{"shipping_id":233,"phone":null,"shipping_name":"Aramex"},{"shipping_id":239,"phone":"95380","shipping_name":"DHL中国"},{"shipping_id":246,"phone":"800-820-8388","shipping_name":"UPS"},{"shipping_id":262,"phone":"400-777-5656","shipping_name":"传喜物流"},{"shipping_id":263,"phone":"400-626-1166","shipping_name":"大田物流"},{"shipping_id":264,"phone":"0755-23508077","shipping_name":"递四方"},{"shipping_id":268,"phone":"400-000-5566","shipping_name":"飞豹快递"},{"shipping_id":273,"phone":"400-182-6666","shipping_name":"恒路物流"},{"shipping_id":275,"phone":"0769-85515555","shipping_name":"加运美"},{"shipping_id":276,"phone":"400-820-5566","shipping_name":"佳吉快运"},{"shipping_id":277,"phone":"400-631-9999","shipping_name":"佳怡物流"},{"shipping_id":281,"phone":"0769-88626730","shipping_name":"京广速递"},{"shipping_id":285,"phone":"400-8888-887","shipping_name":"联昊通"},{"shipping_id":291,"phone":"400-817-4008","shipping_name":"民航快递"},{"shipping_id":305,"phone":"4008-556688","shipping_name":"盛丰物流"},{"shipping_id":306,"phone":"4008-222-222","shipping_name":"盛辉物流"},{"shipping_id":312,"phone":"4001-156-561","shipping_name":"万家物流"},{"shipping_id":315,"phone":"400-830-6333","shipping_name":"信丰物流"},{"shipping_id":317,"phone":"400-005-9958","shipping_name":"亚风速递"},{"shipping_id":319,"phone":"400-108-5656","shipping_name":"燕文物流"},{"shipping_id":324,"phone":"11183","shipping_name":"邮政标准快递"},{"shipping_id":325,"phone":"","shipping_name":"邮政国际包裹"},{"shipping_id":332,"phone":"95572","shipping_name":"中铁快运"},{"shipping_id":335,"phone":"400-830-6050","shipping_name":"优邦国际速运"},{"shipping_id":336,"phone":null,"shipping_name":"天际快递"},{"shipping_id":337,"phone":"1-877-387-9799","shipping_name":"飞洋快递"},{"shipping_id":338,"phone":"400-7200-400","shipping_name":"斑马物联网"},{"shipping_id":339,"phone":"400-086-1756","shipping_name":"易客满"},{"shipping_id":340,"phone":"950616","shipping_name":"京东大件物流"},{"shipping_id":341,"phone":null,"shipping_name":"速必达"},{"shipping_id":343,"phone":"4000-270-270","shipping_name":"中通快运"},{"shipping_id":344,"phone":"95546","shipping_name":"韵达快运"},{"shipping_id":346,"phone":"400-000-0056","shipping_name":"安得物流"},{"shipping_id":347,"phone":null,"shipping_name":"中粮我买网"},{"shipping_id":348,"phone":"4008311311","shipping_name":"壹米滴答"},{"shipping_id":349,"phone":"0527-80876668","shipping_name":"当当网"},{"shipping_id":350,"phone":"021-4009789888","shipping_name":"品骏"},{"shipping_id":351,"phone":"95554","shipping_name":"承诺达特快"},{"shipping_id":352,"phone":"400-128-8000","shipping_name":"安迅物流"},{"shipping_id":354,"phone":"400-628-7926","shipping_name":"D速物流"},{"shipping_id":355,"phone":"95543","shipping_name":"申通国际"},{"shipping_id":356,"phone":"400-6006-111","shipping_name":"一智通"},{"shipping_id":358,"phone":"4000-300-688","shipping_name":"顺心捷达"},{"shipping_id":359,"phone":"022-84889582*807","shipping_name":"群航国际货运"},{"shipping_id":360,"phone":"010-80418291","shipping_name":"中外运速递"},{"shipping_id":361,"phone":"02062262811","shipping_name":"卓志速运"},{"shipping_id":362,"phone":"15371963023","shipping_name":"加州猫速递"},{"shipping_id":363,"phone":"(020)66616988","shipping_name":"高捷物流"},{"shipping_id":364,"phone":"4008518666","shipping_name":"商桥物流"},{"shipping_id":365,"phone":"4008785253","shipping_name":"复融供应链"},{"shipping_id":366,"phone":"17702060769","shipping_name":"中远"},{"shipping_id":367,"phone":"95546","shipping_name":"韵达国际"},{"shipping_id":368,"phone":"4008802969","shipping_name":"美快国际"},{"shipping_id":370,"phone":"020-86767799","shipping_name":"威时沛运"},{"shipping_id":371,"phone":"95311-9","shipping_name":"中通国际"},{"shipping_id":372,"phone":"9533888","shipping_name":"顺丰快运"},{"shipping_id":374,"phone":"00852-3069 7070","shipping_name":"HKE国际速递"},{"shipping_id":375,"phone":"0064-9-6362112","shipping_name":"新西兰平安物流"}]
     * success : true
     * errorCode : 1000000
     * errorMsg : null
     */
    private List<ResultEntity> result;
    private boolean success;
    private int errorCode;
    private String errorMsg;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static  class ResultEntity {
        /**
         * shipping_id : 1
         * phone : 95543
         * shipping_name : 申通快递
         */
        private int shipping_id;
        private String phone;
        private String shipping_name;

        public void setShipping_id(int shipping_id) {
            this.shipping_id = shipping_id;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public int getShipping_id() {
            return shipping_id;
        }

        public String getPhone() {
            return phone;
        }

        public String getShipping_name() {
            return shipping_name;
        }
    }
}
