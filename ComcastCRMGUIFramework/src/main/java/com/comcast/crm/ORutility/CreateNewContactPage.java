package com.comcast.crm.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	
    //=======================initialization===========================
		     WebDriver driver;
			public CreateNewContactPage(WebDriver driver)
				{
					this.driver=driver;
					PageFactory.initElements(driver,this);   
				}
			
			
			//==================storing all elements of login page using @FindBy================
			
			@FindBy(name="lastname")
			private WebElement lstname;
			
			@FindBy(name="support_start_date")
			private WebElement strtDate;
			
			@FindBy(name="support_end_date")
			private WebElement endDate;
			
			@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
			private WebElement addorgICON;
			
			
			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement savebtn;
			
			
			//================== Providing Only Getters() method===================
			
			public WebElement getLstname() {
				return lstname;
			}

			public WebElement getSavebtn() {
				return savebtn;
			}
			
			public WebElement getStrtDate() {
				
				return strtDate;
			}

			public WebElement getEndDate() {
				
				return endDate;
			}
			
			public WebElement addORG() {
				return addorgICON;
			}
			
			
			
			
			
			//=================================Business Lib===============================
			
			

			public void createContact(String lastname)
			{
				lstname.sendKeys(lastname);
				savebtn.click();
			}
			
			public void createContact(String lastname, String sdate, String edate)
			{
				lstname.sendKeys(lastname);
				strtDate.clear();
				strtDate.sendKeys(sdate);
				endDate.clear();
				endDate.sendKeys(edate);
				savebtn.click();
				
			}
			
			public void createContactwithORG(String lastname)
			{
				lstname.sendKeys(lastname);
				addorgICON.click();
				
				

			}
			
			
			
			
			
			
			
			
			
			
			
			
			

}
