package com.Roman3PT.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * GoogleChromeInitializer use WebDriver and configure it.
 * Default Browser: Google Chrome.
 */
public abstract class GoogleChromeInitializer {

    private static final String browserName = "webdriver.chrome.driver";
    private static final String browserPath = "src/main/resources/chromedriver.exe";
    protected WebDriver driver;

    public GoogleChromeInitializer() {
        System.setProperty(browserName, browserPath);
        driver = new ChromeDriver();
    }
}