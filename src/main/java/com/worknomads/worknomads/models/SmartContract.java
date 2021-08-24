package com.worknomads.worknomads.models;

import javax.persistence.*;

@Entity
@Table(name = "SmartContract")
public class SmartContract {

    @Id
    private String address;
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String status;
    private String business_partner_wallet_address;

    public SmartContract() {}

    public SmartContract(String address, String status, String business_partner_wallet_address) {
        this.address = address;
        this.status = status;
        this.business_partner_wallet_address = business_partner_wallet_address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBusiness_partner_wallet_address(String business_partner_wallet_address) {
        this.business_partner_wallet_address = business_partner_wallet_address;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }


    public String getBusiness_partner_wallet_address() {
        return business_partner_wallet_address;
    }

    public Integer getId() {
        return id;
    }
}
