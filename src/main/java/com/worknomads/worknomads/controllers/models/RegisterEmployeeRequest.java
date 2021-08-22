package com.worknomads.worknomads.controllers.models;

public class RegisterEmployeeRequest {
    private String name;
    private String surname;
    private String address;
    private String countryOfResidence;
    private String email;
    private String phoneNum;
    private String walletAddress;

    public RegisterEmployeeRequest(String employeeName, String employeeSur, String address, String countryOfResidence, String email, String phoneNum, String employeeWalletAddress) {
        this.name = employeeName;
        this.surname = employeeSur;
        this.address = address;
        this.countryOfResidence = countryOfResidence;
        this.email = email;
        this.phoneNum = phoneNum;
        this.walletAddress = employeeWalletAddress;
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

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }
}
