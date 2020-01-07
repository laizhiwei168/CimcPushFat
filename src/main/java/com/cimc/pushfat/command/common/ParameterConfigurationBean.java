package com.cimc.pushfat.command.common;

public class ParameterConfigurationBean {

	
	private String pushFatValveType;
	private String pushFatMoShi;
	
	private String pushFatStatus;// 推肥状态
	private String pushFatDoorStatus1;
	private String pushFatDoorStatus2;
	private String pushFatDoorStatus3;
	private String pushFatDoorStatus4;
	
	private String pushFatPumpStatus;// 推肥泵状态
	
	private String KPFatWeightValue;// 推P,K肥重量设定值
	private String KPSecondFatWeightValue;// 推P,K副肥重量设定值	
	private String XSAFatWeightValue;//  推硫酸铵肥重量设定值
	
	private String KPFatCompensationValue;//K,P(主)肥补偿设定值
	private String KPSecondFatCompensationValue;//K,P(备)肥补偿设定值
	private String XSAFatCompensationValue;//硫酸铵肥补偿设定值
 	
 	private String pumpLaterPressureLowValue;// 泵后压力低设定值
 	private String FlowLowValue;// 流量低设定值
 	private String pumpFrequencyValue; //泵频率设定值
 	
 	
	public String getPushFatValveType() {
		return pushFatValveType;
	}
	public void setPushFatValveType(String pushFatValveType) {
		this.pushFatValveType = pushFatValveType;
	}
	public String getPushFatMoShi() {
		return pushFatMoShi;
	}
	public void setPushFatMoShi(String pushFatMoShi) {
		this.pushFatMoShi = pushFatMoShi;
	}
	public String getPushFatStatus() {
		return pushFatStatus;
	}
	public void setPushFatStatus(String pushFatStatus) {
		this.pushFatStatus = pushFatStatus;
	}
	public String getPushFatDoorStatus1() {
		return pushFatDoorStatus1;
	}
	public void setPushFatDoorStatus1(String pushFatDoorStatus1) {
		this.pushFatDoorStatus1 = pushFatDoorStatus1;
	}
	public String getPushFatDoorStatus2() {
		return pushFatDoorStatus2;
	}
	public void setPushFatDoorStatus2(String pushFatDoorStatus2) {
		this.pushFatDoorStatus2 = pushFatDoorStatus2;
	}
	public String getPushFatDoorStatus3() {
		return pushFatDoorStatus3;
	}
	public void setPushFatDoorStatus3(String pushFatDoorStatus3) {
		this.pushFatDoorStatus3 = pushFatDoorStatus3;
	}
	public String getPushFatDoorStatus4() {
		return pushFatDoorStatus4;
	}
	public void setPushFatDoorStatus4(String pushFatDoorStatus4) {
		this.pushFatDoorStatus4 = pushFatDoorStatus4;
	}
	public String getPushFatPumpStatus() {
		return pushFatPumpStatus;
	}
	public void setPushFatPumpStatus(String pushFatPumpStatus) {
		this.pushFatPumpStatus = pushFatPumpStatus;
	}
	
	public String getPumpLaterPressureLowValue() {
		return pumpLaterPressureLowValue;
	}
	public void setPumpLaterPressureLowValue(String pumpLaterPressureLowValue) {
		this.pumpLaterPressureLowValue = pumpLaterPressureLowValue;
	}
	public String getFlowLowValue() {
		return FlowLowValue;
	}
	public void setFlowLowValue(String flowLowValue) {
		FlowLowValue = flowLowValue;
	}
	public String getPumpFrequencyValue() {
		return pumpFrequencyValue;
	}
	public void setPumpFrequencyValue(String pumpFrequencyValue) {
		this.pumpFrequencyValue = pumpFrequencyValue;
	}
	
	public String getKPFatCompensationValue() {
		return KPFatCompensationValue;
	}
	public void setKPFatCompensationValue(String kPFatCompensationValue) {
		KPFatCompensationValue = kPFatCompensationValue;
	}
	public String getKPSecondFatCompensationValue() {
		return KPSecondFatCompensationValue;
	}
	public void setKPSecondFatCompensationValue(String kPSecondFatCompensationValue) {
		KPSecondFatCompensationValue = kPSecondFatCompensationValue;
	}
	public String getXSAFatCompensationValue() {
		return XSAFatCompensationValue;
	}
	public void setXSAFatCompensationValue(String xSAFatCompensationValue) {
		XSAFatCompensationValue = xSAFatCompensationValue;
	}
	public String getKPFatWeightValue() {
		return KPFatWeightValue;
	}
	public void setKPFatWeightValue(String kPFatWeightValue) {
		KPFatWeightValue = kPFatWeightValue;
	}
	public String getKPSecondFatWeightValue() {
		return KPSecondFatWeightValue;
	}
	public void setKPSecondFatWeightValue(String kPSecondFatWeightValue) {
		KPSecondFatWeightValue = kPSecondFatWeightValue;
	}
	public String getXSAFatWeightValue() {
		return XSAFatWeightValue;
	}
	public void setXSAFatWeightValue(String xSAFatWeightValue) {
		XSAFatWeightValue = xSAFatWeightValue;
	}
 	
}
