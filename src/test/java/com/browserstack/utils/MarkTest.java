package com.browserstack.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarkTest {
	
	/*
	
	public static String platformtemp = System.getProperty("profileId");
	
	static String e2eFailreason = "Placing Order Was Unsuccessful";
	
	static String e2ePassreason = "Order Placed Successfully";
	
	static String MarkFavouriteEnforcesLoginTestFailReason =  "Failed To Navigate To Sign-In Page";
	
	static String MarkFavouriteEnforcesLoginTestPassReason =  "Navigated To Sign-In Page";
	
	static String LockedUserTestPassReason = "Account Locked Message Displayed";
	
	static String LockedUserTestFailReason = "Account Locked Message Not Displayed";
	
	public static String ApplyingFiltersPassReason = "Filter Applied Successfully";
	
	public static String ApplyingFiltersFailReason = "Failed To Apply Filter";
	
	public static String LowestToHighestPassReason = "Products Sorted Successfully";
	
	public static String LowestToHighestFailReason = "Failed To Sort Products";
	
	public static String CheckExistingOrdersPassReason = "Orders Already Exist";
	
	public static String CheckExistingOrdersFailReason = "Failed To Fetch Orders";
	
	public static String CheckFavouriteItemsPassReason = "Products Marked As Favourite";
	
	public static String CheckFavouriteItemsFailReason = "Failed To Mark Products As Favourite";
	
	public static String ImageNotLoadingFailReason = "Image Loaded";
	
	public static String ImageNotLoadingPassReason = "Image Not Loading";
	
	*/
	
	
	public static void MarkEndToEndTest(WebDriver driver,Boolean ConfirmationMessage,Boolean CheckNoOfOrders) {
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
		
		
		  if(Constants.ConfirmationMessage==false || Constants.CheckNoOfOrders == false) {
			  
			  driver = CommonSteps.markTestFail(driver, Constants.EndToEndfailreason); 
		  
		  }
	  
		  else {
		  
			  driver = CommonSteps.markTestPass(driver, Constants.EndToEndPassreason);
		 
		  }
		
		}
	}
	
	
	public static void MarkFavouriteEnforcesLoginTest(WebDriver driver,String assertUrl) {
	
		System.out.println("Inside Test Marking Block");
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
		
			if(CommonSteps.platformtemp.contains("bstack-local")) {
				
				System.out.println("Changing assertUrl to Local Url");
			
				Constants.FavouriteEnforcesLoginTestassertUrl = "http://localhost:3000/signin?favourites=true";
			
			}
		
			WebDriverWait wait = new WebDriverWait(driver, 100);
		
			wait.until(ExpectedConditions.urlToBe(Constants.FavouriteEnforcesLoginTestassertUrl));

			String CurrentUrl = driver.getCurrentUrl();
		
			if(CurrentUrl.equals(Constants.FavouriteEnforcesLoginTestassertUrl)) {
			
				CommonSteps.markTestPass(driver, Constants.FavouriteEnforcesLoginTestPassReason);
		
			}
	
			else {
		
				CommonSteps.markTestFail(driver, Constants.FavouriteEnforcesLoginTestFailReason);
		
			}
			
		}
	

	}
	
	
	public static void MarkLockedUserTest(WebDriver driver,Boolean CheckIfDisplayed) {
	
		if(CommonSteps.platformtemp.contains("bstack"))
		{
		
			if(CheckIfDisplayed == true){
			
				driver = CommonSteps.markTestPass(driver, Constants.LockedUserTestPassReason);
		
			}
	
			else {
		
				driver = CommonSteps.markTestFail(driver, Constants.LockedUserTestFailReason);
		
			}
		}
	
	}
	
	
	public static void MarkApplyingFilters(WebDriver driver,int initialProductCount, int finalProductCount) {
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
		
			System.out.println("Inside Marking Test Block");
			
			System.out.println("Initial Product Count Is "+initialProductCount);
			
			System.out.println("Initial Product Count Is "+finalProductCount);
			
			
			if(initialProductCount != finalProductCount) {
			
				CommonSteps.markTestPass(driver, Constants.ApplyingFiltersPassReason);
		
			}
	
			else {
		
				CommonSteps.markTestFail(driver, Constants.ApplyingFiltersFailReason);
		
			}
		
		}
	
	}
	
	
	
	public static void LowestToHighest(WebDriver driver, int flag) {
		
		if(CommonSteps.platformtemp.contains("bstack"))
			
		{
			System.out.println(flag);
		
			if(flag == 1){
			
				CommonSteps.markTestFail(driver, Constants.LowestToHighestFailReason);
		
			}
			else {
		
				CommonSteps.markTestPass(driver, Constants.LowestToHighestPassReason);
		
			}
		
		}
	
	}	
	
	
	public static void CheckExistingOrders(WebDriver driver, int orderCount) {
		if(CommonSteps.platformtemp.contains("bstack"))
		{
			
			if(orderCount <= 0)
			{
		 
				CommonSteps.markTestFail(driver, Constants.CheckExistingOrdersFailReason);
		 
			}
			
			else {
		 
				CommonSteps.markTestPass(driver, Constants.CheckExistingOrdersPassReason);
		 
			}
			
		}
		 
	}	
	
	
	public static void MarkCheckFavouriteItems(WebDriver driver, int favouriteCount) {
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
			
			if(favouriteCount <= 0){
		 
				CommonSteps.markTestFail(driver, Constants.CheckFavouriteItemsFailReason);
		 
			}
			
			else {
		 
				CommonSteps.markTestPass(driver, Constants.CheckFavouriteItemsPassReason);
		 
			}
			
		}
	}	
	
	
	public static void MarkImageNotLoading(WebDriver driver, int flag) {
	
		if(CommonSteps.platformtemp.contains("bstack"))
		{
		
			if(flag==1) {
			
				CommonSteps.markTestFail(driver, Constants.ImageNotLoadingFailReason);
			
			}
	
			else{
		
				CommonSteps.markTestPass(driver, Constants.ImageNotLoadingPassReason);
		
			}
			
		}
		 
	}
	
	
	
	public static void CheckOffers(WebDriver driver) {
		
		if(CommonSteps.platformtemp.contains("bstack")){
		
			if(driver.getPageSource().contains("We've promotional offers in your location.")) {
				
				CommonSteps.markTestPass(driver, Constants.CheckOffersPassReason);
				
			}
		
		
			else {
			
				CommonSteps.markTestFail(driver, Constants.CheckOffersFailReason);
			
			}
		 
		}
	
	}
		
	
	
	


}
