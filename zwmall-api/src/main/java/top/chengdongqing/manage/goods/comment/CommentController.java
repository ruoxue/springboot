package top.chengdongqing.manage.goods.comment;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;

/**
 * 商品评论相关控制器
 * 
 * @author Luyao
 *
 */
public class CommentController extends Controller {

	@Inject
	CommentService commentSrv;

	/**
	 * 查询评论列表
	 */
	@Before(GET.class)
	public void index(String keyword) {
		int score = getInt("score", -1);
		int goodsId = getInt("goodsId", -1);
		int userId = getInt("userId", -1);
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		renderJson(commentSrv.paginate(score, goodsId, userId, keyword, pageNumber, pageSize));
	}

	/**
	 * 更新评论状态
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void updateStatus(int id) {
		renderJson(commentSrv.updateStatus(id));
	}

	/**
	 * 删除评论
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(commentSrv.deleteComment(id));
	}
}
