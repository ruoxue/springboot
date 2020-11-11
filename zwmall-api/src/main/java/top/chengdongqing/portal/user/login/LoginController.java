package top.chengdongqing.portal.user.login;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.ext.interceptor.POST;

import com.jfinal.json.FastJson;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.Ret;
import top.chengdongqing.common.annotation.AccessLimit;
import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.common.sender.SmsSender;
import top.chengdongqing.portal.user.login.validator.AccountLoginValidator;
import top.chengdongqing.portal.user.login.validator.CaptchaLoginValidator;

import java.util.Map;

/**
 * 登录相关控制器
 * 
 * @author Luyao
 *
 */
@Clear(LoginAuthInterceptor.class)
public class LoginController extends BaseController {

	@Inject
	LoginService loginSrv;

	/**
	 * 账号密码登录
	 * 
	 * @param account
	 * @param password
	 */
	@AccessLimit(expireTime = 60, times = 5)
	@Before({ POST.class, AccountLoginValidator.class })
	public void index(String account, String password) {
		System.out.println("111");
		renderJson(loginSrv.accountLogin(account, password, getIp()));
	}

//	@NotBlank("account")
	@AccessLimit(expireTime = 60, times = 5)
	@Before({ POST.class })
	public void openIdLogin(String account, int  loginType) { //
		if (loginType==1){
			String code=getKv().getStr("code");

			String appId="wx3cb4fb0d501022b1";
			String secret="a3394d4cb0ee404789aa9f6ed2e2dfe4";
			String url="https://api.weixin.qq.com/sns/jscode2session?appid="
					+appId+"&secret="+secret
					+"&js_code="+code+"&grant_type=authorization_code";
			String s = HttpKit.get(url);
			System.out.println(s);
			/**
			 * nickName: 夏虫不可语冰²
			 * gender: 1
			 * language: zh_CN
			 * city: Kasukabe-shi
			 * province: Saitama-ken
			 * country: JP
			 * avatarUrl: https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ8BIG7fdqVHibsichsDBnibZGYIzdibfGofmSvpm8dwTxZuqhJBkmlHTKTVJLic7gkQCbZZSicZ6fPpjFg/132
			 * code: 071wGGMZ11GvSU0B1QNZ1W5EMZ1wGGMl
			 * loginType: 1
			 */

			Map<String,String> parse = FastJson.getJson().parse(s, Map.class);

			account  = parse.get("openid");
			String session_key  = parse.get("session_key");
			if (account==null||"".equalsIgnoreCase(account)){
				renderJson(Ret.fail());
			}
		}
		String s = HttpKit.readData(getRequest());
		System.out.println(s);
		if (account==null||"".equalsIgnoreCase(account)){
			renderJson(Ret.fail());

		}else {
			renderJson(loginSrv.openIdLogin(account, "",
					getKv().getStr("nickName"),
					Integer.parseInt(getKv().getStr("gender")),
					getKv().getStr("city"),
					getKv().getStr("province"),
					getKv().getStr("country"),
					getKv().getStr("avatarUrl")
					, getIp()));

		}

	}

	/**
	 * 手机号加短信验证码登录
	 * 
	 * @param phone
	 */
	@AccessLimit(expireTime = 60, times = 3)
	@Before({ POST.class, CaptchaLoginValidator.class })
	public void captchaLogin(String phone) {
		renderJson(loginSrv.captchaLogin(phone, getIp()));
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param phone
	 */
	@NotBlank("phone")
	@Before(POST.class)
	@AccessLimit(limitKey = "phone", expireTime = 60 * 60 * 24, times = 5, msg = "今日发送次数超出，请明日再试")
	public void sendSMSCaptcha(String phone) {
		renderJson(SmsSender.me().sendCaptcha(phone, SmsSender.Template.LOGIN));
	}

	/**
	 * 退出登录
	 */
	@ActionKey("logout")
	@Before({ POST.class, LoginAuthInterceptor.class })
	public void logout() {
		renderJson(loginSrv.logout(getUser()));
	}
}
