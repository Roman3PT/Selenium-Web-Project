package com.Roman3PT.page;

import com.Roman3PT.enums.NavigationMenu;
import com.Roman3PT.service.DriverWebService;
import com.google.common.collect.Iterables;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


/**
 * This is a base class of all Pages
 * This class has general methods of all pages
 */
public abstract class TemplatePage extends DriverWebService {

    private static final Logger logger = Logger.getLogger(TemplatePage.class);

    private static final String navigationMenu = "div[class^='navigation'] ul[id$='navigationUl']";
    private static final String breadCrumb = "a[class='rsmLink']";
    private static final String home = "a[href$='home']";

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public static void goHome() {
        findElementByCssLocated(home).click();
    }

    /**
     * This method redirect us to menu item page
     */
    public static void goToPage(NavigationMenu menu) {
        String menuItem = navigationMenu + " a[href$='/" + menu.getStr() + "']";
        WebElement element = findElementByCssLocated(menuItem);
        String path = element.getAttribute("href");
        String[] parts = path.replace(getBaseURL(), "").split("/");
        StringBuilder newPath = new StringBuilder();
        for (String part : parts) {
            newPath.append(part);
            String item = navigationMenu + " a[href$='/" + newPath + "']";
            new Actions(driver).moveToElement(findElementByCssLocated(item)).perform();
            newPath.append("/");
        }
        element.click();
        logger.info("Go to item: " + menu.getStr());
    }

    public static WebElement getLastBreadCrumb() {
        List<WebElement> list = findElementsByCssLocated(breadCrumb);
        return Iterables.getLast(list);
    }
}