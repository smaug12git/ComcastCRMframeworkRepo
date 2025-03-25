package com.comcast.crm.OppertunityTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.CreateOppotunityPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OpportunityConfemationPage;
import com.comcast.crm.ORutility.OpportunityPage;
import com.comcast.crm.ORutility.OppotunityPopupPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOppoptunityWithOrgTest extends Baseclass {
	
		@Test
		public void CreateOppetunityTest() throws Throwable, IOException
		{
			
			//random no
			
			JavaUtility jlib= new JavaUtility();
				int Rno = jlib.getRandomNumber();
				
				//getdata from excel
				
			ExcelUtility elib= new ExcelUtility();
				String OppoName =  elib.getDataFromExcel("Sheet5", 1,1).toString()+Rno;
				System.out.println(OppoName);
				String Orgname = elib.getDataFromExcel("Sheet3",1,2).toString()+Rno;
				System.out.println(Orgname);
				
				// org
				
				HomePage hp = new HomePage(driver);           
				hp.getOrglink().click();
				OrganizationsPage orgpage = new OrganizationsPage(driver);
				orgpage.getOrgImg().click();
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createOrg(Orgname);
				
				Thread.sleep(3000);

				// oppertunity
				hp.getOpportunitylink().click();
				
				OpportunityPage op= new OpportunityPage(driver);
					op.getopportunityImg().click();
				CreateOppotunityPage cop= new CreateOppotunityPage(driver);
					cop.getoppoptunutyName().sendKeys(OppoName);
					cop.getreletedToImg().click();
					
					//switch to child browser
					
					WebDriverUtility wlib= new WebDriverUtility();
					wlib.switchToTabOnURL(driver,"module=Accounts");
					
					OppotunityPopupPage opp= new OppotunityPopupPage(driver);
					opp.getsearchtxtifeld().sendKeys(Orgname);
					opp.getsearchBtn().click();
					
					driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
					
					// parent
					wlib.switchToTabOnURL(driver,"module=Potential");
					
				
					 cop.getsaveBtn().click();
					 
					 //verify
					 
					 OpportunityConfemationPage ocp= new OpportunityConfemationPage(driver);
					 
					 String act_Header = ocp.getheader().getText();
					 boolean Verify_Header = act_Header.contains(OppoName);
					 
					 Assert.assertTrue(Verify_Header);
			
		}
		
		
	

}
