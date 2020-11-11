package top.chengdongqing.manage.admin.login;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.model.User;

/**
 * 管理员登录参数校验
 * 
 * @author Luyao
 *
 */
public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验账号
		validateRegex("account", User.Pattern.ACCOUNT, Constant.MSG, "账号或密码错误");

		// 校验密码
		validateRegex("password", User.Pattern.PASSWORD, Constant.MSG, "账号或密码错误");
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
