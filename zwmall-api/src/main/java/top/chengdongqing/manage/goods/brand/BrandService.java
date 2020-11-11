package top.chengdongqing.manage.goods.brand;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.GoodsBrand;

/**
 * 品牌管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class BrandService {

	@Inject
	GoodsBrand dao;

	/**
	 * 获取商品品牌
	 * 
	 * @return
	 */
	public List<GoodsBrand> findAll() {
		return dao.template("admin.brand.findBrands").find();
	}

	/**
	 * 新增品牌
	 * 
	 * @param brand
	 * @return
	 */
	public Ret saveBrand(GoodsBrand brand) {
		if (hasName(brand.getName())) {
			return Ret.fail(Constant.MSG, "该品牌名称已存在");
		}

		// 保存品牌
		brand.keep("name", "introduction", "logoUrl");
		brand.setSortNo(getNewSortNo());
		return brand.save() && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 获取新排序号
	 * 
	 * @return
	 */
	private int getNewSortNo() {
		String sql = "select sortNo from goods_brand order by sortNo desc limit 1";
		GoodsBrand brand = dao.findFirst(sql);
		return brand == null ? 0 : brand.getSortNo() + 1;
	}

	/**
	 * 查询该品牌名称是否已存在
	 * 
	 * @param name
	 * @return
	 */
	private boolean hasName(String name) {
		String sql = "select id from goods_brand where name = ? limit 1";
		return dao.findFirst(sql, name) != null;
	}

	/**
	 * 更新品牌
	 * 
	 * @param brand
	 * @return
	 */
	public Ret updateBrand(GoodsBrand brand) {
		GoodsBrand oldBrand = dao.findByIdLoadColumns(brand.getId(), "id, name");
		if (oldBrand == null) {
			return Ret.fail(Constant.MSG, "该品牌不存在");
		}
		if (!oldBrand.getName().equals(oldBrand.getName()) && hasName(oldBrand.getName())) {
			return Ret.fail(Constant.MSG, "该品牌名称已存在");
		}

		oldBrand.setName(brand.getName());
		oldBrand.setIntroduction(brand.getIntroduction());
		oldBrand.setLogoUrl(brand.getLogoUrl());
		return oldBrand.update() && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 删除品牌
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteBrand(int id) {
		GoodsBrand brand = dao.findByIdLoadColumns(id, "id");
		if (brand == null) {
			return Ret.fail(Constant.MSG, "该品牌不存在");
		}
		// 没有下属商品才可删除
		String sql = "select id from goods where brandId = ? limit 1";
		if (Db.findFirst(sql, id) != null) {
			return Ret.fail(Constant.MSG, "请先删除该品牌下的所有商品");
		}

		// 删除该类别
		return brand.delete() && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 品牌排序
	 * 
	 * @param id
	 * @param direction
	 * @return
	 */
	public Ret brandSort(int id, int direction) {
		GoodsBrand brand = dao.findByIdLoadColumns(id, "id, sortNo");
		if (brand == null) {
			return Ret.fail(Constant.MSG, "该品牌不存在");
		}

		// direction等于0为上移，获取该类别的上一个类别，否则相反
		StringBuilder sql = new StringBuilder("select id, sortNo from goods_brand where sortNo ");
		sql.append(direction == 0 ? "<" : ">").append(" ? order by sortNo ");
		sql.append(direction == 0 ? "desc" : "asc").append(" limit 1");
		GoodsBrand brotherBrand = dao.findFirst(sql.toString(), brand.getSortNo());
		if (brotherBrand == null) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 交换排序号
		int sortNo = brotherBrand.getSortNo();
		brotherBrand.setSortNo(brand.getSortNo());
		brand.setSortNo(sortNo);
		boolean isOk = Db.tx(() -> {
			return brand.update() && brotherBrand.update();
		});
		return isOk && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 清除前台品牌相关的缓存
	 * 
	 * @return
	 */
	private boolean clearCache() {
		String[] keys = { "/brand", "/brand/headerBrands" };
		for (String key : keys) {
			CacheKit.removeAll(key);
		}
		return true;
	}
}
