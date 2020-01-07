package com.cimc.pushfat.utils.mongodb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.bson.Document;

import com.cimc.pushfat.utils.common.JsonUtil;
import com.cimc.pushfat.utils.common.PropertiesUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC{
	private static MongoDBJDBC MongoDB=new MongoDBJDBC();
	private MongoDBJDBC(){
		System.out.println("MongoDBJDBC");
	}
	public static MongoDBJDBC getMongoDBJDBC(){
		return MongoDB;
	}
	
	private MongoDatabase db;
	
	/*
	 * 根据经纬度和adduser获取mongodb中的电子围栏
	 */
	public Map<String, Object> getUserFenceData(List<String> addUsers,double longitude, double latitude){
		List<Map<String,Object>> lst_UserFence_map=new ArrayList<Map<String,Object>>();
		   db =getdb();//获取db连接   
		   
		   double[] db2=new double[2];
		   db2[0]=longitude;
		   db2[1]=latitude;
		   BasicDBObject query3 = new BasicDBObject(); 		  
		   Map<String, Object> queryMap = new HashMap<>();  
		    queryMap.put("coordinates", db2);  
		    queryMap.put("type", "Point"); 
		    //模糊匹配rule查询  
		    query3.put("polygons", new BasicDBObject("$geoIntersects", new BasicDBObject("$geometry",new BasicDBObject(queryMap))));
		    query3.put("isDelete", false);
		    query3.put("addUser", new BasicDBObject("$in",addUsers));
		   MongoCollection<Document> collection = db.getCollection("land");// fence
		   FindIterable<Document> docs=collection.find(query3);
		   docs.forEach(new Block<Document>() {
			@Override
			public void apply(Document arg0) {
				// TODO Auto-generated method stub
				//System.out.println("mongodb data："+arg0.toJson());
				Map<String, Object> data = new HashMap<String, Object>();
		        data = JsonUtil.jsonString2SimpleObj(arg0.toJson().toString(), data.getClass());		        
		        lst_UserFence_map.add(data);
			}
			});
		   Map<String, Object> UserFence_data = null;
		   if(lst_UserFence_map.size()>0){	
			   UserFence_data =new HashMap<String, Object>();
			   String id=lst_UserFence_map.get(0).get("id").toString();
		       String fenceName=lst_UserFence_map.get(0).get("fenceName").toString();
		       Integer dataInterval=(Integer) lst_UserFence_map.get(0).get("dataInterval");
		       boolean isEvent=true;//默认为true  主要是monogodb中没有这个字段
		       if(lst_UserFence_map.get(0).get("isEvent")!=null){
		    	   isEvent =(boolean) lst_UserFence_map.get(0).get("isEvent");
		       }		      		      	       
		       boolean isSMS =(boolean)lst_UserFence_map.get(0).get("isSMS");
		       boolean isEmail =(boolean)lst_UserFence_map.get(0).get("isEmail");
		       
		       String mobiles=lst_UserFence_map.get(0).get("mobiles").toString();
		       String emails=lst_UserFence_map.get(0).get("emails").toString();
		       
		       UserFence_data.put("id", id);
		       UserFence_data.put("fenceName", fenceName);
		       UserFence_data.put("dataInterval", dataInterval);
		       
		       UserFence_data.put("isEvent", isEvent);
		       UserFence_data.put("isSMS", isSMS);
		       UserFence_data.put("isEmail", isEmail);
		       UserFence_data.put("mobiles", mobiles);
		       UserFence_data.put("emails", emails);
		   }
		   return UserFence_data;
	}
	
	
	/*
	 * 根据经纬度获取mongodb中的位置信息
	 */
	public Map getLocationData(double longitude, double latitude){
		List<Map<String,Object>> lst_mongdb_map=new ArrayList<Map<String,Object>>();
		Map<String,String> mongdb_map=null;
		   db =getdb();//获取db连接   
		   
		   double[] db2=new double[2];
		   db2[0]=longitude;
		   db2[1]=latitude;
		   BasicDBObject query3 = new BasicDBObject(); 
		   Map<String, Object> queryMap = new HashMap<>();  
		    queryMap.put("coordinates", db2);  
		    queryMap.put("type", "Point");  
		    //模糊匹配rule查询  
		    query3.put("polygons", new BasicDBObject("$geoIntersects", new BasicDBObject("$geometry",new BasicDBObject(queryMap))));
		   MongoCollection<Document> collection = db.getCollection("geo");
		   FindIterable<Document> docs=collection.find(query3);
		   docs.forEach(new Block<Document>() {			   
			@Override
			public void apply(Document arg0) {
				// TODO Auto-generated method stub
				//System.out.println(arg0.toJson());
				Map<String, Object> data = new HashMap<String, Object>();
		        data = JsonUtil.jsonString2SimpleObj(arg0.toJson().toString(), data.getClass());
				lst_mongdb_map.add(data);
			}			
			 });
		   if(lst_mongdb_map.size()>0){	
			   mongdb_map= new HashMap<String, String>();
			   String location=lst_mongdb_map.get(0).get("location").toString();
		       String lgd=lst_mongdb_map.get(0).get("longitude").toString();
		       String lad=lst_mongdb_map.get(0).get("latitude").toString();
		       mongdb_map.put("location", location);
		       mongdb_map.put("longitude", lgd);
		       mongdb_map.put("latitude", lad);
		   }
		   
		   return mongdb_map;
	}
	
	
	/*
	 * 创建mongodb数据库连接
	 */
	public MongoDatabase getdb(){
		if(db ==null){
			Properties ppts= PropertiesUtil.GetProperties("/resources/Mongodb.properties");
		final String IP_ADDRESS = ppts.getProperty("IP_ADDRESS"); // 本机地址
		   final String DB_NAME = ppts.getProperty("DB_NAME"); // 数据库名称
		   //System.out.println("IP_ADDRESS:"+IP_ADDRESS);
		     ServerAddress serverAddress = new ServerAddress(IP_ADDRESS, 27017);
		   List<ServerAddress> addrs = new ArrayList<ServerAddress>();
		   addrs.add(serverAddress);

		   // MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
		   String user_name=ppts.getProperty("name");
		   String user_pwd=ppts.getProperty("password");
		   MongoCredential credential = MongoCredential.createScramSha1Credential(user_name, DB_NAME,
				   user_pwd.toCharArray());
		   List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		   credentials.add(credential);

		   // 通过连接认证获取MongoDB连接
		   MongoClient client = new MongoClient(addrs, credentials);
		    db = client.getDatabase(DB_NAME);
		    return db;
		}else{
			return db;
		}
	}
	
   public static void main( String args[] ){
	   List<String> lst_adduser=new ArrayList<String>();
	   lst_adduser.add("14c51af9277e4a5b9d484bf9319b4f15");
	   Map<String, Object> map= MongoDBJDBC.getMongoDBJDBC().getUserFenceData(lst_adduser,79.688646,56.829059);	// 79.688645, 56.829059   
	  //System.out.println(map);
	   System.out.println(map.get("id")+"        "+map.get("fenceName")+"        "+map.get("dataInterval")) ;
      //System.out.println("id:"+id+"   fenceName:"+fenceName);
	  // for(int i=0;i<5;i++){
		  /*Map<String , String > location_map= MongoDBJDBC.getMongoDBJDBC().getLocationData(82.48761,45.254959);
		  System.out.println("location:"+location_map.get("location"));
		  System.out.println("longitude:"+location_map.get("longitude"));
		  System.out.println("latitude:"+location_map.get("latitude"));*/		  
	  //}
   }
}