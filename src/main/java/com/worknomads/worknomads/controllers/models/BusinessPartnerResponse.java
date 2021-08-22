package com.worknomads.worknomads.controllers.models;

import com.worknomads.worknomads.dtos.Contract2DTO;

import java.util.List;

public class BusinessPartnerResponse {
    private Integer id;
    private String name;
    private String email;
    private String walletAddress;
    private String address;
    private String contactNumber;
    private List<Contract2DTO> contracts2;

    public BusinessPartnerResponse(Integer id, String name, String address, String email, String phone, String walletAddress, List<Contract2DTO> contracts2) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contactNumber = phone;
        this.walletAddress = walletAddress;
        this.contracts2 = contracts2;
    }

    public Integer getId() {
        return id;
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
        return contactNumber;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public void setContracts2(List<Contract2DTO> contracts2) {
        this.contracts2 = contracts2;
    }
}
