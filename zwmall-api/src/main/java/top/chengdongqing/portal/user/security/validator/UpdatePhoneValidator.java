package top.chengdongqing.portal.user.security.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.sender.Sender;

/**
 * 更新手机号参数校验
 * 
 * @author Luyao
 *
 */
public class UpdatePhoneValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验手机号格式
		validateRegex("phone", User.Pattern.PHONE, Constant.MSG, "手机号格式错误");

		// 校验验证码
		validateRequired("captcha", Constant.MSG, "验证码错误");
		if (!Sender.verifyCaptcha(c.get("phone"), c.get("captcha"))) {
			addError(Constant.MSG, "验证码错误");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
