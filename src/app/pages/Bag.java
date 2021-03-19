package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bag {

	WebDriver driver;

	public final static String checkoutselector = "#__next > div > div > div.float-cart.float-cart--open > div.float-cart__content > div.float-cart__footer > div.buy-btn";

	public Bag(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = checkoutselector)
	static WebElement checkoutbutton;

	public void ClickCheckoutButton() {
		checkoutbutton.click();

	}

}
