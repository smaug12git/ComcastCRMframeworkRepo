package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		List<WebElement> eles = driver.findElements(By.xpath("//a[@class='hmenu-item']/../following-sibling::li"));
		
		for(int i=0;i<eles.size();i++)
		{
			WebElement el = eles.get(i);
			String s = el.getText();
			System.out.println(s);
		}
		                                                                      ////div[@class='hmenu-item hmenu-title ']/../following-sibling::li
		System.out.println("======ok===============");
		driver.quit();

	}
	

}
