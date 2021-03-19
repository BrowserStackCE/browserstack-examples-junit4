package user;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonSteps;
import utils.DriverFactory;
import utils.MarkTest;

public class CheckExistingOrders extends DriverFactory {

	public String LocatorOrderPlacedMessage = "#\\31  > div.a-box.a-color-offset-background.order-info > div > div > div > div > div > div.a-column.a-span3 > div.a-row.a-size-mini > span";

	public String initialurl = "https://bstackdemo.com/";

	public String LocatorSignInButton = "signin";

	public String LocatorUserNameField = "react-select-2-input";

	public String UserName = "existing_orders_user";

	public String LocatorPassword = "react-select-3-input";

	public String Password = "testingisfun99";

	public String LocatorLoginButton = "login-btn";

	public String LocatorOrdersButton = "orders";
	
	public String PassReason = "Orders Already Exist";
	
	public String FailReason = "Failed To Fetch Orders";
	
	
	
	
	
	@Test
	public void main() throws Exception {
		// TODO Auto-generated method stub
			
		WebElement signin = driver.findElement(By.id(LocatorSignInButton));

		signin.click();

		WebElement username = driver.findElement(By.id(LocatorUserNameField));

		username.sendKeys(UserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorPassword)));

		password.sendKeys(Password);

		password.sendKeys(Keys.ENTER);

		WebElement Login = driver.findElement(By.id(LocatorLoginButton));

		Login.click();

		WebElement order = driver.findElement(By.id(LocatorOrdersButton));

		order.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LocatorOrderPlacedMessage)));
		
		int orderCount = CommonSteps.orderCount(driver);
		
		System.out.println(orderCount);
		 
		if(CommonSteps.platformtemp.contains("bstack")) {
		 
			MarkTest.CheckExistingOrders(driver, orderCount);
			
		}
		 
	}

}