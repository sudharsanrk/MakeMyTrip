package Genriclib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PomPages.CompleteBooking;
import PomPages.ProceedPay;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass extends Libaries {
	public WebDriver driver;
	public ExtentHtmlReporter htmlreport;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	
	
	 @BeforeSuite
     public void bs()
     {
      htmlReporter = new ExtentHtmlReporter("./reports/testReport.html");
      htmlReporter.config().setDocumentTitle("Make My Trip");
	    htmlReporter.config().setTheme(Theme.DARK);
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
     }
	
	@BeforeMethod
	public void OpenApp() 
	{
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
	}
	
	
	@AfterMethod
	public void  Closeapp(ITestResult res) throws IOException, InterruptedException
	{
    
		
		CompleteBooking cp = new CompleteBooking(driver);
		cp.NoLetMeChoose();
		cp.Continue();
			
	    ProceedPay pay = new ProceedPay(driver);
	    pay.ProceedPayButton();
	    
	    int result = res.getStatus();
		
		if (result==ITestResult.SUCCESS)
			{
			   test.log(Status.PASS, "Test Case is Pass");
			   test.log(Status.PASS,res.getThrowable()+  "Test Case is Pass");
				
			}
			
			else if (result==ITestResult.FAILURE)
			{
		        test.log(Status.FAIL,"Test Case is Fail");
		        
	       test.log(Status.FAIL,res.getThrowable()+  "Test Case is fail");
	      
			}
			
			driver.quit();
		}

@AfterSuite
public void as()
{
	 extent.flush();
}
	

}

