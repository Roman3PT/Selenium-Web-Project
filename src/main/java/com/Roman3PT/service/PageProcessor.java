package com.Roman3PT.service;

import com.Roman3PT.driver.MainWebService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProcessor extends MainWebService {

    public WebElement findLocatedElementByCssLocator(String identifier) {
        return (new WebDriverWait(driver, 6000))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(identifier)));
    }
}