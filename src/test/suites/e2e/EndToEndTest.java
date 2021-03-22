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
import utils.Constants;

public class EndToEndTest extends DriverFactory {
	
	 
	  @Test 
	  // @Description("EndToEndTest")
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
	  
		  Constants.ConfirmationMessage = CommonSteps.isConfirmationMessageDisplayed(driver);
	  
		  Constants.CheckNoOfOrders = CommonSteps.checkNoOfItems(driver);
 
		  Confirmation confirmation = new Confirmation(driver);
	  
		  confirmation.ClickContinueShoppingButton();
	  
		  homepage.ClickOrderButton();
	  
		  MarkTest.MarkEndToEndTest(driver, Constants.ConfirmationMessage, Constants.CheckNoOfOrders);
	 
	 

	  }


}