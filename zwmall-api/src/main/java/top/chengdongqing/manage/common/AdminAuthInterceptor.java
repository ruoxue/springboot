package top.chengdongqing.manage.common;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.model.User;
import top.chengdongqing.manage.admin.permission.PermissionService;
import top.chengdongqing.manage.admin.role.RoleService;

/**
 * 管理员权限拦截器
 * 
 * @author Luyao
 *
 */
public class AdminAuthInterceptor implements Interceptor {

	@Inject
	RoleService roleSrv;

	@Inject
	PermissionService permissionSrv;

	@Override
	public void intercept(Invocation inv) {
		Controller c = inv.getController();
		String token = c.getHeader(Constant.TOKEN);
		int userId = User.getLoginUser(token != null ? token : c.get(Constant.TOKEN)).getId();
		String actionKey = inv.getActionKey();
		// 超级管理员或有当前接口访问权限的普通管理员可通过
		if (roleSrv.isSuperAdmin(userId) || roleSrv.isAdmin(userId) && permissionSrv.hasPermission(userId, actionKey)) {
			inv.invoke();
		} else {
			c.renderError(403);
		}
	}
}
