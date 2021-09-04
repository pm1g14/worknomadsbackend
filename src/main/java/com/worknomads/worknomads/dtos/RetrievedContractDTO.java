package com.worknomads.worknomads.dtos;

public class RetrievedContractDTO {

    private final String address;
    private final String businessPartner;
    private final String employeeName;
    private final String employeeSurname;
    private final String employeeEmail;
    private final String term;
    private final double nextPaymentAmount;
    private final double remainingBalance;
    private final boolean isActive;

    public RetrievedContractDTO(String contractAddress, String businessPartner, String employeeName, String employeeSur, String employeeEmail, String term, double nextPaymentAmount, double remainingBalance, boolean isActive) {
        this.address = contractAddress;
        this.businessPartner = businessPartner;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSur;
        this.employeeEmail = employeeEmail;
        this.term = term;
        this.nextPaymentAmount = nextPaymentAmount;
        this.remainingBalance = remainingBalance;
        this.isActive = isActive;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getTerm() {
        return term;
    }

    public double getNextPaymentAmount() {
        return nextPaymentAmount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getBusinessPartner() {
        return businessPartner;
    }

    public String getAddress() {
        return address;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }
}
