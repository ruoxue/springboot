package top.chengdongqing.manage.admin.permission;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.core.Action;
import com.jfinal.core.JFinal;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.AdminPermission;
import top.chengdongqing.common.model.AdminRole;
import top.chengdongqing.common.model.AdminRolePermission;

/**
 * 权限管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class PermissionService {

	@Inject
	AdminPermission dao;

	@Inject
	AdminRole roleDao;

	@Inject
	AdminRolePermission rolePermissionDao;

	/**
	 * 查询该用户是否有该接口访问权限
	 * 
	 * @param userId
	 * @param actionKey
	 * @return
	 */
	public boolean hasPermission(int userId, String actionKey) {
		return dao.template("admin.permission.hasPermission", userId, actionKey).findFirst() != null;
	}

	/**
	 * 分页查询权限列表
	 * 
	 * @param keyword
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<AdminPermission> paginate(String keyword, int pageNumber, int pageSize) {
		return dao.template("admin.permission.paginate", Kv.by("keyword", keyword)).paginate(pageNumber, pageSize);
	}

	/**
	 * 同步接口列表
	 * 
	 * @return
	 */
	public Ret syncActionKey() {
		int count = 0;

		// 获取所有的接口
		List<String> actionKeys = JFinal.me().getAllActionKeys();
		for (String actionKey : actionKeys) {
			// 仅处理后台接口
			if (!actionKey.startsWith("/admin"))
				continue;

			// 查询该接口是否已保存
			String sql = "select id from admin_permission where actionKey = ? limit 1";
			AdminPermission permission = dao.findFirst(sql, actionKey);
			// 不存在则保存
			if (permission == null) {
				// 根据接口名获取控制器
				Action action = JFinal.me().getAction(actionKey, new String[1]);
				// 获取控制器类名
				String controller = action.getControllerClass().getSimpleName();
				permission = new AdminPermission();
				permission.setActionKey(actionKey);
				permission.setController(controller);
				if (permission.save()) {
					// 累加新增的接口数量
					count++;
				}
			}
		}

		return count > 0 ? Ret.ok("count", count) : Fail.setMsg("已是最新状态，无需更新");
	}

	/**
	 * 删除权限
	 * 
	 * @param id
	 * @return
	 */
	public Ret delete(int id) {
		AdminPermission permission = getPermissionById(id);

		// 判断该是否被角色绑定
		String sql = "select roleId from admin_role_permission where permissionId = ? limit 1";
		AdminRolePermission rolePermission = rolePermissionDao.findFirst(sql, id);
		if (rolePermission != null) {
			// 查询该角色名称
			AdminRole role = roleDao.findByIdLoadColumns(rolePermission.getRoleId(), "name");
			if (role != null) {
				return Ret.fail(Constant.MSG, "该权限已被" + role.getName() + "绑定，请先解绑");
			}
		}
		return permission.delete() ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 根据id获取权限
	 * 
	 * @param id
	 * @return
	 */
	private AdminPermission getPermissionById(int id) {
		AdminPermission permission = dao.findByIdLoadColumns(id, "id");
		if (permission == null) {
			throw new IllegalStateException("The permission is not exist");
		}
		return permission;
	}

	/**
	 * 更新权限备注
	 * 
	 * @param id
	 * @param remark
	 * @return
	 */
	public Ret updateRemark(int id, String remark) {
		AdminPermission permission = getPermissionById(id);
		permission.setRemark(remark);
		return permission.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 获取指定角色的权限id集合
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Integer> findPermissionsOfRole(int roleId) {
		String sql = "select permissionId from admin_role_permission where roleId = ?";
		return Db.query(sql, roleId);
	}
}
