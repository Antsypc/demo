package xyz.antsgroup.demo.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Ants Young on 2016/7/18.
 */
@ServerEndpoint("/socket/{param}")
public class WebSocketEndPoint {


    public WebSocketEndPoint() {
        System.out.println("WebSocketEndPoint constructor...");
    }

    @OnOpen
    public void onOpen(@PathParam("param") String param, Session session) throws IOException {
        System.out.println(this.hashCode() + " /socket/" + param + " : WebSocket onOpen().");
    }

    @OnMessage
    public String onMessage(String message) {
        System.out.println(this.hashCode() + " EndPoint onMessage() : " + message);
        return "receive : " + message;
    }


    @OnError
    public void onError(Throwable t) {
        System.out.println(this.hashCode() + " error happened : " + t.getMessage());
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println(this.hashCode() + " WebSocket onClose() : " + reason.getReasonPhrase());
    }

}
