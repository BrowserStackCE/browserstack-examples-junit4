package com.browserstack.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonSteps {

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


}
