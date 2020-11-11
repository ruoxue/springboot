package top.chengdongqing.portal.order.comment.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;

/**
 * 商品评价参数校验
 * 
 * @author Luyao
 *
 */
public class GoodsCommentValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 校验订单号
		validateRequired("orderNo", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验商品id
		validateInteger("skuId", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 校验商品评分
		validateDouble("score", 1, 5, Constant.MSG, Fail.Msg.PARAM_EMPTY);
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
