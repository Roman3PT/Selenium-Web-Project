package com.Roman3PT.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * GoogleChromeInitializer use WebDriver and configure it.
 * Default Browser: Google Chrome.
 */
public abstract class DriverInitializer {

    protected static WebDriver driver;

    private static final Logger logger = Logger.getLogger(DriverInitializer.class);

    private static final String browserName = "webdriver.chrome.driver";
    private static final String browserPath = "src/main/resources/chromedriver.exe";


    public void initializeDriver() {
        System.setProperty(browserName, browserPath);
        driver = new ChromeDriver();
        logger.info("initialization Driver");
        configure();
        logger.info("Driver is configured");
    }

    /**
     * This method perform configuration of WebDriver
     */
    private void configure() {
        driver.manage().window().maximize();
    }
}