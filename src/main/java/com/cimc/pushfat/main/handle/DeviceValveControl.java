package com.cimc.pushfat.main.handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cimc.pushfat.bean.common.ValveNumberBean;
import com.cimc.pushfat.codec.data.CommandEquipmentPackageData;
import com.cimc.pushfat.utils.common.HttpClientUtil;
import com.cimc.pushfat.utils.data.FgValveData;
import com.cimc.pushfat.utils.data.ValveMainData;
import com.cimc.pushfat.utils.data.ValveReSult;
import com.cimc.pushfat.utils.log.LogManager;
import com.cimc.pushfat.utils.serializer.FastJsonSerializer;

public class DeviceValveControl {

	
	public static String handleDeviceValve(int ValveID,String fgName,CommandEquipmentPackageData commandEquipmentPackageData){
		boolean isopen=true;
		boolean iscolse=true;
		String oldstate=getDeviceValveState(ValveID,fgName);// 获取旧的阀门状态
		Map<String, String> valveNumbermap=	ValveNumberBean.getValve(ValveID+"");//获取阀门地址
		List<Map<String, String>> ls_m=daControl(oldstate,commandEquipmentPackageData,valveNumbermap);
		// 下面就是控制阀门操作接口
		if(ls_m.get(0).size()>0){
			// 处理打开阀门
			ValveReSult valveReSult= SetDeviceValveState(ValveID,1, ls_m.get(0));
			if(valveReSult!=null&& "true".equals(valveReSult.getStatus())){
				isopen=true;
				//refreshDeviceValveState(deviceID, ls_m.get(0));
			}else{
				isopen=false;
			}
		}
		if(ls_m.get(1).size()>0){
			// 处理关闭阀门
			ValveReSult valveReSult= SetDeviceValveState(ValveID,0, ls_m.get(1));
			if(valveReSult!=null && "true".equals(valveReSult.getStatus())){
				iscolse=true;
				//refreshDeviceValveState(deviceID, ls_m.get(1));
			}else{
				iscolse=false;
			}
		}	
		if((isopen&&iscolse)?true:false){
			
			return commandEquipmentPackageData.toString();
		}
		return null;
	}
	
	public static String getDeviceValveState(int deviceID,String fgName){
		String url="http://121.40.66.98:8004/api/Device/Device/Fg/Valve";
		String token="QWugy*QnYBl42xaSDyFJOoXpt";
		Map<String ,String> params=new HashMap<String ,String>();
		params.put("pageIndex", "0");
		params.put("pageSize", "10");
		params.put("deviceID", deviceID+"");//pageIndex=0&pageSize=10&deviceID=22&fgName=未分组
		params.put("fgName", fgName);
		String json=HttpClientUtil.doGetForm(url, token, params);
		LogManager.getInstance().PrintGetValveLog(json);
		//System.out.println(json);;
		FastJsonSerializer fastJsonSerializer=new FastJsonSerializer();
		ValveMainData valveMainData=fastJsonSerializer.toObject(json, ValveMainData.class);
		//System.out.println(valveMainData.getInfo().get(0));
		StringBuffer strb=new StringBuffer();
		for(String s:valveMainData.getInfo()){
			FgValveData fgValveData=fastJsonSerializer.toObject(s, FgValveData.class);
			
			strb.append(doValveState(fgValveData.getValveStatus()));
		}
		// 补充一些不知8个阀门的数据
		for(int i=valveMainData.getInfo().size();i<9;i++){
			strb.append("0000");
		}
		//System.out.println(strb);
		
		return strb.toString();
	}
	
	public static ValveReSult SetDeviceValveState(int deviceID,int tapSwitch,Map<String, String> map){
		FastJsonSerializer fastJsonSerializer=new FastJsonSerializer();
		String url="http://121.40.66.98:8004/api/DeviceAt/DeviceAt";
		String token="QWugy*QnYBl42xaSDyFJOoXpt";
		List<String> ls=new ArrayList<String>();
		for(String key:map.keySet()){
			String vale=map.get(key);
			ls.add(key+"-"+vale);
		}
		if(ls.size()<=0){
			return null;
		}
		Map<String ,Object> params=new HashMap<String ,Object>();		
		params.put("deviceID", deviceID);
		params.put("tapSwitch", tapSwitch);// 0 表示关阀，1 表示开阀，2 表示查询数据 
		params.put("tapNumbers",ls);//pageIndex=0&pageSize=10&deviceID=22&fgName=未分组
		params.put("AtType", "ValveSet");
		String jsn=fastJsonSerializer.toJSON(params);
		//System.out.println(jsn);
		LogManager.getInstance().PrintSetValveLog(jsn);
		String json=HttpClientUtil.doPostFormTojson(url, token, jsn);
		//System.out.println(json);
		LogManager.getInstance().PrintSetValveLog(deviceID+"   "+json);
		ValveReSult  valveReSult=fastJsonSerializer.toObject(json, ValveReSult.class);
		return valveReSult;
		//return null;
	}
	
	public static void refreshDeviceValveState(int deviceID,Map<String, String> map){
		FastJsonSerializer fastJsonSerializer=new FastJsonSerializer();
		String url="http://121.40.66.98:8004/api/DeviceAt/DeviceAt";
		String token="QWugy*QnYBl42xaSDyFJOoXpt";
		List<String> ls=new ArrayList<String>();
		for(String key:map.keySet()){
			ls.add(key+"-0000");
		}
		if(ls.size()<=0){
			return ;
		}
		Map<String ,Object> params=new HashMap<String ,Object>();		
		params.put("deviceID", deviceID);
		params.put("tapSwitch", 2);// 0 表示关阀，1 表示开阀，2 表示查询数据 
		params.put("tapNumbers",ls);//pageIndex=0&pageSize=10&deviceID=22&fgName=未分组
		params.put("AtType", "ValveSet");
		String jsn=fastJsonSerializer.toJSON(params);		
		String json=HttpClientUtil.doPostFormTojson(url, token, jsn);
		
	}
	
	private static List<Map<String, String>> daControl(String oldstate,CommandEquipmentPackageData state,Map<String, String> valveNumbermap){
		Map<String, String> openMap=new HashMap<String, String>();
		Map<String, String> closeMap=new HashMap<String, String>();
		// 阀门1
		if(!state.getValve1().equals(oldstate.substring(0, 4))){
			String valve= switchState(state.getValve1());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("1"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("1"), valve);
			}
		}
		
		// 阀门2
		if(!state.getValve2().equals(oldstate.substring(4, 8))){
			String valve= switchState(state.getValve2());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("2"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("2"), valve);
			}
		}
		
		// 阀门3
		if(!state.getValve3().equals(oldstate.substring(8, 12))){
			String valve= switchState(state.getValve3());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("3"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("3"), valve);
			}
		}
		
		// 阀门4
		if(!state.getValve4().equals(oldstate.substring(12, 16))){
			String valve= switchState(state.getValve4());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("4"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("4"), valve);
			}
		}
		
		// 阀门5
		if(!state.getValve5().equals(oldstate.substring(16, 20))){
			String valve= switchState(state.getValve5());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("5"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("5"), valve);
			}
		}
		
		
		// 阀门6
		if(!state.getValve6().equals(oldstate.substring(20, 24))){
			String valve= switchState(state.getValve6());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("6"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("6"), valve);
			}
		}
		
		
		// 阀门7
		if(!state.getValve7().equals(oldstate.substring(24, 28))){
			String valve= switchState(state.getValve7());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("7"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("7"), valve);
			}
		}
		
		
		// 阀门8
		if(!state.getValve8().equals(oldstate.substring(28, 32))){
			String valve= switchState(state.getValve8());
			if(!"".equals(valve) && "0000".equals(valve)){
				// 操作关接口
				closeMap.put(valveNumbermap.get("8"), valve);
			}else if(!"".equals(valve)&& !"0000".equals(valve)){
				// 操作开接口
				openMap.put(valveNumbermap.get("8"), valve);
			}
		}	
		
		if(!state.getValve9().equals(oldstate.substring(32, 36))) {
			String valve = switchState(state.getValve9());
	         if(!"".equals(valve) && "0000".equals(valve)) {
	            closeMap.put((String)valveNumbermap.get("9"), valve);
	         } else if(!"".equals(valve) && !"0000".equals(valve)) {
	            openMap.put((String)valveNumbermap.get("9"), valve);
	         }
	      }
		List<Map<String, String>> ls_m=new ArrayList<Map<String,String>>();
		ls_m.add(openMap);
		ls_m.add(closeMap);
		return ls_m;
	}
	
	private static String switchState(String state){
		switch (state) {
		case "0000":
			// 全关
			return "0000";
		case "0100":
			// 1开
			return "1000";
		
		case "0001":
			// 2开
			return "0100";
		
		case "0101":
			// 全开
			return "1100";
		default:
			return "";
		}
	}
	
	private static String doValveState(String state){
		//全关到1开  全开到1开  1开到2开
		switch (state) {
		case "全关":
			return "0000";
		case "全关到1开":
			return "0000";
		case "全关到2开":
			return "0000";
		case "全关到全开":
			return "0000";
		case "1开":
			return "0100";
		case "1开到2开":
			return "0100";
		case "1开到全关":
			return "0100";
		case "1开到全开":
			return "0100";
		case "2开":
			return "0001";
		case "2开到1开":
			return "0001";
		case "2开到全关":
			return "0001";
		case "2开到全开":
			return "0001";
		case "全开":
			return "0101";
		case "全开到1开":
			return "0101";
		case "全开到2开":
			return "0101";
		case "全开到全关":
			return "0101";
		case "未到位":
			return "0000";
		default:
			return "0000";
		}
	}
}
