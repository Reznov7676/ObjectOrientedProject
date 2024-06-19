package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {

	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}

	
	
	public void doClick(By locator) {
		
		driver.findElement(locator).click();
	}
	
	public void dosendkeys(By locator , String textdata) {
		
		driver.findElement(locator).sendKeys(textdata);
	}
	
	
	
	public void waitForDocumentReady(WebDriver driver , By locator,int time,String Credentials) {
		WebElement xpath = driver.findElement(locator);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
	
		wait.until(ExpectedConditions.visibilityOf(xpath));
	
		//xpath.click();
		xpath.sendKeys(Credentials);
	
	
	}
	

	
	
	
	
	
	
	
	
}
