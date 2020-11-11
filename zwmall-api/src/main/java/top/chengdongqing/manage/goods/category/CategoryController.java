package top.chengdongqing.manage.goods.category;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.model.GoodsCategory;

/**
 * 商品类别管理控制器
 * 
 * @author Luyao
 *
 */
public class CategoryController extends Controller {

	@Inject
	CategoryService categorySrv;

	/**
	 * 获取商品类别
	 */
	@Before(GET.class)
	public void index() {
		int parentId = getInt("parentId", 0);
		renderJson(categorySrv.findCategoryies(parentId));
	}

	/**
	 * 添加类别
	 * 
	 * @param parentId
	 * @param name
	 */
	@Before(POST.class)
	@NotBlank({ "parentId", "name" })
	public void save(int parentId, String name) {
		renderJson(categorySrv.saveCategory(parentId, name));
	}

	/**
	 * 更新类别
	 * 
	 * @param category
	 */
	@Before(POST.class)
	@NotBlank({ "id", "parentId", "name" })
	public void update(@Para("") GoodsCategory category) {
		renderJson(categorySrv.updateCategory(category));
	}

	/**
	 * 删除类别
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(categorySrv.deleteCategory(id));
	}

	/**
	 * 类别排序
	 * 
	 * @param id
	 * @param direction
	 */
	@Before(POST.class)
	@NotBlank({ "id", "direction" })
	public void sort(int id, int direction) {
		renderJson(categorySrv.categorySort(id, direction));
	}

	/**
	 * 根据子类别id获取父类别id
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(GET.class)
	public void parentId(int id) {
		renderJson(categorySrv.findParentId(id));
	}
}
