package com.cimc.pushfat.codec.encode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.utils.common.Utilty;
import com.cimc.pushfat.codec.common.MSConsts;


public class MsgEncoder {
	private Utilty utilty=new Utilty();
	
	// 回复通用应答
	public byte[] encode4TerminalCommonResp(PackageData packageData) throws IOException{
		byte[] body=utilty.concatAll(utilty.int2Bytes(packageData.getFlowId(),1),new byte[]{0x01});
		byte[] headerAndBody= encodMsg(packageData,MSConsts.cmd_cimnc_common_resp,body);
		byte[] crc_bys= utilty.hexStrToByteArray(utilty.getCRC16MODBUS(headerAndBody,headerAndBody.length));
		byte[] msgHeaderAndBody=utilty.concatAll(headerAndBody, crc_bys);
		return msgHeaderAndBody;
	}
	
	//Information
	public byte[] encode4TerminalInformationResp(PackageData packageData) throws IOException{
		byte[] body=utilty.concatAll(utilty.int2Bytes(packageData.getFlowId(),1),new byte[]{0x01});
		byte[] headerAndBody= encodMsg(packageData,MSConsts.cmd_cimnc_Information_resp,body);
		byte[] crc_bys= utilty.hexStrToByteArray(utilty.getCRC16MODBUS(headerAndBody,headerAndBody.length));
		byte[] msgHeaderAndBody=utilty.concatAll(headerAndBody, crc_bys);
		return msgHeaderAndBody;
	}
	
	public byte[] encode4TerminalInformationResp(PackageData packageData,String str_body) throws IOException{
		//byte[] body=utilty.concatAll(utilty.int2Bytes(packageData.getFlowId(),1),new byte[]{0x01});
		byte[] body=utilty.hexStrToByteArray(str_body);
		byte[] headerAndBody= encodMsg(packageData,MSConsts.cmd_cimnc_Information_resp,body);
		byte[] crc_bys= utilty.hexStrToByteArray(utilty.getCRC16MODBUS(headerAndBody,headerAndBody.length));
		byte[] msgHeaderAndBody=utilty.concatAll(headerAndBody, crc_bys);
		return msgHeaderAndBody;
	}
	
	public byte[] encode4TerminalCommandResp(PackageData packageData,byte[] body) throws IOException{		
		byte[] headerAndBody= encodMsg(packageData,MSConsts.cmd_cimnc_Command_platform_resp,body);
		byte[] crc_bys= utilty.hexStrToByteArray(utilty.getCRC16MODBUS(headerAndBody,headerAndBody.length));
		byte[] msgHeaderAndBody=utilty.concatAll(headerAndBody, crc_bys);
		return msgHeaderAndBody;
	}
	
	public byte[] encode4TerminalCommandValveResp(PackageData packageData,byte[] body) throws IOException{		
		byte[] headerAndBody= encodMsg(packageData,MSConsts.cmd_cimnc_Command_equipment_resp,body);
		byte[] crc_bys= utilty.hexStrToByteArray(utilty.getCRC16MODBUS(headerAndBody,headerAndBody.length));
		byte[] msgHeaderAndBody=utilty.concatAll(headerAndBody, crc_bys);
		return msgHeaderAndBody;
	}
	
	public byte[] encode4TerminalCommandValveResp(PackageData packageData,String str_body) throws IOException{
		byte[] body=utilty.hexStrToByteArray(str_body);
		byte[] headerAndBody= encodMsg(packageData,MSConsts.cmd_cimnc_Command_equipment_resp,body);
		byte[] crc_bys= utilty.hexStrToByteArray(utilty.getCRC16MODBUS(headerAndBody,headerAndBody.length));
		byte[] msgHeaderAndBody=utilty.concatAll(headerAndBody, crc_bys);
		return msgHeaderAndBody;
	}
	
	// 组装协议报文结构
	private byte[] encodMsg(PackageData packageData,int messageID,byte[] body) throws IOException{
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			int bodyLength=0;
			if(body!=null){
				bodyLength=body.length;
			}
			// 标识
			baos.write(new byte[]{0x7e});
			// 协议标识
			baos.write(utilty.int2Bytes(packageData.getProtocol(),1));
			// 协议版本
			baos.write(utilty.int2Bytes(packageData.getProtocolVersion(),1));			
			// 设备ID
			//String deviceId=utilty.convertStringToHex(packageData.getDeviceId());
			baos.write(utilty.hexStrToByteArray(packageData.getDeviceId()));
			// 功能码
			baos.write(utilty.int2Bytes(messageID,1));				
			// 单元标识符
			baos.write(utilty.int2Bytes(packageData.getElement(),1));
			// 消息序号
			baos.write(utilty.int2Bytes(getFlowId(packageData.getFlowId()),1));
			// 内容长度
			baos.write(utilty.int2Bytes(bodyLength,1));
			// 内容
			if(bodyLength>0){
			baos.write(body);			
			}
			return baos.toByteArray();
		} finally {
			if (baos != null) {
				baos.close();
			}
		}		
	}
	
	//获取流水号
    private  int getFlowId(int currentFlowId){
    	if (currentFlowId >= 0xff)
			currentFlowId = 0;
		return ++currentFlowId;
    }

	
}
