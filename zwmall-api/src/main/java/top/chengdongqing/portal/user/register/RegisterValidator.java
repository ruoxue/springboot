package top.chengdongqing.portal.user.register;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.sender.Sender;

/**
 * 账号注册参数校验
 * 
 * @author Luyao
 *
 */
public class RegisterValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验手机号
		validateRegex("phone", User.Pattern.PHONE, Constant.MSG, "手机号格式错误");

		// 校验验证码
		validateRegex("captcha", User.Pattern.CAPTCHA, Constant.MSG, "验证码格式错误");

		// 校验密码
		validateRegex("password", User.Pattern.PASSWORD, Constant.MSG, "密码格式错误");

		// 校验验证码是否正确
		if (!Sender.verifyCaptcha(c.get("phone"), c.get("captcha"))) {
			addError(Constant.MSG, "验证码错误");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
