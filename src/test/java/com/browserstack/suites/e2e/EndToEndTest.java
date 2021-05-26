package com.browserstack.suites.e2e;

import com.browserstack.examples.config.WebDriverFactory;
import com.browserstack.examples.tests.AbstractWebDriverTest;
import com.browserstack.pages.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
@RunWith(Parameterized.class)
public class EndToEndTest extends AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EndToEndTest.class);

    @Test
    public void endToEndTest() throws Exception {

        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        webDriver.get(getTestEndpoint());


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
