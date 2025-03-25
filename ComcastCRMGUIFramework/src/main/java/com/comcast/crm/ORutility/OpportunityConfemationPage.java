package com.comcast.crm.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityConfemationPage {
WebDriver driver;
	
	public OpportunityConfemationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this); 
	}
	
	
	@FindBy(id="dtlview_Opportunity Name")
	private WebElement oppoName;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	
	
	public WebElement getoppoName()
	{
		return oppoName;
	}
	
	public WebElement getheader()
	{
		return header;
	}
	
	
	
		
	
	

}
