package com.browserstack.examples.rule;

import com.browserstack.examples.config.CommonCapabilities;
import com.browserstack.examples.config.Platform;
import com.browserstack.examples.config.RemoteDriverConfig;
import com.browserstack.examples.config.WebDriverConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
public class WebDriverProviderRule extends TestWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverProviderRule.class);
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    private String methodName;
    private WebDriver driver;
    private WebDriverConfiguration webDriverConfiguration;

    /**
     * @return the name of the currently-running test method
     */
    public String getMethodName() {
        return methodName;
    }

    public WebDriver getWebDriver(WebDriverConfiguration webDriverConfiguration, Platform platform) throws MalformedURLException {
        this.webDriverConfiguration = webDriverConfiguration;
        switch (webDriverConfiguration.getDriverType()) {
            case localDriver:
                System.setProperty(WEBDRIVER_CHROME_DRIVER, Paths.get(platform.getDriverPath()).toString());
                this.driver = new ChromeDriver();
                break;
            case remoteDriver:
                RemoteDriverConfig remoteDriverConfig = webDriverConfiguration.getRemoteDriver();
                CommonCapabilities commonCapabilities = remoteDriverConfig.getCommonCapabilities();
                DesiredCapabilities platformCapabilities = new DesiredCapabilities();
                if (StringUtils.isNoneEmpty(platform.getDevice())) {
                    platformCapabilities.setCapability("device", platform.getDevice());
                }
                platformCapabilities.setCapability("browser", platform.getBrowser());
                platformCapabilities.setCapability("browser_version", platform.getBrowserVersion());
                platformCapabilities.setCapability("os", platform.getOs());
                platformCapabilities.setCapability("os_version", platform.getOsVersion());
                platformCapabilities.setCapability("name", getMethodName());
                platformCapabilities.setCapability("project", commonCapabilities.getProject());
                platformCapabilities.setCapability("build", commonCapabilities.getBuildPrefix());
                commonCapabilities.getCapabilities().getCapabilityMap().forEach(platformCapabilities::setCapability);
                if (platform.getCapabilities() != null) {
                    platform.getCapabilities().getCapabilityMap().forEach(platformCapabilities::setCapability);
                }
                String user = remoteDriverConfig.getUser();
                if (StringUtils.isNoneEmpty(System.getenv("BROWSERSTACK_USERNAME"))) {
                    user = System.getenv("BROWSERSTACK_USERNAME");
                }
                String accessKey = remoteDriverConfig.getAccessKey();
                if (StringUtils.isNoneEmpty(System.getenv("BROWSERSTACK_ACCESS_KEY"))) {
                    accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
                }
                platformCapabilities.setCapability("browserstack.user", user);
                platformCapabilities.setCapability("browserstack.key", accessKey);
                this.driver = new RemoteWebDriver(new URL(remoteDriverConfig.getHubUrl()), platformCapabilities);
                break;
        }
        return driver;
    }

    /**
     * Invoked when a test succeeds
     */
    protected void succeeded(Description description) {
        LOGGER.info("Succeeded Test :: {} WebDriver Session :: {}", description.getDisplayName(), this.driver);
        ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Test Passed\"}}");
    }

    /**
     * Invoked when a test fails
     */
    protected void failed(Throwable e, Description description) {
        LOGGER.info("Failed Test :: {} WebDriver Session :: {}", description.getDisplayName(), this.driver, e);
        ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"" + e.getLocalizedMessage() + "\"}}");
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
