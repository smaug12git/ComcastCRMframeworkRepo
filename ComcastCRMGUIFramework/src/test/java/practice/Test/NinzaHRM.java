package practice.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NinzaHRM {
	@Test
	public void NinzaTest() throws EncryptedDocumentException, IOException
	{
		WebDriver  driver= new ChromeDriver();
		driver.get("http://49.249.28.218:8091/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		/*fetching data om excel*/
		FileInputStream fis= new FileInputStream("./TestData/test data.xls");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("ninza");
		 String projectName = sh.getRow(1).getCell(0).toString();
		 String projectManager = sh.getRow(1).getCell(1).toString();
		 String projectstatus = sh.getRow(1).getCell(2).toString();
		
		/*login to app*/
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/* naigate to module */
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys(projectManager);
		WebElement Projectstat = driver.findElement(By.xpath("//option[.='Select Value']/parent::select[@name='status']"));
		Select s = new Select(Projectstat) ;
		s.selectByVisibleText(projectstatus);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		/*anothe module*/
		
		driver.findElement(By.xpath("//a[.='Employees']")).click();
		driver.findElement(By.xpath("//span[.='Add New Employee']")).click();
		
		/*reading data from excel */
		
		 String Name = sh.getRow(4).getCell(0).toString();
		 String email = sh.getRow(4).getCell(1).toString();
		 String phoneNo = sh.getRow(4).getCell(2).toString();
		 String userName = sh.getRow(4).getCell(3).toString();
		 String desig = sh.getRow(4).getCell(4).toString();
		 String exp = sh.getRow(4).getCell(5).toString();
		 String project = sh.getRow(4).getCell(6).toString();
		 
		 
		 driver.findElement(By.xpath("//label[.='Name*']/following-sibling::input")).sendKeys(Name);
		 driver.findElement(By.xpath("//label[.='Email*']/following-sibling::input")).sendKeys(email);
		 driver.findElement(By.xpath("//label[.='Phone*']/following-sibling::input")).sendKeys(phoneNo);
		 driver.findElement(By.xpath("//label[.='Username*']/following-sibling::input")).sendKeys(userName);
		 driver.findElement(By.xpath("//label[.='Designation*']/following-sibling::input")).sendKeys(desig);
		 driver.findElement(By.xpath("//label[.='Experience*']/following-sibling::input")).sendKeys(exp);
		 WebElement projectDD = driver.findElement(By.xpath("//select[@name='project']"));
		 Select s1= new Select(projectDD);
		 s1.selectByVisibleText(project);
		 
		 driver.findElement(By.xpath("//select[@name='project']")).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);
		 
		 
		 /*verify*/
		 String name_verify = driver.findElement(By.xpath("//td[.='"+Name+"']")).getText();
		 boolean verifying = name_verify.equals(Name);
	 Assert.assertTrue(verifying);
		 
		 
//		 boolean confermation = driver.findElement(By.xpath("//div[.='User laopadpa Successfully Created']")).isDisplayed();
//		 Assert.assertTrue(confermation);
//		
		driver.quit();
		
	}

}
