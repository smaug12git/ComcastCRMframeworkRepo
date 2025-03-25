package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		
		
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
				String org_name = eLib.getDataFromExcel("Sheet3", 7, 2).toString() +randomNum;
				String contact_lastname = eLib.getDataFromExcel("Sheet3", 7, 3).toString();
				
//			
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
				
				Thread.sleep(3000);
				// naigate to contact
				
				driver.findElement(By.linkText("Contacts")).click();
				
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.name("lastname")).sendKeys(contact_lastname);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				
				
				// switch to CHILD window
				wLib.switchToTabOnURL(driver, "module=Accounts");
//				
//				
				
				driver.findElement(By.name("search_text")).sendKeys(org_name);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[.='"+org_name+"']")).click(); // dynamic xpath
				
				//naigate back to PARENT window
				wLib.switchToTabOnURL(driver, "module=Contacts");
				
			
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				// verify 
				
				String act_header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(act_header.contains(contact_lastname))
				{
					System.out.println(act_header  +"is matching======PASS=====");
				}
				else
				{
					System.out.println(act_header  +"is not matching======FAIL=====");
				}
				
				String act_ogname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				
				if (act_ogname.trim().equals(org_name)) {
					
					System.out.println(org_name+ "is verified====PASS=====");
				}
				else
				{
					System.out.println(org_name+ "is not verified====FAIL=====");
				}
				driver.quit();

	}

}
