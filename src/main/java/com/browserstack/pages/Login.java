package com.browserstack.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;

	public final static String IDLocator = "react-select-2-input";
	public final static String PasswordLocator = "react-select-3-input";
	public final static String SignInButtonLocator = "login-btn";

	public final static String id = "fav_user";
	public final static String password = "testingisfun99";

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		login();
	}

	public void login() {
		EnterID();
		EnterPassword();
		ClickSignIn();
	}

	@FindBy(id = IDLocator)
	static WebElement ID;

	public void EnterID() {

		ID.sendKeys(id);

		ID.sendKeys(Keys.ENTER);
	}

	@FindBy(id = PasswordLocator)
	static WebElement Password;

	public void EnterPassword() {

		Password.sendKeys(password);

		Password.sendKeys(Keys.ENTER);
	}

	@FindBy(id = SignInButtonLocator)
	static WebElement SignIn;

	public void ClickSignIn() {

		SignIn.sendKeys(Keys.RETURN);
	}

}
