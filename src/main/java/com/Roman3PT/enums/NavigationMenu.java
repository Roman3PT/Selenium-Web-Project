package com.Roman3PT.enums;

public enum NavigationMenu {

    MANUFACTURING_SAFETY("manufacturing-safety"),
    FUTURE_FOCUS("future-focus"),
    CORROSIVES("corrosives"),
    PARTS_SERVICE("parts-service"),
    MY_HR("my-hr"),
    TIMELINE("timeline"),
    DEALER("dealer");

    private String str;

    NavigationMenu(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}