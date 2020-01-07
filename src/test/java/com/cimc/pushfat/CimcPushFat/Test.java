package com.cimc.pushfat.CimcPushFat;

import java.util.HashMap;
import java.util.Map;

import com.cimc.pushfat.command.cache.CommandCache;
import com.cimc.pushfat.utils.common.DateUtils;
import com.cimc.pushfat.utils.common.HttpClientUtil;
import com.cimc.pushfat.utils.data.FgData;
import com.cimc.pushfat.utils.data.ValveMainData;
import com.cimc.pushfat.utils.serializer.FastJsonSerializer;
import com.cimc.pushfat.web.service.IotDataService;
import com.cimc.pushfat.web.service.IotDataServicePortType;

public class Test {
     
	public static void main(String[] args) {
		/*CommandCache.getInstance().addCommandCache("123456","-----111-----");
		CommandCache.getInstance().addCommandCache("123456","-----888-----");
		System.out.println("获取："+CommandCache.getInstance().getCommandCache("123456"));
		CommandCache.getInstance().addCommandCache("123456","-----333-----");
		CommandCache.getInstance().addCommandCache("123456","-----555-----");
		System.out.println("获取："+CommandCache.getInstance().getCommandCache("123456"));
		System.out.println("获取："+CommandCache.getInstance().getCommandCache("123456"));
		CommandCache.getInstance().addCommandCache("123456","-----444-----");
		System.out.println("获取："+CommandCache.getInstance().getCommandCache("123456"));
		System.out.println("获取："+CommandCache.getInstance().getCommandCache("123456"));*/
		
		/*System.out.println(Float.intBitsToFloat(0x40800000));
		float f=Float.parseFloat("4");
		System.out.println(Integer.toHexString(Float.floatToIntBits(f)));*/
		/*String url="http://121.40.66.98:8004/api/Device/Device/Fg";
		String token="QWugy*QnYBl42xaSDyFJOoXpt";
		Map<String ,String> params=new HashMap<String ,String>();
		params.put("deviceID", "22");
		String json=HttpClientUtil.doGetForm(url, token, params);
		System.out.println(json);;
		FastJsonSerializer fastJsonSerializer=new FastJsonSerializer();
		ValveMainData valveMainData=fastJsonSerializer.toObject(json, ValveMainData.class);
		System.out.println(valveMainData.getInfo().get(0));
		FgData fgData=fastJsonSerializer.toObject(valveMainData.getInfo().get(0), FgData.class);
		System.out.println(fgData.getFgName());*/
//		IotDataService ids=new IotDataService();
//		IotDataServicePortType ispt=ids.getIotDataServiceHttpSoap11Endpoint();
//		String xml=ispt.gatewayData("中程智能", "111111","8677260330418741");//"867726033041874"
//		if(xml!=null && !"".equals(xml)) {
//			System.out.println(xml);
//		}else {
//			System.out.println("=--=-=");
//		}
		System.out.println(DateUtils.datetime2datetime("201909251733210020"));
	}
}
