<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>WebSocket Demo</title>
  </head>
  <body>
    <h2>WebSocket HTML5 简单实现</h2>
    <div>
      <ul>
        <li><a target="_blank" href="https://www.w3.org/TR/2011/WD-websockets-20110419/">The WebSocket API - W3C Working Draft 19 April 2011</a></li>
        <li><a target="_blank" href="https://html.spec.whatwg.org/multipage/comms.html">Web Communication docs</a></li>
        <li><a target="_blank" href="https://tools.ietf.org/html/rfc6455">WebSocket - RFC 6455 - 2011/12 </a></li>
        <li><a target="_blank" href="http://www.ibm.com/developerworks/cn/java/j-lo-WebSocket/">IBM developerworks - WebSocket 实战</a></li>
        <li><a target="_blank" href="http://www.open-open.com/lib/view/open1428648292500.html">Java WebSocket H5 简单实现</a></li>
      </ul>
    </div>

    <input id='connect' type="button" value="连接WebSocket" onclick="initWebSocket()" />
    <input id='close' type="button" value="关闭WebSocket" onclick="closeWebSocket()"/>
    <input type="text" id="msg" /><input type="button" onclick="webSocketSendMsg()" value="发送" />

    <div id="receiveMsgPanel">
    </div>
  </body>

  <script type="text/javascript">
    var ws;
    document.getElementById('close').disabled = true;

    // 初始化 WebSocket 对象, new 对象成功即同服务器建立了连接
    // WebSocket 需要实现的4个方法如下
    function initWebSocket(){
      ws = new WebSocket("ws://localhost:8080/websocket/socket/hello");
      document.getElementById('close').disabled = false;
      document.getElementById('connect').disabled = true;

      // 成功打开回话后执行
      ws.onopen = function(evn){
        console.log(evn);
      };

      // 接受到服务端消息后执行
      ws.onmessage = function(evn){
        console.log(evn.data);
        var msg = document.getElementById("receiveMsgPanel");
        msg.innerHTML += evn.data + '<br/>';
      };

      // 成功关闭回话后执行
      ws.onclose = function(){
        console.log("WebSocket closed.");
      };

      // 发生错误后执行
      ws.onerror = function () {
        console.log("Error happened.")
      };
    }

    // 发送数据,调用 WebSocket 对象的 send() 方法
    function webSocketSendMsg(){
      var msg = document.getElementById("msg").value;
      ws.send(msg);
      document.getElementById("msg").value = "";
    }

    // 主动断开连接,调用 WebSocket 对象的 close() 方法
    function closeWebSocket() {
      ws.close();
      document.getElementById('close').disabled = true;
      document.getElementById('connect').disabled = false;
      console.log("主动断开 WebSocket 回话.")
    }
  </script>
</html>
