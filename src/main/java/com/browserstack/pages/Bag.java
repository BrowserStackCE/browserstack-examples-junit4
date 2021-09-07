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

	public final static String CHECKOUTLOCATOR = "#__next > div > div > div.float-cart.float-cart--open > div.float-cart__content > div.float-cart__footer > div.buy-btn";
	public final static String IPHONE12LOCATOR = "#\\31  > div.shelf-item__buy-btn";
	public final static String IPHONE12MINILOCATOR = "#\\32  > div.shelf-item__buy-btn";
	public final static String IPHONE12PROMAXLOCATOR = "#\\33  > div.shelf-item__buy-btn";


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

	@FindBy(css = IPHONE12LOCATOR)
	static WebElement iPhone12;

	public void clickiPhone12() {
		iPhone12.click();
	}

	@FindBy(css = IPHONE12MINILOCATOR)
	static WebElement iPhone12Mini;

	public void clickiPhone12Mini() {
		iPhone12Mini.click();
	}

	@FindBy(css = IPHONE12PROMAXLOCATOR)
	static WebElement iPhone12ProMax;

	public void clickiPhone12ProMax() {
		iPhone12ProMax.click();
	}

	@FindBy(css = CHECKOUTLOCATOR)
	static WebElement checkoutbutton;

	public void clickCheckoutButton() {
		checkoutbutton.click();

	}

}
