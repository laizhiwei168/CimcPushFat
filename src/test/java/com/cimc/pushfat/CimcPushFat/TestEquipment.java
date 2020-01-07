package com.cimc.pushfat.CimcPushFat;

import java.util.ArrayList;
import java.util.List;

import com.cimc.pushfat.manager.dal.TaEquipmentDal;
import com.cimc.pushfat.manager.po.TaEquipmentPo;
import com.cimc.pushfat.utils.common.UUIDUtil;

public class TestEquipment {

	private static TaEquipmentDal dal=new TaEquipmentDal();
	
	public static void main(String[] args) {
		List<String> lsList=new ArrayList<String>();
		lsList.add("867726033807043");
		lsList.add("867726033807373");
		lsList.add("867726033806391");
		lsList.add("867726033807167");
		lsList.add("867726033806961");
		lsList.add("867726033806136");
		lsList.add("867726033808389");
		lsList.add("867726033806672");
		lsList.add("867726033807019");
		lsList.add("867726033808074");
		lsList.add("867726033750847");
		lsList.add("867726033751142");
		lsList.add("867726033808132");
		lsList.add("867726033794803");
		lsList.add("867726033806052");
		for(String EquipmentNo: lsList) {
			//addEquipment(EquipmentNo);
		}
		
	}
	
	private static void addEquipment(String EquipmentNo) {
		//String EquipmentNo="867726033797236";
		TaEquipmentPo po=new TaEquipmentPo();
		po.setPk_equipment(UUIDUtil.getUUID());
		po.setPk_company("714d9223721c11e9b99c00163e06dab9");
		po.setEquipmentNo(EquipmentNo);
		po.setEquipmentType(9);//1:推肥机 2:气象站 3:压力  4:网关  5:电池阀  6:液肥灌  7:孢子捕捉器  8:昆虫捕捉器 9:商情设备
		po.setCreator("2cee4278721d11e9b99c00163e06dab9");;
		po.setCreatortime("2019-07-26 15:06:01");
		dal.AddEquipment(po);
	}
}
