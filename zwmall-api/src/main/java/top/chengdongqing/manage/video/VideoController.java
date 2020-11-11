package top.chengdongqing.manage.video;

import java.io.File;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.model.Video;
import top.chengdongqing.common.uploader.Uploader;

/**
 * 视频管理相关控制器
 * 
 * @author Luyao
 *
 */
public class VideoController extends Controller {

	@Inject
	private VideoService videoSrv;

	/**
	 * 查询视频列表
	 */
	@Before(GET.class)
	public void index() {
		renderJson(videoSrv.findAll());
	}

	/**
	 * 更新视频状态
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void updateStatus(int id) {
		renderJson(videoSrv.updateStatus(id));
	}

	/**
	 * 删除视频
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(videoSrv.deleteVideo(id));
	}

	/**
	 * 添加视频
	 * 
	 * @param video
	 */
	@Before({ POST.class, VideoValidator.class })
	public void save(@Para("") Video video) {
		renderJson(videoSrv.saveVideo(video));
	}

	/**
	 * 更新视频
	 * 
	 * @param video
	 */
	@NotBlank
	@Before({ POST.class, VideoValidator.class })
	public void update(@Para("") Video video) {
		renderJson(videoSrv.updateVideo(video));
	}

	/**
	 * 上传视频
	 */
	@Before(POST.class)
	public void uploadVideo() {
		File video = getFile().getFile();
		renderJson(Uploader.me().uploadVideo(video));
	}

	/**
	 * 上传视频封面
	 */
	@Before(POST.class)
	public void uploadCover() {
		File image = getFile().getFile();
		renderJson(Uploader.me().uploadImage(image, "video/cover"));
	}

	/**
	 * 视频排序
	 * 
	 * @param id
	 * @param direction
	 */
	@Before(POST.class)
	@NotBlank({ "id", "direction" })
	public void sort(int id, int direction) {
		renderJson(videoSrv.videoSort(id, direction));
	}
}
