package top.chengdongqing.portal.user.security.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.sender.Sender;

/**
 * 找回密码参数校验
 * 
 * @author Luyao
 *
 */
public class RetrievePasswordValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验账号格式
		validateRegex("account", User.Pattern.ACCOUNT, Constant.MSG, "账号格式错误");

		// 校验验证码是否为空
		validateRequired("captcha", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验密码格式
		validateRegex("password", User.Pattern.PASSWORD, Constant.MSG, "密码格式错误");

		// 校验验证码是否正确，先判断账号类型
		String account = c.get("account");
		String captcha = c.get("captcha");
		if (account.matches(User.Pattern.PHONE)) {
			if (!Sender.verifyCaptcha(account, captcha)) {
				addError(Constant.MSG, "验证码错误");
			}
		} else {
			if (!Sender.verifyCaptcha(account, captcha)) {
				addError(Constant.MSG, "验证码错误");
			}
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
