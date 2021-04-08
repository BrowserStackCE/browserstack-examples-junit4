package com.browserstack.examples.config;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
@Data
@ToString
public class WebDriverConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverConfiguration.class);

    private String testEndpoint;

    private DriverType driverType;

    private LocalDriverConfig localDriver;

    private RemoteDriverConfig remoteDriver;

    public List<Platform> getActivePlatforms() {
        List<Platform> activePlatforms = Collections.emptyList();
        switch (driverType) {
            case remoteDriver:
                activePlatforms = remoteDriver.getPlatforms();
                break;
            case localDriver:
                activePlatforms = localDriver.getPlatforms();
                break;
        }

        return activePlatforms;
    }
}
