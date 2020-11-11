package top.chengdongqing.portal.banner;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;

import top.chengdongqing.common.model.Banner;

/**
 * 轮播图相关控制器
 * 
 * @author Luyao
 *
 */
@Before(GET.class)
public class BannerController extends Controller {

	@Inject
	BannerService bannerSrv;

	/**
	 * 获取滚动轮播图
	 */
	public void slides() {
		renderJson(bannerSrv.findBanners(Banner.Type.SLIDE));
	}

	/**
	 * 获取推销商品广告
	 */
	public void promos() {
		renderJson(bannerSrv.findBanners(Banner.Type.PROMO));
	}

	/**
	 * 获取广告横幅
	 */
	public void adverts() {
		renderJson(bannerSrv.findBanners(Banner.Type.ADVERT));
	}
	
	/**
	 * 获取首页顶部横幅
	 */
	public void top() {
		renderJson(bannerSrv.findBanners(Banner.Type.TOP));
	}
}
