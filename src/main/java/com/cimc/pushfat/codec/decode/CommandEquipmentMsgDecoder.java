package com.cimc.pushfat.codec.decode;

import com.cimc.pushfat.codec.data.CommandEquipmentPackageData;
import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.utils.common.Utilty;

public class CommandEquipmentMsgDecoder {
	private Utilty utilty=new Utilty();
	public CommandEquipmentPackageData toCommandEquipmentUploadMsg(PackageData packageData) {
		CommandEquipmentPackageData cepd =new CommandEquipmentPackageData(packageData);
		
		byte[] body_bt=packageData.getMsgBodyBytes();
		
		cepd.setValve1(utilty.toStringByte(body_bt,15,16));
		cepd.setValve2(utilty.toStringByte(body_bt,17,18));
		cepd.setValve3(utilty.toStringByte(body_bt,19,20));
		cepd.setValve4(utilty.toStringByte(body_bt,21,22));
		cepd.setValve5(utilty.toStringByte(body_bt,23,24));
		cepd.setValve6(utilty.toStringByte(body_bt,25,26));
		cepd.setValve7(utilty.toStringByte(body_bt,27,28));
		cepd.setValve8(utilty.toStringByte(body_bt,29,30));
		cepd.setValve9(utilty.toStringByte(body_bt, 31, 32));
		System.out.println("阀门1:"+cepd.getValve1()+"  阀门2:"+cepd.getValve2()+"  阀门3:"+cepd.getValve3()+"  阀门4:"+cepd.getValve4()+"  阀门5:"+cepd.getValve5()+"   阀门6:"+cepd.getValve6()+"   阀门7:"+cepd.getValve7()+"   阀门8:"+cepd.getValve8()+"   阀门9:"+cepd.getValve9());
		return cepd;
	}
}
