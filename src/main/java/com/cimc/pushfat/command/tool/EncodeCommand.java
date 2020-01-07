package com.cimc.pushfat.command.tool;

import com.cimc.pushfat.command.common.ParameterConfigurationBean;
import com.cimc.pushfat.utils.common.Utilty;


public class EncodeCommand {
	//private  Utilty util=new  Utilty();
	public String HandleEncodeCommand(ParameterConfigurationBean contentBean){
		 String pushFatValveType = contentBean.getPushFatValveType();
	     String pushFatMoShi = contentBean.getPushFatMoShi();
	    
	     String pushFatStatus=contentBean.getPushFatStatus();// 推肥状态
		 String pushFatDoorStatus1=contentBean.getPushFatDoorStatus1();
		 String pushFatDoorStatus2=contentBean.getPushFatDoorStatus2();
		 String pushFatDoorStatus3=contentBean.getPushFatDoorStatus3();
		 String pushFatDoorStatus4=contentBean.getPushFatDoorStatus4();
		
		 String pushFatPumpStatus=contentBean.getPushFatPumpStatus();// 推肥泵状态
		
	     String KPSecondFatWeightValue=contentBean.getKPSecondFatWeightValue();// 推P,K(备)肥重量设定值
	 	 String KPFatCompensationValue =contentBean.getKPFatCompensationValue();// K,P(主)肥补偿设定值
	 	 String KPFatWeightValue=contentBean.getKPFatWeightValue();//推P,K(主)肥重量设定值
	 	 String XSAFatWeightValue=contentBean.getXSAFatWeightValue();//  推硫酸铵肥重量设定值
	 	 String KPSecondFatCompensationValue=contentBean.getKPSecondFatCompensationValue();// K,P(备)肥补偿设定值
	 	 String XSAFatCompensationValue=contentBean.getXSAFatCompensationValue();// 硫酸铵肥补偿设定值
	 	 
	 	 String pumpLaterPressureLowValue=contentBean.getPumpLaterPressureLowValue();// 泵后压力低设定值
	 	 String FlowLowValue=contentBean.getFlowLowValue();// 流量低设定值
	 	 String pumpFrequencyValue=contentBean.getPumpFrequencyValue(); //泵频率设定值
	    
	    
		StringBuffer strbf=new StringBuffer();
		
		 if(pushFatValveType != null) {
	         strbf.append(pushFatValveType);
	      } else {
	         strbf.append("ff");
	      }

	      if(pushFatMoShi != null) {
	         strbf.append(pushFatMoShi);
	      } else {
	         strbf.append("ff");
	      }
		
		//推肥状态
		 if(pushFatStatus!=null){
			 strbf.append(pushFatStatus);
		 }else{
			 strbf.append("ff");
		 }
		 
		 //1#推肥阀控制
		 if(pushFatDoorStatus1!=null){
			 strbf.append(pushFatDoorStatus1);
		 }else{
			 strbf.append("ff");
		 }
		 if(pushFatDoorStatus2!=null){
			 strbf.append(pushFatDoorStatus2);
		 }else{
			 strbf.append("ff");
		 }
		 if(pushFatDoorStatus3!=null){
			 strbf.append(pushFatDoorStatus3);
		 }else{
			 strbf.append("ff");
		 }
		 if(pushFatDoorStatus4!=null){
			 strbf.append(pushFatDoorStatus4);
		 }else{
			 strbf.append("ff");
		 }
		 
		 // 推肥泵控制		 
		 if(pushFatPumpStatus!=null){
			 strbf.append(pushFatPumpStatus);
		 }else{
			 strbf.append("ff");
		 }
		 
		 //电磁阀状态
		 strbf.append("ffffffffffffffffffffffffffffffff");
		 
		 //   推P,K(备)肥重量设定值
		 if(KPSecondFatWeightValue!=null){
			 float f=Float.parseFloat(KPSecondFatWeightValue);
			 if(f!=0) {
				 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
			 }else {
				 strbf.append("00000000");
			 }
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		 // K,P(主)肥补偿设定值
		 if(KPFatCompensationValue!=null){			 
			 float f=Float.parseFloat(KPFatCompensationValue);
			 if(f!=0) {
				 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
			 }else {
				 strbf.append("00000000");
			 }
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		 //  推P,K(主)肥重量设定值	 	
		 if(KPFatWeightValue!=null){
			 float f=Float.parseFloat(KPFatWeightValue);
			 if(f!=0) {
				 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
			 }else {
				 strbf.append("00000000");
			 }
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		 
		//  推硫酸铵肥重量设定值
		 if(XSAFatWeightValue!=null){
			 float f=Float.parseFloat(XSAFatWeightValue);
			 if(f!=0) {
				 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
			 }else {
				 strbf.append("00000000");
			 }
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		//  K,P(备)肥补偿设定值	 	
		 if(KPSecondFatCompensationValue!=null){
			 float f=Float.parseFloat(KPSecondFatCompensationValue);
			 if(f!=0) {
				 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
			 }else {
				 strbf.append("00000000");
			 }
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		// 硫酸铵肥补偿设定值
		 if(XSAFatCompensationValue!=null){
			 float f=Float.parseFloat(XSAFatCompensationValue);
			 if(f!=0) {
				 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
			 }else {
				 strbf.append("00000000");
			 }
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		// 泵后压力低设定值
		 if(pumpLaterPressureLowValue!=null){
			 float f=Float.parseFloat(pumpLaterPressureLowValue);
			 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		// 流量低设定值
		 if(FlowLowValue!=null){
			 float f=Float.parseFloat(FlowLowValue);
			 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
		 }else{
			 strbf.append("ffffffff");
		 }
		 
		// 泵频率设定
		 if(pumpFrequencyValue!=null){
			 float f=Float.parseFloat(pumpFrequencyValue);
			 strbf.append(Integer.toHexString(Float.floatToIntBits(f)));
		 }else{
			 strbf.append("ffffffff");
		 }				 
		 
		 strbf.append("ffffffffffffffffffffffff");
		 
		 return strbf.toString();
	}
	
	
	/*public static void main(String[] args) {
		EncodeCommand EncodeCommand=new EncodeCommand();
		ParameterConfigurationBean contentBean=new ParameterConfigurationBean();
		contentBean.setPumpFrequencyValue("41C80000");
		String str=EncodeCommand.HandleEncodeCommand(contentBean);
		System.out.println(str);
	}*/
}
