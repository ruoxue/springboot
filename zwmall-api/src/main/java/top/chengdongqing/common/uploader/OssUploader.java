package top.chengdongqing.common.uploader;

import java.nio.file.Path;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

import top.chengdongqing.common.config.Constant.ConfigFile;

/**
 * 上传文件到OSS
 * 
 * @author Luyao
 *
 */
public class OssUploader extends Uploader {

	// 配置文件
	private static final Prop prop = PropKit.use(ConfigFile.OSS);

	private static OSS client;
	private static String baseUrl;

	static {
		// 实例化oss客户端
		client = new OSSClientBuilder().build(prop.get("endpoint"), prop.get("access.id"), prop.get("access.secret"));

		// 拼接基础访问路径
		StringBuilder url = new StringBuilder("https://").append(prop.get("bucket"));
		url.append(".").append(prop.get("endpoint")).append("/");
		baseUrl = url.toString();
	}

	@Override
	String upload(Path filePath, String saveDire, String fileName) {
		// 拼接对象的键名
		String objectName = saveDire + "/" + fileName;

		// 新建上传文件请求
		PutObjectRequest request = new PutObjectRequest(prop.get("bucket"), objectName, filePath.toFile());
		// 上传文件
		client.putObject(request);

		// 拼接文件完整路径
		return baseUrl + objectName;
	}
}
