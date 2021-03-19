package user;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonSteps;
import utils.DriverFactory;
import utils.MarkTest;

public class CheckFavouriteItems extends DriverFactory {
	
	
	public String LocatorSignInButton = "signin";
	
	public String LocatorUserName  = "react-select-2-input";
	
	public String UserName = "existing_orders_user";
	
	public String LocatorPassword = "react-select-3-input";
	
	public String Password = "testingisfun99";
	
	public String LocatorLoginButton = "login-btn";
	
	public String PassReason = "Products Marked As Favourites";
	
	public String FailReason = "Failed To Mark Products In Favourites";
	

	@Test
	public void main() {
		// TODO Auto-generated method stub

		WebElement signin = driver.findElement(By.id(LocatorSignInButton));

		signin.click();

		WebElement username = driver.findElement(By.id(LocatorUserName));

		username.sendKeys(UserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorPassword)));

		password.sendKeys(Password);

		password.sendKeys(Keys.ENTER);

		WebElement loginbutton = driver.findElement(By.id(LocatorLoginButton));

		loginbutton.click();
		
		for(int index=0;index<3;index++) {
			
			//Need to remove thread.sleep but code is working fine as of now
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
			WebElement SelectFavourite = driver.findElements(By.className("MuiIconButton-label")).get(index);
		

			SelectFavourite.click();
		
		
		
		}

		WebElement Favourites = driver.findElement(By.id("favourites"));

		Favourites.click();
	
		int favouriteCount = CommonSteps.favouriteCount(driver);
		
		System.out.println("Favourite Count " +favouriteCount);
		 
		if(CommonSteps.platformtemp.contains("bstack"))
		{
		
		MarkTest.MarkCheckFavouriteItems(driver, favouriteCount);

		}
	
	
	}

		
}


