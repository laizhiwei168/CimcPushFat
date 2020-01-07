package com.cimc.pushfat.manager.dal;

import com.cimc.pushfat.manager.common.DBBean;
import com.cimc.pushfat.manager.db.DBHandleHelper;
import com.cimc.pushfat.manager.po.Va_ValvePo;
import com.cimc.pushfat.manager.po.Va_fgPo;
import com.cimc.pushfat.manager.po.Va_fgValvePo;

public class ValveDal {

	private DBHandleHelper DbHelper = new DBHandleHelper();


	   public int AddValve(Va_ValvePo po) {
	      StringBuilder sql = new StringBuilder("insert into va_valve (");
	      if(po.getPk_valve() != null && !"".equals(po.getPk_valve())) {
	         sql.append("pk_valve");
	      }

	      if(po.getValveID() != null && !"".equals(po.getValveID())) {
	         sql.append(",valveID");
	      }

	      if(po.getValveName() != null && !"".equals(po.getValveName())) {
	         sql.append(",valveName");
	      }

	      if(po.getValveNo() != null && !"".equals(po.getValveNo())) {
	         sql.append(",valveNo");
	      }

	      sql.append(") values(");
	      if(po.getPk_valve() != null && !"".equals(po.getPk_valve())) {
	         sql.append("'" + po.getPk_valve() + "'");
	      }

	      if(po.getValveID() != null && !"".equals(po.getValveID())) {
	         sql.append(",'" + po.getValveID() + "'");
	      }

	      if(po.getValveName() != null && !"".equals(po.getValveName())) {
	         sql.append(",'" + po.getValveName() + "'");
	      }

	      if(po.getValveNo() != null && !"".equals(po.getValveNo())) {
	         sql.append(",'" + po.getValveNo() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }

	   public int Addfg(Va_fgPo po) {
	      StringBuilder sql = new StringBuilder("insert into va_fg (");
	      if(po.getPk_fg() != null && !"".equals(po.getPk_fg())) {
	         sql.append("pk_fg");
	      }

	      if(po.getPk_valve() != null && !"".equals(po.getPk_valve())) {
	         sql.append(",pk_valve");
	      }

	      if(po.getFgName() != null && !"".equals(po.getFgName())) {
	         sql.append(",fgName");
	      }

	      sql.append(") values(");
	      if(po.getPk_fg() != null && !"".equals(po.getPk_fg())) {
	         sql.append("'" + po.getPk_fg() + "'");
	      }

	      if(po.getPk_valve() != null && !"".equals(po.getPk_valve())) {
	         sql.append(",'" + po.getPk_valve() + "'");
	      }

	      if(po.getFgName() != null && !"".equals(po.getFgName())) {
	         sql.append(",'" + po.getFgName() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }

	   public int AddfgValve(Va_fgValvePo po) {
	      StringBuilder sql = new StringBuilder("insert into va_fgvalve (");
	      if(po.getPk_fgValve() != null && !"".equals(po.getPk_fgValve())) {
	         sql.append("pk_fgValve");
	      }

	      if(po.getPk_fg() != null && !"".equals(po.getPk_fg())) {
	         sql.append(",pk_fg");
	      }

	      if(po.getFgValveNo() != null && !"".equals(po.getFgValveNo())) {
	         sql.append(",fgValveNo");
	      }

	      if(po.getFgValveName() != null && !"".equals(po.getFgValveName())) {
	         sql.append(",fgValveName");
	      }

	      if(po.getFgValveAddress() != null && !"".equals(po.getFgValveAddress())) {
	         sql.append(",fgValveAddress");
	      }

	      if(po.getNumber() != null && !"".equals(po.getNumber())) {
	         sql.append(",number");
	      }

	      sql.append(") values(");
	      if(po.getPk_fgValve() != null && !"".equals(po.getPk_fgValve())) {
	         sql.append("'" + po.getPk_fgValve() + "'");
	      }

	      if(po.getPk_fg() != null && !"".equals(po.getPk_fg())) {
	         sql.append(",'" + po.getPk_fg() + "'");
	      }

	      if(po.getFgValveNo() != null && !"".equals(po.getFgValveNo())) {
	         sql.append(",'" + po.getFgValveNo() + "'");
	      }

	      if(po.getFgValveName() != null && !"".equals(po.getFgValveName())) {
	         sql.append(",'" + po.getFgValveName() + "'");
	      }

	      if(po.getFgValveAddress() != null && !"".equals(po.getFgValveAddress())) {
	         sql.append(",'" + po.getFgValveAddress() + "'");
	      }

	      if(po.getNumber() != null && !"".equals(po.getNumber())) {
	         sql.append(",'" + po.getNumber() + "'");
	      }

	      sql.append(")");
	      int Result = this.DbHelper.ExecuteSql(DBBean.mysqldata, sql.toString());
	      return Result;
	   }
}
