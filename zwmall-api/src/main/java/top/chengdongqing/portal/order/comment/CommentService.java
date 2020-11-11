package top.chengdongqing.portal.order.comment;

import java.util.List;
import java.util.stream.Collectors;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.GoodsComment;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.OrderExpress;
import top.chengdongqing.common.model.OrderGoods;

/**
 * 订单评价相关逻辑层
 * 
 * @author Luyao
 *
 */
public class CommentService {

	@Inject
	Order dao;

	@Inject
	OrderExpress expressDao;

	@Inject
	OrderGoods orderGoodsDao;

	/**
	 * 查询所有待评论的订单
	 * 
	 * @param token
	 * @return
	 */
	public List<Order> findAll(int userId) {
		// 查询订单列表
		String orderSql = "select orderNo, payAmount, createTime from `order` where userId = ? and status = ? order by createTime desc";
		List<Order> comments = dao.find(orderSql, userId, Order.Status.RECEIPTED.getCode());
		String goodsesSql = "select goodsId, thumbUrl from order_goods where orderNo = ? and scoreStatus = ? order by createTime desc";
		comments.forEach(comment -> {
			// 查询该订单下的待评价商品列表
			List<OrderGoods> goodses = orderGoodsDao.find(goodsesSql, comment.getOrderNo(), Status.ENABLED);
			comment.put("goodses", goodses);
		});

		return comments;
	}

	/**
	 * 获取待评论订单详情
	 * 
	 * @param orderNo
	 * @param userId
	 * @return
	 */
	public Ret findDetails(String orderNo, int userId) {
		Order order = getOrderByOrderNo(orderNo, userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 查询该订单的快递信息
		String sql = "select packagingScore, speedScore, comment, scoreStatus from order_express where orderNo = ? limit 1";
		OrderExpress express = expressDao.findFirst(sql, orderNo);
		if (express.getScoreStatus() == Status.ENABLED) {
			express.setComment("");
		}

		// 查询该订单下的商品
		sql = "select goodsId, skuId, name, thumbUrl, score, comment, photoUrls, scoreStatus from order_goods where orderNo = ? order by createTime desc";
		List<OrderGoods> goodses = orderGoodsDao.find(sql, orderNo).parallelStream().map((goods) -> {
			if (goods.getScoreStatus() == Status.ENABLED) {
				goods.setComment("");
			}
			return goods;
		}).collect(Collectors.toList());
		return Ret.ok("express", express).set("goodses", goodses);
	}

	/**
	 * 根据订单号和用户id查询订单信息
	 * 
	 * @param orderNo
	 * @param userId
	 * @return
	 */
	private Order getOrderByOrderNo(String orderNo, int userId) {
		String sql = "select id from `order` where orderNo = ? and userId = ? limit 1";
		return dao.findFirst(sql, orderNo, userId);
	}

	/**
	 * 提交快递评价
	 * 
	 * @param express
	 * @param userId
	 * @return
	 */
	public Ret submitExpressComment(OrderExpress express, int userId) {
		Order order = getOrderByOrderNo(express.getOrderNo(), userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 查询订单快递信息
		String sql = "select id, scoreStatus from order_express where orderNo = ? limit 1";
		OrderExpress orderExpress = expressDao.findFirst(sql, express.getOrderNo());
		if (orderExpress == null || orderExpress.getScoreStatus() == Status.DISABLED) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 更新快递评价信息
		orderExpress.setPackagingScore(express.getPackagingScore());
		orderExpress.setSpeedScore(express.getSpeedScore());
		orderExpress.setComment(express.getComment());
		orderExpress.setScoreStatus(Status.DISABLED);
		return orderExpress.update() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.SUBMIT_FAIL);
	}

	/**
	 * 提交商品评价
	 * 
	 * @param goods
	 * @param userId
	 * @return
	 */
	public Ret submitGoodsComment(OrderGoods goods, int userId) {
		Order order = getOrderByOrderNo(goods.getOrderNo(), userId);
		if (order == null) {
			return Ret.fail(Constant.MSG, "该订单不存在");
		}

		// 查询该商品是否可评价
		String sql = "select id, goodsId, scoreStatus from order_goods where orderNo = ? and skuId = ? limit 1";
		OrderGoods orderGoods = orderGoodsDao.findFirst(sql, goods.getOrderNo(), goods.getSkuId());
		if (orderGoods == null || orderGoods.getScoreStatus() == Status.DISABLED) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 更新订单商品评价信息
		orderGoods.setScore(goods.getScore());
		orderGoods.setComment(goods.getComment());
		orderGoods.setScoreStatus(Status.DISABLED);
		orderGoods.setPhotoUrls(goods.getPhotoUrls());

		// 保存到商品评价记录
		GoodsComment comment = new GoodsComment();
		comment.setUserId(userId);
		comment.setOrderNo(goods.getOrderNo());
		comment.setGoodsId(orderGoods.getGoodsId());
		comment.setScore(goods.getScore());
		comment.setContent(goods.getComment());
		comment.setPhotoUrls(goods.getPhotoUrls());

		boolean isOk = Db.tx(() -> {
			return orderGoods.update() && comment.save();
		});
		if (isOk) {
			// 如果该订单的所有商品都已评价，则更新订单状态
			sql = "select count(*) from order_goods where orderNo = ? and scoreStatus = ?";
			int totalCount = Db.queryInt(sql, goods.getOrderNo(), Status.DISABLED);
			sql = "select count(*) from order_goods where orderNo = ?";
			int commentedCount = Db.queryInt(sql, goods.getOrderNo());
			if (commentedCount == totalCount) {
				order.setStatus(Order.Status.COMMENTED.getCode());
				order.update();
			}
			return Ret.ok();
		}
		return Ret.fail(Constant.MSG, Fail.Msg.SUBMIT_FAIL);
	}
}
