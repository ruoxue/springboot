package com.wowotou.payservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
    public static String GetCenter(String str, String startStr, String endStr) {


        String newStr = str.substring(str.indexOf(startStr + " = "),
                str.indexOf(endStr, str.indexOf(startStr + " = "))).replace("\"", "").
                replace(startStr, "").replace("=", "").trim();
        return newStr;
    }


    public static String getMeCenter(String str, String startStr, String endStr) {


        String newStr = str.substring(str.indexOf(startStr ),
                str.indexOf(endStr, str.indexOf(startStr  ))).replace("\"", "").
                replace(startStr, "").trim();
        return newStr;
    }


    public static String replaceBlank(String str) {

        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);

            dest = m.replaceAll("");

        }
        return dest;

    }
}
