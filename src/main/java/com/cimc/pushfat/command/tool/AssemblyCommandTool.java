package com.cimc.pushfat.command.tool;

import com.cimc.pushfat.command.common.ParameterConfigurationBean;


public class AssemblyCommandTool {
	public ParameterConfigurationBean  HandleAssemblyCommand(String[] l_command_content,String[] l_command_type){
		ParameterConfigurationBean pc_po =new ParameterConfigurationBean();
		int commandNumber=l_command_type.length;
		int commandContent=l_command_content.length;
		if(commandNumber>0){
		  for(int i=0;i<commandNumber;i++){
			  String type=l_command_type[i];
			  String content="";
			  if(commandContent>0){//处理查询命令
				  content=l_command_content[i];
			  }
			  AssemblyCommand(content, type.toUpperCase(), pc_po);
		  }
		}
		
		return pc_po;
	}
	
	private void AssemblyCommand(String command_content,String command_type,ParameterConfigurationBean pc_po){
		switch (command_type) {
		case "10":
			pc_po.setPushFatValveType(command_content);
			break;
		case "11":
			pc_po.setPushFatMoShi(command_content);
			break;
		case "A0":
			//推肥状态
			pc_po.setPushFatStatus(command_content);
			break;
		case "A1":
			//推肥阀门1
			pc_po.setPushFatDoorStatus1(command_content);
			break;
		case "A2":
			//推肥阀门2
			pc_po.setPushFatDoorStatus2(command_content);
			break;
		case "A3":
			//推肥阀门3
			pc_po.setPushFatDoorStatus3(command_content);
			break;
		case "A4":
			//推肥阀门4
			pc_po.setPushFatDoorStatus4(command_content);
			break;
		
		case "B0":
			//推肥泵状态
			pc_po.setPushFatPumpStatus(command_content);
			break;
			
		case "C1":
			//推P,K(备)肥重量设定值		
			pc_po.setKPSecondFatWeightValue(command_content);
			break;
		case "C2":
			//K,P(主)肥补偿设定值
			pc_po.setKPFatCompensationValue(command_content);
			break;
		case "C3":
			//推P,K(主)肥重量设定值
			pc_po.setKPFatWeightValue(command_content);
			break;
		case "C4":
			// 推硫酸铵肥重量设定值
			pc_po.setXSAFatWeightValue(command_content);
			break;
		case "C5":
			// K,P(备)肥补偿设定值
			pc_po.setKPSecondFatCompensationValue(command_content);
			break;
		case "C6":
			// 硫酸铵肥补偿设定值
			pc_po.setXSAFatCompensationValue(command_content);
			break;
		case "C7":
			//泵后压力低设定值
			pc_po.setPumpLaterPressureLowValue(command_content);
			break;
		case "C8":
			//流量低设定值
			pc_po.setFlowLowValue(command_content);
			break;
		case "C9":
			//泵频率设定值
			pc_po.setPumpFrequencyValue(command_content);
			break;
		
		}
	}
}
