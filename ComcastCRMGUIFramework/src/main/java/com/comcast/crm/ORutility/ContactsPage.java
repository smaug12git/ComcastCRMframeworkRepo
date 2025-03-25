package com.comcast.crm.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	
	//=======================initialization===========================
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);   
	}
	
	
	
	//==================storing all elements of login page using @FindBy================
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") //themes/softed/images/btnL3Add.gif
	private WebElement contactimg;
	
	
	
	
	//================== Proiding Only Getters() method===================
		
	public WebElement getOrgImg() {
		return contactimg ;
	
	}
	

}
