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

public class CreateOrgWithPhoneNoTest {

	public static void main(String[] args) throws IOException {
		
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
		String org_name = eLib.getDataFromExcel("Sheet2", 4, 2).toString() + randomNum;
		String phone_no = eLib.getDataFromExcel("Sheet2", 7, 3).toString();
		
//		FileInputStream fis1= new FileInputStream("./files/test data.xls");
//		Workbook book = WorkbookFactory.create(fis1);
//		Sheet sh = book.getSheet("Sheet2");
//		String org_name = sh.getRow(4).getCell(2).toString() + r1;
//		String phone_no = sh.getRow(7).getCell(3).getStringCellValue() ;
		
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
		driver.findElement(By.id("phone")).sendKeys(phone_no);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		// verify phone no
		
		String act_phoneNo = driver.findElement(By.id("dtlview_Phone")).getText();
		if(act_phoneNo.equals(phone_no)) {
			System.out.println(act_phoneNo +"data is verified === PASS======");
		}
		else
		{
			System.out.println(act_phoneNo +"data is  not verified === FAIL======");
		}
		
		
		
		// signout
		
		WebElement ele= driver.findElement(By.xpath("(//img[@src='themes/softed/images/user.PNG'])[1]"));
		
		wLib.mouseMoveOnElemet(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	
	

	}

}
