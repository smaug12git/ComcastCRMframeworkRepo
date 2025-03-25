package practice.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OrganizationInformationPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

@Listeners(com.comcast.crm.listenerUtility.ListeneImp.class)
//@Listeners(practice.Test.ListenerImpandExtentForOrgTest.class)
public class CreateOrgwithListenerANDExtent  extends Baseclass{
	
	@Test 
	public void OrgTest() throws EncryptedDocumentException, IOException {

		
		JavaUtility jLib = new JavaUtility();     
		int randomNum = jLib.getRandomNumber();
		
		
		ExcelUtility eLib = new ExcelUtility();  
		String org_name = eLib.getDataFromExcel("Sheet3", 1, 2) + randomNum;
		
		HomePage hp = new HomePage(driver);           
		hp.getOrglink().click();
		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click(); 
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(org_name);
		
		OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver);  
		String actorgInfo = orginfopage.getHeaderMsg().getText();
		
		boolean orgInfo_verify = actorgInfo.contains(org_name);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(orgInfo_verify);
	}
		@Test(groups = "RegressionTest")
		public void OrgwithIndustry() throws Throwable, IOException {
			
			// generating andom numbers
			JavaUtility jLib = new JavaUtility();    
			int randomNum = jLib.getRandomNumber();
			
			// getting data om excel
			ExcelUtility eLib = new ExcelUtility();
			String org_name = eLib.getDataFromExcel("Sheet3", 1, 2) + randomNum;   
			String industry_name = eLib.getDataFromExcel("Sheet3", 4, 3).toString();
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
			boolean IndustryType_verify = actIndustryType.equals(industry_type);
			soft.assertEquals(IndustryType_verify,"hii");
			
		
		soft.assertAll();
		
		

}
}
