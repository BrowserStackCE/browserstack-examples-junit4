package product;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonSteps;
import utils.DriverFactory;
import utils.MarkTest;

public class ApplyingFilters extends DriverFactory {

	public String assertcondition = "16 Product(s) found.";
	public String initialurl = "https://bstackdemo.com/";
	public String LocatorAppleFilter = "#__next > div > div > main > div.filters > div:nth-child(2) > label > span";
	public String LocatorSamsungFilter = "#__next > div > div > main > div.filters > div:nth-child(3) > label > span";
	public String LocatorProductCount = "products-found";
	public String LocatorSpinnerReload = "//div[@class='spinner lds-ring']";
	
	public String PassReason = "Filter Applied Successfully";
	public String FailReason = "Failed To Apply Filter";

	@Test

	public void main() {
		// TODO Auto-generated method stub
		
		int initialProductCount = CommonSteps.productCount(driver);
		
		WebElement AppleFilter = driver.findElement(By.cssSelector(LocatorAppleFilter));

		AppleFilter.click();

		WebElement Samsung = driver.findElement(By.cssSelector(LocatorSamsungFilter));

		Samsung.click();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LocatorSpinnerReload)));

		int finalProductCount = CommonSteps.productCount(driver);
		
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
		
			MarkTest.MarkApplyingFilters(driver, initialProductCount, finalProductCount);
		
		}

	}

}
