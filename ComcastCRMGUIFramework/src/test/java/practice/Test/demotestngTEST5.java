package practice.Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demotestngTEST5 {
	
	@Test
	public void disp()
	{
		Reporter.log("go to setting===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp1()
	{
		Reporter.log("change the name of account===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp2()
	{
		Reporter.log("change the Dp of the account===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	


}
