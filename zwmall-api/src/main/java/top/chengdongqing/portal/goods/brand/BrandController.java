package top.chengdongqing.portal.goods.brand;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.plugin.ehcache.CacheInterceptor;

/**
 * 商品品牌相关控制器
 * 
 * @author Luyao
 *
 */
@Before({ GET.class, CacheInterceptor.class })
public class BrandController extends Controller {

	@Inject
	BrandService brandSrv;

	/**
	 * 获取全部品牌
	 */
	public void index() {
		renderJson(brandSrv.findAll());
	}

	/**
	 * 获取头部品牌列表
	 */
	public void headerBrands() {
		renderJson(brandSrv.findHeaderBrands());
	}
}
