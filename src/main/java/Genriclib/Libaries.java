package Genriclib;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class Libaries 
{
	public WebDriver driver;
	 
	

	public void Scrollbar(WebElement ele) throws InterruptedException
	{
		
		Point loc=ele.getLocation();
		int X = loc.getX();
		int Y = loc.getY();
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy("+X+"+"+Y+")");
		 
		Thread.sleep(10000);
		}
	
	public String PropertiesFile (String ele) throws IOException
	{
		Properties pro = new Properties();
        FileInputStream file = new FileInputStream(Address.propertiesfile);
        pro.load(file);
        return   pro.getProperty(ele);

	
	}
	public void ScreenShort(WebDriver driver) throws IOException
	{
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
	    File fs = new File(Address.Photopath);
        FileUtils.copyFile(file, fs);
	}
	
	@DataProvider
	public  Object dataexcel() throws EncryptedDocumentException, IOException
	
	{
		FileInputStream file=new FileInputStream(Address.Excelfilepath);
     	 Workbook wb=WorkbookFactory.create(file);
	    Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		short colum = sheet.getRow(1).getLastCellNum();
		
	Object obj[][]=	new Object[row][colum];
	for (int i=0;i<row;i++)
	{
	 for (int j=0;j<colum;j++)
	 {
		 String s = sheet.getRow(i+1).getCell(j).getStringCellValue();
		 obj[i][j]=s;
	 }
	
	}return obj;
	
	}
	
	
	
}
