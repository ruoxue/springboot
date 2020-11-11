package top.chengdongqing.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.kit.Fail;

/**
 * 参数非空拦截器
 * 
 * @author Luyao
 *
 */
public class NotBlankInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// 判断该方法是否添加了该注解
		NotBlank params = inv.getMethod().getAnnotation(NotBlank.class);
		// 判断该注解是否有参数
		if (params != null && params.value().length > 0) {
			Controller c = inv.getController();
			for (String key : params.value()) {
				// 如果该参数为空，则直接返回为空提示
				if (StrKit.isBlank(c.get(key))) {
					c.renderJson(Fail.setMsg(Fail.Msg.PARAM_EMPTY));
					return;
				}
			}
		}
		inv.invoke();
	}
}
