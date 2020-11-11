package top.chengdongqing.manage.admin.login;

import com.jfinal.aop.Inject;
import com.jfinal.kit.LogKit;
import com.jfinal.kit.Ret;

import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.User;
import top.chengdongqing.manage.admin.role.RoleService;

/**
 * 登录相关逻辑层
 * 
 * @author Luyao
 *
 */
public class LoginService {

	@Inject
	User dao;

	@Inject
	RoleService roleSrv;

	@Inject
	top.chengdongqing.portal.user.login.LoginService loginSrv;

	/**
	 * 管理员登录
	 * 
	 * @param account
	 * @param password
	 * @param ip
	 * @return
	 */
	public Ret login(String account, String password, String ip) {
		Ret result = loginSrv.accountLogin(account, password, ip);
		if (result.isOk()) {
			// 查询该用户是否是管理员
			User loginUser = result.getAs("loginUser");
			if (!roleSrv.isAdmin(loginUser.getId())) {
				return Fail.setMsg("该管理员不存在");
			}

			// 查询该管理员的角色名称
			loginUser.put("role", roleSrv.findRoleName(loginUser.getId()));

			// 记录日志
			LogKit.warn("%s【%s】 登录成功！".formatted(account, loginUser.getStr("role")));
		}
		return result;
	}
}
