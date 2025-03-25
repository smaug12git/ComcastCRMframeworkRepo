package practice.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.comcast.crm.listenerUtility.ListeneImp.class) // used to monitor the test execution in runtime and generate runtime events
public class RetryInvoiceTEST  {
	
		@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImp.class)
		public void actieSimcard()
		{
			System.out.println("execute createInvoiceTest");
			
			Assert.assertEquals("", "login");
			System.out.println("Step==1");
			System.out.println("Step==2");
			System.out.println("Step==3");
			System.out.println("Step==4");
		}
		
		

}
