package com.comcast.crm.ALLorgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OrganizationInformationPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrgTest extends Baseclass {

	@Test (groups = "SmokeTest")
	public void OrgTest() throws EncryptedDocumentException, IOException {

		

		JavaUtility jLib = new JavaUtility();      // geneating random numbes
		int randomNum = jLib.getRandomNumber();
		
		ExcelUtility eLib = new ExcelUtility();   // getting data om excel sheet
		String org_name = eLib.getDataFromExcel("Sheet2", 1, 2) + randomNum;

		HomePage hp = new HomePage(driver);             //creating org 
		hp.getOrglink().click();
		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click();
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(org_name);

		OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver);    // verification
		String actorgInfo = orginfopage.getHeaderMsg().getText();
		if (actorgInfo.contains(org_name)) {
			System.out.println(org_name + "\t" + "name is verifed==PASS===");
		} else {
			System.out.println(org_name + "  " + "name is not verifed==FAIL===");
		}
	}

	@Test(groups = "RegressionTest")
	public void OrgwithPhoneNum() throws Throwable, IOException {

		// ==============================================

		JavaUtility jLib = new JavaUtility();      //geneating random no
		int randomNum = jLib.getRandomNumber();
 
		ExcelUtility eLib = new ExcelUtility();    // fetching data om excel
		String org_name = eLib.getDataFromExcel("Sheet2", 4, 2).toString() + randomNum;
		String phone_no = eLib.getDataFromExcel("Sheet2", 7, 3).toString();

		HomePage hp = new HomePage(driver);            // creating og with contact
		hp.getOrglink().click();
		OrganizationsPage orgpage = new OrganizationsPage(driver);  //POM OR
		orgpage.getOrgImg().click();
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);   //POM OR
		cnp.createOrg(org_name, phone_no);

		OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver); //POM OR   // verification

		String actorgInfo = orginfopage.getHeaderMsg().getText();

		if (actorgInfo.contains(org_name)) {
			System.out.println(org_name + "\t" + "name is verifed==PASS===");
		} else {
			System.out.println(org_name + "  " + "name is not verifed==FAIL===");
		}

	}

	@Test(groups = "RegressionTest")
	public void OrgwithIndustry() throws Throwable, IOException {
		
		JavaUtility jLib = new JavaUtility();    // generating andom numbers
		int randomNum = jLib.getRandomNumber();

		ExcelUtility eLib = new ExcelUtility();
		String org_name = eLib.getDataFromExcel("Sheet2", 1, 2) + randomNum;   // getting data om excel
		String industry_name = eLib.getDataFromExcel("Sheet2", 4, 3).toString();
		String industry_type = eLib.getDataFromExcel("Sheet2", 4, 4).toString();
		
		HomePage hp = new HomePage(driver);                // create org with industry
		hp.getOrglink().click();
		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click();
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrg(org_name, industry_name, industry_type);

		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver); //  verification
 
		String actIndustry = orginfo.getIndustry().getText();
		if (actIndustry.equals(industry_name)) {
			System.out.println(actIndustry + "is  verifed====PASS=====");
		} else {
			System.out.println(actIndustry + "is not verifed====FAIL=====");
		}

		String actIndustryType = orginfo.getIndustrytype().getText();
		if (actIndustryType.equals(industry_type)) {
			System.out.println(actIndustryType + " " + "is  verifed====PASS=====");
		} else {
			System.out.println(actIndustryType + " " + "is not verifed====FAIL=====");

		}

	}
}
