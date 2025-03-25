package practice.Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	@Test
	public void createTest()
	{
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		 String filepath = ts.getScreenshotAs(OutputType.BASE64); // sc location 
		 
		//spark report config
      ExtentSparkReporter spark= new ExtentSparkReporter("./TestData/Adv_report.html");
      	spark.config().setDocumentTitle("CRM Test suite result");
      	spark.config().setReportName("CRM Report");
      	spark.config().setTheme(Theme.DARK);
      	
      	//add env information and create test
      ExtentReports report = new ExtentReports();
      report.attachReporter(spark);
      report.setSystemInfo("OS", "Windows-10");
      report.setSystemInfo("Browser", "Chrome111");
      
      ExtentTest test = report.createTest("createTest");
      
      test.log(Status.INFO, "login to app");
      test.log(Status.INFO, "navigate to contact page");
      test.log(Status.INFO, "created contact");
      
      if("hii".equals("hiii"))
      {
    	   test.log(Status.PASS, "contact is created");
      }else {
    	  test.addScreenCaptureFromBase64String(filepath, "errorfile");
      }
     
    report.flush();	
    driver.quit();
	}

	
}
