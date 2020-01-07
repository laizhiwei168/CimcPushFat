package com.cimc.pushfat.manager.subscribe.notify.impl;

import com.cimc.pushfat.codec.data.CommandEquipmentPackageData;
import com.cimc.pushfat.manager.subscribe.notify.ISubscribeNotify;

public class CommandEquipmentSubscribeNotify implements ISubscribeNotify {

	@Override
	public void HandleSubscribeNotify(Object deviceData) {
		CommandEquipmentPackageData commandEquipmentPackageData=(CommandEquipmentPackageData) deviceData;
		
	}	

}
