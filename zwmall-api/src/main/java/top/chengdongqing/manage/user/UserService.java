package top.chengdongqing.manage.user;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.User;
import top.chengdongqing.manage.admin.role.RoleService;

/**
 * 用户管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class UserService {

	@Inject
	private User dao;

	@Inject
	RoleService roleSrv;

	/**
	 * 分页查询用户列表
	 * 
	 * @param status
	 * @param keyword
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<User> paginate(int status, String keyword, int pageNumber, int pageSize) {
		Kv params = Kv.by("status", status).set("keyword", keyword);
		return dao.template("admin.user.paginate", params).paginate(pageNumber, pageSize);
	}

	/**
	 * 更新用户状态
	 * 
	 * @param id
	 * @return
	 */
	public Ret updateStatus(int id) {
		User user = dao.findByIdLoadColumns(id, "id, status, token");
		if (user == null) {
			throw new IllegalStateException("The user is not exist");
		}

		if (roleSrv.isSuperAdmin(id)) {
			return Fail.setMsg("禁止操作超级管理员");
		}

		// 更新状态、清除缓存、清除登录信息
		user.setStatus(user.getStatus() == 0 ? 1 : 0);
		CacheKit.remove(CacheKey.LOGIN_USER, user.getToken());
		user.setToken(null);
		return user.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 注销账号
	 * 
	 * @param id
	 * @return
	 */
	public Ret cancelAccount(int id) {
		User user = dao.findByIdLoadColumns(id, "id, status, token");
		if (user == null) {
			throw new IllegalStateException("The user is not exist");
		}

		// 查询该用户是否还有未完成的订单
		String sql = "select id from `order` where userId = ? and status >= ? and status <= ? limit 1";
		Record orderRecord = Db.findFirst(sql, id, Order.Status.PAID.getCode(), Order.Status.SHIPPED.getCode());
		if (orderRecord != null) {
			return Fail.setMsg("该用户还有未完成的订单，操作失败！");
		}

		// 是否是管理员
		if (roleSrv.isAdmin(id)) {
			return Fail.setMsg("请先解绑该用户的管理员角色");
		}

		// 删除该用户的相关数据
		if (Db.template("admin.user.cancelAccount", id).delete() > 0) {
			CacheKit.remove(CacheKey.LOGIN_USER, user.getToken());
			return Ret.ok();
		}
		return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 获取手机号提示
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Record> getUserAssist(String keyword) {
		if (StrKit.isBlank(keyword) || !keyword.matches("\\d{1,11}")) {
			return new ArrayList<>();
		}
		String sql = "select id, phone from `user` where phone like concat('%', ?, '%') limit 5";
		return Db.find(sql, keyword);
	}
}
