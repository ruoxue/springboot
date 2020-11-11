package top.chengdongqing.portal.user.favorite;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;

/**
 * 收藏的商品相关控制器
 * 
 * @author Luyao
 *
 */
public class FavoriteController extends BaseController {

	@Inject
	FavoriteService favoriteSrv;

	/**
	 * 查询指定的用户收藏的商品
	 */
	@Before(GET.class)
	public void index() {
		renderJson(favoriteSrv.findAll(getUserId()));
	}

	/**
	 * 删除指定的收藏的商品
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(favoriteSrv.delete(id, getUserId()));
	}

	/**
	 * 收藏喜欢的商品
	 * 
	 * @param goodsId
	 * @param skuId
	 */
	@Before(POST.class)
	@NotBlank({ "goodsId", "skuId" })
	public void save(int goodsId, int skuId) {
		renderJson(favoriteSrv.save(goodsId, skuId, getUserId()));
	}
}
