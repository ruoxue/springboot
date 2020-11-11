package top.chengdongqing.common.controller;

import com.jfinal.core.Controller;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.IpKit;
import top.chengdongqing.common.model.User;

/**
 * 基础控制器
 * 
 * @author Luyao
 *
 */
public class BaseController extends Controller {

	/**
	 * 获取当前登录用户信息
	 * 
	 * @return
	 */
	protected User getUser() {
		return User.getLoginUser(getHeader(Constant.TOKEN));
	}

	/**
	 * 获取当前登录用户id
	 * 
	 * @return
	 */
	protected Integer getUserId() {
		User user = getUser();
		return user != null ? user.getId() : null;
	}

	/**
	 * 获取IP地址
	 * 
	 * @return
	 */
	protected String getIp() {
		return IpKit.getIp(getRequest());
	}
}
