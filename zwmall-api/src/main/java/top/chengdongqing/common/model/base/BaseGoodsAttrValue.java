package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGoodsAttrValue<M extends BaseGoodsAttrValue<M>> extends Model<M> implements IBean {

	/**
	 * 商品类别属性值id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 商品类别属性值id
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 关联的商品类别属性名id
	 */
	public void setAttrId(java.lang.Integer attrId) {
		set("attrId", attrId);
	}
	
	/**
	 * 关联的商品类别属性名id
	 */
	public java.lang.Integer getAttrId() {
		return getInt("attrId");
	}

	/**
	 * 商品类别属性值
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 商品类别属性值
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	/**
	 * 更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		set("updateTime", updateTime);
	}
	
	/**
	 * 更新时间
	 */
	public java.util.Date getUpdateTime() {
		return get("updateTime");
	}

}
