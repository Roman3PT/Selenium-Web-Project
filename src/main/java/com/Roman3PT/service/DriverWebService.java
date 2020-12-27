package com.Roman3PT.service;

import com.Roman3PT.driver.DriverInitializer;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * This is a wrapper class over the Driver class
 */
public class DriverWebService extends DriverInitializer {

    private static final Logger logger = Logger.getLogger(DriverWebService.class);
    private static final String baseURL = "http://qa.yotec.net/";

    public void openURL(String url) {
        driver.get(url);
        if (findElementByCssLocated("a").isDisplayed())
            findElementByCssLocated("a").click();
        logger.info("Open Page: " + url);
    }

    public static WebElement findElementByCssLocated(String cssSelector) {
        return new WebDriverWait(driver, 8)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    public static List<WebElement> findElementsByCssLocated(String cssSelector) {
        return new WebDriverWait(driver, 8)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void quit() {
        driver.quit();
        logger.info("Destroy driver...");
    }
}