package top.chengdongqing.manage.admin.menu;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.AdminMenu;
import top.chengdongqing.manage.admin.role.RoleService;

/**
 * 菜单管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class MenuService {

	@Inject
	AdminMenu dao;

	@Inject
	RoleService roleSrv;

	/**
	 * 获取当前管理员的菜单列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<AdminMenu> findMenus(int userId) {
		// 查询父菜单
		boolean isSuperAdmin = roleSrv.isSuperAdmin(userId);
		Kv params = Kv.by("adminId", userId).set("isSuperAdmin", isSuperAdmin);
		List<AdminMenu> navs = dao.template("admin.menu.findMenus", params).find();

		// 查询子菜单
		navs.forEach(menu -> {
			params.set("parentId", menu.getId());
			List<AdminMenu> children = dao.template("admin.menu.findChildrenMenus", params).find();
			menu.put("menus", children);
			params.remove("parentId");
		});
		return navs;
	}

	/**
	 * 获取菜单列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<AdminMenu> findAll(int parentId) {
		String sql = "select * from admin_menu where parentId = ? order by sortNo";
		return dao.find(sql, parentId);
	}

	/**
	 * 删除菜单
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteMenu(int id) {
		AdminMenu menu = getMenuById(id);

		if (menu.isRoot()) {
			// 是根菜单需要确定没有下属子菜单
			String sql = "select id from admin_menu where parentId = ? limit 1";
			if (dao.findFirst(sql, id) != null) {
				return Fail.setMsg("请先删除该菜单下的所有子菜单");
			}
		} else {
			// 是子菜单需要确定没有被角色绑定
			String sql = "select id from admin_role_menu where menuId = ? limit 1";
			Record record = Db.findFirst(sql, id);
			if (record != null) {
				return Fail.setMsg("请先解绑该菜单下的所有角色");
			}
		}
		return menu.delete() ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 根据id获取菜单
	 * 
	 * @param id
	 * @return
	 */
	private AdminMenu getMenuById(int id) {
		AdminMenu menu = dao.findByIdLoadColumns(id, "id, parentId, sortNo");
		if (menu == null) {
			throw new IllegalStateException("The menu is not exist");
		}
		return menu;
	}

	/**
	 * 新增菜单
	 * 
	 * @param menu
	 * @return
	 */
	public Ret saveMenu(AdminMenu menu) {
		// 如果不是根菜单，查询它的父菜单是否存在
		if (!menu.isRoot()) {
			String sql = "select id from admin_menu where id = ? limit 1";
			if (dao.findFirst(sql, menu.getParentId()) == null) {
				return Fail.setMsg("该父菜单不存在");
			}
		}

		// 获取当前最大排序
		String sql = "select sortNo from admin_menu where parentId = ? order by sortNo desc limit 1";
		Integer maxSortNo = Db.queryInt(sql, menu.getParentId());
		menu.setSortNo(maxSortNo == null ? 0 : maxSortNo + 1);

		// 清除无用数据
		menu.remove("id", "createTime");
		if (menu.isRoot()) {
			menu.remove("pagePath", "iconClass");
		}
		return menu.save() ? Ret.ok() : Fail.setMsg(Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 更新菜单
	 * 
	 * @param menu
	 * @return
	 */
	public Ret updateMenu(AdminMenu menu) {
		if (menu.isRoot()) {
			menu.remove("pagePath", "iconClass");
		}
		return menu.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 菜单排序
	 * 
	 * @param id
	 * @param direction
	 * @return
	 */
	public Ret menuSort(int id, int direction) {
		AdminMenu menu = getMenuById(id);

		// direction等于0为上移，获取该类别的上一个类别，否则相反
		StringBuilder sql = new StringBuilder("select id, sortNo from admin_menu where parentId = ? and sortNo ");
		sql.append(direction == 0 ? "<" : ">").append(" ? order by sortNo ");
		sql.append(direction == 0 ? "desc" : "asc").append(" limit 1");
		AdminMenu nearbyMenu = dao.findFirst(sql.toString(), menu.getParentId(), menu.getSortNo());
		if (nearbyMenu == null) {
			return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
		}

		// 交换排序号
		int sortNo = nearbyMenu.getSortNo();
		nearbyMenu.setSortNo(menu.getSortNo());
		menu.setSortNo(sortNo);
		boolean isOk = Db.tx(() -> {
			return menu.update() && nearbyMenu.update();
		});
		return isOk ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 获取指定角色的菜单id集合
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Integer> findMenusOfRole(int roleId) {
		String sql = "select menuId from admin_role_menu where roleId = ?";
		return Db.query(sql, roleId);
	}
}
