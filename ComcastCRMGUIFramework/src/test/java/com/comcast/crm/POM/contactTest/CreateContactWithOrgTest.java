package com.comcast.crm.POM.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ORutility.ContactInformationPage;
import com.comcast.crm.ORutility.ContactsPage;
import com.comcast.crm.ORutility.CreateNewContactPage;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.Loginpage;
import com.comcast.crm.ORutility.OrgPopUpPage;
import com.comcast.crm.ORutility.OrganizationsPage;
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
				String lastname = eLib.getDataFromExcel("Sheet3", 7, 3).toString();
				
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
				
				
				
				
				// STEP2:=======LOGIN TO APPLICATION
				driver.get(URL);
				Loginpage lp= new Loginpage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				// STEP3:=======NAIGATE TO ORGANIZATION
				
				HomePage hp= new HomePage(driver);
				hp.getOrglink().click();
				
				OrganizationsPage orgpage= new OrganizationsPage(driver);
				orgpage.getOrgImg().click();
				
				CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
				cnop.createOrg(org_name);
				
			Thread.sleep(4000);	
			
				// NAVIGATE TO CONTACT
				HomePage hp1= new HomePage(driver);
				hp1.getContactlink().click();
				
				ContactsPage cp= new ContactsPage(driver);
				cp.getOrgImg().click();
				
				CreateNewContactPage ccp= new CreateNewContactPage(driver);
				ccp.createContactwithORG(lastname);
				
	//================ switch to CHILD window
				
				wLib.switchToTabOnURL(driver, "module=Accounts");
				
//======================OrgPopUp handling=====================
				
				OrgPopUpPage op= new OrgPopUpPage(driver);
//					
				     op.orgpopup(org_name);
					driver.findElement(By.xpath("//a[text()='"+org_name+"']")).click();
					
//=====================naigate back to PARENT window and Save
					wLib.switchToTabOnURL(driver, "module=Contacts");
					
					driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				
// =========================verify OrgHeader and Orgname
					
					ContactInformationPage cip= new ContactInformationPage(driver);
					String actContactHeader = cip.getContactheader().getText();
						if(actContactHeader.trim().contains(lastname))
						{
							System.out.println(actContactHeader +" "+"is verified====Pass=========");
						}
						else
						{
							System.out.println(actContactHeader +" "+"is not verified====fail=========");
						}
						
						
						String actPopupOrgName = cip.getPopOrgname().getText();
						if(actPopupOrgName.trim().equals(org_name))
						{
							System.out.println(actPopupOrgName+" "+"is verified====Pass=========");
						}
						else
						{
							System.out.println(actPopupOrgName+" "+"is not verified====FAIL=========");
						}
				

						// signout
						
								hp.logout();
								driver.quit();
					
					
						
						
				
				
	}

}
