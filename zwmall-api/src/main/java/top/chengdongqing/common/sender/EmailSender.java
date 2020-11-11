package top.chengdongqing.common.sender;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.jfinal.captcha.Captcha;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.ConfigFile;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.StringKit;
import top.chengdongqing.common.model.User;

/**
 * 发送邮件
 * 
 * @author Luyao
 *
 */
public class EmailSender extends Sender {

	private static final Sender me = new EmailSender();

	public static Sender me() {
		return me;
	}

	// 配置文件
	private static final Prop prop = PropKit.use(ConfigFile.EMAIL);

	/**
	 * 邮件标题
	 */
	public interface Template {
		// 绑定邮箱
		String BIND = "邮箱验证";
		// 找回密码
		String RETRIEVE_PASSWORD = "找回密码";
	}

	@Override
	public Ret sendCaptcha(String email, String template) {
		// 生成验证码
		String captcha = StringKit.generateCaptcha();

		// 生成内容
		String content = """
				亲爱的%s用户，您好！<br/><br/>
				您本次的验证码是：<span style="color: #ff6700;">%s</span><br/>
				请勿将验证码透露给其他人。<br/><br/>
				本邮件由系统自动发送，请勿直接回复！<br/>
				感谢您的访问，祝您使用愉快！
				""".formatted(prop.get("email.name"), captcha);

		// 发送邮件
		Ret result = send(email, template, content);
		if (result.isOk()) {
			// 保存验证码到本地缓存
			cache.put(new Captcha(email, captcha, 5 * 60));
		}
		return result;
	}

	@Override
	public Ret send(String email, String template, String content) {
		// 校验邮箱格式
		if (StrKit.isBlank(email) || !email.matches(User.Pattern.EMAIL)) {
			return Fail.setMsg("邮箱格式错误");
		}

		// 实例化网页邮件客户端
		HtmlEmail he = new HtmlEmail();
		he.setHostName(prop.get("email.host"));
		he.setSmtpPort(prop.getInt("email.port"));
		he.setSSLOnConnect(true);
		he.setAuthentication(prop.get("email.account"), prop.get("email.password"));
		he.setCharset(Constant.CHARSET);
		try {
			he.setFrom(prop.get("email.account"), prop.get("email.name"));
			he.addTo(email, prop.get("email.name") + "用户");
			// 生成标题
			StringBuilder subject = new StringBuilder(template);
			subject.append(" - ").append(prop.get("email.name"));
			he.setSubject(subject.toString());
			he.setMsg(content);
			he.send();
			return Ret.ok();
		} catch (EmailException e) {
			throw new RuntimeException(e);
		}
	}
}
