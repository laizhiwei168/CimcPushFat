package com.cimc.pushfat.manager.po;

public class TaEquipmentPo {

	 private String pk_equipment;
	   private String pk_company;
	   private String equipmentNo;
	   private Integer equipmentType;
	   private String creator;
	   private String creatortime;
	   private String modifier;
	   private String modifiedtime;
	   
	public String getPk_equipment() {
		return pk_equipment;
	}
	public void setPk_equipment(String pk_equipment) {
		this.pk_equipment = pk_equipment;
	}
	public String getPk_company() {
		return pk_company;
	}
	public void setPk_company(String pk_company) {
		this.pk_company = pk_company;
	}
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public Integer getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(Integer equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreatortime() {
		return creatortime;
	}
	public void setCreatortime(String creatortime) {
		this.creatortime = creatortime;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	   
}
