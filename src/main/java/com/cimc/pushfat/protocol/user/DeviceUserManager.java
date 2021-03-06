package com.cimc.pushfat.protocol.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.xsocket.connection.INonBlockingConnection;

import com.cimc.pushfat.codec.data.PackageData;


public class DeviceUserManager {
	private DeviceUserManager(){
    }
    private static DeviceUserManager manager = new DeviceUserManager();
    
    public static DeviceUserManager getInstance(){
        return manager;
    }
    
    private final Map<String, String> socketTagMap=new ConcurrentHashMap<String, String>();
    private final ConcurrentMap<String, UserDeviceBean> deviceMap = new ConcurrentHashMap<>();
    
    // 记录设备通讯渠道
    public int addDeviceUser(PackageData packageData,INonBlockingConnection nbc){
    	String xsockeId =nbc.getId(); 
    	INonBlockingConnection xsocke= nbc;
    	String deviceId=packageData.getDeviceId();
    	if(!socketTagMap.containsKey(xsockeId)){//判断标记map里是否存在对应的xsockeId
    		socketTagMap.put(xsockeId, deviceId);
    		if(deviceMap.containsKey(deviceId)){//处理已登记号的设备
    			UserDeviceBean olduserDeviceBean= deviceMap.get(deviceId);
    			olduserDeviceBean.setConnect(true);
    			olduserDeviceBean.setXsocke(xsocke);
    			olduserDeviceBean.setXsockeId(xsockeId);
    			return 3;
    		}else{
    			UserDeviceBean userDeviceBean=new UserDeviceBean(); 
    			userDeviceBean.setConnect(true);
    			userDeviceBean.setXsocke(xsocke);
    			userDeviceBean.setPackageData(packageData);
    			userDeviceBean.setXsockeId(xsockeId);
    			deviceMap.put(deviceId, userDeviceBean);
    		}
    		return 1;
    	}
    	return 0;
    }
    
    // 获取设备信息
    public String getdeviceId(String xsockeId){
    	return socketTagMap.get(xsockeId);
    }
    
    // 获取设备渠道信息
    public UserDeviceBean getUserDeviceBean(String deviceId){
    	UserDeviceBean olduserDeviceBean= deviceMap.get(deviceId);
    	return olduserDeviceBean;
    }
    
    // 断开连接操作
    public String  removeDeviceUser(String xsockeId) {
		String deviceId=socketTagMap.remove(xsockeId);
		if(deviceId!=null){
			UserDeviceBean userDeviceBean= deviceMap.get(deviceId);
			if(userDeviceBean!=null && xsockeId.equals(userDeviceBean.getXsockeId())){
				userDeviceBean.setConnect(false);
				return deviceId;
			}
		}
	 return deviceId+"--过期--";
    }
    
    // 统计在线人数
    public int getOnlineCount() {
        return socketTagMap.size();
    }    	
}
