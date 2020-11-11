package top.chengdongqing.portal.order.pay;

import java.math.BigDecimal;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;

import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.StringKit;
import top.chengdongqing.common.kit.XmlKit;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.Order.PayMode;
import top.chengdongqing.common.model.OrderTime;
import top.chengdongqing.common.payment.Alipay;
import top.chengdongqing.common.payment.WechatPay;
import top.chengdongqing.portal.order.OrderService;
import top.chengdongqing.portal.order.bo.PayInfo;

/**
 * 订单支付相关逻辑层
 * 
 * @author Luyao
 *
 */
public class PayService {

	@Inject
	Order dao;

	@Inject
	OrderService orderSrv;

	/**
	 * 查询订单基础信息
	 * 
	 * @param orderNo
	 * @param userId
	 * @return
	 */
	public Ret findDetails(String orderNo, int userId) {
		// 查询订单信息
		Order order = dao.template("order.baseDetails", orderNo, userId).findFirst();
		if (order == null) {
			return Fail.setMsg("该订单不存在");
		}
		order.put("phone", StringKit.filterAccount(order.getStr("phone")));
		return Ret.ok("order", order);
	}

	/**
	 * 请求订单付款
	 * 
	 * @param orderNo
	 * @param payMode
	 * @param userId
	 * @param ip
	 * @return
	 */
	public Ret requestPayment(String orderNo, int payMode, int userId, String ip) {
		// 查询该订单信息
		String sql = "select payAmount, status from `order` where orderNo = ? and userId = ? limit 1";
		Order order = dao.findFirst(sql, orderNo, userId);
		if (order == null) {
			return Fail.setMsg("该订单不存在");
		} else if (order.getStatus() != Order.Status.ORDERED.getCode()) {
			return Fail.setMsg("该订单禁止支付");
		}

		// 需付款金额
		BigDecimal amount = order.getPayAmount();

		// 判断支付方式
		if (payMode == Order.PayMode.WECHAT_PAY.getCode()) {
//			return Fail.setMsg("暂未配置微信支付账号信息，若你愿意，可提供给作者");
			 return WechatPay.me().requestPayment(orderNo, amount, ip);
		} else if (payMode == Order.PayMode.ALIPAY.getCode()) {
			return Alipay.me().requestPayment(orderNo, amount, ip);
		} else {
			throw new IllegalArgumentException("The payment mode is not exist");
		}
	}

	/**
	 * 支付回调处理
	 * 
	 * @param xml
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Ret paymentCallback(String xml, Kv params) {
		// 处理及验证回调的参数
		Ret result = null;
		if (xml != null) {
			result = WechatPay.me().handleCallback(XmlKit.xmlToMap(xml));
		} else {
			result = Alipay.me().handleCallback(params);
		}
		if (result.isFail()) {
			return result;
		}

		PayInfo payInfo = result.getAs("payInfo");
		String orderNo = payInfo.getOrderNo();

		// 查询该订单信息，校验订单金额是否一致
		String sql = "select id, payAmount from `order` where orderNo = ? limit 1";
		Order order = dao.findFirst(sql, orderNo);
		if (order == null || order.getPayAmount().compareTo(payInfo.getPayAmount()) != 0) {
			return result;
		}

		// 更新订单信息
		order.setStatus(Order.Status.PAID.getCode());
		order.setPayMode(xml != null ? PayMode.WECHAT_PAY.getCode() : PayMode.ALIPAY.getCode());
		order.setPaymentNo(payInfo.getPaymentNo());
		if (order.update()) {
			// 记录支付时间
			OrderTime time = orderSrv.getTimeByOrderNo(orderNo);
			if (time != null) {
				time.setPaidTime(payInfo.getPaymentTime());
				time.update();
			}

			// 通知客户端
			PaySuccessWS.sendSuccessNotice(orderNo);
		}
		return result;
	}
}
