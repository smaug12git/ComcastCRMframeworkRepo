package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_PacticeTest1 {
	
	
	@Test
	public void priceinfoTest() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(6000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String av="//span[text()='Samsung Galaxy A05 (Silver, 6GB, 128GB Storage) | 50 MP Main Camera | Upto 12GB RAM with RAM Plus | MediaTek Helio G85 | 5000 mAh Battery']/../../../../div[3]/div/div/div/div/div/a/span/span[2]/span[2]";
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung",Keys.ENTER);
		String price = driver.findElement(By.xpath(av)).getText();
		System.out.println(price);
		
	

}
}