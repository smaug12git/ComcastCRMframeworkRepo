package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class POMBasic_crm_login {
	
	@FindBy(name="user_name")
	private WebElement un;
	
	@FindBy(name="user_password")
	private WebElement psw;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	@Test
	public void loginTest()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		
		POMBasic_crm_login pf = PageFactory.initElements(driver, POMBasic_crm_login.class);
		pf.un.sendKeys("admin");
		pf.psw.sendKeys("admin");
		pf.loginbtn.click();
		
	}
	
	

}
