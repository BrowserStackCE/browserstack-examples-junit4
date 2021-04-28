package com.browserstack.examples.tests;

import com.browserstack.utils.CommonSteps;
import com.browserstack.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import com.browserstack.pages.*;

import java.util.List;

import static org.junit.Assert.*;
import static org.openqa.selenium.Keys.ENTER;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
@RunWith(Parameterized.class)
public class LockedUserTest extends AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LockedUserTest.class);


    @Test
    public void lockedUserTest() throws Exception {

        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        webDriver.get(webDriverConfiguration.getTestEndpoint());


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
