package top.chengdongqing.common.controller;

import java.io.File;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.render.FileRender;

/**
 * 文件访问控制器，仅开发测试用
 * 
 * @author Luyao
 *
 */
public class FileController extends Controller {

	/**
	 * 访问文件
	 */
	@NotBlank("path")
	@Before(GET.class)
	@ActionKey("/file")
	public void index(String path) {
		File file = new File(Constant.UPLOAD_BASE_PATH + path);
		if (file != null && file.exists() && file.isFile()) {
			render(new FileRender(file));
		} else {
			renderError(404);
		}
	}
}
