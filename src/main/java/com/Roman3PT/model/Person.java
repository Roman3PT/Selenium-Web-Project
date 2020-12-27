package com.Roman3PT.model;

/**
 * Its a class for form 'Contact Us'
 */
public class Person {

    private String name;
    private String company;
    private String email;
    private String phone;
    private String country;

    public Person(String name, String company, String email, String phone, String country) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }
}