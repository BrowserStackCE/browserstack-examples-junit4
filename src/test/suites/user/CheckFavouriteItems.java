package user;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonSteps;
import utils.Constants;
import utils.DriverFactory;
import utils.MarkTest;

public class CheckFavouriteItems extends DriverFactory {

	@Test
	//@Description("CheckFavouriteItems")
	public void main() {
		// TODO Auto-generated method stub

		WebElement signin = driver.findElement(By.id(Constants.CheckFavouriteItemsLocatorSignInButton));

		signin.click();

		WebElement username = driver.findElement(By.id(Constants.CheckFavouriteItemsLocatorUserName));

		username.sendKeys(Constants.CheckFavouriteItemsUserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.CheckFavouriteItemsLocatorPassword)));

		password.sendKeys(Constants.CheckFavouriteItemsPassword);

		password.sendKeys(Keys.ENTER);

		WebElement loginbutton = driver.findElement(By.id(Constants.CheckFavouriteItemsLocatorLoginButton));

		loginbutton.click();
		
		for(int index=0;index<3;index++) {
			
			//Need to remove thread.sleep but code is working fine as of now
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
			WebElement SelectFavourite = driver.findElements(By.className(Constants.SelectFavouriteLocator)).get(index);

			SelectFavourite.click();
		
		}

		WebElement Favourites = driver.findElement(By.id(Constants.Favourites));

		Favourites.click();
	
		Constants.favouriteCount = CommonSteps.favouriteCount(driver);

		
		MarkTest.MarkCheckFavouriteItems(driver, Constants.favouriteCount);	
	
	}

		
}


