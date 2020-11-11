package top.chengdongqing.common.interceptor;

import javax.servlet.http.HttpServletResponse;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * 跨域配置拦截器
 * 
 * @author Luyao
 *
 */
public class CrossDomainInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		Controller c = inv.getController();
		HttpServletResponse response = c.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		if (c.getRequest().getMethod().equalsIgnoreCase("OPTIONS")) {
			c.renderNull();
		} else {
			inv.invoke();
		}
	}
}
