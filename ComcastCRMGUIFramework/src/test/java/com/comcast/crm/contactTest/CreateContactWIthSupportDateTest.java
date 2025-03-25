package com.comcast.crm.contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWIthSupportDateTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//=================commondata from property file============================
		
		FileUtility fLib= new FileUtility();
		
		String BROWSER=fLib.getDatafromPropertiesFile("browser");
		String URL=fLib.getDatafromPropertiesFile("url");
		String USERNAME=fLib.getDatafromPropertiesFile("username");
		String PASSWORD=fLib.getDatafromPropertiesFile("password");
		
		//=================geneating random no=============================
		
		JavaUtility jLib= new JavaUtility();
		int randomNum = jLib.getRandomNumber();
		
		//=================== testscript data from excel=======================
		
		ExcelUtility eLib= new ExcelUtility();
		String last_name = eLib.getDataFromExcel("Sheet3", 1, 2).toString() +randomNum;
		
		//===========================system date========================
		
		
		 String start_date =jLib.getSystemDate();
		 
		 String end_date =jLib.getReqiuredDate(30);
		 
		
		
		//===============launch different browsers==============================
		
		WebDriver driver= null;
		
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
			driver= new FirefoxDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		
		//======================navigate to application=================================
		
		WebDriverUtility wLib= new WebDriverUtility();
		
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
		
		// STEP1:=======NAIGATE TO APPLICATION
		driver.get(URL);
		
		// STEP2:=======LOGIN TO APPLICATION
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		// STEP3:=======NAIGATE TO CONTACTS
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(last_name);
		
		// STEP4:=======NAIGATE TO Support Start date
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(start_date);
		
		// STEP5:=======NAIGATE TO Support end date
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(end_date);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//======verify Start date=================
		
		String act_start_date = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(act_start_date.equals(start_date)) {
			System.out.println(act_start_date + "is pesent===PASS==========");
		}
		else {
			System.out.println(act_start_date + "is not pesent===FAIL==========");
		}
		

		//======verify end date=================
		
		String act_end_date = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(act_end_date.equals(end_date)) {
			System.out.println(act_end_date + "is pesent===PASS==========");
		}
		else {
			System.out.println(act_end_date + "is not pesent===FAIL==========");
		}
		
		
		
		driver.quit();
		
		
		

	}

}
