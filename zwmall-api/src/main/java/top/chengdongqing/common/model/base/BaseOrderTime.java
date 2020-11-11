package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOrderTime<M extends BaseOrderTime<M>> extends Model<M> implements IBean {

	/**
	 * 订单进度信息id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 订单进度信息id
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 关联订单号
	 */
	public void setOrderNo(java.lang.String orderNo) {
		set("orderNo", orderNo);
	}
	
	/**
	 * 关联订单号
	 */
	public java.lang.String getOrderNo() {
		return getStr("orderNo");
	}

	/**
	 * 付款时间
	 */
	public void setPaidTime(java.util.Date paidTime) {
		set("paidTime", paidTime);
	}
	
	/**
	 * 付款时间
	 */
	public java.util.Date getPaidTime() {
		return get("paidTime");
	}

	/**
	 * 配货时间
	 */
	public void setPreparedTime(java.util.Date preparedTime) {
		set("preparedTime", preparedTime);
	}
	
	/**
	 * 配货时间
	 */
	public java.util.Date getPreparedTime() {
		return get("preparedTime");
	}

	/**
	 * 发货时间
	 */
	public void setShippedTime(java.util.Date shippedTime) {
		set("shippedTime", shippedTime);
	}
	
	/**
	 * 发货时间
	 */
	public java.util.Date getShippedTime() {
		return get("shippedTime");
	}

	/**
	 * 收货时间
	 */
	public void setReceiptedTime(java.util.Date receiptedTime) {
		set("receiptedTime", receiptedTime);
	}
	
	/**
	 * 收货时间
	 */
	public java.util.Date getReceiptedTime() {
		return get("receiptedTime");
	}

	/**
	 * 取消时间
	 */
	public void setCancelTime(java.util.Date cancelTime) {
		set("cancelTime", cancelTime);
	}
	
	/**
	 * 取消时间
	 */
	public java.util.Date getCancelTime() {
		return get("cancelTime");
	}

	/**
	 * 退款时间
	 */
	public void setRefundTime(java.util.Date refundTime) {
		set("refundTime", refundTime);
	}
	
	/**
	 * 退款时间
	 */
	public java.util.Date getRefundTime() {
		return get("refundTime");
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	/**
	 * 更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		set("updateTime", updateTime);
	}
	
	/**
	 * 更新时间
	 */
	public java.util.Date getUpdateTime() {
		return get("updateTime");
	}

}
