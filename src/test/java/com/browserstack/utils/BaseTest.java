package com.browserstack.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver webDriver;

    @Before
    public void init() {
        if (StringUtils.equalsIgnoreCase(System.getProperty("browserstack-local"), "true")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            webDriver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            webDriver = new ChromeDriver();
            webDriver.get("https://bstackdemo.com");
        }
    }

    @After
    public void teardown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
