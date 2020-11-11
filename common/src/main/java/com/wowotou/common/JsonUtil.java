package com.wowotou.common;


import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;

public class JsonUtil<T> {
    public       T   fromJson(String param,Class<T> tClass){
     return    new Gson().fromJson(
                 (param),tClass);
    }

    public String toJsonStr(Map<String, String> body) {
            return new Gson().toJson(body);
    }
}
