package com.Roman3PT.page;

import com.Roman3PT.service.MainWebService;
import org.openqa.selenium.WebElement;

public class YotecMainPage extends MainWebService {

    private static final String mainSlider = "div[class='slider-home']";
    private static final String navigationMenu = "div[class^='navigation'] ul[id$='navigationUl'] ";

    public WebElement getMainSlider() {
        return findElementByCssLocated(mainSlider);
    }
}