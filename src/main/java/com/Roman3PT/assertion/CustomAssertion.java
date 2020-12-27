package com.Roman3PT.assertion;

import com.Roman3PT.helper.CustomHelper;
import com.Roman3PT.service.DriverWebService;
import org.testng.Assert;

public class CustomAssertion {

    private static final DriverWebService service = new DriverWebService();

    public static void assertURL(String expectedURL, String actualURL) {
        Assert.assertEquals(expectedURL, CustomHelper.getLastLocatorFromURL(actualURL));
    }

}