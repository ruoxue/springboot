package top.chengdongqing.manage.goods.brand;

import java.io.File;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.model.GoodsBrand;
import top.chengdongqing.common.uploader.Uploader;

/**
 * 品牌管理相关控制器
 * 
 * @author Luyao
 *
 */
public class BrandController extends Controller {

	@Inject
	BrandService brandSrv;

	/**
	 * 获取商品品牌
	 */
	@Before(GET.class)
	public void index() {
		renderJson(brandSrv.findAll());
	}

	/**
	 * 添加品牌
	 * 
	 * @param brand
	 */
	@NotBlank("name")
	@Before(POST.class)
	public void save(@Para("") GoodsBrand brand) {
		renderJson(brandSrv.saveBrand(brand));
	}

	/**
	 * 上传品牌logo
	 */
	@Before(POST.class)
	public void uploadLogo() {
		File logo = getFile().getFile();
		renderJson(Uploader.me().uploadImage(logo, Uploader.SaveDire.LOGO));
	}

	/**
	 * 更新品牌
	 * 
	 * @param brand
	 */
	@Before(POST.class)
	@NotBlank({ "id", "name" })
	public void update(@Para("") GoodsBrand brand) {
		renderJson(brandSrv.updateBrand(brand));
	}

	/**
	 * 删除品牌
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(brandSrv.deleteBrand(id));
	}

	/**
	 * 品牌排序
	 * 
	 * @param id
	 * @param direction
	 */
	@Before(POST.class)
	@NotBlank({ "id", "direction" })
	public void sort(int id, int direction) {
		renderJson(brandSrv.brandSort(id, direction));
	}
}
