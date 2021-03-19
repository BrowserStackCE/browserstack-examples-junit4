package offers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;

public class CheckOffers extends DriverFactory {

	public String initialurl = "https://bstackdemo.com/";
	public String LocatorSignInButton = "signin";
	public String LocatorUserName = "react-select-2-input";
	public String UserName = "fav_user";
	public String LocatorPassword = "react-select-3-input";
	public String Password = "testingisfun99";
	public String LocatorLoginButton = "login-btn";
	public String LocatorOffers = "offers";
	public String asserturl = "https://bstackdemo.com/offers";

	@Test

	public void main() {
		// TODO Auto-generated method stub

		driver.manage().window().maximize();

		WebElement signin = driver.findElement(By.id(LocatorSignInButton));

		signin.click();

		WebElement username = driver.findElement(By.id(LocatorUserName));

		username.sendKeys(UserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorPassword)));

		password.sendKeys(Password);

		password.sendKeys(Keys.ENTER);

		WebElement Login = driver.findElement(By.id(LocatorLoginButton));

		Login.click();

		WebElement offers = driver.findElement(By.id(LocatorOffers));

		offers.click();

		wait.until(ExpectedConditions.urlToBe(asserturl));

		String CurrentUrl = driver.getCurrentUrl();

		assertEquals(CurrentUrl, asserturl);

	}

}
