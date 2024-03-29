package com.worknomads.worknomads.models;

import javax.persistence.*;

@Entity
@Table(name = "BusinessPartner")
public class BusinessPartner {


    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;

    @Id
    private String wallet_address;

    protected BusinessPartner() {}

    public BusinessPartner(String name, String address, String email, String phone, String walletAddress) {

        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.wallet_address = walletAddress;
    }

    @Override
    public String toString() {
        return "";
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
        return phone;
    }

    public String getWalletAddress() {
        return wallet_address;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setWalletAddress(String walletAddress) {
        this.wallet_address = walletAddress;
    }
}
