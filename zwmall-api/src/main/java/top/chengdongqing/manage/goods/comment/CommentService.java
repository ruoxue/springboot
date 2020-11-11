package top.chengdongqing.manage.goods.comment;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;

import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.GoodsComment;

/**
 * 商品评论相关逻辑层
 */
public class CommentService {

	@Inject
	GoodsComment dao;

	/**
	 * 分页查询评论列表
	 * 
	 * @param score
	 * @param goodsId
	 * @param userId
	 * @param keyword
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<GoodsComment> paginate(int score, int goodsId, int userId, String keyword, int pageNumber,
			int pageSize) {
		Kv params = Kv.by("score", score).set("goodsId", goodsId).set("userId", userId).set("keyword", keyword);
		return dao.template("admin.comment.paginate", params).paginate(pageNumber, pageSize);
	}

	/**
	 * 更新评论状态
	 * 
	 * @param id
	 * @return
	 */
	public Ret updateStatus(int id) {
		GoodsComment comment = dao.findByIdLoadColumns(id, "id, status");
		comment.setStatus(comment.getStatus() == 0 ? 1 : 0);
		return comment.update() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 删除评论
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteComment(int id) {
		GoodsComment comment = new GoodsComment();
		comment.setId(id);
		return comment.delete() ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}
}
