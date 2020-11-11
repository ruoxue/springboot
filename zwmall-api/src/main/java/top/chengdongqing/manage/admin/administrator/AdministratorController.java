package top.chengdongqing.manage.admin.administrator;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;

/**
 * 管理员管理相关控制器
 * 
 * @author Luyao
 *
 */
public class AdministratorController extends Controller {

	@Inject
	AdministratorService adminSrv;

	/**
	 * 获取管理员列表
	 */
	@Before(GET.class)
	public void index(String keyword) {
		int roleId = getInt("roleId", 0);
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		renderJson(adminSrv.paginate(roleId, keyword, pageNumber, pageSize));
	}

	/**
	 * 新增管理员
	 * 
	 * @param phone
	 * @param roleId
	 */
	@Before(POST.class)
	@NotBlank({ "phone", "roleId" })
	public void save(String phone, int roleId) {
		renderJson(adminSrv.saveAdmin(phone, roleId));
	}

	/**
	 * 修改管理员
	 * 
	 * @param id
	 * @param roleId
	 */
	@Before(POST.class)
	@NotBlank({ "id", "roleId" })
	public void update(int id, int roleId) {
		renderJson(adminSrv.updateAdmin(id, roleId));
	}

	/**
	 * 删除管理员
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(adminSrv.deleteAdmin(id));
	}
}
