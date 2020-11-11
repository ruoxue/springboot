package top.chengdongqing.manage.admin.menu;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;

/**
 * 菜单参数校验
 * 
 * @author Luyao
 *
 */
public class MenuValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 菜单名称
		validateRequired("name", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 父菜单
		validateInteger("parentId", Constant.MSG, Fail.Msg.PARAM_ERROR);

		// 页面链接
		if (c.getInt("parentId") != 0) {
			validateRequired("pagePath", Constant.MSG, Fail.Msg.PARAM_EMPTY);
			if (!c.get("pagePath").startsWith("/")) {
				addError(Constant.MSG, "请输入正确的页面链接");
			}

			validateRequired("iconClass", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
