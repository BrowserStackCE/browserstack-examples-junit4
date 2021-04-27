package com.browserstack.examples.tests;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class FilterTests extends AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterTests.class);

    @Test
    public void testSelectingAppleFilterDisplaysNoSamsungDevices() throws Exception {
        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        webDriver.get(getTestEndpoint());

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector(".filters-available-size:nth-child(2) .checkmark"))).click();
        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
        List<WebElement> appleDeviceName = webDriver.findElements(By.cssSelector(".shelf-item__title"));

        /* =================== Verify ================= */
        long samsungDeviceCount = appleDeviceName.stream().filter(e -> e.getText().contains("Galaxy")).count();
        assertEquals(0, samsungDeviceCount);
    }


    @Test
    public void testSelectingSamsungFilterDisplaysNoAppleDevices() throws Exception {
        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        webDriver.get(getTestEndpoint());

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector(".filters-available-size:nth-child(3) .checkmark"))).click();
        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
        List<WebElement> samsungDeviceName = webDriver.findElements(By.cssSelector(".shelf-item__title"));

        /* =================== Verify ================= */
        long appleDeviceCount = samsungDeviceName.stream().filter(e -> e.getText().contains("iPhone")).count();
        assertEquals(0, appleDeviceCount);
    }
}
