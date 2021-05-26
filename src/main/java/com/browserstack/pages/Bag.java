package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class Bag {

	WebDriver driver;

	public final static String checkoutselector = "#__next > div > div > div.float-cart.float-cart--open > div.float-cart__content > div.float-cart__footer > div.buy-btn";
	public final static String SignInSelector = "signin";
	public final static String iPhone12Locator = "#\\31  > div.shelf-item__buy-btn";
	public final static String iPhone12MiniLocator = "#\\32  > div.shelf-item__buy-btn";
	public final static String iPhone12ProMaxLocator = "#\\33  > div.shelf-item__buy-btn";
	public final static String OrderButtonLocator = "orders";


	public Bag(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		addToCart(wait);
	}

	public void addToCart(WebDriverWait wait) {
		wait.until(ExpectedConditions.urlContains("?signin=true"));
		wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
		clickiPhone12();
		driver.findElement(By.className("float-cart__close-btn")).click();
		clickiPhone12Mini();
		driver.findElement(By.className("float-cart__close-btn")).click();
		clickiPhone12ProMax();
		clickCheckoutButton();
	}

	@FindBy(css = iPhone12Locator)
	static WebElement iPhone12;

	public void clickiPhone12() {
		iPhone12.click();
	}

	@FindBy(css = iPhone12MiniLocator)
	static WebElement iPhone12Mini;

	public void clickiPhone12Mini() {
		iPhone12Mini.click();
	}

	@FindBy(css = iPhone12ProMaxLocator)
	static WebElement iPhone12ProMax;

	public void clickiPhone12ProMax() {
		iPhone12ProMax.click();
	}

	@FindBy(css = checkoutselector)
	static WebElement checkoutbutton;

	public void clickCheckoutButton() {
		checkoutbutton.click();

	}

}
