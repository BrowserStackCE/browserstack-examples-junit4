package com.browserstack.examples.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
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
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);

        /* =================== Execute ================= */

        /* =================== Verify ================= */
    }


    @Test
    public void testSelectingSamsungFilterDisplaysNoAppleDevices() throws Exception {
        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);

        /* =================== Execute ================= */

        /* =================== Verify ================= */
    }
}
