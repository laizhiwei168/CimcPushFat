package com.cimc.pushfat.main.handle;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.cimc.pushfat.utils.data.Data;
import com.cimc.pushfat.utils.data.Field;
import com.cimc.pushfat.utils.data.record;
import com.cimc.pushfat.web.service.IotDataService;
import com.cimc.pushfat.web.service.IotDataServicePortType;


public class DevicePressureControl {

	// 获取的压力值需要转换为千帕压力  值*1000
	public static String handleDevicePressure(List<String> ls) {
		if(ls!=null && !ls.isEmpty()) {
			StringBuilder sb=new StringBuilder();
			for(String gateway:ls) {
				IotDataService ids=new IotDataService();
				IotDataServicePortType ispt=ids.getIotDataServiceHttpSoap11Endpoint();
				String xml=ispt.gatewayData("中程智能", "111111",gateway);//"867726033041874"
				String pressure=null;
				if(xml!=null && !"".equals(xml)) {
				try {
					JAXBContext context = JAXBContext.newInstance(Data.class);
					Unmarshaller unmarshaller = context.createUnmarshaller();  
			        Data data = (Data)unmarshaller.unmarshal(new StringReader(xml));
			        String id = null;
			        String value = null;
			        if(data.getRecord()!=null && !data.getRecord().isEmpty()) {
			        for(record record:data.getRecord()) {
			        	 for(Field s:record.getField()) {
			        		 if("channel_name".equals(s.getColumn_name())){
			        			 id=s.getValue();
			        		 }else if("value".equals(s.getColumn_name())){
			        			 value=s.getValue();
			        		 }
						}
			        	if("130".equals(id)) {
			        		pressure=value;
			        	}
			        }
			        }
			        
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				// 做压力值转换为协议识别
				//pressure
					if(pressure!=null) {
						float f=Float.parseFloat(pressure);
						sb.append(Integer.toHexString(Float.floatToIntBits(f*1000)));
					}
				}else {
					sb.append("00000000");
				}
			}
			if(sb.length()<32) {
				for(int i=sb.length();i<32;i++) {
					sb.append("0");
				}
			}
			return sb.toString();
		}
		return null;
	}
}
