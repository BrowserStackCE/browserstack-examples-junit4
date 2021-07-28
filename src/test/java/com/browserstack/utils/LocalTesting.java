package com.browserstack.utils;

import com.browserstack.examples.config.RemoteDriverConfig;
import com.browserstack.local.Local;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.Semaphore;


public class LocalTesting extends Thread {

    private static LocalTesting instance;

    private static final Semaphore BINARY_SEMAPHORE = new Semaphore(1);

    static Local bsLocal = new Local();

    private static final Logger  LOGGER= LoggerFactory.getLogger(LocalTesting.class);

    public LocalTesting(RemoteDriverConfig remoteDriverConfig) throws Exception {

           BINARY_SEMAPHORE.acquire();
                if (!bsLocal.isRunning()) {
                    HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
                    bsLocalArgs.put("key", remoteDriverConfig.getAccessKey());
                    bsLocal.start(bsLocalArgs);
                }
            BINARY_SEMAPHORE.release();

    }


    public static void createInstance(RemoteDriverConfig remoteDriverConfig, DesiredCapabilities platformCapabilities)  {
        try {
            instance = new LocalTesting(remoteDriverConfig);
        } catch (Exception e) {
            LOGGER.error("Local initialization failed.");
        }
        Runtime.getRuntime().addShutdownHook(instance);
    }


    @Override
    public void run() {
        try {
            if (bsLocal.isRunning())
                bsLocal.stop();

            } catch (Exception exception) {
            exception.printStackTrace();

        }
    }


}

