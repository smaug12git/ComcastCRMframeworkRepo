package com.comcast.crm.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPopUpPage {
	
	
	//=======================initialization===========================
			WebDriver driver;
			public OrgPopUpPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver,this);   
			}
			
			
			 //==================storing all elements of login page using @FindBy================

			
			
			@FindBy(id="search_txt")
			private WebElement search;
			
			@FindBy(name="search")
			private WebElement searchbtn;
			
			
			
			//=====================Getters()============
			
			public WebElement getSearch() {
				return search;
			}

			public WebElement getSearchbtn() {
				return searchbtn;
			}
			
			
			
			
			//=======================Business class
			
			public void orgpopup(String orgname)
			{
				search.sendKeys(orgname);
				searchbtn.click();
			}
			
			
			

}
