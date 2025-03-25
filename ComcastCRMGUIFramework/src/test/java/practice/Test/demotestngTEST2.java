package practice.Test;

//import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;



public class demotestngTEST2  {
	
	@Test
	public void disp()
	{
	//Assert.fail();
		
		Reporter.log("Search a product====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test                                    //(dependsOnMethods = "disp()")
	public void disp1()
	{
		Reporter.log("add a product===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test                                //(enabled= false)
	public void disp2()
	{
		Reporter.log("buy the product=====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	


}
