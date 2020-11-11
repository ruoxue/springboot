package top.chengdongqing.manage.order;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

import top.chengdongqing.common.kit.ExcelKit;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.Order.PayMode;
import top.chengdongqing.common.model.OrderExpress;
import top.chengdongqing.common.model.OrderTime;
import top.chengdongqing.common.payment.Alipay;
import top.chengdongqing.common.payment.WechatPay;

/**
 * 订单管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class OrderService {

	@Inject
	Order dao;

	@Inject
	OrderTime timeDao;

	/**
	 * 查询订单
	 * 
	 * @param keyword
	 * @param status
	 * @param startDate
	 * @param endDate
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<Order> paginate(String keyword, int status, Date startDate, Date endDate, int pageNumber,
			int pageSize) {
		// 查询订单列表
		Kv params = Kv.by("keyword", keyword).set("status", status).set("startDate", startDate).set("endDate", endDate);
		Page<Order> paginate = dao.template("admin.order.paginate", params).paginate(pageNumber, pageSize);

		paginate.getList().forEach(order -> {
			// 订单状态描述
			order.put("statusDesc", Order.Status.getNameByCode(order.getStatus()));
		});
		return paginate;
	}

	/**
	 * 查询订单详情
	 * 
	 * @param id
	 * @return
	 */
	public Order findDetails(int id) {
		Order order = dao.findById(id);
		if (order == null) {
			throw new IllegalStateException("The order is not exist");
		}

		// 获取订单状态
		order.put("statusDesc", Order.Status.getNameByCode(order.getStatus()));
		// 获取支付方式
		order.put("payMode", Order.PayMode.getNameByCode(order.getPayMode()));
		// 查询用户信息
		String userSql = "select name, avatarUrl, phone from `user` where id = ? limit 1";
		order.put("user", Db.findFirst(userSql, order.getUserId()));
		// 查询时间信息
		order.put("time", Db.findFirst("select * from order_time where orderNo = ? limit 1", order.getOrderNo()));
		// 查询商品信息
		order.put("goodses", Db.find("select * from order_goods where orderNo = ?", order.getOrderNo()));
		// 查询收货信息
		order.put("shipping",
				Db.findFirst("select * from order_address where orderNo = ? limit 1", order.getOrderNo()));
		if (order.getStatus() >= Order.Status.SHIPPED.getCode()
				&& order.getStatus() <= Order.Status.COMMENTED.getCode()) {
			// 查询快递信息
			String expressSql = "select * from order_express where orderNo = ? limit 1";
			order.put("express", Db.findFirst(expressSql, order.getOrderNo()));
		}
		return order;
	}

	/**
	 * 确认订单已配货
	 * 
	 * @param id
	 * @return
	 */
	public Ret orderPrepared(int id) {
		Order order = getOrderById(id);

		// 判断该订单的状态是否是已付款
		if (order.getStatus() != Order.Status.PAID.getCode()) {
			return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
		}
		order.setStatus(Order.Status.PREPARED.getCode());

		// 更新配货时间
		OrderTime time = getTimeByOrderNo(order.getOrderNo());
		time.setPreparedTime(new Date());
		boolean isOk = Db.tx(() -> {
			return order.update() && time.update();
		});
		return isOk ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 根据id查询订单
	 * 
	 * @param id
	 * @return
	 */
	private Order getOrderById(int id) {
		Order order = dao.findByIdLoadColumns(id, "id, orderNo, status, payAmount, payMode");
		if (order == null) {
			throw new IllegalStateException("The order is not exist");
		}
		return order;
	}

	/**
	 * 根据订单号或 订单时间信息
	 * 
	 * @param orderNo
	 * @return
	 */
	private OrderTime getTimeByOrderNo(String orderNo) {
		return timeDao.findFirst("select id from order_time where orderNo = ? limit 1", orderNo);
	}

	/**
	 * 确认订单发货
	 * 
	 * @param orderId
	 * @param express
	 * @param adminId
	 * @return
	 */
	public Ret orderShipped(int orderId, OrderExpress express, int adminId) {
		Order order = getOrderById(orderId);

		// 判断该订单的状态是否是已配货
		if (order.getStatus() != Order.Status.PREPARED.getCode()) {
			return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
		}
		order.setStatus(Order.Status.SHIPPED.getCode());

		// 保存快递信息
		express.keep("name", "linkUrl", "waybillNo");
		express.setOrderNo(order.getOrderNo());
		express.setAdminId(adminId);

		// 更新发货时间
		OrderTime time = getTimeByOrderNo(order.getOrderNo());
		time.setShippedTime(new Date());
		boolean isOk = Db.tx(() -> {
			return order.update() && express.save() && time.update();
		});
		return isOk ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 订单退款处理
	 * 
	 * @param id
	 * @param remark
	 * @return
	 */
	public Ret orderRefund(int id, String remark) {
		Order order = getOrderById(id);
		// 判断该订单的状态是否是已配货
		if (order.getStatus() != Order.Status.REFUNDING.getCode()) {
			return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
		}
		order.setStatus(remark == null ? Order.Status.REFUNDED.getCode() : Order.Status.REFUND_FAIL.getCode());
		if (order.getStatus() == Order.Status.REFUND_FAIL.getCode()) {
			order.setRemark(remark);
		} else {
			// 请求支付平台退款
			Ret result = Ret.fail();
			BigDecimal payAmount = order.getPayAmount();
			if (order.getPayMode() == PayMode.WECHAT_PAY.getCode()) {
				result = WechatPay.me().requestRefund(order.getOrderNo(), payAmount, payAmount);
			} else {
				result = Alipay.me().requestRefund(order.getOrderNo(), payAmount, payAmount);
			}

			if (result.isOk()) {
				// 记录退款时间
				OrderTime time = getTimeByOrderNo(order.getOrderNo());
				time.setRefundTime(new Date());
			} else {
				return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
			}
		}

		return order.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 导出订单excel
	 * 
	 * @param status
	 * @param keyword
	 * @param startDate
	 * @param endDate
	 * @param response
	 * @return
	 */
	public byte[] getOrdersExcel(int status, String keyword, Date startDate, Date endDate) {
		List<Order> orders = paginate(keyword, status, startDate, endDate, 1, 1000000).getList();
		if (orders.size() == 0) {
			throw new IllegalStateException("没有查询到需要导出的数据");
		}

		// 获取列标题
		LinkedHashMap<String, String> titles = new LinkedHashMap<>();
		titles.put("orderNo", "订单号");
		titles.put("userPhone", "用户账号");
		titles.put("statusDesc", "订单状态");
		titles.put("statusDesc", "订单状态");
		titles.put("payAmount", "实付金额");
		titles.put("createTime", "下单时间");

		// 生成excel
		try {
			return ExcelKit.generateExcel(titles, orders);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


}
