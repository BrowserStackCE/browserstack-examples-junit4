package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Confirmation {

	WebDriver driver;

	public final static String CONTINUESHOPPINGLOCATOR = "#checkout-app > div > div > div > div > a > button";

	public Confirmation(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		clickContinueShoppingButton(wait);
	}

	@FindBy(css = CONTINUESHOPPINGLOCATOR)
	static WebElement ContinueShoppingButton;

	public void clickContinueShoppingButton(WebDriverWait wait) {
		wait.until(ExpectedConditions.urlContains("confirmation"));
		ContinueShoppingButton.click();
	}

}
