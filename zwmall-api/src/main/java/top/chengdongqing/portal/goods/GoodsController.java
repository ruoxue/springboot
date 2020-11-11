package top.chengdongqing.portal.goods;

import com.alibaba.fastjson.JSON;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.ehcache.CacheInterceptor;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.manage.goods.GoodsValidator;

/**
 * 商品相关控制器
 * 
 * @author Luyao
 *
 */
public class GoodsController extends Controller {

	@Inject
	GoodsService goodsSrv;

	/**
	 * 查询最新的10个商品
	 */
	@Before(CacheInterceptor.class)
	public void hotGoodses() {
		renderJson(goodsSrv.findHotGoodses());
	}

	/**
	 * 获取搜索提示词
	 * 
	 * @param keyword 搜索关键词
	 */
	@NotBlank("keyword")
	public void promptKeywords(String keyword) {
		renderJson(goodsSrv.findPromptKeywords(keyword));
	}

	/**
	 * 商品搜索
	 */
	public void search() {
		String keyword = get("keyword", "all");
		int categoryId = getInt("categoryId", -1);
		int brandId = getInt("brandId", -1);
		String sort = get("sort", "new");
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 20);
		int type = getInt("type", 1);
		renderJson(goodsSrv.searchGoodses(keyword, categoryId, brandId,type, sort, pageNumber, pageSize));
	}

	/**
	 * 获取随机推荐的商品
	 */
	public void recommends() {
		renderJson(goodsSrv.findRecommends());
	}

	/**
	 * 查询商品详情
	 * 
	 * @param id
	 */
	@NotBlank
	public void details(int id) {
		renderJson(goodsSrv.findDetails(id));
	}

	/**
	 * 获取商品规格
	 * 
	 * @param id
	 */
	@NotBlank
	public void skus(int id) {
		renderJson(goodsSrv.findSkus(id));
	}

	@Before({ POST.class,  GoodsValidator.class })
	public void addAuction(@Para("") Goods goods) {
		Kv details = getKv();
		goods.setSketch(details.getStr("sketch"));
		goods.setSpecs(details.getStr("specs"));
		renderJson(goodsSrv.saveGoods(goods, details.getStr("banners"),
				details.getStr("skus")));
	}


}
