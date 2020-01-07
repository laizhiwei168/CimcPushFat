package com.cimc.pushfat.manager.dal;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.manager.common.DBBean;
import com.cimc.pushfat.manager.db.DBHandleHelper;
import com.cimc.pushfat.manager.po.TaLocationDataPo;

public class TaLocationDataDal {

	private DBHandleHelper DbHelper = new DBHandleHelper();


	   public List<Map<String, Object>> selectTaLocationDataByID(String pk_equipmet) {
	      String SQLString = "SELECT *  FROM ta_location_data_new WHERE pk_equipment='" + pk_equipmet + "'";
	      List<Map<String, Object>> ls_taData = this.DbHelper.Query(DBBean.mysqldata, SQLString);
	      return ls_taData;
	   }

	   public int AddTaLocationDataNew(TaLocationDataPo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_location_data_new (");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("pk_equipment");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",dataTime");
	      }

	      if(po.getIs_position() != null) {
	         sql.append(",is_position");
	      }

	      if(po.getPositiontype() != null) {
	         sql.append(",positiontype");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",longitude");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",latitude");
	      }

	      if(po.getR_longitude() != null) {
	         sql.append(",r_longitude");
	      }

	      if(po.getR_latitude() != null) {
	         sql.append(",r_latitude");
	      }

	      if(po.getSpeed() != null) {
	         sql.append(",speed");
	      }

	      if(po.getDirection() != null) {
	         sql.append(",direction");
	      }

	      if(po.getLocation() != null) {
	         sql.append(",location");
	      }

	      sql.append(") values(");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("'" + po.getPk_equipment() + "'");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",'" + po.getDataTime() + "'");
	      }

	      if(po.getIs_position() != null) {
	         sql.append(",'" + po.getIs_position() + "'");
	      }

	      if(po.getPositiontype() != null) {
	         sql.append(",'" + po.getPositiontype() + "'");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",'" + po.getLongitude() + "'");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",'" + po.getLatitude() + "'");
	      }

	      if(po.getR_longitude() != null) {
	         sql.append(",'" + po.getR_longitude() + "'");
	      }

	      if(po.getR_latitude() != null) {
	         sql.append(",'" + po.getR_latitude() + "'");
	      }

	      if(po.getSpeed() != null) {
	         sql.append(",'" + po.getSpeed() + "'");
	      }

	      if(po.getDirection() != null) {
	         sql.append(",'" + po.getDirection() + "'");
	      }

	      if(po.getLocation() != null) {
	         sql.append(",'" + po.getLocation() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }

	   public int updateTaLocationDataNew(TaLocationDataPo po) {
	      StringBuilder sql = new StringBuilder("update ta_tf_equipmet_data_new set ");
	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append("dataTime='" + po.getDataTime() + "'");
	      }

	      if(po.getIs_position() != null) {
	         sql.append(",is_position='" + po.getIs_position() + "'");
	      }

	      if(po.getPositiontype() != null) {
	         sql.append(",positiontype='" + po.getPositiontype() + "'");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",longitude='" + po.getLongitude() + "'");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",latitude='" + po.getLatitude() + "'");
	      }

	      if(po.getR_longitude() != null) {
	         sql.append(",r_longitude='" + po.getR_longitude() + "'");
	      }

	      if(po.getR_latitude() != null) {
	         sql.append(",r_latitude='" + po.getR_latitude() + "'");
	      }

	      if(po.getSpeed() != null) {
	         sql.append(",speed='" + po.getSpeed() + "'");
	      }

	      if(po.getDirection() != null) {
	         sql.append(",direction='" + po.getDirection() + "'");
	      }

	      if(po.getLocation() != null) {
	         sql.append(",location='" + po.getLocation() + "'");
	      }

	      sql.append(" where pk_equipment='" + po.getPk_equipment() + "'");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }

	   public int AddTaLocationData(TaLocationDataPo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_location_data (");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("pk_equipment");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",dataTime");
	      }

	      if(po.getIs_position() != null) {
	         sql.append(",is_position");
	      }

	      if(po.getPositiontype() != null) {
	         sql.append(",positiontype");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",longitude");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",latitude");
	      }

	      if(po.getR_longitude() != null) {
	         sql.append(",r_longitude");
	      }

	      if(po.getR_latitude() != null) {
	         sql.append(",r_latitude");
	      }

	      if(po.getSpeed() != null) {
	         sql.append(",speed");
	      }

	      if(po.getDirection() != null) {
	         sql.append(",direction");
	      }

	      if(po.getLocation() != null) {
	         sql.append(",location");
	      }

	      sql.append(") values(");
	      if(po.getPk_equipment() != null && !"".equals(po.getPk_equipment())) {
	         sql.append("'" + po.getPk_equipment() + "'");
	      }

	      if(po.getDataTime() != null && !"".equals(po.getDataTime())) {
	         sql.append(",'" + po.getDataTime() + "'");
	      }

	      if(po.getIs_position() != null) {
	         sql.append(",'" + po.getIs_position() + "'");
	      }

	      if(po.getPositiontype() != null) {
	         sql.append(",'" + po.getPositiontype() + "'");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",'" + po.getLongitude() + "'");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",'" + po.getLatitude() + "'");
	      }

	      if(po.getR_longitude() != null) {
	         sql.append(",'" + po.getR_longitude() + "'");
	      }

	      if(po.getR_latitude() != null) {
	         sql.append(",'" + po.getR_latitude() + "'");
	      }

	      if(po.getSpeed() != null) {
	         sql.append(",'" + po.getSpeed() + "'");
	      }

	      if(po.getDirection() != null) {
	         sql.append(",'" + po.getDirection() + "'");
	      }

	      if(po.getLocation() != null) {
	         sql.append(",'" + po.getLocation() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }
}
