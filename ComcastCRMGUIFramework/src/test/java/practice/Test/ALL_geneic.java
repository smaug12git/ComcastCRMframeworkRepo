package practice.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ALL_geneic {
	
	//================fileutility===========
			
	public String getPropertiesfileData(String key) throws Throwable, Throwable
	{
		Properties p= new Properties();
					p.load(new FileInputStream("path"));
			String data = p.getProperty(key);
			return data;
	}
	
	public String getJSONfileData(String key) throws Throwable, Throwable, Throwable
	{
		JSONParser j= new JSONParser();
		Object obj = j.parse(new FileReader("path"));
		JSONObject jobj= (JSONObject) obj;
		String data = jobj.get(key).toString();
		return data;
		
	}
	
	public String getEXCELfileData(String path,String Sheetname, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheetname);
		String data = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
	public void seetEXCELfileData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("path");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheetname");
		 sh.getRow(1).createCell(1).setCellValue("hii");
		 
		 FileOutputStream fos= new FileOutputStream("path");
		 book.write(fos);
		 book.close();
	}
	
	
	
	public String getSystemDate()
	{
		Date d= new Date();
		SimpleDateFormat s= new SimpleDateFormat();
		String date = s.format(d);
		return date;
	}
	
	public String getRequiredDate(int days)
	{
		Date d = new Date();
		SimpleDateFormat s= new SimpleDateFormat();
		s.format(d);
		Calendar cal = s.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String data = s.format(cal.getTime());
		return data;
	}
	
	public void passValue(WebDriver driver,String val,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+val+"';", ele);
	}
	
	public void passValueBasedOn(WebDriver driver,String ID,String actvalue )
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById("+ID+").value='"+actvalue+"'");
		
	}

	
	
	
	
}
