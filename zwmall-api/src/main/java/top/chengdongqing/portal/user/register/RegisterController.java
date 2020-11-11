package top.chengdongqing.portal.user.register;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.AccessLimit;
import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.common.sender.SmsSender;

/**
 * 注册相关控制器
 * 
 * @author Luyao
 *
 */
@Clear(LoginAuthInterceptor.class)
public class RegisterController extends BaseController {

	@Inject
	RegisterService registerSrv;

	/**
	 * 账号注册
	 * 
	 * @param phone
	 * @param password
	 */
	@Before({ POST.class, RegisterValidator.class })
	public void index(String phone, String password) {
		renderJson(registerSrv.register(phone, password, getIp(), false));
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param phone
	 */
	@Before(POST.class)
	@NotBlank("phone")
	@AccessLimit(limitKey = "phone", expireTime = 60 * 60 * 24, times = 5, msg = "今日发送次数超出，请明日再试")
	public void sendSMSCaptcha(String phone) {
		renderJson(SmsSender.me().sendCaptcha(phone, SmsSender.Template.REGISTER));
	}
}
