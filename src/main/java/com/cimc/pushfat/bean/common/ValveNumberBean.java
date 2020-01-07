package com.cimc.pushfat.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * 设备ID：22
阀门编号
1."ValveNo": 838,
2."ValveNo": 292,
3."ValveNo": 778,
4."ValveNo": 817,
5."ValveNo": 968,
6."ValveNo": 907,
7."ValveNo": 268,
8."ValveNo": 307,
 * @author lzw
 *
 */
public class ValveNumberBean {

	private static Map<String,Map<String, String>> l_map = new HashMap<String,Map<String, String>>();
	   private static Map<String, String> valveNumbermap1 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap2 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap3 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap4 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap5 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap6 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap7 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap8 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap9 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap10 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap11 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap12 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap13 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap14 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap15 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap16 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap17 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap18 = new HashMap<String, String>();
	   private static Map<String, String> valveNumbermap19 = new HashMap<String, String>();


	   static {
	      valveNumbermap1.put("1", "0346");
	      valveNumbermap1.put("2", "0124");
	      valveNumbermap1.put("3", "03B9");
	      valveNumbermap1.put("4", "0331");
	      valveNumbermap1.put("5", "03C8");
	      valveNumbermap1.put("6", "038B");
	      valveNumbermap1.put("7", "010C");
	      valveNumbermap1.put("8", "0133");
	      l_map.put("22", valveNumbermap1);
	      valveNumbermap2.put("1", "0058");
	      valveNumbermap2.put("2", "03D6");
	      valveNumbermap2.put("3", "00B1");
	      valveNumbermap2.put("4", "028A");
	      valveNumbermap2.put("5", "0309");
	      valveNumbermap2.put("6", "025D");
	      valveNumbermap2.put("7", "03BA");
	      valveNumbermap2.put("8", "032C");
	      l_map.put("24", valveNumbermap2);
	      valveNumbermap3.put("1", "0111");
	      valveNumbermap3.put("2", "01F1");
	      valveNumbermap3.put("3", "0386");
	      valveNumbermap3.put("4", "0095");
	      valveNumbermap3.put("5", "03FB");
	      valveNumbermap3.put("6", "01B5");
	      valveNumbermap3.put("7", "0172");
	      valveNumbermap3.put("8", "00D1");
	      l_map.put("10", valveNumbermap3);
	      valveNumbermap4.put("1", "0336");
	      valveNumbermap4.put("2", "01FB");
	      valveNumbermap4.put("3", "0165");
	      valveNumbermap4.put("4", "019E");
	      valveNumbermap4.put("5", "024E");
	      valveNumbermap4.put("6", "0403");
	      valveNumbermap4.put("7", "02BA");
	      valveNumbermap4.put("8", "0110");
	      l_map.put("8", valveNumbermap4);
	      valveNumbermap5.put("1", "018F");
	      valveNumbermap5.put("2", "03DF");
	      valveNumbermap5.put("3", "03EE");
	      valveNumbermap5.put("4", "00CA");
	      valveNumbermap5.put("5", "0244");
	      valveNumbermap5.put("6", "0347");
	      valveNumbermap5.put("7", "0266");
	      valveNumbermap5.put("8", "03A2");
	      l_map.put("20", valveNumbermap5);
	      valveNumbermap6.put("1", "02D3");
	      valveNumbermap6.put("2", "017B");
	      valveNumbermap6.put("3", "01FC");
	      valveNumbermap6.put("4", "0444");
	      valveNumbermap6.put("5", "0246");
	      valveNumbermap6.put("6", "02FD");
	      l_map.put("21", valveNumbermap6);
	      valveNumbermap7.put("1", "00D6");
	      valveNumbermap7.put("2", "0379");
	      valveNumbermap7.put("3", "0441");
	      valveNumbermap7.put("4", "0164");
	      valveNumbermap7.put("5", "03D2");
	      valveNumbermap7.put("6", "0399");
	      valveNumbermap7.put("7", "0434");
	      valveNumbermap7.put("8", "0342");
	      l_map.put("16", valveNumbermap7);
	      valveNumbermap8.put("1", "028D");
	      valveNumbermap8.put("2", "0262");
	      valveNumbermap8.put("3", "0369");
	      valveNumbermap8.put("4", "021F");
	      valveNumbermap8.put("5", "0462");
	      valveNumbermap8.put("6", "0235");
	      l_map.put("9", valveNumbermap8);
	      valveNumbermap9.put("1", "0234");
	      valveNumbermap9.put("2", "01BE");
	      valveNumbermap9.put("3", "0269");
	      valveNumbermap9.put("4", "044B");
	      valveNumbermap9.put("5", "0139");
	      valveNumbermap9.put("6", "0333");
	      valveNumbermap9.put("7", "02C6");
	      l_map.put("33", valveNumbermap9);
	      valveNumbermap10.put("1", "0360");
	      valveNumbermap10.put("2", "0180");
	      valveNumbermap10.put("3", "0162");
	      valveNumbermap10.put("4", "025F");
	      valveNumbermap10.put("5", "00FD");
	      valveNumbermap10.put("6", "0153");
	      valveNumbermap10.put("7", "0240");
	      l_map.put("32", valveNumbermap10);
	      valveNumbermap11.put("1", "03FD");
	      valveNumbermap11.put("2", "00EB");
	      valveNumbermap11.put("3", "0285");
	      valveNumbermap11.put("4", "03DD");
	      valveNumbermap11.put("5", "0189");
	      valveNumbermap11.put("6", "00CC");
	      valveNumbermap11.put("7", "024F");
	      l_map.put("31", valveNumbermap11);
	      valveNumbermap12.put("1", "00CE");
	      valveNumbermap12.put("2", "0264");
	      valveNumbermap12.put("3", "039E");
	      valveNumbermap12.put("4", "0267");
	      valveNumbermap12.put("5", "016D");
	      valveNumbermap12.put("6", "02A2");
	      valveNumbermap12.put("7", "03BC");
	      valveNumbermap12.put("8", "0368");
	      l_map.put("17", valveNumbermap12);
	      valveNumbermap13.put("1", "009F");
	      valveNumbermap13.put("2", "014F");
	      valveNumbermap13.put("3", "0219");
	      valveNumbermap13.put("4", "03D0");
	      valveNumbermap13.put("5", "00BC");
	      valveNumbermap13.put("6", "0241");
	      valveNumbermap13.put("7", "00B4");
	      valveNumbermap13.put("8", "01FF");
	      l_map.put("19", valveNumbermap13);
	      valveNumbermap14.put("1", "0332");
	      valveNumbermap14.put("2", "03D9");
	      valveNumbermap14.put("3", "0460");
	      valveNumbermap14.put("4", "0390");
	      valveNumbermap14.put("5", "02C5");
	      valveNumbermap14.put("6", "0446");
	      valveNumbermap14.put("7", "00F5");
	      valveNumbermap14.put("8", "00D8");
	      l_map.put("11", valveNumbermap14);
	      valveNumbermap15.put("1", "033E");
	      valveNumbermap15.put("2", "02F5");
	      valveNumbermap15.put("3", "00CB");
	      valveNumbermap15.put("4", "0352");
	      valveNumbermap15.put("5", "00B7");
	      valveNumbermap15.put("6", "0435");
	      valveNumbermap15.put("7", "008A");
	      l_map.put("30", valveNumbermap15);
	      valveNumbermap16.put("1", "0192");
	      valveNumbermap16.put("2", "0187");
	      valveNumbermap16.put("3", "03A1");
	      valveNumbermap16.put("4", "028E");
	      valveNumbermap16.put("5", "0242");
	      valveNumbermap16.put("6", "036E");
	      valveNumbermap16.put("7", "021E");
	      l_map.put("29", valveNumbermap16);
	      valveNumbermap17.put("1", "025A");
	      valveNumbermap17.put("2", "013B");
	      valveNumbermap17.put("3", "03AE");
	      valveNumbermap17.put("4", "0296");
	      valveNumbermap17.put("5", "0100");
	      valveNumbermap17.put("6", "03F0");
	      valveNumbermap17.put("7", "01BD");
	      valveNumbermap17.put("8", "00A4");
	      valveNumbermap17.put("9", "03C0");
	      l_map.put("28", valveNumbermap17);
	      valveNumbermap18.put("1", "0464");
	      valveNumbermap18.put("2", "025E");
	      valveNumbermap18.put("3", "037E");
	      valveNumbermap18.put("4", "0372");
	      valveNumbermap18.put("5", "013F");
	      valveNumbermap18.put("6", "0154");
	      valveNumbermap18.put("7", "02C1");
	      valveNumbermap18.put("8", "01BF");
	      l_map.put("18", valveNumbermap18);
	      valveNumbermap19.put("1", "00C3");
	      valveNumbermap19.put("2", "01E9");
	      valveNumbermap19.put("3", "02B8");
	      valveNumbermap19.put("4", "0013");
	      valveNumbermap19.put("5", "02FE");
	      valveNumbermap19.put("6", "014D");
	      valveNumbermap19.put("7", "0128");
	      valveNumbermap19.put("8", "0123");
	      l_map.put("39", valveNumbermap19);
	   }
	/*public static String getValveAddress(String key){
		return valveNumbermap.get(key);
	}*/
	 
	   public static Map<String, String> getValve(String key) {
		      return l_map.get(key);
		}
	/*public static void main(String[] args) {
		System.out.println(ValveNumberBean.getValveAddress("1"));
	}*/
}
