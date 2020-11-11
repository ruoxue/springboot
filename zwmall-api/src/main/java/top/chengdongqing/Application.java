package top.chengdongqing;

import com.jfinal.server.undertow.UndertowServer;

import top.chengdongqing.common.config.AppConfig;
import top.chengdongqing.common.config.Constant.ConfigFile;
import top.chengdongqing.portal.order.pay.PaySuccessWS;

/**
 * 应用启动类
 * 
 * @author Luyao
 *
 */

public class Application {

	public static void main(String[] args) {
		UndertowServer.create(AppConfig.class, ConfigFile.APPLICATION).configWeb(builder -> {
			builder.addWebSocketEndpoint(PaySuccessWS.class);
		}).start();
	}
}
