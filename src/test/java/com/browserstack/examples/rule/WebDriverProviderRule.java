package com.browserstack.examples.rule;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.browserstack.examples.config.Platform;
import com.browserstack.examples.config.WebDriverConfiguration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
public class WebDriverProviderRule extends TestWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverProviderRule.class);

    private String methodName;
    private WebDriver driver;
    private WebDriverConfiguration webDriverConfiguration;

    /**
     * @return the name of the currently-running test method
     */
    public String getMethodName() {
        return methodName;
    }

    public WebDriver getWebDriver(WebDriverConfiguration webDriverConfiguration, Platform platform) {
        this.webDriverConfiguration = webDriverConfiguration;
        // instantiate the WebDriver based on whether it is a remote or a local driver
        return driver;
    }

    /**
     * Invoked when a test succeeds
     */
    protected void succeeded(Description description) {
        LOGGER.info("Succeeded Test :: {} WebDriver Session :: {}", description.getDisplayName(), this.driver);
    }

    /**
     * Invoked when a test fails
     */
    protected void failed(Throwable e, Description description) {
        LOGGER.info("Failed Test :: {} WebDriver Session :: {}", description.getDisplayName(), this.driver, e);
    }

    @Override
    protected void starting(Description d) {
        methodName = d.getMethodName();
    }

    /**
     * Invoked when a test method finishes (whether passing or failing)
     */
    protected void finished(Description description) {
        LOGGER.info("Finished Test :: {} WebDriver Session :: {}", this.methodName, this.driver);
        LOGGER.info("Quitting the WebDriver instance :: {}", this.driver);
        if (this.driver != null) {
            this.driver.quit();
        }
    }


}
