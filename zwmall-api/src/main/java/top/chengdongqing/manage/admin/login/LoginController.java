package top.chengdongqing.manage.admin.login;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.AccessLimit;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.manage.common.AdminAuthInterceptor;

/**
 * 管理员登录控制器
 * 
 * @author Luyao
 *
 */
@Clear({ LoginAuthInterceptor.class, AdminAuthInterceptor.class })
public class LoginController extends BaseController {

	@Inject
	LoginService loginSrv;

	/**
	 * 管理员登录
	 * 
	 * @param account
	 * @param password
	 */
	@AccessLimit(expireTime = 60, times = 3)
	@Before({ POST.class, LoginValidator.class })
	public void index(String account, String password) {
		renderJson(loginSrv.login(account, password, getIp()));
	}
}
