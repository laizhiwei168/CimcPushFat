package com.cimc.pushfat.codec.data;


public class InformationPackageData extends PackageData { 
	public InformationPackageData(PackageData packageData){
		this.identifier=packageData.getIdentifier();//标识
		this.protocol=packageData.getProtocol();//协议标识
		this.protocolVersion=packageData.getProtocolVersion();//协议版本
		this.deviceId=packageData.getDeviceId();//设备ID
		this.messageID=packageData.getMessageID();// 功能码
		this.element=packageData.getElement();// 单元标识符
		this.flowId=packageData.getFlowId();//消息序号
		this.msgBodyLength=packageData.getMsgBodyLength();//内容长度
		this.msgBodyBytes=packageData.getMsgBodyBytes();//内容
		this.checkSum=packageData.getCheckSum();//校验		
	}
	
	private String dataTime;
	
	private Integer doorNumber;
	
	private Integer deviceAlert;// 有无报警
	
	private Integer deviceOperatePattern;// 设备操作模式
	
	private Integer pushFatStatus;// 推肥状态
	private Boolean pushFatDoorStatus1;
	private Boolean pushFatDoorStatus2;
	private Boolean pushFatDoorStatus3;
	private Boolean pushFatDoorStatus4;
	
	private Integer pushFatPumpStatus;// 推肥泵状态
	private Boolean pushFatPumpDoorStatus1;
	private Boolean pushFatPumpDoorStatus2;
	private Boolean pushFatPumpDoorStatus3;
	private Boolean pushFatPumpDoorStatus4;
	private Boolean pushFatPumpDoorStatus5;

	private Boolean pushFatPumpDoorStatus6;
	private Boolean pushFatPumpDoorStatus7;
	private Boolean pushFatPumpDoorStatus8;
	private Boolean pushFatPumpDoorStatus9;
	private Boolean pushFatPumpDoorStatus10;

	private Boolean pushFatPumpDoorStatus11;
	private Boolean pushFatPumpDoorStatus12;
	private Boolean pushFatPumpDoorStatus13;
	private Boolean pushFatPumpDoorStatus14;
	private Boolean pushFatPumpDoorStatus15;
	
	private Boolean pushFatPumpDoorStatus16;
	
	private Integer pushFatNumber;// 推肥次数
	
	private Integer	KPFatWeight; // 当前推K,P肥重量
	private Integer KPSecondFatWeight;// 当前推K,P副肥重量
	private Integer XSAFatWeight;// 当前推硫酸铵肥重量
	private Integer KPFatGross;// K,P肥总量
	private Integer KPSecondFatGross;// K,P副肥总量	
	private Integer XSAFatGross;// 硫酸铵肥总量
	private Integer KPFatLength;// 当前推K,P(主)肥时长
	private Integer KPSecondFatLength;// 当前推K,P(备)肥时长
	private Integer XSAFatLength;//推硫酸铵肥时长

	private Integer KPFatTotalLength;// 当前推K,P(主)肥总时长
	private Integer KPSecondFatTotalLength;// 当前推K,P(备)肥总时长
	private Integer XSAFatTotalLength;//推硫酸铵肥总时长
	
	private Integer instantFlow;// 当前瞬时流量
	private Integer pumpLaterPressure;// 泵后压力
	
	private Integer KPFatTanklevel;// KP肥罐液位
	private Integer KPSecondFatTanklevel;// KP副肥罐液位	
	private Integer XSAFatTanklevel;// 硫酸铵肥罐液位
	
	private Integer KPFatWeightValue;// 推P,K肥重量设定值
	private Integer KPSecondFatWeightValue;// 推P,K副肥重量设定值	
	private Integer XSAFatWeightValue;//  推硫酸铵肥重量设定值
	
	private Integer KPFatCompensationValue;//K,P(主)肥补偿设定值
	private Integer KPSecondFatCompensationValue;//K,P(备)肥补偿设定值
	private Integer XSAFatCompensationValue;//硫酸铵肥补偿设定值
	
	private Integer pumpLaterPressureLowValue;// 泵后压力低设定值
	private Integer FlowLowValue;// 流量低设定值
	private Integer pumpFrequencyValue; //泵频率设定值
	
	private Integer KPPushFatNumber; //K,P(主)肥推肥次数
	private Integer KPSecondPushFatNumber; //K,P(备)肥推肥次数
	private Integer XSAPushFatNumber; //硫酸铵肥推肥次数
	
	
	public Integer getKPPushFatNumber() {
		return KPPushFatNumber;
	}
	public void setKPPushFatNumber(Integer kPPushFatNumber) {
		KPPushFatNumber = kPPushFatNumber;
	}
	public Integer getKPSecondPushFatNumber() {
		return KPSecondPushFatNumber;
	}
	public void setKPSecondPushFatNumber(Integer kPSecondPushFatNumber) {
		KPSecondPushFatNumber = kPSecondPushFatNumber;
	}
	public Integer getXSAPushFatNumber() {
		return XSAPushFatNumber;
	}
	public void setXSAPushFatNumber(Integer xSAPushFatNumber) {
		XSAPushFatNumber = xSAPushFatNumber;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public Integer getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(Integer doorNumber) {
		this.doorNumber = doorNumber;
	}
	public Integer getDeviceAlert() {
		return deviceAlert;
	}
	public void setDeviceAlert(Integer deviceAlert) {
		this.deviceAlert = deviceAlert;
	}
	public Integer getPushFatStatus() {
		return pushFatStatus;
	}
	public void setPushFatStatus(Integer pushFatStatus) {
		this.pushFatStatus = pushFatStatus;
	}
	public Boolean getPushFatDoorStatus1() {
		return pushFatDoorStatus1;
	}
	public void setPushFatDoorStatus1(Boolean pushFatDoorStatus1) {
		this.pushFatDoorStatus1 = pushFatDoorStatus1;
	}
	public Boolean getPushFatDoorStatus2() {
		return pushFatDoorStatus2;
	}
	public void setPushFatDoorStatus2(Boolean pushFatDoorStatus2) {
		this.pushFatDoorStatus2 = pushFatDoorStatus2;
	}
	public Boolean getPushFatDoorStatus3() {
		return pushFatDoorStatus3;
	}
	public void setPushFatDoorStatus3(Boolean pushFatDoorStatus3) {
		this.pushFatDoorStatus3 = pushFatDoorStatus3;
	}
	public Boolean getPushFatDoorStatus4() {
		return pushFatDoorStatus4;
	}
	public void setPushFatDoorStatus4(Boolean pushFatDoorStatus4) {
		this.pushFatDoorStatus4 = pushFatDoorStatus4;
	}
	public Integer getPushFatPumpStatus() {
		return pushFatPumpStatus;
	}
	public void setPushFatPumpStatus(Integer pushFatPumpStatus) {
		this.pushFatPumpStatus = pushFatPumpStatus;
	}
	public Boolean getPushFatPumpDoorStatus1() {
		return pushFatPumpDoorStatus1;
	}
	public void setPushFatPumpDoorStatus1(Boolean pushFatPumpDoorStatus1) {
		this.pushFatPumpDoorStatus1 = pushFatPumpDoorStatus1;
	}
	public Boolean getPushFatPumpDoorStatus2() {
		return pushFatPumpDoorStatus2;
	}
	public void setPushFatPumpDoorStatus2(Boolean pushFatPumpDoorStatus2) {
		this.pushFatPumpDoorStatus2 = pushFatPumpDoorStatus2;
	}
	public Boolean getPushFatPumpDoorStatus3() {
		return pushFatPumpDoorStatus3;
	}
	public void setPushFatPumpDoorStatus3(Boolean pushFatPumpDoorStatus3) {
		this.pushFatPumpDoorStatus3 = pushFatPumpDoorStatus3;
	}
	public Boolean getPushFatPumpDoorStatus4() {
		return pushFatPumpDoorStatus4;
	}
	public void setPushFatPumpDoorStatus4(Boolean pushFatPumpDoorStatus4) {
		this.pushFatPumpDoorStatus4 = pushFatPumpDoorStatus4;
	}
	public Boolean getPushFatPumpDoorStatus5() {
		return pushFatPumpDoorStatus5;
	}
	public void setPushFatPumpDoorStatus5(Boolean pushFatPumpDoorStatus5) {
		this.pushFatPumpDoorStatus5 = pushFatPumpDoorStatus5;
	}
	public Boolean getPushFatPumpDoorStatus6() {
		return pushFatPumpDoorStatus6;
	}
	public void setPushFatPumpDoorStatus6(Boolean pushFatPumpDoorStatus6) {
		this.pushFatPumpDoorStatus6 = pushFatPumpDoorStatus6;
	}
	public Boolean getPushFatPumpDoorStatus7() {
		return pushFatPumpDoorStatus7;
	}
	public void setPushFatPumpDoorStatus7(Boolean pushFatPumpDoorStatus7) {
		this.pushFatPumpDoorStatus7 = pushFatPumpDoorStatus7;
	}
	public Boolean getPushFatPumpDoorStatus8() {
		return pushFatPumpDoorStatus8;
	}
	public void setPushFatPumpDoorStatus8(Boolean pushFatPumpDoorStatus8) {
		this.pushFatPumpDoorStatus8 = pushFatPumpDoorStatus8;
	}
	public Boolean getPushFatPumpDoorStatus9() {
		return pushFatPumpDoorStatus9;
	}
	public void setPushFatPumpDoorStatus9(Boolean pushFatPumpDoorStatus9) {
		this.pushFatPumpDoorStatus9 = pushFatPumpDoorStatus9;
	}
	public Boolean getPushFatPumpDoorStatus10() {
		return pushFatPumpDoorStatus10;
	}
	public void setPushFatPumpDoorStatus10(Boolean pushFatPumpDoorStatus10) {
		this.pushFatPumpDoorStatus10 = pushFatPumpDoorStatus10;
	}
	public Boolean getPushFatPumpDoorStatus11() {
		return pushFatPumpDoorStatus11;
	}
	public void setPushFatPumpDoorStatus11(Boolean pushFatPumpDoorStatus11) {
		this.pushFatPumpDoorStatus11 = pushFatPumpDoorStatus11;
	}
	public Boolean getPushFatPumpDoorStatus12() {
		return pushFatPumpDoorStatus12;
	}
	public void setPushFatPumpDoorStatus12(Boolean pushFatPumpDoorStatus12) {
		this.pushFatPumpDoorStatus12 = pushFatPumpDoorStatus12;
	}
	public Boolean getPushFatPumpDoorStatus13() {
		return pushFatPumpDoorStatus13;
	}
	public void setPushFatPumpDoorStatus13(Boolean pushFatPumpDoorStatus13) {
		this.pushFatPumpDoorStatus13 = pushFatPumpDoorStatus13;
	}
	public Boolean getPushFatPumpDoorStatus14() {
		return pushFatPumpDoorStatus14;
	}
	public void setPushFatPumpDoorStatus14(Boolean pushFatPumpDoorStatus14) {
		this.pushFatPumpDoorStatus14 = pushFatPumpDoorStatus14;
	}
	public Boolean getPushFatPumpDoorStatus15() {
		return pushFatPumpDoorStatus15;
	}
	public void setPushFatPumpDoorStatus15(Boolean pushFatPumpDoorStatus15) {
		this.pushFatPumpDoorStatus15 = pushFatPumpDoorStatus15;
	}
	public Boolean getPushFatPumpDoorStatus16() {
		return pushFatPumpDoorStatus16;
	}
	public void setPushFatPumpDoorStatus16(Boolean pushFatPumpDoorStatus16) {
		this.pushFatPumpDoorStatus16 = pushFatPumpDoorStatus16;
	}
	public Integer getPushFatNumber() {
		return pushFatNumber;
	}
	public void setPushFatNumber(Integer pushFatNumber) {
		this.pushFatNumber = pushFatNumber;
	}
	public Integer getKPFatWeight() {
		return KPFatWeight;
	}
	public void setKPFatWeight(Integer kPFatWeight) {
		KPFatWeight = kPFatWeight;
	}
	public Integer getXSAFatWeight() {
		return XSAFatWeight;
	}
	public void setXSAFatWeight(Integer xSAFatWeight) {
		XSAFatWeight = xSAFatWeight;
	}
	public Integer getKPFatGross() {
		return KPFatGross;
	}
	public void setKPFatGross(Integer kPFatGross) {
		KPFatGross = kPFatGross;
	}
	public Integer getXSAFatGross() {
		return XSAFatGross;
	}
	public void setXSAFatGross(Integer xSAFatGross) {
		XSAFatGross = xSAFatGross;
	}
	
	public Integer getPumpLaterPressure() {
		return pumpLaterPressure;
	}
	public void setPumpLaterPressure(Integer pumpLaterPressure) {
		this.pumpLaterPressure = pumpLaterPressure;
	}
	public Integer getInstantFlow() {
		return instantFlow;
	}
	public void setInstantFlow(Integer instantFlow) {
		this.instantFlow = instantFlow;
	}
	public Integer getKPFatWeightValue() {
		return KPFatWeightValue;
	}
	public void setKPFatWeightValue(Integer kPFatWeightValue) {
		KPFatWeightValue = kPFatWeightValue;
	}
	public Integer getXSAFatWeightValue() {
		return XSAFatWeightValue;
	}
	public void setXSAFatWeightValue(Integer xSAFatWeightValue) {
		XSAFatWeightValue = xSAFatWeightValue;
	}
	
	public Integer getPumpLaterPressureLowValue() {
		return pumpLaterPressureLowValue;
	}
	public void setPumpLaterPressureLowValue(Integer pumpLaterPressureLowValue) {
		this.pumpLaterPressureLowValue = pumpLaterPressureLowValue;
	}
	public Integer getFlowLowValue() {
		return FlowLowValue;
	}
	public void setFlowLowValue(Integer flowLowValue) {
		FlowLowValue = flowLowValue;
	}
	public Integer getPumpFrequencyValue() {
		return pumpFrequencyValue;
	}
	public void setPumpFrequencyValue(Integer pumpFrequencyValue) {
		this.pumpFrequencyValue = pumpFrequencyValue;
	}
	public Integer getDeviceOperatePattern() {
		return deviceOperatePattern;
	}
	public void setDeviceOperatePattern(Integer deviceOperatePattern) {
		this.deviceOperatePattern = deviceOperatePattern;
	}
	public Integer getKPSecondFatWeight() {
		return KPSecondFatWeight;
	}
	public void setKPSecondFatWeight(Integer kPSecondFatWeight) {
		KPSecondFatWeight = kPSecondFatWeight;
	}
	public Integer getKPSecondFatGross() {
		return KPSecondFatGross;
	}
	public void setKPSecondFatGross(Integer kPSecondFatGross) {
		KPSecondFatGross = kPSecondFatGross;
	}
	public Integer getKPFatTotalLength() {
		return KPFatTotalLength;
	}
	public void setKPFatTotalLength(Integer kPFatTotalLength) {
		KPFatTotalLength = kPFatTotalLength;
	}
	public Integer getKPSecondFatTotalLength() {
		return KPSecondFatTotalLength;
	}
	public void setKPSecondFatTotalLength(Integer kPSecondFatTotalLength) {
		KPSecondFatTotalLength = kPSecondFatTotalLength;
	}
	public Integer getXSAFatTotalLength() {
		return XSAFatTotalLength;
	}
	public void setXSAFatTotalLength(Integer xSAFatTotalLength) {
		XSAFatTotalLength = xSAFatTotalLength;
	}
	public Integer getKPFatTanklevel() {
		return KPFatTanklevel;
	}
	public void setKPFatTanklevel(Integer kPFatTanklevel) {
		KPFatTanklevel = kPFatTanklevel;
	}
	public Integer getKPSecondFatTanklevel() {
		return KPSecondFatTanklevel;
	}
	public void setKPSecondFatTanklevel(Integer kPSecondFatTanklevel) {
		KPSecondFatTanklevel = kPSecondFatTanklevel;
	}
	public Integer getXSAFatTanklevel() {
		return XSAFatTanklevel;
	}
	public void setXSAFatTanklevel(Integer xSAFatTanklevel) {
		XSAFatTanklevel = xSAFatTanklevel;
	}
	public Integer getKPSecondFatWeightValue() {
		return KPSecondFatWeightValue;
	}
	public void setKPSecondFatWeightValue(Integer kPSecondFatWeightValue) {
		KPSecondFatWeightValue = kPSecondFatWeightValue;
	}
	public Integer getKPFatCompensationValue() {
		return KPFatCompensationValue;
	}
	public void setKPFatCompensationValue(Integer kPFatCompensationValue) {
		KPFatCompensationValue = kPFatCompensationValue;
	}
	public Integer getKPSecondFatCompensationValue() {
		return KPSecondFatCompensationValue;
	}
	public void setKPSecondFatCompensationValue(Integer kPSecondFatCompensationValue) {
		KPSecondFatCompensationValue = kPSecondFatCompensationValue;
	}
	public Integer getXSAFatCompensationValue() {
		return XSAFatCompensationValue;
	}
	public void setXSAFatCompensationValue(Integer xSAFatCompensationValue) {
		XSAFatCompensationValue = xSAFatCompensationValue;
	}	
	public Integer getKPFatLength() {
		return KPFatLength;
	}
	public void setKPFatLength(Integer kPFatLength) {
		KPFatLength = kPFatLength;
	}
	public Integer getKPSecondFatLength() {
		return KPSecondFatLength;
	}
	public void setKPSecondFatLength(Integer kPSecondFatLength) {
		KPSecondFatLength = kPSecondFatLength;
	}
	public Integer getXSAFatLength() {
		return XSAFatLength;
	}
	public void setXSAFatLength(Integer xSAFatLength) {
		XSAFatLength = xSAFatLength;
	}
	
}
