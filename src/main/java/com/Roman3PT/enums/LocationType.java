package com.Roman3PT.enums;

public enum LocationType {

    SALES("Sales"),
    WARRANTY("Warranty"),
    SERVICE("Service");

    private String name;

    LocationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}