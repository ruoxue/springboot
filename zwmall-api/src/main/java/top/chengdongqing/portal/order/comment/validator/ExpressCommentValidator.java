package top.chengdongqing.portal.order.comment.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;

/**
 * 快递评价参数校验
 * 
 * @author Luyao
 *
 */
public class ExpressCommentValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验订单号
		validateRequired("orderNo", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验包装评分
		validateDouble("packagingScore", 1, 5, Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验速度评分
		validateDouble("speedScore", 1, 5, Constant.MSG, Fail.Msg.PARAM_EMPTY);
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
