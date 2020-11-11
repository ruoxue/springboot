package top.chengdongqing.portal.user.security.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.render.CaptchaRender;

/**
 * 更新密码参数校验
 * 
 * @author Luyao
 *
 */
public class UpdatePwdValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验原密码格式
		validateRegex("oldPwd", User.Pattern.PASSWORD, Constant.MSG, "原密码格式错误");

		// 校验新密码格式
		validateRegex("newPwd", User.Pattern.PASSWORD, Constant.MSG, "新密码格式错误");

		// 校验验证码
		validateRequired("captcha", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		validateRequired("key", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		if (!CaptchaRender.validate(c.get("key"), c.get("captcha"))) {
			addError(Constant.MSG, "验证码错误");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
