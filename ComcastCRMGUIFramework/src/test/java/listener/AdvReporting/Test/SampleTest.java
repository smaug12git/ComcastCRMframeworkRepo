package listener.AdvReporting.Test;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ORutility.ContactInformationPage;
import com.comcast.crm.ORutility.ContactsPage;
import com.comcast.crm.ORutility.CreateNewContactPage;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OrganizationInformationPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;


@Listeners(listener.AdvReporting.Test.ListenerImplimentation.class)
public class SampleTest extends BASECLASS {
	
	@Test
	public void orgTest() throws EncryptedDocumentException, IOException
	{
		System.out.println("============ORGTEST EXECUTED=======");
		
				// GENEATING RANDOM NUMBER
				JavaUtility jLib = new JavaUtility();  
				int randomNum = jLib.getRandomNumber();
				
		// GETTING DATA FOM EXCEL SHEET
				ExcelUtility eLib = new ExcelUtility();  
				String org_name = eLib.getDataFromExcel("Sheet3", 1, 2) + randomNum;
				
		//CREATING ORG
				HomePage hp = new HomePage(driver);           
				hp.getOrglink().click();
				OrganizationsPage orgpage = new OrganizationsPage(driver);
				orgpage.getOrgImg().click();
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createOrg(org_name);
				
		// VERIFICATION
				OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver);  
				String actorgInfo = orginfopage.getHeaderMsg().getText();
				
				boolean orgInfo_verify = actorgInfo.contains(org_name);
				Assert.assertEquals(orgInfo_verify,"hiiii");
	}
	 
	@Test
	public void ContactTest() throws EncryptedDocumentException, IOException
	{
		System.out.println("============CONTACTTEST EXECUTED=======");
		
		// GENEATING RANDOM NUMBER
				JavaUtility jLib = new JavaUtility();
				int randomNum = jLib.getRandomNumber();

		// GETTING DATA FOM EXCEL SHEET
				ExcelUtility eLib = new ExcelUtility();
				String last_name = eLib.getDataFromExcel("Sheet3", 1, 2).toString() + randomNum;

		//CREATING CONTACT WITH LAST NAME
				HomePage hp = new HomePage(driver);
				hp.getContactlink().click();
				ContactsPage cp = new ContactsPage(driver);
				cp.getOrgImg().click();
				CreateNewContactPage ccp = new CreateNewContactPage(driver);
				ccp.createContact(last_name);
				ContactInformationPage cip = new ContactInformationPage(driver);

		// VERIFICATION
				String actualheader = cip.getContactheader().getText();
				boolean header_verify = actualheader.contains(last_name);
				Assert.assertTrue(header_verify);

				String actlastname = cip.getLstname().getText();
				boolean name_verify = actlastname.trim().equals(last_name);
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(name_verify,"byyyee");
				
				soft.assertAll();
				

				
	}
	
	@Test
	public void ProductTest()
	{
		System.out.println("============PODUCTTEST EXECUTED=======");
		
		//Date d= new Date();
		//System.out.println(d);
	}
	
	@Test
	public void DocumentsTest()
	{
		System.out.println("============DOCUMENTTEST EXECUTED=======");
	}

}
