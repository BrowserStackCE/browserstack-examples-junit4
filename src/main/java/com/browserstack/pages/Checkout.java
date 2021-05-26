package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {

	WebDriver driver;

	public final static String FirstNameSelector = "firstNameInput";
	public final static String LastNameSelector = "lastNameInput";
	public final static String AddressSelector = "addressLine1Input";
	public final static String StateSelector = "provinceInput";
	public final static String PostalCodeSelector = "postCodeInput";
	public final static String SubmitSelector = "checkout-shipping-continue";

	public final static String firstname = "Bhagyesh";
	public final static String lastname = "Nanwani";
	public final static String address = "Street1,New York";
	public final static String state = "New York";
	public final static String postalcode = "401105";

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

	@FindBy(id = FirstNameSelector)
	static WebElement FirstName;

	public void enterFirstName() {
		FirstName.sendKeys(firstname);
	}

	@FindBy(id = LastNameSelector)
	static WebElement LastName;

	public void enterLastName() {
		LastName.sendKeys(lastname);
	}

	@FindBy(id = AddressSelector)
	static WebElement Address;

	public void enterAddress() {
		Address.sendKeys(address);
	}

	@FindBy(id = StateSelector)
	static WebElement State;

	public void enterState() {
		State.sendKeys(state);
	}

	@FindBy(id = PostalCodeSelector)
	static WebElement PostalCode;

	public void enterPostalCode() {
		PostalCode.sendKeys(postalcode);
	}

	@FindBy(id = SubmitSelector)
	static WebElement Submit;

	public void clickSubmit() {
		Submit.click();
	}

}
