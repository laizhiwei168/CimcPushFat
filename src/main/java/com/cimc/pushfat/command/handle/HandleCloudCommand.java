package com.cimc.pushfat.command.handle;

import com.cimc.pushfat.command.cache.CommandCache;
import com.cimc.pushfat.command.common.HttpCommandPo;
import com.cimc.pushfat.manager.bll.CommandBll;
import com.cimc.pushfat.manager.po.CommandPo;
import com.cimc.pushfat.protocol.user.DeviceUserManager;
import com.cimc.pushfat.protocol.user.UserDeviceBean;
import com.cimc.pushfat.utils.common.DateUtils;
import com.cimc.pushfat.utils.common.StringUtils;
import com.cimc.pushfat.utils.common.UUIDUtil;
import com.cimc.pushfat.utils.serializer.FastJsonSerializer;
import com.cimc.pushfat.websocket.client.CommmandClient;


public class HandleCloudCommand {
	private FastJsonSerializer  fastJsonSerializer=new FastJsonSerializer();
	public String DecodeCloudCommand(String str){
		//LogManager.getInstance().PrintGetHttpCommandLog(str);// 打印数据信息
		if(str!=null && !"".equals(str) && StringUtils.isJSONValid2(str)){			
	        HttpCommandPo httpCommandPo= fastJsonSerializer.toObject(str, HttpCommandPo.class);
	        if(httpCommandPo!=null){
	        	System.out.println("========HandleCloudCommand处理=========");
	            String equipmet_id=httpCommandPo.getEquipmet_id();
	            String command_type=httpCommandPo.getCommand_type();
	            String command_content=httpCommandPo.getCommand_content();
	            System.out.println(equipmet_id.trim()+"   "+ command_type.trim()+"    "+ command_content.trim());
	            if(!StringUtils.strIsNullOrEmpty(equipmet_id)&& !StringUtils.strIsNullOrEmpty(command_type)&& !StringUtils.strIsNullOrEmpty(command_content)){        	
	            	String id=UUIDUtil.getUUID();
	        		String idAndtypeAndcontent=id+"="+command_type+"="+command_content;
	        		System.out.println(equipmet_id+"=========="+idAndtypeAndcontent);
	        		
	        		boolean isadd=CommandCache.getInstance().addCommandCache(equipmet_id, idAndtypeAndcontent);
	        		
        			if(isadd){
        				AddCommandData(id, equipmet_id, command_type, command_content);				
        			}
        			// 处理回复接收命令应答
	        		httpCommandPo.setStatus("1");
	        		httpCommandPo.setType("ReCommand");
	        		String ReCommand=fastJsonSerializer.toJSON(httpCommandPo);
	        		CommmandClient.getCommmandClient().pushData(ReCommand);
	        		
	        		// 处理命令下发
	        		DeviceUserManager deviceUserManager=DeviceUserManager.getInstance();
	        		UserDeviceBean olduserDeviceBean=deviceUserManager.getUserDeviceBean(equipmet_id);
	        		if(olduserDeviceBean!=null && olduserDeviceBean.isConnect()){
	        			DeviceCommand deviceCommand=new DeviceCommand();
			    		deviceCommand.sendCacheCommand(olduserDeviceBean.getPackageData(), olduserDeviceBean.getXsocke());
	        		}
	            }
	        } 
        }
		return "ok";
	}
	
	// 存储设备命令到数据库里
	private void AddCommandData(String id,String equipmet_id,String command_type,String command_content){
		CommandBll commandBll=new CommandBll();
		CommandPo command=new CommandPo();
		command.setId(id);
		command.setEquipmet_id(equipmet_id);
		command.setCommand_type(command_type);
		command.setCommand_content(command_content);
		command.setAddTime(DateUtils.getDoDayTime());
		commandBll.insertCommand(command);
	}
}
