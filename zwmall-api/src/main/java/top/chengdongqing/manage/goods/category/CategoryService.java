package top.chengdongqing.manage.goods.category;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.GoodsCategory;

/**
 * 商品类别管理逻辑层
 * 
 * @author Luyao
 *
 */
public class CategoryService {

	@Inject
	GoodsCategory dao;

	/**
	 * 获取商品类别
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsCategory> findCategoryies(int parentId) {
		return dao.template("admin.category.findCategories", Kv.by("parentId", parentId)).find();
	}

	/**
	 * 添加商品类别
	 * 
	 * @param parentId
	 * @param name
	 * @return
	 */
	public Ret saveCategory(int parentId, String name) {
		if (hasName(name)) {
			return Ret.fail(Constant.MSG, "该类别名称已存在");
		}

		// 保存类别
		GoodsCategory category = new GoodsCategory();
		category.setName(name);
		category.setParentId(parentId);
		category.setSortNo(getNewSortNo(parentId));
		return category.save() && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 获取新排序号
	 * 
	 * @param parentId
	 * @return
	 */
	private int getNewSortNo(int parentId) {
		String sql = "select sortNo from goods_category where parentId = ? order by sortNo desc limit 1";
		GoodsCategory category = dao.findFirst(sql, parentId);
		return category == null ? 0 : category.getSortNo() + 1;
	}

	/**
	 * 查询该类别名称是否存在
	 * 
	 * @param name
	 * @return
	 */
	private boolean hasName(String name) {
		String sql = "select id from goods_category where name = ? limit 1";
		return dao.findFirst(sql, name) != null;
	}

	/**
	 * 更新类别
	 * 
	 * @param category
	 * @return
	 */
	public Ret updateCategory(GoodsCategory category) {
		GoodsCategory oldCategory = dao.findByIdLoadColumns(category.getId(), "id, name");
		if (oldCategory == null) {
			return Ret.fail(Constant.MSG, "该类别不存在");
		}
		if (!category.getName().equals(oldCategory.getName()) && hasName(category.getName())) {
			return Ret.fail(Constant.MSG, "该类别名称已存在");
		}

		oldCategory.setName(category.getName());
		oldCategory.setParentId(category.getParentId());
		return oldCategory.update() && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 删除类别
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteCategory(int id) {
		GoodsCategory category = dao.findByIdLoadColumns(id, "id, parentId");
		if (category == null) {
			return Ret.fail(Constant.MSG, "该类别不存在");
		}
		if (category.isRoot()) {
			// 如果是根类别，没有子类别才可删除
			String sql = "select id from goods_category where parentId = ? limit 1";
			if (dao.findFirst(sql, id) != null) {
				return Ret.fail(Constant.MSG, "请先删除该类别下的所有子类别");
			}
		} else {
			// 如果是子类别，没有下属商品才可删除
			String sql = "select id from goods where categoryId = ? limit 1";
			if (Db.findFirst(sql, id) != null) {
				return Ret.fail(Constant.MSG, "请先删除该类别下的所有商品");
			}
		}

		// 删除该类别
		return category.delete() && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 类别排序
	 * 
	 * @param id
	 * @param direction
	 * @return
	 */
	public Ret categorySort(int id, int direction) {
		GoodsCategory category = dao.findByIdLoadColumns(id, "id, parentId, sortNo");
		if (category == null) {
			return Ret.fail(Constant.MSG, "该类别不存在");
		}

		// direction等于0为上移，获取该类别的上一个类别，否则相反
		StringBuilder sql = new StringBuilder("select id, sortNo from goods_category where parentId = ? and sortNo ");
		sql.append(direction == 0 ? "<" : ">").append(" ? order by sortNo ");
		sql.append(direction == 0 ? "desc" : "asc").append(" limit 1");
		GoodsCategory brotherCategory = dao.findFirst(sql.toString(), category.getParentId(), category.getSortNo());
		if (brotherCategory == null) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 交换排序号
		int sortNo = brotherCategory.getSortNo();
		brotherCategory.setSortNo(category.getSortNo());
		category.setSortNo(sortNo);
		boolean isOk = Db.tx(() -> {
			return category.update() && brotherCategory.update();
		});
		return isOk && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 清除前台类别相关的缓存
	 * 
	 * @return
	 */
	private boolean clearCache() {
		String[] keys = { "/category", "/category/heroCategories", "/category/brickCategories" };
		for (String key : keys) {
			CacheKit.removeAll(key);
		}
		return true;
	}

	/**
	 * 根据子类别id获取父类别id
	 * 
	 * @param id
	 * @return
	 */
	public Integer findParentId(int id) {
		String sql = "select parentId from goods_category where id = ? limit 1";
		return Db.queryInt(sql, id);
	}
}
