package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDatafromPropertiesFile(String key) throws IOException
	{
		
		Properties p=new Properties();
			  p.load( new FileInputStream("./configAppData/commondata.properties"));
		
String data = p.getProperty(key);
		
		return data;
	}

}