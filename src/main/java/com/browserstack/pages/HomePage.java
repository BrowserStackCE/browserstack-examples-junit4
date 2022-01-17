package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public final static String SIGNINLOCATOR = "signin";

	public HomePage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		clickSignInButton(wait);
	}

	@FindBy(id = SIGNINLOCATOR)
	static WebElement SignInButton;

	public void clickSignInButton(WebDriverWait wait) {
		SignInButton.click();
		wait.until(ExpectedConditions.urlContains("signin"));
	}

}
