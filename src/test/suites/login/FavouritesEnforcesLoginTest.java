package login;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.DriverFactory;
import utils.MarkTest;

public class FavouritesEnforcesLoginTest extends DriverFactory {

	
	@Test
	//@Description("FavouritesEnforcesLoginTest")
	public void FavouriteEnforcesLoginTest() throws Exception {
		// TODO Auto-generated method stub

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 100);

		WebElement favourites = wait.until(ExpectedConditions.elementToBeClickable(By.id(Constants.LocatorFavourites)));

		favourites.click();
			
		MarkTest.MarkFavouriteEnforcesLoginTest(driver,Constants.FavouriteEnforcesLoginTestassertUrl);


	}
	
}
