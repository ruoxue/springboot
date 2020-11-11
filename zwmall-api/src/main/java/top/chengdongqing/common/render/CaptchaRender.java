package top.chengdongqing.common.render;

import com.jfinal.captcha.Captcha;
import com.jfinal.kit.StrKit;

/**
 * 图片验证码渲染
 * 
 * @author Luyao
 *
 */
public class CaptchaRender extends com.jfinal.captcha.CaptchaRender {

	// 验证码的键
	private String captchaKey;

	public CaptchaRender(String captchaKey) {
		if (StrKit.isBlank(captchaKey)) {
			throw new IllegalArgumentException("The captchaKey can not be blank");
		}
		this.captchaKey = captchaKey;
	}

	@Override
	protected Captcha createCaptcha() {
		return new Captcha(captchaKey, getRandomString());
	}
}