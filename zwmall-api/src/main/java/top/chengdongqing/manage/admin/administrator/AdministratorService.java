package top.chengdongqing.manage.admin.administrator;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.AdminRole;
import top.chengdongqing.common.model.AdminUserRole;
import top.chengdongqing.common.model.User;

/**
 * 管理员管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class AdministratorService {

	@Inject
	AdminUserRole dao;

	@Inject
	User userDao;

	/**
	 * 分页查询管理员
	 * 
	 * @param roleId
	 * @param keyword
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<Record> paginate(int roleId, String keyword, int pageNumber, int pageSize) {
		Kv params = Kv.by("roleId", roleId).set("keyword", keyword);
		return Db.template("admin.administrator.paginate", params).paginate(pageNumber, pageSize);
	}

	/**
	 * 新增管理员
	 * 
	 * @param phone
	 * @param roleId
	 * @return
	 */
	public Ret saveAdmin(String phone, int roleId) {
		String sql = "select id from `user` where phone = ? limit 1";
		User user = userDao.findFirst(sql, phone);
		if (user == null) {
			return Fail.setMsg("该手机号未注册");
		}

		// 查询该账号是否已分配角色
		sql = "select id from admin_user_role where adminId = ? limit 1";
		if (dao.findFirst(sql, user.getId()) != null) {
			return Fail.setMsg("该账号已是管理员");
		}

		AdminUserRole userRole = new AdminUserRole();
		userRole.setAdminId(user.getId());
		userRole.setRoleId(roleId);
		return userRole.save() ? Ret.ok() : Fail.setMsg(Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 更新管理员
	 * 
	 * @param id
	 * @param roleId
	 * @return
	 */
	public Ret updateAdmin(int id, int roleId) {
		if (AdminRole.isSuperAdmin(roleId)) {
			return Fail.setMsg("禁止操作超级管理员");
		}

		AdminUserRole userRole = new AdminUserRole();
		userRole.setId(id);
		userRole.setRoleId(roleId);
		return userRole.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 删除管理员
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteAdmin(int id) {
		AdminUserRole userRole = dao.findById(id);
		if (AdminRole.isSuperAdmin(userRole.getRoleId())) {
			return Fail.setMsg("禁止删除超级管理员");
		}
		return userRole.delete() ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}
}
