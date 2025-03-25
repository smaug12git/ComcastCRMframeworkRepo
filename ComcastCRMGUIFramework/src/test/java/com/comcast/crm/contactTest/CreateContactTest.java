package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib= new FileUtility();
		
		String BROWSER=fLib.getDatafromPropertiesFile("browser");
		String URL=fLib.getDatafromPropertiesFile("url");
		String USERNAME=fLib.getDatafromPropertiesFile("username");
		String PASSWORD=fLib.getDatafromPropertiesFile("password");
		
		//=================geneating random no=============================
		
		JavaUtility jLib= new JavaUtility();
		int randomNum = jLib.getRandomNumber();
		
		//===================excel for testscript data=======================
		
		ExcelUtility eLib= new ExcelUtility();
		String last_name = eLib.getDataFromExcel("Sheet3", 1, 2).toString() +randomNum;
		
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
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(last_name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//veriy last name
		
		String act_lastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(act_lastName.equals(last_name)) {
			System.out.println(act_lastName +" is present ====PASS=======");
		}
			else {
				System.out.println(act_lastName +" is present ====FAIL=======");
			}
		
		driver.quit();
		
		}
		
	}


