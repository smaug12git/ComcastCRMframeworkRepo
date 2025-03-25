package practice.Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demotestngTEST4 {
	
	@Test
	public void disp()
	{
		Reporter.log("search a product===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp1()
	{
		Reporter.log("add to wishlist====>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	@Test
	public void disp2()
	{
		Reporter.log("remove from wishlist===>" +" Thread ID is: " + Thread.currentThread().getId(), true);
	}
	
	


}
