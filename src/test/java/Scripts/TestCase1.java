package Scripts;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import Genriclib.Baseclass;
import PomPages.CompleteYourBooking;
import PomPages.Flights;
import PomPages.HomePage;


public class TestCase1 extends Baseclass{
	
	@Test(dataProvider = "dataexcel")
	public void tc1(String name,String last,String phone,String emailid) throws IOException, InterruptedException, AWTException 
	{
		test = extent.createTest("tc1");
		HomePage Ho = new HomePage(driver);
		Ho.From(driver);
		Ho.TO();
		Ho.Chennai(driver);
		Ho.Next(driver);
		Ho.Date(driver);		
		Ho.Search();
		
		
		Flights fl = new Flights(driver);
		Thread.sleep(8000);
	    fl.Close(driver);
	    fl.ViewPrices();
		fl.Booking(driver);
		
		
		CompleteYourBooking co = new CompleteYourBooking(driver);
	   co.sendelemts(driver, name, last, phone, emailid);
	
		}

}
