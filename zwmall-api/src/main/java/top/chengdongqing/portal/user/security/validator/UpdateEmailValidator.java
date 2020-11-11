package top.chengdongqing.portal.user.security.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.sender.Sender;

/**
 * 更新邮箱参数校验
 * 
 * @author Luyao
 *
 */
public class UpdateEmailValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验邮箱格式
		validateEmail("email", Constant.MSG, "邮箱格式错误");

		// 校验验证码
		validateRequired("captcha", Constant.MSG, "验证码错误");
		if (!Sender.verifyCaptcha(c.get("email"), c.get("captcha"))) {
			addError(Constant.MSG, "验证码错误");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
