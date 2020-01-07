package com.cimc.pushfat.app.start;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.cimc.pushfat.bean.common.ConstantBean;
import com.cimc.pushfat.main.handle.MainScheduled;
import com.cimc.pushfat.senhe.tcp.XSocketSenHeServer;
import com.cimc.pushfat.socket.tcp.XSocketServer;
import com.cimc.pushfat.websocket.client.CommmandClient;
import com.cimc.pushfat.websocket.heartbeat.CommmandHeartbeat;


public class AppStart {

	public static void main(String[] args) {
		/**启动Xsocket服务通讯*/
		Integer PORT = null;
		String XSOCKET_PORT=ConstantBean.constantMap.get("XSOCKET_PORT");
		if(XSOCKET_PORT!=null&&!"".equals(XSOCKET_PORT)){
			PORT=Integer.parseInt(XSOCKET_PORT);
		}
		XSocketServer projectServer = new XSocketServer(PORT);
	    projectServer.start();
	    
	    /** main 定时轮查*/
	    Integer main_polling_interval=Integer.parseInt(ConstantBean.constantMap.get("main_polling_interval"));
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new MainScheduled(),0, main_polling_interval, TimeUnit.MINUTES);
		
		/**接收森禾产量数据*/ 
		ExecutorService senhe_exc= Executors.newSingleThreadExecutor();
		try {
			senhe_exc.execute(new Runnable() {
			@Override
			public void run() {
				XSocketSenHeServer senHeServer = new XSocketSenHeServer(7011);
				senHeServer.start();
			}
		  });
		} catch (Exception e) {
		}finally{
			senhe_exc.shutdown();
		}
		
		/**开启命令接收socket服务端*/
		/*ExecutorService Quartz_exc= Executors.newSingleThreadExecutor();
		try {
		  Quartz_exc.execute(new Runnable() {
			@Override
			public void run() {
				XSocketCommadServer projectServer = new XSocketCommadServer(7000);
			    projectServer.start();
			}
		  });
		} catch (Exception e) {
		}finally{
		    Quartz_exc.shutdown();
		}*/
		
		/**开启websocket心跳连接*/
		  ExecutorService Commmandext= Executors.newSingleThreadExecutor();
		  try {
			  //"ws://127.0.0.1:8080/LayIM_JavaClient/websocket/456";
			  String wrUrl=ConstantBean.constantMap.get("WEBSOCKETURL").toString();
			  if(wrUrl!=null && !"".equals(wrUrl)){
				  CommmandClient commmandClient=CommmandClient.getCommmandClient();
				  commmandClient.runCommmandConnect(wrUrl);
				  Commmandext.execute(new CommmandHeartbeat(commmandClient));//创建commandwebsocket心跳包
			  }
		  }catch (Exception e) {
		  }finally{
	    	Commmandext.shutdown();//结束线程
		  }
	}
}
