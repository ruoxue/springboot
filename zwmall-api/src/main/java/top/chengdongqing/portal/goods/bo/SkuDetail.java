package top.chengdongqing.portal.goods.bo;

import java.math.BigDecimal;

/**
 * 商品规格详情实体类
 * 
 * @author Luyao
 *
 */
public class SkuDetail {

	public SkuDetail() {}

	public SkuDetail(int goodsId, int skuId, String name, String thumbUrl, BigDecimal price, BigDecimal originalPrice,
			int stock, int maxBuy) {
		this.goodsId = goodsId;
		this.skuId = skuId;
		this.name = name;
		this.thumbUrl = thumbUrl;
		this.price = price;
		this.originalPrice = originalPrice;
		this.stock = stock;
		this.maxBuy = maxBuy;
	}

	private int goodsId;
	private int skuId;
	private String name;
	private String thumbUrl;
	private BigDecimal price;
	private BigDecimal originalPrice;
	private int stock;
	private int maxBuy;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMaxBuy() {
		return maxBuy;
	}

	public void setMaxBuy(int maxBuy) {
		this.maxBuy = maxBuy;
	}
}
