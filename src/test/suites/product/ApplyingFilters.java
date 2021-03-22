package product;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonSteps;
import utils.Constants;
import utils.DriverFactory;
import utils.MarkTest;

public class ApplyingFilters extends DriverFactory {



	@Test
	//@Description("ApplyingFilters")

	public void main() throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		
		
		//Experimental Stuff
		//UserName And AccessKey
		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader("./resources/conf/runners/test_caps.json");

		Object obj;

		obj = jsonparser.parse(reader);

		JSONObject credentials = (JSONObject) obj;

		String Username = (String) credentials.get("user");

		String Access_Key = (String) credentials.get("key");
		
		String Application_Endpoint = (String) credentials.get("application_endpoint");
		
		
		
		
		
		
 		
		System.out.println("Username Is:  "+Username);
		
		System.out.println("AccessKey Is  "+ Access_Key);
		
		System.out.println("Application Endpoint Is:" +Application_Endpoint);
		
		JSONObject tests = (JSONObject)credentials.get("tests");
		
		JSONObject single = (JSONObject) tests.get("single");
		
		System.out.println("Single Is:" +single);
		
		JSONArray array = (JSONArray) single.get("env_caps");
		
		JSONObject config = (JSONObject) array.get(0);
		
		System.out.println("Config is "+config);
		
		String browser = (String) config.get("browser");
		
		System.out.println("Browser Is:" +browser);
		
		System.out.println("OS Is" +(String) config.get("os"));
		
		System.out.println("OS version Is" +(String) config.get("os_version"));
	     
		 
		 
		 //Experimental Stuff Ends Here
		
		Constants.initialProductCount = CommonSteps.productCount(driver);
		
		WebElement AppleFilter = driver.findElement(By.cssSelector(Constants.ApplyingFiltersLocatorAppleFilter));

		AppleFilter.click();

		WebElement Samsung = driver.findElement(By.cssSelector(Constants.ApplyingFiltersLocatorSamsungFilter));

		Samsung.click();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.ApplyingFiltersLocatorSpinnerReload)));

		Constants.finalProductCount = CommonSteps.productCount(driver);
		
		MarkTest.MarkApplyingFilters(driver, Constants.initialProductCount, Constants.finalProductCount);


	}

}
