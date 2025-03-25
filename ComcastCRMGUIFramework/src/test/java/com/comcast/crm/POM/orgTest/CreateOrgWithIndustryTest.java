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
		
		
// STEP2:=======LOGIN TO APPLICATION========================

		driver.get(URL);
		Loginpage lp= new Loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

// STEP3:=======NAIGATE TO ORGANIZATION and Create organization=======================
		
						HomePage hp= new HomePage(driver);
						hp.getOrglink().click();
						
						OrganizationsPage orgpage= new OrganizationsPage(driver);
						orgpage.getOrgImg().click();
						
		
		
// STEP4:=======ENTER ALL THE DETAILS AND CREATE NEW ORGANIZATION=====================
						
							CreateNewOrganizationPage  cnp= new CreateNewOrganizationPage(driver);
							cnp.createOrg(org_name, industry_name, industry_type);
							
//STEP5: =================verify industry and type==================
		
							OrganizationInformationPage orginfo= new OrganizationInformationPage(driver);
							
							String actIndustry = orginfo.getIndustry().getText();
							if (actIndustry.equals(industry_name))
							{
								System.out.println(actIndustry + "is  verifed====PASS=====");
							}
							else
							{
								System.out.println(actIndustry + "is not verifed====FAIL=====");
							}
							
							String actIndustryType = orginfo.getIndustrytype().getText();
							if (actIndustryType.equals(industry_type))
							{
								System.out.println(actIndustryType +" "+ "is  verifed====PASS=====");
							}
							else
							{
								System.out.println(actIndustryType +" " +"is not verifed====FAIL=====");
							}
		
		
		// =======================signout
		
							hp.logout();
							driver.quit();
		
		
	}

}
