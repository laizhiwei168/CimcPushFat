package com.cimc.pushfat.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DevicePressureBean {

	
	private static Map<String, List<String>> devicePressuremap=new HashMap<String, List<String>>();
	static {
		List<String> l_1=new LinkedList<String>();
		l_1.add("867726033041874");
		l_1.add("867726033066228");
		devicePressuremap.put("16800025", l_1);//8-2b
		
		List<String> l_2=new LinkedList<String>();
		l_2.add("867726033807662");
		devicePressuremap.put("16800002 16800024", l_2);//10-2a
		
		List<String> l_3=new LinkedList<String>();
		l_3.add("867726033808033");
		devicePressuremap.put("16800024", l_3);//10-2b
		
		List<String> l_4=new LinkedList<String>();
		l_4.add("867726033808645");
		devicePressuremap.put("16800026", l_4);//8-2c
		
		List<String> l_5=new LinkedList<String>();
		l_5.add("867726033038540");
		l_5.add("867726032988760");
		l_5.add("867726033041791");
		devicePressuremap.put("16800019", l_5);//8-1b
		
		List<String> l_6=new LinkedList<String>();
		l_6.add("867726033809254");
		devicePressuremap.put("16800022", l_6);//7-2a
		
		/*List<String> l_7=new LinkedList<String>();
		l_7.add("867726033751191");
		devicePressuremap.put("", l_7);//7-2c
		
		List<String> l_8=new LinkedList<String>();
		l_8.add("867726033809304");
		devicePressuremap.put("16800013", l_8);//7-2d
		
		List<String> l_9=new LinkedList<String>();
		l_9.add("867726030527552");
		devicePressuremap.put("", l_9);//7-2e
*/		
		List<String> l_10=new LinkedList<String>();
		l_10.add("868744030681963");
		devicePressuremap.put("16800021", l_10);//7-5a
		
		List<String> l_11=new LinkedList<String>();
		l_11.add("867726033036395");
		devicePressuremap.put("16800023", l_11);//7-5c
		
		List<String> l_12=new LinkedList<String>();
		l_12.add("867726033808264");
		devicePressuremap.put("16800003", l_12);//7-5d
		
		List<String> l_13=new LinkedList<String>();
		l_13.add("867726033067119");
		devicePressuremap.put("16800015", l_13);//7-5b
	   }
	public static List<String> getDevicePressure(String key){
		return devicePressuremap.get(key);
	}
}
