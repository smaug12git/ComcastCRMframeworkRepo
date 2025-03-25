package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.degrees;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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


public class ListeneImp implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("report coniguration");

		// spark report  config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		spark = new ExtentSparkReporter("./AdvanceReoprt/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test suite result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome111");

	}

	public void onFinish(ISuite suite) {
		System.out.println("report backup");

		report.flush();

	}

	public void onTestStart(ITestResult result) {
		System.out.println("=========" + result.getMethod().getMethodName() + "======START======");

		test = report.createTest(result.getMethod().getMethodName());// to ceate test case inside extent report

		UtilityClassObject.setTest(test);
		
		test.log(Status.INFO, result.getMethod().getMethodName() + "=====STARTED=======");

		test.assignAuthor("SANU");
		test.assignCategory("ContactTest");
		test.assignDevice("HP Pavilion ");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=========" + result.getMethod().getMethodName() + "======END======");
		test.log(Status.PASS, result.getMethod().getMethodName() + "=====COMPLETED=======");

	}

	public void onTestFailure(ITestResult result) {

		// ScreenShot
//		EventFiringWebDriver eDriver= new EventFiringWebDriver(Baseclass.sdriver);
//		File source = eDriver.getScreenshotAs(OutputType.FILE);
//		String time = new Date().toString().replace(" ", "_").replace(":", "_");
//		try {
//			FileUtils.copyFile(source, new File("./TestData/"+testName+"+"+time+".jpeg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String testName = result.getMethod().getMethodName();
		TakesScreenshot sc = (TakesScreenshot) Baseclass.sdriver;
		String filepath = sc.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);

		test.log(Status.FAIL, result.getMethod().getMethodName() + "=====FAILED=======");

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
