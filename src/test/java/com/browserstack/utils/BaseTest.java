package com.browserstack.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver webDriver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/Users/adarsh/Downloads/chromedriver");
        webDriver = new ChromeDriver(); // Initialize the class-level driver variable
        webDriver.get("https://www.bstackdemo.com/");
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
