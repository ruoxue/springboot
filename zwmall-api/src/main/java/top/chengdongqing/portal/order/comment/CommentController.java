package top.chengdongqing.portal.order.comment;

import java.io.File;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.model.OrderExpress;
import top.chengdongqing.common.model.OrderGoods;
import top.chengdongqing.common.uploader.Uploader;
import top.chengdongqing.common.uploader.Uploader.SaveDire;
import top.chengdongqing.portal.order.comment.validator.ExpressCommentValidator;
import top.chengdongqing.portal.order.comment.validator.GoodsCommentValidator;

/**
 * 订单评价相关控制器
 * 
 * @author Luyao
 *
 */
public class CommentController extends BaseController {

	@Inject
	CommentService commentSrv;

	/**
	 * 查询待评论的订单列表
	 */
	@Before(GET.class)
	public void index() {
		renderJson(commentSrv.findAll(getUserId()));
	}

	/**
	 * 查询待评论订单详情
	 * 
	 * @param orderNo
	 */
	@Before(GET.class)
	@NotBlank("orderNo")
	public void details(String orderNo) {
		renderJson(commentSrv.findDetails(orderNo, getUserId()));
	}

	/**
	 * 提交快递评价
	 * 
	 * @param express
	 */
	@Before({ POST.class, ExpressCommentValidator.class })
	public void submitExpressComment(@Para("") OrderExpress express) {
		renderJson(commentSrv.submitExpressComment(express, getUserId()));
	}

	/**
	 * 提交商品评价
	 * 
	 * @param goods
	 */
	@Before({ POST.class, GoodsCommentValidator.class })
	public void submitGoodsComment(@Para("") OrderGoods goods) {
		renderJson(commentSrv.submitGoodsComment(goods, getUserId()));
	}
	
	/**
	 * 上传评论时分享的图片
	 */
	@Before(POST.class)
	public void uploadPhoto() {
		File photo = getFile(SaveDire.COMMENT).getFile();
		renderJson(Uploader.me().uploadImage(photo, SaveDire.COMMENT));
	}
}
