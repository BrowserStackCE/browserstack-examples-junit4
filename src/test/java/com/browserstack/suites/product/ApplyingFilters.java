package com.browserstack.suites.product;

import com.browserstack.utils.DriverFactory;

public class ApplyingFilters extends DriverFactory {
//
//
//
//	@Test
//	//@Description("ApplyingFilters")
//
//	public void applyingFilters() throws IOException, ParseException {
//		// TODO Auto-generated method stub
//
//
//
//		//Experimental Stuff
//		//UserName And AccessKey
//
//		/*
//
//		JSONParser jsonparser = new JSONParser();
//
//		FileReader reader = new FileReader("src/test/java/resources/test_caps.json");
//
//		Object obj;
//
//		obj = jsonparser.parse(reader);
//
//		JSONObject credentials = (JSONObject) obj;
//
//		String Username = (String) credentials.get("user");
//
//		String Access_Key = (String) credentials.get("key");
//
//		String Application_Endpoint = (String) credentials.get("application_endpoint");
//
//
//
//
//
//
//
//		System.out.println("Username Is:  "+Username);
//
//		System.out.println("AccessKey Is  "+ Access_Key);
//
//		System.out.println("Application Endpoint Is:" +Application_Endpoint);
//
//		JSONObject tests = (JSONObject)credentials.get("tests");
//
//		JSONObject single = (JSONObject) tests.get("single");
//
//		System.out.println("Single Is:" +single);
//
//
//
//		JSONArray array = (JSONArray) single.get("env_caps");
//
//		JSONObject config = (JSONObject) array.get(0);
//
//		System.out.println("Config is "+config);
//
//		String browser = (String) config.get("browser");
//
//		System.out.println("Browser Is:" +browser);
//
//		System.out.println("OS Is" +(String) config.get("os"));
//
//		System.out.println("OS version Is" +(String) config.get("os_version"));
//
//		JSONObject common_caps = (JSONObject) single.get("common_caps");
//
//		System.out.println(common_caps);
//
//
//		String Project = (String) common_caps.get("project");
//
//		String Build = (String) common_caps.get("build");
//
//		String Session = (String) common_caps.get("name");
//
//
//		System.out.println("ProjectName Is :"+Project);
//
//		System.out.println("Build Is :"+Build);
//
//		System.out.println("Session Is :"+Session);
//
//
//
//	//	System.out.println("Build is "+build);
//
//	//	System.out.println("Session Name is "+name);
//
//
//
//		JSONArray array1 = (JSONArray) single.get("common_caps");
//
//		JSONObject common_caps = (JSONObject) array1.get(1);
//
//		 String project = (String) common_caps.get("project");
//
//		 System.out.println("Project Name Is:" +project);
//
//		 String build = (String) common_caps.get("build");
//
//		 System.out.println("Build Name Is:" +build);
//
//		 String name = (String) common_caps.get("name");
//
//		 System.out.println("Session Name Is:" +name);
//
//		 */
//
//		 //Experimental Stuff Ends Here
//
//
//		Constants.initialProductCount = CommonSteps.productCount(driver);
//
//		WebElement AppleFilter = driver.findElement(By.cssSelector(Constants.ApplyingFiltersLocatorAppleFilter));
//
//		AppleFilter.click();
//
//		WebElement Samsung = driver.findElement(By.cssSelector(Constants.ApplyingFiltersLocatorSamsungFilter));
//
//		Samsung.click();
//
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.ApplyingFiltersLocatorSpinnerReload)));
//
//		Constants.finalProductCount = CommonSteps.productCount(driver);
//
//		MarkTest.MarkApplyingFilters(driver,Constants.initialProductCount, Constants.finalProductCount);
//
//
//	}

}
