package practice.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EXTAAAAAAAAAAAAAAAA {

	@Test
	public void test() {

		String Actname = null;
		String actprice = null;

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles", Keys.ENTER);

		String x1 = "//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']";

		List<WebElement> all_name = driver.findElements(By.xpath(x1));
		System.out.println("total name of product" + all_name.size());

		for (WebElement name : all_name) {
			Actname = name.getText();
			System.out.println(Actname);
		}

		String x = "//span[@class='a-price-whole']";

		List<WebElement> all_element = driver.findElements(By.xpath(x));

		System.out.println("total no of product::" + all_element.size());

		for (WebElement ele : all_element) {
			actprice = ele.getText();
			System.out.println(actprice);
		}

		driver.quit();
	}
}
