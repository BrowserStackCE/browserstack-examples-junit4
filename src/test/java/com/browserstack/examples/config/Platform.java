package com.browserstack.examples.config;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
@Data
@ToString
public class Platform {

    private String name;

    private String os;

    private String os_version;

    private String browser;

    private String browser_version;

    private String driverPath;

    private Capabilities capabilities;
}
