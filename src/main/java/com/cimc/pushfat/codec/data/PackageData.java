package com.cimc.pushfat.codec.data;

import java.util.Arrays;

public class PackageData { 

	protected int identifier;//标识
	protected int protocol;//协议标识
	protected int protocolVersion;//协议版本
	protected String deviceId;//设备ID
	protected int messageID;// 功能码
	protected int element;// 单元标识符
	protected int flowId;//消息序号
	protected int msgBodyLength;//内容长度
	protected byte[] msgBodyBytes;//内容
	protected int checkSum;//校验
	
	
	
	
	@Override
	public String toString() {
		return "PackageData [identifier=" + identifier + ", protocol="
				+ protocol + ", protocolVersion=" + protocolVersion
				+ ", deviceId=" + deviceId + ", messageID=" + messageID
				+ ", element=" + element + ", flowId=" + flowId
				+ ", msgBodyLength=" + msgBodyLength + ", msgBodyBytes="
				+ Arrays.toString(msgBodyBytes) + ", checkSum=" + checkSum
				+ "]";
	}

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public int getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(int protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public byte[] getMsgBodyBytes() {
		return msgBodyBytes;
	}
	public void setMsgBodyBytes(byte[] msgBodyBytes) {
		this.msgBodyBytes = msgBodyBytes;
	}
	public int getCheckSum() {
		return checkSum;
	}
	public void setCheckSum(int checkSum) {
		this.checkSum = checkSum;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public int getProtocol() {
		return protocol;
	}
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	public int getMsgBodyLength() {
		return msgBodyLength;
	}
	public void setMsgBodyLength(int msgBodyLength) {
		this.msgBodyLength = msgBodyLength;
	}
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
