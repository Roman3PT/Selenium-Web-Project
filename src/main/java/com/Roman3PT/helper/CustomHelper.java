package com.Roman3PT.helper;

import com.google.common.collect.Iterables;

import java.util.Arrays;

public class CustomHelper {

    public static String getLastLocatorFromURL(String url) {
        String[] locators = url.split("/");
        return Iterables.getLast(Arrays.asList(locators.clone()));
    }
}