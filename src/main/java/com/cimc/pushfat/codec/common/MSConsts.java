package com.cimc.pushfat.codec.common;

public class MSConsts {
	
	// 标识位
    public static final int pkg_identifier = 0x7E;
    
    // 协议
    //public static final int msg_cimc_protocol_handshake = 0x2222;	
    //public static final int msg_cimc_protocol_modbus = 0x0000;	
    
    // 终端通用应答
 	public static final int msg_cimc_terminal_common_req = 0x00;	
 	public static final int msg_cimc_terminal_Information_req = 0x51;//设备主动上报
 	public static final int msg_cimc_terminal_Command_equipment_req = 0x52;// 终端设备操作控制
 	public static final int msg_cimc_terminal_Command_platform_req = 0x53;// 平台操作控制回复
 	
 		
    // 平台通用应答
 	public static final int cmd_cimnc_common_resp = 0x0001;
 	public static final int cmd_cimnc_Information_resp = 0x61;//设备主动上报
 	public static final int cmd_cimnc_Command_equipment_resp = 0x62;// 终端设备操作控制
 	public static final int cmd_cimnc_Command_platform_resp = 0x63;// 平台操作控制回复
 	
}
