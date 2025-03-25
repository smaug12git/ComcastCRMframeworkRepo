package listener.AdvReporting.Test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.Loginpage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BASECLASS {
	
				DataBaseUtility dlib= new DataBaseUtility();
				ExcelUtility elib= new ExcelUtility();
				FileUtility flib=  new FileUtility();
				JavaUtility jlib= new JavaUtility();
				WebDriverUtility wlib= new WebDriverUtility();
				public static WebDriver driver;
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("===executed before Suite====");
	}
	

	@BeforeTest
		public void configBT()
		{
			System.out.println("===executed before Test====");
		}
	
	@BeforeClass
	public void configBC() throws IOException
		{
			System.out.println("===executed before Class====");
				
				String BROWSER = flib.getDatafromPropertiesFile("browser");
				
					if(BROWSER.equals("chrome")) {
						driver= new ChromeDriver(); 
					}
					else if(BROWSER.equals("firefox")){
						driver= new FirefoxDriver();
					}
					else if(BROWSER.equals("edge")){
						driver= new EdgeDriver();
					}
					else {
					driver= new ChromeDriver();
					}
		}
	
	@BeforeMethod
	public void configBM() throws IOException
	{
		System.out.println("===executed before Method====");
		
				wlib.waitForPageToLoad(driver);
				
				String USERNAME = flib.getDatafromPropertiesFile("username");
				String PASSWORD = flib.getDatafromPropertiesFile("password");
				String URL = flib.getDatafromPropertiesFile("url");
				driver.get(URL);
				Loginpage lp= new Loginpage(driver);
					lp.loginToApp(USERNAME, PASSWORD);
				
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("===executed after Method====");
				
				HomePage hp= new HomePage(driver);
					hp.logout();
				
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("===executed after Class====");
		
				driver.quit();
	} 
	
	@AfterTest
	public void configAT()
	{
		System.out.println("===executed after Test====");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("===executed after Suite====");
	}
	
	

}
