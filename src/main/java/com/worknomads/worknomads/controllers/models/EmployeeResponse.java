package com.worknomads.worknomads.controllers.models;

public class EmployeeResponse {
    private Integer id;
    private final String name;
    private final String surname;
    private final String address;
    private final String email;
    private final String walletAddress;

    private final String countryOfResidence;
    private final String phoneNum;

    public EmployeeResponse(Integer id, String name, String surname, String address, String email, String walletAddress, String countryOfResidence, String phoneNum) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.walletAddress = walletAddress;
        this.countryOfResidence = countryOfResidence;
        this.phoneNum = phoneNum;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
