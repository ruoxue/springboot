package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGoodsBanner<M extends BaseGoodsBanner<M>> extends Model<M> implements IBean {

	/**
	 * 商品轮播图集合id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 商品轮播图集合id
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 关联的商品id
	 */
	public void setGoodsId(java.lang.Integer goodsId) {
		set("goodsId", goodsId);
	}
	
	/**
	 * 关联的商品id
	 */
	public java.lang.Integer getGoodsId() {
		return getInt("goodsId");
	}

	/**
	 * 轮播图标识
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 轮播图标识
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 轮播图地址集合
	 */
	public void setUrls(java.lang.String urls) {
		set("urls", urls);
	}
	
	/**
	 * 轮播图地址集合
	 */
	public java.lang.String getUrls() {
		return getStr("urls");
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
