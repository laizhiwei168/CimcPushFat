package com.cimc.pushfat.main.handle;

import java.util.Properties;

import com.cimc.pushfat.command.cache.CommandCache;
import com.cimc.pushfat.manager.controller.CommandCacheController;
import com.cimc.pushfat.utils.common.PropertiesUtil;


/**
 * 主要处理本系统的定时任务
 * 1.定时刷新升级
 * 2.定时刷新远程命令
 * @author lzw
 *
 */
public class MainScheduled implements Runnable{
	//private DeviceUpgradeContrller deviceUpgradeContrller=new DeviceUpgradeContrller();
	private CommandCacheController commandCacheController=new CommandCacheController();
	@Override
	public void run() {
		System.out.println("===================  ** ! MainScheduled ** =========================");
		// 刷新升级包到服务缓存里
		//deviceUpgradeContrller.saveDeviceUpgradeByAllType();
		//deviceUpgradeContrller.saveDeviceUpgradeBytePartType();
		// 刷新命令到服务缓存里
		commandCacheController.handlecomman2Cache();
		
		/*
		String imeiNo="16800000";
		String id="123456";
		String command_type="A1,A3,C1,C3,C5";
		String command_content="01,00,41000000,42F11333,40800000";
		
		String idAndtypeAndcontent=id+"="+command_type+"="+command_content;
		System.out.println(imeiNo+"=========="+idAndtypeAndcontent);
		CommandCache.getInstance().addCommandCache(imeiNo, idAndtypeAndcontent);
		*/
		
		/*Properties props= PropertiesUtil.GetProperties("/resources/constant1.properties");
		for(Object key : props.keySet()){
			System.out.println(key.toString()+"       "+ props.get(key).toString());
			CommandCache.getInstance().addCommandCache(key.toString(), props.get(key).toString());
		}*/
			
	}

}
