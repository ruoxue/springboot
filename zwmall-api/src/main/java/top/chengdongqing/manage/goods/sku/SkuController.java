package top.chengdongqing.manage.goods.sku;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;

/**
 * 商品规格相关控制器
 * 
 * @author Luyao
 *
 */
public class SkuController extends Controller {

	@Inject
	SkuService skuSrv;

	/**
	 * 获取商品的规格信息
	 * 
	 * @param goodsId
	 */
	@Before(GET.class)
	@NotBlank("goodsId")
	public void findSkus(int goodsId) {
		renderJson(skuSrv.findSkus(goodsId));
	}

	/**
	 * 获取所有的属性列表
	 */
	@Before(GET.class)
	public void findAttrs() {
		renderJson(skuSrv.findAttrs());
	}

	/**
	 * 新增属性
	 * 
	 * @param name
	 */
	@NotBlank("name")
	@Before(POST.class)
	public void saveAttr(String name) {
		renderJson(skuSrv.saveAttr(name));
	}

	/**
	 * 更新属性
	 * 
	 * @param id
	 * @param name
	 */
	@Before(POST.class)
	@NotBlank({ "id", "name" })
	public void updateAttr(int id, String name) {
		renderJson(skuSrv.updateAttr(id, name));
	}

	/**
	 * 删除属性
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void deleteAttr(int id) {
		renderJson(skuSrv.deleteAttr(id));
	}

	/**
	 * 添加属性值
	 * 
	 * @param keyId
	 * @param name
	 */
	@Before(POST.class)
	@NotBlank({ "keyId", "name" })
	public void saveValue(int keyId, String name) {
		renderJson(skuSrv.saveVlaue(keyId, name));
	}

	/**
	 * 更新属性值
	 * 
	 * @param id
	 * @param name
	 */
	@Before(POST.class)
	@NotBlank({ "id", "name" })
	public void updateValue(int id, String name) {
		renderJson(skuSrv.updateValue(id, name));
	}

	/**
	 * 删除属性值
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void deleteValue(int id) {
		renderJson(skuSrv.deleteValue(id));
	}
}
