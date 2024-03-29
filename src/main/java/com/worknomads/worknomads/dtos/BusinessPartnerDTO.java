package com.worknomads.worknomads.dtos;

import java.util.List;

public class BusinessPartnerDTO {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String walletAddress;
    private List<Contract2DTO> contracts2;

    public BusinessPartnerDTO() {}

    public BusinessPartnerDTO(String name, String address, String email, String phone, String walletAddress, List<Contract2DTO> contracts2) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.walletAddress = walletAddress;
        this.contracts2 = contracts2;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId(){
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
        return phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public List<Contract2DTO> getContracts2() {
        return contracts2;
    }
}
