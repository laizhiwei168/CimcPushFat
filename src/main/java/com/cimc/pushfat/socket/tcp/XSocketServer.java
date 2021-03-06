package com.cimc.pushfat.socket.tcp;

import java.io.IOException;
import java.net.UnknownHostException;
import org.xsocket.connection.IConnection.FlushMode;
import org.xsocket.connection.IServer;
import org.xsocket.connection.Server;

public class XSocketServer extends Thread {  
    
  private static  int PORT=31101;
  
  public XSocketServer(Integer port){
	  if(port!=null){
		  this.PORT=port;
	  }
  }
  
  public void run() {
      IServer srv = null;  
      try {
          //建立Projecthandler
          srv = new Server(PORT, new ProjectHandle());
          srv.setFlushmode(FlushMode.ASYNC);//设备是否为异步处理
          //srv.setConnectionTimeoutMillis(5000);//设置连接超时的时间
          srv.setIdleTimeoutMillis(60000*5);//设置最大空闲时间
      } catch (UnknownHostException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();  
      }
      //服务器运行  
      srv.run();
      System.out.println("The ProjectServer start on port: "+PORT);
  } 
}  
