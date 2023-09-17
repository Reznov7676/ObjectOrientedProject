package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
	
	
	By emailId = By.xpath("//*[@id='user-name']");
	By password = By.xpath("//*[@id='password']");
	By Login = By.xpath("//*[@id='login-button']");
	
	
	
	public void Loginhomepage(String UserName , String Password) {
		
		dosendkeys(emailId,UserName);
		dosendkeys(password,Password);
		doClick(Login);
		
	}
	
	
	
	
	
	

}
