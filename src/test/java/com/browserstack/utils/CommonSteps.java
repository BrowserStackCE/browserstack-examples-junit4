package com.browserstack.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonSteps {


	//public static String platformtemp = System.getProperty("profileId");


	public static boolean isConfirmationMessageDisplayed(WebDriver driver)
	{

		 Boolean ConfirmationMessage = driver.findElement(By.id("confirmation-message")).isDisplayed();

		 System.out.println("Boolean Value: "+ConfirmationMessage);

		  	if(ConfirmationMessage == false)
		  	{
		  		System.out.println("Mark test as failed");

		  	}

		 return ConfirmationMessage;

	}


	public static boolean checkNoOfItems(WebDriver driver)
	{


		 Boolean NoOfItems = driver.findElement(By.id("3")).isDisplayed();

		 System.out.println("Boolean Value: "+NoOfItems);

		  if(NoOfItems == false) {

			  System.out.println("Mark test as failed");

		  }

		  return NoOfItems;


	}


	//Some Issue With Test Status Syntax


	 public static WebDriver markTestFail(WebDriver driver , String reason){

	        if(driver != null) {

	        	System.out.println("Marking Fail");

	            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

	            //javascriptExecutor.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"" + reason + "\"}}");

	            javascriptExecutor.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"" +reason+ "\"}}");

	        }



	        return driver;

	 }


	 public static WebDriver markTestPass(WebDriver driver , String reason){

	        if(driver != null) {

	        	System.out.println("Marking Passed");

	            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

	            javascriptExecutor.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"" +reason+ "\"}}");

	        }

	        return driver;

	 }



	 public static int productCount(WebDriver driver){

	        return driver.findElements(By.className("shelf-item")).size();

	    }


	 public static int findCostByIndex(WebDriver driver,int index){

		  WebElement product = findProductByIndex(driver,index);

		  String cost = product
	                .findElement(By.className("shelf-item__price"))
	                .findElement(By.className("val"))
	                .findElement(By.tagName("b")).getText();

	        return Integer.parseInt(cost);
	 }




	 private static WebElement findProductByIndex(WebDriver driver,int index){

	        return driver.findElements(By.className("shelf-item")).get(index);

	 }



	 public static int orderCount(WebDriver driver){

	        return driver.findElements(By.className("a-box-group")).size();

	 }


	 public static int favouriteCount(WebDriver driver){

	       return driver.findElements(By.className("shelf-item")).size();

	    }


}
