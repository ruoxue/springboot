package top.chengdongqing.manage.user;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;

/**
 * 用户管理相关控制器
 * 
 * @author Luyao
 *
 */
public class UserController extends Controller {

	@Inject
	private UserService userSrv;

	/**
	 * 查询用户列表
	 * 
	 * @param keyword
	 */
	@Before(GET.class)
	public void index(String keyword) {
		int status = getInt("status", -1);
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		renderJson(userSrv.paginate(status, keyword, pageNumber, pageSize));
	}

	/**
	 * 更新用户状态
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void updateStatus(int id) {
		renderJson(userSrv.updateStatus(id));
	}

	/**
	 * 注销账号
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void cancelAccount(int id) {
		renderJson(userSrv.cancelAccount(id));
	}
	
	/**
	 * 用户提示
	 * 
	 * @param keyword
	 */
	@Before(GET.class)
	public void assist(String keyword) {
		renderJson(userSrv.getUserAssist(keyword));
	}
}
