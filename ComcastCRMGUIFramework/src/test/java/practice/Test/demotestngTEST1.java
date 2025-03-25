package practice.Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;


public class demotestngTEST1 
{
	
	@Test
	public void disp()
	{
		Reporter.log("signup=====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp1()
	{
		Reporter.log("login====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp2()
	{
		Reporter.log("Homepage====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	


}
