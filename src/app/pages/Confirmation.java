package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation {

	WebDriver driver;

	public final static String ContinueShoppingSelector = "#checkout-app > div > div > div > div > a > button";

	public Confirmation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ContinueShoppingSelector)
	static WebElement ContinueShoppingButton;

	public void ClickContinueShoppingButton() {

		ContinueShoppingButton.click();
	}

}
