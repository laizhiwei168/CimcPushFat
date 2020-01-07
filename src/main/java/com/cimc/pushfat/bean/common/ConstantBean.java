package com.cimc.pushfat.bean.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.cimc.pushfat.utils.common.PropertiesUtil;

//
public class ConstantBean {
	public static Map<String, String> constantMap=new HashMap<String, String>();
	static {
		Properties props= PropertiesUtil.GetProperties("/resources/constant.properties");
		for(Object key : props.keySet()){
			constantMap.put(key.toString(), props.get(key).toString());
		}
	}	
}
