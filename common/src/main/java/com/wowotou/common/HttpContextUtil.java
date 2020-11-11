package com.wowotou.common;

import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpContextUtil {

    private static final Map<String, HttpContext> MAP =  new ConcurrentHashMap<>();

    public static HttpContext getContext(String uid){
        HttpContext context = MAP.get(uid);
        if(null==context){
            context = HttpClientContext.create();
            MAP.put(uid,context);
        }

        return context;
    }
}
