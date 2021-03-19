package login;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonSteps;
import utils.DriverFactory;
import utils.MarkTest;

public class FavouritesEnforcesLoginTest extends DriverFactory {

	String assertUrl = "https://bstackdemo.com/signin?favourites=true";

	String initialurl = "https://bstackdemo.com/";

	String LocatorFavourites = "favourites";
	
	String PassReason = "Navigated To Sign-In Page";
	
	String FailReason = "Failed To Navigate To Sign-In Page";

	@Test
	public void FavouriteEnforcesLoginTest() throws Exception {
		// TODO Auto-generated method stub

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement favourites = wait.until(ExpectedConditions.elementToBeClickable(By.id(LocatorFavourites)));

		favourites.click();

		wait.until(ExpectedConditions.urlToBe(assertUrl));

		String CurrentUrl = driver.getCurrentUrl();
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
			
			MarkTest.MarkFavouriteEnforcesLoginTest(driver, CurrentUrl , assertUrl);
			
		}

	}
	
}
