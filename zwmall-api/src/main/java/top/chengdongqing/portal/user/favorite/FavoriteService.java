package top.chengdongqing.portal.user.favorite;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.UserFavorite;
import top.chengdongqing.portal.goods.GoodsService;
import top.chengdongqing.portal.goods.bo.SkuDetail;

/**
 * 收藏的商品相关逻辑层
 * 
 * @author Luyao
 *
 */
public class FavoriteService {

	@Inject
	UserFavorite dao;

	@Inject
	GoodsService goodsSrv;

	/**
	 * 查询指定的用户收藏的商品
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserFavorite> findAll(int userId) {
		String sql = "select * from user_favorite where userId = ? order by createTime desc";
		return dao.find(sql, userId);
	}

	/**
	 * 删除指定的收藏的商品
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public Ret delete(int id, int userId) {
		String sql = "delete from user_favorite where id = ? and userId = ? limit 1";
		return Db.delete(sql, id, userId) > 0 ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 收藏喜欢的商品
	 * 
	 * @param goodsId
	 * @param skuId
	 * @param userId
	 * @return
	 */
	public Ret save(int goodsId, int skuId, int userId) {
		// 查询该收藏是否存在
		String sql = "select id from user_favorite where userId = ? and goodsId = ? and skuId = ? limit 1";
		if (dao.findFirst(sql, userId, goodsId, skuId) != null) {
			return Ret.ok();
		}

		// 查询规格信息
		SkuDetail sku = goodsSrv.getSkuInfo(goodsId, skuId);
		if (sku == null) {
			return Ret.fail(Constant.MSG, "该商品不存在");
		}

		UserFavorite favorite = new UserFavorite();
		favorite.setUserId(userId);
		favorite.setGoodsId(goodsId);
		favorite.setSkuId(skuId);
		favorite.setName(sku.getName());
		favorite.setPrice(sku.getPrice());
		favorite.setThumbUrl(sku.getThumbUrl());
		return favorite.save() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}
}
