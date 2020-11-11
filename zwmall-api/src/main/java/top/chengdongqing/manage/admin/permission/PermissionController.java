package top.chengdongqing.manage.admin.permission;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;

/**
 * 权限管理相关控制器
 * 
 * @author Luyao
 *
 */
public class PermissionController extends Controller {

	@Inject
	private PermissionService permissionSrv;

	/**
	 * 获取权限列表
	 */
	@Before(GET.class)
	public void index(String keyword) {
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		renderJson(permissionSrv.paginate(keyword, pageNumber, pageSize));
	}

	/**
	 * 同步接口列表
	 */
	@Before(POST.class)
	public void sync() {
		renderJson(permissionSrv.syncActionKey());
	}

	/**
	 * 删除权限
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(permissionSrv.delete(id));
	}

	/**
	 * 修改权限备注
	 * 
	 * @param id
	 * @param remark
	 */
	@NotBlank
	@Before(POST.class)
	public void updateRemark(int id, String remark) {
		renderJson(permissionSrv.updateRemark(id, remark));
	}

	/**
	 * 获取指定角色的权限
	 * 
	 * @param roleId
	 */
	@Before(GET.class)
	@NotBlank("roleId")
	public void permissionsOfRole(int roleId) {
		renderJson(permissionSrv.findPermissionsOfRole(roleId));
	}
}
