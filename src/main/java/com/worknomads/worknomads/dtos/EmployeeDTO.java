package com.worknomads.worknomads.dtos;

public class EmployeeDTO {
    private Integer id;
    private final String name;
    private final String surname;
    private final String address;
    private final String email;
    private final String walletAddress;
    private final String countryOfResidence;
    private final String phoneNum;

    public EmployeeDTO(Integer id, String name, String surname, String address, String countryOfResidence, String email, String phoneNum, String walletAddress) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.countryOfResidence = countryOfResidence;
        this.email = email;
        this.phoneNum = phoneNum;
        this.walletAddress = walletAddress;
    }

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

}