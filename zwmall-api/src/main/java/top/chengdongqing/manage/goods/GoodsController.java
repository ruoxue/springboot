package top.chengdongqing.manage.goods;

import java.io.File;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.uploader.Uploader;

/**
 * 商品管理相关控制器
 * 
 * @author Luyao
 *
 */
public class GoodsController extends Controller {

	@Inject
	GoodsService goodsSrv;

	/**
	 * 分页查询商品
	 */
	@Before(GET.class)
	public void index() {
		int status = getInt("status", -1);
		String keyword = get("keyword");
		String categoryId = get("categoryId");
		String brandId = get("brandId");
		int sortMode = getInt("sortMode", 0);
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		renderJson(goodsSrv.paginate(status, keyword, categoryId, brandId, sortMode, pageNumber, pageSize));
	}

	/**
	 * 更新商品状态
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void updateStatus(int id) {
		renderJson(goodsSrv.updateStatus(id));
	}

	/**
	 * 删除商品
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(goodsSrv.deleteGoods(id));
	}

	/**
	 * 批量更新商品状态
	 * 
	 * @param ids
	 * @param status
	 */
	@Before(POST.class)
	@NotBlank({ "ids", "status" })
	public void batchUpdateStatus(String ids, int status) {
		renderJson(goodsSrv.batchUpdateStatus(ids, status));
	}

	/**
	 * 上传商品相关图片
	 */
	@Before(POST.class)
	public void uploadImage() {
		String type = getHeader("type");
		// 判断文件类型是否匹配
		String[] types = { "thumb", "banner", "sketch", "specs" };
		if (StrKit.isBlank(type) || !Arrays.asList(types).contains(type)) {
			renderError(405);
			return;
		}

		// 上传图片
		File image = getFile().getFile();
		Ret result = Uploader.me().uploadImage(image, "goods/" + type);
		result.set("success", result.isOk()).set("file_path", result.getStr("url"));
		renderJson(result);
	}

	/**
	 * 提交商品
	 * 
	 * @param goods
	 */
	@Before({ POST.class, GoodsValidator.class })
	public void submit(@Para("") Goods goods) {
		Kv details = JSON.parseObject(getRawData(), Kv.class);
		goods.setSketch(details.getStr("sketch"));
		goods.setSpecs(details.getStr("specs"));
		renderJson(goodsSrv.saveGoods(goods, details.getStr("banners"),
				details.getStr("skus")));
	}

	/**
	 * 更新商品
	 * 
	 * @param goods
	 */
	@NotBlank
	@Before({ POST.class, GoodsValidator.class })
	public void update(@Para("") Goods goods) {
		Kv details = JSON.parseObject(getRawData(), Kv.class);
		goods.setSketch(details.getStr("sketch"));
		goods.setSpecs(details.getStr("specs"));
		renderJson(goodsSrv.updateGoods(goods, details.getStr("banners"), details.getStr("skus")));
	}

	/**
	 * 获取商品详情
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(GET.class)
	public void details(int id) {
		renderJson(goodsSrv.findDetails(id));
	}

	/**
	 * 商品提示
	 * 
	 * @param keyword
	 */
	@Before(GET.class)
	public void assist(String keyword) {
		renderJson(goodsSrv.getGoodsAssist(keyword));
	}
}
