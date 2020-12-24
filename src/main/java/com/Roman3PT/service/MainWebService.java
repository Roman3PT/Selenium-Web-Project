package com.Roman3PT.service;

import com.Roman3PT.driver.DriverInitializer;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a wrapper class over the Driver class
 */
public class MainWebService extends DriverInitializer {

    private static final Logger logger = Logger.getLogger(MainWebService.class);

    public void openPage(String url) {
        driver.get(url);
        logger.info("Open Page: " + url);
    }

    public WebElement findElementByCssLocated(String cssSelector) {
        return new WebDriverWait(driver, 6)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    public void destroy() {
        driver.quit();
        logger.info("Driver is destroyed!");
    }

}