package com.comcast.crm.POM.orgTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.Loginpage;
import com.comcast.crm.ORutility.OrganizationInformationPage;
import com.comcast.crm.ORutility.OrganizationsPage;
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
		
//=========================================navigate to application=================================
		
						WebDriverUtility wLib= new WebDriverUtility();
	
						driver.manage().window().maximize();
						wLib.waitForPageToLoad(driver);
		
		
		
		// STEP2:=======LOGIN TO APPLICATION
						driver.get(URL);
						Loginpage lp= new Loginpage(driver);
						lp.loginToApp(USERNAME, PASSWORD);
		
		// STEP3:=======NAIGATE TO ORGANIZATION and Create organization
						
						HomePage hp= new HomePage(driver);
						hp.getOrglink().click();
						
						OrganizationsPage orgpage= new OrganizationsPage(driver);
						orgpage.getOrgImg().click();
		
						
		
		//STEP4:=======ENTER ALL THE DETAILS AND CREATE NEW ORGANIZATION==============================
		
						CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
						cnop.createOrg(org_name);

		
		// STEP6==============verify header message Expected result
		
						OrganizationInformationPage orginfopage= new OrganizationInformationPage(driver);
						String actorgInfo=orginfopage.getHeaderMsg().getText();
							if(actorgInfo.contains(org_name))
							{
								System.out.println(org_name +"\t"+ "name is verifed==PASS===");
							}
							else
							{
								System.out.println(org_name + "  "+ "name is not verifed==FAIL===");
							}
			
		// STEP8:======= SIGNOUT APPLICATION==============================
	
						hp.logout();
						driver.quit();
	
		

	}

}
