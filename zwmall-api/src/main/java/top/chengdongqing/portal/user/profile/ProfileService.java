package top.chengdongqing.portal.user.profile;

import java.io.File;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.uploader.Uploader;
import top.chengdongqing.common.uploader.Uploader.SaveDire;

/**
 * 个人资料相关逻辑层
 * 
 * @author Luyao
 *
 */
public class ProfileService {

	@Inject
	User dao;

	/**
	 * 更新个人资料
	 * 
	 * @param user
	 * @param loginUser
	 * @return
	 */
	public Ret update(User user, User loginUser) {
		// 仅保留需要的字段
		user.keep("name", "gender", "birthday", "region", "motto");
		user.setId(loginUser.getId());
		if (user.update()) {
			CacheKit.remove(CacheKey.LOGIN_USER, loginUser.getToken());
			return Ret.ok();
		}
		return Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 更新头像
	 * 
	 * @param avatar
	 * @param loginUser
	 * @return
	 */
	public Ret updateAvatar(File avatar, User loginUser) {
		// 保存图片
		Ret result = Uploader.me().uploadImage(avatar, SaveDire.AVATAR);
		if (result.isFail()) {
			return result;
		}

		// 更新用户头像
		User user = new User();
		user.setId(loginUser.getId());
		user.setAvatarUrl(result.getStr("url"));
		if (user.update()) {
			CacheKit.remove(CacheKey.LOGIN_USER, loginUser.getToken());
			return Ret.ok("avatarUrl", user.getAvatarUrl());
		}
		return Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 查询用户相关数量信息
	 * 
	 * @param userId
	 * @return
	 */
	public int[] findCounts(int userId) {
		int[] counts = new int[4];

		// 待支付订单
		String sql = "select count(*) from `order` where userId = ? and status = ?";
		counts[0] = Db.queryInt(sql, userId, Order.Status.ORDERED.getCode());

		// 待收货订单
		sql = "select count(*) from `order` where userId = ? and (status >= ? and status <= ?)";
		counts[1] = Db.queryInt(sql, userId, Order.Status.PAID.getCode(), Order.Status.SHIPPED.getCode());

		// 待评价商品
		sql = "select count(*) from order_goods t1 right join `order` t2 on t1.orderNo = t2.orderNo where t2.userId = ? and t2.status = ? and t1.scoreStatus = ?";
		counts[2] = Db.queryInt(sql, userId, Order.Status.RECEIPTED.getCode(), Constant.Status.ENABLED);

		// 喜欢的商品
		sql = "select count(*) from user_favorite where userId = ?";
		counts[3] = Db.queryInt(sql, userId);
		return counts;
	}
}
