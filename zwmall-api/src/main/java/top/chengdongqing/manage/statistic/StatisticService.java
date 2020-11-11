package top.chengdongqing.manage.statistic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;

import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.model.Order;

/**
 * 统计相关逻辑层
 * 
 * @author Luyao
 *
 */
public class StatisticService {

	@Inject
	Goods goodsDao;

	/**
	 * 查询订单成交数据
	 * 
	 * @return
	 */
	public Kv findPaidAmounts() {
		// 查询今日成交金额
		SqlPara params = new SqlPara().addPara(Order.Status.PAID.getCode()).addPara(Order.Status.COMMENTED.getCode());
		String todayAmount = Db.template("admin.statistic.todayAmount", params.getPara()).queryStr();

		// 查询近一年的订单成交金额
		List<Record> records = Db.template("admin.statistic.lastYearAmounts", params.getPara()).find();

		// 从一年前的这个月开始统计往后的12个月每个月的成交金额
		BigDecimal[] lastYearAmounts = new BigDecimal[12];
		// 开始计算的日期
		LocalDate startDate = LocalDate.now().minusYears(1);
		for (int i = 0; i < 12; i++) {
			LocalDate stepDate = startDate.plusMonths(i);
			LocalDate endDate = stepDate.plusMonths(1);
			lastYearAmounts[i] = records.stream().filter(record -> {
				LocalDate paidTime = record.getDate("paidTime").toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();
				boolean inStartDate = paidTime.isEqual(stepDate) || paidTime.isAfter(stepDate);
				boolean inEndDate = paidTime.isBefore(endDate) || paidTime.isEqual(endDate);
				return inStartDate && inEndDate;
			}).map(record -> record.getBigDecimal("payAmount")).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
		return Kv.by("todayAmount", todayAmount).set("lastYearAmounts", lastYearAmounts);
	}

	/**
	 * 核心数据统计
	 * 
	 * @return
	 */
	public Kv findCoreStatistics() {
		// 获取订单数量
		int orderCount = Db.queryInt("select count(*) from `order`");
		// 获取今日订单数量
		int newOrderCount = Db.queryInt("select count(*) from `order` where to_days(createTime) = to_days(curdate())");
		// 获取商品数量
		int goodsCount = Db.queryInt("select count(*) from goods");
		// 获取今日上新商品数量
		int newGoodsCount = Db.queryInt("select count(*) from goods where to_days(createTime) = to_days(curdate())");
		// 获取用户数量
		int userCount = Db.queryInt("select count(*) from `user`");
		// 获取今日新增用户数量
		int newUserCount = Db.queryInt("select count(*) from `user` where to_days(createTime) = to_days(curdate())");
		// 获取待付款订单数量
		int waitingPaidOrderCount = Db.queryInt("select count(*) from `order` where status = ?",
				Order.Status.ORDERED.getCode());
		// 获取今日取消的订单数量
		int cancelOrderCount = Db
				.queryInt("select count(*) from order_time where to_days(cancelTime) = to_days(curdate())");

		// 封装统计数据
		Kv statistics = Kv.by("orderCount", orderCount).set("newOrderCount", newOrderCount);
		statistics.set("goodsCount", goodsCount).set("newGoodsCount", newGoodsCount);
		statistics.set("userCount", userCount).set("newUserCount", newUserCount);
		statistics.set("waitingPaidOrderCount", waitingPaidOrderCount).set("cancelOrderCount", cancelOrderCount);
		return statistics;
	}

	/**
	 * 查询销售排行榜
	 * 
	 * @return
	 */
	public List<Record> findSalesRank() {
		// 查询销量高的商品信息
		SqlPara params = new SqlPara().addPara(Order.Status.PAID.getCode());
		params.addPara(Order.Status.COMMENTED.getCode());
		List<Record> records = Db.template("admin.statistic.salesRank", params.getPara()).find();

		// 查询每个规格对应的商品名称信息
		String queryGoods = "select name, thumbUrl, unit, skuType from goods where id = ? limit 1";
		String querySku = "select t1.name, t2.urls thumbUrl from goods_sku t1 left join goods_banner t2 on t1.bannersId = t2.id where t1.id = ? limit 1";
		records.forEach(record -> {
			Goods goods = goodsDao.findFirst(queryGoods, record.getInt("goodsId"));
			record.setColumns(goods);
			String name = goods.getName();
			if (goods.hasVariousSpec()) {
				// 查询规格名称
				Record sku = Db.findFirst(querySku, record.getInt("skuId"));
				name += " " + sku.getStr("name");
				record.set("thumbUrl", sku.getStr("thumbUrl").split(",")[0]);
			}
			record.set("name", name);
			record.remove("skuType", "goodsId", "skuId");
		});
		return records;
	}

	/**
	 * 查询品牌销售情况
	 * 
	 * @return
	 */
	public List<Record> findBrandSalesRank() {
		// 查询销售额前5的品牌
		SqlPara params = new SqlPara().addPara(Order.Status.PAID.getCode()).addPara(Order.Status.COMMENTED.getCode());
		List<Record> records = Db.template("admin.statistic.brandsRank", params.getPara()).find();

		// 查询商品总销售额
		String queryTotalAmount = "select sum(goodsAmount) from `order` where (status >= ? and status <= ?)";
		BigDecimal totalAmount = Db.queryBigDecimal(queryTotalAmount, params.getPara());
		if (totalAmount != null) {
			// 计算其它品牌销售额
			BigDecimal topBrandAmount = records.stream().map(record -> record.getBigDecimal("salesAmount"))
					.reduce(BigDecimal.ZERO, BigDecimal::add);
			BigDecimal othersTotalAmount = totalAmount.subtract(topBrandAmount);
			// 添加到集合
			records.add(new Record().set("brandName", "其它").set("salesAmount", othersTotalAmount));
		}
		return records;
	}

	/**
	 * 查询库存紧张的商品
	 * 
	 * @param keyword
	 * @param status
	 * @param pageSize
	 * @param pageNumber
	 * 
	 * @return
	 */
	public Page<Record> findWarningGoodses(String keyword, int status, int pageNumber, int pageSize) {
		Kv params = Kv.by("keyword", keyword).set("status", status);
		Page<Record> paginate = Db.template("admin.statistic.warningGoodses", params).paginate(pageNumber, pageSize);
		paginate.getList().forEach(e -> {
			e.set("thumbUrl", e.getStr("thumbUrl").split(",")[0]);
		});
		return paginate;
	}
}
