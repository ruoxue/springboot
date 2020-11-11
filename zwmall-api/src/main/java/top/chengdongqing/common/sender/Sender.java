package top.chengdongqing.common.sender;

import com.jfinal.captcha.Captcha;
import com.jfinal.captcha.CaptchaCache;
import com.jfinal.kit.Ret;

/**
 * 发送消息抽象类
 * 
 * @author Luyao
 *
 */
public abstract class Sender {

	// 验证码缓存
	static final CaptchaCache cache = new CaptchaCache();

	/**
	 * 发送验证码
	 * 
	 * @param account
	 * @param template
	 * @return
	 */
	public abstract Ret sendCaptcha(String account, String template);

	/**
	 * 发送信息
	 * 
	 * @param account
	 * @param template
	 * @param content
	 * @return
	 */
	abstract Ret send(String account, String template, String content);

	/**
	 * 校验验证码
	 * 
	 * @param account
	 * @param code
	 * @return
	 */
	public static boolean verifyCaptcha(String account, String code) {
		Captcha captcha = cache.get(account);
		return captcha != null && !captcha.isExpired() && captcha.getValue().equals(code);
	}
}
