package top.chengdongqing.portal.user.security.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.render.CaptchaRender;

/**
 * 绑定手机号时发送短信参数校验
 * 
 * @author Luyao
 *
 */
public class SendCaptchaForBindPhoneValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验手机号格式
		validateRegex("phone", User.Pattern.PHONE, Constant.MSG, "手机号格式错误");

		// 校验图片验证码
		validateRequired("captcha", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		validateRequired("key", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		if (!CaptchaRender.validate(c.get("key"), c.get("captcha"))) {
			addError(Constant.MSG, "图片验证码错误");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
