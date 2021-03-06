package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGoodsBrand<M extends BaseGoodsBrand<M>> extends Model<M> implements IBean {

	/**
	 * 商品品牌id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 商品品牌id
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 商品品牌名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 商品品牌名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 商品品牌介绍
	 */
	public void setIntroduction(java.lang.String introduction) {
		set("introduction", introduction);
	}
	
	/**
	 * 商品品牌介绍
	 */
	public java.lang.String getIntroduction() {
		return getStr("introduction");
	}

	/**
	 * 商品品牌logo
	 */
	public void setLogoUrl(java.lang.String logoUrl) {
		set("logoUrl", logoUrl);
	}
	
	/**
	 * 商品品牌logo
	 */
	public java.lang.String getLogoUrl() {
		return getStr("logoUrl");
	}

	/**
	 * 排序号
	 */
	public void setSortNo(java.lang.Integer sortNo) {
		set("sortNo", sortNo);
	}
	
	/**
	 * 排序号
	 */
	public java.lang.Integer getSortNo() {
		return getInt("sortNo");
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
