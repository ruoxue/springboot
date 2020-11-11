package top.chengdongqing.common.uploader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.jfinal.kit.PropKit;

import top.chengdongqing.common.config.Constant;

/**
 * 上传文件到本地
 * 
 * @author Luyao
 *
 */
public class LocalUploader extends Uploader {

	private static String baseUrl;

	static {
		if (Constant.DEV_MODE) {
			baseUrl = "http://localhost:%d/file?path=".formatted(PropKit.getInt("undertow.port"));
		} else {
			baseUrl = PropKit.get("static.url");
		}
	}

	@Override
	String upload(Path filePath, String saveDire, String fileName) {
		try {
			// 获取要存放的文件夹对象
			Path targetDirectory = Paths.get(Constant.UPLOAD_BASE_PATH + saveDire);
			// 如果该文件夹不存在则创建
			if (!Files.isDirectory(targetDirectory)) {
				Files.createDirectories(targetDirectory);
			}
			// 重命名并移动文件到指定文件夹
			Files.move(filePath, targetDirectory.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			// 拼接文件访问路径
			return String.join("/", baseUrl, saveDire, fileName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
