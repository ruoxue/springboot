package top.chengdongqing.common.kit;

import com.jfinal.kit.Ret;

import top.chengdongqing.common.config.Constant;

/**
 * 错误消息相关工具类
 */
public class Fail {

	/**
	 * 设置并返回错误消息
	 * 
	 * @param msg
	 * @return
	 */
	public static Ret setMsg(String msg) {
		return Ret.fail(Constant.MSG, msg);
	}

	/**
	 * 常用错误消息
	 */
	public interface Msg {
		String PARAM_EMPTY = "参数为空";
		String PARAM_ERROR = "参数错误";
		String SAVE_FAIL = "新增失败";
		String UPDATE_FAIL = "修改失败";
		String DELETE_FAIL = "删除失败";
		String OPERATION_FAIL = "操作失败";
		String SUBMIT_FAIL = "提交失败";
		String REQUEST_FAIL = "请求失败";
		String UPLOAD_FAIL = "上传失败";
		String QUERY_FAIL = "查询失败";
		String PERMISSION_DENIED = "权限不足";
	}
}
