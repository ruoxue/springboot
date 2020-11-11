package top.chengdongqing.portal.order.pay;

import javax.websocket.server.ServerEndpoint;

import com.jfinal.kit.Ret;

import top.chengdongqing.common.websocket.BaseWS;

/**
 * 订单支付成功实时通知
 * 
 * @author Luyao
 *
 */
@ServerEndpoint("/pay/status.ws/{id}")
public class PaySuccessWS extends BaseWS {

	/**
	 * 发送支付成功通知
	 * 
	 * @param orderNo
	 */
	static void sendSuccessNotice(String orderNo) {
		send(orderNo, Ret.ok().toJson());
	}
}
