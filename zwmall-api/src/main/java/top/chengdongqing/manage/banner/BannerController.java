package top.chengdongqing.manage.banner;

import java.io.File;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.model.Banner;
import top.chengdongqing.common.uploader.Uploader;

/**
 * 横幅管理相关控制器
 * 
 * @author Luyao
 *
 */
public class BannerController extends Controller {

	@Inject
	BannerService bannerSrv;

	/**
	 * 获取横幅
	 */
	@NotBlank("type")
	@Before(GET.class)
	public void index(String type) {
		renderJson(bannerSrv.findBanners(type));
	}

	/**
	 * 更新横幅状态
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void updateStatus(int id) {
		renderJson(bannerSrv.updateStatus(id));
	}

	/**
	 * 删除横幅
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(bannerSrv.deleteBanner(id));
	}

	/**
	 * 更新横幅
	 * 
	 * @param banner
	 */
	@NotBlank
	@Before({ POST.class, BannerValidator.class })
	public void update(@Para("") Banner banner) {
		renderJson(bannerSrv.updateBanner(banner));
	}

	/**
	 * 新增横幅
	 * 
	 * @param banner
	 */
	@Before({ POST.class, BannerValidator.class })
	public void save(@Para("") Banner banner) {
		renderJson(bannerSrv.saveBanner(banner));
	}

	/**
	 * 上传横幅
	 */
	@Before(POST.class)
	public void uploadImage() {
		String type = getHeader("type");
		if (StrKit.isBlank(type) || !Banner.Type.hasType(type)) {
			renderError(405);
			return;
		}

		File image = getFile().getFile();
		renderJson(Uploader.me().uploadImage(image, "banner/" + type));
	}

	/**
	 * 横幅排序
	 * 
	 * @param id
	 * @param direction
	 */
	@Before(POST.class)
	@NotBlank({ "id", "direction" })
	public void sort(int id, int direction) {
		renderJson(bannerSrv.bannerSort(id, direction));
	}
}
