package com.comcast.crm.POM.contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ORutility.ContactInformationPage;
import com.comcast.crm.ORutility.ContactsPage;
import com.comcast.crm.ORutility.CreateNewContactPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.Loginpage;
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
		 System.out.println(start_date);
		 
		 String end_date =jLib.getReqiuredDate(30);
		 System.out.println(end_date);
		
		
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
		
		

// STEP2:=======LOGIN TO APPLICATION
				driver.get(URL);
				Loginpage lp= new Loginpage(driver);
				lp.loginToApp(USERNAME, PASSWORD);

// STEP3:=======NAIGATE TO contact
				
						HomePage hp= new HomePage(driver);
						hp.getContactlink().click();
						
						ContactsPage cp= new ContactsPage(driver);
						cp.getOrgImg().click();

//STEP4:=======ENTER ALL THE DETAILS AND CREATE NEW Contact
						
						CreateNewContactPage ccp= new CreateNewContactPage(driver);
						ccp.createContact(last_name, start_date, end_date);
						
//STEP5:======verify Start date=================
		
						ContactInformationPage cip= new ContactInformationPage(driver);
						 
							String actStrtdate = cip.getStrtdate().getText();
							
							if(actStrtdate.trim().equals(start_date))
							{
								System.out.println(actStrtdate+" "+ "is verified====PASS====");
							}
							else
							{
								System.out.println(actStrtdate+" "+ "is not verified====FAIL====");
							}
						
							
							//======verify enddate date=================
							String actEnddate = cip.getEnddate().getText();
							
							if(actEnddate.trim().equals(end_date))
							{
								System.out.println(actEnddate +" "+"is verified====PASS====");
							}
							else
							{
								System.out.println(actEnddate+" "+ "is not verified====FAIL====");
							}
						
		
			// signout
			
							hp.logout();
							driver.quit();
		
		
		

	}

}
