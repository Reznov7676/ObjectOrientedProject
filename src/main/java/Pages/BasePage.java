package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
