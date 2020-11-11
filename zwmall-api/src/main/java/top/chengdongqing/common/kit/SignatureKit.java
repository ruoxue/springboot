package top.chengdongqing.common.kit;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.jfinal.kit.Base64Kit;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;

/**
 * 数据签名工具类
 * 
 * @author Luyao
 *
 */
public class SignatureKit {

	/**
	 * MD5签名
	 * 
	 * @param params
	 * @return
	 */
	public static String md5Sign(Map<String, String> params) {
		return HashKit.md5(buildParamsStr(params));
	}

	/**
	 * SHA256WithRSA签名
	 * 
	 * @param content
	 * @param key
	 * @return
	 */
	public static String rsa256Sign(Map<String, String> params, String key) {
		String content = buildParamsStr(params);
		try {
			// 获取指定算法的签名实例
			Signature signature = Signature.getInstance("SHA256WithRSA");
			// 获取指定算法的密钥工厂
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			// 将私钥解码
			byte[] keyBytes = Base64.getDecoder().decode(key.getBytes());
			// 生成私钥
			PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
			// 用私钥初始化签名
			signature.initSign(privateKey);
			// 更新要签名的内容
			signature.update(content.getBytes(Constant.CHARSET));
			// 执行签名并用base64编码
			return Base64Kit.encode(signature.sign());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * SHA256WithRSA验签
	 * 
	 * @param key
	 * @param sign
	 * @return
	 */
	public static boolean rsa256Verify(Map<String, String> params, String key, String sign) {
		String content = buildParamsStr(params);
		try {
			// 获取指定算法的签名实例
			Signature signature = Signature.getInstance("SHA256WithRSA");
			// 获取指定算法的密钥工厂
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			// 获取BASE64编码器
			Decoder decoder = Base64.getDecoder();
			// 将公钥解码
			byte[] keyBytes = decoder.decode(key.getBytes());
			// 生成公钥
			PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(keyBytes));
			// 初始化校验
			signature.initVerify(publicKey);
			// 更新签名的内容
			signature.update(content.getBytes(Constant.CHARSET));
			// 校验签名是否一致
			return signature.verify(decoder.decode(sign.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * HMAC-SHA1签名
	 * 
	 * @param params
	 * @param key
	 * @return
	 */
	public static String sha1HmacSign(Map<String, String> params, String key) {
		// 获取符合POP规则的参数字符串
		String content = buildPopParamsStr(params);

		// 定义摘要算法
		String algorithm = "HmacSHA1";
		try {
			// 获取摘要实例
			Mac mac = Mac.getInstance(algorithm);
			// 加载密钥
			mac.init(new SecretKeySpec((key + "&").getBytes(Constant.CHARSET), algorithm));
			// 执行消息摘要
			byte[] signData = mac.doFinal(content.getBytes(Constant.CHARSET));
			// base64编码
			return Base64Kit.encode(signData);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 构建符合POP规则的参数字符串
	 * 
	 * @param params
	 * @return
	 */
	private static String buildPopParamsStr(Map<String, String> params) {
		// 构建键值对字符串
		String paramsStr = buildParamsStr(params, true);

		// 拼接符合POP规则的字符串
		StringBuilder sb = new StringBuilder("GET");
		sb.append("&").append(popUrlEncode("/")).append("&");
		sb.append(popUrlEncode(paramsStr));

		return sb.toString();
	}

	public static String buildParamsStr(Map<String, String> params) {
		return buildParamsStr(params, false);
	}

	/**
	 * 构建键值对参数字符串
	 * 
	 * @param params
	 * @return
	 */
	private static String buildParamsStr(Map<String, String> params, boolean popEncode) {
		// 将map转为有序的treemap
		SortedMap<String, String> sortedParams = new TreeMap<String, String>(params);

		// 所有参数的字符串集合
		StringBuilder sb = new StringBuilder();
		sortedParams.forEach((key, value) -> {
			if (StrKit.notBlank(value) && !key.equals("key") && !key.equals("sign")) {
				sb.append(key).append("=").append(popEncode ? popUrlEncode(value) : value).append("&");
			}
		});
		// 将key放在最后，仅微信支付
		if (params.containsKey("key")) {
			sb.append("key").append("=").append(params.get("key")).append("&");
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * 符合POP规则的特殊编码
	 * 
	 * @param value
	 * @return
	 */
	private static String popUrlEncode(String value) {
		return URLEncoder.encode(value, Charset.forName(Constant.CHARSET)).replace("+", "%20").replace("*", "%2A")
				.replace("%7E", "~");
	}
}
