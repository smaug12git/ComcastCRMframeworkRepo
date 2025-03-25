package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJSONFile(String key) throws Throwable
	{
		
		FileReader fileR = new FileReader("/configAppData/applicationcommondata.json");
		
		JSONParser j= new JSONParser();
		Object obj = j.parse(fileR);
		
		JSONObject jobj= (JSONObject) obj;
		String data =(String) jobj.get(key);
		return data; 
	}

}
