package xyz.antsgroup.demo.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * WebSocket 原生方法实现.
 * 可以接受多个客户端的请求,为每个请求新建一个独立的 EndPoint 对象.
 *
 * Created by Ants Young on 2016/7/18.
 */
@ServerEndpoint("/socket/{param}")
public class WebSocketEndPoint {


    public WebSocketEndPoint() {
        System.out.println("WebSocketEndPoint constructor...");
    }

    /**
     * 客户端请求建立连接时执行方法
     * @param param 可选参数,性质类似 Spring MVC
     * @param session Session
     * @throws IOException
     */
    @OnOpen
    public void onOpen(@PathParam("param") String param, Session session) throws IOException {
        System.out.println(this.hashCode() + " /socket/" + param + " : WebSocket onOpen().");
    }

    /**
     * 接受客户端传来的消息,并返回相应消息
     * @param message 可以是字符串也可以是二进制流
     * @return 相应消息
     */
    @OnMessage
    public String onMessage(String message) {
        System.out.println(this.hashCode() + " EndPoint onMessage() : " + message);
        return "receive : " + message;
    }

    /**
     * 发送错误时执行方法
     * @param t Throwable
     */
    @OnError
    public void onError(Throwable t) {
        System.out.println(this.hashCode() + " error happened : " + t.getMessage());
    }

    /**
     * 关闭回话是执行方法
     * @param session Session
     * @param reason CloseReason
     */
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println(this.hashCode() + " WebSocket onClose() : " + reason.getCloseCode() + " " +  reason.getReasonPhrase());
    }

}
