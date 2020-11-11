package top.chengdongqing.common.config;

import com.jfinal.kit.PropKit;

/**
 * 核心常量类
 * 
 * @author Luyao
 *
 */
public class Constant {

	// 统一字符编码格式
	public static final String CHARSET = "utf-8";
	// 返回给前端消息的键
	public static final String MSG = "msg";
	// 用户登录令牌的键
	public static final String TOKEN = "token";
	// 是否为开发模式
	public static final boolean DEV_MODE = PropKit.use(ConfigFile.APPLICATION).getBoolean("undertow.devMode", false);
	// 文件存放基础路径
	public static final String UPLOAD_BASE_PATH = DEV_MODE ? PropKit.get("upload.path.dev") : PropKit.get("upload.path.online");

	/**
	 * 通用状态
	 */
	public interface Status {
		// 启用
		int ENABLED = 0;
		// 禁用
		int DISABLED = 1;
	}

	/**
	 * 配置文件地址
	 */
	public interface ConfigFile {
		// 核心配置
		String APPLICATION = "config/application.txt";
		// 支付宝支付配置
		String ALIPAY = "config/payment/alipay.txt";
		// 微信支付配置
		String WECHAT = "config/payment/wechat.txt";
		// 短信配置
		String SMS = "config/sender/sms.txt";
		// 邮箱配置
		String EMAIL = "config/sender/email.txt";
		// 对象存储配置
		String OSS = "config/uploader/oss.txt";
	}

	/**
	 * 缓存的键名
	 */
	public interface CacheKey {
		// 登录用户
		String LOGIN_USER = "loginUser";
		// 媒体信息
		String MEDIA = "media";
	}
}
