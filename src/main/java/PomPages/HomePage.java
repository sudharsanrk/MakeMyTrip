package PomPages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {

	@FindBy (xpath = "//a[@class='close']")
	private WebElement CloseIcon;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement FromTextField;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")
	private WebElement ToTextField;
	
	@FindBy (xpath = "//span[@class='ic_circularclose_grey'")
	private WebElement CloseButton ;
	
	@FindBy (xpath = "(//p[text()='21'])[1]")
	private WebElement DateElements;
	
	@FindBy (xpath = "//a[text()='Search']")
	private WebElement SearchButton;
	
	
	@FindBy (xpath = "//div[text()='MAA']")
	private WebElement ChennaiElement;
	
	@FindBy (xpath = "(//span[@role='button'])[2]")
	private WebElement NextButton;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Close()
	{
		CloseButton.click();
	}
	
	public void From(WebDriver driver) throws InterruptedException
	{
		
		FromTextField.click();
	}
	
	public void TO()
	{
		ToTextField.click();
	}
	
	public void Date(WebDriver driver)
	{

		JavascriptExecutor date=(JavascriptExecutor) driver;
		date.executeScript("arguments[0].click()", DateElements);
	}
	
	public void Search()
	{
		SearchButton.click();
	}
	
	public void Chennai(WebDriver driver)
	{
		JavascriptExecutor che=(JavascriptExecutor) driver;
		che.executeScript("arguments[0].click()", ChennaiElement);
	}
	
	
	public void Next(WebDriver driver)
	{
		JavascriptExecutor nex=(JavascriptExecutor) driver;
		
		for (int i=0;i<=5;i++)
		{
			nex.executeScript("arguments[0].click()", NextButton);
		}
	}
	
}
