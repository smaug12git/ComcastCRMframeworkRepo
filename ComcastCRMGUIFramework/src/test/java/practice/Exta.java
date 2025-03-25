package practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Exta {

	public static void main(String[] args) throws Throwable {

		/*
		 * { Date dObj= new Date();
		 * 
		 * SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd"); String date =
		 * s.format(dObj); System.out.println(date);
		 * 
		 * 
		 * 
		 * SimpleDateFormat s1= new SimpleDateFormat("yyyy-MM-dd");
		 * 
		 * Calendar cal = s1.getCalendar(); cal.add(Calendar.DAY_OF_MONTH, 30); String
		 * requiedDate = s1.format(cal.getTime()); System.out.println(requiedDate);
		 * 
		 * 
		 * }
		 */

		/*
		 * WebDriver driver= new ChromeDriver();
		 * 
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * 
		 * FileUtility fLib= new FileUtility(); WebDriverUtility wLib= new
		 * WebDriverUtility();
		 * 
		 * driver.get(fLib.getDatafromPropertiesFile("url"));
		 * driver.findElement(By.name("user_name")).sendKeys("admin");
		 * driver.findElement(By.name("user_password")).sendKeys("admin");
		 * 
		 * wLib.ClickOnElement(driver, driver.findElement(By.id("submitButton")));
		 * 
		 * driver.findElement(RelativeLocator.with(By.xpath(
		 * "//img[@src='themes/softed/images/tbarChat.gif']"))
		 * .toLeftOf(By.xpath("//img[@src='themes/softed/images/btnL3Tracker.gif']"))).
		 * click();
		 * 
		 * driver.findElement(RelativeLocator.with(By.xpath(
		 * "//img[@src='themes/softed/images/tbarChat.gif']"))
		 * .toLeftOf(By.xpath("//img[@src='themes/softed/images/btnL3Tracker.gif']"))).
		 * click();
		 */

		// open shadowehost element

//		/*
//		 * WebDriver driver= new ChromeDriver();
//		 * 
//		 * driver.manage().window().maximize();
//		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		 * driver.get("https://demoapps.qspiders.com/ui?scenario=1");
//		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		 * 
//		 * 
//		 * driver.findElement(By.xpath("//section[.='Shadow Root Elements']")).click();
//		 * driver.findElement(By.xpath("//section[.='Shadow Root']")).click();
//		 * 
//		 * 
//		 * SearchContext shadowHost1
//		 * =driver.findElement(By.xpath("//div[@class='my-3']")).getShadowRoot();
//		 * 
//		 * shadowHost1.findElement(By.cssSelector("input[type='text']")).sendKeys(
//		 * "hiiii");
//		 *
//		 * 
//		 * SearchContext shadowHost2 =
//		 * driver.findElement(By.xpath("(//div[@class='my-3'])[2]")).getShadowRoot();
//		 * shadowHost2.findElement(By.cssSelector("input[type='text']")).sendKeys(
//		 * "byeeee");
//		 */

		// close shadowHost element
		
		
		/*
		 * WebDriver driver= new ChromeDriver();
		 * 
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * 
		 * 
		 * driver.findElement(By.xpath("//section[.='Shadow Root Elements']")).click();
		 * driver.findElement(By.xpath("//section[.='Shadow Root']")).click();
		 * 
		 * driver.findElement(By.linkText("Close Shadow Root")).click();
		 * 
		 * driver.findElement(By.xpath("//h1[.='Login']")).click(); Actions act= new
		 * Actions(driver); act.sendKeys(Keys.TAB).perform();
		 * 
		 * 
		 */
		
		
		
		FirefoxDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	
//		Robot r= new Robot();
//		r.keyPress(KeyEvent.VK_ACCEPT);
//		r.keyRelease(KeyEvent.VK_ACCEPT);
//		driver.switchTo().alert();
//		
//		driver.get("https://demowebshop.tricentis.com/");
//		
//		TakesScreenshot t= (TakesScreenshot) driver;
//		File s = driver.getFullPageScreenshotAs(OutputType.FILE);
//		File f= new File("./TestData/ullhomepage.jpeg");
//		FileHandler.copy(s, f);
		
		
		Actions act= new Actions(driver);
		act.click(driver.findElement(By.id("small-searchterms"))).keyDown(Keys.CONTROL).sendKeys("a");
		
		
//		ChromeOptions c= new ChromeOptions();
//		c.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		
		
		

	}

}
