package com.comcast.crm.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {       //===============================Rule 1: create sepeate java class===========
	
	
	
	//===============================  Rule3: initialization==============
	
								WebDriver driver;
								public Loginpage(WebDriver driver)
								{
									this.driver=driver;
									PageFactory.initElements(driver,this);    // pagefactory.initElements(driver, Loginpage.class);
								}
	
	//=============Rule 2: Object Creation //======storing all elements of login page using @FindBy==========
	                            
								@FindBy(name="user_name")
								private WebElement un;
	
								@FindBy(name="user_password")
								private WebElement psw;
	
								@FindBy(id="submitButton")
								private WebElement clickbtn;
	
	
	// ===================Rule :4 object encapsulation and getters methods(use when single action is required)======================
	
								public WebElement getusename()
								{
									return un;
								}
	
								public WebElement getpassword()
								{
									return psw;
								}
	
								public WebElement getloginbtn()
								{
									return clickbtn;
								}
	
	
	//========================== Rule 5:business Lib(use when multiple action is requied ) / provides action
	
								public void loginToApp(String userName, String passWord)
								{
								
									un.sendKeys(userName);
									psw.sendKeys(passWord);
									clickbtn.click();
								}
								
	
	
	
	
	
	
	
	
	

}
