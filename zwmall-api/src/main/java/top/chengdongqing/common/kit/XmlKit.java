package top.chengdongqing.common.kit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;

/**
 * XML处理工具类
 * 
 * @author Luyao
 *
 */
public class XmlKit {

	/**
	 * xml转map
	 * 
	 * @param xml
	 * @return
	 */
	public static Map<String, String> xmlToMap(String xml) {
		if (StrKit.isBlank(xml)) {
			throw new IllegalArgumentException("The xml string can not be blank");
		}

		// 承载XML参数的Map
		Map<String, String> params = new ConcurrentHashMap<>();

		// 将xml字符串转为字节数组输入流
		try (InputStream is = new ByteArrayInputStream(xml.getBytes(Constant.CHARSET))) {
			// 将字节流转为文档对象
			Document doc = newDocumentBuilder().parse(is);
			// 将文档元素规范化
			doc.getDocumentElement().normalize();
			// 获取根节点XML下的所有子节点
			NodeList nodes = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				// 获取节点对象
				Node node = nodes.item(i);
				// 判断该节点是否是元素节点
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					params.put(node.getNodeName(), node.getTextContent());
				}
			}
			return params;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * map转xml
	 * 
	 * @param map
	 * @return
	 */
	public static String mapToXml(Map<String, String> map) {
		// 创建文档对象
		Document document = newDocumentBuilder().newDocument();

		// 创建根节点
		Element root = document.createElement("xml");
		// 循环创建子节点并将它放到根节点里
		map.forEach((key, value) -> {
			if (StrKit.notBlank(value)) {
				Element element = document.createElement(key);
				// 将节点的值放到节点内
				element.appendChild(document.createTextNode(value.trim()));
				root.appendChild(element);
			}
		});
		// 将根节点拼接到文档
		document.appendChild(root);

		// 实例化字符串收集器
		try (StringWriter writer = new StringWriter()) {
			// 实例化XML转化器
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// 获取文档资源对象
			DOMSource source = new DOMSource(document);
			// 设置XML编码格式
			transformer.setOutputProperty(OutputKeys.ENCODING, Constant.CHARSET);
			// 去除XML空格
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// 实例化流收集器
			StreamResult result = new StreamResult(writer);
			// 将xml文档转换成字符流
			transformer.transform(source, result);
			// 输出XML字符串
			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 构建xml文档
	 * 
	 * @return
	 */
	public static DocumentBuilder newDocumentBuilder() {
		// 实例化文档构建工厂
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			// 不允许宣布文档类型
			dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			// 不是对外发布的一般实体
			dbFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			// 不是对外发布的参数实体
			dbFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			// 不加载外部的文档类型声明
			dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			// 对XML特征值进行安全处理
			dbFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
			// 不处理XInclude标记
			dbFactory.setXIncludeAware(false);
			// 不扩展实体引用
			dbFactory.setExpandEntityReferences(false);
			// 实例化文档构建器
			return dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
}
