package top.chengdongqing.common.uploader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import com.jfinal.kit.FileKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;

/**
 * 文件上传抽象类
 * 
 * @author Luyao
 *
 */
public abstract class Uploader {

	private static final Uploader me = new LocalUploader();

	public static Uploader me() {
		return me;
	}

	/**
	 * 文件保存地址
	 */
	public interface SaveDire {
		// 用户头像
		String AVATAR = "avatar";
		// 评论图片
		String COMMENT = "comment";
		// 品牌logo
		String LOGO = "logo";
		// 视频
		String VIDEO = "video";
	}

	/**
	 * 上传图片
	 * 
	 * @param file
	 * @param saveDire
	 * @return
	 */
	public Ret uploadImage(File file, String saveDire) {
		String[] formats = { "jpg", "png", "gif", "jpeg", "webp", "jfif" };
		return upload(file, saveDire, formats, 1024 * 1024 * 2);
	}

	/**
	 * 上传视频
	 * 
	 * @param file
	 * @return
	 */
	public Ret uploadVideo(File file) {
		String[] formats = { "mp4" };
		return upload(file, SaveDire.VIDEO, formats, 1024 * 1024 * 100);
	}

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @param saveDire
	 * @param formats
	 * @param maxSize
	 */
	private Ret upload(File file, String saveDire, String[] formats, int maxSize) {
		// 获取文件后缀名
		String suffix = FileKit.getFileExtension(file);
		// 获取文件path
		Path filePath = file.toPath();

		try {
			// 检查文件
			Ret result = checkFile(filePath, formats, maxSize, suffix);
			if (result.isFail()) {
				Files.deleteIfExists(filePath);
				return result;
			}

			// 生成文件名
			String fileName = StrKit.getRandomUUID() + "." + suffix;
			// 执行上传
			String url = upload(filePath, saveDire, fileName);
			Files.deleteIfExists(filePath);
			return Ret.ok("url", url);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 具体上传处理
	 * 
	 * @param filePath
	 * @param saveDire
	 * @param fileName
	 * @return
	 */
	abstract String upload(Path filePath, String saveDire, String fileName);

	/**
	 * 检查文件
	 * 
	 * @param file
	 * @param formats
	 * @param maxSize
	 * @param suffix
	 * @return
	 * @throws IOException
	 */
	private Ret checkFile(Path file, String[] formats, int maxSize, String suffix) throws IOException {
		// 判断该文件是否正常
		if (Files.notExists(file)) {
			return Ret.fail(Constant.MSG, "文件错误");
		}
		// 判断文件格式是否合规
		if (!Arrays.asList(formats).contains(suffix)) {
			return Ret.fail(Constant.MSG, "文件格式错误");
		}
		// 判断文件大小是否超出
		if (Files.size(file) > maxSize) {
			return Ret.fail(Constant.MSG, "文件过大");
		}
		return Ret.ok();
	}
}
