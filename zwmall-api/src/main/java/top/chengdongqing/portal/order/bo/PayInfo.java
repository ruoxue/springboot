package top.chengdongqing.portal.order.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付信息对象
 * 
 * @author Luyao
 *
 */
public class PayInfo {

	public PayInfo() {

	}

	public PayInfo(String orderNo, String paymentNo, BigDecimal payAmount, Date paymentTime) {
		super();
		this.orderNo = orderNo;
		this.paymentNo = paymentNo;
		this.payAmount = payAmount;
		this.paymentTime = paymentTime;
	}
	
	// 订单号
	private String orderNo;
	// 支付平台订单号
	private String paymentNo;
	// 实际支付金额
	private BigDecimal payAmount;
	// 支付时间
	private Date paymentTime;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
}
