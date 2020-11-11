package top.chengdongqing.common.render;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;

import com.jfinal.kit.FileKit;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

/**
 * 文件渲染
 * 
 * @author Luyao
 *
 */
public class FileRender extends Render {

	// 要渲染的图片
	private File file;
	// 文件内容类型
	private String contentType;

	public FileRender(File file) {
		this.file = file;
		this.contentType = getContentType(FileKit.getFileExtension(file));
	}

	/**
	 * 获取文件内容类型
	 * 
	 * @param suffix
	 * @return
	 */
	private String getContentType(String suffix) {
		String type = "application";
		if (List.of("jpg", "png", "gif", "jpeg", "webp", "jfif").contains(suffix)) {
			type = "image";
		} else if ("mp4".equals(suffix)) {
			type = "video";
		} else {
			suffix = "octet-stream";
		}
		return type + "/" + suffix;
	}

	@Override
	public void render() {
		// 定义内容类型
		response.setContentType(contentType);
		// 定义文件保存名称
		response.setHeader("Content-disposition", "filename=" + file.getName());
		try (ServletOutputStream os = response.getOutputStream(); InputStream is = new FileInputStream(file)) {
			os.write(is.readAllBytes());
		} catch (IOException e) {
			throw new RenderException(e);
		}
	}
}
