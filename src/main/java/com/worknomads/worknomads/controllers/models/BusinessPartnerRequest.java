package com.worknomads.worknomads.controllers.models;

import com.worknomads.worknomads.dtos.Contract2DTO;

import java.util.List;

public class BusinessPartnerRequest {
    private String name;
    private String email;
    private String walletAddress;
    private String address;
    private String phone;
    private List<Contract2DTO> contracts2;

    public BusinessPartnerRequest(String name, String address, String email, String phone, String walletAddress, List<Contract2DTO> contracts2) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.walletAddress = walletAddress;
        this.contracts2 = contracts2;
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

    public List<Contract2DTO> getContracts2() {
        return contracts2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public void setContracts2(List<Contract2DTO> contracts2) {
        this.contracts2 = contracts2;
    }
}
