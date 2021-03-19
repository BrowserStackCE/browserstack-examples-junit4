package login;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonSteps;
import utils.DriverFactory;
import utils.MarkTest;

public class LockedUserTest extends DriverFactory {

	String initialurl = "https://bstackdemo.com/";
	String LocatorSignInButton = "signin";
	String LocatorUserName = "react-select-2-input";
	String LocatorPassword = "react-select-3-input";
	String LocatorSignIn = "login-btn";
	String UserName = "locked_user";
	String Password = "testingisfun99";
	String LocatorAccountLockedMessage = "api-error";
	String PassReason = "Account Locked Message Displayed";
	String FailReason = "Account Locked Message Not Displayed";
	

	@Test

	public void lockedUserTest() throws Exception {
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

		WebElement Signin = driver.findElement(By.id(LocatorSignIn));

		Signin.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("api-error")));

		Boolean CheckIfDisplayed = driver.findElement(By.className(LocatorAccountLockedMessage)).isDisplayed();
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
			
			MarkTest.MarkLockedUserTest(driver, CheckIfDisplayed);
			
		}	
		

	}

}
