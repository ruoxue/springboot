package top.chengdongqing.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.captcha.Captcha;
import com.jfinal.captcha.CaptchaCache;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.annotation.AccessLimit;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.IpKit;

/**
 * 接口访问限制拦截器
 * 
 * @author Luyao
 *
 */
public class AccessLimitInterceptor implements Interceptor {

	private static final CaptchaCache cache = new CaptchaCache();

	@Override
	public void intercept(Invocation inv) {
		AccessLimit limit = inv.getMethod().getAnnotation(AccessLimit.class);
		if (limit != null) {
			// 获取注解里定义的参数
			int expireTime = limit.expireTime();
			int times = limit.times();
			String limitKey = limit.limitKey();

			// 获取缓存中的访问信息
			Controller c = inv.getController();
			String actionKey = inv.getActionKey();
			String cacheKey = actionKey + "_";
			if (StrKit.notBlank(limitKey) && StrKit.notBlank(c.get(limitKey))) {
				cacheKey += c.get(limitKey);
			} else {
				cacheKey += IpKit.getIp(c.getRequest());
			}
			Captcha access = cache.get(cacheKey);

			// 判断是否存在访问记录及是否访问限制过期
			if (access == null || access.isExpired()) {
				cache.put(new Captcha(cacheKey, String.valueOf(1), expireTime));
			} else {
				// 判断访问的次数是否超过
				int accessed = Integer.valueOf(access.getValue());
				if (accessed >= times) {
					c.renderJson(Fail.setMsg(limit.msg()));
					return;
				} else {
					// 保存访问次数
					cache.put(new Captcha(cacheKey, String.valueOf(accessed + 1), expireTime));
				}
			}
		}
		inv.invoke();
	}
}
