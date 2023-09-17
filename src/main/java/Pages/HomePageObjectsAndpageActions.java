package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePageObjectsAndpageActions extends BasePage{

	public HomePageObjectsAndpageActions(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
	
	public void clickOnaddTocart() {
		String b [] = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Fleece Jacket"};
		//String b  = "Sauce Labs Bike Light";
		//String a =driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		List<WebElement> gt =driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(int i=0;i<=gt.size()-1;i++) {
			
			
			String p = gt.get(i).getText();
			//System.out.println(p);
			
			List names = Arrays.asList(b);

			
		if (names.contains(p)) {
		
			    driver.findElements(By.cssSelector(".btn")).get(i).click();
				
       }
			
			
			
    }
		   
		

   }
	
	
	
	public void VerifySwagLabsMenu() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
	   String arr[]= {"All Items","About","Logout","Reset App State"};
		ArrayList <String>ft = new ArrayList<String>(Arrays.asList(arr));
		ArrayList <String>op = new ArrayList<String>();
		
		driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
		Thread.sleep(3000);
		List <WebElement> list = driver.findElements(By.xpath("//*[@id='menu_button_container']/div/div[2]/div[1]/nav/a"));
		for(WebElement df: list) {
			String vc=df.getText();
			System.out.println(vc);
			
			op.add(vc);
			
			
		}

		
		if(op.equals(ft)) {
			System.out.println("testpass");
		}
		else {
			
			throw new IllegalArgumentException("exception");
		}
	}
	
	
	public void ClickOnSauceProducts() {
		
		List <WebElement> SauceList=driver.findElements(By.xpath("//div[@class='inventory_container'] //div[@class='inventory_item_name']"));
	
		for(WebElement d: SauceList) {
			
	String product=	d.getText();
	
	if(product.contains("Sauce")) {
		WebElement addtocart=	driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
	wait.until(ExpectedConditions.visibilityOf(addtocart)).click();
	
		
	}
			
		}
	
	
	}

	
	public void verifyAddtoCartnumber(int w) {
		
		WebElement addtocart_number= driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span"));
		String atc_number=addtocart_number.getText();
		if(atc_number.equals("5")) {
			System.out.println("pass");
			
		}
		
		else {
			
			throw new IllegalArgumentException("Expected Value should be " +atc_number+" but we have got ");
		}
		//return new HomePagerelatedMethodsandXpaths(driver);
	}
	
	public void VerifySortingMenu() {
		String option;
		ArrayList <String>arr = new ArrayList <String>();
		ArrayList<String> list = new ArrayList<String>();   
		// adding elements to the ArrayList
		list.add("Name (Z to A)");
		list.add("Name (A to Z)");
		list.add("Price (low to high)");   
		list.add("Price (high to low)"); 
		
	
		List <WebElement> y= driver.findElements(By.xpath("//select[@class='product_sort_container']/option"));
		for(int i=0;i<=y.size()-1;i++) {
			 option = y.get(i).getText();
			//System.out.println(option);
			
			arr.add(option);
		}
		
		Collections.sort(arr,Collections.reverseOrder());
		Collections.sort(list,Collections.reverseOrder());
		if(arr.equals(list)) {
			System.out.println("success");
			
		}
		else {
			
			throw new IllegalArgumentException("fail");
		}
	}
	
	

}
