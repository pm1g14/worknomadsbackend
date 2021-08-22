package com.worknomads.worknomads.dtos;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String walletAddress;
    private String countryOfResidence;
    private String phoneNum;

    public EmployeeDTO() {}

    public EmployeeDTO(String name, String surname, String address, String countryOfResidence, String email, String phoneNum, String walletAddress) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.countryOfResidence = countryOfResidence;
        this.email = email;
        this.phoneNum = phoneNum;
        this.walletAddress = walletAddress;
    }

    public Integer getId(){
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

    public void setId(Integer id) {
        this.id = id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}