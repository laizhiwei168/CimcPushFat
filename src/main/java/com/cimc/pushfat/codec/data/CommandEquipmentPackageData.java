package com.cimc.pushfat.codec.data;

public class CommandEquipmentPackageData extends PackageData { 
	public CommandEquipmentPackageData(PackageData packageData){
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
	
	private String valve1;// 阀门1
	private String valve2;// 阀门2
	private String valve3;// 阀门3
	private String valve4;// 阀门4
	private String valve5;// 阀门5
	private String valve6;// 阀门6
	private String valve7;// 阀门7
	private String valve8;// 阀门8
	private String valve9;// 阀门8
	
	
	@Override
	public String toString() {
		return valve1 +  valve2 + valve3 + valve4+ valve5 + valve6 + valve7 + valve8+ valve9 ;
	}
	public String getValve1() {
		return valve1;
	}
	public void setValve1(String valve1) {
		this.valve1 = valve1;
	}
	public String getValve2() {
		return valve2;
	}
	public void setValve2(String valve2) {
		this.valve2 = valve2;
	}
	public String getValve3() {
		return valve3;
	}
	public void setValve3(String valve3) {
		this.valve3 = valve3;
	}
	public String getValve4() {
		return valve4;
	}
	public void setValve4(String valve4) {
		this.valve4 = valve4;
	}
	public String getValve5() {
		return valve5;
	}
	public void setValve5(String valve5) {
		this.valve5 = valve5;
	}
	public String getValve6() {
		return valve6;
	}
	public void setValve6(String valve6) {
		this.valve6 = valve6;
	}
	public String getValve7() {
		return valve7;
	}
	public void setValve7(String valve7) {
		this.valve7 = valve7;
	}
	public String getValve8() {
		return valve8;
	}
	public void setValve8(String valve8) {
		this.valve8 = valve8;
	}
	public String getValve9() {
		return valve9;
	}
	public void setValve9(String valve9) {
		this.valve9 = valve9;
	}
	
}
