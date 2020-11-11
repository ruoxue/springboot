package top.chengdongqing.portal.user.address.validator;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.User;

/**
 * 更新地址参数校验
 * 
 * @author Luyao
 *
 */
public class AddressUpdateValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验地址id
		validateRequired("id", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验姓名
		validateRegex("name", User.Pattern.NAME, Constant.MSG, "收货人姓名格式错误");

		// 校验手机号
		if (StrKit.notBlank(c.get("phone"))) {
			validateRegex("phone", User.Pattern.PHONE, Constant.MSG, "收货人手机号格式错误");
		}

		// 校验地址
		validateRequired("province", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		validateRequired("city", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		validateRequired("district", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		validateRequired("address", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验标签
		validateString("label", 0, 10, Constant.MSG, "标签不能超过10个字符");
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
