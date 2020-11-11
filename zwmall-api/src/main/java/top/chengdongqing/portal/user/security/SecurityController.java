package top.chengdongqing.portal.user.security;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.AccessLimit;
import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.common.render.CaptchaRender;
import top.chengdongqing.common.sender.EmailSender;
import top.chengdongqing.common.sender.SmsSender;
import top.chengdongqing.portal.user.security.validator.RetrievePasswordValidator;
import top.chengdongqing.portal.user.security.validator.SendCaptchaForBindEmailValidator;
import top.chengdongqing.portal.user.security.validator.SendCaptchaForBindPhoneValidator;
import top.chengdongqing.portal.user.security.validator.UpdateEmailValidator;
import top.chengdongqing.portal.user.security.validator.UpdatePhoneValidator;
import top.chengdongqing.portal.user.security.validator.UpdatePwdValidator;

/**
 * 安全相关控制器
 * 
 * @author Luyao
 *
 */
public class SecurityController extends BaseController {

	@Inject
	SecurityService securitySrv;

	/**
	 * 找回密码时发送验证码
	 * 
	 * @param account
	 */
	@Before(POST.class)
	@NotBlank("account")
	@Clear(LoginAuthInterceptor.class)
	@AccessLimit(limitKey = "account", expireTime = 60 * 60 * 24, times = 5, msg = "今日发送次数超出，请明日再试")
	public void sendCaptchaForRetrievePwd(String account) {
		renderJson(securitySrv.sendCaptchaForRetrievePwd(account));
	}

	/**
	 * 找回密码
	 * 
	 * @param account
	 * @param password
	 */
	@Clear(LoginAuthInterceptor.class)
	@AccessLimit(expireTime = 60 * 60, times = 5)
	@Before({ POST.class, RetrievePasswordValidator.class })
	public void retrievePassword(String account, String password) {
		renderJson(securitySrv.retrievePassword(account, password));
	}

	/**
	 * 获取账号信息
	 */
	@Before(GET.class)
	public void getAccountInfo() {
		renderJson(securitySrv.getAccountInfo(getUser()));
	}

	/**
	 * 获取图片验证码
	 */
	@Before(GET.class)
	@NotBlank("key")
	@Clear(LoginAuthInterceptor.class)
	public void captcha(String key) {
		render(new CaptchaRender(key));
	}

	/**
	 * 更新密码
	 * 
	 * @param oldPwd
	 * @param newPwd
	 */
	@Before({ POST.class, UpdatePwdValidator.class })
	public void updatePwd(String oldPwd, String newPwd) {
		renderJson(securitySrv.updatePwd(oldPwd, newPwd, getUser()));
	}

	/**
	 * 发送绑定邮箱邮件
	 * 
	 * @param email
	 */
	@AccessLimit(expireTime = 60 * 60 * 24, times = 3, msg = "今日发送次数超出，请明日再试")
	@Before({ POST.class, SendCaptchaForBindEmailValidator.class })
	public void sendCaptchaForBindEmail(String email) {
		renderJson(EmailSender.me().sendCaptcha(email, EmailSender.Template.BIND));
	}

	/**
	 * 更新邮箱
	 * 
	 * @param email
	 */
	@Before({ POST.class, UpdateEmailValidator.class })
	public void updateEmail(String email) {
		renderJson(securitySrv.updateEmail(email, getUser()));
	}

	/**
	 * 发送绑定手机短信
	 * 
	 * @param phone
	 */
	@AccessLimit(expireTime = 60 * 60 * 24, times = 3, msg = "今日发送次数超出，请明日再试")
	@Before({ POST.class, SendCaptchaForBindPhoneValidator.class })
	public void sendCaptchaForBindPhone(String phone) {
		renderJson(SmsSender.me().sendCaptcha(phone, SmsSender.Template.PHONE_UPDATE));
	}

	/**
	 * 更新手机号
	 * 
	 * @param email
	 */
	@Before({ POST.class, UpdatePhoneValidator.class })
	public void updatePhone(String phone) {
		renderJson(securitySrv.updatePhone(phone, getUser()));
	}
}
