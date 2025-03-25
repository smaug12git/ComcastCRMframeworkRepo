package practice.Test;

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
import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpandExtentForOrgTest implements ISuiteListener,ITestListener {
	
				public ExtentSparkReporter spark;
				public static ExtentReports reports;
				public static ExtentTest test ;
				
	public void onStart(ISuite suite)
	{
		
	
		
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		 spark= new ExtentSparkReporter("./EXT/repo_"+date+".html");
		spark.config().setDocumentTitle("xyz");
		spark.config().setReportName("bunny");
		spark.config().setTheme(Theme.DARK);
		
		 reports= new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("os", "win10");
	}
	
	public void onFinish(ISuite suite)
	{
		reports.flush();
	}
	
	public void onTestStart(ITestResult result)
	{
		
		test = reports.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, "Test Start");
	} 
	
	public void onTestSuccess(ITestResult result)
	{
		
	}
	
	public void onTestFailue(ITestResult result)
	{
		
		String testname = result.getMethod().getMethodName();
		
		TakesScreenshot ts= (TakesScreenshot) Baseclass.sdriver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(path,testname+"_"+date);		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
