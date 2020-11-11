package top.chengdongqing.portal.common;

import com.jfinal.config.Routes;

import top.chengdongqing.portal.goods.GoodsController;
import top.chengdongqing.portal.goods.brand.BrandController;
import top.chengdongqing.portal.goods.category.CategoryController;
import top.chengdongqing.portal.goods.comment.CommentController;

/**
 * 商品相关路由配置
 * 
 * @author Luyao
 *
 */
public class GoodsRoutes extends Routes {

	@Override
	public void config() {
		add("goods", GoodsController.class);
		add("brand", BrandController.class);
		add("category", CategoryController.class);
		add("comment", CommentController.class);
	}
}
