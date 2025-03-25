package practice.Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;



public class demotestngTEST3  {
	
	@Test (priority=1)
	public void disp()
	{
		Reporter.log("go to payment page===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	
	
	@Test(priority=3)
	public void disp2()
	{
		Reporter.log("complete the payment===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test(priority=2)
	public void disp1()
	{
		Reporter.log("view the Transaction===> " +" Thread ID is: " + Thread.currentThread().getId(), true);
	}


}
