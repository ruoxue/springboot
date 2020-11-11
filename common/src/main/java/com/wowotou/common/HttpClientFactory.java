package com.wowotou.common;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public class HttpClientFactory {
    /**
     * client池管理器
     */
    private static PoolingHttpClientConnectionManager manager;

    private static int POOL_SIZE = 100;//连接池最大连接数

    private static int MAX_PER_ROUTE = 200;//最大路由数

    private static CloseableHttpClient client;


    public static PoolingHttpClientConnectionManager getConnectionManager() {
        return manager;
    }


    static {
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(null, (a, b) -> true).build();
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", sslSocketFactory)
                    .build();

            manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            manager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
            manager.setMaxTotal(POOL_SIZE);
            //handshake timeout，采用默认值60s
            manager.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(60000).build());

            HttpClientBuilder clientBuilder = HttpClientBuilder.create()
                    .setConnectionManager(manager)
                    .setKeepAliveStrategy(generateKeepAliveStrategy())
                    .disableAutomaticRetries();//禁用重试
            client = clientBuilder.build();
        } catch (Exception e) {
            //log.error("init httpclientmanger get error:{}", e);
        }
    }

    private static ConnectionKeepAliveStrategy generateKeepAliveStrategy(){
        return  new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                HeaderElementIterator it = new BasicHeaderElementIterator
                        (response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    HeaderElement he = it.nextElement();
                    String param = he.getName();
                    String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase
                            ("timeout")) {
                        return Long.parseLong(value) * 1000;
                    }
                }
                return 60 * 1000;//如果没有约定，则默认定义时长为60s
            }
        };
    }


    private HttpClientFactory() {

    }

    public static CloseableHttpClient createClient() {
        return client;
    }
}
