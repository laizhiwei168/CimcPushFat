package com.cimc.pushfat.senhe.tcp;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.charset.Charset;

import org.xsocket.DataConverter;
import org.xsocket.MaxReadSizeExceededException;
import org.xsocket.connection.IConnectHandler;
import org.xsocket.connection.IDataHandler;
import org.xsocket.connection.IDisconnectHandler;
import org.xsocket.connection.INonBlockingConnection;

import com.cimc.pushfat.protocol.service.ProtocolServiceImpl;
import com.cimc.pushfat.protocol.service.TaLandYieldServiceImpl;
import com.cimc.pushfat.protocol.user.DeviceUserManager;
import com.cimc.pushfat.utils.log.LogManager;


/**
 * 
 * @author lzw
 *
 */

public class ProjectHandle implements IDataHandler, IConnectHandler,IDisconnectHandler {

	public boolean onDisconnect(INonBlockingConnection connection)
			throws IOException {
		
        return true; 
	}
	
	public boolean onConnect(INonBlockingConnection connection)
			throws IOException, BufferUnderflowException,
			MaxReadSizeExceededException {
		return true;
	}
	
	public boolean onData(INonBlockingConnection connection)
			throws IOException, BufferUnderflowException,
			ClosedChannelException, MaxReadSizeExceededException {
		
		ByteBuffer copyBuffer = ByteBuffer.allocate(20000);
		connection.read(copyBuffer); 
    	copyBuffer.flip();
    	
    	//处理没有数据的报文
    	byte[] bt = DataConverter.toBytes(copyBuffer);
    	//LogManager.getInstance().PrintSenHeLog(bt);
    	String str=new String(bt,Charset.forName("gbk"));//把byte数组转换为中文
    	//System.out.println(ss);
    	LogManager.getInstance().PrintSenHeLog(str);
    	if(str!=null) {
    		TaLandYieldServiceImpl ptl=new TaLandYieldServiceImpl();
    		ptl.dealWithData(str, connection);
    	}
        return true;
	}   
}  