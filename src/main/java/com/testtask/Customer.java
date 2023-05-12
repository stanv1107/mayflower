package com.testtask;

public class Customer {

    private final String customerName;
    private final String contactName;
    private final String address;
    private final String city;
    private final String postalCode;
    private final String country;

    public Customer(String customerName, String contactName, String address, String city, String postalCode, String country) {
        this.customerName = customerName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

}