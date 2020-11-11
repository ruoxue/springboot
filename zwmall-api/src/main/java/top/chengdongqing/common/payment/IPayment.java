package top.chengdongqing.common.payment;

import java.math.BigDecimal;
import java.util.Map;

import com.jfinal.kit.Ret;

import top.chengdongqing.common.kit.Fail;

/**
 * 支付相关接口
 * 
 * @author Luyao
 *
 */
public interface IPayment {

	/**
	 * 请求付款
	 * 
	 * @param orderNo
	 * @param amount
	 * @param ip
	 * @return
	 */
	Ret requestPayment(String orderNo, BigDecimal amount, String ip);

	/**
	 * 支付成功回调参数解析
	 * 
	 * @param params
	 * @return
	 */
	Ret handleCallback(Map<String, String> params);

	/**
	 * 请求订单取消
	 * 
	 * @param orderNo
	 * @return
	 */
	Ret requestCancel(String orderNo);

	/**
	 * 请求订单退款
	 * 
	 * @param orderNo
	 * @param totalAmount
	 * @param refundAmount
	 * @return
	 */
	Ret requestRefund(String orderNo, BigDecimal totalAmount, BigDecimal refundAmount);

	/**
	 * 获取错误原因
	 * 
	 * @param resultMap
	 * @return
	 */
	default String buildMsg(Map<String, String> resultMap) {
		return Fail.Msg.OPERATION_FAIL;
	};
}
