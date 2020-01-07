package com.cimc.pushfat.command.common;

public class HttpCommandPo {
	private String equipmet_id;
	private String command_type;
	private String command_content;
	private String status;
	private String type;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEquipmet_id() {
		return equipmet_id;
	}
	public void setEquipmet_id(String equipmet_id) {
		this.equipmet_id = equipmet_id;
	}
	public String getCommand_type() {
		return command_type;
	}
	public void setCommand_type(String command_type) {
		this.command_type = command_type;
	}
	public String getCommand_content() {
		return command_content;
	}
	public void setCommand_content(String command_content) {
		this.command_content = command_content;
	}
		
}
