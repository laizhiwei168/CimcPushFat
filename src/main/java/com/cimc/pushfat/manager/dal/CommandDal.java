package com.cimc.pushfat.manager.dal;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.manager.common.DBBean;
import com.cimc.pushfat.manager.db.DBHandleHelper;
import com.cimc.pushfat.manager.po.CommandPo;
import com.cimc.pushfat.manager.po.Full_commandPo;


public class CommandDal {
	DBHandleHelper DbHelper=new DBHandleHelper();
	/*
	 * 查询3天内有效的命令
	 */	
	public List<Map<String, Object>> selectcammandBy3day(){
		String SQLString="select * FROM command where `status`='0'and type=1 AND addTime BETWEEN DATE_ADD(NOW(),INTERVAL -3 HOUR) AND NOW() ORDER BY addTime ";
		List<Map<String, Object>> ls_gx_cammand= DbHelper.Query(DBBean.mysqldata,SQLString);		
		return ls_gx_cammand;
	}
	
	/*
	 * 平台发送数据到设备时触发 ，作用起到与应答通信的标记
	 * 变更command数据的消息序号
	 */
	public int updateCommandtoframSeq(Full_commandPo full_command){
		String SQLString="update command "
				+ "set flowid='" + full_command.getFlowid() + "',status='" + full_command.getStatus()+ "' where id='" + full_command.getId() + "'";
		int Result=DbHelper.ExecuteSql(DBBean.mysqldata,SQLString);
		return Result;
	}

	/*
	 * 设备回应平台时触发，作用记录设备处理后返回的结果
	 * 根据IMEI，frameSeq字段变更设备配置结果
	 */
	public int updateCommand(Full_commandPo full_command){
		String SQLString="update command "
				+ "set finishTime='" + full_command.getFinishTime() + "',status='" + full_command.getStatus() + "'  where equipmet_id='" + full_command.getEquipmet_id() + "' and flowid='" + full_command.getFlowid() + "'AND addTime  BETWEEN DATE_ADD(NOW(),INTERVAL -3 HOUR) AND NOW() and `status`='0'";
		int Result=DbHelper.ExecuteSql(DBBean.mysqldata,SQLString);
		//System.out.println(SQLString);
		return Result;
	}
	
	public int updateTFCommand(Full_commandPo full_command){
		String SQLString="update command "
				+ "set finishTime='" + full_command.getFinishTime() + "',status='" + full_command.getStatus() + "'  where id='" + full_command.getId()  + "'AND addTime  BETWEEN DATE_ADD(NOW(),INTERVAL -3 HOUR) AND NOW() and `status`='1'";
		int Result=DbHelper.ExecuteSql(DBBean.mysqldata,SQLString);
		//System.out.println(SQLString);
		return Result;
	}
	
	/*
	 * 更具设备号和流水号查找命令内容
	 * */
	public List<Map<String, Object>> selectcammandByIDAndFlowid(Full_commandPo full_command){
		String SQLString="select id,equipmet_id,command_type,command_content FROM command where equipmet_id='" + full_command.getEquipmet_id() + "' and flowid='" + full_command.getFlowid() + "' AND addTime BETWEEN DATE_ADD(NOW(),INTERVAL -3 HOUR) AND NOW()";
		List<Map<String, Object>> ls_gx_cammand= DbHelper.Query(DBBean.mysqldata,SQLString);		
		return ls_gx_cammand;
	}
	
	/*
	 *新增一条命令数据
	 */
	public int insertCommand(CommandPo command){
		String SQLString="insert into command (id,equipmet_id,command_type,command_content,addTime,type) values('"+command.getId()+"','"+command.getEquipmet_id()+"','"+command.getCommand_type()+"','"+command.getCommand_content()+"','"+command.getAddTime()+"','1')";
		int Result=DbHelper.ExecuteSql(DBBean.mysqldata,SQLString);
		return Result;
	}
	
}
