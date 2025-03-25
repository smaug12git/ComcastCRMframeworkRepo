package practice.Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demotestngTEST6 {
	
	@Test
	public void disp()
	{
		Reporter.log("go to dashboard====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp1()
	{
		Reporter.log("go to kids section====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp2()
	{
		Reporter.log("buy something====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	


}
