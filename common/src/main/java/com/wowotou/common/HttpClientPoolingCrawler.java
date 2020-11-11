package com.wowotou.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientPoolingCrawler {
    private static int SOCKET_TIMEOUT = 30000;//设置等待数据超时时间30s

    private static int REQUEST_TIMEOUT = 30000;//从连接池获取连接超时时间30s

    private static int CONNECT_TIMEOUT = 30000;//连接超时时间30s


    private CloseableHttpClient client = HttpClientFactory.createClient();
    private String url;
    private HttpHost proxy;
    private Map<String, String> headers;
    private Map<String, String> data;
    private String json;
    private String charset = "utf-8";
    private HttpContext httpContext;

    private HttpClientPoolingCrawler() {

    }

    public static HttpClientPoolingCrawler custom() {
        return new HttpClientPoolingCrawler();
    }

    public HttpClientPoolingCrawler url(String url) {
        this.url = url;
        return this;
    }

    public HttpClientPoolingCrawler client(CloseableHttpClient client) {
        this.client = client;
        return this;
    }

    public HttpClientPoolingCrawler proxy(HttpHost proxy) {
        this.proxy = proxy;
        return this;
    }

    public HttpClientPoolingCrawler headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public HttpClientPoolingCrawler data(Map<String, String> data) {
        this.data = data;
        return this;
    }

    public HttpClientPoolingCrawler json(String json) {
        this.json = json;
        return this;
    }

    public HttpClientPoolingCrawler charset(String charset) {
        this.charset = charset;
        return this;
    }

    public HttpClientPoolingCrawler context(HttpContext httpContext) {
        this.httpContext = httpContext;
        return this;
    }

    public HttpCustomResponse get() throws Exception {
        return deal(false);
    }

    public HttpCustomResponse post() throws Exception {
        return deal(true);
    }

    private HttpCustomResponse deal(boolean isPost) throws Exception {
        HttpCustomResponse customResponse = new HttpCustomResponse();
        HttpRequestBase hrb = null;
        CloseableHttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        try {
            CloseableHttpClient client = null == this.client ? HttpClients.createDefault() : this.client;
            hrb = isPost ? new HttpPost(url) : new HttpGet(url);

            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> e : headers.entrySet()) {
                    hrb.addHeader(e.getKey(), e.getValue());
                }
            }

            hrb.setConfig(generateRequestConfig());

            if (isPost) {
                if (!StringUtils.isEmpty(json)) {
                    StringEntity stringEntity = new StringEntity(json, charset);
                    stringEntity.setContentType("application/json");
                    ((HttpPost) hrb).setEntity(stringEntity);
                } else if (null != data && !data.isEmpty()) {
                    List<NameValuePair> paramList = new ArrayList<>();
                    for (Map.Entry<String, String> e : data.entrySet()) {
                        paramList.add(new BasicNameValuePair(e.getKey(), e.getValue()));
                    }
                    UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(paramList, charset);
                    ((HttpPost) hrb).setEntity(paramEntity);
                }
            }

            httpResponse = client.execute(hrb, httpContext);

            httpEntity = httpResponse.getEntity();

            customResponse.setResponseBytes(EntityUtils.toByteArray(httpEntity));
            customResponse.setStatusCode(httpResponse.getStatusLine().getStatusCode());
            customResponse.setCharset(this.charset);
            customResponse.setHeaders(httpResponse.getAllHeaders());
            customResponse.setResponseBody(new String(customResponse.getResponseBytes(), charset));

        } catch (Exception e) {
            throw e;
        } finally {
            EntityUtils.consume(httpEntity);
            if (null != httpResponse) httpResponse.close();
        }

        return customResponse;
    }

    private RequestConfig generateRequestConfig() {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom()
                .setConnectTimeout(SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setCookieSpec(CookieSpecs.STANDARD)
                .setRedirectsEnabled(true)
                .setProxy(proxy);
        return requestConfigBuilder.build();
    }

    public HttpClientPoolingCrawler domain(String domain) throws Exception {
        if(null != httpContext) {
            BasicCookieStore newBasicCookieStore = new BasicCookieStore();
            CookieStore cookieStore = (CookieStore) httpContext.getAttribute(ClientContext.COOKIE_STORE);
            List<Cookie> cookies = cookieStore.getCookies();
            for (Cookie cookie : cookies) {
                BasicClientCookie basicClientCookie = new BasicClientCookie(cookie.getName(), cookie.getValue());
                basicClientCookie.setDomain(domain);
                basicClientCookie.setPath(cookie.getPath());
                basicClientCookie.setExpiryDate(cookie.getExpiryDate());
                newBasicCookieStore.addCookie(basicClientCookie);
            }
            httpContext.setAttribute(ClientContext.COOKIE_STORE, newBasicCookieStore);
        }
        return this;
    }
}
