package com.cimc.pushfat.codec.decode;

import com.cimc.pushfat.codec.data.InformationPackageData;
import com.cimc.pushfat.codec.data.PackageData;
import com.cimc.pushfat.utils.common.Utilty;


public class InformationMsgDecoder {

	private Utilty utilty=new Utilty();
	public InformationPackageData toInformationfoUploadMsg(PackageData packageData) {
		InformationPackageData informationPackageData=new InformationPackageData(packageData);
		
		byte[] body_bt=packageData.getMsgBodyBytes();
		
		informationPackageData.setDataTime(utilty.toStringByte(body_bt,0,5));
		informationPackageData.setDoorNumber(body_bt[6] & 0xff);
		informationPackageData.setDeviceAlert(body_bt[7] & 0xff);
		informationPackageData.setDeviceOperatePattern(body_bt[8] & 0xff);
		
		informationPackageData.setPushFatStatus(body_bt[9] & 0xff);;// 推肥状态
		informationPackageData.setPushFatDoorStatus1((body_bt[10] & 0xff)==1?true:false);;
		informationPackageData.setPushFatDoorStatus2((body_bt[11] & 0xff)==1?true:false);;
		informationPackageData.setPushFatDoorStatus3((body_bt[12] & 0xff)==1?true:false);;
		informationPackageData.setPushFatDoorStatus4((body_bt[13] & 0xff)==1?true:false);;
		
		informationPackageData.setPushFatPumpStatus(body_bt[14] & 0xff);;// 推肥泵状态
		
		informationPackageData.setPushFatNumber(utilty.bytes2Int(body_bt, 31, 2));
				
		boolean is_has=true;    	
    	byte messageid=body_bt[33];
        int number=body_bt[34] & 0xFF;
        int contentionLength_index=33+number+2;
        int contentionLength=packageData.getMsgBodyLength()-6;
        int situation=34; 
		
		 while (is_has) {
			 switch (messageid) {
			 	case 0x01:			 		
			 		informationPackageData.setKPFatWeight(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x02:			 		
			 		informationPackageData.setKPSecondFatWeight(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x03:
			 		informationPackageData.setXSAFatWeight(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x04:
			 		informationPackageData.setKPFatGross(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x05:			 		
			 		informationPackageData.setKPSecondFatGross(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x06:			 		
			 		informationPackageData.setXSAFatGross(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x07:
			 		
			 		informationPackageData.setKPFatLength(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x08:			 		
			 		informationPackageData.setKPSecondFatLength(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 	case 0x09:
			 		informationPackageData.setXSAFatLength(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
			 		
			 	case (byte) 0xA0:
			 		informationPackageData.setKPFatTotalLength(utilty.bytes2Int(body_bt, situation+1, number));
			 		break;
				case (byte) 0xA1:
					informationPackageData.setKPSecondFatTotalLength(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xA2:					
					informationPackageData.setXSAFatTotalLength(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xA3:
					informationPackageData.setInstantFlow(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xA4:
					informationPackageData.setPumpLaterPressure(utilty.bytes2Int(body_bt, situation+1, number));
						break;			
						
				case (byte) 0xA5:
					informationPackageData.setKPFatTanklevel(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xA6:
					informationPackageData.setKPSecondFatTanklevel(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xA7:
					informationPackageData.setXSAFatTanklevel(utilty.bytes2Int(body_bt, situation+1, number));
						break;	
				case (byte) 0xA8:
					informationPackageData.setKPFatWeightValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xA9:
					informationPackageData.setKPSecondFatWeightValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xB0:
					informationPackageData.setXSAFatWeightValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xB1:
					informationPackageData.setKPFatCompensationValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xB2:
					informationPackageData.setKPSecondFatCompensationValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xB3:
					informationPackageData.setXSAFatCompensationValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xB4:
					informationPackageData.setPumpLaterPressureLowValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xB5:
					informationPackageData.setFlowLowValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
				case (byte) 0xB6:
					informationPackageData.setPumpFrequencyValue(utilty.bytes2Int(body_bt, situation+1, number));
						break;
						
				case (byte) 0xB9:
					//System.out.println("================");
						break;
				default:
					break;
			 }			 
			//处理开始定位 与 读取的字节数
			situation=situation+number+2;
            if(contentionLength_index>=contentionLength){
            	is_has=false;
            	//return;
            }else{
            	messageid=body_bt[situation-1];
            	number=utilty.bytes2Int(body_bt, situation, 1);                
                contentionLength_index=contentionLength_index+number+2;              
               // System.out.println("situation:"+situation+"  messageid:"+(body_bt[situation-1]& 0xFF)+" contentionLength_index:"+contentionLength_index+"   contentionLength:"+contentionLength);
            }
		 }
		 informationPackageData.setKPPushFatNumber(utilty.bytes2Int(body_bt, contentionLength, 2));
		 informationPackageData.setKPSecondPushFatNumber(utilty.bytes2Int(body_bt, contentionLength+2, 2));
		 informationPackageData.setXSAPushFatNumber(utilty.bytes2Int(body_bt, contentionLength+4, 2));
		return informationPackageData;
	}
	
}
