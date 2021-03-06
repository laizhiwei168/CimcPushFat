package com.cimc.pushfat.socket.tcp;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;

import org.xsocket.DataConverter;
import org.xsocket.MaxReadSizeExceededException;
import org.xsocket.connection.IConnectHandler;
import org.xsocket.connection.IDataHandler;
import org.xsocket.connection.IDisconnectHandler;
import org.xsocket.connection.INonBlockingConnection;

import com.cimc.pushfat.protocol.service.ProtocolServiceImpl;
import com.cimc.pushfat.protocol.user.DeviceUserManager;


/**
 * 
 * @author lzw
 *
 */

public class ProjectHandle implements IDataHandler, IConnectHandler,IDisconnectHandler {

	public boolean onDisconnect(INonBlockingConnection connection)
			throws IOException {
		DeviceUserManager deviceUserManager=DeviceUserManager.getInstance();        
		String id = deviceUserManager.removeDeviceUser(connection.getId());
        System.out.println("总共在线人数"+deviceUserManager.getOnlineCount() + "      deviceId:" + id);
        return true; 
	}
	
	public boolean onConnect(INonBlockingConnection connection)
			throws IOException, BufferUnderflowException,
			MaxReadSizeExceededException {
		System.out.println(connection.getId() + "is connect!");
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
    	//String ss=new String(bt,Charset.forName("gbk"));//把byte数组转换为中文
    	//System.out.println(ss);
        if(bt.length<=0){
        	return true;  
        }
      
        //处理数据报文业务
        ProtocolServiceImpl ptl=new ProtocolServiceImpl();
        Object obj= ptl.dealWithData(bt,connection);//处理报文数据
        if(obj!=null){
        	connection.write((byte[])obj);//把数据反馈回设备端
        }
        return true;
	}   
}  