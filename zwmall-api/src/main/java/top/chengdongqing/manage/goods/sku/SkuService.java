package top.chengdongqing.manage.goods.sku;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.GoodsAttrKey;
import top.chengdongqing.common.model.GoodsAttrValue;
import top.chengdongqing.common.model.GoodsSku;
import top.chengdongqing.common.model.Order;

/**
 * 商品规格相关逻辑层
 * 
 * @author Luyao
 *
 */
public class SkuService {

	@Inject
	GoodsSku dao;

	@Inject
	GoodsAttrKey attrKeyDao;

	@Inject
	GoodsAttrValue attrValueDao;

	/**
	 * 获取商品规格信息
	 * 
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSku> findSkus(int goodsId) {
		Kv params = Kv.by("goodsId", goodsId);
		params.set("paidCode", Order.Status.PAID.getCode()).set("complateCode", Order.Status.COMMENTED.getCode());
		return dao.template("admin.sku.findSkus", params).find();
	}

	/**
	 * 获取商品属性列表
	 * 
	 * @return
	 */
	public List<GoodsAttrKey> findAttrs() {
		List<GoodsAttrKey> attrs = attrKeyDao.find("select id, name from goods_attr_key");

		String sql = "select id, name from goods_attr_value where attrId = ?";
		attrs.forEach(key -> {
			List<GoodsAttrValue> values = attrValueDao.find(sql, key.getId());
			key.put("values", values);
		});
		return attrs;
	}

	/**
	 * 新增属性
	 * 
	 * @param name
	 * @return
	 */
	public Ret saveAttr(String name) {
		if (hasAttrKey(name)) {
			return Ret.fail(Constant.MSG, "该属性名称已存在");
		}

		GoodsAttrKey key = new GoodsAttrKey();
		key.setName(name);
		return key.save() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 查询该属性是否存在
	 * 
	 * @param name
	 * @return
	 */
	private boolean hasAttrKey(String name) {
		String sql = "select id from goods_attr_key where name = ? limit 1";
		return attrKeyDao.findFirst(sql, name) != null;
	}

	/**
	 * 更新属性
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public Ret updateAttr(int id, String name) {
		GoodsAttrKey key = attrKeyDao.findByIdLoadColumns(id, "id, name");
		if (key == null) {
			return Ret.fail(Constant.MSG, "该属性不存在");
		}
		if (!name.equals(key.getName()) && hasAttrKey(name)) {
			return Ret.fail(Constant.MSG, "该属性名称已存在");
		}

		key.setName(name);
		return key.update() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 删除属性
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteAttr(int id) {
		// 查询该属性下是否有值
		String sql = "select id from goods_attr_value where attrId = ? limit 1";
		if (attrValueDao.findFirst(sql, id) != null) {
			return Ret.fail(Constant.MSG, "请先删除该属性下的全部值");
		}

		GoodsAttrKey key = new GoodsAttrKey();
		key.setId(id);
		return key.delete() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 添加属性值
	 * 
	 * @param keyId
	 * @param name
	 * @return
	 */
	public Ret saveVlaue(int keyId, String name) {
		// 查询该属性是否存在
		if (attrKeyDao.findById(keyId) == null) {
			return Ret.fail(Constant.MSG, "该属性不存在");
		}

		if (hasAttrValue(name)) {
			return Ret.fail(Constant.MSG, "该属性值已存在");
		}

		GoodsAttrValue value = new GoodsAttrValue();
		value.setAttrId(keyId);
		value.setName(name);
		return value.save() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 查询该值是否存在
	 * 
	 * @param name
	 * @return
	 */
	private boolean hasAttrValue(String name) {
		String sql = "select id from goods_attr_value where name = ? limit 1";
		return attrValueDao.findFirst(sql, name) != null;
	}

	/**
	 * 更新属性值
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public Ret updateValue(int id, String name) {
		GoodsAttrValue value = attrValueDao.findByIdLoadColumns(id, "id, name");
		if (value == null) {
			return Ret.fail(Constant.MSG, "该属性值不存在");
		}
		if (!name.equals(value.getName()) && hasAttrValue(name)) {
			return Ret.fail(Constant.MSG, "该属性值已存在");
		}

		value.setName(name);
		return value.update() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 删除属性值
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteValue(int id) {
		GoodsAttrValue value = new GoodsAttrValue();
		value.setId(id);
		return value.delete() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.DELETE_FAIL);
	}
}
