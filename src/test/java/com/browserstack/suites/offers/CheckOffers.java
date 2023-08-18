package com.browserstack.suites.offers;

import com.browserstack.utils.BaseTest;
import com.browserstack.utils.Constants;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.Keys.ENTER;


public class CheckOffers extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckOffers.class);

    @Test
    public void checkOffers() throws Exception {

        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriver.get(getTestEndpoint());

        /* =================== Execute ================= */
        String locationScript = String.format(Constants.LOCATION_SCRIPT_FORMAT, Constants.OFFER_LATITUDE, Constants.OFFER_LONGITUDE);
        ((JavascriptExecutor) webDriver).executeScript(locationScript);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("signin"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-2-input"))).sendKeys("fav_user", ENTER);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
        webDriver.findElement(By.id("login-btn")).click();
        //wait.until(ExpectedConditions.urlToBe("https://bstackdemo.com/?signin=true"));
        wait.until(ExpectedConditions.urlContains("signin=true"));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("offers"))).click();

        /* =================== Verify ================= */
        assertTrue(webDriver.getPageSource().contains("We've promotional offers in your location."));

    }



}
