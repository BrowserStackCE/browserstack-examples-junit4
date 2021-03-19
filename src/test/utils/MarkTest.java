package utils;

import org.openqa.selenium.WebDriver;

public class MarkTest {
	
	
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
	
	
	public static void MarkEndToEndTest(WebDriver driver,Boolean ConfirmationMessage,Boolean CheckNoOfOrders) {
		
		  if(ConfirmationMessage==false || CheckNoOfOrders == false) {
			  
			  driver = CommonSteps.markTestFail(driver, e2eFailreason); 
		  
		  }
	  
		  else {
		  
			  driver = CommonSteps.markTestPass(driver, e2ePassreason);
		 
		  }
		
	}
	
	
	public static void MarkFavouriteEnforcesLoginTest(WebDriver driver,String CurrentUrl,String assertUrl) {
	
	
		if(CurrentUrl.equals(assertUrl)) {
			
			CommonSteps.markTestPass(driver, MarkFavouriteEnforcesLoginTestPassReason);
		
		}
	
		else {
		
			CommonSteps.markTestFail(driver, MarkFavouriteEnforcesLoginTestFailReason);
		
		}
	

	}
	
	
	public static void MarkLockedUserTest(WebDriver driver,Boolean CheckIfDisplayed) {
	
		if(CheckIfDisplayed == true){
			
			driver = CommonSteps.markTestPass(driver, LockedUserTestPassReason);
		
		}
	
		else {
		
			driver = CommonSteps.markTestFail(driver, LockedUserTestFailReason);
		
		}
	
	}
	
	
	public static void MarkApplyingFilters(WebDriver driver,int initialProductCount, int finalProductCount) {
		
		if(initialProductCount != finalProductCount) {
			
			CommonSteps.markTestPass(driver, ApplyingFiltersPassReason);
		
		}
	
		else {
		
			CommonSteps.markTestFail(driver, ApplyingFiltersFailReason);
		
		}
	
	}
	
	
	
	public static void LowestToHighest(WebDriver driver, int flag) {
		
		if(flag == 1){
			
			CommonSteps.markTestFail(driver, LowestToHighestFailReason);
		
		}
		else {
		
			CommonSteps.markTestPass(driver, LowestToHighestPassReason);
		
		}
	
	}	
	
	
	public static void CheckExistingOrders(WebDriver driver, int orderCount) {
		
		 if(orderCount <= 0)
		 {
		 
			 CommonSteps.markTestFail(driver, CheckExistingOrdersFailReason);
		 
		 
		 }
	
		 else {
		 
			 CommonSteps.markTestPass(driver, CheckExistingOrdersPassReason);
		 
		 }
		 
	}	
	
	
	public static void MarkCheckFavouriteItems(WebDriver driver, int favouriteCount) {
		
		 if(favouriteCount <= 0)
		 {
		 
			 CommonSteps.markTestFail(driver, CheckFavouriteItemsFailReason);
		 
		 
		 }
	
		 else {
		 
			 CommonSteps.markTestPass(driver, CheckFavouriteItemsPassReason);
		 
		 }
		 
	}	
	
	
	public static void MarkImageNotLoading(WebDriver driver, int flag) {
		
		if(flag==1) {
			
			CommonSteps.markTestFail(driver, ImageNotLoadingFailReason);
			
		}
	
		else{
		
			CommonSteps.markTestPass(driver, ImageNotLoadingPassReason);
		
		}
		 
	}


}
