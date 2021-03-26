package com.browserstack.suites.login;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browserstack.utils.Constants;
import com.browserstack.utils.DriverFactory;
import com.browserstack.utils.MarkTest;

public class LockedUserTest extends DriverFactory {

	

	@Test
	//@Description("LockedUserTest")
	public void lockedUserTest() throws Exception {
		// TODO Auto-generated method stub

		driver.manage().window().maximize();

		WebElement signin = driver.findElement(By.id(Constants.LockedUserTestLocatorSignInButton));

		signin.click();

		WebElement username = driver.findElement(By.id(Constants.LockedUserTestLocatorUserName));

		username.sendKeys(Constants.LockedUserTestUserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.LockedUserTestLocatorPassword)));

		password.sendKeys(Constants.LockedUserTestPassword);

		password.sendKeys(Keys.ENTER);

		WebElement Signin = driver.findElement(By.id(Constants.LockedUserTestLocatorSignIn));

		Signin.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Constants.LocatorAccountLockedMessage)));

		Constants.CheckIfDisplayed = driver.findElement(By.className(Constants.LocatorAccountLockedMessage)).isDisplayed();
			
		MarkTest.MarkLockedUserTest(driver, Constants.CheckIfDisplayed);
		

	}

}
