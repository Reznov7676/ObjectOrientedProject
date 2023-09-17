package Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.Page;



public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	Calendar cal= Calendar.getInstance();
	Date t = cal.getTime();
	String timeStamp = t.toString();
	SoftAssert softAssert = new SoftAssert();
	
	@Parameters({"browser"})
	@BeforeMethod
	
	public void setup(String browser) {
		
//		driver = new ChromeDriver();
//		  
//
//		  driver.manage().deleteAllCookies();
//		  driver.manage().window().maximize();
//		  wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		  driver.get("https://www.saucedemo.com/");
//		  page = new Page(driver , wait);
		  
	    if(browser.equals("chrome")){
		  
		  
			  driver = new ChromeDriver();
			  driver.manage().deleteAllCookies();
			  driver.manage().window().maximize();
			  wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			  driver.get("https://www.saucedemo.com/");
			  page = new Page(driver , wait);

	}
	    
	    if(browser.equals("safari")){
	        driver = new SafariDriver();
	        driver.manage().deleteAllCookies();
	        driver.manage().window().maximize();
			  driver.get("https://www.saucedemo.com/");
			  page = new Page(driver , wait);
	     
	   }
	}
	
	@DataProvider(name="getdata")
public Object[][] testdata(){
		
		Object p[][]= {{"standard_user","secret_sauce"}};
		return p;
	
	
}
	
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	@AfterMethod
	public void takescreenshot(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			
			
			
            // Take a screenshot of the element
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Copy the screenshot to a desired location (e.g., a folder)
            FileUtils.copyFile(screenshotFile, new File("/Users/jaymaldikar/eclipse-workspace/ObjectOrientedProject/Screenshots/First" +timeStamp+".png"));
		}
		
		 
		driver.quit();
		
	}
	
}
