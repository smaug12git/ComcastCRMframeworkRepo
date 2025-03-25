package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DATAProvide {
	
	@DataProvider
	public Object[][] DPasJSON() throws FileNotFoundException, IOException, ParseException
	{

		JSONParser j = new JSONParser();
		Object obj = j.parse(new FileReader("./configAppData/applicationcommondata.json"));
		JSONObject jobj = (JSONObject) obj;

		Object[][] objarr = new Object[1][2];

		objarr[0][0] = jobj.get("username");
		objarr[0][1] = jobj.get("password");
		return objarr;	
	}
	
	@DataProvider
	public Object[][] DPasProperties() throws Throwable, IOException
	{
		Properties p=new Properties();
		p.load( new FileInputStream("./configAppData/commondata.properties"));

		Object[][] objarr = new Object[1][2];

		objarr[0][0] = p.get("username");
		objarr[0][1] = p.get("password");

		return objarr;
	}
	
	@DataProvider
	public Object[][] DPasExcel() throws Throwable
	{
		ExcelUtility eLib= new ExcelUtility();
		
		Object[][] objarr = new Object[3][3];
		
		objarr[0][0] = eLib.getDataFromExcel("Sheet2", 1, 2);
		
		
//		objarr[1][0]=eLib.getDataFromExcel("Sheet2", 4, 2);
//		objarr[1][1]=eLib.getDataFromExcel("Sheet2", 4, 3);
//		objarr[1][2]=eLib.getDataFromExcel("Sheet2", 4, 4);
//		
//		objarr[2][0]=eLib.getDataFromExcel("Sheet2", 7, 2);
//		objarr[2][0]=eLib.getDataFromExcel("Sheet2", 7, 3);
		
		
		
		return objarr;
		
		
	}

}
