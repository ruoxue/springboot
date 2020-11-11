package top.chengdongqing.portal.user.security;

import com.jfinal.aop.Inject;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.StringKit;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.sender.EmailSender;
import top.chengdongqing.common.sender.SmsSender;
import top.chengdongqing.portal.user.login.LoginService;

/**
 * 安全相关逻辑层
 * 
 * @author Luyao
 *
 */
public class SecurityService {

	@Inject
	User dao;

	@Inject
	LoginService loginSrv;

	/**
	 * 找回密码时发送验证码
	 * 
	 * @param account
	 * @return
	 */
	public Ret sendCaptchaForRetrievePwd(String account) {
		if (account.matches(User.Pattern.PHONE)) {
			return SmsSender.me().sendCaptcha(account, SmsSender.Template.RETRIEVE_PASSWORD);
		} else {
			return EmailSender.me().sendCaptcha(account, EmailSender.Template.RETRIEVE_PASSWORD);
		}
	}

	/**
	 * 找回密码
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public Ret retrievePassword(String account, String password) {
		// 查询该账号是否存在
		if (!loginSrv.hasAccount(account)) {
			return Fail.setMsg("该账号不存在");
		}

		// 重置密码
		String sql = "update `user` set password = #para(0), salt = #para(1), token = null where phone = #para(2) or email = #para(2) limit 1";
		String salt = HashKit.generateSaltForSha256();
		int result = Db.templateByString(sql, HashKit.sha256(password + salt), salt, account).update();
		return result > 0 ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 获取账号信息
	 * 
	 * @param loginUser
	 * @return
	 */
	public Ret getAccountInfo(User loginUser) {
		// 仅获取手机号、邮箱、安全等级，且账号需过滤
		String phone = StringKit.filterAccount(loginUser.getPhone());
		String email = StringKit.filterAccount(loginUser.getEmail());
		String avatar= (loginUser.getAvatarUrl());
		String userName= (loginUser.getName());

		Kv accountInfo = Kv.by("phone", phone).set("email", email).
				set("avatar", avatar).set("name", userName).
				set("securityLevel", loginUser.getSecurityLevel());
		return Ret.ok("accountInfo", accountInfo);
	}

	/**
	 * 更新密码
	 * 
	 * @param oldPwd
	 * @param newPwd
	 * @param loginUser
	 * @return
	 */
	public Ret updatePwd(String oldPwd, String newPwd, User loginUser) {
		// 校验原密码是否正确
		String sql = "select password, salt from `user` where id = ? limit 1";
		User user = dao.findFirst(sql, loginUser.getId());
		if (!user.getPassword().equals(HashKit.sha256(oldPwd + user.getSalt()))) {
			return Fail.setMsg("原密码错误");
		}

		// 更新密码
		loginUser.setSalt(HashKit.generateSaltForSha256());
		loginUser.setPassword(HashKit.sha256(newPwd + loginUser.getSalt()));
		// 清除登录状态
		CacheKit.remove(CacheKey.LOGIN_USER, loginUser.getToken());
		loginUser.setToken(null);
		return loginUser.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 更新邮箱
	 * 
	 * @param email
	 * @param loginUser
	 * @return
	 */
	public Ret updateEmail(String email, User loginUser) {
		// 重置邮箱
		loginUser.setEmail(email);
		// 更新安全等级
		loginUser.setSecurityLevel(User.securityLevel.SAFE);
		return loginUser.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 更新手机号
	 * 
	 * @param phone
	 * @param loginUser
	 * @return
	 */
	public Ret updatePhone(String phone, User loginUser) {
		// 重置邮箱
		loginUser.setPhone(phone);
		return loginUser.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}
}
