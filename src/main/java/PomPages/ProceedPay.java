package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedPay {

	
	@FindBy (xpath = "//button[text()='Proceed to pay']")
	private WebElement ProceedPayButton;
	
	
public ProceedPay (WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void ProceedPayButton() throws InterruptedException
	{
		ProceedPayButton.click();
		Thread.sleep(8000);
	}
	
	
	
}


