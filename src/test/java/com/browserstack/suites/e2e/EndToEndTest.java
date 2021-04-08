package com.browserstack.suites.e2e;

import org.junit.Test;

import com.browserstack.pages.Bag;
import com.browserstack.pages.Checkout;
import com.browserstack.pages.Confirmation;
import com.browserstack.pages.HomePage;
import com.browserstack.pages.Login;
import com.browserstack.utils.CommonSteps;
import com.browserstack.utils.Constants;
import com.browserstack.utils.DriverFactory;
import com.browserstack.utils.MarkTest;

public class EndToEndTest extends DriverFactory {


    @Test
    // @Description("EndToEndTest")
    public void endToEndTest() throws Exception {
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
