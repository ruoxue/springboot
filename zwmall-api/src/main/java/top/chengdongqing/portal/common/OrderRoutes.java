package top.chengdongqing.portal.common;

import com.jfinal.config.Routes;

import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.portal.order.OrderController;
import top.chengdongqing.portal.order.comment.CommentController;
import top.chengdongqing.portal.order.pay.PayController;
import top.chengdongqing.portal.order.submit.SubmitController;

/**
 * 订单相关路由
 * 
 * @author Luyao
 *
 */
public class OrderRoutes extends Routes {

	@Override
	public void config() {
		// 未登录拦截
		addInterceptor(new LoginAuthInterceptor());

		add("order/submit", SubmitController.class);
		add("order/pay", PayController.class);
		add("order", OrderController.class);
		add("order/comment", CommentController.class);
	}
}
