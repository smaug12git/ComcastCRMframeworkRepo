package com.comcast.crm.orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		
		
		
		//================= property file for common data================================
		
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
		String org_name = eLib.getDataFromExcel("Sheet2", 1, 2) + randomNum;
		
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
		
		// STEP3:=======NAIGATE TO ORGANIZATION
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		
		//STEP4:=======organization page by click on "+" image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		// STEP5:=======ENTER ALL THE DETAILS AND CREATE NEW ORGANIZATION
		driver.findElement(By.name("accountname")).sendKeys(org_name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// STEP6==============verify header message Expected result
		String header_info = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header_info.contains(org_name)) {
			System.out.println(org_name +" data is created=====PASS======");
		}
		else {
			System.out.println(org_name +" data is not created=====FAIL======");
		}
		
		// STEP7:======= verify header orgName info Expected result==============================
		String actual_orgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actual_orgName.equals(org_name)) {
				System.out.println(org_name +"data is present=======PASS========");
			}
			else {
				System.out.println(org_name +"data is not present=======PASS========");
			}
			
			// STEP8:======= SIGNOUT APPLICATION
			
			WebElement ele= driver.findElement(By.xpath("(//img[@src='themes/softed/images/user.PNG'])[1]"));
			wLib.mouseMoveOnElemet(driver, ele);
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
		
		

	}

}
