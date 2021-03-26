package com.browserstack.suites.user;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browserstack.utils.CommonSteps;
import com.browserstack.utils.Constants;
import com.browserstack.utils.DriverFactory;
import com.browserstack.utils.MarkTest;

public class CheckExistingOrders extends DriverFactory {
	
	
	
	@Test
	//@Description("CheckExistingOrders")
	public void checkExistingOrders() throws Exception {
		// TODO Auto-generated method stub
			
		WebElement signin = driver.findElement(By.id(Constants.CheckExistingOrdersLocatorSignInButton));

		signin.click();

		WebElement username = driver.findElement(By.id(Constants.CheckExistingOrdersLocatorUserNameField));

		username.sendKeys(Constants.CheckExistingOrdersUserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.CheckExistingOrdersLocatorPassword)));

		password.sendKeys(Constants.CheckExistingOrdersPassword);

		password.sendKeys(Keys.ENTER);

		WebElement Login = driver.findElement(By.id(Constants.CheckExistingOrdersLocatorLoginButton));

		Login.click();

		WebElement order = driver.findElement(By.id(Constants.CheckExistingOrdersLocatorOrdersButton));

		order.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.CheckExistingOrdersLocatorOrderPlacedMessage)));
		
		Constants.CheckExistingOrdersorderCount = CommonSteps.orderCount(driver);
		
		MarkTest.CheckExistingOrders(driver, Constants.CheckExistingOrdersorderCount);

		
	}

}