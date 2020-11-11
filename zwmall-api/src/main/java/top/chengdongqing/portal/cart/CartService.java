package top.chengdongqing.portal.cart;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Cart;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.portal.goods.GoodsService;
import top.chengdongqing.portal.goods.bo.SkuDetail;

/**
 * 购物车逻辑层
 * 
 * @author Luyao
 *
 */

public class CartService {

	@Inject
	Cart dao;

	@Inject
	Goods goodsDao;

	@Inject
	GoodsService goodsSrv;

	/**
	 * 获取购物车信息
	 * 
	 * @param onlyChecked
	 * @param userId
	 * @return
	 */
	public List<Cart> findCart(boolean onlyChecked, int userId) {
		// 获取购物车中的商品
		List<Object> params = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(
				"select id, goodsId, skuId, name, thumbUrl, price, count, checked from cart where userId = ?");
		params.add(userId);
		// 仅获取已选中的商品
		if (onlyChecked) {
			sql.append(" and checked = ?");
			params.add(Status.ENABLED);
		}
		sql.append(" order by createTime desc");
		List<Cart> cart = dao.findByCache("cart", userId, sql.toString(), params.toArray());

		// 更新购物车信息
		cart.forEach(e -> {
			SkuDetail sku = goodsSrv.getSkuInfo(e.getGoodsId(), e.getSkuId());
			// 取消选中
			if (sku == null || e.getCount() > sku.getStock()) {
				e.setChecked(Status.DISABLED);
			}
			if (e.getPrice().compareTo(sku.getPrice()) != 0) {
				// 更新价格
				e.setPrice(sku.getPrice());
				e.update();
			}
		});

		return cart;
	}

	/**
	 * 添加商品到购物车
	 * 
	 * @param goodsId
	 * @param skuId
	 * @param userId
	 * @return
	 */
	public Ret put(int goodsId, int skuId, int userId) {
		// 查询规格详情
		SkuDetail sku = goodsSrv.getSkuInfo(goodsId, skuId);
		if (sku == null) {
			return Fail.setMsg("该商品不存在");
		}
		if (sku.getStock() <= 0) {
			return Fail.setMsg("该商品库存不足");
		}

		// 查询该商品在购物车里是否已存在
		String sql = "select id, count from cart where userId = ? and goodsId = ? and skuId = ? limit 1";
		Cart oldCart = dao.findFirst(sql, userId, goodsId, skuId);
		if (oldCart == null) {
			// 新增购物车记录
			Cart cart = new Cart();
			cart.setUserId(userId);
			cart.setGoodsId(goodsId);
			cart.setSkuId(skuId);
			cart.setName(sku.getName());
			cart.setThumbUrl(sku.getThumbUrl());
			cart.setPrice(sku.getPrice());
			if (cart.save()) {
				CacheKit.remove("cart", userId);
				return Ret.ok("id", cart.getId());
			}
		} else {
			// 如果没超出最大购买量则数量加一
			int count = oldCart.getCount();
			if (count < sku.getMaxBuy()) {
				oldCart.setCount(count + 1);
				if (oldCart.update()) {
					CacheKit.remove("cart", userId);
					return Ret.ok("id", oldCart.getId());
				}
			} else {
				return Fail.setMsg("商品加入购物车数量超过限购数");
			}
		}

		return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 更新商品数量
	 * 
	 * @param id
	 * @param count
	 * @param userId
	 * @return
	 */
	public Ret updateCount(int id, int count, int userId) {
		// 数量必须大于0
		if (count < 1) {
			return Fail.setMsg(Fail.Msg.PARAM_ERROR);
		}

		// 查询该用户的购物车中的该商品是否存在
		Ret result = findCart(id, userId);
		if (result.isFail()) {
			return result;
		}
		Cart cart = result.getAs("cart");

		// 查询该商品的最大购买量
		Goods goods = goodsDao.findByIdLoadColumns(cart.getGoodsId(), "maxBuy");
		if (goods != null) {
			if(count > goods.getMaxBuy()) {
				return Fail.setMsg("加入购物车数量超过限购数");
			}
			
			cart.setCount(count);
			if (cart.update()) {
				CacheKit.remove("cart", userId);
				return Ret.ok();
			}
		}
		return Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 获取购物车中指定的商品信息
	 * 
	 * @param cartId
	 * @param userId
	 * @return
	 */
	private Ret findCart(int cartId, int userId) {
		String sql = "select id, name, goodsId, skuId, count from cart where id = ? and userId = ? limit 1";
		Cart cart = dao.findFirst(sql, cartId, userId);
		if (cart == null) {
			return Fail.setMsg("您的购物车中没有该商品");
		}
		return Ret.ok("cart", cart);
	}

	/**
	 * 更新选中状态
	 * 
	 * @param id
	 * @param checked
	 * @param userId
	 * @return
	 */
	public Ret updateCheck(int id, boolean checked, int userId) {
		// 查询该用户的购物车中的该商品是否存在
		Ret result = findCart(id, userId);
		if (result.isFail()) {
			return result;
		}
		Cart cart = result.getAs("cart");

		// 获取规格
		SkuDetail sku = goodsSrv.getSkuInfo(cart.getGoodsId(), cart.getSkuId());
		if (sku == null) {
			return Fail.setMsg(cart.getName() + " 不存在或已下架");
		}
		if (cart.getCount() > sku.getStock()) {
			return Fail.setMsg(cart.getName() + " 当前库存为：" + sku.getStock());
		}

		// 更新选中状态
		cart.setChecked(checked ? 0 : 1);
		CacheKit.remove("cart", userId);
		return cart.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 删除购物车中的商品
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public Ret delete(int id, int userId) {
		String sql = "delete from cart where id = ? and userId = ? limit 1";
		return Db.delete(sql, id, userId) > 0 ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 用户登录后同步所有登录前放在浏览器缓存的购物车商品
	 * 
	 * @param cartJson
	 * @param userId
	 * @return
	 */
	public Ret syncCart(String cartJson, int userId) {
		try {
			// 解析json
			List<Kv> cart = JSON.parseArray(cartJson, Kv.class);
			cart.forEach(e -> {
				// 获取商品基本信息
				int goodsId = e.getInt("goodsId");
				int skuId = e.getInt("id");
				int count = e.getInt("count");

				// 保存到数据库
				Ret result = put(goodsId, skuId, userId);
				if (result.isOk()) {
					// 如果数量不止一个，则修改数量
					if (count > 1) {
						updateCount(result.getInt("id"), count, userId);
					}
				}
			});
			return Ret.ok();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
