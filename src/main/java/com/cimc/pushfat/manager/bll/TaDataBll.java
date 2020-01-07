package com.cimc.pushfat.manager.bll;

import java.util.List;
import java.util.Map;

import com.cimc.pushfat.manager.dal.TaDataDal;
import com.cimc.pushfat.manager.po.TfEuipmetDataPo;

public class TaDataBll {

	private TaDataDal taDataDal = new TaDataDal();


	   public List<Map<String, Object>> selectEquipmentById(String EQUIPMENT_ID) {
		   List<Map<String, Object>> ls_Equipment = this.taDataDal.selectEquipmentById(EQUIPMENT_ID);
	      return ls_Equipment;
	   }

	   public int addInfoTaDataNew(TfEuipmetDataPo po) {
		   List<Map<String, Object>> ls_TaData = this.taDataDal.selectTaDataByID(po.getPk_equipment());
	      if(ls_TaData.isEmpty()) {
	         this.taDataDal.AddTaDataNew(po);
	      } else {
	         this.taDataDal.updateTaDataNew(po);
	      }

	      this.taDataDal.AddTaData(po);
	      return 1;
	   }
}
