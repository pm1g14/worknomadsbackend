package com.worknomads.worknomads.controllers.models;

public class RegisterCompanyRequest {
    private String name;
    private String address;
    private String email;
    private String phone;
    private String walletAddress;

    public RegisterCompanyRequest(String name, String address, String email, String phone, String walletAddress) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.walletAddress = walletAddress;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }
}
