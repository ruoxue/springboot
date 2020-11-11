package top.chengdongqing.common.kit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Map;
import java.util.stream.Collectors;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;

/**
 * http工具类
 * 
 * @author Luyao
 *
 */
public class HttpKit {

	/**
	 * 发送GET请求
	 * 
	 * @param url
	 * @return
	 */
	public static String get(String url) {
		return get(url, null);
	}

	/**
	 * 发送GET请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String get(String url, Map<String, String> params) {
		HttpRequest request = HttpRequest.newBuilder(URI.create(buildUrlWithParams(url, params)))
				.header("Content-Type", "application/x-www-form-urlencoded").GET().build();
		return send(request);
	}

	/**
	 * 给访问路径拼接参数
	 * 
	 * @param url
	 * @param queryParas
	 * @return
	 */
	private static String buildUrlWithParams(String url, Map<String, String> params) {
		if (params == null || params.isEmpty()) {
			return url;
		}

		StringBuilder sb = new StringBuilder(url);
		// 若已有参数则和之前的参数合并
		sb.append(url.indexOf('?') == -1 ? '?' : '&');

		// 循环拼接参数
		params.forEach((key, value) -> {
			if (StrKit.notBlank(value)) {
				value = URLEncoder.encode(value, Charset.forName(Constant.CHARSET));
				sb.append(key).append('=').append(value).append('&');
			}
		});

		// 去掉最后的&
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * 发送POST请求
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public static String post(String url, String data) {
		return post(url, data, null);
	}

	/**
	 * 发送POST请求
	 * 
	 * @param url
	 * @param data
	 * @param params
	 * @return
	 */
	public static String post(String url, String data, Map<String, String> params) {
		HttpRequest request = HttpRequest.newBuilder(URI.create(buildUrlWithParams(url, params)))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.POST(HttpRequest.BodyPublishers.ofString(data, Charset.forName(Constant.CHARSET))).build();
		return send(request);
	}

	/**
	 * 发送http请求
	 * 
	 * @param request
	 * @return
	 */
	private static String send(HttpRequest request) {
		HttpClient client = HttpClient.newHttpClient();
		try {
			return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 发送带本地证书的POST请求
	 * 
	 * @param url
	 * @param data
	 * @param cert
	 * @param password
	 * @return
	 */
	public static String postWithCert(String url, String data, File cert, char[] password) {
		HttpRequest request = HttpRequest.newBuilder(URI.create(url))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.POST(HttpRequest.BodyPublishers.ofString(data, Charset.forName(Constant.CHARSET))).build();

		try {
			// 实例化SSL上下文
			SSLContext sslContext = SSLContext.getInstance("TLS");
			// 实例化密钥管理工厂
			KeyManagerFactory keyManagerFactory = KeyManagerFactory
					.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			// 实例化密钥库
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			// 加载证书文件和密码
			keyStore.load(new FileInputStream(cert), password);
			// 初始化密钥管理工厂
			keyManagerFactory.init(keyStore, password);
			// 初始化SSL上下文
			sslContext.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());
			// 构建HTTP客户端实例
			HttpClient client = HttpClient.newBuilder().sslContext(sslContext).build();
			return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 读取字符流
	 * 
	 * @param request
	 * @return
	 */
	public static String readBuffer(HttpServletRequest request) {
		try (BufferedReader reader = request.getReader()) {
			return reader.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
