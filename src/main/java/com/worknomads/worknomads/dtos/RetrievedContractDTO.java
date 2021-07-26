package com.worknomads.worknomads.dtos;

public class RetrievedContractDTO {

    private final String employeeName;
    private final String employeeSur;
    private final String employeeEmail;
    private final String term;
    private final double nextPaymentAmount;
    private final double remainingBalance;
    private final boolean isActive;

    public RetrievedContractDTO(String employeeName, String employeeSur, String employeeEmail, String term, double nextPaymentAmount, double remainingBalance, boolean isActive) {
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
}
