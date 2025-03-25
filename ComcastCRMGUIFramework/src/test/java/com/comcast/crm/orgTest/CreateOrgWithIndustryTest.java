package com.comcast.crm.orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgWithIndustryTest {

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
		String org_name = eLib.getDataFromExcel("Sheet2", 1, 2) + randomNum;
		String industry_name =eLib.getDataFromExcel("Sheet2", 4, 3).toString();
		String industry_type =eLib.getDataFromExcel("Sheet2", 4, 4).toString();
//		
//		FileInputStream fis1= new FileInputStream("./files/test data.xls");
//		Workbook book = WorkbookFactory.create(fis1);
//		Sheet sh = book.getSheet("Sheet2");
//		String org_name = sh.getRow(4).getCell(2).toString() + r1;
//		String industry_name = sh.getRow(4).getCell(3).toString() ;
//		String industry_type = sh.getRow(4).getCell(4).toString() ;
		
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
		
		Select s= new Select(driver.findElement(By.name("industry")));
		s.selectByVisibleText(industry_name);
		Select s1= new Select(driver.findElement(By.name("accounttype")));
		s1.selectByVisibleText(industry_type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		// verify industry and type
		
		String act_industry_name = driver.findElement(By.id("mouseArea_Industry")).getText();
		if(act_industry_name.equals(industry_name)) {
			System.out.println(act_industry_name+"data is pesent === PASS======");
		}
		else
		{
			System.out.println(act_industry_name+"data is  not pesent === FAIL======");
		}
		
		String act_industry_type = driver.findElement(By.id("dtlview_Type")).getText();
		if(act_industry_type.equals(industry_type)) {
			System.out.println(act_industry_type+"data is pesent === PASS======");
		}
		else
		{
			System.out.println(act_industry_type+"data is  not pesent === FAIL======");
		}
		
		// signout
		
		WebElement ele= driver.findElement(By.xpath("(//img[@src='themes/softed/images/user.PNG'])[1]"));
		wLib.mouseMoveOnElemet(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
