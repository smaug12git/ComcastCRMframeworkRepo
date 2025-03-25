package practice.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProductnameWithPrice {
	
	@Test
	
	public void getProductWithPrice()
	{
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles", Keys.ENTER);

		String x1 = "//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']/span";

		List<WebElement> all_name = driver.findElements(By.xpath(x1));
		System.out.println("total name of product :===>" + all_name.size());
				for(WebElement name:all_name)
				{
					System.out.println( name.getText());
				}
				
				String x = "//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']/../../following-sibling::div[1]//span[@aria-hidden='true']";
				List<WebElement> all_price = driver.findElements(By.xpath(x));
				System.out.println("total name of product :===>" + all_price.size());
				for(WebElement price:all_price)
				{
					System.out.println(price.getText());
				}
				driver.quit();
		
	}

}
