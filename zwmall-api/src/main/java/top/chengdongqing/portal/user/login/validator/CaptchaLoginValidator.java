package top.chengdongqing.portal.user.login.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.sender.SmsSender;

/**
 * 验证码登录参数校验
 * 
 * @author Luyao
 *
 */
public class CaptchaLoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验手机号格式
		validateRegex("phone", User.Pattern.PHONE, Constant.MSG, "手机号错误");

		// 校验验证码格式
		validateRegex("captcha", User.Pattern.CAPTCHA, Constant.MSG, "验证码错误");

		// 校验验证码是否正确
		if (!SmsSender.verifyCaptcha(c.get("phone"), c.get("captcha"))) {
			addError(Constant.MSG, "验证码错误");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
