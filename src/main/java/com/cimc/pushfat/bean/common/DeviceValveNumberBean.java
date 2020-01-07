package com.cimc.pushfat.bean.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author lzw
 *
 */
public class DeviceValveNumberBean {

	/**
	 * 7-2C  16800008
	 * 
	 * 7-2D  16800020
	 * 
	 * 8-2C  16800017
	 * */
	private static Map<String, Integer> valveNumbermap=new HashMap<String, Integer>();
	static {
	      valveNumbermap.put("16800026", Integer.valueOf(8));//8-2C
	      valveNumbermap.put("16800002", Integer.valueOf(10));//10-2A
	      valveNumbermap.put("16800019", Integer.valueOf(22));//8-1B
	      valveNumbermap.put("16800022", Integer.valueOf(21));//7-2A
	      valveNumbermap.put("16800013", Integer.valueOf(20));//7-2B
	      valveNumbermap.put("16800024", Integer.valueOf(24));//10-2B
	      valveNumbermap.put("16800007", Integer.valueOf(16));//8-2A
	      valveNumbermap.put("16800021", Integer.valueOf(9));//7-5A
	      valveNumbermap.put("16800015", Integer.valueOf(33));//7-5B
	      valveNumbermap.put("16800023", Integer.valueOf(32));//7-5C
	      valveNumbermap.put("16800003", Integer.valueOf(31));//7-5D
	      valveNumbermap.put("16800006", Integer.valueOf(17));//11-5A
	      valveNumbermap.put("16800016", Integer.valueOf(19));//11-5B
	      valveNumbermap.put("16800001", Integer.valueOf(11));//7-2E
	      valveNumbermap.put("16800014", Integer.valueOf(30));//11-3C
	      valveNumbermap.put("16800004", Integer.valueOf(29));//11-3B
	      valveNumbermap.put("16800010", Integer.valueOf(28));//11-3A
	      valveNumbermap.put("16800011", Integer.valueOf(18));//11-5C
	      valveNumbermap.put("16800025", Integer.valueOf(39));//8-2B
	   }
	public static Integer getDeviceValveAddress(String key){
		return valveNumbermap.get(key);
	}
}
