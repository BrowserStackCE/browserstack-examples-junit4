package com.browserstack.examples.tests;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.browserstack.examples.config.Platform;
import com.browserstack.examples.config.WebDriverConfiguration;
import com.browserstack.examples.rule.WebDriverProviderRule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
public abstract class AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractWebDriverTest.class);

//    @Parameterized.Parameters(name = "{0}")
    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data() throws IOException {
        String capabilitiesConfigFile = System.getProperty("capabilities.config", "capabilities.yml");
        LOGGER.debug("Using capabilities configuration from FILE :: {}", capabilitiesConfigFile);
        URL resourceURL = AbstractWebDriverTest.class.getClassLoader().getResource(capabilitiesConfigFile);

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        webDriverConfiguration = objectMapper.readValue(resourceURL, WebDriverConfiguration.class);
        LOGGER.debug("Web Driver Configuration :: {}", webDriverConfiguration);
        List<Object[]> returnData = new ArrayList<>();
        List<Platform> platforms = webDriverConfiguration.getActivePlatforms();

        platforms.forEach(platform -> {
            returnData.add(new Object[]{platform});
        });
        return returnData;
    }

    protected static WebDriverConfiguration webDriverConfiguration;

    @Parameterized.Parameter(0)
    public Platform platform;

    @Rule
    public WebDriverProviderRule webDriverProviderRule = new WebDriverProviderRule();
}
