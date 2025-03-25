package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProvider_withloop_PacticeTest {
	
	WebDriver driver=null;

	@Test(dataProvider = "testdata")
	public void priceinfoTest(String brandName, String productName) throws InterruptedException
	{
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(7000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		
		String av="//span[text()='"+productName+"']/../../../../div[3]/div/div/div/div/div/a/span/span[2]/span[2]";
			
		 String price = driver.findElement(By.xpath(av)).getText();
		System.out.println(price);
		
		driver.quit();
		
		
		
	}
		
		@DataProvider
		public Object[][] testdata() throws Throwable
		{
			ExcelUtility elib =new ExcelUtility();
			int rowcount = elib.getRowCount("mobileinfo");
			
			Object [][] objarr= new Object[rowcount][2];
			
			for(int i=0;i<rowcount;i++)
			{
			objarr[i][0]=elib.getDataFromExcel("mobileinfo", i+1, 0);
			objarr[i][1]=elib.getDataFromExcel("mobileinfo", i+1, 1);
			
			}
			
		return objarr;
		
		}	
		
	

}
