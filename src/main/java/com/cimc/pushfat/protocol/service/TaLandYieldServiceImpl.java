package com.cimc.pushfat.protocol.service;

import org.xsocket.connection.INonBlockingConnection;

import com.cimc.pushfat.manager.controller.TaLandYieldController;
import com.cimc.pushfat.manager.po.TaLandYieldPo;
import com.cimc.pushfat.thread.pool.LandPool;
import com.cimc.pushfat.utils.common.DateUtils;

public class TaLandYieldServiceImpl {

	public Object dealWithData(final String str,INonBlockingConnection nbc) {
		TaLandYieldController controller=new TaLandYieldController();
		TaLandYieldPo po=new TaLandYieldPo();
		if(str.startsWith("#")) {
			String[] s_str=str.replace("#", "").split(",");
			if(s_str.length>2) {
				//System.out.println(s_str[0]+"  "+s_str[1]+"  "+s_str[2]+"   "); 
				try {
					po.setPkLand("123456789");
					//po.setDatatime(DateUtils.getDoDayTime());
					po.setLongitude(Double.valueOf(s_str[0]));
					po.setLatitude(Double.valueOf(s_str[1]));
					if(!"".equals(s_str[2])) {
						po.setYield(Double.valueOf(s_str[2]));
					}
					if(s_str.length>3&&s_str[3]!=null && !"".equals(s_str[3])) {
						po.setLandType(Integer.valueOf(s_str[3]));
					}
					if(s_str.length>4&&s_str[4]!=null && !"".equals(s_str[4])) {						
					    po.setDatatime(DateUtils.datetime2datetime(s_str[4]));
					}
					/*if(s_str.length>5&&s_str[5]!=null && !"".equals(s_str[5])) {
						po.setDemarcate2(Double.valueOf(s_str[5]));
					}
					if(s_str.length>6&&s_str[6]!=null && !"".equals(s_str[6])) {
						po.setSimulationValue(Double.valueOf(s_str[6]));
					}*/
					
					LandPool.init().execute(new  Runnable() {
			 			public void run() {
			 				controller.handleLandYield(po);
			 			}
			 		});
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return null;
	}
	
	
	
}
