//package com.wowotou.payservice.order;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.wowotou.payservice.annotation.APIShow;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@APIShow("策略")
//@Service
//public class StrategyService implements IOrderService {
//    @Resource
//    PayOrderService payOrderService;
//    @Resource
//    AdminService adminService;
//    @Resource
//    PayAccountService payAccountService;
//
//    @Resource
//    BankService bankService;
//    @Resource
//    PayMissOrderService payMissOrderService;
//
//    @Override
//    public Map<String, String> getCodeUrl(QueueType queue) {
//        return null;
//    }
//
//    @Override
//    public void query(QueryModel map) {
//
//    }
//
//    @Override
//    public Map<String, String> query(int id, String ip) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> bindMainAccount(int id) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> unBindMainAccount(int id) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> login(NeedLoginModel param) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> sendLoginSms(NeedLoginModel param) {
//        return null;
//    }
//
//    @Override
//    public String payNotify(Map<String, String> params, String ip) {
//        BankModel bankModel = bankService.getBankByBankWechat(params.get("username"));
//
//        String sign2 = com.mfypay.service.util.Md5.md5(com.mfypay.service.util.MapUtil.getParamStr(params));
//        String sign = params.get("sign");
//
//        params.remove("sign");
//        boolean verify_result = sign.equalsIgnoreCase(sign2);
//        if (!verify_result){
//            System.out.println("{\"code\":0}");
//        }
//
//        try {
//            long pub_time=System.currentTimeMillis()/1000;
//            try {
//                  pub_time=Long.valueOf(params.get("pub_time"));
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//            String out_trade_no = params.get("mark");
//            PayCanAccount account = null;
//
//            if (out_trade_no == null || "".equalsIgnoreCase(out_trade_no) ||
//                    "".equalsIgnoreCase(out_trade_no.trim()) ||
//                    "null".equalsIgnoreCase(out_trade_no.trim())) {
//
//                String des = new String(org.apache.commons.net.util.Base64.decodeBase64(params.get("des")), "UTF-8");//
//                System.out.println("des" + des);
//
//                // String tem= "您尾号=的银行卡;交易时间：=\n ;交易金额：=元";
//                String tem = bankModel.getTemplate();// "尊敬的客户：\n\n您(.*)的银行卡\n交易对手方：(.*)\n交易(.*)\n交易类型：存入 (.*)\n交易金额：(.*\\d+(\\.\\d+)?元)\n近七日年化超4.08%！不用跑网点，平安养老金通30天抢购中，千元起购，期限灵活。产品非存款，投资需谨慎。点击即可购买。";
//
//                des = StrUtil.replaceBlank(des);
//                tem = StrUtil.replaceBlank(tem);
//                JsonObject jsonObject = new Gson().fromJson(tem, JsonObject.class);
//
//                String end3 = jsonObject.get("end").getAsString();
//                String time3 = jsonObject.get("time").getAsString();
//                String money3 = jsonObject.get("money").getAsString();
//
//                //{"end":"",}
//
//
//                String[] splitEnd = end3.split("-");
//                String end = StrUtil.getMeCenter(des, splitEnd[0], splitEnd[1]);
//                System.out.println("end" + end);
//
//                String[] split = money3.split("-");
//
//                String money = StrUtil.getMeCenter(des, split[0], split[1]);
//
//                money=money.replace(",","");
//
//
//                Pattern p1 = Pattern.compile(time3);
//                Matcher m1 = p1.matcher(des);
//                System.out.println(m1.find());
//                String time = m1.group(0);
//
//                SimpleDateFormat sdf = new SimpleDateFormat(bankModel.getInfo());
//                Date parse = sdf.parse(time);
//
//
//                Calendar pubCalendar = TimeUtil.getCalenderByTime(pub_time);
//                pubCalendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//
//                Calendar instance = Calendar.getInstance();
//                instance.setTime(parse);
//                instance.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//                if (!(bankModel.getInfo().startsWith("y"))&&!(bankModel.getInfo().startsWith("Y"))){
//
//                    instance.set(Calendar.YEAR, pubCalendar.get(Calendar.YEAR));
//                }
//
//                if ((bankModel.getInfo().startsWith("H"))){
//
//                    instance.set(Calendar.MONTH, pubCalendar.get(Calendar.MONTH));
//
//                    instance.set(Calendar.DAY_OF_MONTH, pubCalendar.get(Calendar.DAY_OF_MONTH));
//                }
////                pubCalendar.setTimeZone(TimeZone.getTimeZone());
//                long times = instance.getTimeInMillis() / 1000;
//
//
//
//                String token = (params.get("token"));
//
//                AdminModel adminModel = adminService.getAdminByToken(token);
//
//
//                account = payAccountService.getAccountByEndUserId(end, bankModel.getId(), adminModel.getId());
//
//                if (account == null) {
//                    return "err";
//                }
//
//                if (adminModel == null) {
//                    return "err2";
//                }
//
//                PayQueue payQueue = payOrderService.getStrategyQueue(Double.valueOf(money),
//                        times, adminModel.getId(), account.getUserId(), account.getUnit());
//
//                if ((pub_time-90>times)||(pub_time+90<times)){
//                    Map<String, String> map = new HashMap<>();
//                    //mark,channelOrderId,userId,extra\
//
//                    map.put("mark", "时间解析出错");
//                    map.put("channelOrderId", params.get("no"));
//                    map.put("userId", account.getUserId());
//                    map.put("extra", params.get("extra"));
//                    map.put("ip", ip);
//                    map.put("money",money);
//                    map.put("mTime",String.valueOf(times));
//                    map.put("cTime",String.valueOf(pub_time));
//                    payMissOrderService.addMissOrder(map);
//
//
//                    return  "{\"code\":-1}";
//                }
//
//
//                if (payQueue == null||(!des.contains(bankModel.getKeyword()))) {
//
//
//                    Map<String, String> map = new HashMap<>();
//                    //mark,channelOrderId,userId,extra\
//
//
//                    map.put("mark", out_trade_no);
//                    map.put("channelOrderId", params.get("no"));
//                    map.put("userId", account.getUserId());
//                    map.put("extra", params.get("extra"));
//                    map.put("ip", ip);
//                    map.put("money",money);
//                    map.put("mTime",String.valueOf(times));
//                    map.put("cTime",String.valueOf(pub_time));
//                    payMissOrderService.addMissOrder(map);
//
//
//                    return "e";
//                }
//
//
//
//
//
//
//                out_trade_no = payQueue.getMark();
//            }
//            //支付宝交易号
//
//            String trade_no = new String(params.get("no").getBytes("ISO-8859-1"),
//                    "UTF-8");
//
//            //交易状态
//            String trade_status = new String(params.get("trade_status")
//                    .getBytes("ISO-8859-1"), "UTF-8");
//
//
//
//
//
//            if (verify_result && trade_status.equals("SUCCESS")) {
//                payOrderService.resultSuccess(out_trade_no, trade_no, trade_no,
//                        account.getUserId(), params.get("extra"), ip);
//
//                return params.get("mark");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "err4";
//
//
//    }
//
//    @Override
//    public Map<String, String> addAccount(Map<String, String> request) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> updateAccount(Map<String, String> request) {
//        return null;
//    }
//
//    @Override
//    public Map<String, String> orderSettle(String mark, String tradeNo) {
//        return null;
//    }
//}
