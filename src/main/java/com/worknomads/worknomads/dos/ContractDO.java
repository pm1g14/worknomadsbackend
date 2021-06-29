package com.worknomads.worknomads.dos;

public class ContractDO {

    private final String contractId;
    private final String employeeName;
    private final String employeeSur;
    private final String address;
    private final String countryOfResidence;
    private final String email;
    private final String phoneNum;
    private final String companyWalletAddr;
    private final String employeeWalletAddr;
    private final ContractDetailsDO contractDetails;

    public ContractDO(String employeeName, String employeeSur, String address, String country, String email, String phoneNum, String companyWalletAddr, String employeeWalletAddr, ContractDetailsDO contractDetails) {
        this.employeeName = employeeName;
        this.address = address;
        this.employeeSur = employeeSur;
        this.countryOfResidence = country;
        this.email = email;
        this.phoneNum = phoneNum;
        this.contractDetails = contractDetails;
        this.companyWalletAddr = companyWalletAddr;
        this.employeeWalletAddr = employeeWalletAddr;
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

    public ContractDetailsDO getContractDetails() {
        return contractDetails;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public String getContractId() {
        return contractId;
    }

    public String getCompanyWalletAddr() {
        return companyWalletAddr;
    }

    public String getEmployeeWalletAddr() {
        return employeeWalletAddr;
    }
}
