package top.chengdongqing.portal.order;

import com.jfinal.aop.Aop;
import com.jfinal.plugin.cron4j.ITask;

/**
 * 自动取消超时未支付的订单
 * 
 * @author Luyao
 *
 */
public class OrderCancelTask implements ITask {
	
	OrderService orderSrv = Aop.get(OrderService.class);

	@Override
	public void run() {
		orderSrv.orderCancelAuto();
	}

	@Override
	public void stop() {
		
	}
}
