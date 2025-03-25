package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_PacticeTest {
	
	
	@Test(dataProvider = "testdata")
	public void priceinfoTest(String brandName, String productName) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		
		String av="//span[text()='"+productName+"']/../../../../div[3]/div/div/div/div/div/a/span/span[2]/span[2]";
			
		 String price = driver.findElement(By.xpath(av)).getText();
		System.out.println(price);
		
		driver.quit();
		
		
		
	}
		
		@DataProvider()
		public Object[][] testdata()
		{
			
			Object [][] objArr= new Object[3][2];
			
			objArr[0][0]="samsung";
			objArr[0][1]="Samsung Galaxy A05 (Silver, 6GB, 128GB Storage) | 50 MP Main Camera | Upto 12GB RAM with RAM Plus | MediaTek Helio G85 | 5000 mAh Battery";
			
			objArr[1][0]="samsung";
			objArr[1][1]="Samsung Galaxy M35 5G (Daybreak Blue,8GB RAM,128GB Storage)| Corning Gorilla Glass Victus+| AnTuTu Score 595K+ | Vapour Cooling Chamber | 6000mAh Battery | 120Hz Super AMOLED Display| Without Charger";
			
			objArr[2][0]="samsung";
			objArr[2][1]="Samsung Galaxy M35 5G (Daybreak Blue,6GB RAM,128GB Storage)| Corning Gorilla Glass Victus+| AnTuTu Score 595K+ | Vapour Cooling Chamber | 6000mAh Battery | 120Hz Super AMOLED Display| Without Charger";
			
			return objArr;
		}
		
		
		
	

}
