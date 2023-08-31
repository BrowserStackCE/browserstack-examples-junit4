package com.browserstack.suites.login;

import com.browserstack.utils.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class NavigateToLoginPage extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigateToLoginPage.class);

    @Test
    public void navigateToLoginPage() throws Exception {

        /* =================== Prepare ================= */
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        /* =================== Execute ================= */
        wait.until(waitWebDriver -> waitWebDriver.findElements(By.
                cssSelector(".spinner"))
                .isEmpty());
        wait.until(ExpectedConditions.elementToBeClickable(By
                .id("favourites"))).click();

        /* =================== Verify ================= */
        wait.until(ExpectedConditions.urlContains("signin?favourites=true"));
        String CurrentUrl = webDriver.getCurrentUrl();
        assertTrue(CurrentUrl.contains("signin?favourites=true"));

    }

}



