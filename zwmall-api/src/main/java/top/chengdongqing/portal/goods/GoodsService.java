package top.chengdongqing.portal.goods;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.model.GoodsBanner;
import top.chengdongqing.common.model.GoodsSku;
import top.chengdongqing.portal.goods.bo.SkuDetail;

/**
 * 商品相关业务层
 * 
 * @author Luyao
 *
 */
public class GoodsService {

	@Inject
	Goods dao;

	@Inject
	GoodsSku skuDao;

	/**
	 * 查询最新的10个商品
	 * 
	 * @return
	 */
	public List<Goods> findHotGoodses() {
		String sql = "select id, name from goods where status = ? order by createTime desc limit 10";
		return dao.find(sql, Status.ENABLED);
	}

	/**
	 * 获取搜索提示词
	 * 
	 * @param keyword
	 * @return
	 */
	public List<String> findPromptKeywords(String keyword) {
		String sql = "select name from goods where name like ? and status = ? order by createTime desc limit 10";
		return Db.query(sql, "%" + keyword + "%", Status.ENABLED);
	}

	/**
	 * 商品搜索
	 * 
	 * @param keyword
	 * @param categoryId
	 * @param brandId
	 * @param sort
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<Goods> searchGoodses(String keyword, int categoryId, int brandId,int type, String sort, int pageNumber,
			int pageSize) {
		// 搜索商品列表
		Kv params = Kv.by("keyword", keyword).set("categoryId", categoryId);
		params.set("brandId", brandId).set("sort", sort).set("type",type).set("status", Status.ENABLED);
		return dao.template("goods.search", params).paginate(pageNumber, pageSize);
	}

	/**
	 * 获取随机推荐的商品
	 * 
	 * @return
	 */
	public List<Goods> findRecommends() {
		return dao.template("goods.findRecommends", Status.ENABLED).find();
	}

	/**
	 * 查询商品详情
	 * 
	 * @param id
	 * @return
	 */
	public Goods findDetails(int id) {
		return CacheKit.get("goodsDetails", id, () -> {
			Goods goods = dao.findByIdLoadColumns(id,
					"id, name, sketchType,thumbUrl,introduction, sketch, specs, status,auctionTime,startTime");
			if (goods == null || goods.getStatus() == Constant.Status.DISABLED) {
				return null;
			}
			return goods;
		});
	}

	/**
	 * 获取商品规格
	 * 
	 * @param id
	 * @return
	 */
	public Ret findSkus(int id) {
		return CacheKit.get("skus", id, () -> {
			Goods goods = dao.findByIdLoadColumns(id, "id, name, introduction, maxBuy, skuType");
			if (goods == null) {
				return Ret.fail(Constant.MSG, "该商品不存在");
			}

			// 查询该商品所有的规格类别
			List<GoodsSku> skus = skuDao.template("goods.findSkus", id).find();
			if (skus.size() == 0) {
				return Ret.fail(Constant.MSG, "获取商品信息失败");
			}

			// 获取每个类别下的子项
			skus.forEach(sku -> {
				sku.put("sellout", sku.getStock() <= 0);
				sku.remove("stock");
			});
			return Ret.ok("goods", goods).set("skus", skus);
		});
	}

	/**
	 * 根据商品id和规格id查询商品规格详情
	 * 
	 * @param goodsId
	 * @param skuId
	 * @return
	 */
	public SkuDetail getSkuInfo(int goodsId, int skuId) {
		return CacheKit.get("sku", skuId, () -> {
			// 查询该规格详情
			Goods sku = dao.template("goods.skuInfo", goodsId, Status.ENABLED, skuId).findFirst();
			if (sku == null) {
				return null;
			}

			// 获取商品图片
			String thumbUrl = sku.getStr("bannerUrls").split(",")[0];
			// 获取商品全称
			StringBuilder name = new StringBuilder(sku.getStr("name"));
			if (sku.hasVariousSpec()) {
				name.append(" ").append(sku.getStr("skuName"));
			}
			// 获取其余信息
			BigDecimal price = sku.getBigDecimal("price");
			BigDecimal originalPrice = sku.getBigDecimal("originalPrice");
			int stock = sku.getInt("stock");
			int maxBuy = sku.getInt("maxBuy");

			// 封装商品信息
			return new SkuDetail(goodsId, skuId, name.toString(), thumbUrl, price, originalPrice, stock, maxBuy);
		});
	}


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
//				sku.setBannersId(90);
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
	private boolean clearCache() {
		CacheKit.removeAll("/goods/hotGoodses");
		CacheKit.removeAll("goodsDetails");
		CacheKit.removeAll("skus");
		CacheKit.removeAll("sku");
		return true;
	}
}
