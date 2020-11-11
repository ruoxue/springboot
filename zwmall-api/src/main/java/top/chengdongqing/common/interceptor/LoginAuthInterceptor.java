package top.chengdongqing.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.model.User;

/**
 * 未登录拦截器
 * 
 * @author Luyao
 *
 */
public class LoginAuthInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		Controller c = inv.getController();

		// 获取token
		String token = c.getHeader(Constant.TOKEN) != null ? c.getHeader(Constant.TOKEN) : c.get(Constant.TOKEN);
		System.out.println(token);
		if (StrKit.isBlank(token)) {
			c.renderError(400);
			return;
		}

		// 获取登录信息
		User loginUser = User.getLoginUser(token);
		System.out.println(loginUser);
		if (loginUser == null || loginUser.isDisabled()) {
			c.renderError(403);
		} else {
			inv.invoke();
		}
	}
}
