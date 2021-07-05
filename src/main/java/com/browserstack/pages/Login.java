package com.browserstack.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;

	public final static String IDLOCATOR = "react-select-2-input";
	public final static String PASSWORDLOCATOR = "react-select-3-input";
	public final static String SIGNINBUTTONLOCATOR = "login-btn";

	public final static String USERID = "fav_user";
	public final static String PASSWORD = "testingisfun99";

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		login();
	}

	public void login() {
		enterID();
		enterPassword();
		clickSignIn();
	}

	@FindBy(id = IDLOCATOR)
	static WebElement ID;

	public void enterID() {
		ID.sendKeys(USERID);
		ID.sendKeys(Keys.ENTER);
	}

	@FindBy(id = PASSWORDLOCATOR)
	static WebElement Password;

	public void enterPassword() {
		Password.sendKeys(PASSWORD);
		Password.sendKeys(Keys.ENTER);
	}

	@FindBy(id = SIGNINBUTTONLOCATOR)
	static WebElement SignIn;

	public void clickSignIn() {
		SignIn.sendKeys(Keys.RETURN);
	}

}
