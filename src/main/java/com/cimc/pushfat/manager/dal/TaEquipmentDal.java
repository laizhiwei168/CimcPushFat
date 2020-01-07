package com.cimc.pushfat.manager.dal;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.manager.common.DBBean;
import com.cimc.pushfat.manager.db.DBHandleHelper;
import com.cimc.pushfat.manager.po.TaDevicePo;
import com.cimc.pushfat.manager.po.TaEquipmentPo;

public class TaEquipmentDal {

	private DBHandleHelper DbHelper = new DBHandleHelper();


	   public List<Map<String, Object>> selectEquipmentById(String EQUIPMENT_ID) {
	      String SQLString = "SELECT a.*,b.imeiNo FROM ta_equipment a LEFT JOIN ta_device b  on a.pk_equipment=b.pk_equipment where b.imeiNo='" + EQUIPMENT_ID + "' and a.enablestate=1";
	      List<Map<String, Object>> ls_taTank = this.DbHelper.Query(DBBean.mysqldata, SQLString);
	      return ls_taTank;
	   }

	   public int AddDevice(TaDevicePo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_device (");
	      if(po.getPk_device() != null && !"".equals(po.getPk_device())) {
	         sql.append("pk_device");
	      }

	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append(",pk_equipment");
	      }

	      if(po.getPk_company() != null && !"".equals(po.getPk_company())) {
	         sql.append(",pk_company");
	      }

	      if(po.getDeviceNo() != null) {
	         sql.append(",deviceNo");
	      }

	      if(po.getImeiNo() != null) {
	         sql.append(",imeiNo");
	      }

	      if(po.getModelNoId() != null) {
	         sql.append(",modelNoId");
	      }

	      if(po.getCardId() != null) {
	         sql.append(",cardId");
	      }

	      if(po.getProtocolId() != null) {
	         sql.append(",protocolId");
	      }

	      if(po.getCreator() != null) {
	         sql.append(",creator");
	      }

	      if(po.getCreatortime() != null) {
	         sql.append(",creatortime");
	      }

	      if(po.getModifier() != null) {
	         sql.append(",modifier");
	      }

	      if(po.getModifiedtime() != null) {
	         sql.append(",modifiedtime");
	      }

	      sql.append(") values(");
	      if(po.getPk_device() != null && !"".equals(po.getPk_device())) {
	         sql.append("'" + po.getPk_device() + "'");
	      }

	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append(",'" + po.getPk_equipment() + "'");
	      }

	      if(po.getPk_company() != null && !"".equals(po.getPk_company())) {
	         sql.append(",'" + po.getPk_company() + "'");
	      }

	      if(po.getDeviceNo() != null) {
	         sql.append(",'" + po.getDeviceNo() + "'");
	      }

	      if(po.getImeiNo() != null) {
	         sql.append(",'" + po.getImeiNo() + "'");
	      }

	      if(po.getModelNoId() != null) {
	         sql.append(",'" + po.getModelNoId() + "'");
	      }

	      if(po.getCardId() != null) {
	         sql.append(",'" + po.getCardId() + "'");
	      }

	      if(po.getProtocolId() != null) {
	         sql.append(",'" + po.getProtocolId() + "'");
	      }

	      if(po.getCreator() != null) {
	         sql.append(",'" + po.getCreator() + "'");
	      }

	      if(po.getCreatortime() != null) {
	         sql.append(",'" + po.getCreatortime() + "'");
	      }

	      if(po.getModifier() != null) {
	         sql.append(",'" + po.getModifier() + "'");
	      }

	      if(po.getModifiedtime() != null) {
	         sql.append(",'" + po.getModifiedtime() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }

	   public int AddEquipment(TaEquipmentPo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_equipment (");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("pk_equipment");
	      }

	      if(po.getPk_company() != null && !"".equals(po.getPk_company())) {
	         sql.append(",pk_company");
	      }

	      if(po.getEquipmentNo() != null) {
	         sql.append(",equipmentNo");
	      }

	      if(po.getEquipmentType() != null) {
	         sql.append(",equipmentType");
	      }

	      if(po.getCreator() != null) {
	         sql.append(",creator");
	      }

	      if(po.getCreatortime() != null) {
	         sql.append(",creatortime");
	      }

	      if(po.getModifier() != null) {
	         sql.append(",modifier");
	      }

	      if(po.getModifiedtime() != null) {
	         sql.append(",modifiedtime");
	      }

	      sql.append(") values(");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("'" + po.getPk_equipment() + "'");
	      }

	      if(po.getPk_company() != null && !"".equals(po.getPk_company())) {
	         sql.append(",'" + po.getPk_company() + "'");
	      }

	      if(po.getEquipmentNo() != null) {
	         sql.append(",'" + po.getEquipmentNo() + "'");
	      }

	      if(po.getEquipmentType() != null) {
	         sql.append(",'" + po.getEquipmentType() + "'");
	      }

	      if(po.getCreator() != null) {
	         sql.append(",'" + po.getCreator() + "'");
	      }

	      if(po.getCreatortime() != null) {
	         sql.append(",'" + po.getCreatortime() + "'");
	      }

	      if(po.getModifier() != null) {
	         sql.append(",'" + po.getModifier() + "'");
	      }

	      if(po.getModifiedtime() != null) {
	         sql.append(",'" + po.getModifiedtime() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }
}
