package com.browserstack.suites.login;

import com.browserstack.examples.tests.AbstractWebDriverTest;
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
public class NavigateToLoginPage extends AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigateToLoginPage.class);

    @Test
    public void navigateToLoginPage() throws Exception {

        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        webDriver.get(getTestEndpoint());

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



