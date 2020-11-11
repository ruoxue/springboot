package top.chengdongqing.portal.goods.category;

import java.util.List;
import java.util.stream.Collectors;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import top.chengdongqing.common.model.Banner;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.model.GoodsCategory;

/**
 * 商品类别相关业务层
 * 
 * @author Luyao
 *
 */
public class CategoryService {

	@Inject
	GoodsCategory dao;

	@Inject
	Goods goodsDao;

	/**
	 * 获取全部类别
	 * 
	 * @return
	 */
	public List<GoodsCategory> findAll() {
		String sql = "select id, name from goods_category where parentId != 0 order by sortNo, createTime";
		return dao.find(sql);
	}

	/**
	 * 获取首页主角类别
	 * 
	 * @return
	 */
	public List<GoodsCategory> findHeroCategories() {
		// 分组查询商品类别
		List<GoodsCategory> categories = dao.template("category.groups").find();

		// 查询该分组下的商品
		String sql = "select id, thumbUrl, `name` from goods where categoryId in (#(categoryId)) order by createTime desc limit 24";
		categories.forEach(e -> {
			List<Goods> goodses = goodsDao.templateByString(sql, Kv.by("categoryId", e.getStr("ids"))).find();
			e.put("goodses", goodses);
			e.remove("parentSortNo");
			e.remove("ids");
		});
		return categories;
	}

	/**
	 * 获取首页类别块
	 * 
	 * @return
	 */
	public List<GoodsCategory> findBrickCategories() {
		String sqlForCategory = "select id, `name` from goods_category where parentId != 0 order by sortNo, createTime limit 6";
		List<GoodsCategory> categories = dao.find(sqlForCategory);

		String sqlForGoods = "select id, `name`, thumbUrl, price, title, skuType from goods where categoryId = ? order by createTime desc limit 8";
		String sqlForAdvert = "select * from banner where type = ? and categoryId = ? limit 2";
		return categories.stream().map(e -> {
			// 查询该类别下的商品
			List<Goods> goodses = goodsDao.find(sqlForGoods, e.getId());
			e.put("goodses", goodses);
			// 查询该类别下的广告图
			List<Record> adverts = Db.find(sqlForAdvert, Banner.Type.CATEGORY, e.getId());
			e.put("adverts", adverts);
			return e;
		}).filter(e -> {
			// 过滤商品或广告数量不足的类别
			List<Goods> goodses = e.get("goodses");
			List<Record> adverts = e.get("adverts");
			return goodses.size() >= 8 && adverts.size() >= 1;
		}).collect(Collectors.toList());
	}
}
