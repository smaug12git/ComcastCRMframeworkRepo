package practice.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BASEclassUtility.Baseclass;

@Listeners(com.comcast.crm.listenerUtility.ListeneImp.class) // used to monitor the test execution in runtime and generate runtime events
public class InvoiceTEST extends Baseclass {
	
		@Test
		public void createInvoiceTest()
		{
			System.out.println("execute createInvoiceTest");
			String actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, "login");
			System.out.println("Step==1");
			System.out.println("Step==2");
			System.out.println("Step==3");
			System.out.println("Step==4");
		}
		
		@Test
		public void createInvoicewithContactTest()
		{
			System.out.println("execute createInvoicewithContactTest");
		}

}
