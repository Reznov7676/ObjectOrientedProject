package HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import Pages.HomePageObjectsAndpageActions;
import Pages.LoginPage;
import Tests.BaseTest;

public class HomePage_SwagLabs_SortingMenu_TestCase_3 extends BaseTest {

	
	@Test(dataProvider="getdata")
	
	public void lg(String User , String pas) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
		page.getInstance(LoginPage.class).Loginhomepage(User, pas);
		String test= verifyTitle();
		Assert.assertEquals(test, "Swag Labs");
		page.getInstance(HomePageObjectsAndpageActions.class).VerifySortingMenu();
		
		
	}
	

}
