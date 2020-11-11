package top.chengdongqing.portal.goods.comment;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.interceptor.LoginAuthInterceptor;

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
	 * 获取商品评分
	 * 
	 * @param goodsId
	 */
	@Before(GET.class)
	@NotBlank("goodsId")
	public void goodsScores(int goodsId) {
		renderJson(commentSrv.findGoodsScores(goodsId));
	}

	/**
	 * 获取商品评论列表
	 * 
	 * @param goodsId
	 */
	@Before(GET.class)
	@NotBlank("goodsId")
	public void index(int goodsId) {
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		int score = getInt("score", 0);
		boolean onlyHasPhotos = getBoolean("onlyHasPhotos", false);
		renderJson(commentSrv.findComments(goodsId, pageNumber, pageSize, score, onlyHasPhotos));
	}

	/**
	 * 点赞或取消点赞
	 * 
	 * @param id
	 * @param liked
	 */
	@NotBlank({ "id", "liked" })
	@Before({ POST.class, LoginAuthInterceptor.class })
	public void switchLike(int id, boolean liked) {
		renderJson(commentSrv.switchLike(id, liked));
	}
}
