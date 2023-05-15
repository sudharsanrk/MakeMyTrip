package PomPages;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Flights {

	@FindBy (xpath = "html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/button[1]")
	private WebElement CloseButoon;
	
	@FindBy (xpath = "(//button[contains(@class,'ViewFareBtn  ')])[1]")
	private WebElement ViewPricesButton;
	
	@FindBy (xpath = "(//button[text()='Book Now'])[1]")
	private WebElement BookingButton;
	
	
	public Flights(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Close(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(8000);
		CloseButoon.click();	
	}
	
	public void ViewPrices()
	{
		ViewPricesButton.click();
	}

	public void Booking(WebDriver driver) throws InterruptedException, IOException 
	{
		BookingButton.click();
		
	}
	
	
}
