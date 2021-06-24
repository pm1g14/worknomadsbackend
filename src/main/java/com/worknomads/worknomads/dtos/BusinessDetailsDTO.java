package com.worknomads.worknomads.dtos;

public class BusinessDetailsDTO {

    private final String name;
    private final String address;
    private final String email;
    private final String phone;
    //TODO add fields for payment details?


    public BusinessDetailsDTO(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
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
}
