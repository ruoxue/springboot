package top.chengdongqing.portal.order;

import java.util.Date;
import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.StringKit;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.OrderGoods;
import top.chengdongqing.common.model.OrderTime;
import top.chengdongqing.common.payment.Alipay;
import top.chengdongqing.common.payment.WechatPay;

/**
 * 订单相关逻辑层
 * 
 * @author Luyao
 *
 */
public class OrderService {

	@Inject
	Order dao;

	@Inject
	OrderGoods orderGoodsDao;

	@Inject
	OrderTime orderTimeDao;

	/**
	 * 根据订单号获取订单时间对象
	 * 
	 * @param orderNo
	 * @return
	 */
	public OrderTime getTimeByOrderNo(String orderNo) {
		String timeSql = "select id from order_time where orderNo = ? limit 1";
		return orderTimeDao.findFirst(timeSql, orderNo);
	}

	/**
	 * 分页查询订单列表
	 * 
	 * @param status
	 * @param keyword
	 * @param pageNumber
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public Page<Order> paginate(int status, String keyword,int goodsId,int type, int pageNumber, int pageSize, int userId) {
		// 查询订单列表
		Kv params = Kv.by("userId", userId).set("status", status).set("type", type)
				.set("keyword", keyword).set("goodsId",goodsId);
		Page<Order> paginate = dao.template("order.paginate", params).paginate(pageNumber, pageSize, true);

		String sql = "select goodsId, name, thumbUrl, price, count from order_goods where orderNo = ?";
		paginate.getList().forEach(order -> {
			// 获取订单状态描述
			order.put("statusDesc", Order.Status.getNameByCode(order.getStatus()));
			// 获取支付方式描述
			order.put("payMode", Order.PayMode.getNameByCode(order.getPayMode()));
			// 获取订单商品集合
			List<OrderGoods> goodses = orderGoodsDao.find(sql, order.getOrderNo());
			order.put("goodses", goodses);
		});

		return paginate;
	}




	/**
	 * 删除订单
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public Ret delete(int id, int userId) {
		Order order = getOrderById(id, userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 判断该订单是否可删除
		if (order.getStatus() >= 2 && order.getStatus() <= 32) {
			return Ret.fail(Constant.MSG, "当前状态不支持删除订单");
		}

		boolean isOk = Db.tx(() -> {
			boolean restoredStatus = true;
			// 恢复库存及删除订单及其关联信息
			if (order.getStatus().compareTo(Order.Status.ORDERED.getCode()) == 0) {
				restoredStatus = restoredStock(order.getOrderNo());
			}
			return restoredStatus && Db.template("order.delete", order.getOrderNo()).delete() > 0;
		});
		if (isOk) {
			return Ret.ok();
		}

		return Ret.fail(Constant.MSG, Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 根据订单id和用户id查询订单
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	private Order getOrderById(int id, int userId) {
		// 查询该订单信息
		String sql = "select id, status, orderNo from `order` where id = ? and userId = ? limit 1";
		return dao.findFirst(sql, id, userId);
	}

	/**
	 * 恢复商品库存
	 * 
	 * @param orderNo
	 * @param
	 */
	private boolean restoredStock(String orderNo) {
		// 查询该订单关联的商品
		String sqlForQuery = "select skuId, count from order_goods where orderNo = ?";
		List<OrderGoods> goodses = orderGoodsDao.find(sqlForQuery, orderNo);

		// 更新商品库存
		int count = 0;
		String sqlForStock = "update goods_sku set stock = stock + ? where id = ? limit 1";
		for (OrderGoods goods : goodses) {
			int updateCount = Db.update(sqlForStock, goods.getCount(), goods.getSkuId());
			if (updateCount > 0) {
				count++;
			}
		}

		// 禁止继续支付
		try {
			WechatPay.me().requestCancel(orderNo);
			Alipay.me().requestCancel(orderNo);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

		return count == goodses.size();
	}

	/**
	 * 自动取消超时未支付的订单
	 */
	public void orderCancelAuto() {
		// 查询所有待支付且创建时间超过30分钟的订单
		String sql = "select id, orderNo from `order` where status = ? and date_add(createTime, interval 30 minute) < now()";
		List<Order> orders = dao.find(sql, Order.Status.ORDERED.getCode());
		orders.forEach(order -> {
			order.setStatus(Order.Status.CANCELED.getCode());
			if (order.update()) {
				// 记录取消时间
				OrderTime time = getTimeByOrderNo(order.getOrderNo());
				if (time != null) {
					time.setCancelTime(new Date());
					time.update();
				}

				// 恢复库存并关闭订单
				restoredStock(order.getOrderNo());
			}
		});
	}

	/**
	 * 查询订单详情
	 * 
	 * @param orderNo
	 * @param userId
	 * @return
	 */
	public Ret findDetails(String orderNo, int userId) {
		// 查询订单基本信息
		String sql = "select id, orderNo, status, goodsAmount, payMode, expressFee, discountAmount, payAmount, createTime, remark from `order` where orderNo = ? and userId = ? limit 1";
		Order order = dao.findFirst(sql, orderNo, userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 查询订单商品信息
		sql = "select goodsId, name, thumbUrl, price, count from order_goods where orderNo = ?";
		List<OrderGoods> goodses = orderGoodsDao.find(sql, orderNo);
		order.put("goodses", goodses);

		// 查询订单时间信息
		sql = "select paidTime, preparedTime, shippedTime, receiptedTime, cancelTime, refundTime, createTime from order_time where orderNo = ? limit 1";
		order.put("timeInfo", Db.findFirst(sql, orderNo));

		// 查询订单快递信息
		if (order.getStatus() >= Order.Status.SHIPPED.getCode()
				&& order.getStatus() <= Order.Status.COMMENTED.getCode()) {
			sql = "select name, linkUrl, waybillNo from order_express where orderNo = ? limit 1";
			order.put("expressInfo", Db.findFirst(sql, orderNo));
		}

		// 查询订单收货信息
		sql = "select consignee, phone, province, city, district, address from order_address where orderNo = ? limit 1";
		Record shippingInfo = Db.findFirst(sql, orderNo);
		shippingInfo.set("phone", StringKit.filterAccount(shippingInfo.getStr("phone")));
		order.put("shippingInfo", shippingInfo);

		// 获取订单状态和支付方式描述
		order.put("statusDesc", Order.Status.getNameByCode(order.getStatus()));
		order.put("payMode", Order.PayMode.getNameByCode(order.getPayMode()));

		return Ret.ok("order", order);
	}

	/**
	 * 取消订单
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public Ret cancelOrder(int id, int userId) {
		// 查询该订单是否存在
		Order order = getOrderById(id, userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 判断该订单状态
		if (order.getStatus().compareTo(Order.Status.ORDERED.getCode()) != 0) {
			return Ret.fail(Constant.MSG, "当前状态无法取消订单");
		}

		// 更新状态及恢复库存
		order.setStatus(Order.Status.CANCELED.getCode());
		boolean isOk = Db.tx(() -> {
			return order.update() && restoredStock(order.getOrderNo());
		});

		return isOk ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 申请订单退款
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public Ret refundOrder(int id, int userId) {
		// 查询该订单是否存在
		Order order = getOrderById(id, userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 判断该订单状态
		if (order.getStatus().compareTo(Order.Status.PAID.getCode()) != 0) {
			return Ret.fail(Constant.MSG, "当前状态无法申请退款");
		}

		// 更新订单状态、申请退款及恢复库存
		order.setStatus(Order.Status.REFUNDING.getCode());
		boolean isOk = Db.tx(() -> {
			return order.update() && restoredStock(order.getOrderNo());
		});

		return isOk ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 确认收货处理
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public Ret confirmReceipt(int id, int userId) {
		Order order = getOrderById(id, userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 判断订单状态
		if (order.getStatus().compareTo(Order.Status.SHIPPED.getCode()) != 0) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 更新订单状态
		order.setStatus(Order.Status.RECEIPTED.getCode());
		if (order.update()) {
			// 保存收货时间
			OrderTime time = getTimeByOrderNo(order.getOrderNo());
			time.setReceiptedTime(new Date());
			time.update();
			return Ret.ok();
		}
		return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}

	public Order getMaxOrderByGoodsId(int goodsId) {
//dao.findFirst()

		return dao.findFirst("select id,payAmount from `order` where goodsId =? order by payAmount desc limit 1", goodsId);




	}
}
