package top.chengdongqing.common.kit;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.kit.StrKit;

/**
 * IP地址获取工具类
 * 
 * @author Luyao
 *
 */
public class IpKit {

	/**
	 * 获取客户端IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		// 经过Nginx代理后获取ip的方式
		String ip = request.getHeader("X-Real-IP");
		if (StrKit.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			// 通过JDK自带的方式获取
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
