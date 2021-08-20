package com.worknomads.worknomads.dtos;

import java.util.List;

public class BusinessPartnerDTO {
    private final String name;
    private final String address;
    private final String email;
    private final String phone;
    private String walletAddress;
    private List<Contract2DTO> contracts2;

    public BusinessPartnerDTO(String name, String address, String email, String phone, String walletAddress, List<Contract2DTO> contracts2) {
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
}
