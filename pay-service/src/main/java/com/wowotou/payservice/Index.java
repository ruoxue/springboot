//package com.wowotou.payservice;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotypecom.wowotou.api.controller
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Logger;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//// mvn clean package -Dmaven.loadMMS.skip=true
//@Controller
//public class Index {
//
//
//    @Resource
//    private PayQueueService payQueueService;
//
//    @RequestMapping(value = "/pay", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, String> orderPay(int id) throws ClassNotFoundException {
//        QueueType queueType = payQueueService.getQueueTypebyId((id));
//        Map<String, String> codeUrl = new HashMap<>();
//        if (queueType == null) {
//            return null;
//        }
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean(Class.forName(queueType.getApi2()));
//
//        if (service == null) {
//            return codeUrl;
//        }
//        codeUrl = service.getCodeUrl(queueType);
//        return codeUrl;
//
//
//    }
//
//    @Resource
//    PayAccountService payAccountService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, String> updateToken(int aId) throws ClassNotFoundException {
//
//
//        PayChannel channel = payChannelService.getChannel((String.valueOf(aId)));
//        Map<String, String> codeUrl = new HashMap<>();
//        if (channel == null) {
//            return null;
//        }
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean(Class.forName(channel.getApi2()));
//        if (service == null) {
//            return codeUrl;
//        }
//        codeUrl = service.login(null);
//        return codeUrl;
//    }
//
//    @Resource
//    PayOrderService service;
//
//    @RequestMapping(value = "/notify", method = RequestMethod.GET)
//    public @ResponseBody
//    String notify(String id) {
//        System.out.println("notify");
//        return service.orderNotify(id);
//    }
//
//    @Autowired
//    ClassService classService;
//
//    @RequestMapping(value = "/api", method = RequestMethod.GET)
//    public @ResponseBody
//    List<ClassModel> getSonClass() {
//
//        return classService.getSonClass();
//
//
//    }
//
//
//    @RequestMapping(value = "/login/{channelId}", method = RequestMethod.GET)
//    public @ResponseBody
//    Map<String, String> login(@PathVariable int channelId,
//                              HttpServletRequest request) throws ClassNotFoundException {
//
//        PayChannel channel = payChannelService.getChannelById(channelId);
//
//        Map<String, String> params = new HashMap();
//        Map requestParams = request.getParameterMap();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            params.put(name, valueStr);
//
//        }
//
//
//        if (channel == null) {
//            return null;
//        }
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean
//                        (Class.forName(channel.getApi2()));
//        return null;//service.login(params);
//
//
//    }
//
//
//    @Resource
//    PayChannelService payChannelService;
//
//    @RequestMapping(value = "/payNotify/{remark}/{api}")
//    public @ResponseBody
//    String alipayNotify(HttpServletRequest request,
//                        @PathVariable String remark, @PathVariable String api)
//            throws ClassNotFoundException {
//
//
//        //获取支付宝POST过来反馈信息
//        Map<String, String> params = new HashMap();
//        Map requestParams = request.getParameterMap();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            params.put(name, valueStr);
//
//        }
//
//
//        IOrderService service
//                = (IOrderService) SpringContextUtil.getBean(Class.forName("com.mfypay.pay.order." + api));
//
//        return service.payNotify(params, IpUtil.getIpAddress(request));
//
//    }
//
//
//    @RequestMapping(value = "/bindAccount", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, String> bindAccount(int id) throws ClassNotFoundException {
//        PayCanAccount childAccount = payAccountService.getAccountById(id + "");
//        PayChannel channel = payChannelService.getChannelById(childAccount.getChannelId());
//        Map<String, String> codeUrl = new HashMap<>();
//        if (channel == null) {
//            return null;
//        }
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean(Class.forName(channel.getApi2()));
//        return service.bindMainAccount(id);
//    }
//
//
//    @RequestMapping(value = "/unbindAccount", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, String> unbindAccount(int id) throws ClassNotFoundException {
//        PayCanAccount childAccount = payAccountService.getAccountById(id + "");
//        PayChannel channel = payChannelService.getChannelById(childAccount.getChannelId());
//        Map<String, String> codeUrl = new HashMap<>();
//        if (channel == null) {
//            return null;
//        }
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean(Class.forName(channel.getApi2()));
//        return service.unBindMainAccount(id);
//    }
//
//    @RequestMapping(value = "/payQuery", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, String> query(HttpServletRequest request,int id) throws ClassNotFoundException {
//        QueueType queueType = payQueueService.getQueueTypebyId((id));
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean(Class.forName(queueType.getApi2()));
//
//        return service.query(id, IpUtil.getIpAddress(request));
//    }
//
//
//    @RequestMapping(value = "/addAccount/{channnelId}", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, String> addAccount(@PathVariable int channnelId,
//                                   HttpServletRequest request) throws ClassNotFoundException {
//
//        PayChannel channel = payChannelService.getChannelById(channnelId);
//
//        Map<String, String> params = new HashMap();
//        Map requestParams = request.getParameterMap();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            params.put(name, valueStr);
//
//        }
//
//
//        if (channel == null) {
//            return null;
//        }
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean(Class.forName(channel.getApi2()));
//        return service.addAccount(params);
//    }
//
//
//    @RequestMapping(value = "/updateAccount/{channnelId}", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, String> updateAccount(@PathVariable int channnelId, HttpServletRequest request) throws ClassNotFoundException {
//
//        PayChannel channel = payChannelService.getChannelById(channnelId);
//        //获取支付宝POST过来反馈信息
//        Map<String, String> params = new HashMap();
//        Map requestParams = request.getParameterMap();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");
//
//
//            params.put(name, valueStr);
//
//        }
//        if (channel == null) {
//            return null;
//        }
//        IOrderService service =
//                (IOrderService) SpringContextUtil.getBean(Class.forName(channel.getApi2()));
//        return service.updateAccount(params);
//    }
//
//
//    @RequestMapping(value = "/orderSettle/{remark}/{tradeNo}/{api}")
//    public @ResponseBody
//    Map<String, String> orderSettle(HttpServletRequest request,
//                                    @PathVariable String remark, @PathVariable String tradeNo, @PathVariable String api)
//            throws ClassNotFoundException {
//        System.out.println(api);
//
//
//        IOrderService service
//                = (IOrderService) SpringContextUtil.getBean(Class.forName("com.mfypay.pay.order." + api));
//
//        return service.orderSettle(remark, tradeNo);
//
//    }
//    @Resource
//    AliUtil aliUtil;
//    @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
//    public @ResponseBody
//    Map<String, String> getUserId(String  auth_code,String app_id)  {
//        return  aliUtil.getUserId(auth_code,app_id);
//    }
//
//    Logger logger =Logger.getLogger(this.getClass().getSimpleName());
//
//
//    /**
//     * 猫池
//     * @return
//     */
//    @RequestMapping(value = "/getSms", method = RequestMethod.POST)
//    public @ResponseBody
//       Map<String,String>  getSms(HttpServletRequest request){
//        String phone = request.getParameter("phone");
//        String content = request.getParameter("content");
//        logger.info(phone + ",接收到短信：" + content);
//        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(content)) {
//            return null;
//        }
//
//
//
//        String verCode = "";
//        Pattern pattern = Pattern.compile("\\d{6}");
//        Matcher matcher = pattern.matcher(content);
//        if (matcher.find()) {
//            verCode = matcher.group();
//
//            payAccountService.updateVerCode(verCode,phone);
//        }
//       return  new HashMap<>();
//    }
//
//
//
//
//
//    @RequestMapping(value = "/index")
//    public @ResponseBody
//    Map<String,String>  get(HttpServletRequest request){
//
//        return  new HashMap<>();
//    }
//
//}
