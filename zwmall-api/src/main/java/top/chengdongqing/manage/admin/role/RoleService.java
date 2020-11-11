package top.chengdongqing.manage.admin.role;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;

import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.AdminRole;
import top.chengdongqing.common.model.AdminRoleMenu;
import top.chengdongqing.common.model.AdminRolePermission;
import top.chengdongqing.common.model.AdminUserRole;

/**
 * 角色管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class RoleService {

	@Inject
	AdminRole dao;

	@Inject
	AdminUserRole userRoleDao;

	@Inject
	AdminRolePermission rolePermissionDao;

	/**
	 * 查询该用户是否是管理员
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isAdmin(int userId) {
		String sql = "select id from admin_user_role where adminId = ? limit 1";
		return userRoleDao.findFirst(sql, userId) != null;
	}

	/**
	 * 查询该用户是否是超级管理员
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isSuperAdmin(int userId) {
		String sql = "select roleId from admin_user_role where adminId = ? limit 1";
		AdminUserRole userRole = userRoleDao.findFirst(sql, userId);
		return userRole != null && AdminRole.isSuperAdmin(userRole.getRoleId());
	}

	/**
	 * 根据用户id获取角色名称
	 * 
	 * @param userId
	 * @return
	 */
	public String findRoleName(int userId) {
		String sql = "select t1.name from admin_role t1 left join admin_user_role t2 on t1.id = t2.roleId where t2.adminId = ? limit 1";
		AdminRole role = dao.findFirst(sql, userId);
		return role != null ? role.getName() : "";
	}

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	public List<AdminRole> findAll() {
		String sql = "select t1.*, (select count(*) from admin_user_role where roleId = t1.id) adminCount from admin_role t1 order by createTime";
		return dao.find(sql);
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteRole(int id) {
		if (AdminRole.isSuperAdmin(id)) {
			return Fail.setMsg("禁止删除超级管理员");
		}

		// 查询该角色是否已被管理员绑定
		String sql = "select id from admin_user_role where roleId = ? limit 1";
		if (Db.findFirst(sql, id) != null) {
			return Fail.setMsg("请先解绑该角色下的管理员");
		}
		return new AdminRole().set("id", id).delete() ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 新增角色
	 * 
	 * @param name
	 * @return
	 */
	public Ret saveRole(String name) {
		if (hasRole(name)) {
			return Fail.setMsg("该角色名称已存在");
		}

		AdminRole role = new AdminRole();
		role.setName(name);
		return role.save() ? Ret.ok() : Fail.setMsg(Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 查询角色名称是否存在
	 * 
	 * @param name
	 * @return
	 */
	private boolean hasRole(String name) {
		String sql = "select id from admin_role where name = ? limit 1";
		return dao.findFirst(sql, name) != null;
	}

	/**
	 * 更新角色名称
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public Ret updateName(int id, String name) {
		AdminRole role = dao.findById(id);
		if (role == null) {
			throw new IllegalStateException("The role is not exist");
		}
		if (!role.getName().equals(name) && hasRole(name)) {
			return Fail.setMsg("该角色名称已存在");
		}

		role.setName(name);
		return role.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 更新角色的菜单
	 * 
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	public Ret updateMenus(int roleId, String menuIds) {
		if (AdminRole.isSuperAdmin(roleId)) {
			return Fail.setMsg("禁止修改超级管理员");
		}

		// 删除该角色所有的菜单
		String sql = "delete from admin_role_menu where roleId = ?";
		Db.delete(sql, roleId);
		// 保存选中的菜单
		String[] ids = menuIds.split(",");
		List<AdminRoleMenu> roleMenus = new ArrayList<>();
		for (String id : ids) {
			AdminRoleMenu roleMenu = new AdminRoleMenu();
			roleMenu.setRoleId(roleId);
			roleMenu.setMenuId(Integer.parseInt(id));
			roleMenus.add(roleMenu);
		}
		Db.batchSave(roleMenus, roleMenus.size());
		return Ret.ok();
	}

	/**
	 * 更新角色的权限
	 * 
	 * @param roleId
	 * @param permissionId
	 * @return
	 */
	public Ret updatePermission(int roleId, int permissionId) {
		if (AdminRole.isSuperAdmin(roleId)) {
			return Fail.setMsg("禁止修改超级管理员");
		}

		// 查询该角色和该权限的关联是否存在
		String sql = "select id from admin_role_permission where roleId = ? and permissionId = ? limit 1";
		AdminRolePermission rolePermission = rolePermissionDao.findFirst(sql, roleId, permissionId);
		if (rolePermission == null) {
			rolePermission = new AdminRolePermission();
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissionId(permissionId);
			if (rolePermission.save()) {
				return Ret.ok();
			}
		} else if (rolePermission.delete()) {
			return Ret.ok();
		}
		return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}
}
