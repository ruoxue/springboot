
package top.chengdongqing.common.kit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.jfinal.kit.StrKit;

import top.chengdongqing.common.model.User;

/**
 * 字符串处理工具类
 * 
 * @author Luyao
 *
 */
public class StringKit {

	/**
	 * 生成验证码
	 * 
	 * @return
	 */
	public static String generateCaptcha() {
		String randNum = String.valueOf(Math.random());
		return randNum.substring(randNum.length() - 6, randNum.length());
	}

	/**
	 * 生成订单号
	 * 
	 * @return
	 */
	public static String generateOrderNo() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss")) + generateCaptcha();
	}

	/**
	 * 过滤账号
	 * 
	 * @param account
	 * @return
	 */
	public static String filterAccount(String account) {
		if (StrKit.notBlank(account)) {
			if (account.matches(User.Pattern.PHONE)) {
				// 手机号取前3位和后2位
				String prefix = account.substring(0, 3);
				String suffix = account.substring(9);
				return prefix + "******" + suffix;
			} else if (account.matches(User.Pattern.EMAIL)) {
				// 邮箱取前2位和@符号前一位到最后一位
				String prefix = account.substring(0, 2);
				int index = account.indexOf("@") - 1;
				String suffix = account.substring(index);
				return prefix + "******" + suffix;
			}
		}
		return "";
	}
}
