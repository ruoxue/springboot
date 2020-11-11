package top.chengdongqing.common.sender;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.jfinal.captcha.Captcha;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant.ConfigFile;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.HttpKit;
import top.chengdongqing.common.kit.SignatureKit;
import top.chengdongqing.common.kit.StringKit;
import top.chengdongqing.common.model.User;

/**
 * 发送短信
 * 
 * @author Luyao
 *
 */
public class SmsSender extends Sender {

	private static final Sender me = new SmsSender();

	public static Sender me() {
		return me;
	}

	// 配置文件
	private static final Prop prop = PropKit.use(ConfigFile.SMS);
	// 短信发送成功状态码
	private static final String SEND_SUCCESS = "OK";

	/**
	 * 短信模板
	 */
	public interface Template {
		// 短信验证码登录
		String LOGIN = prop.get("template.login");
		// 账号注册
		String REGISTER = LOGIN;
		// 找回密码
		String RETRIEVE_PASSWORD = LOGIN;
		// 更新手机号
		String PHONE_UPDATE = LOGIN;
	}

	@Override
	public Ret sendCaptcha(String phone, String template) {
		// 生成验证码
		String captcha = StringKit.generateCaptcha();

		// 发送短信
		Ret result = send(phone, template, Kv.by("code", captcha).toJson());
		if (result.isOk()) {
			// 保存验证码到本地缓存
			cache.put(new Captcha(phone, captcha, 5 * 60));
		}
		return result;
	}

	@Override
	public Ret send(String phone, String template, String content) {
		// 校验手机号格式
		if (StrKit.isBlank(phone) || !phone.matches(User.Pattern.PHONE)) {
			return Fail.setMsg("手机号格式错误");
		}

		// 封装参数
		Map<String, String> params = new HashMap<String, String>();
		params.put("PhoneNumbers", phone);
		params.put("AccessKeyId", prop.get("access.id"));
		params.put("Action", prop.get("method.name"));
		params.put("Version", prop.get("method.version"));
		params.put("Format", "json");
		params.put("SignatureMethod", prop.get("sign.method"));
		params.put("SignatureVersion", prop.get("sign.version"));
		params.put("SignatureNonce", StrKit.getRandomUUID());
		// 时间戳，按照ISO8601 标准表示，并需要使用UTC时间
		String timestamp = Instant.now().atZone(ZoneId.of("GMT"))
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
		params.put("Timestamp", timestamp);
		params.put("SignName", prop.get("sign.name"));
		params.put("TemplateCode", template);
		// 放到模板的参数，JSON格式
		params.put("TemplateParam", content);
		params.put("Signature", SignatureKit.sha1HmacSign(params, prop.get("access.secret")));

		try {
			// 发送请求
			String result = HttpKit.get(prop.get("http.url"), params);
			Kv resultMap = JSON.parseObject(result, Kv.class);

			// 判断是否发送成功
			boolean isOk = SEND_SUCCESS.equals(resultMap.get("Code"));
			return isOk ? Ret.ok() : Fail.setMsg(Fail.Msg.REQUEST_FAIL);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
