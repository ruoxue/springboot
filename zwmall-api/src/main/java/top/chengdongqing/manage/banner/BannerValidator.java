package top.chengdongqing.manage.banner;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Banner;

/**
 * 轮播图参数校验
 * 
 * @author Luyao
 *
 */
public class BannerValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 图片地址
		validateUrl("pictureUrl", Constant.MSG, Fail.Msg.PARAM_ERROR);

		// 链接模式
		validateInteger("linkMode", 0, 1, Constant.MSG, Fail.Msg.PARAM_ERROR);

		// 链接地址
		if (c.getInt("linkMode") == 0 && StrKit.isBlank(c.get("goodsId"))) {
			addError(Constant.MSG, Fail.Msg.PARAM_ERROR);
		}
		if (c.getInt("linkMode") == 1) {
			if (StrKit.isBlank(c.get("linkUrl"))) {
				addError(Constant.MSG, Fail.Msg.PARAM_ERROR);
			} else {
				validateUrl("linkUrl", Constant.MSG, "链接格式错误");
			}
		}

		// 类型
		validateRequired("type", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		String type = c.get("type");
		// 类型是否存在
		if (!Banner.Type.hasType(type)) {
			addError(Constant.MSG, Fail.Msg.PARAM_ERROR);
		}
		// 类型为商品类别广告时，必须包含商品类别id
		if (type.equals(Banner.Type.CATEGORY)) {
			validateRequired("categoryId", Constant.MSG, Fail.Msg.PARAM_EMPTY);
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
