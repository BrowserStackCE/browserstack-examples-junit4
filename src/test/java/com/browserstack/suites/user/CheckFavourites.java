package com.browserstack.suites.user;

import com.browserstack.utils.BaseTest;
import com.browserstack.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.Keys.ENTER;

public class CheckFavourites extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckFavourites.class);
    @Test
    public void checkFavourites() throws Exception {

        /* =================== Prepare ================= */
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("signin"))).click();
        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-2-input"))).sendKeys("existing_orders_user", ENTER);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
        webDriver.findElement(By.id("login-btn")).click();
        wait.until(ExpectedConditions.urlContains("?signin=true"));
        for(int index=0;index<3;index++) {
            webDriver.findElements(By.className(Constants.SelectFavouriteLocator)).get(index).click();
        }

        /* =================== Verify ================= */
        webDriver.findElement(By.id("favourites")).click();
        long favouriteCount = webDriver.findElements(By.className("shelf-item")).size();
        assertTrue(favouriteCount>0);

    }

}
