package e2e;



import org.junit.Test;
import pages.Bag;
import pages.Checkout;
import pages.Confirmation;
import pages.HomePage;
import pages.Login;
import utils.DriverFactory;
import utils.MarkTest;
import utils.CommonSteps;

public class EndToEndTest extends DriverFactory {

	String asserturl = "https://bstackdemo.com/orders";

	String initialurl = "https://bstackdemo.com/";
	
	String failreason = "Placing Order Was Unsuccessful";
	
	String Passreason = "Order Placed Successfully";
	
	Boolean  CheckNoOfOrders  = false;
	
	Boolean ConfirmationMessage = false;

	 
	  @Test 
	  public void EndToEnd() throws Exception { 
		  // TODO Auto-generated method stub
	 
	  HomePage homepage = new HomePage(driver);
	  
	  homepage.ClickSignInButton();
	  
	  Login login = new Login(driver);
	  
	  login.login();
	  
	  homepage.AddToCart();
	    
	  Bag bag = new Bag(driver);
	  
	  bag.ClickCheckoutButton();
	  
	  Checkout checkout = new Checkout(driver);
	  
	  checkout.EnterCheckoutDetails();
	  
	  ConfirmationMessage = CommonSteps.isConfirmationMessageDisplayed(driver);
	  
	  CheckNoOfOrders = CommonSteps.checkNoOfItems(driver);
 
	  Confirmation confirmation = new Confirmation(driver);
	  
	  confirmation.ClickContinueShoppingButton();
	  
	  homepage.ClickOrderButton();
	  
	  	if(CommonSteps.platformtemp.contains("bstack")){
		  
	  		MarkTest.MarkEndToEndTest(driver, ConfirmationMessage, CheckNoOfOrders);
	 
	  	}
	 

	  }


}