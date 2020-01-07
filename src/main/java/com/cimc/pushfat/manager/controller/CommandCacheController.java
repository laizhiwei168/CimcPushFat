package com.cimc.pushfat.manager.controller;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.command.cache.CommandCache;
import com.cimc.pushfat.command.handle.DeviceCommand;
import com.cimc.pushfat.manager.bll.CommandBll;
import com.cimc.pushfat.protocol.user.DeviceUserManager;
import com.cimc.pushfat.protocol.user.UserDeviceBean;



public class CommandCacheController {

	private CommandBll commandBll=new CommandBll();
	private CommandCache commandCache=CommandCache.getInstance();
	public void handlecomman2Cache(){
		List<Map<String, Object>> lst_map=commandBll.selectcammandBy3day();
		if(lst_map.isEmpty()){
			return;
		}
		for(Map<String, Object> map:lst_map){
			String id=map.get("id").toString().trim();
			String imeiNo=map.get("equipmet_id").toString().trim();
			String command_type="";
			if(map.get("command_type")!=null){
		    command_type=map.get("command_type").toString().trim();
			}
			String command_content="";
			if(map.get("command_content")!=null){
			command_content=map.get("command_content").toString().trim();
			}
			if(!"".equals(command_type)&&!"".equals(command_content)){
				String idAndtypeAndcontent=id+"="+command_type.toUpperCase()+"="+command_content;
				System.out.println(imeiNo+"=========="+idAndtypeAndcontent);
				commandCache.addCommandCache(imeiNo, idAndtypeAndcontent);	
			}
		}
		
		// 每个要下发命令的发送
		for(String equipmet_id:commandCache.getCommandCacheMap().keySet()) {
			DeviceUserManager deviceUserManager=DeviceUserManager.getInstance();
    		UserDeviceBean olduserDeviceBean=deviceUserManager.getUserDeviceBean(equipmet_id);
    		if(olduserDeviceBean!=null && olduserDeviceBean.isConnect()){
    			DeviceCommand deviceCommand=new DeviceCommand();
	    		deviceCommand.sendCacheCommand(olduserDeviceBean.getPackageData(), olduserDeviceBean.getXsocke());
    		}
		}
		
	}		
}
