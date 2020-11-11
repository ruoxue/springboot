//package com.wowotou.payservice.util;
//
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.HeaderIterator;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.NameValuePair;
//import org.apache.http.ParseException;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.CookieStore;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.protocol.HttpClientContext;
//import org.apache.http.cookie.Cookie;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.BasicCookieStore;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
//import org.apache.http.impl.client.DefaultRedirectStrategy;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.cookie.BasicClientCookie;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class HttpClient {
//
//    public CloseableHttpClient httpClient = null;
//    public HttpClientContext context = null;
//    public CookieStore cookieStore = null;
//    public RequestConfig requestConfig = null;
//
//    public HttpClient() {
//        context = HttpClientContext.create();
//        cookieStore = new BasicCookieStore();
//        // 配置超时时间（连接服务端超时1秒，请求数据返回超时2秒）
//        requestConfig = RequestConfig.custom().setConnectTimeout(120000).setSocketTimeout(60000).setConnectionRequestTimeout(60000).build();
//        // 设置默认跳转以及存储cookie
//        httpClient = HttpClientBuilder.create().setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy()).setRedirectStrategy(new DefaultRedirectStrategy()).setDefaultRequestConfig(requestConfig).setDefaultCookieStore(cookieStore).build();
//
//    }
//
//    /**
//     * http get
//     *
//     * @param url
//     * @return response
//     * @throws ClientProtocolException
//     * @throws IOException
//     */
//    public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
//        HttpGet httpget = new HttpGet(url);
//        CloseableHttpResponse response = httpClient.execute(httpget, context);
//        cookieStore = context.getCookieStore();
//        return response;
//    }
//
//    /**
//     * 獲取HTTP請求返回HTML信息
//     * .
//     *
//     * @param url
//     * @return
//     * @throws ClientProtocolException
//     * @throws IOException
//     * @author Administrator
//     * 2018年1月18日 Administrator
//     */
//    public String getHtml(String url) throws ClientProtocolException, IOException {
//        CloseableHttpResponse response = null;
//        try {
//            response = get(url);
//            return EntityUtils.toString(response.getEntity());
//        } finally {
//            if (response != null) {
//                response.close();
//            }
//        }
//    }
//
//    /**
//     * @return context属性
//     */
//    public HttpClientContext getContext() {
//        return context;
//    }
//
//    /**
//     * http post
//     *
//     * @param url
//     * @param parameters
//     *            form表单
//     * @return response
//     * @throws ClientProtocolException
//     * @throws IOException
//     */
//    public CloseableHttpResponse post(String url, String parameters, String body) throws ClientProtocolException, IOException {
//        HttpPost httpPost = new HttpPost(url);
//        if (!StringUtils.isEmpty(parameters)) {
//            List<NameValuePair> nvps = toNameValuePairList(parameters);
//            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
//        }
//
//        if (StringUtils.isNotEmpty(body)) {
//            httpPost.addHeader("Content-Type", "application/json");
//            StringEntity entity = null;
//            try {
//                entity = new StringEntity(body, "UTF-8");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            httpPost.setEntity(entity);// http post with xml data
//        }
//
//        CloseableHttpResponse response = httpClient.execute(httpPost, context);
//        cookieStore = context.getCookieStore();
//        return response;
//    }
//
//    @SuppressWarnings("unused")
//    private List<NameValuePair> toNameValuePairList(String parameters) {
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        String[] paramList = parameters.split("&");
//        for (String parm : paramList) {
//            int index = -1;
//            for (int i = 0; i < parm.length(); i++) {
//                index = parm.indexOf("=");
//                break;
//            }
//            String key = parm.substring(0, index);
//            String value = parm.substring(++index, parm.length());
//            nvps.add(new BasicNameValuePair(key, value));
//        }
//        System.out.println(nvps.toString());
//        return nvps;
//    }
//
//    /**
//     * 手动增加cookie
//     *
//     * @param name
//     * @param value
//     * @param domain
//     * @param path
//     */
//    public void addCookie(String name, String value, String domain, String path) {
//        BasicClientCookie cookie = new BasicClientCookie(name, value);
//        cookie.setDomain(domain);
//        cookie.setPath(path);
//        cookieStore.addCookie(cookie);
//    }
//
//    /**
//     * 把结果console出来
//     *
//     * @param httpResponse
//     * @throws ParseException
//     * @throws IOException
//     */
//    public void printResponse(HttpResponse httpResponse) throws ParseException, IOException {
//        // 获取响应消息实体
//        HttpEntity entity = httpResponse.getEntity();
//        // 响应状态
//        System.out.println("status:" + httpResponse.getStatusLine());
//        System.out.println("headers:");
//        HeaderIterator iterator = httpResponse.headerIterator();
//        while (iterator.hasNext()) {
//            System.out.println("\t" + iterator.next());
//        }
//        // 判断响应实体是否为空
//        if (entity != null) {
//            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                System.out.println(EntityUtils.toString(httpResponse.getEntity()));
//            }
//
//        }
//        System.out.println("------------------------------------------------------------------------------------------\r\n");
//    }
//
//    /**
//     * 把当前cookie从控制台输出出来
//     *
//     */
//    public void printCookies() {
//        System.out.println("headers:");
//        cookieStore = context.getCookieStore();
//        List<Cookie> cookies = cookieStore.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println("key:" + cookie.getName() + "  value:" + cookie.getValue());
//        }
//    }
//
//    /**
//     * 检查cookie的键值是否包含传参
//     *
//     * @param key
//     * @return
//     */
//    public boolean checkCookie(String key) {
//        cookieStore = context.getCookieStore();
//        List<Cookie> cookies = cookieStore.getCookies();
//        boolean res = false;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals(key)) {
//                res = true;
//                break;
//            }
//        }
//        return res;
//    }
//
//    /**
//     * 直接把Response内的Entity内容转换成String
//     *
//     * @param httpResponse
//     * @return
//     * @throws ParseException
//     * @throws IOException
//     */
//    public String toString(CloseableHttpResponse httpResponse) throws ParseException, IOException {
//        // 获取响应消息实体
//        HttpEntity entity = httpResponse.getEntity();
//        if (entity != null)
//            return EntityUtils.toString(entity);
//        else
//            return null;
//    }
//}
