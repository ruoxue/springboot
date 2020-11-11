import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class T {


    public static void main(String[] s) {






        Map<String, String> headers = new HashMap<String, String>();
        headers.put("origin", "http://iservice.10010.com");
        headers.put("x-requested-with", "XMLHttpRequest");
//        headers.put("Host", "iservice.10010.com");

//        headers.put(":authority", "iservice.10010.com");
        headers.put("Referer", "https://iservice.10010.com/e4/query/others/service_recharge.html");
        headers.put("User-Agent", "Mozilla%2f5.0+(Windows+NT+10.0%3b+WOW64)+AppleWebKit%2f537.36+(KHTML%2c+like+Gecko)+Chrome%2f80.0.3987.162+Safari%2f537.36");
        String url = "https://iservice.10010.com/e3/static/life/rechargeCardStateQuery?_=" + System.currentTimeMillis();

        String param = "idValue=982000482502190&checkCode=null";
        String cookie = "";    headers.put("cookie", cookie);
        headers.put("content-type","application/x-www-form-urlencoded;charset=UTF-8");
        testCallPost(url, param, headers);
    }


    private static void testCallPost(String url, String body, Map<String, String> header) {
        System.out.println("请求报文=" + body);
        // 创建默认的HTTP客户端对象
        HttpClient client = HttpClient.newHttpClient();
        // 创建一个自定义的HTTP请求对象
        HttpRequest.Builder builder = HttpRequest.newBuilder(URI.create(url)) // 待调用的url地址
                .POST(HttpRequest.BodyPublishers.ofString(body)) // 调用方式为POST，且请求报文为字符串
                 ;

        for (Map.Entry<String, String> entry : header.entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }

        // 设置头部参数，内容类型为json
        HttpRequest request = builder.build();

        try {
            // 客户端传递请求信息，且返回字符串形式的应答报文
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // 打印HTTP调用的应答状态码和应答报文
            System.out.println(String.format("应答状态码=%d, 应答报文=%s",
                    response.statusCode(), response.body()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
