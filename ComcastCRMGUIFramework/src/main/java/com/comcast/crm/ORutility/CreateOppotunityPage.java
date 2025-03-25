package com.comcast.crm.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOppotunityPage {
	
	WebDriver driver;
	
	public CreateOppotunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	
	@FindBy(name="potentialname")
	private WebElement oppoptunutyName;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement reletedToImg;
	
	
	
	@FindBy(name="assigned_user_id")
	private WebElement assignedDD;
	
	@FindBy(name="closingdate")
	private WebElement closeDate;
	
	@FindBy(name="sales_stage")
	private WebElement salesStageDD;
	
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	
	
	public WebElement getoppoptunutyName()
	{
		return oppoptunutyName;
	}
	
	public WebElement getreletedToImg()
	{
		return reletedToImg;
	}
	
	
	public WebElement getassignedDD()
	{
		return assignedDD;
	}
	
	public WebElement getcloseDate()
	{
		return closeDate;
	}
	
	public WebElement salesStageDD()
	{
		return salesStageDD;
	}
	
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
			
	
	// business method
	
	
	
	public void assignedDD(String opt)
	{
			Select s= new Select(assignedDD);
			s.selectByVisibleText(opt);
					
	}
	
	public void salesStagesDD(String st)
	{
			Select s= new Select(salesStageDD);
			s.selectByVisibleText(st);
					
	}
	
	public void expectedcloseDate(String date)
	{
		closeDate.clear();
		closeDate.sendKeys(date);
	}
	
	
	
	
	
	

}
