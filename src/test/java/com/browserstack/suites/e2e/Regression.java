package com.browserstack.suites.e2e;

import com.browserstack.pages.*;
import com.browserstack.utils.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class Regression extends BaseTest {

    @Test
    public void endToEndTest() throws Exception {

        // Initialize WebDriverWait using the WebDriver instance
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        /* =================== Execute ================= */
       HomePage homepage = new HomePage(webDriver, wait);
       Login login = new Login(webDriver);
       Bag bag = new Bag(webDriver, wait);
       Checkout checkout = new Checkout(webDriver, wait);
       Confirmation confirmation = new Confirmation(webDriver, wait);
       FavUserHomePage favUserHomePage = new FavUserHomePage(webDriver ,wait);

        /* =================== Verify ================= */

        wait.until(ExpectedConditions.urlContains("/orders"));
        wait.until(ExpectedConditions
               .visibilityOfElementLocated(By
                       .className("item-view-left-col-inner")));
        int count = webDriver.findElements(By.className("item-view-left-col-inner")).size();
        assertTrue(count == 3);

    }

}
