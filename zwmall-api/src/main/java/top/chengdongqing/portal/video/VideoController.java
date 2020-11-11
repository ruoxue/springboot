package top.chengdongqing.portal.video;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import top.chengdongqing.common.uploader.Uploader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * 视频相关控制器
 * 
 * @author Luyao
 *
 */
public class VideoController extends Controller {

	@Inject
	VideoService videoSrv;

	/**
	 * 获取视频列表
	 */
	@Before(GET.class)
	public void index() {
		renderJson(videoSrv.findAll(getBoolean("all", false)));
	}


	/**
	 * 上传视频
	 */
	@Before(POST.class)
	public void uploadVideo( ) throws IOException, ServletException {



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

}
