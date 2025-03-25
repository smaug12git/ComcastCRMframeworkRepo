package com.comcast.crm.ORutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	//=======================initialization===========================
	
							WebDriver driver;
							public HomePage(WebDriver driver)
							{
								this.driver=driver;
								PageFactory.initElements(driver,this);   
							}
	
	//==================storing all elements of login page using @FindBy================
	
								@FindBy(linkText = "Organizations")
								private WebElement orglink;
								
								@FindBy(linkText = "Contacts")
								private WebElement contactlink;
								
								@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
								private WebElement adminimg;
								
								@FindBy(xpath = "//a[.='Sign Out']")
								private WebElement signoutlink;
								
								@FindBy(xpath = "(//a[.='Opportunities'])[1]")
								private WebElement opportunitylink;
								
								
	
	//================== Proiding Only Getters() method===================
	
								public WebElement getOrglink() {
									return orglink;
								}
							
								public WebElement getContactlink() {
									return contactlink;
								}
								
								public WebElement getOpportunitylink()
								{
									return opportunitylink;
								}
								

								public WebElement getsignout()
								{
									return adminimg;
								}
								
								public WebElement getsignoutlink()
								{
									return signoutlink;
								}
								
								
								
								
								public void logout()
								{
									Actions a= new Actions(driver);
									a.moveToElement(adminimg).perform();
									signoutlink.click();
								}
								
								
	
	

}
