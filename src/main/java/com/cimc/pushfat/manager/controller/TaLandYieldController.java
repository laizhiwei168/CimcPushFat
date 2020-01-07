package com.cimc.pushfat.manager.controller;

import com.cimc.pushfat.manager.bll.TaLandYieldBll;
import com.cimc.pushfat.manager.po.TaLandYieldPo;

public class TaLandYieldController {

	private TaLandYieldBll bll=new TaLandYieldBll();
	
	public void handleLandYield(TaLandYieldPo po){
		bll.addTaLandYield(po);
	}
	
}
