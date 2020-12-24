package com.Roman3PT;

public enum NavigationMenu {

    WE_ARE_WABASH("\"We Are Wabash\""),
    TRADITION_OF_INNOVATION("\"Tradition of Innovation\""),
    OUR_PRODUCTS("\"Our Products\""),
    OUR_BANDS("\"Our Brands\""),
    WORK_WITH_WABASH("\"Work With Wabash\""),
    TIMELINE("\"Timeline\""),
    LOCATION_SEARCH("Location Search");

    private String str;

    NavigationMenu(String str) {
        this.str = str;
    }
}