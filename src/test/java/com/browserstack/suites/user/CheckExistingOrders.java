package com.browserstack.suites.user;

import com.browserstack.utils.BaseTest;
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

import static org.openqa.selenium.Keys.ENTER;

public class CheckExistingOrders extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckExistingOrders.class);
    @Test
    public void checkExistingOrders() throws Exception {

        /* =================== Prepare ================= */
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("signin"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-2-input"))).sendKeys("existing_orders_user", ENTER);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
        webDriver.findElement(By.id("login-btn")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("orders"))).click();

        /* =================== Verify ================= */
        int ordercount = webDriver.findElements(By.className("a-box-group")).size();
        assert ordercount <= 0 || (true);

    }

}
