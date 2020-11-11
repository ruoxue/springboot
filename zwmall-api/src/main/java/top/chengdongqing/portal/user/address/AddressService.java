package top.chengdongqing.portal.user.address;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.StringKit;
import top.chengdongqing.common.model.UserAddress;

/**
 * 收货地址相关逻辑层
 * 
 * @author Luyao
 *
 */
public class AddressService {

	@Inject
	UserAddress dao;

	/**
	 * 获取指定用户的所有收货地址
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserAddress> findAll(int userId) {
		String sql = "select * from user_address where userId = ? order by createTime";
		List<UserAddress> addresses = dao.find(sql, userId);
		addresses.forEach(e -> {
			e.setPhone(StringKit.filterAccount(e.getPhone()));
		});
		return addresses;
	}

	/**
	 * 新增收货地址
	 * 
	 * @param address
	 * @param userId
	 * @return
	 */
	public Ret save(UserAddress address, int userId) {
		// 去除多余信息
		address.remove("id", "createTime", "updateTime");
		// 添加用户id
		address.setUserId(userId);
		// 保存地址
		return address.save() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 更新收货地址
	 * 
	 * @param address
	 * @param userId
	 * @return
	 */
	public Ret update(UserAddress address, int userId) {
		// 校验该地址是否是当前用户的
		if (!isOwnAddress(address.getId(), userId)) {
			return Ret.fail(Constant.MSG, "该地址不存在");
		}

		// 去除多余信息
		address.remove("userId", "createTime", "updateTime");
		if (StrKit.isBlank(address.getPhone())) {
			address.remove("phone");
		}
		// 保存地址
		return address.update() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 查询是否当用户自己的收货地址
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	private boolean isOwnAddress(int id, int userId) {
		String sql = "select id from user_address where id = ? and userId = ? limit 1";
		UserAddress oldAddress = dao.findFirst(sql, id, userId);
		return oldAddress != null;
	}

	/**
	 * 删除收货地址
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public Ret delete(int id, int userId) {
		// 校验该地址是否是当前用户的
		if (!isOwnAddress(id, userId)) {
			return Ret.fail(Constant.MSG, "该地址不存在");
		}

		// 删除地址
		return dao.deleteById(id) ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.DELETE_FAIL);
	}
}
