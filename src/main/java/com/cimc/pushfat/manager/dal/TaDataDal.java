package com.cimc.pushfat.manager.dal;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.manager.common.DBBean;
import com.cimc.pushfat.manager.db.DBHandleHelper;
import com.cimc.pushfat.manager.po.TfEuipmetDataPo;

public class TaDataDal {

	 private DBHandleHelper DbHelper = new DBHandleHelper();


	   public List<Map<String, Object>> selectEquipmentById(String EQUIPMENT_ID) {
	      String SQLString = "SELECT a.*,b.imeiNo FROM ta_equipment a LEFT JOIN ta_device b  on a.pk_equipment=b.pk_equipment where b.imeiNo='" + EQUIPMENT_ID + "' and a.enablestate=1";
	      List<Map<String, Object>> ls_taTank = this.DbHelper.Query(DBBean.mysqldata, SQLString);
	      return ls_taTank;
	   }

	   public List<Map<String, Object>> selectTaDataByID(String pk_equipmet) {
	      String SQLString = "SELECT *  FROM ta_tf_equipmet_data_new WHERE pk_equipment='" + pk_equipmet + "'";
	      List<Map<String, Object>> ls_taData = this.DbHelper.Query(DBBean.mysqldata, SQLString);
	      return ls_taData;
	   }

	   public int AddTaDataNew(TfEuipmetDataPo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_tf_equipmet_data_new (");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("pk_equipment");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",dataTime");
	      }

	      if(po.getDeviceAlert() != null) {
	         sql.append(",deviceAlert");
	      }

	      if(po.getDeviceOperatePattern() != null) {
	         sql.append(",deviceOperatePattern");
	      }

	      if(po.getPushFatStatus() != null) {
	         sql.append(",pushFatStatus");
	      }

	      if(po.getPushFatDoorStatus1() != null) {
	         sql.append(",pushFatDoorStatus1");
	      }

	      if(po.getPushFatDoorStatus2() != null) {
	         sql.append(",pushFatDoorStatus2");
	      }

	      if(po.getPushFatDoorStatus3() != null) {
	         sql.append(",pushFatDoorStatus3");
	      }

	      if(po.getPushFatDoorStatus4() != null) {
	         sql.append(",pushFatDoorStatus4");
	      }

	      if(po.getPushFatPumpStatus() != null) {
	         sql.append(",pushFatPumpStatus");
	      }

	      if(po.getPushFatNumber() != null) {
	         sql.append(",pushFatNumber");
	      }

	      if(po.getKPFatWeight() != null) {
	         sql.append(",KPFatWeight");
	      }

	      if(po.getKPSecondFatWeight() != null) {
	         sql.append(",KPSecondFatWeight");
	      }

	      if(po.getXSAFatWeight() != null) {
	         sql.append(",XSAFatWeight");
	      }

	      if(po.getKPFatGross() != null) {
	         sql.append(",KPFatGross");
	      }

	      if(po.getKPSecondFatGross() != null) {
	         sql.append(",KPSecondFatGross");
	      }

	      if(po.getXSAFatGross() != null) {
	         sql.append(",XSAFatGross");
	      }

	      if(po.getKPFatLength() != null) {
	         sql.append(",KPFatLength");
	      }

	      if(po.getKPSecondFatLength() != null) {
	         sql.append(",KPSecondFatLength");
	      }

	      if(po.getXSAFatLength() != null) {
	         sql.append(",XSAFatLength");
	      }

	      if(po.getKPFatTotalLength() != null) {
	         sql.append(",KPFatTotalLength");
	      }

	      if(po.getKPSecondFatTotalLength() != null) {
	         sql.append(",KPSecondFatTotalLength");
	      }

	      if(po.getXSAFatTotalLength() != null) {
	         sql.append(",XSAFatTotalLength");
	      }

	      if(po.getInstantFlow() != null) {
	         sql.append(",instantFlow");
	      }

	      if(po.getPumpLaterPressure() != null) {
	         sql.append(",pumpLaterPressure");
	      }

	      if(po.getKPFatTanklevel() != null) {
	         sql.append(",KPFatTanklevel");
	      }

	      if(po.getKPSecondFatTanklevel() != null) {
	         sql.append(",KPSecondFatTanklevel");
	      }

	      if(po.getXSAFatTanklevel() != null) {
	         sql.append(",XSAFatTanklevel");
	      }

	      if(po.getKPFatWeightValue() != null) {
	         sql.append(",KPFatWeightValue");
	      }

	      if(po.getKPSecondFatWeightValue() != null) {
	         sql.append(",KPSecondFatWeightValue");
	      }

	      if(po.getXSAFatWeightValue() != null) {
	         sql.append(",XSAFatWeightValue");
	      }

	      if(po.getKPFatCompensationValue() != null) {
	         sql.append(",KPFatCompensationValue");
	      }

	      if(po.getKPSecondFatCompensationValue() != null) {
	         sql.append(",KPSecondFatCompensationValue");
	      }

	      if(po.getXSAFatCompensationValue() != null) {
	         sql.append(",XSAFatCompensationValue");
	      }

	      if(po.getPumpLaterPressureLowValue() != null) {
	         sql.append(",pumpLaterPressureLowValue");
	      }

	      if(po.getFlowLowValue() != null) {
	         sql.append(",FlowLowValue");
	      }

	      if(po.getPumpFrequencyValue() != null) {
	         sql.append(",pumpFrequencyValue");
	      }

	      if(po.getKPPushFatNumber() != null) {
	         sql.append(",KPPushFatNumber");
	      }

	      if(po.getKPSecondPushFatNumber() != null) {
	         sql.append(",KPSecondPushFatNumber");
	      }

	      if(po.getXSAPushFatNumber() != null) {
	         sql.append(",XSAPushFatNumber");
	      }

	      sql.append(") values(");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("'" + po.getPk_equipment() + "'");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",'" + po.getDataTime() + "'");
	      }

	      if(po.getDeviceAlert() != null) {
	         sql.append(",'" + po.getDeviceAlert() + "'");
	      }

	      if(po.getDeviceOperatePattern() != null) {
	         sql.append(",'" + po.getDeviceOperatePattern() + "'");
	      }

	      if(po.getPushFatStatus() != null) {
	         sql.append(",'" + po.getPushFatStatus() + "'");
	      }

	      if(po.getPushFatDoorStatus1() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus1() + "'");
	      }

	      if(po.getPushFatDoorStatus2() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus2() + "'");
	      }

	      if(po.getPushFatDoorStatus3() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus3() + "'");
	      }

	      if(po.getPushFatDoorStatus4() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus4() + "'");
	      }

	      if(po.getPushFatPumpStatus() != null) {
	         sql.append(",'" + po.getPushFatPumpStatus() + "'");
	      }

	      if(po.getPushFatNumber() != null) {
	         sql.append(",'" + po.getPushFatNumber() + "'");
	      }

	      if(po.getKPFatWeight() != null) {
	         sql.append(",'" + po.getKPFatWeight() + "'");
	      }

	      if(po.getKPSecondFatWeight() != null) {
	         sql.append(",'" + po.getKPSecondFatWeight() + "'");
	      }

	      if(po.getXSAFatWeight() != null) {
	         sql.append(",'" + po.getXSAFatWeight() + "'");
	      }

	      if(po.getKPFatGross() != null) {
	         sql.append(",'" + po.getKPFatGross() + "'");
	      }

	      if(po.getKPSecondFatGross() != null) {
	         sql.append(",'" + po.getKPSecondFatGross() + "'");
	      }

	      if(po.getXSAFatGross() != null) {
	         sql.append(",'" + po.getXSAFatGross() + "'");
	      }

	      if(po.getKPFatLength() != null) {
	         sql.append(",'" + po.getKPFatLength() + "'");
	      }

	      if(po.getKPSecondFatLength() != null) {
	         sql.append(",'" + po.getKPSecondFatLength() + "'");
	      }

	      if(po.getXSAFatLength() != null) {
	         sql.append(",'" + po.getXSAFatLength() + "'");
	      }

	      if(po.getKPFatTotalLength() != null) {
	         sql.append(",'" + po.getKPFatTotalLength() + "'");
	      }

	      if(po.getKPSecondFatTotalLength() != null) {
	         sql.append(",'" + po.getKPSecondFatTotalLength() + "'");
	      }

	      if(po.getXSAFatTotalLength() != null) {
	         sql.append(",'" + po.getXSAFatTotalLength() + "'");
	      }

	      if(po.getInstantFlow() != null) {
	         sql.append(",'" + po.getInstantFlow() + "'");
	      }

	      if(po.getPumpLaterPressure() != null) {
	         sql.append(",'" + po.getPumpLaterPressure() + "'");
	      }

	      if(po.getKPFatTanklevel() != null) {
	         sql.append(",'" + po.getKPFatTanklevel() + "'");
	      }

	      if(po.getKPSecondFatTanklevel() != null) {
	         sql.append(",'" + po.getKPSecondFatTanklevel() + "'");
	      }

	      if(po.getXSAFatTanklevel() != null) {
	         sql.append(",'" + po.getXSAFatTanklevel() + "'");
	      }

	      if(po.getKPFatWeightValue() != null) {
	         sql.append(",'" + po.getKPFatWeightValue() + "'");
	      }

	      if(po.getKPSecondFatWeightValue() != null) {
	         sql.append(",'" + po.getKPSecondFatWeightValue() + "'");
	      }

	      if(po.getXSAFatWeightValue() != null) {
	         sql.append(",'" + po.getXSAFatWeightValue() + "'");
	      }

	      if(po.getKPFatCompensationValue() != null) {
	         sql.append(",'" + po.getKPFatCompensationValue() + "'");
	      }

	      if(po.getKPSecondFatCompensationValue() != null) {
	         sql.append(",'" + po.getKPSecondFatCompensationValue() + "'");
	      }

	      if(po.getXSAFatCompensationValue() != null) {
	         sql.append(",'" + po.getXSAFatCompensationValue() + "'");
	      }

	      if(po.getPumpLaterPressureLowValue() != null) {
	         sql.append(",'" + po.getPumpLaterPressureLowValue() + "'");
	      }

	      if(po.getFlowLowValue() != null) {
	         sql.append(",'" + po.getFlowLowValue() + "'");
	      }

	      if(po.getPumpFrequencyValue() != null) {
	         sql.append(",'" + po.getPumpFrequencyValue() + "'");
	      }

	      if(po.getKPPushFatNumber() != null) {
	         sql.append(",'" + po.getKPPushFatNumber() + "'");
	      }

	      if(po.getKPSecondPushFatNumber() != null) {
	         sql.append(",'" + po.getKPSecondPushFatNumber() + "'");
	      }

	      if(po.getXSAPushFatNumber() != null) {
	         sql.append(",'" + po.getXSAPushFatNumber() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }

	   public int updateTaDataNew(TfEuipmetDataPo po) {
	      StringBuilder sql = new StringBuilder("update ta_tf_equipmet_data_new set ");
	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append("dataTime='" + po.getDataTime() + "'");
	      }

	      if(po.getDeviceAlert() != null) {
	         sql.append(",deviceAlert='" + po.getDeviceAlert() + "'");
	      }

	      if(po.getDeviceOperatePattern() != null) {
	         sql.append(",deviceOperatePattern='" + po.getDeviceOperatePattern() + "'");
	      }

	      if(po.getPushFatStatus() != null) {
	         sql.append(",pushFatStatus='" + po.getPushFatStatus() + "'");
	      }

	      if(po.getPushFatDoorStatus1() != null) {
	         sql.append(",pushFatDoorStatus1='" + po.getPushFatDoorStatus1() + "'");
	      }

	      if(po.getPushFatDoorStatus2() != null) {
	         sql.append(",pushFatDoorStatus2='" + po.getPushFatDoorStatus2() + "'");
	      }

	      if(po.getPushFatDoorStatus3() != null) {
	         sql.append(",pushFatDoorStatus3='" + po.getPushFatDoorStatus3() + "'");
	      }

	      if(po.getPushFatDoorStatus4() != null) {
	         sql.append(",pushFatDoorStatus4='" + po.getPushFatDoorStatus4() + "'");
	      }

	      if(po.getPushFatPumpStatus() != null) {
	         sql.append(",pushFatPumpStatus='" + po.getPushFatPumpStatus() + "'");
	      }

	      if(po.getPushFatNumber() != null) {
	         sql.append(",pushFatNumber='" + po.getPushFatNumber() + "'");
	      }

	      if(po.getKPFatWeight() != null) {
	         sql.append(",KPFatWeight='" + po.getKPFatWeight() + "'");
	      }

	      if(po.getKPSecondFatWeight() != null) {
	         sql.append(",KPSecondFatWeight='" + po.getKPSecondFatWeight() + "'");
	      }

	      if(po.getXSAFatWeight() != null) {
	         sql.append(",XSAFatWeight='" + po.getXSAFatWeight() + "'");
	      }

	      if(po.getKPFatGross() != null) {
	         sql.append(",KPFatGross='" + po.getKPFatGross() + "'");
	      }

	      if(po.getKPSecondFatGross() != null) {
	         sql.append(",KPSecondFatGross='" + po.getKPSecondFatGross() + "'");
	      }

	      if(po.getXSAFatGross() != null) {
	         sql.append(",XSAFatGross='" + po.getXSAFatGross() + "'");
	      }

	      if(po.getKPFatLength() != null) {
	         sql.append(",KPFatLength='" + po.getKPFatLength() + "'");
	      }

	      if(po.getKPSecondFatLength() != null) {
	         sql.append(",KPSecondFatLength='" + po.getKPSecondFatLength() + "'");
	      }

	      if(po.getXSAFatLength() != null) {
	         sql.append(",XSAFatLength='" + po.getXSAFatLength() + "'");
	      }

	      if(po.getKPFatTotalLength() != null) {
	         sql.append(",KPFatTotalLength='" + po.getKPFatTotalLength() + "'");
	      }

	      if(po.getKPSecondFatTotalLength() != null) {
	         sql.append(",KPSecondFatTotalLength='" + po.getKPSecondFatTotalLength() + "'");
	      }

	      if(po.getXSAFatTotalLength() != null) {
	         sql.append(",XSAFatTotalLength='" + po.getXSAFatTotalLength() + "'");
	      }

	      if(po.getInstantFlow() != null) {
	         sql.append(",instantFlow='" + po.getInstantFlow() + "'");
	      }

	      if(po.getPumpLaterPressure() != null) {
	         sql.append(",pumpLaterPressure='" + po.getPumpLaterPressure() + "'");
	      }

	      if(po.getKPFatTanklevel() != null) {
	         sql.append(",KPFatTanklevel='" + po.getKPFatTanklevel() + "'");
	      }

	      if(po.getKPSecondFatTanklevel() != null) {
	         sql.append(",KPSecondFatTanklevel='" + po.getKPSecondFatTanklevel() + "'");
	      }

	      if(po.getXSAFatTanklevel() != null) {
	         sql.append(",XSAFatTanklevel='" + po.getXSAFatTanklevel() + "'");
	      }

	      if(po.getKPFatWeightValue() != null) {
	         sql.append(",KPFatWeightValue='" + po.getKPFatWeightValue() + "'");
	      }

	      if(po.getKPSecondFatWeightValue() != null) {
	         sql.append(",KPSecondFatWeightValue='" + po.getKPSecondFatWeightValue() + "'");
	      }

	      if(po.getXSAFatWeightValue() != null) {
	         sql.append(",XSAFatWeightValue='" + po.getXSAFatWeightValue() + "'");
	      }

	      if(po.getKPFatCompensationValue() != null) {
	         sql.append(",KPFatCompensationValue='" + po.getKPFatCompensationValue() + "'");
	      }

	      if(po.getKPSecondFatCompensationValue() != null) {
	         sql.append(",KPSecondFatCompensationValue='" + po.getKPSecondFatCompensationValue() + "'");
	      }

	      if(po.getXSAFatCompensationValue() != null) {
	         sql.append(",XSAFatCompensationValue='" + po.getXSAFatCompensationValue() + "'");
	      }

	      if(po.getPumpLaterPressureLowValue() != null) {
	         sql.append(",pumpLaterPressureLowValue='" + po.getPumpLaterPressureLowValue() + "'");
	      }

	      if(po.getFlowLowValue() != null) {
	         sql.append(",FlowLowValue='" + po.getFlowLowValue() + "'");
	      }

	      if(po.getPumpFrequencyValue() != null) {
	         sql.append(",pumpFrequencyValue='" + po.getPumpFrequencyValue() + "'");
	      }

	      if(po.getKPPushFatNumber() != null) {
	         sql.append(",KPPushFatNumber='" + po.getKPPushFatNumber() + "'");
	      }

	      if(po.getKPSecondPushFatNumber() != null) {
	         sql.append(",KPSecondPushFatNumber='" + po.getKPSecondPushFatNumber() + "'");
	      }

	      if(po.getXSAPushFatNumber() != null) {
	         sql.append(",XSAPushFatNumber='" + po.getXSAPushFatNumber() + "'");
	      }

	      sql.append(" where pk_equipment='" + po.getPk_equipment() + "'");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }

	   public int AddTaData(TfEuipmetDataPo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_tf_equipmet_data (");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("pk_equipment");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",dataTime");
	      }

	      if(po.getDeviceAlert() != null) {
	         sql.append(",deviceAlert");
	      }

	      if(po.getDeviceOperatePattern() != null) {
	         sql.append(",deviceOperatePattern");
	      }

	      if(po.getPushFatStatus() != null) {
	         sql.append(",pushFatStatus");
	      }

	      if(po.getPushFatDoorStatus1() != null) {
	         sql.append(",pushFatDoorStatus1");
	      }

	      if(po.getPushFatDoorStatus2() != null) {
	         sql.append(",pushFatDoorStatus2");
	      }

	      if(po.getPushFatDoorStatus3() != null) {
	         sql.append(",pushFatDoorStatus3");
	      }

	      if(po.getPushFatDoorStatus4() != null) {
	         sql.append(",pushFatDoorStatus4");
	      }

	      if(po.getPushFatPumpStatus() != null) {
	         sql.append(",pushFatPumpStatus");
	      }

	      if(po.getPushFatNumber() != null) {
	         sql.append(",pushFatNumber");
	      }

	      if(po.getKPFatWeight() != null) {
	         sql.append(",KPFatWeight");
	      }

	      if(po.getKPSecondFatWeight() != null) {
	         sql.append(",KPSecondFatWeight");
	      }

	      if(po.getXSAFatWeight() != null) {
	         sql.append(",XSAFatWeight");
	      }

	      if(po.getKPFatGross() != null) {
	         sql.append(",KPFatGross");
	      }

	      if(po.getKPSecondFatGross() != null) {
	         sql.append(",KPSecondFatGross");
	      }

	      if(po.getXSAFatGross() != null) {
	         sql.append(",XSAFatGross");
	      }

	      if(po.getKPFatLength() != null) {
	         sql.append(",KPFatLength");
	      }

	      if(po.getKPSecondFatLength() != null) {
	         sql.append(",KPSecondFatLength");
	      }

	      if(po.getXSAFatLength() != null) {
	         sql.append(",XSAFatLength");
	      }

	      if(po.getKPFatTotalLength() != null) {
	         sql.append(",KPFatTotalLength");
	      }

	      if(po.getKPSecondFatTotalLength() != null) {
	         sql.append(",KPSecondFatTotalLength");
	      }

	      if(po.getXSAFatTotalLength() != null) {
	         sql.append(",XSAFatTotalLength");
	      }

	      if(po.getInstantFlow() != null) {
	         sql.append(",instantFlow");
	      }

	      if(po.getPumpLaterPressure() != null) {
	         sql.append(",pumpLaterPressure");
	      }

	      if(po.getKPFatTanklevel() != null) {
	         sql.append(",KPFatTanklevel");
	      }

	      if(po.getKPSecondFatTanklevel() != null) {
	         sql.append(",KPSecondFatTanklevel");
	      }

	      if(po.getXSAFatTanklevel() != null) {
	         sql.append(",XSAFatTanklevel");
	      }

	      if(po.getKPFatWeightValue() != null) {
	         sql.append(",KPFatWeightValue");
	      }

	      if(po.getKPSecondFatWeightValue() != null) {
	         sql.append(",KPSecondFatWeightValue");
	      }

	      if(po.getXSAFatWeightValue() != null) {
	         sql.append(",XSAFatWeightValue");
	      }

	      if(po.getKPFatCompensationValue() != null) {
	         sql.append(",KPFatCompensationValue");
	      }

	      if(po.getKPSecondFatCompensationValue() != null) {
	         sql.append(",KPSecondFatCompensationValue");
	      }

	      if(po.getXSAFatCompensationValue() != null) {
	         sql.append(",XSAFatCompensationValue");
	      }

	      if(po.getPumpLaterPressureLowValue() != null) {
	         sql.append(",pumpLaterPressureLowValue");
	      }

	      if(po.getFlowLowValue() != null) {
	         sql.append(",FlowLowValue");
	      }

	      if(po.getPumpFrequencyValue() != null) {
	         sql.append(",pumpFrequencyValue");
	      }

	      if(po.getKPPushFatNumber() != null) {
	         sql.append(",KPPushFatNumber");
	      }

	      if(po.getKPSecondPushFatNumber() != null) {
	         sql.append(",KPSecondPushFatNumber");
	      }

	      if(po.getXSAPushFatNumber() != null) {
	         sql.append(",XSAPushFatNumber");
	      }

	      sql.append(") values(");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("'" + po.getPk_equipment() + "'");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",'" + po.getDataTime() + "'");
	      }

	      if(po.getDeviceAlert() != null) {
	         sql.append(",'" + po.getDeviceAlert() + "'");
	      }

	      if(po.getDeviceOperatePattern() != null) {
	         sql.append(",'" + po.getDeviceOperatePattern() + "'");
	      }

	      if(po.getPushFatStatus() != null) {
	         sql.append(",'" + po.getPushFatStatus() + "'");
	      }

	      if(po.getPushFatDoorStatus1() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus1() + "'");
	      }

	      if(po.getPushFatDoorStatus2() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus2() + "'");
	      }

	      if(po.getPushFatDoorStatus3() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus3() + "'");
	      }

	      if(po.getPushFatDoorStatus4() != null) {
	         sql.append(",'" + po.getPushFatDoorStatus4() + "'");
	      }

	      if(po.getPushFatPumpStatus() != null) {
	         sql.append(",'" + po.getPushFatPumpStatus() + "'");
	      }

	      if(po.getPushFatNumber() != null) {
	         sql.append(",'" + po.getPushFatNumber() + "'");
	      }

	      if(po.getKPFatWeight() != null) {
	         sql.append(",'" + po.getKPFatWeight() + "'");
	      }

	      if(po.getKPSecondFatWeight() != null) {
	         sql.append(",'" + po.getKPSecondFatWeight() + "'");
	      }

	      if(po.getXSAFatWeight() != null) {
	         sql.append(",'" + po.getXSAFatWeight() + "'");
	      }

	      if(po.getKPFatGross() != null) {
	         sql.append(",'" + po.getKPFatGross() + "'");
	      }

	      if(po.getKPSecondFatGross() != null) {
	         sql.append(",'" + po.getKPSecondFatGross() + "'");
	      }

	      if(po.getXSAFatGross() != null) {
	         sql.append(",'" + po.getXSAFatGross() + "'");
	      }

	      if(po.getKPFatLength() != null) {
	         sql.append(",'" + po.getKPFatLength() + "'");
	      }

	      if(po.getKPSecondFatLength() != null) {
	         sql.append(",'" + po.getKPSecondFatLength() + "'");
	      }

	      if(po.getXSAFatLength() != null) {
	         sql.append(",'" + po.getXSAFatLength() + "'");
	      }

	      if(po.getKPFatTotalLength() != null) {
	         sql.append(",'" + po.getKPFatTotalLength() + "'");
	      }

	      if(po.getKPSecondFatTotalLength() != null) {
	         sql.append(",'" + po.getKPSecondFatTotalLength() + "'");
	      }

	      if(po.getXSAFatTotalLength() != null) {
	         sql.append(",'" + po.getXSAFatTotalLength() + "'");
	      }

	      if(po.getInstantFlow() != null) {
	         sql.append(",'" + po.getInstantFlow() + "'");
	      }

	      if(po.getPumpLaterPressure() != null) {
	         sql.append(",'" + po.getPumpLaterPressure() + "'");
	      }

	      if(po.getKPFatTanklevel() != null) {
	         sql.append(",'" + po.getKPFatTanklevel() + "'");
	      }

	      if(po.getKPSecondFatTanklevel() != null) {
	         sql.append(",'" + po.getKPSecondFatTanklevel() + "'");
	      }

	      if(po.getXSAFatTanklevel() != null) {
	         sql.append(",'" + po.getXSAFatTanklevel() + "'");
	      }

	      if(po.getKPFatWeightValue() != null) {
	         sql.append(",'" + po.getKPFatWeightValue() + "'");
	      }

	      if(po.getKPSecondFatWeightValue() != null) {
	         sql.append(",'" + po.getKPSecondFatWeightValue() + "'");
	      }

	      if(po.getXSAFatWeightValue() != null) {
	         sql.append(",'" + po.getXSAFatWeightValue() + "'");
	      }

	      if(po.getKPFatCompensationValue() != null) {
	         sql.append(",'" + po.getKPFatCompensationValue() + "'");
	      }

	      if(po.getKPSecondFatCompensationValue() != null) {
	         sql.append(",'" + po.getKPSecondFatCompensationValue() + "'");
	      }

	      if(po.getXSAFatCompensationValue() != null) {
	         sql.append(",'" + po.getXSAFatCompensationValue() + "'");
	      }

	      if(po.getPumpLaterPressureLowValue() != null) {
	         sql.append(",'" + po.getPumpLaterPressureLowValue() + "'");
	      }

	      if(po.getFlowLowValue() != null) {
	         sql.append(",'" + po.getFlowLowValue() + "'");
	      }

	      if(po.getPumpFrequencyValue() != null) {
	         sql.append(",'" + po.getPumpFrequencyValue() + "'");
	      }

	      if(po.getKPPushFatNumber() != null) {
	         sql.append(",'" + po.getKPPushFatNumber() + "'");
	      }

	      if(po.getKPSecondPushFatNumber() != null) {
	         sql.append(",'" + po.getKPSecondPushFatNumber() + "'");
	      }

	      if(po.getXSAPushFatNumber() != null) {
	         sql.append(",'" + po.getXSAPushFatNumber() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }
}
