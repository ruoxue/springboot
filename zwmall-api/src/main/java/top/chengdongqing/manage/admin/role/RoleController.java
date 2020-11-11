package top.chengdongqing.manage.admin.role;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;

/**
 * 角色管理相关控制器
 * 
 * @author Luyao
 *
 */
public class RoleController extends Controller {

	@Inject
	RoleService roleSrv;

	/**
	 * 查询角色列表
	 */
	@Before(GET.class)
	public void index() {
		renderJson(roleSrv.findAll());
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(roleSrv.deleteRole(id));
	}

	/**
	 * 新增角色
	 * 
	 * @param name
	 */
	@NotBlank("name")
	@Before(POST.class)
	public void save(String name) {
		renderJson(roleSrv.saveRole(name));
	}

	/**
	 * 更新角色名称
	 * 
	 * @param id
	 * @param name
	 */
	@Before(POST.class)
	@NotBlank({ "id", "name" })
	public void updateName(int id, String name) {
		renderJson(roleSrv.updateName(id, name));
	}

	/**
	 * 更新角色的菜单
	 * 
	 * @param roleId
	 * @param menuIds
	 */
	@Before(POST.class)
	@NotBlank({ "roleId", "menuIds" })
	public void updateMenus(int roleId, String menuIds) {
		renderJson(roleSrv.updateMenus(roleId, menuIds));
	}

	/**
	 * 更新角色的权限
	 * 
	 * @param roleId
	 * @param permissionId
	 */
	@Before(POST.class)
	@NotBlank({ "roleId", "permissionId" })
	public void updatePermission(int roleId, int permissionId) {
		renderJson(roleSrv.updatePermission(roleId, permissionId));
	}
}
