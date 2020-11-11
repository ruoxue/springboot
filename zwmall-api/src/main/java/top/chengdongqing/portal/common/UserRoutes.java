package top.chengdongqing.portal.common;

import com.jfinal.config.Routes;

import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.portal.user.address.AddressController;
import top.chengdongqing.portal.user.favorite.FavoriteController;
import top.chengdongqing.portal.user.login.LoginController;
import top.chengdongqing.portal.user.profile.ProfileController;
import top.chengdongqing.portal.user.register.RegisterController;
import top.chengdongqing.portal.user.security.SecurityController;

/**
 * 用户相关路由
 * 
 * @author Luyao
 *
 */
public class UserRoutes extends Routes {

	@Override
	public void config() {
		// 未登录拦截
		addInterceptor(new LoginAuthInterceptor());

		add("login", LoginController.class);
		add("register", RegisterController.class);
		add("security", SecurityController.class);
		add("profile", ProfileController.class);
		add("address", AddressController.class);
		add("favorite", FavoriteController.class);
	}
}
