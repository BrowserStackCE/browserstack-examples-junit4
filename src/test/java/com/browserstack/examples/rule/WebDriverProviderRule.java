package com.browserstack.examples.rule;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.net.URL;
import com.browserstack.examples.config.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
public class WebDriverProviderRule extends TestWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverProviderRule.class);
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";
    private static final String WEBDRIVER_EDGE_DRIVER = "webdriver.edge.driver";
    private static final String TEST_STATUS_SCRIPT = "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"%s\", \"reason\": \"%s\"}}";
    private static final String BROWSERSTACK_USERNAME = "BROWSERSTACK_USERNAME";
    private static final String BROWSERSTACK_ACCESS_KEY = "BROWSERSTACK_ACCESS_KEY";
    private static final String BUILD_ID = "BUILD_ID";
    private static final String DEFAULT_BUILD_NAME = "browserstack-examples-junit4";

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
                this.driver = createLocalWebDriver(platform);
                break;
            case remoteDriver:
                this.driver = createRemoteWebDriver(webDriverConfiguration, platform);
            case dockerDriver:
                this.driver = createDockerWebDriver(webDriverConfiguration, platform);
                driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Instantiates Local Driver for different browser types
     */


    public WebDriver createDockerWebDriver(WebDriverConfiguration webDriverConfiguration,Platform platform) throws MalformedURLException {
        RemoteDriverConfig remoteDriverConfig = webDriverConfiguration.getRemoteDriverConfig();
        CommonCapabilities commonCapabilities = remoteDriverConfig.getCommonCapabilities();
        DesiredCapabilities platformCapabilities = new DesiredCapabilities();
        platformCapabilities.setBrowserName(platform.getBrowser());
        return new RemoteWebDriver(new URL(remoteDriverConfig.getHubUrl()), platformCapabilities);
    }


    private WebDriver createLocalWebDriver(Platform platform) {
        WebDriver webDriver = null;
        switch (BrowserType.valueOf(platform.getName())) {
            case chrome:
                System.setProperty(WEBDRIVER_CHROME_DRIVER, Paths.get(platform.getDriverPath()).toString());
                ChromeOptions chromeOptions = new ChromeOptions();
                if (platform.getCapabilities() != null) {
                    platform.getCapabilities().getCapabilityMap().forEach(chromeOptions::setCapability);
                }
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case firefox:
                System.setProperty(WEBDRIVER_GECKO_DRIVER, Paths.get(platform.getDriverPath()).toString());
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (platform.getCapabilities() != null) {
                    platform.getCapabilities().getCapabilityMap().forEach(firefoxOptions::setCapability);
                }
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case ie:
                System.setProperty(WEBDRIVER_IE_DRIVER, Paths.get(platform.getDriverPath()).toString());
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                if (platform.getCapabilities() != null) {
                    platform.getCapabilities().getCapabilityMap().forEach(internetExplorerOptions::setCapability);
                }
                webDriver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            case edge:
                System.setProperty(WEBDRIVER_EDGE_DRIVER, Paths.get(platform.getDriverPath()).toString());
                EdgeOptions edgeOptions = new EdgeOptions();
                if (platform.getCapabilities() != null) {
                    platform.getCapabilities().getCapabilityMap().forEach(edgeOptions::setCapability);
                }
                webDriver = new EdgeDriver(edgeOptions);
                break;
            case safari:
                SafariOptions safariOptions = new SafariOptions();
                if (platform.getCapabilities() != null) {
                    platform.getCapabilities().getCapabilityMap().forEach(safariOptions::setCapability);
                }
                webDriver = new SafariDriver(safariOptions);
                break;
            case opera:
                OperaOptions operaOptions = new OperaOptions();
                if (platform.getCapabilities() != null) {
                    platform.getCapabilities().getCapabilityMap().forEach(operaOptions::setCapability);
                }
                webDriver = new OperaDriver(operaOptions);
                break;
        }
        return webDriver;
    }

    /**
     * Instantiates Remote Driver
     */
    public WebDriver createRemoteWebDriver(WebDriverConfiguration webDriverConfiguration, Platform platform) throws MalformedURLException {
        RemoteDriverConfig remoteDriverConfig = webDriverConfiguration.getRemoteDriverConfig();
        CommonCapabilities commonCapabilities = remoteDriverConfig.getCommonCapabilities();
        DesiredCapabilities platformCapabilities = new DesiredCapabilities();
        if (StringUtils.isNotEmpty(platform.getDevice())) {
            platformCapabilities.setCapability("device", platform.getDevice());
        }
        platformCapabilities.setCapability("browser", platform.getBrowser());
        platformCapabilities.setCapability("browser_version", platform.getBrowserVersion());
        platformCapabilities.setCapability("os", platform.getOs());
        platformCapabilities.setCapability("os_version", platform.getOsVersion());
        platformCapabilities.setCapability("name", getMethodName());
        platformCapabilities.setCapability("project", commonCapabilities.getProject());
        platformCapabilities.setCapability("build", commonCapabilities.getBuildPrefix());

        if (commonCapabilities.getCapabilities() != null) {
            commonCapabilities.getCapabilities().getCapabilityMap().forEach(platformCapabilities::setCapability);
        }

        if (platform.getCapabilities() != null) {
            platform.getCapabilities().getCapabilityMap().forEach(platformCapabilities::setCapability);
        }
        String user = remoteDriverConfig.getUser();
        if (StringUtils.isNoneEmpty(System.getenv(BROWSERSTACK_USERNAME))) {
            user = System.getenv(BROWSERSTACK_USERNAME);
        }
        String accessKey = remoteDriverConfig.getAccessKey();
        if (StringUtils.isNoneEmpty(System.getenv(BROWSERSTACK_ACCESS_KEY))) {
            accessKey = System.getenv(BROWSERSTACK_ACCESS_KEY);
        }
        platformCapabilities.setCapability("browserstack.user", user);
        platformCapabilities.setCapability("browserstack.key", accessKey);
        return new RemoteWebDriver(new URL(remoteDriverConfig.getHubUrl()), platformCapabilities);
    }

    private String createBuildName(String buildPrefix) {
        if (StringUtils.isEmpty(buildPrefix)) {
            buildPrefix = DEFAULT_BUILD_NAME;
        }
        String buildName = buildPrefix;

        String buildId = System.getenv(BUILD_ID);
        if (StringUtils.isNotEmpty(buildId)) {
            buildName = buildName + "-" + buildId;
        }
        return buildName;
    }

    /**
     * Invoked when a test succeeds
     */
    protected void succeeded(Description description) {
        LOGGER.info("Succeeded Test :: {} WebDriver Session :: {}", description.getDisplayName(), this.driver);
        if (webDriverConfiguration.getDriverType() == DriverType.remoteDriver) {
            ((JavascriptExecutor) driver).executeScript(String.format(TEST_STATUS_SCRIPT, "passed", "Test Passed"));
        }
    }


    /**
     * Invoked when a test fails
     */
    protected void failed(Throwable e, Description description) {
        LOGGER.info("Failed Test :: {} WebDriver Session :: {}", description.getDisplayName(), this.driver, e);
        if (webDriverConfiguration.getDriverType() == DriverType.remoteDriver) {
            ((JavascriptExecutor) driver).executeScript(String.format(TEST_STATUS_SCRIPT, "failed", e.getMessage()));
        }
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
