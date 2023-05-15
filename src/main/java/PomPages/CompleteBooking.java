package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteBooking {
	
	@FindBy (xpath = "//button[text()='Yes, Please']")
	private WebElement YesPleaseElemnts;
	
	@FindBy (xpath = "//button[text()='Continue']")
	private WebElement ContinueButton;
	
	@FindBy (xpath = "//button[text()='CONTINUE ANYWAY']")
	private WebElement ContinueAnyWayButton;
	
	
     public  CompleteBooking (WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void NoLetMeChoose() throws InterruptedException
	{
		Thread.sleep(7000);
		YesPleaseElemnts.click();
	}
	
	
	public void Continue() throws InterruptedException
	{  
		Thread.sleep(8000);
		ContinueButton.click();
		Thread.sleep(8000);
		ContinueButton.click();
		Thread.sleep(8000);
	}
	
	public void ContinueAnyWay() throws InterruptedException
	{
		ContinueAnyWayButton.click();
		Thread.sleep(8000);
	}
	
	

}
