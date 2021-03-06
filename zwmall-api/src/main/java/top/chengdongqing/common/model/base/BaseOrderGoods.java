package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOrderGoods<M extends BaseOrderGoods<M>> extends Model<M> implements IBean {

	/**
	 * 订单详情id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 订单详情id
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 关联的订单号
	 */
	public void setOrderNo(java.lang.String orderNo) {
		set("orderNo", orderNo);
	}
	
	/**
	 * 关联的订单号
	 */
	public java.lang.String getOrderNo() {
		return getStr("orderNo");
	}

	/**
	 * 商品id
	 */
	public void setGoodsId(java.lang.Integer goodsId) {
		set("goodsId", goodsId);
	}
	
	/**
	 * 商品id
	 */
	public java.lang.Integer getGoodsId() {
		return getInt("goodsId");
	}

	/**
	 * 商品规格id
	 */
	public void setSkuId(java.lang.Integer skuId) {
		set("skuId", skuId);
	}
	
	/**
	 * 商品规格id
	 */
	public java.lang.Integer getSkuId() {
		return getInt("skuId");
	}

	/**
	 * 商品名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 商品名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 商品图片地址
	 */
	public void setThumbUrl(java.lang.String thumbUrl) {
		set("thumbUrl", thumbUrl);
	}
	
	/**
	 * 商品图片地址
	 */
	public java.lang.String getThumbUrl() {
		return getStr("thumbUrl");
	}

	/**
	 * 商品价格
	 */
	public void setPrice(java.math.BigDecimal price) {
		set("price", price);
	}
	
	/**
	 * 商品价格
	 */
	public java.math.BigDecimal getPrice() {
		return get("price");
	}

	/**
	 * 商品数量
	 */
	public void setCount(java.lang.Integer count) {
		set("count", count);
	}
	
	/**
	 * 商品数量
	 */
	public java.lang.Integer getCount() {
		return getInt("count");
	}

	/**
	 * 小计金额
	 */
	public void setAmount(java.math.BigDecimal amount) {
		set("amount", amount);
	}
	
	/**
	 * 小计金额
	 */
	public java.math.BigDecimal getAmount() {
		return get("amount");
	}

	/**
	 * 评价状态 0.待评价 1.已评价
	 */
	public void setScoreStatus(java.lang.Integer scoreStatus) {
		set("scoreStatus", scoreStatus);
	}
	
	/**
	 * 评价状态 0.待评价 1.已评价
	 */
	public java.lang.Integer getScoreStatus() {
		return getInt("scoreStatus");
	}

	/**
	 * 商品评分
	 */
	public void setScore(java.lang.Double score) {
		set("score", score);
	}
	
	/**
	 * 商品评分
	 */
	public java.lang.Double getScore() {
		return getDouble("score");
	}

	/**
	 * 商品评论内容
	 */
	public void setComment(java.lang.String comment) {
		set("comment", comment);
	}
	
	/**
	 * 商品评论内容
	 */
	public java.lang.String getComment() {
		return getStr("comment");
	}

	/**
	 * 分享的图片集合
	 */
	public void setPhotoUrls(java.lang.String photoUrls) {
		set("photoUrls", photoUrls);
	}
	
	/**
	 * 分享的图片集合
	 */
	public java.lang.String getPhotoUrls() {
		return getStr("photoUrls");
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
