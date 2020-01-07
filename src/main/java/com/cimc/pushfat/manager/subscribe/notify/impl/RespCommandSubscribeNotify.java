package com.cimc.pushfat.manager.subscribe.notify.impl;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.command.common.HttpCommandPo;
import com.cimc.pushfat.command.handle.DeviceCommand;
import com.cimc.pushfat.manager.bll.CommandBll;
import com.cimc.pushfat.manager.po.Full_commandPo;
import com.cimc.pushfat.manager.subscribe.notify.ISubscribeNotify;
import com.cimc.pushfat.protocol.user.DeviceUserManager;
import com.cimc.pushfat.protocol.user.UserDeviceBean;
import com.cimc.pushfat.utils.common.DateUtils;
import com.cimc.pushfat.utils.serializer.FastJsonSerializer;
import com.cimc.pushfat.websocket.client.CommmandClient;

public class RespCommandSubscribeNotify implements ISubscribeNotify {

	public CommandBll bll=new CommandBll();
	private FastJsonSerializer  fastJsonSerializer=new FastJsonSerializer();
	@Override
	public void HandleSubscribeNotify(Object deviceData) {
		PackageData packageData=(PackageData)deviceData;
		
		int flowid= packageData.getMsgBodyBytes()[0]& 0xff;
		Full_commandPo command=new Full_commandPo();
		command.setEquipmet_id(packageData.getDeviceId());
		command.setFlowid(flowid);
		List<Map<String, Object>> ls_gx_cammand= bll.selectcammandByIDAndFlowidToList(command);
		//System.out.println(fowl);
		if(ls_gx_cammand.size()>0) {
			Full_commandPo full_command=new Full_commandPo();
			full_command.setId(ls_gx_cammand.get(0).get("id").toString().trim());
			full_command.setFinishTime(DateUtils.getDoDayTime());
			full_command.setStatus(2);
			bll.updateTFCommand(full_command);
			
			HttpCommandPo httpCommandPo=new HttpCommandPo();
			httpCommandPo.setEquipmet_id(ls_gx_cammand.get(0).get("equipmet_id").toString());
			httpCommandPo.setCommand_type(ls_gx_cammand.get(0).get("command_type").toString());
			httpCommandPo.setCommand_content(ls_gx_cammand.get(0).get("command_content").toString());
			httpCommandPo.setStatus("2");
    		httpCommandPo.setType("ReCommand");
    		String ReCommand=fastJsonSerializer.toJSON(httpCommandPo);
    		CommmandClient.getCommmandClient().pushData(ReCommand);
		}	
		
		
		DeviceUserManager deviceUserManager=DeviceUserManager.getInstance();
		UserDeviceBean olduserDeviceBean=deviceUserManager.getUserDeviceBean(packageData.getDeviceId());
		if(olduserDeviceBean!=null && olduserDeviceBean.isConnect()){
			DeviceCommand deviceCommand=new DeviceCommand();
    		deviceCommand.sendCacheCommand(olduserDeviceBean.getPackageData(), olduserDeviceBean.getXsocke());
		}
	}

}
