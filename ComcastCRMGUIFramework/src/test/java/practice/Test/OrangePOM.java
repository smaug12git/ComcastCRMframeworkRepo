package practice.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangePOM {
	
			WebDriver driver;
	public OrangePOM(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements( driver,this);
	}
	
	
	/*login page elements*/
	@FindBy(name = "username")
	private WebElement user_name;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login_save_btn;
	
	/* homepage elements*/
	@FindBy(xpath = "//span[.='PIM']")
	private WebElement PIM_btn;
	
	@FindBy(xpath = "//a[.='Add Employee']")
	private WebElement AddEmp_btn;
	
	@FindBy(name = "firstName")
	private WebElement first_name;
	
	@FindBy(name = "lastName")
	private WebElement last_name;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save_btn;
	

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement empID;
	
	@FindBy(xpath = "//a[.='Employee List']")
	private WebElement empList;
	
	/*verify*/
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement empIDverify;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchbtn;
	
	
	
	
	/*==========================getter methods===================================*/
	
	public WebElement getUser_name() {
		return user_name;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin_save_btn() {
		return login_save_btn;
	}
	
	

	public WebElement getPIM_btn() {
		return PIM_btn;
	}

	public WebElement getFirst_name() {
		return first_name;
	}

	public WebElement getLast_name() {
		return last_name;
	}
	
	public WebElement click_save() {
		return save_btn;
	}

	public WebElement getAddEmp_btn() {
		return AddEmp_btn;
	}

	public WebElement getEmpID() {
		return empID;
	}
	
	public WebElement getEmplist() {
		return empList;
	}
	
	public WebElement verifyEmpID() {
		return empIDverify;
	}
	
	public WebElement getsearchbtn() {
		return searchbtn;
	}
	
	
	
	
	/* ==================business lib==============================*/
	
	
	/*login to application*/
	public void loginToApp()
	{
		user_name.sendKeys("Admin");
		password.sendKeys("admin123");
		login_save_btn.click();
	}
	
	/*adding an employee*/
	public void AddEmployee()
	{
		PIM_btn.click();
		AddEmp_btn.click();
		first_name.sendKeys("SAM");
		last_name.sendKeys("A");
		
		
	
	}
	
	/*search employee*/
	
	public void verifyEmp(String id)
	{
		empIDverify.sendKeys(id);
		searchbtn.click();
		
	}

	
	
	
	

}
