package com.cimc.pushfat.manager.bll;

import com.cimc.pushfat.manager.dal.TaLandYieldDal;
import com.cimc.pushfat.manager.po.TaLandYieldPo;

public class TaLandYieldBll {

	private TaLandYieldDal dal=new TaLandYieldDal();
	
	public int addTaLandYield(TaLandYieldPo po) {
		return dal.AddTaLandYield(po);
	}
	
}
