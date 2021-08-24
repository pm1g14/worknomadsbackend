package com.worknomads.worknomads.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ContractDTO {

    private final String employeeName;
    private final String employeeSurname;
    private final String address;
    private final String countryOfResidence;
    private final String email;
    private final String phoneNumber;
    private final String companyWalletAddress;
    private final String employeeWalletAddress;
    private final ContractDetailsDTO contractDetails;


    @JsonCreator
    public ContractDTO(
            @JsonProperty("employeeName") String employeeName,
            @JsonProperty("employeeSurname") String employeeSur,
            @JsonProperty("address") String address,
            @JsonProperty("countryOfResidence") String country,
            @JsonProperty("email") String email,
            @JsonProperty("phoneNumber") String phoneNum,
            @JsonProperty("companyWalletAddress") String senderWalletAddr,
            @JsonProperty("contractDetails") ContractDetailsDTO contractDetails,
            @JsonProperty("employeeWalletAddress") String employeeWalletAddress) {
        this.employeeName = employeeName;
        this.address = address;
        this.employeeSurname = employeeSur;
        this.countryOfResidence = country;
        this.email = email;
        this.phoneNumber = phoneNum;
        this.contractDetails = contractDetails;
        this.companyWalletAddress = senderWalletAddr;
        this.employeeWalletAddress = employeeWalletAddress;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public ContractDetailsDTO getContractDetails() {
        return contractDetails;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public String getCompanyWalletAddress() {
        return companyWalletAddress;
    }

    public String getEmployeeWalletAddress() {
        return employeeWalletAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
