package top.chengdongqing.common.render;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.servlet.ServletOutputStream;

import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

import top.chengdongqing.common.config.Constant;

/**
 * 字节流渲染
 * 
 * @author Luyao
 *
 */
public class StreamRender extends Render {

	// 要渲染的字节数组
	private byte[] bytes;
	// 文件名
	private String name;

	public StreamRender(byte[] bytes, String name) {
		this.bytes = bytes;
		this.name = URLEncoder.encode(name, Charset.forName(Constant.CHARSET));
	}

	@Override
	public void render() {
		// 定义打开方式为附件下载，并定义文件名
		response.setHeader("Content-disposition", "filename=" + name);
		try (ServletOutputStream os = response.getOutputStream()) {
			os.write(bytes);
		} catch (IOException e) {
			throw new RenderException(e);
		}
	}
}
