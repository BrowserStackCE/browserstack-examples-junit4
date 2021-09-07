package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {

	WebDriver driver;

	public final static String FIRSTNAMELOCATOR = "firstNameInput";
	public final static String LASTNAMELOCATOR = "lastNameInput";
	public final static String ADDRESSLOCATOR = "addressLine1Input";
	public final static String STATELOCATOR = "provinceInput";
	public final static String POSTALCODELOCATOR = "postCodeInput";
	public final static String SUBMITLOCATOR = "checkout-shipping-continue";

	public final static String FIRSTNAME = "Bhagyesh";
	public final static String LASTNAME = "Nanwani";
	public final static String ADDRESS = "Street1,New York";
	public final static String STATE = "New York";
	public final static String POSTALCODE = "401105";

	public Checkout(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EnterCheckoutDetails(wait);
	}

	public void EnterCheckoutDetails(WebDriverWait wait) {
		wait.until(ExpectedConditions.urlContains("checkout"));
		enterFirstName();
		enterLastName();
		enterAddress();
		enterState();
		enterPostalCode();
		clickSubmit();

	}

	@FindBy(id = FIRSTNAMELOCATOR)
	static WebElement FirstName;

	public void enterFirstName() {
		FirstName.sendKeys(FIRSTNAME);
	}

	@FindBy(id = LASTNAMELOCATOR)
	static WebElement LastName;

	public void enterLastName() {
		LastName.sendKeys(LASTNAME);
	}

	@FindBy(id = ADDRESSLOCATOR)
	static WebElement Address;

	public void enterAddress() {
		Address.sendKeys(ADDRESS);
	}

	@FindBy(id = STATELOCATOR)
	static WebElement State;

	public void enterState() {
		State.sendKeys(STATE);
	}

	@FindBy(id = POSTALCODELOCATOR)
	static WebElement PostalCode;

	public void enterPostalCode() {
		PostalCode.sendKeys(POSTALCODE);
	}

	@FindBy(id = SUBMITLOCATOR)
	static WebElement Submit;

	public void clickSubmit() {
		Submit.click();
	}

}
