package practice;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


public class Baseclass {
	
	
	public FileUtility flib= new FileUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public DataBaseUtility dblib= new DataBaseUtility();
	public JavaUtility jlib= new JavaUtility();
	 public static WebDriver driver= null;
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void beforesuit()
	{
		System.out.println("============DB connection=====");
		dblib.getDBconnection();
	}
	
	@BeforeTest(groups = {"SmokeTest","RegressionTest"})
	public void beforetest()
	{
		
	}
	
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	public void beforeclass() throws IOException
	{
		System.out.println("=====launch Browser=========");
				
				String BROWSER = flib.getDatafromPropertiesFile("browser");
				
				if(BROWSER.equals("chorme"))
						{
							driver= new ChromeDriver();
						}
				else if(BROWSER.equals("firefox"))
						{
							driver= new FirefoxDriver();
						}
				else
				{
					driver= new ChromeDriver();
				}
				
	}	  
				
		@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
		public void loginpage() throws Throwable
		{
			System.out.println("======login to application=========");
			
			String URL = flib.getDatafromPropertiesFile("url");
			String USERNAME = flib.getDatafromPropertiesFile("username");
			String PASSWORD = flib.getDatafromPropertiesFile("password");
			
			driver.get(URL);
			Loginpage lp= new Loginpage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
		}
		
		
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void aftermethod()
	{
		System.out.println("=====LOGOUT O APPLICATION=======");
    HomePage hp= new HomePage(driver);
		hp.logout();
		
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void afterclass()
	{
		
		driver.quit();
	}
	

	@AfterTest(groups = {"SmokeTest","RegressionTest"})
	public void aftertest()
	{
		
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void aftersuit() throws SQLException
	{
		dblib.closeDBconnection();
	}

}
