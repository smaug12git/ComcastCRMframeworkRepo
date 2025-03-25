   package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
	
	//=======================waiting Statement====================
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementToPresent(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	          //=====================Window Popup=======================
	
		public void switchToTabOnURL(WebDriver driver, String PartialURL)
		{
			Set<String> ID = driver.getWindowHandles();
			Iterator<String> itr = ID.iterator();
			
				while(itr.hasNext())
				{
					String winID = itr.next();
					driver.switchTo().window(winID);
					
					String actURl = driver.getCurrentUrl();	
					if(actURl.contains(PartialURL))
					{
						break;
					}
				}
		}
	
	
		public void switchToTabOnTitle(WebDriver driver, String PartialTitle)
		{
			Set<String> ID = driver.getWindowHandles();
			Iterator<String> itr = ID.iterator();
			
				while(itr.hasNext())
				{
					String winID = itr.next();
					driver.switchTo().window(winID);
					
					String actURl = driver.getTitle();	
					if(actURl.contains(PartialTitle))
					{
						break;
					}
				}
		}
		
		
		//=============================Alart Popup=========================
		
		public void switchToAlartAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		public void switchToAlartAndCancel(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		
		
	  //===========================frames============
		
		public void switchToFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		
		public void switchToFrame(WebDriver driver, String nameID)
		{
			driver.switchTo().frame(nameID);
		}
		
		
		public void switchToFrame(WebDriver driver, WebElement ele)
		{
			driver.switchTo().frame(ele);
		}
		
		
		public void switchToParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		
		public void switchToMainFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
	
	
	//=====================================Dropdown====================================
		
		public void selectBasedOnIndex(WebElement ele, int index)
		{
			Select s= new Select(ele);
			s.selectByIndex(index);
		}
		
		public void selectBasedText(WebElement ele, String Text)
		{
			Select s= new Select(ele);
			s.selectByVisibleText(Text);
			
		}
		
		public void selectBasedValue(WebElement ele, String value)
		{
			Select s= new Select(ele);
			s.selectByVisibleText(value);
			
		}
	
		
		//===================================Actions class(mouse action and keyboard action)====================
	
		public void mouseMoveOnElemet(WebDriver driver, WebElement ele)
		{
			Actions act= new Actions(driver);
			act.moveToElement(ele).perform();
		}
		
		public void mouseRightClick(WebDriver driver, WebElement ele)
		{
			Actions act= new Actions(driver);
			act.contextClick(ele).perform();
		}
		
		public void mouseDoubleClick(WebDriver driver, WebElement ele)
		{
			Actions act= new Actions(driver);
			act.doubleClick(ele).perform();
		}
		
		public void mouseDragAndDrop(WebDriver driver, WebElement source, WebElement target)
		{
			Actions act= new Actions(driver);
			act.dragAndDrop(source, target).perform();
		}
		
		public void mouseClickAndHold(WebDriver driver, WebElement source, WebElement target)
		{
			Actions act= new Actions(driver);
			act.clickAndHold(source).moveToElement(target).click().perform();
		}
		
		
		
		
		
	
		
	
	//=============================Screenshot===================================
		
		public void getScreenShotOfWebPage(WebDriver driver, String path ) throws Throwable
		{
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File dest= new File(path);
			FileHandler.copy(source, dest);
			
			}
		
		public void getSceenShotOfWebElement(WebElement ele, String path) throws Throwable
		{
			File source = ele.getScreenshotAs(OutputType.FILE);
			File dest= new File(path);
			FileHandler.copy(source, dest);
		}
	
		//======================================JavascriptExecutor==============================
		
		public void GetElementByID(WebDriver driver, String id, String elevalue)             
		{
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("document.getElementById("+id+").value="+ elevalue +";");
		}
		
		
		public void GetElementByTagnName(WebDriver driver, String tagname, String elevalue)             
		{
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("document.getElementByTagName("+tagname+").value="+ elevalue +";");
		}
		
		public void ClickOnElement(WebDriver driver, WebElement ele)
		{
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();",ele);
		}
		
		public void PassValueIntoElement(WebDriver driver, WebElement ele,String elevalue)
		{
			JavascriptExecutor j=(JavascriptExecutor) driver;
			j.executeScript("arguments[0].value="+elevalue+";",ele);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
