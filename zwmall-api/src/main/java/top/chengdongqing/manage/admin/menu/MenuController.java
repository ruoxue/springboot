package top.chengdongqing.manage.admin.menu;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.model.AdminMenu;

/**
 * 菜单管理相关控制器
 * 
 * @author Luyao
 *
 */
public class MenuController extends BaseController {

	@Inject
	MenuService menuSrv;

	/**
	 * 获取当前管理员的菜单列表
	 */
	@Before(GET.class)
	public void index() {
		renderJson(menuSrv.findMenus(getUserId()));
	}

	/**
	 * 获取菜单列表
	 */
	@Before(GET.class)
	public void all() {
		int parentId = getInt("parentId", 0);
		renderJson(menuSrv.findAll(parentId));
	}

	/**
	 * 删除菜单
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(menuSrv.deleteMenu(id));
	}

	/**
	 * 新增菜单
	 * 
	 * @param menu
	 */
	@Before({ POST.class, MenuValidator.class })
	public void save(@Para("") AdminMenu menu) {
		renderJson(menuSrv.saveMenu(menu));
	}

	/**
	 * 更新菜单
	 * 
	 * @param menu
	 */
	@NotBlank
	@Before({ POST.class, MenuValidator.class })
	public void update(@Para("") AdminMenu menu) {
		renderJson(menuSrv.updateMenu(menu));
	}

	/**
	 * 菜单排序
	 * 
	 * @param id
	 * @param direction
	 */
	@Before(POST.class)
	@NotBlank({ "id", "direction" })
	public void sort(int id, int direction) {
		renderJson(menuSrv.menuSort(id, direction));
	}

	/**
	 * 获取指定角色的菜单
	 * 
	 * @param roleId
	 */
	@Before(GET.class)
	@NotBlank("roleId")
	public void menusOfRole(int roleId) {
		renderJson(menuSrv.findMenusOfRole(roleId));
	}
}
