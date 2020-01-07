package com.cimc.pushfat.manager.dal;

import com.cimc.pushfat.manager.common.DBBean;
import com.cimc.pushfat.manager.db.DBHandleHelper;
import com.cimc.pushfat.manager.po.TaLandYieldPo;

public class TaLandYieldDal {

	private DBHandleHelper DbHelper = new DBHandleHelper();
	
	public int AddTaLandYieldNew(TaLandYieldPo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_land_yield_new (");
	      if(po.getPkLand() != null && !"".equals(po.getPkLand())) {
	         sql.append("pk_land");
	      }

	      if(po.getDatatime() != null && !"".equals(po.getDatatime())) {
	         sql.append(",datatime");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",longitude");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",latitude");
	      }

	      if(po.getYield() != null) {
	         sql.append(",yield");
	      }	 
	      //---------
	      if(po.getWeight() != null) {
		         sql.append(",weight");
		      }	
	      if(po.getDemarcate1() != null) {
		         sql.append(",demarcate1");
		      }
	      if(po.getDemarcate2() != null) {
		         sql.append(",demarcate2");
		      }
	      if(po.getSimulationValue() != null) {
		         sql.append(",simulationValue");
		      }
	      if(po.getLandType() != null) {
		         sql.append(",landType");
		      }

	      sql.append(") values(");
	      
	      if(po.getPkLand() != null && !"".equals(po.getPkLand())) {
	         sql.append("'" + po.getPkLand() + "'");
	      }

	      if(po.getDatatime() != null && !"".equals(po.getDatatime())) {
	         sql.append(",'" + po.getDatatime() + "'");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",'" + po.getLongitude() + "'");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",'" + po.getLatitude() + "'");
	      }

	      if(po.getYield() != null) {
	         sql.append(",'" + po.getYield() + "'");
	      }	
	      
	      if(po.getWeight() != null) {
	         sql.append(",'" + po.getWeight() + "'");
	      }	
	      if(po.getDemarcate1() != null) {
	         sql.append(",'" + po.getDemarcate1() + "'");
	      }
	      if(po.getDemarcate2() != null) {
	         sql.append(",'" + po.getDemarcate2() + "'");
	      }
	      if(po.getSimulationValue() != null) {
	         sql.append(",'" + po.getSimulationValue() + "'");
	      }
	      if(po.getLandType()!= null) {
	         sql.append(",'" + po.getLandType() + "'");
	      }
	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }
	
	public int AddTaLandYield(TaLandYieldPo po) {
	      StringBuilder sql = new StringBuilder("insert into ta_land_yield (");
	      if(po.getPkLand() != null && !"".equals(po.getPkLand())) {
	         sql.append("pk_land");
	      }

	      if(po.getDatatime() != null && !"".equals(po.getDatatime())) {
	         sql.append(",datatime");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",longitude");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",latitude");
	      }

	      if(po.getYield() != null) {
	         sql.append(",yield");
	      }	      
	      if(po.getWeight() != null) {
	         sql.append(",weight");
	      }
	      if(po.getDemarcate1() != null) {
	         sql.append(",demarcate1");
	      }
	      if(po.getDemarcate2() != null) {
	         sql.append(",demarcate2");
	      }
	      if(po.getSimulationValue() != null) {
	         sql.append(",simulationValue");
	      }
	      if(po.getLandType() != null) {
		         sql.append(",landType");
		      }

	      sql.append(") values(");
	      
	      if(po.getPkLand() != null && !"".equals(po.getPkLand())) {
	         sql.append("'" + po.getPkLand() + "'");
	      }

	      if(po.getDatatime() != null && !"".equals(po.getDatatime())) {
	         sql.append(",'" + po.getDatatime() + "'");
	      }

	      if(po.getLongitude() != null) {
	         sql.append(",'" + po.getLongitude() + "'");
	      }

	      if(po.getLatitude() != null) {
	         sql.append(",'" + po.getLatitude() + "'");
	      }

	      if(po.getYield() != null) {
	         sql.append(",'" + po.getYield() + "'");
	      }	
	      if(po.getWeight() != null) {
	         sql.append(",'" + po.getWeight() + "'");
	      }	
	      if(po.getDemarcate1() != null) {
	         sql.append(",'" + po.getDemarcate1() + "'");
	      }
	      if(po.getDemarcate2() != null) {
	         sql.append(",'" + po.getDemarcate2() + "'");
	      }
	      if(po.getSimulationValue() != null) {
	         sql.append(",'" + po.getSimulationValue() + "'");
	      }
	      if(po.getLandType()!= null) {
	         sql.append(",'" + po.getLandType() + "'");
	      }
	      sql.append(")");
	      //System.out.println(sql.toString());
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }
}
