package top.chengdongqing.manage.goods;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.model.GoodsBanner;
import top.chengdongqing.common.model.GoodsSku;
import top.chengdongqing.common.model.Order;

/**
 * 商品管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class GoodsService {

	@Inject
	Goods dao;

	@Inject
	GoodsBanner bannerDao;

	@Inject
	GoodsSku skuDao;

	/**
	 * 分页查询商品
	 * 
	 * @param status
	 * @param keyword
	 * @param categoryId
	 * @param brandId
	 * @param sortMode
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<Goods> paginate(int status, String keyword, String categoryId, String brandId, int sortMode,
			int pageNumber, int pageSize) {
		// 查询商品列表
		Kv params = Kv.by("status", status).set("keyword", keyword).set("categoryId", categoryId);
		params.set("brandId", brandId).set("sortMode", sortMode);
		params.set("paidCode", Order.Status.PAID.getCode()).set("complateCode", Order.Status.COMMENTED.getCode());
		return dao.template("admin.goods.paginate", params).paginate(pageNumber, pageSize);
	}

	/**
	 * 更新商品状态
	 * 
	 * @param id
	 * @return
	 */
	public Ret updateStatus(int id) {
		Goods goods = dao.findByIdLoadColumns(id, "id, status");
		if (goods == null) {
			return Ret.fail(Constant.MSG, "该商品不存在");
		}

		goods.setStatus(goods.getStatus() == 0 ? 1 : 0);
		return goods.update() && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 删除商品
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteGoods(int id) {
		Goods goods = dao.findByIdLoadColumns(id, "id");
		if (goods == null) {
			return Ret.fail(Constant.MSG, "该商品不存在");
		}

		// 如果已存在该商品相关的订单则禁止删除
		String sql = "select id from order_goods where goodsId = ? limit 1";
		if (Db.findFirst(sql, id) != null) {
			return Ret.fail(Constant.MSG, "已存在该商品相关的订单，禁止删除");
		}

		if (goods.delete()) {
			// 删除商品规格及轮播图
			sql = "delete t1, t2 from goods_sku t1 join goods_banner t2 on t1.goodsId = t2.goodsId where t1.goodsId = ?";
			if (Db.delete(sql, id) > 0 && clearCache()) {
				return Ret.ok();
			}
		}
		return Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 批量更新商品状态
	 * 
	 * @param ids
	 * @param status
	 * @return
	 */
	public Ret batchUpdateStatus(String ids, int status) {
		if (status != 0 && status != 1) {
			return Ret.fail(Constant.MSG, "参数错误");
		}

		String sql = "update goods set status = #para(status) where id in (#(ids))";
		int count = Db.templateByString(sql, Kv.by("status", status).set("ids", ids)).update();
		return count > 0 && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 清除前台商品相关缓存
	 * 
	 * @return
	 */
	private boolean clearCache() {
		CacheKit.removeAll("/goods/hotGoodses");
		CacheKit.removeAll("goodsDetails");
		CacheKit.removeAll("skus");
		CacheKit.removeAll("sku");
		return true;
	}

	/**
	 * 保存商品
	 * 
	 * @param goods
	 * @param banners
	 * @param skus
	 * @return
	 */
	public Ret saveGoods(Goods goods, String banners, String skus) {
		// 判断该商品名称是否已存在
		String sql = "select id from goods where `name` = ? limit 1";
		if (dao.findFirst(sql, goods.getName()) != null) {
			return Ret.fail(Constant.MSG, "该商品名称已存在");
		}

		// 解析轮播图
		List<GoodsBanner> bannerList = JSON.parseArray(banners, GoodsBanner.class);
		// 解析商品规格
		List<GoodsSku> skuList = JSON.parseArray(skus, GoodsSku.class);
		// 去除无用信息
		goods.remove("id", "status", "createTime");

		boolean isOk = Db.tx(() -> {
			// 保存商品信息
			boolean goodsSaved = goods.save();

			// 保存轮播图
			int bannerCount = 0;
			for (GoodsBanner banner : bannerList) {
				banner.remove("id", "createTime");
				banner.setGoodsId(goods.getId());
				if (banner.save()) {
					bannerCount++;
				}
			}
			// 保存商品规格
			int skuCount = 0;
			for (GoodsSku sku : skuList) {
				sku.remove("id", "createTime");
				sku.setGoodsId(goods.getId());
				sku.setBannersId(bannerList.get(sku.getBannersId()).getId());
				sku.setSortNo(skuCount);
				if (sku.save()) {
					skuCount++;
				}
			}

			// 提交事务
			return goodsSaved && bannerCount == bannerList.size() && skuCount == skuList.size();
		});

		return isOk && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 更新商品信息
	 * 
	 * @param goods
	 * @param banners
	 * @param skus
	 * @return
	 */
	public Ret updateGoods(Goods goods, String banners, String skus) {
		// 判断该商品是否已存在
		Goods oldGoods = dao.findByIdLoadColumns(goods.getId(), "id, name");
		if (oldGoods == null) {
			return Ret.fail(Constant.MSG, "该商品不存在");
		}
		// 判断该商品名称是否已存在且非当前商品
		if (!goods.getName().equals(oldGoods.getName())) {
			String sql = "select id from goods where `name` = ? limit 1";
			if (dao.findFirst(sql, goods.getName()) != null) {
				return Ret.fail(Constant.MSG, "该商品名称已存在");
			}
		}

		// 解析轮播图
		List<GoodsBanner> bannerList = JSON.parseArray(banners, GoodsBanner.class);
		// 解析商品规格
		List<GoodsSku> skuList = JSON.parseArray(skus, GoodsSku.class);
		// 去除无用信息
		goods.remove("status", "createTime", "updateTime");

		// 删除该商品已保存的轮播图
		String deletBannersSql = "delete from goods_banner where goodsId = ?";

		boolean isOk = Db.tx(() -> {
			// 更新商品
			boolean goodsUpdated = goods.update();

			// 删除旧轮播图
			Db.delete(deletBannersSql, goods.getId());

			// 保存轮播图
			int bannerCount = 0;
			for (GoodsBanner banner : bannerList) {
				banner.remove("id", "createTime");
				banner.setGoodsId(goods.getId());
				if (banner.save()) {
					bannerCount++;
				}
			}
			// 更新商品规格
			int skuCount = 0;
			for (GoodsSku sku : skuList) {
				sku.setBannersId(bannerList.get(sku.getBannersId()).getId());
				if (sku.update()) {
					skuCount++;
				}
			}

			// 提交事务
			return goodsUpdated && bannerCount == bannerList.size() && skuCount == skuList.size();
		});

		return isOk && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 获取商品详情
	 * 
	 * @param id
	 * @return
	 */
	public Ret findDetails(int id) {
		Goods goods = dao.findById(id);
		if (goods == null) {
			return Ret.fail(Constant.MSG, "该商品不存在");
		}

		// 查询轮播图及规格信息
		String bannersSql = "select * from goods_banner where goodsId = ?";
		List<GoodsBanner> banners = bannerDao.find(bannersSql, id);
		String skusSql = "select * from goods_sku where goodsId = ?";
		List<GoodsSku> skus = skuDao.find(skusSql, id);

		// 封装到商品信息中
		goods.put("banners", banners);
		goods.put("skus", skus);
		return Ret.ok("goods", goods);
	}

	/**
	 * 获取商品提示
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Record> getGoodsAssist(String keyword) {
		if (StrKit.isBlank(keyword)) {
			return new ArrayList<>();
		}
		String sql = "select id, name from goods where `name` like concat('%', ?, '%') limit 5";
		return Db.find(sql, keyword);
	}
}
