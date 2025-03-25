package practice.Test;

	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BASEclassUtility.Baseclass;
	import com.comcast.crm.ORutility.CreateNewOrganizationPage;
	import com.comcast.crm.ORutility.HomePage;
	import com.comcast.crm.ORutility.OrganizationInformationPage;
	import com.comcast.crm.ORutility.OrganizationsPage;
	import com.comcast.crm.generic.fileutility.ExcelUtility;
	import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerUtility.ListeneImp;

@Listeners(com.comcast.crm.listenerUtility.ListeneImp.class)
	public class CreateContactTestExtentReport  extends Baseclass{

		@Test (groups = "SmokeTest")
		public void OrgTest() throws EncryptedDocumentException, IOException {

			UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");
			 // 
			JavaUtility jLib = new JavaUtility();     
			int randomNum = jLib.getRandomNumber();
			
			UtilityClassObject.getTest().log(Status.INFO, " getting data om excel sheet");
			 // getting data om excel sheet
			ExcelUtility eLib = new ExcelUtility();  
			String org_name = eLib.getDataFromExcel("Sheet2", 1, 2) + randomNum;
			
			UtilityClassObject.getTest().log(Status.INFO, "creating org ");

			  //creating org 
			HomePage hp = new HomePage(driver);           
			hp.getOrglink().click();
			OrganizationsPage orgpage = new OrganizationsPage(driver);
			orgpage.getOrgImg().click();
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createOrg(org_name);
			
			UtilityClassObject.getTest().log(Status.INFO, org_name+ "created organization page successully ");

			
			  // verification
			OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver);  
			String actorgInfo = orginfopage.getHeaderMsg().getText();
			
			boolean orgInfo_verify = actorgInfo.contains(org_name);
			Assert.assertTrue(orgInfo_verify);
		}

		@Test(groups = "RegressionTest")
		public void OrgwithPhoneNum() throws Throwable, IOException {

			  //geneating random no
			JavaUtility jLib = new JavaUtility();    
			int randomNum = jLib.getRandomNumber();
	 
			 // fetching data om excel
			ExcelUtility eLib = new ExcelUtility();   
			String org_name = eLib.getDataFromExcel("Sheet2", 4, 2).toString() + randomNum;
			String phone_no = eLib.getDataFromExcel("Sheet2", 7, 3).toString();
			
			  // creating og with contact
			HomePage hp = new HomePage(driver);          
			hp.getOrglink().click();
			OrganizationsPage orgpage = new OrganizationsPage(driver);  
			orgpage.getOrgImg().click();
			CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);  
			cnp.createOrg(org_name, phone_no);
			
			// verification
			
			OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver); 
			String actorgInfo = orginfopage.getHeaderMsg().getText();
			boolean orgInfo_verify = actorgInfo.contains(org_name);
			Assert.assertTrue(orgInfo_verify);

		}

		@Test(groups = "RegressionTest")
		public void OrgwithIndustry() throws Throwable, IOException {
			
			// generating andom numbers
			JavaUtility jLib = new JavaUtility();    
			int randomNum = jLib.getRandomNumber();
			
			// getting data om excel
			ExcelUtility eLib = new ExcelUtility();
			String org_name = eLib.getDataFromExcel("Sheet2", 1, 2) + randomNum;   
			String industry_name = eLib.getDataFromExcel("Sheet2", 4, 3).toString();
			String industry_type = eLib.getDataFromExcel("Sheet2", 4, 4).toString();
			
			 // create org with industry
			HomePage hp = new HomePage(driver);               
			hp.getOrglink().click();
			OrganizationsPage orgpage = new OrganizationsPage(driver);
			orgpage.getOrgImg().click();
			CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
			cnp.createOrg(org_name, industry_name, industry_type);

		//  verification
			OrganizationInformationPage orginfo = new OrganizationInformationPage(driver); 
			
			String actIndustry = orginfo.getIndustry().getText();
			boolean Industry_verify = actIndustry.equals(industry_name);
			SoftAssert soft= new SoftAssert();
			soft.assertTrue(Industry_verify);
			
			String actIndustryType = orginfo.getIndustrytype().getText();
			boolean IndustryType_verify = actIndustryType.equals(org_name);
			soft.assertTrue(IndustryType_verify);
			
			soft.assertAll();
			
			
			

		}
	}



