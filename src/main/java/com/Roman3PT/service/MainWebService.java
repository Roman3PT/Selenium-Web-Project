package com.Roman3PT.driver;

import org.apache.log4j.Logger;

/**
 * This is a wrapper class over the Driver class
 */
public class MainWebService extends DriverInitializer {

    private static final Logger logger = Logger.getLogger(MainWebService.class);

    public void openPage(String url) {
        driver.get(url);
        logger.info("Open Page: " + url);
    }

    public void destroy() {
        driver.quit();
        logger.info("Driver is destroyed!");
    }

}