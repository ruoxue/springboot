package top.chengdongqing.portal.goods.comment;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.GoodsComment;

/**
 * 评论相关逻辑层
 * 
 * @author Luyao
 *
 */
public class CommentService {

	@Inject
	GoodsComment dao;

	/**
	 * 获取商品评分
	 * 
	 * @param goodsId
	 * @return
	 */
	public int[] findGoodsScores(int goodsId) {
		int[] scores = new int[6];

		// 获取该商品评分总人数
		String sql = "select count(*) from goods_comment where goodsId = ? and status = ?";
		scores[0] = Db.queryInt(sql, goodsId, Status.ENABLED);

		// 从高到低获取不同分数的人数
		for (int i = 5, j = 1; i > 0; i--, j++) {
			scores[j] = Db.queryInt(sql + " and score = ?", goodsId, Status.ENABLED, i);
		}
		return scores;
	}

	/**
	 * 获取商品评论列表
	 * 
	 * @param goodsId
	 * @param pageNumber
	 * @param pageSize
	 * @param score
	 * @param onlyHasPhotos
	 * @return
	 */
	public Page<GoodsComment> findComments(int goodsId, int pageNumber, int pageSize, int score,
			boolean onlyHasPhotos) {
		// 分页查询评论列表
		Kv params = Kv.by("goodsId", goodsId).set("status", Status.ENABLED);
		params.set("score", score).set("onlyHasPhotos", onlyHasPhotos);
		Page<GoodsComment> paginate = dao.template("comment.paginate", params).paginate(pageNumber, pageSize);

		paginate.getList().forEach(e -> {
			// 清除需隐藏的字段
			e.remove("orderNo", "userId", "status");
		});
		return paginate;
	}

	/**
	 * 点赞或取消点赞
	 * 
	 * @param id
	 * @param liked
	 * @return
	 */
	public synchronized Ret switchLike(int id, boolean liked) {
		// 查询该评论是否存在
		GoodsComment comment = dao.findByIdLoadColumns(id, "id, likes");
		if (comment == null) {
			return Ret.fail(Constant.MSG, "该评论不存在");
		}

		// 如果当前点赞量等于0则不能继续取消点赞
		if (comment.getLikes() <= 0 && !liked) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 增加或减少点赞数量
		comment.setLikes(liked ? comment.getLikes() + 1 : comment.getLikes() - 1);
		return comment.update() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.UPDATE_FAIL);
	}
}
