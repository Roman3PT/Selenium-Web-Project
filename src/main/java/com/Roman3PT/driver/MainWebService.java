package com.Roman3PT.driver;

public class MainWebService extends GoogleChromeInitializer {

    public void openPage(String url) {
        driver.get(url);
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public void quit() {
        driver.quit();
    }

}