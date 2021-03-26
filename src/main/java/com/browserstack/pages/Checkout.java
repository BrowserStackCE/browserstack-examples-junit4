package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	// Creating Constructor
	public Checkout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterCheckoutDetails() {

		EnterFirstName();
		EnterLastName();
		EnterAddress();
		EnterState();
		EnterPostalCode();
		ClickSubmit();

	}

	@FindBy(id = FirstNameSelector)
	static WebElement FirstName;

	public void EnterFirstName() {

		FirstName.sendKeys(firstname);
	}

	@FindBy(id = LastNameSelector)
	static WebElement LastName;

	public void EnterLastName() {

		LastName.sendKeys(lastname);
	}

	@FindBy(id = AddressSelector)
	static WebElement Address;

	public void EnterAddress() {

		Address.sendKeys(address);
	}

	@FindBy(id = StateSelector)
	static WebElement State;

	public void EnterState() {

		State.sendKeys(state);
	}

	@FindBy(id = PostalCodeSelector)
	static WebElement PostalCode;

	public void EnterPostalCode() {

		PostalCode.sendKeys(postalcode);
	}

	@FindBy(id = SubmitSelector)
	static WebElement Submit;

	public void ClickSubmit() {

		Submit.click();
	}

}
