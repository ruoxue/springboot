package top.chengdongqing.portal.user.profile;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.model.User;

/**
 * 个人资料校验
 * 
 * @author Luyao
 *
 */
public class ProfileValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验昵称
		validateRegex("name", User.Pattern.NAME, Constant.MSG, "昵称格式错误");

		// 校验性别
		validateInteger("gender", 1, 2, Constant.MSG, "请选择性别");

		// 校验地区
		validateString("region", 0, 30, Constant.MSG, "请选择正确的地区");

		// 校验签名
		validateString("motto", 0, 30, Constant.MSG, "签名不能超过30个字符");
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
