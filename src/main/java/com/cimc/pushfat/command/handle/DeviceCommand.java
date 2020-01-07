package com.cimc.pushfat.command.handle;

import org.xsocket.connection.INonBlockingConnection;

import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.codec.encode.MsgEncoder;
import com.cimc.pushfat.command.cache.CommandCache;
import com.cimc.pushfat.command.common.ParameterConfigurationBean;
import com.cimc.pushfat.command.tool.AssemblyCommandTool;
import com.cimc.pushfat.command.tool.EncodeCommand;
import com.cimc.pushfat.manager.bll.CommandBll;
import com.cimc.pushfat.manager.po.Full_commandPo;
import com.cimc.pushfat.utils.common.DateUtils;
import com.cimc.pushfat.utils.common.Utilty;
import com.cimc.pushfat.utils.log.LogManager;



public class DeviceCommand {
	//private TerminalMsgProcessService msgProcessService=new TerminalMsgProcessService();
	public void sendCacheCommand(PackageData packageData,INonBlockingConnection nbc){
		Full_commandPo full_command=new Full_commandPo();
		ParameterConfigurationBean pc_po=null;
		String terminalPhone=packageData.getDeviceId();
		String idAndtypeAndcontent=CommandCache.getInstance().getCommandCache(terminalPhone);
		if(!"".equals(idAndtypeAndcontent.trim())){
			String[] strs=idAndtypeAndcontent.split("=");
			if(1<strs.length && strs.length<=3){
				String id=strs[0];
				String command_type=strs[1];
				String command_content=strs[2];
				if(!"".equals(command_type)){//这是防止非法命令，内容为空是查询命令 PlatformConversionCommand
					String[] l_command_type=command_type.split(",");
					String[] l_command_content=command_content.split(",");
					AssemblyCommandTool assemblyCommandTool=new AssemblyCommandTool();
					pc_po=assemblyCommandTool.HandleAssemblyCommand(l_command_content, l_command_type);
				}
				full_command.setId(id);
			}
		}
		
		if(pc_po!=null){
			Integer flowId=pushDeviceCommand(packageData, nbc, pc_po);
			if(flowId!=null){//处理业务
				full_command.setFlowid(flowId);
				full_command.setFinishTime(DateUtils.getDoDayTime());
				full_command.setStatus(1);
				CommandBll commandBll=new CommandBll();
				//commandBll.updateTFCommand(full_command);
				commandBll.updateCommandtoframSeq(full_command);
			}
		}
	}
	
	private Integer pushDeviceCommand(PackageData packageData,INonBlockingConnection nbc,ParameterConfigurationBean pc_po){
		Integer flowId=null;
		try { 
			 Utilty util=new  Utilty();
			 //获取组装命令报文
			 EncodeCommand encodeCommand=new EncodeCommand();
			 String commandBody=encodeCommand.HandleEncodeCommand(pc_po);
			 System.out.println("===commandBody:"+commandBody);
			 byte[] body_bt= util.hexStrToByteArray(commandBody);
			 MsgEncoder msgEncoder=new MsgEncoder();
			 byte[] msgHeaderAndBody= msgEncoder.encode4TerminalCommandResp(packageData, body_bt);			
			 nbc.write(msgHeaderAndBody);
			 flowId= getFlowId(packageData.getFlowId());
			 // 记录命令报文
			 LogManager.getInstance().PrintSentDeviceLog(packageData.getDeviceId(),msgHeaderAndBody);//记录应答报文
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flowId;
	}
	
	//获取流水号
    private  int getFlowId(int currentFlowId){
    	if (currentFlowId >= 0xff)
			currentFlowId = 0;
		return ++currentFlowId;
    }
	
}
