package com.cimc.pushfat.protocol.service;


import org.xsocket.connection.INonBlockingConnection;

import com.cimc.pushfat.codec.common.MSConsts;
import com.cimc.pushfat.codec.data.CommandEquipmentPackageData;
import com.cimc.pushfat.codec.data.InformationPackageData;
import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.codec.decode.CommandEquipmentMsgDecoder;
import com.cimc.pushfat.codec.decode.InformationMsgDecoder;
//import com.cimc.pushfat.codec.decode.InformationMsgDecoder;
import com.cimc.pushfat.codec.decode.MsgDecoder;
import com.cimc.pushfat.codec.encode.MsgEncoder;
import com.cimc.pushfat.codec.service.TerminalMsgProcessService;
import com.cimc.pushfat.manager.subscribe.factory.SubscribeFactory;
import com.cimc.pushfat.protocol.user.DeviceUserController;
import com.cimc.pushfat.thread.pool.SubscribePool;
import com.cimc.pushfat.utils.log.LogManager;

/**
 * 协议中枢控制层
 * 
 * @author lzw
 *
 */
public class ProtocolServiceImpl {

	public Object dealWithData(final byte[] bt,INonBlockingConnection nbc) {
		byte[] re_msg_by=null;
		// 解析报文结构
		MsgDecoder msgDecoder=new MsgDecoder();
		PackageData packageData=msgDecoder.bytes2PackageData(bt);		
		//System.out.println(packageData);
		
		// 过滤掉非法报文
		if(packageData==null){
			LogManager.getInstance().PrintGainDeviceLog("deivce",bt);//打印log
			return null;
		}else{
			//记录设备上传报文			
			LogManager.getInstance().PrintGainDeviceLog(packageData.getDeviceId(),bt);						
		}
		
		TerminalMsgProcessService msgEncoderService=new TerminalMsgProcessService();
		// 设备信息
		if(MSConsts.msg_cimc_terminal_Information_req == packageData.getMessageID()){			
			try {
				InformationMsgDecoder informationMsgDecoder=new InformationMsgDecoder();
				InformationPackageData InformationPackageData=informationMsgDecoder.toInformationfoUploadMsg(packageData);
				HandldSubscribeData(packageData.getMessageID(), InformationPackageData);
				
				//re_msg_by=msgEncoder.encode4TerminalInformationResp(packageData);// 第一代				
				re_msg_by=msgEncoderService.processInformationMsg(packageData);
				if(re_msg_by!=null){
					LogManager.getInstance().PrintSentDeviceLog(packageData.getDeviceId(),re_msg_by);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 终端设备操作控制
		else if(MSConsts.msg_cimc_terminal_Command_equipment_req == packageData.getMessageID()){			
			try {
				CommandEquipmentMsgDecoder commandEquipmentMsgDecoder=new CommandEquipmentMsgDecoder();
				CommandEquipmentPackageData commandEquipmentPackageData=commandEquipmentMsgDecoder.toCommandEquipmentUploadMsg(packageData);
				HandldSubscribeData(packageData.getMessageID(), commandEquipmentPackageData);
				
				re_msg_by=msgEncoderService.processCommandValveMsg(commandEquipmentPackageData);
				if(re_msg_by!=null){
					LogManager.getInstance().PrintSentDeviceLog(packageData.getDeviceId(),re_msg_by);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 平台操作控制回复
		else if (MSConsts.msg_cimc_terminal_Command_platform_req == packageData.getMessageID()) {
			try {
				HandldSubscribeData(packageData.getMessageID(), packageData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		        
		DeviceUserController.getInstance().handleDeviceController(packageData, nbc);  
		return re_msg_by;
	}
	
	/**处理业务数据并操作数据库*/
	public void HandldSubscribeData(int MsgId,Object objectNode){
        SubscribePool.init().execute(new  Runnable() {
 			public void run() {
 				SubscribeFactory subscribeFactory=new SubscribeFactory();
 				subscribeFactory.pushDataToPlatform(MsgId,objectNode);
 			}
 		});
	}
}
