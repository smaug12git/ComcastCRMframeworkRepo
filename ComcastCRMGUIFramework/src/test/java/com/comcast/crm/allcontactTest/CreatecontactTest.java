package com.comcast.crm.allcontactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.ContactInformationPage;
import com.comcast.crm.ORutility.ContactsPage;
import com.comcast.crm.ORutility.CreateNewContactPage;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OrgPopUpPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreatecontactTest extends Baseclass {

	@Test(groups="SmokeTest")
	public void createContact() throws EncryptedDocumentException, IOException {
		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber(); // generating random number

		ExcelUtility eLib = new ExcelUtility();
		String last_name = eLib.getDataFromExcel("Sheet3", 1, 2).toString() + randomNum; // getting data from excel

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click(); // click on contact link

		ContactsPage cp = new ContactsPage(driver);
		cp.getOrgImg().click();
		CreateNewContactPage ccp = new CreateNewContactPage(driver); // click on contact img link and enter last name
		ccp.createContact(last_name);
		ContactInformationPage cip = new ContactInformationPage(driver); // verify last name
		String actualheader = cip.getContactheader().getText();

		if (actualheader.contains(last_name)) {
			System.out.println(actualheader + " is present ====PASS=======");
		} else {
			System.out.println(actualheader + " is not present ====FAIL=======");
		}

		String actlastname = cip.getLstname().getText();
		if (actlastname.trim().equals(last_name)) {
			System.out.println(actlastname + " is present ====PASS=======");
		} else {
			System.out.println(actlastname + " is not present ====FAIL=======");
		}

	}

	@Test(groups= "RegressionTest")
	public void createContactwithOrgTest() throws EncryptedDocumentException, IOException {

		JavaUtility jLib = new JavaUtility(); //// generating random number
		int randomNum = jLib.getRandomNumber();

		ExcelUtility eLib = new ExcelUtility(); //// getting data from excel
		String last_name = eLib.getDataFromExcel("Sheet3", 1, 2).toString() + randomNum;

		String start_date = jLib.getSystemDate(); // getting sys start date and end date
		String end_date = jLib.getReqiuredDate(30);

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getOrgImg().click();
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(last_name, start_date, end_date);

		ContactInformationPage cip = new ContactInformationPage(driver);

		String actStrtdate = cip.getStrtdate().getText(); // verification

		if (actStrtdate.trim().equals(start_date)) {
			System.out.println(actStrtdate + " " + "is verified====PASS====");
		} else {
			System.out.println(actStrtdate + " " + "is not verified====FAIL====");
		}
		String actEnddate = cip.getEnddate().getText();

		if (actEnddate.trim().equals(end_date)) {
			System.out.println(actEnddate + " " + "is verified====PASS====");
		} else {
			System.out.println(actEnddate + " " + "is not verified====FAIL====");
		}

	}

	@Test(groups ="RegressionTest")
	public void createContactwithsupportdateTest()
			throws EncryptedDocumentException, IOException, InterruptedException {

		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber();

		ExcelUtility eLib = new ExcelUtility();
		String org_name = eLib.getDataFromExcel("Sheet3", 7, 2).toString() + randomNum;
		String lastname = eLib.getDataFromExcel("Sheet3", 7, 3).toString();

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(org_name);

		Thread.sleep(3000);              // for create contact link 

		HomePage hp1 = new HomePage(driver);
		hp1.getContactlink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getOrgImg().click();

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactwithORG(lastname);

		wlib.switchToTabOnURL(driver, "module=Accounts");     // switch to child window

		OrgPopUpPage op = new OrgPopUpPage(driver);
		op.orgpopup(org_name);
		driver.findElement(By.xpath("//a[text()='" + org_name + "']")).click();

		wlib.switchToTabOnURL(driver, "module=Contacts");    // switch back to paent window

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		ContactInformationPage cip = new ContactInformationPage(driver);      // verification
		String actContactHeader = cip.getContactheader().getText();
		if (actContactHeader.trim().contains(lastname)) {
			System.out.println(actContactHeader + " " + "is verified====Pass=========");
		} else {
			System.out.println(actContactHeader + " " + "is not verified====fail=========");
		}

		String actPopupOrgName = cip.getPopOrgname().getText();
		if (actPopupOrgName.trim().equals(org_name)) {
			System.out.println(actPopupOrgName + " " + "is verified====Pass=========");
		} else {
			System.out.println(actPopupOrgName + " " + "is not verified====FAIL=========");
		}

	}

}
