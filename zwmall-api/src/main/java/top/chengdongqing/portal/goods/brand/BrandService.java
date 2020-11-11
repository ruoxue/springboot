package top.chengdongqing.portal.goods.brand;

import java.util.List;

import com.jfinal.aop.Inject;

import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.model.GoodsBrand;

/**
 * 商品品牌相关逻辑层
 * 
 * @author Luyao
 *
 */
public class BrandService {

	@Inject
	GoodsBrand dao;

	@Inject
	Goods goodsDao;

	/**
	 * 获取全部品牌
	 * 
	 * @return
	 */
	public List<GoodsBrand> findAll() {
		String sql = "select id, name from goods_brand order by sortNo, createTime";
		return dao.find(sql);
	}

	/**
	 * 获取头部品牌列表
	 * 
	 * @return
	 */
	public List<GoodsBrand> findHeaderBrands() {
		// 查询排名前10的品牌
		String sqlForBrand = "select id, name from goods_brand order by sortNo, createTime limit 10";
		List<GoodsBrand> brands = dao.find(sqlForBrand);

		// 查询每个品牌下的前6个商品
		String sqlForGoods = "select id, thumbUrl, name, price, skuType from goods where brandId = ? and status = ? order by createTime desc limit 6";
		brands.forEach(e -> {
			List<Goods> goodses = goodsDao.find(sqlForGoods, e.getId(), Status.ENABLED);
			e.put("goodses", goodses);
		});
		return brands;
	}
}
