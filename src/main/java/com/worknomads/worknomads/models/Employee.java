package com.worknomads.worknomads.models;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String country_of_residence;
    private String email;
    private String phone_num;

    @Id
    private String wallet_address;

    protected Employee() {}

    public Employee(String employeeName, String employeeSur, String address, String countryOfResidence, String email, String phoneNum, String walletAddress) {
        this.name = employeeName;
        this.surname = employeeSur;
        this.address = address;
        this.country_of_residence = countryOfResidence;
        this.email = email;
        this.phone_num = phoneNum;
        this.wallet_address = walletAddress;
    }

    public Integer getId() {
        return id;
    }
    public String getEmployeeName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getCountryOfResidence() {
        return country_of_residence;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phone_num;
    }

    public String getWalletAddress() {
        return wallet_address;
    }
}
