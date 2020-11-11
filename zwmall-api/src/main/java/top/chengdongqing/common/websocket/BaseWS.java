package top.chengdongqing.common.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import com.jfinal.kit.StrKit;

/**
 * WebSocket相关抽象类
 * 
 * @author Luyao
 *
 */
public abstract class BaseWS {

	// 客户端缓存
	protected static final Map<String, Session> clients = new ConcurrentHashMap<>();

	/**
	 * 连接打开时
	 * 
	 * @param session
	 * @param id
	 */
	@OnOpen
	protected void onOpen(Session session, @PathParam("id") String id) {
		if (StrKit.notBlank(id)) {
			clients.put(id, session);
		}
	}

	/**
	 * 收到消息时
	 * 
	 * @param session
	 */
	@OnMessage
	protected void onMessage(String message) {

	}

	/**
	 * 连接关闭时
	 * 
	 * @param id
	 */
	@OnClose
	protected void onClose(@PathParam("id") String id) {
		if (StrKit.notBlank(id)) {
			clients.remove(id);
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param id
	 * @param content
	 */
	protected static void send(String id, String content) {
		Session session = clients.get(id);
		if (session != null) {
			session.getAsyncRemote().sendText(content);
		}
	}
}
