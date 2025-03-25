package practice;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.Loginpage;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DPaspropertiesifle extends  Baseclass{
	
	@Test(dataProvider = "testdata")
	public void CreateOrgTest(String URL,String USERNAME,String PASSWORD ) throws Throwable
	{
		

//===============launch different browsers==============================
		
		driver.get("http://49.249.28.218:8888/");
		
		WebDriverUtility wLib= new WebDriverUtility();
		
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
// STEP2:=======LOGIN TO APPLICATION

		driver.get(URL);
		Loginpage lp= new Loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

	}
	
	
	@DataProvider
	public Object[][] testdata() throws Throwable, Throwable
		{
		
//		Properties p=new Properties();
//		p.load( new FileInputStream("./configAppData/commondata.properties"));
		
		JSONParser j= new JSONParser();
		Object obj = j.parse(new FileReader("./configAppData/applicationcommondata.json"));
		JSONObject jobj=(JSONObject) obj;
		
		Object [][] objarr = new Object[1][2];
		
		objarr[0][0]=jobj.get("username");
		objarr[0][1]=jobj.get("password");;
		
		
		return objarr;
		
		
		}	
		
		
	}

