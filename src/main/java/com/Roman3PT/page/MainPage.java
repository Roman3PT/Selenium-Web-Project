package com.Roman3PT.page;

import org.openqa.selenium.WebElement;

public class MainPage extends TemplatePage {

    private static final String mainSlider = "div[class='slider-home']";

    public WebElement getMainSlider() {
        return findElementByCssLocated(mainSlider);
    }
}