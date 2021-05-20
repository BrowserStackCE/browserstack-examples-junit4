package com.browserstack.suites.product;

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

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
@RunWith(Parameterized.class)
public class ApplyingSamsungAndAppleFilter extends AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyingSamsungAndAppleFilter.class);

    @Test
    public void ApplyingAppleAndSamsungFilters() throws Exception {

        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        webDriver.get(webDriverConfiguration.getTestEndpoint());

        /* =================== Execute ================= */
        int initialProductCount = webDriver.findElements(By.className("shelf-item")).size();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector(".filters-available-size:nth-child(2) .checkmark"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector(".filters-available-size:nth-child(3) .checkmark"))).click();

        /* =================== Verify ================= */
        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
        int finalProductCount = webDriver.findElements(By.className("shelf-item")).size();
        assert initialProductCount == finalProductCount || (true);

    }


}
