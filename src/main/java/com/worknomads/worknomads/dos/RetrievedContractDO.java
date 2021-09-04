package com.worknomads.worknomads.dos;

import com.worknomads.worknomads.enums.ContractPaymentTerm;

public class RetrievedContractDO {

    private final String address;
    private final String businessPartner;
    private final String employeeName;
    private final String employeeSur;
    private final String employeeEmail;
    private final ContractPaymentTerm term;
    private final double nextPaymentAmount;
    private final double remainingBalance;
    private final boolean isActive;

    public RetrievedContractDO(String contractAddress, String businessPartner, String employeeName, String employeeSur, String employeeEmail, ContractPaymentTerm term, double nextPaymentAmount, double remainingBalance, boolean isActive) {
        this.address = contractAddress;
        this.businessPartner = businessPartner;
        this.employeeName = employeeName;
        this.employeeSur = employeeSur;
        this.employeeEmail = employeeEmail;
        this.term = term;
        this.nextPaymentAmount = nextPaymentAmount;
        this.remainingBalance = remainingBalance;
        this.isActive = isActive;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSur() {
        return employeeSur;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public ContractPaymentTerm getTerm() {
        return term;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public double getNextPaymentAmount() {
        return nextPaymentAmount;
    }


    public String getBusinessPartner() {
        return businessPartner;
    }

    public String getAddress() {
        return address;
    }
}
