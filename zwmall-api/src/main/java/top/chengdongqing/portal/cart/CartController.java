package top.chengdongqing.portal.cart;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.interceptor.LoginAuthInterceptor;

/**
 * 购物车相关控制器
 * 
 * @author Luyao
 *
 */
@Before(LoginAuthInterceptor.class)
public class CartController extends BaseController {

	@Inject
	CartService cartSrv;

	/**
	 * 获取购物车信息
	 */
	@Before(GET.class)
	public void index() {
		boolean onlyChecked = getBoolean("onlyChecked", false);
		renderJson(cartSrv.findCart(onlyChecked, getUserId()));
	}

	/**
	 * 添加商品到购物车
	 * 
	 * @param goodsId
	 * @param skuId
	 */
	@Before(POST.class)
	@NotBlank({ "goodsId", "skuId" })
	public void put(int goodsId, int skuId) {
		renderJson(cartSrv.put(goodsId, skuId, getUserId()));
	}

	/**
	 * 更新商品数量
	 * 
	 * @param id
	 * @param count
	 */
	@Before(POST.class)
	@NotBlank({ "id", "count" })
	public void updateCount(int id, int count) {
		renderJson(cartSrv.updateCount(id, count, getUserId()));
	}

	/**
	 * 更新商品选中状态
	 * 
	 * @param id
	 * @param checked
	 */
	@Before(POST.class)
	@NotBlank({ "id", "checked" })
	public void updateCheck(int id, boolean checked) {
		renderJson(cartSrv.updateCheck(id, checked, getUserId()));
	}

	/**
	 * 从购物车中删除商品
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void remove(int id) {
		renderJson(cartSrv.delete(id, getUserId()));
	}

	/**
	 * 用户登录后同步所有登录前放在浏览器缓存的购物车商品
	 */
	@Before(POST.class)
	@NotBlank("cartJson")
	public void sync(String cartJson) {
		renderJson(cartSrv.syncCart(cartJson, getUserId()));
	}
}
