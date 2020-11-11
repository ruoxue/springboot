package top.chengdongqing.portal.user.security.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.render.CaptchaRender;

/**
 * 绑定邮箱时发送邮件参数校验
 * 
 * @author Luyao
 *
 */
public class SendCaptchaForBindEmailValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验邮箱格式
		validateEmail("email", Constant.MSG, "邮箱格式错误");

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
