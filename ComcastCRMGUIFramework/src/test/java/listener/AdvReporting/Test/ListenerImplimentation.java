package listener.AdvReporting.Test;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplimentation implements ISuiteListener,ITestListener {
	
	String Test_name=null;
	ExtentReports reports;
	ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		String d = new Date().toString().replace(" ", "_").replace(":", "_");
		
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvReportNew/report_"+d+".html");
				spark.config().setDocumentTitle("Report Of ORG and CONTACT Test");
				spark.config().setReportName("SampleTest of Org and Contact");
				spark.config().setTheme(Theme.DARK);
				
		 reports = new ExtentReports();
				reports.attachReporter(spark);
				reports.setSystemInfo("OS", "WIN-10");
				reports.setSystemInfo("Browser", "Chrome");
				reports.getReport();
				
		
	}
 
	@Override
	public void onFinish(ISuite suite) {
		
		reports.flush();
		
	}
	
	
	

	@Override
	public void onTestStart(ITestResult result) {
		
		Test_name = result.getMethod().getMethodName();
		System.out.println(Test_name +"===>" +"  Test execution STARTED");
		
		 test = reports.createTest(Test_name);
		 test.assignDevice("HP-Pailion");
		 test.assignAuthor("Sanu");
		 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println(Test_name +"===>"+"  Test execution SUCCESS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(Test_name +"===>"+"  Test execution FAIL");
		
		TakesScreenshot ts= (TakesScreenshot) BASECLASS.driver;
		String source = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(source, Test_name);
		test.log(Status.FAIL, "orgTEST");
		test.log(Status.FAIL, "contactTest");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	
	

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	

}
