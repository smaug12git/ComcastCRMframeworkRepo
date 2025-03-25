package practice.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRM {
	
	@Test
	public void HRMtest() throws InterruptedException
	{
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	OrangePOM OP= new OrangePOM(driver);
	    OP.loginToApp();
	    OP.AddEmployee();
	    Thread.sleep(3000);
	    
	    String ActEmpID = OP.getEmpID().getText();
	    System.out.println(ActEmpID);
	    
	
	}
	

}
