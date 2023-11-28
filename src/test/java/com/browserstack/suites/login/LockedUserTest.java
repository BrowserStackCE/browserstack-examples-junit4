package com.browserstack.suites.login;

import com.browserstack.utils.BaseTest;
import org.junit.Test;
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


public class LockedUserTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LockedUserTest.class);

    @Test
    public void lockedUserTest() throws Exception {

        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriver.get(getTestEndpoint());

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("signin"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-2-input"))).sendKeys("locked_user", ENTER);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-3-input"))).sendKeys("testingisfun99\n");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("login-btn"))).sendKeys(Keys.RETURN);



        /* =================== Verify ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .className("api-error")));
        boolean CheckIfDisplayed = webDriver.findElement(By.className("api-error")).isDisplayed();
        assertTrue(CheckIfDisplayed == true);

    }
    @Test
    public void secondLockedUserTest() throws Exception {


        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriver.get(getTestEndpoint());

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("signin"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-2-input"))).sendKeys("locked_user", ENTER);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-3-input"))).sendKeys("testingisfun99\n");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("login-btn"))).sendKeys(Keys.RETURN);



        /* =================== Verify ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .className("api-error")));
        boolean CheckIfDisplayed = webDriver.findElement(By.className("api-error")).isDisplayed();
        assertTrue(CheckIfDisplayed == true);

    }

    @Test
    public void thirdLockedUserTest() throws Exception {


        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriver.get(getTestEndpoint());

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("signin"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-2-input"))).sendKeys("locked_user", ENTER);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-3-input"))).sendKeys("testingisfun99\n");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("login-btn"))).sendKeys(Keys.RETURN);



        /* =================== Verify ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .className("api-error")));
        boolean CheckIfDisplayed = webDriver.findElement(By.className("api-error")).isDisplayed();
        assertTrue(CheckIfDisplayed == true);

    }

}
