package com.cimc.pushfat.manager.subscribe.notify.impl;

import java.util.List;
import java.util.Map;


import com.cimc.pushfat.codec.data.InformationPackageData;
import com.cimc.pushfat.manager.bll.TaDataBll;
import com.cimc.pushfat.manager.po.TfEuipmetDataPo;
import com.cimc.pushfat.manager.subscribe.notify.ISubscribeNotify;
import com.cimc.pushfat.utils.common.DateUtils;


public class InformationSubscribeNotify implements ISubscribeNotify {

	 private TaDataBll bll = new TaDataBll();

	@Override
	public void HandleSubscribeNotify(Object deviceData) {
		InformationPackageData InformationPackageData=(InformationPackageData) deviceData;
		String deviceId = InformationPackageData.getDeviceId();
		List<Map<String, Object>> ls_Equipment = this.bll.selectEquipmentById(deviceId);
	    if(ls_Equipment.isEmpty()||ls_Equipment.size()<=0) {
	    	return ;
	    }
	    String pk_equipment = ((Map)ls_Equipment.get(0)).get("pk_equipment").toString();
        String dataTime = DateUtils.BCDdatetime2datetime(InformationPackageData.getDataTime());	// 时间段	
		 Integer doorNumber=InformationPackageData.getDoorNumber();	// 门的数量	
		 Integer  deviceAlert=InformationPackageData.getDeviceAlert();// 设备是否有报警		
		 Integer pushFatNumber=InformationPackageData.getPushFatNumber();// 推肥次数
		// System.out.println("dataTime:"+dataTime+"  doorNumber:"+doorNumber+"  deviceAlert:"+deviceAlert+"  pushFatNumber:"+pushFatNumber);
		
		 Integer deviceOperatePattern=InformationPackageData.getDeviceOperatePattern();// 设备操作模式
		 Integer pushFatStatus=InformationPackageData.getPushFatStatus();// 推肥状态
		 Boolean pushFatDoorStatus1=InformationPackageData.getPushFatDoorStatus1();
		 Boolean pushFatDoorStatus2=InformationPackageData.getPushFatDoorStatus2();
		 Boolean pushFatDoorStatus3=InformationPackageData.getPushFatDoorStatus3();
		 Boolean pushFatDoorStatus4=InformationPackageData.getPushFatDoorStatus4();
		 Integer pushFatPumpStatus=InformationPackageData.getPushFatPumpStatus();// 推肥泵状态
		 
		// System.out.println("设备操作模式:"+deviceOperatePattern+"   推肥状态:"+pushFatStatus+"   阀门1:"+pushFatDoorStatus1+"   阀门2:"+pushFatDoorStatus2+"   阀门3:"+pushFatDoorStatus3+"   阀门4:"+pushFatDoorStatus4+"  推肥泵状态:"+pushFatPumpStatus);
		 		 
		 
		Double	KPFatWeight=InformationPackageData.getKPFatWeight()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPFatWeight());  // 当前推K,P肥重量
		Double KPSecondFatWeight=InformationPackageData.getKPSecondFatWeight()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPSecondFatWeight());;// 当前推K,P副肥重量
		Double XSAFatWeight=InformationPackageData.getXSAFatWeight()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getXSAFatWeight());// 当前推硫酸铵肥重量
		Double KPFatGross=InformationPackageData.getKPFatGross()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPFatGross());// K,P肥总量
		Double KPSecondFatGross=InformationPackageData.getKPSecondFatGross()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPSecondFatGross());// K,P副肥总量	
		Double XSAFatGross=InformationPackageData.getXSAFatGross()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getXSAFatGross());// 硫酸铵肥总量
		Double KPFatLength=InformationPackageData.getKPFatLength()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPFatLength());// 当前推K,P(主)肥时长
		Double KPSecondFatLength=InformationPackageData.getKPSecondFatLength()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPSecondFatLength());// 当前推K,P(备)肥时长
		Double XSAFatLength=InformationPackageData.getXSAFatLength()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getXSAFatLength());//推硫酸铵肥时长
		//System.out.println("当前推K,P肥重量:"+KPFatWeight +"  当前推K,P副肥重量:"+ KPSecondFatWeight+"  当前推硫酸铵肥重量:"+XSAFatWeight +"  K,P肥总量:"+ KPFatGross+"   K,P副肥总量	:"+ KPSecondFatGross+"   硫酸铵肥总量:"+ XSAFatGross+"  当前推K,P(主)肥时长:"+KPFatLength +"   当前推K,P(备)肥时长:"+KPSecondFatLength+ "  推硫酸铵肥时长:"+ XSAFatLength);
		
		Double KPFatTotalLength=InformationPackageData.getKPFatTotalLength()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPFatTotalLength());// 当前推K,P(主)肥总时长
		Double KPSecondFatTotalLength=InformationPackageData.getKPSecondFatTotalLength()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPSecondFatTotalLength());// 当前推K,P(备)肥总时长
		Double XSAFatTotalLength=InformationPackageData.getXSAFatTotalLength()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getXSAFatTotalLength());//推硫酸铵肥总时长
		Double instantFlow=InformationPackageData.getInstantFlow()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getInstantFlow());// 当前瞬时流量
		Double pumpLaterPressure=InformationPackageData.getPumpLaterPressure()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getPumpLaterPressure());// 泵后压力
		//System.out.println("当前推K,P(主)肥总时长:"+ KPFatTotalLength+"   当前推K,P(备)肥总时长:"+KPSecondFatTotalLength +"  推硫酸铵肥总时长:"+XSAFatTotalLength +"  当前瞬时流量:"+instantFlow +"  泵后压力:"+ pumpLaterPressure);
		
		Double KPFatTanklevel=InformationPackageData.getKPFatTanklevel()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPFatTanklevel());// KP肥罐液位
		Double KPSecondFatTanklevel=InformationPackageData.getKPSecondFatTanklevel()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPSecondFatTanklevel());// KP副肥罐液位	
		Double XSAFatTanklevel=InformationPackageData.getXSAFatTanklevel()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getXSAFatTanklevel());// 硫酸铵肥罐液位
		Double KPFatWeightValue=InformationPackageData.getKPFatWeightValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPFatWeightValue());// 推P,K肥重量设定值
		Double KPSecondFatWeightValue=InformationPackageData.getKPSecondFatWeightValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPSecondFatWeightValue());// 推P,K副肥重量设定值	
		Double XSAFatWeightValue=InformationPackageData.getXSAFatWeightValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getXSAFatWeightValue());//  推硫酸铵肥重量设定值
		//System.out.println("KP肥罐液位:"+KPFatTanklevel +"  KP副肥罐液位:"+ KPSecondFatTanklevel+"  硫酸铵肥罐液位:"+ XSAFatTanklevel+"  推P,K肥重量设定值:"+ KPFatWeightValue+"  推P,K副肥重量设定值:"+ KPSecondFatWeightValue+"  推硫酸铵肥重量设定值:"+XSAFatWeightValue );
		
		Double KPFatCompensationValue=InformationPackageData.getKPFatCompensationValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPFatCompensationValue());//K,P(主)肥补偿设定值
		Double KPSecondFatCompensationValue=InformationPackageData.getKPSecondFatCompensationValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getKPSecondFatCompensationValue());//K,P(备)肥补偿设定值
		Double XSAFatCompensationValue=InformationPackageData.getXSAFatCompensationValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getXSAFatCompensationValue());//硫酸铵肥补偿设定值
		Double pumpLaterPressureLowValue=InformationPackageData.getPumpLaterPressureLowValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getPumpLaterPressureLowValue());// 泵后压力低设定值
		Double FlowLowValue=InformationPackageData.getFlowLowValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getFlowLowValue());// 流量低设定值
		Double pumpFrequencyValue=InformationPackageData.getPumpFrequencyValue()==null?null:(double)Float.intBitsToFloat(InformationPackageData.getPumpFrequencyValue()); //泵频率设定值
		//System.out.println("K,P(主)肥补偿设定值:"+KPFatCompensationValue +"  K,P(备)肥补偿设定值:"+KPSecondFatCompensationValue +"  硫酸铵肥补偿设定值:"+ XSAFatCompensationValue+" 泵后压力低设定值:"+ pumpLaterPressureLowValue+"  流量低设定值:"+ FlowLowValue+"  泵频率设定值:"+ pumpFrequencyValue);
		 
		Double  KPPushFatNumber=InformationPackageData.getKPPushFatNumber()==null?null:Double.valueOf(InformationPackageData.getKPPushFatNumber()); //K,P(主)肥推肥次数
		Double  KPSecondPushFatNumber=InformationPackageData.getKPSecondPushFatNumber()==null?null:Double.valueOf(InformationPackageData.getKPSecondPushFatNumber());  //K,P(备)肥推肥次数
		Double XSAPushFatNumber = InformationPackageData.getXSAPushFatNumber() == null?null:Double.valueOf(InformationPackageData.getXSAPushFatNumber().doubleValue());
        //System.out.println("K,P(主)肥推肥次数:"+KPPushFatNumber +"  K,P(备)肥推肥次数:"+KPSecondPushFatNumber +"  硫酸铵肥推肥次数:"+ XSAPushFatNumber);
		
		 TfEuipmetDataPo po = new TfEuipmetDataPo();
         po.setPk_equipment(pk_equipment);
         po.setDataTime(dataTime);
         po.setDeviceAlert(deviceAlert);
         po.setDeviceOperatePattern(deviceOperatePattern);
         po.setPushFatStatus(pushFatStatus);
         po.setPushFatDoorStatus1(Integer.valueOf(pushFatDoorStatus1.booleanValue()?1:0));
         po.setPushFatDoorStatus2(Integer.valueOf(pushFatDoorStatus2.booleanValue()?1:0));
         po.setPushFatDoorStatus3(Integer.valueOf(pushFatDoorStatus3.booleanValue()?1:0));
         po.setPushFatDoorStatus4(Integer.valueOf(pushFatDoorStatus4.booleanValue()?1:0));
         po.setPushFatPumpStatus(pushFatPumpStatus);
         po.setPushFatNumber(pushFatNumber);
         po.setKPFatWeight(KPFatWeight);
         po.setKPSecondFatWeight(KPSecondFatWeight);
         po.setXSAFatWeight(XSAFatWeight);
         po.setKPFatGross(KPFatGross);
         po.setKPSecondFatGross(KPSecondFatGross);
         po.setXSAFatGross(XSAFatGross);
         po.setKPFatLength(KPFatLength);
         po.setKPSecondFatLength(KPSecondFatLength);
         po.setXSAFatLength(XSAFatLength);
         po.setKPFatTotalLength(KPFatTotalLength);
         po.setKPSecondFatTotalLength(KPSecondFatTotalLength);
         po.setXSAFatTotalLength(XSAFatTotalLength);
         po.setInstantFlow(instantFlow);
         po.setPumpLaterPressure(pumpLaterPressure);
         po.setKPFatTanklevel(KPFatTanklevel);
         po.setKPSecondFatTanklevel(KPSecondFatTanklevel);
         po.setXSAFatTanklevel(XSAFatTanklevel);
         po.setKPFatWeightValue(KPFatWeightValue);
         po.setKPSecondFatWeightValue(KPSecondFatWeightValue);
         po.setXSAFatWeightValue(XSAFatWeightValue);
         po.setKPFatCompensationValue(KPFatCompensationValue);
         po.setKPSecondFatCompensationValue(KPSecondFatCompensationValue);
         po.setXSAFatCompensationValue(XSAFatCompensationValue);
         po.setPumpLaterPressureLowValue(pumpLaterPressureLowValue);
         po.setFlowLowValue(FlowLowValue);
         po.setPumpFrequencyValue(pumpFrequencyValue);
         po.setKPPushFatNumber(KPPushFatNumber);
         po.setKPSecondPushFatNumber(KPSecondPushFatNumber);
         po.setXSAPushFatNumber(XSAPushFatNumber);
         bll.addInfoTaDataNew(po);
	}

}
