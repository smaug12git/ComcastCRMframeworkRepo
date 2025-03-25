package com.comcast.crm.POM.contactTest;

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
						ccp.createContact(last_name);
		
	  //STEP5:=================veriy contact header and last name
		
						ContactInformationPage cip= new ContactInformationPage(driver);
						String actualheader = cip.getContactheader().getText();
						
						if(actualheader.contains(last_name)) {
							System.out.println(actualheader +" is present ====PASS=======");
						}
						else {
							System.out.println(actualheader +" is not present ====FAIL=======");
						}
						
						
					String actlastname = cip.getLstname().getText();
						if(actlastname.trim().equals(last_name)) {
							System.out.println(actlastname +" is present ====PASS=======");
						}
						else {
							System.out.println(actlastname +" is not present ====FAIL=======");
						}
		
					
						// signout
						
						hp.logout();
						driver.quit();
		
	}
		
	}


