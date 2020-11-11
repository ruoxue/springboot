//package com.wowotou.payservice.socket;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.corundumstudio.socketio.AckRequest;
//import com.corundumstudio.socketio.SocketIOClient;
//import com.corundumstudio.socketio.SocketIOServer;
//import com.corundumstudio.socketio.annotation.OnConnect;
//import com.corundumstudio.socketio.annotation.OnDisconnect;
//import com.corundumstudio.socketio.annotation.OnEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.UUID;
//
//
//@Component
//public class MessageEventHandler {
//    ///**/
//    private final SocketIOServer socketIoServer;
//
//    @Autowired
//    public MessageEventHandler(SocketIOServer server) {
//        this.socketIoServer = server;
//    }
//
//    @OnConnect
//    public void onConnect(SocketIOClient client) {
//
//
//        System.out.println(new Date().toString() + ":---" + "客户端:" + client.getSessionId() + "已连接 在线" + socketIoServer.getAllClients().size());
//    }
//
//    @OnDisconnect
//    public void onDisconnect(SocketIOClient client) {
//       // payAccountService.clearAccount(client.getSessionId().toString());
//
//        System.out.println(new Date().toString() +client.isChannelOpen()+ ":---"
//                + "客户端:" + client.getSessionId()
//                + "断开连接 在线" + socketIoServer.getAllClients().size());
//    }
//
//    @Resource
//    private AdminService adminService;
//
//    @OnEvent(value = "service")
//    public void onEvent(SocketIOClient client, AckRequest request, String msg) {
//        System.out.println(new Date().toString() + ":---" + client.getSessionId() + "发来消息：" + msg);
//
//        if (msg != null && !"".equalsIgnoreCase(msg)) {
//            MsgModel msgModel = JSON.parseObject(msg, MsgModel.class);
//            if (msgModel != null) {
//                msgModel.setSocket_id(client.getSessionId().toString());
//                AdminModel adminModel = adminService.getAdminByToken(msgModel.getToken());
//                if (adminModel==null){
//                    return;
//                }
//
//                if (msgModel.getDataType() == 1) {
//
//                        payAccountService.addOrUpdateAccount(adminModel.getId(), msgModel);
//                        client.joinRoom(adminModel.getId()+"");
//
//
//
//                } else if (msgModel.getDataType() == 2) {//jsbh
//
//                        msgModel.setSocket_id(client.getSessionId().toString());
//                        payAccountService.addOrUpdateAccount(adminModel.getId(), msgModel);
//                        client.leaveRoom(adminModel.getId()+"");
//
//                } else if (msgModel.getDataType() == 3) {
//
//
//                        payQueueService.updateQueue(adminModel.getId(),msgModel.getUserId(),
//                                msgModel.getUrl(), msgModel.getMark(),
//                                msgModel.getNo(), msgModel.getExtra(),msgModel.getMoney());
//
//                } else if (msgModel.getDataType() == 4) {
//
//                        payQueueService.updateQueue(adminModel.getId(),msgModel.getUserId(),
//                                msgModel.getUrl(),
//                                msgModel.getMark(), msgModel.getNo(),
//                                msgModel.getExtra(),msgModel.getMoney());
//
//
//                }
//
//            }
//
//
//        }
//
//
//    }
//
//
//    @Resource
//    private PayAccountService payAccountService;
//    @Resource
//    private PayQueueService payQueueService;
//
//    /**
//     * @param queueId
//     */
//    public void sendBuyLogEvent(String queueId) {   //这里就是向客户端推消息了
//
//        PayQueue payQueue = payQueueService.getPayQueuebyId(Integer.parseInt(queueId.trim()));
//
//        if (payQueue == null) {
//            System.out.println("无可用序列:queueId---->" + queueId);
//            return;
//        }
//
//        PayCanAccount account = payAccountService.getAccountByUserId(payQueue.getUserId());//sb
//
//
//        if (account != null
//                && socketIoServer.getClient(
//                        UUID.fromString(account.getSocket_id())) != null)
//        {
//
//            AdminModel admin = adminService.getAdminById(account.getAdminId());
//
//
//            NotifyMsgModel notifyMsgModel = new NotifyMsgModel();
//            notifyMsgModel.setAccount_id(account.getId());
//            notifyMsgModel.setAction(account.getChannelId()+"");
//            notifyMsgModel.setType(payQueue.getType());
//            notifyMsgModel.setNum(1);
//            if (payQueue.getToUserId()!=null){
//
//                notifyMsgModel.setToUserId(payQueue.getToUserId());
//            }
//            notifyMsgModel.setPrice(String.valueOf(payQueue.getTradeMoney()));
//            notifyMsgModel.setTimestamp((int) (System.currentTimeMillis() / 1000));
//            notifyMsgModel.setTrade_no(payQueue.getMark());
//
//            notifyMsgModel.setExtra(payQueue.getInfo());
//
//            String keyStr = notifyMsgModel.getTrade_no()
//                    + notifyMsgModel.getType() + notifyMsgModel.getPrice()
//                    + notifyMsgModel.getTimestamp() +
//                    admin.getToken();
//            notifyMsgModel.setKey(Md5.md5(keyStr));
//            System.out.println(new Date().toString() + ":---" + "key:" + keyStr);
//            String s = JSONObject.toJSONString(notifyMsgModel);
//            System.out.println(new Date().toString() + ":---" + "下发：" + s);
//            socketIoServer.getClient(UUID.fromString(account.getSocket_id())).sendEvent("client", s);
//
//        } else {
//            System.out.println("无可用账号");
//        }
//
//    }
//
//
//
//
//    public String getCurrentSId() {
//        StringBuilder sb = new StringBuilder();
//        for (SocketIOClient client : socketIoServer.getAllClients()) {
//            if (client == null) continue;
//            sb.append("'").append(client.getSessionId().toString()).append("'").append(",");
//
//        }
//        if (sb != null && sb.length() >= 1) {
//            return sb.substring(0, sb.length() - 1);
//        }
//        return sb.toString();
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
