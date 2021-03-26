package com.browserstack.utils;

public class Constants {

	//End to End Test
	public static String EndToEndasserturl = "https://bstackdemo.com/orders";

	public static String initialurl = "https://bstackdemo.com/";
	
	public static String EndToEndfailreason = "Placing Order Was Unsuccessful";

	public static String EndToEndPassreason = "Order Placed Successfully";
	
	public static Boolean  CheckNoOfOrders  = false;
	
	public static Boolean ConfirmationMessage = false;
	
	
	
	
	//FavouriteEnforcesLoginTest
	public static String  FavouriteEnforcesLoginTestassertUrl = "https://bstackdemo.com/signin?favourites=true";
	
	public static String LocatorFavourites = "favourites";
	
	public static String FavouriteEnforcesLoginTestPassReason = "Navigated To Sign-In Page";
	
	public static String FavouriteEnforcesLoginTestFailReason = "Failed To Navigate To Sign-In Page";
	
	

	
	//LockedUserTest
	
	public static String LockedUserTestLocatorSignInButton = "signin";
	
	public static String LockedUserTestLocatorUserName = "react-select-2-input";
	
	public static String LockedUserTestLocatorPassword = "react-select-3-input";
	
	public static String LockedUserTestLocatorSignIn = "login-btn";
	
	public static String LockedUserTestUserName = "locked_user";
	
	public static String LockedUserTestPassword = "testingisfun99";
	
	public static String LocatorAccountLockedMessage = "api-error";
	
	public static String LockedUserTestPassReason = "Account Locked Message Displayed";
	
	public static String LockedUserTestFailReason = "Account Locked Message Not Displayed";
	
	public static Boolean CheckIfDisplayed;
	
	
	
	//CheckOffers
	
	
	public static String CheckOffersLocatorSignInButton = "signin";
	
	public static String CheckOffersLocatorUserName = "react-select-2-input";
	
	public static String CheckOffersUserName = "fav_user";
	
	public static String CheckOffersLocatorPassword = "react-select-3-input";
	
	public static String CheckOffersPassword = "testingisfun99";
	
	public static String CheckOffersLocatorLoginButton = "login-btn";
	
	public static String CheckOffersLocatorOffers = "offers";
	
	public static String CheckOffersasserturl = "https://bstackdemo.com/offers";
	
	public static String CheckOffersCurrentUrl;
	
	public static String CheckOffersPassReason = "Offers Found";
	
	public static String CheckOffersFailReason = "Offers Not Found";
	
	//ApplyingFilters
	public static String ApplyingFiltersassertcondition = "16 Product(s) found.";
	
	public static String ApplyingFiltersLocatorAppleFilter = "#__next > div > div > main > div.filters > div:nth-child(2) > label > span";
	
	public static String ApplyingFiltersLocatorSamsungFilter = "#__next > div > div > main > div.filters > div:nth-child(3) > label > span";
	
	public static String ApplyingFiltersLocatorProductCount = "products-found";
	
	public static String ApplyingFiltersLocatorSpinnerReload = "//div[@class='spinner lds-ring']";
	
	public static String ApplyingFiltersPassReason = "Filter Applied Successfully";
	
	public static String ApplyingFiltersFailReason = "Failed To Apply Filter";
	
	public static int initialProductCount,finalProductCount;
	
	
	//LowestToHighest

	public static String LowestToHighestLocatorOrderButton = "#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select";

	public static String LowestToHighestLocatorLowesttoHighest = "#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select > option:nth-child(2)";
	
	public static String LowestToHighestPassReason = "Products Sorted Successfully";
	
	public static String LowestToHighestFailReason = "Failed To Sort Products";
	
	public static int LowestToHighestProductCount,LowestToHighestcurrentCost,LowestToHighestLastCost;
	
	
	
	//Check Exiting Orders
	
	public static String CheckExistingOrdersLocatorOrderPlacedMessage = "#\\31  > div.a-box.a-color-offset-background.order-info > div > div > div > div > div > div.a-column.a-span3 > div.a-row.a-size-mini > span";

	public static String CheckExistingOrdersLocatorSignInButton = "signin";

	public static String CheckExistingOrdersLocatorUserNameField = "react-select-2-input";

	public static String CheckExistingOrdersUserName = "existing_orders_user";

	public static String CheckExistingOrdersLocatorPassword = "react-select-3-input";

	public static String CheckExistingOrdersPassword = "testingisfun99";

	public static String CheckExistingOrdersLocatorLoginButton = "login-btn";

	public static String CheckExistingOrdersLocatorOrdersButton = "orders";
	
	public static String CheckExistingOrdersPassReason = "Orders Already Exist";
	
	public static String CheckExistingOrdersFailReason = "Failed To Fetch Orders";
	
	public static int CheckExistingOrdersorderCount;
	
	
	//Check FavouriteItems
	
	public static String CheckFavouriteItemsLocatorSignInButton = "signin";
	
	public static String CheckFavouriteItemsLocatorUserName  = "react-select-2-input";
	
	public static String CheckFavouriteItemsUserName = "existing_orders_user";
	
	public static String CheckFavouriteItemsLocatorPassword = "react-select-3-input";
	
	public static String CheckFavouriteItemsPassword = "testingisfun99";
	
	public static String CheckFavouriteItemsLocatorLoginButton = "login-btn";
	
	public static String CheckFavouriteItemsPassReason = "Products Marked As Favourites";
	
	public static String CheckFavouriteItemsFailReason = "Failed To Mark Products In Favourites";
	
	public static String SelectFavouriteLocator = "MuiIconButton-label";
	
	public static String Favourites = "favourites";
	
	public static int favouriteCount;
	
	
	//Image Not Loading User
	
	
	public static String ImageNotLoadingLocatorSignIn = "signin";
	
	public static String ImageNotLoadingLocatorUserNameField = "react-select-2-input";
	
	public static String ImageNotLoadingUserName = "image_not_loading_user";
	
	public static String ImageNotLoadingLocatorPassword = "react-select-3-input";
	
	public static String ImageNotLoadingPassword = "testingisfun99";
	
	public static String ImageNotLoadingLocatorLogin = "login-btn";
	
	public static String ImageNotLoadingFailReason = "Image Loaded";
	
	public static String ImageNotLoadingPassReason = "Image Not Loading";
	
	
	public static int flag=0;
	
	public static String src;
	
	public static int ImageNotLoadingproductcount;
	
	public static int i;
	
	public static String ImageLocator = "//*[@id=\"" +i+ "\"]/div[2]/img";
	

	
	
	
	
	
}
