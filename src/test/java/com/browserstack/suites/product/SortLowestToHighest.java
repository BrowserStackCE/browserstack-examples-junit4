package com.browserstack.suites.product;

import com.browserstack.utils.CommonSteps;
import com.browserstack.webdriver.junit4.AbstractWebDriverTest;
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

@RunWith(Parameterized.class)
public class SortLowestToHighest extends AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortLowestToHighest.class);

    @Test
    public void lowestToHighest() throws Exception {

        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        webDriver.get(getTestEndpoint());

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select")))
                            .click();
        wait.until(ExpectedConditions.elementToBeClickable(By
                .cssSelector("#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select > option:nth-child(2)")))
                    .click();
        wait.until(waitWebDriver -> waitWebDriver.findElements(By.
                cssSelector(".spinner"))
                    .isEmpty());
        int productCount = webDriver.findElements(By.className("shelf-item")).size();
        int lastCost = CommonSteps.findCostByIndex(webDriver, 0);

        /* =================== Verify ================= */
        int currentCost,Flag=0;
        for (int index = 1; index < productCount; index++) {
            currentCost = CommonSteps.findCostByIndex(webDriver, index);
            if (currentCost < lastCost) {
                Flag = 1;
            }
            lastCost = currentCost;
        }
        assertTrue(Flag!=1);
    }



}
