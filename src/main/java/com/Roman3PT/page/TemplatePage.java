package com.Roman3PT.page;

import com.Roman3PT.enums.NavigationMenu;
import com.Roman3PT.model.Person;
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

    protected static final String navigationMenu = "div[class^='navigation'] ul[id$='navigationUl']";
    protected static final String breadCrumb = "a[class='rsmLink']";
    protected static final String home = "a[href$='home']";

    protected static final String choiceContactForm = "select[id$='dropDown']";
    protected static final String countryContactForm = "select[id$='dropDownCountry']";
    protected static final String nameContactForm = "input[placeholder='Name']";
    protected static final String companyContactForm = "input[placeholder='Company']";
    protected static final String emailContactForm = "input[placeholder='Email']";
    protected static final String phoneContactForm = "input[placeholder='Phone']";
    protected static final String commentsContactForm = "textarea[placeholder='Comments']";
    protected static final String submitContactForm = "input[value='Submit']";
    protected static final String successMessage = "div[id$='successMessage']";

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

    public static void contactUs(Person person) {
        chooseOptionFromSelect(choiceContactForm, "Third Choice");
        chooseOptionFromSelect(countryContactForm, person.getCountry());
        findElementByCssLocated(nameContactForm).sendKeys(person.getName());
        findElementByCssLocated(companyContactForm).sendKeys(person.getCompany());
        findElementByCssLocated(emailContactForm).sendKeys(person.getEmail());
        findElementByCssLocated(phoneContactForm).sendKeys(person.getPhone());
        findElementByCssLocated(commentsContactForm).sendKeys("I'm Java Programmer)))");
        findElementByCssLocated(submitContactForm).click();
    }

    public static WebElement getLastBreadCrumb() {
        List<WebElement> list = findElementsByCssLocated(breadCrumb);
        return Iterables.getLast(list);
    }

    public static WebElement getSuccessMessage() {
        return findElementByCssLocated(successMessage);
    }
}