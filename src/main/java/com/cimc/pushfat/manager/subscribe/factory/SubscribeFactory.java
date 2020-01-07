package com.cimc.pushfat.manager.subscribe.factory;

import com.cimc.pushfat.manager.subscribe.notify.ISubscribeNotify;
import com.cimc.pushfat.manager.subscribe.notify.impl.CommandEquipmentSubscribeNotify;
import com.cimc.pushfat.manager.subscribe.notify.impl.InformationSubscribeNotify;
import com.cimc.pushfat.manager.subscribe.notify.impl.RespCommandSubscribeNotify;


public class SubscribeFactory {

	public  void pushDataToPlatform(int MsgId, Object objectNode){
		ISubscribeNotify subscribeNotifyResource;
		switch (MsgId) {
		/*case 0X0001://处理设备注册方法
			subscribeNotifyResource=new CommandConfigSubscribeNotify();
			subscribeNotifyResource.HandleSubscribeNotify(objectNode);
			break;*/
		case 0X51://处理设备位置信息插入方法
			subscribeNotifyResource=new InformationSubscribeNotify();
			subscribeNotifyResource.HandleSubscribeNotify(objectNode);
			break;
		case 0X52://设备管道阀门命令控制
			subscribeNotifyResource=new CommandEquipmentSubscribeNotify();
			subscribeNotifyResource.HandleSubscribeNotify(objectNode);
			break;
		case 0X53://设备命令回复
			subscribeNotifyResource=new RespCommandSubscribeNotify();
			subscribeNotifyResource.HandleSubscribeNotify(objectNode);
			break;
		default:
			break;
		}
	}
}
