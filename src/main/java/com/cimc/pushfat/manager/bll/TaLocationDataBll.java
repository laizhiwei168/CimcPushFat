package com.cimc.pushfat.manager.bll;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.manager.dal.TaLocationDataDal;
import com.cimc.pushfat.manager.po.TaLocationDataPo;

public class TaLocationDataBll {
	private TaLocationDataDal dal = new TaLocationDataDal();


	   public int addInfoTaDataNew(TaLocationDataPo po) {
		   List<Map<String, Object>> ls_TaData = this.dal.selectTaLocationDataByID(po.getPk_equipment());
	      if(ls_TaData.isEmpty()) {
	         this.dal.AddTaLocationDataNew(po);
	      } else {
	         this.dal.updateTaLocationDataNew(po);
	      }

	      this.dal.AddTaLocationData(po);
	      return 1;
	   }
}
