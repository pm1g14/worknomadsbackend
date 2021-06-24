package com.worknomads.worknomads.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ContractDTO {

    private final String contractId;

    @JsonProperty(namespace="employeeName") private final String employeeName;
    @JsonProperty(namespace="employeeSur") private final String employeeSur;
    @JsonProperty(namespace="address") private final String address;
    @JsonProperty(namespace="countryOfResidence") private final String countryOfResidence;
    @JsonProperty(namespace="email") private final String email;
    @JsonProperty(namespace="phoneNum") private final String phoneNum;
    @JsonProperty(namespace="contractDetails") private final ContractDetailsDTO contractDetails;

    public ContractDTO(String employeeName, String employeeSur, String address, String country, String email, String phoneNum, ContractDetailsDTO contractDetails) {
        this.employeeName = employeeName;
        this.address = address;
        this.employeeSur = employeeSur;
        this.countryOfResidence = country;
        this.email = email;
        this.phoneNum = phoneNum;
        this.contractDetails = contractDetails;
        this.contractId = ""; //TODO implement a logic to provide a unique contractId for each contract
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSur() {
        return employeeSur;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public ContractDetailsDTO getContractDetails() {
        return contractDetails;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public String getContractId() {
        return contractId;
    }
}
