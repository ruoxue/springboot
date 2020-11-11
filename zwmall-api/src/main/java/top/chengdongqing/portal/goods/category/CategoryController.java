package top.chengdongqing.portal.goods.category;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.plugin.ehcache.CacheInterceptor;

/**
 * 商品类别相关控制器
 * 
 * @author Luyao
 *
 */
@Before({ GET.class, CacheInterceptor.class })
public class CategoryController extends Controller {

	@Inject
	CategoryService categorySrv;

	/**
	 * 获取全部类别
	 */
	public void index() {
		renderJson(categorySrv.findAll());
	}

	/**
	 * 获取首页主角类别
	 */
	public void heroCategories() {
		renderJson(categorySrv.findHeroCategories());
	}

	/**
	 * 获取首页类别块
	 */
	public void brickCategories() {
		renderJson(categorySrv.findBrickCategories());
	}
}
