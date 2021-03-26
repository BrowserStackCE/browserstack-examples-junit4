package com.browserstack.suites.offers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browserstack.utils.Constants;
import com.browserstack.utils.DriverFactory;
import com.browserstack.utils.MarkTest;

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
	
	private static final String LOCATION_SCRIPT_FORMAT = "navigator.geolocation.getCurrentPosition = function(success){\n" +
	            "    var position = { \"coords\":{\"latitude\":\"%s\",\"longitude\":\"%s\"}};\n" +
	            "    success(position);\n" +
	            "}";
	private static final String OFFER_LATITUDE = "1";
	private static final String OFFER_LONGITUDE = "103";

	@Test
	//@Description("CheckOffers")

	public void checkOffers() {
		// TODO Auto-generated method stub

		driver.manage().window().maximize();

		WebElement signin = driver.findElement(By.id(Constants.CheckOffersLocatorSignInButton));

		signin.click();

		WebElement username = driver.findElement(By.id(Constants.CheckOffersLocatorUserName));

		username.sendKeys(Constants.CheckOffersUserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.CheckOffersLocatorPassword)));

		password.sendKeys(Constants.CheckOffersPassword);

		password.sendKeys(Keys.ENTER);

		WebElement Login = driver.findElement(By.id(Constants.CheckOffersLocatorLoginButton));

		Login.click();
		
		mockLocation(driver);

		  String locationScript = String.format(LOCATION_SCRIPT_FORMAT, OFFER_LATITUDE, OFFER_LONGITUDE);
		  
	      ((JavascriptExecutor) driver).executeScript(locationScript);
		
		
		WebElement offers = driver.findElement(By.id(Constants.CheckOffersLocatorOffers));

		offers.click();

		wait.until(ExpectedConditions.urlToBe(Constants.CheckOffersasserturl));

		Constants.CheckOffersCurrentUrl = driver.getCurrentUrl();

		assertEquals(Constants.CheckOffersCurrentUrl, Constants.CheckOffersasserturl);
		
		MarkTest.CheckOffers(driver);
		

	}
	
	
	
	
	 private void mockLocation(WebDriver driver) {
		 
	        String locationScript = String.format(LOCATION_SCRIPT_FORMAT, OFFER_LATITUDE, OFFER_LONGITUDE);
	        
	        ((JavascriptExecutor) driver).executeScript(locationScript);
	        
	 }

}
