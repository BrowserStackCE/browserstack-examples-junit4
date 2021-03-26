package com.browserstack.suites.login;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browserstack.utils.Constants;
import com.browserstack.utils.DriverFactory;
import com.browserstack.utils.MarkTest;


public class FavouritesEnforcesLoginTest extends DriverFactory {

	
	@Test
	//@Description("FavouritesEnforcesLoginTest")
	public void favouriteEnforcesLoginTest() throws Exception {
		// TODO Auto-generated method stub
		
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 100);

		WebElement favourites = wait.until(ExpectedConditions.elementToBeClickable(By.id(Constants.LocatorFavourites)));

		favourites.click();
			
		MarkTest.MarkFavouriteEnforcesLoginTest(driver,Constants.FavouriteEnforcesLoginTestassertUrl);


	}
	
}
