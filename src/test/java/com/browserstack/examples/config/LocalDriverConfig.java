package com.browserstack.examples.config;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
public class LocalDriverConfig {

    private List<Platform> platforms;

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
}
