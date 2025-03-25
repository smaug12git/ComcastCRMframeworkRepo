package practice;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OrganizationInformationPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrgTest extends Baseclass {
	
	
						
	@Test(dataProvider = "DPasExcel", dataProviderClass = DATAProvide.class)
	public void createOrgTest(String sheetname, int rowNum, int cellNum) throws Throwable, IOException 
	{
		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber();

		ExcelUtility eLib = new ExcelUtility();
		String org_name = eLib.getDataFromExcel(sheetname, rowNum, cellNum) + randomNum;

		//CREATE ORG
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(org_name);

		// VERIFY
		OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver);
		String actorgInfo = orginfopage.getHeaderMsg().getText();
		if (actorgInfo.contains(org_name)) {
			System.out.println(org_name + "\t" + "name is verifed==PASS===");
		} else {
			System.out.println(org_name + "  " + "name is not verifed==FAIL===");
		}

	}

}
