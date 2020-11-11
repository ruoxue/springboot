package top.chengdongqing.manage.order;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;

/**
 * 确认已发货时参数校验
 * 
 * @author Luyao
 *
 */
public class ShippedValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验订单id
		validateInteger("orderId", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验快递公司名称
		validateRequired("name", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验快递公司网址
		validateUrl("linkUrl", Constant.MSG, Fail.Msg.PARAM_ERROR);

		// 校验快递单号
		validateString("waybillNo", 8, 20, Constant.MSG, Fail.Msg.PARAM_ERROR);
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
