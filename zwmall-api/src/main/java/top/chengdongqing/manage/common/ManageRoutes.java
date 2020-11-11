package top.chengdongqing.manage.common;

import com.jfinal.config.Routes;
import com.jfinal.core.Controller;

import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.manage.admin.administrator.AdministratorController;
import top.chengdongqing.manage.admin.login.LoginController;
import top.chengdongqing.manage.admin.menu.MenuController;
import top.chengdongqing.manage.admin.permission.PermissionController;
import top.chengdongqing.manage.admin.role.RoleController;
import top.chengdongqing.manage.banner.BannerController;
import top.chengdongqing.manage.goods.GoodsController;
import top.chengdongqing.manage.goods.brand.BrandController;
import top.chengdongqing.manage.goods.category.CategoryController;
import top.chengdongqing.manage.goods.comment.CommentController;
import top.chengdongqing.manage.goods.sku.SkuController;
import top.chengdongqing.manage.order.OrderController;
import top.chengdongqing.manage.statistic.StatisticController;
import top.chengdongqing.manage.user.UserController;
import top.chengdongqing.manage.video.VideoController;

/**
 * 后台路由配置
 * 
 * @author Luyao
 *
 */
public class ManageRoutes extends Routes {

	@Override
	public void config() {
		// 未登录拦截
		addInterceptor(new LoginAuthInterceptor());
		// 管理员权限拦截
		addInterceptor(new AdminAuthInterceptor());

		add("login", LoginController.class);
		add("menu", MenuController.class);
		add("category", CategoryController.class);
		add("brand", BrandController.class);
		add("goods", GoodsController.class);
		add("comment", CommentController.class);
		add("sku", SkuController.class);
		add("order", OrderController.class);
		add("user", UserController.class);
		add("banner", BannerController.class);
		add("video", VideoController.class);
		add("permission", PermissionController.class);
		add("role", RoleController.class);
		add("administrator", AdministratorController.class);
		add("statistic", StatisticController.class);
	}

	@Override
	public Routes add(String controllerKey, Class<? extends Controller> controllerClass) {
		return super.add("/admin/" + controllerKey, controllerClass);
	}
}
