package com.Roman3PT;

import com.Roman3PT.service.IService;
import org.junit.Assert;
import org.testng.annotations.Test;

public class YotecMainTest implements IService {

    @Test
    public void mainPageVisible() {
        Assert.assertTrue(mainPage.getMainSlider().isDisplayed());
    }
}