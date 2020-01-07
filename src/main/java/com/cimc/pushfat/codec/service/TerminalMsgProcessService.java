package com.cimc.pushfat.codec.service;

import java.util.List;

import com.cimc.pushfat.bean.common.DevicePressureBean;
import com.cimc.pushfat.bean.common.DeviceValveNumberBean;
import com.cimc.pushfat.codec.data.CommandEquipmentPackageData;
import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.codec.encode.MsgEncoder;
import com.cimc.pushfat.main.handle.DevicePressureControl;
import com.cimc.pushfat.main.handle.DeviceValveControl;



public class TerminalMsgProcessService {

    private MsgEncoder msgEncoder;

    public TerminalMsgProcessService() {
        this.msgEncoder = new MsgEncoder();
    }
    // 信息放回
    public byte[] processInformationMsg(PackageData packageData) throws Exception {
    	Integer Valve=DeviceValveNumberBean.getDeviceValveAddress(packageData.getDeviceId());
    	String str_body;
    	if(Valve!=null){
    		String state=DeviceValveControl.getDeviceValveState(Valve,"未分组");
        	if(state!=null && !"".equals(state)){
        		// 处理管道压力
        		 List<String> ls=DevicePressureBean.getDevicePressure(packageData.getDeviceId());
        		 String devicePressure= DevicePressureControl.handleDevicePressure(ls);
        		 if(devicePressure!=null && !"".equals(devicePressure)) {
        			 str_body = "0000000000000000" + state +devicePressure;
        		 }else {
        			 str_body = "0000000000000000" + state + "00000000000000000000000000000000"; 
        		 }
        	}else{
        		str_body = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        	}
    	}else {
    		 str_body = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
    	}
    	
    	byte[] bs = this.msgEncoder.encode4TerminalInformationResp(packageData,str_body);
        return bs;
    }
    // 设备控制返回
    public byte[] processCommandValveMsg(CommandEquipmentPackageData commandEquipmentPackageData) throws Exception {
    	
    	Integer Valve=DeviceValveNumberBean.getDeviceValveAddress(commandEquipmentPackageData.getDeviceId());
    	String str_body;
    	if(Valve!=null){
    		String state=DeviceValveControl.handleDeviceValve(Valve,"未分组",commandEquipmentPackageData);
        	if(state!=null && !"".equals(state)){
        		// 处理管道压力
       		 List<String> ls=DevicePressureBean.getDevicePressure(commandEquipmentPackageData.getDeviceId());
       		 String devicePressure= DevicePressureControl.handleDevicePressure(ls);
       		 if(devicePressure!=null && !"".equals(devicePressure)) {
    			 str_body = "0000000000000000" + state +devicePressure;
       		 }else {
        		 str_body = "0000000000000000" + state + "00000000000000000000000000000000";
       		 }
        	}else{
        		str_body = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        	}
    	}else {
    		 str_body = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
    	}
    	
    	byte[] bs = this.msgEncoder.encode4TerminalInformationResp(commandEquipmentPackageData,str_body);
        return bs;
    }

}
