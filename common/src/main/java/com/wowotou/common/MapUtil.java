package com.wowotou.common;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil {

    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }


    public static String getParamStr(Map<String, String> map) {
        Map<String, String> resultMap = sortMapByKey(map);    //按Key进行排序
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if (sb.length() >= 1) {
            return sb.substring(0, sb.length() - 1);
        } else {
            return "";
        }

    }

    public static Map<String, String> StrToMapTrim(String cookie) {
        Map<String, String> map = new HashMap<>();

        for (String s : cookie.split(";")) {

            String[] split1 = s.split("=");
            if (split1.length > 1) {
                map.put(split1[0].trim(), (s.replaceAll(split1[0] + "=", "")));
            }
        }

        return map;

    }

    public static Map<String, String> StrToMap(String cookie) {
        Map<String, String> map = new HashMap<>();

        for (String s : cookie.split(";")) {

            String[] split1 = s.split("=");
            if (split1.length > 1) {
                if (split1[0].equals("userAgent")) {
                    map.put(split1[0], URLEncoder.encode("Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16C50 NebulaSDK/1.8.100112 Nebula PSDType(1) AlipayDefined(nt:WIFI,ws:320|504|2.0) AliApp(AP/10.1.52.6006) AlipayClient/10.1.52.6006 Alipay Language/zh-Hans"));
                }
                map.put(split1[0], (s.replaceAll(split1[0] + "=", "")));
            }
        }

        return map;

    }


    public static Map<String, String> Str2Map(String redirect) {

        if (redirect.indexOf("?") != -1) {
            redirect = redirect.split("\\?")[1];
        }
        redirect = URLDecoder.decode(URLDecoder.decode(redirect)).trim();


        String[] split = redirect.split("&");
        Map<String, String> map = new HashMap<>();

        for (String s : split) {

            String[] split1 = s.split("=");
            if (split1.length > 1) {
                map.put(split1[0], URLDecoder.decode(split1[1]));
            }
        }

        return map;

    }

    /**
     * https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2017053107394231&scope=auth_base&redirect_uri=http://sdpayweb.js96008.com/qrcwg/webservice/zfb/authcode?md5=29a45a9dce1b14812235299cca313959&sweeptime=1567385102574&transid=29a9045ae4ad40bbbff65e4d9aed1997&channelcode=002&ShopSeq=mnt1172019080815524746600000&MerchantId=3210250401A0000339&ShopName=%E8%BD%A6%E8%8A%AF%E5%87%80%E6%B1%BD%E8%BD%A6%E7%BB%B4%E4%BF%AE%E7%BE%8E%E5%AE%B9&IsMainShop=0&state=1
     *
     * @param redirect
     * @return
     */
    public static MultiValueMap<String, String> Str2mvMap(String redirect) {

        if (redirect.indexOf("?") != -1) {
            String[] split = redirect.split("\\?");
            if (split.length == 2) {
                redirect = redirect.split("\\?")[1];
            } else if (split.length == 3) {
                redirect = redirect.split("\\?")[1] + "&" + redirect.split("\\?")[2];
            }

        }
        redirect = URLDecoder.decode(URLDecoder.decode(redirect)).trim();


        String[] split = redirect.split("&");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        for (String s : split) {

            String[] split1 = s.split("=");
            if (split1.length > 1) {
                if (split1[0].equals("redirect_uri")) {
                    continue;
                }
                map.add(split1[0], URLDecoder.decode(split1[1]));
            }
        }

        return map;

    }

}
