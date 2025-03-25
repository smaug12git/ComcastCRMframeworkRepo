package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProvider_withloop_PacticeTest1 {
	
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
		
		@DataProvider(parallel = true)
		public Object[][] testdata() throws Throwable
		{
			ExcelUtility elib =new ExcelUtility();
			
			int rowcount = elib.getRowCount("mobileinfo");
			int cellCount = elib.getCellCount("mobileinfo", rowcount);
			
			Object [][] objarr= new Object[rowcount][cellCount];
			
			for(int i=0;i<rowcount;i++)
			{
				for(int j=0;j<cellCount;j++)
				{
			objarr[i][j]=elib.getDataFromExcel("mobileinfo", i+1, j);
			
			
			}
			}
			return objarr;
		}	
		
	

}
