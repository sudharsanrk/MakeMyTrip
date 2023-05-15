package PomPages;





import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Genriclib.Libaries;


public class CompleteYourBooking 
{
	 public Libaries li=new Libaries();
	 

    
	@FindBy  (xpath = "//span[text()='View Fare Rules']")
    private WebElement ViewElements;
	
	@FindBy (xpath = "//button[text()='+ ADD NEW ADULT']")
	private WebElement AddNewAdult;
	
	@FindBy (xpath = "//input[@placeholder='First & Middle Name']")
	private WebElement FirstNameTextField;
	
	@FindBy (xpath = "//input[@placeholder='Last Name']")
	private WebElement LastNameTextField;
	
	@FindBy(xpath = "//label[@tabindex='0']")
	private WebElement MaleButton;
	
	@FindBy(xpath = "//input[@placeholder='Mobile No']")
    private WebElement PhoneNoTextField;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement  EmailTextField;
	
	@FindBy (xpath = "//div[text()='sud@gmail.com']")
	private WebElement EmailDropDownElements;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath = "//button[text()='CONFIRM']")
    private WebElement ConfirmButton;

	
	
	
	
	
	public CompleteYourBooking(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void view(WebDriver driver ) throws InterruptedException, IOException
	{	

       ArrayList<Object> tab = new ArrayList<Object>(driver.getWindowHandles());
       driver.switchTo().window((String) tab.get(1));
       Thread.sleep(8000);
	}
	
	public void AddNew(WebDriver driver) throws InterruptedException
	{
		
		PageFactory.initElements(driver, AddNewAdult);	
		Actions ac= new Actions(driver);
		ac.moveToElement(AddNewAdult).click().perform();
	
	}
	
	public void FirstName() throws IOException   
	{
	FirstNameTextField.sendKeys(li.PropertiesFile("FirstName"));
	}
	
	public void LastName() throws IOException 
	{
		LastNameTextField.sendKeys(li.PropertiesFile("LastName"));
	}
	
	public void Male()
	{
	
		MaleButton.click();
	}
	
	public void PhoneNO() throws IOException 
	{
		PhoneNoTextField.sendKeys(li.PropertiesFile("PhoneNo"));
	}
	
	public void EmailId(WebDriver driver) throws IOException, InterruptedException 
	{
		EmailTextField.sendKeys(li.PropertiesFile("EmailId"));
		Thread.sleep(4000);
	Actions	ac=new Actions(driver);
		ac.moveToElement(EmailDropDownElements).click().perform();
		
	}
	
	public void EmailIdDropDown() throws InterruptedException
	{
		Thread.sleep(4000);
		EmailDropDownElements.click();
		Thread.sleep(4000);
	}
	
	public void Continue()
	{
		ContinueButton.click();
	}
	
	public void Confirm()
	{
		ConfirmButton.click();
	}
	
	public void sendelemts(WebDriver driver,String name,String last,String phone,String emailid) throws InterruptedException, IOException
	{
		view(driver);
		AddNew(driver);
		FirstNameTextField.sendKeys(name);
		LastNameTextField.sendKeys(last);
		Male();
		PhoneNoTextField.sendKeys(phone);
		EmailTextField.sendKeys(emailid);
		
		
		
		
		Thread.sleep(4000);
	Actions	ac=new Actions(driver);
	
		ac.moveToElement(EmailTextField).click().perform();
		Thread.sleep(4000);
		li.ScreenShort(driver);
		Thread.sleep(4000);
		Continue();
		Confirm();
	
		
		
	}
	
	
}
