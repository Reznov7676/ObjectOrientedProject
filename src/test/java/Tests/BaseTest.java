package Tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
	
	public void setup(String browser) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser jsonparser = new JSONParser();
		String locatorsPath = Paths.get("json", "locators.json").toString();
		//JSONObject rejsonobject=(JSONObject) jsonparser.parse(new FileReader("/Users/jaymaldikar/eclipse-workspace/ObjectOrientedProject/json/locators.json"));
		JSONObject rejsonobject=(JSONObject) jsonparser.parse(new FileReader(locatorsPath));
		
//		driver = new ChromeDriver();
//		  
//
//		  driver.manage().deleteAllCookies();
//		  driver.manage().window().maximize();
//		  wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		  driver.get("https://www.saucedemo.com/");
//		  page = new Page(driver , wait);
		  
	    if(browser.equals("chrome")){
		  
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--disable-gpu");
	    	options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
	    	options.addArguments("--no-sandbox"); // Bypass OS security model
	    	options.addArguments("--headless");
			  driver = new ChromeDriver(options);
			  driver.manage().deleteAllCookies();
			  driver.manage().window().maximize();
			//  wait = new WebDriverWait(driver,Duration.ofSeconds(30));
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
		
		 
		
		
	}
	
	public void ToverifyBrokenLinks() throws IOException, InterruptedException {
		String website;
		List <WebElement>tag_links=driver.findElements(By.tagName("a"));
		int countoflinks = tag_links.size();
		
		for(WebElement link : tag_links) {
			 website = link.getAttribute("href");
			 if(website!=null) {
				 URL url = new URL(website);
					HttpURLConnection test= (HttpURLConnection)url.openConnection();
					test.connect();
					//Thread.sleep(3000);
					int a = test.getResponseCode();
					//Thread.sleep(3000);
					if(a==200) {
						System.out.println(website + " :"+ " pass");
					}
					
					else {
						System.out.println(website + " :"+ " fail");
					} 
			 }

		}
	
	
	
		
	}
	
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}
	
}
