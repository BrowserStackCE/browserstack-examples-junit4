package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public final static String SignInSelector = "signin";
	public final static String iPhone12Locator = "#\\31  > div.shelf-item__buy-btn";
	public final static String iPhone12MiniLocator = "#\\32  > div.shelf-item__buy-btn";
	public final static String iPhone12ProMaxLocator = "#\\33  > div.shelf-item__buy-btn";
	public final static String OrderButtonLocator = "orders";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = SignInSelector)
	static WebElement SignInButton;

	public void ClickSignInButton() {

		SignInButton.click();
	}

	public void AddToCart() {
		ClickiPhone12();
		ClickiPhone12Mini();
		ClickiPhone12ProMax();
	}

	@FindBy(css = iPhone12Locator)
	static WebElement iPhone12;

	public void ClickiPhone12() {

		iPhone12.click();
	}

	@FindBy(css = iPhone12MiniLocator)
	static WebElement iPhone12Mini;

	public void ClickiPhone12Mini() {

		iPhone12Mini.click();
	}

	@FindBy(css = iPhone12ProMaxLocator)
	static WebElement iPhone12ProMax;

	public void ClickiPhone12ProMax() {

		iPhone12ProMax.click();
	}

	@FindBy(id = OrderButtonLocator)
	static WebElement OrderButton;

	public void ClickOrderButton() {

		OrderButton.click();
	}

}
