package top.chengdongqing.portal.common;

import com.jfinal.config.Routes;

import top.chengdongqing.portal.banner.BannerController;
import top.chengdongqing.portal.cart.CartController;
import top.chengdongqing.portal.video.VideoController;

/**
 * 前台路由配置
 * 
 * @author Luyao
 *
 */
public class PortalRoutes extends Routes {

	@Override
	public void config() {
		add(new UserRoutes());
		add(new GoodsRoutes());
		add(new OrderRoutes());
		
		add("video", VideoController.class);
		add("banner", BannerController.class);
		add("cart", CartController.class);
	}
}
