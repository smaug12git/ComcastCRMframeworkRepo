package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn;
	
	public void getDBconnection(String url,String username, String password) throws SQLException
	{
		try{
		Driver driveref= new Driver();
		DriverManager.registerDriver(driveref);
		
		 conn = DriverManager.getConnection(url, username, password);
		} 
		catch(Exception e)
		{	
		}
	}
	
	public void getDBconnection()
	{
		try{
			 Driver d= new Driver();
			 DriverManager.deregisterDriver(d);
			conn= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");	 
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void closeDBconnection() throws SQLException
	{
		try {
		conn.close();
		}
		catch(Exception e)
		{
		}
	}
	
	
	public ResultSet executeOnSelectQuery(String query) throws Throwable
	{
		ResultSet result=null;
		
		try {
		Statement stat = conn.createStatement();
		 result = stat.executeQuery(query); // result contains complete table
		}
		catch(Exception e)
		{	
		}
		
		return result;
		
	}
	
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		
		try {
			Statement stat = conn.createStatement();
			result =stat.executeUpdate(query); // result contains complete table
			}
			catch(Exception e)
			{	
			}
		
		return result;
		
	}
	
	
	
	
	
	
	

}
