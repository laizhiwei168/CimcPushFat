package com.cimc.pushfat.codec.decode;

import com.cimc.pushfat.codec.common.MSConsts;
import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.utils.common.Utilty;


public class MsgDecoder {
	private Utilty utilty=new Utilty();
	public PackageData bytes2PackageData(byte[] data) {
		// 识别报文标识
		if(MSConsts.pkg_identifier != utilty.bytes2Int(data, 0, 1)){
			return null;
		}
		
		//校验码认证判断MsgLocationInfoDecoder
	   	String checkCode=""+utilty.toStringByte(data, data.length-2, data.length-1);	   	
	   	if(!checkCode.toUpperCase().equals(utilty.getCRC16MODBUS(data,data.length-2))) {
	   		System.out.println("校验码失败！！！！！！！");
	   		return null;
	    }
		
		PackageData packageData=null;
	   	try{
	   		packageData=new PackageData();
			packageData.setIdentifier(utilty.bytes2Int(data, 0, 1));
			packageData.setProtocol(utilty.bytes2Int(data, 1, 1));
			packageData.setProtocolVersion(utilty.bytes2Int(data, 2, 1));
			String deviceId=utilty.toStringByte(data,3,6);
			packageData.setDeviceId(deviceId);
			packageData.setMessageID(data[7] & 0xff);
			packageData.setElement(data[8] & 0xff);	
			packageData.setFlowId(data[9] & 0xff);
			packageData.setMsgBodyLength(data[10] & 0xff);
			byte[] tmp = new byte[data[10] & 0xff];
			System.arraycopy(data, 11, tmp, 0, tmp.length);
			packageData.setMsgBodyBytes(tmp);
			//System.out.println(utilty.toStringByte(tmp, 0, tmp.length-1));
	   	} catch(Exception e){
	   		System.out.println(" == == 无法识别设备的设备号位数  或 设备内容长度有误  == == ");
	   	}
		return packageData;
	}
}
