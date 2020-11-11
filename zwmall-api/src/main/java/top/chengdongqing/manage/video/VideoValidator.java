package top.chengdongqing.manage.video;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;

/**
 * 视频参数校验
 * 
 * @author Luyao
 *
 */
public class VideoValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 视频名称
		validateRequired("name", Constant.MSG, Fail.Msg.PARAM_EMPTY);

		// 视频地址
		validateUrl("videoUrl", Constant.MSG, "视频播放地址错误");

		// 封面地址
		validateUrl("coverUrl", Constant.MSG, "视频封面地址错误");
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}
