//package com.wowotou.payservice.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.google.gson.Gson;
//import com.mfypay.pay.bean.kb.KbOrderBean;
//import com.mfypay.pay.bean.kb.KbPriceModel;
//import com.mfypay.pay.bean.kb.KbPriceParam;
//import com.mfypay.pay.bean.kongbao.KdRetModel;
//import com.mfypay.pay.bean.pdd.PddMmsMOdel;
//import com.mfypay.pay.bean.pdd.SalePddAddressModel;
//import com.mfypay.pay.net.FetchUtil;
//import com.mfypay.service.util.MapUtil;
//import com.mfypay.service.util.Md5;
//import com.mfypay.service.util.NetUtil;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//
//import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class KbUtil {
//
//
//    public static KdRetModel.KdPriceEntity getKd() {
//        String url = "http://www.483kb.com/API/GetKd";
//
//        Map<String, String> map = new HashMap<>();
//        String sid =  System.currentTimeMillis()+"";
//        map.put("sid", sid);
//        System.out.println("xiaoming123465" + sid);
//        String sign = MD5("xiaoming" + MD5("123465", "16") + sid, "32");
//        System.out.println(sign);
//        map.put("sign", sign);
//        map.put("username", "xiaoming");
//        System.out.println(map);
//        System.out.println(new Gson().toJson(map));
//        String s = FetchUtil.PostJson(url, "", null,   (map),"",null,USERAGENT.ALIPAYUA);
//        System.out.println(s);
//        KdRetModel kdRetModel = new Gson().fromJson(s, KdRetModel.class);
//
//        List<KdRetModel.KdPriceEntity> kdPrice = kdRetModel.getKdPrice();
//
//
//        kdPrice.sort(new Comparator<KdRetModel.KdPriceEntity>() {
//            @Override
//            public int compare(KdRetModel.KdPriceEntity o1, KdRetModel.KdPriceEntity o2) {
//                return (int) (o1.getApiPrice() * 100 - o2.getApiPrice() * 100);
//            }
//        });
//        System.out.println(kdRetModel.getKdPrice().get(0).getApiPrice() + kdRetModel.getKdPrice().get(0).getKdName());
//
//        return kdRetModel.getKdPrice().get(0);
//    }
//
//
//    public static KbPriceModel.DataEntity loadCan() {
//
//
//        KbPriceParam priceParam = new KbPriceParam();
//
//
//        String s = KbUtil.loadMMS("getprice", priceParam);
//        KbPriceModel kbPriceModel = new Gson().fromJson(s, KbPriceModel.class);
//
//        List<KbPriceModel.DataEntity> data = kbPriceModel.getData();
//
//
//        data.sort(new Comparator<KbPriceModel.DataEntity>() {
//            @Override
//            public int compare(KbPriceModel.DataEntity o1, KbPriceModel.DataEntity o2) {
//                return (int) (o1.getPrice1() * 1000 - o2.getPrice1() * 1000);
//            }
//        });
//        System.out.println(data.get(0).getPlatform() + data.get(0).getPrice1());
//
//        return data.get(0);
//
//
//    }
//
//
//    public static String addKd(Object kbOrderBean) {
//        String url = "http://www.483kb.com/API/BuyKddh";
//        String s ="";// FetchUtil.PostJson(url, "", null,  (kbOrderBean),"",null,USERAGENT.ALIPAYUA);
//        return s;
//    }
//
//
//    public static String loadMMS(Object kbOrderBean) {
//        String logiType = "buykongbao";
//
//        return loadMMS(logiType, kbOrderBean);
//    }
//
//
//    public static String loadMMS(String logiType, Object kbOrderBean) {
//
//        String appKey = "xiaoxiaoming";
//        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Map<String, String> parammap = new HashMap();
//        String timestamp = s.format(new Date());
//        parammap.put("appKey", appKey);
//
//
//        parammap.put("orders", new Gson().toJson(kbOrderBean));
//        parammap.put("timestamp", timestamp);
//        parammap.put("logiType", logiType);
//        Set<String> set = new TreeSet<String>(new Comparator<String>() {
//            public int compare(String o1, String o2) {
//                return o1.substring(0, 1).compareTo(o2.substring(0, 1));
//            }
//        });
//        for (String m : parammap.keySet()) {
//            set.add(m);
//        }
//        StringBuffer signbuffer = new StringBuffer();
//        signbuffer.append(MD5("123465", "16"));
//        for (String ss : set) {
//            signbuffer.append(ss).append(parammap.get(ss));
//        }
//        signbuffer.append(MD5("123465", "16"));
//        parammap.put("sign", MD5(signbuffer.toString(), "32").toUpperCase());
//        System.out.println("===" + MapUtil.getParamStr(parammap) + "--");
//
//        return doPost("http://www.kongbao90.com/OrderSubmit/index.asp", (parammap));//  FetchUtil.PostForm("http://www.kongbao90.com/OrderSubmit/index.asp","",null,MapUtil.getParamStr(parammap),"",null);
//
//
//    }
//
//
//    public static String doPost(String url, Map<String, String> param) {
//        // 创建Httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpResponse response = null;
//        String resultString = "";
//        try {
//            // 创建Http Post请求
//            HttpPost httpPost = new HttpPost(url);
//            // 创建参数列表
//            if (param != null) {
//                List<NameValuePair> paramList = new ArrayList<>();
//                for (String key : param.keySet()) {
//                    paramList.add(new BasicNameValuePair(key, param.get(key)));
//                }
//                // 模拟表单
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "UTF-8");
//                httpPost.setEntity(entity);
//            }
//            // 执行http请求
//            response = httpClient.execute(httpPost);
//            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                response.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//        return resultString;
//    }
//
//
//    public static String MD5(String sourceStr, String flag) {
//        String result = "";// 通过result返回结果值
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");// 1.初始化MessageDigest信息摘要对象,并指定为MD5不分大小写都可以
//            md.update(sourceStr.getBytes());// 2.传入需要计算的字符串更新摘要信息，传入的为字节数组byte[],将字符串转换为字节数组使用getBytes()方法完成
//            byte b[] = md.digest();// 3.计算信息摘要digest()方法,返回值为字节数组
//
//            int i;// 定义整型
//            // 声明StringBuffer对象
//            StringBuffer buf = new StringBuffer("");
//            for (int offset = 0; offset < b.length; offset++) {
//                i = b[offset];// 将首个元素赋值给i
//                if (i < 0)
//                    i += 256;
//                if (i < 16)
//                    buf.append("0");// 前面补0
//                buf.append(Integer.toHexString(i));// 转换成16进制编码
//            }
//            result = buf.toString();// 转换成字符串
//            if (flag.equals("32")) {
//                System.out.println("MD5(" + sourceStr + ",32) = " + result);// 输出32位16进制字符串
//                return result;
//
//            } else {
//                System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));// 输出16位16进制字符串
//                return buf.toString().substring(8, 24);
//            }
//
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println(e);
//        }
//        return "";// 返回结果
//    }
//
//    public static String getFlow() {
//
//        String url = "http://www.wckongbao.cn/API/GetFlow";
//        Map<String, String> map = new HashMap<>();
//        String sid = System.currentTimeMillis()+"";
//        map.put("sid", sid);
//        System.out.println("xiaoming123465" + sid);
//        String sign = MD5("xiaoming" + MD5("123465", "16") + sid, "32");
//        System.out.println(sign);
//        map.put("sign", sign);
//        map.put("username", "xiaoming");
//        System.out.println(map);
//        System.out.println(new Gson().toJson(map));
//        String s = FetchUtil.PostJson(url, "", null,  (map),"",null,USERAGENT.ALIPAYUA);
//        System.out.println(s);
//        return s;
//
//
//    }
//
//
//    public static void buyFlxow(String username, String goods_link, String cat) {
//
//
//    }
//}
