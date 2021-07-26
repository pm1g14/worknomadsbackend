package com.worknomads.worknomads.dtos;

public final class ContractDetailsDTO {

    private final String contractExpiry;
    private final double grossSalary;
    private final String remoteLocation;
    private final int paymentInstallments;
    private final String paymentTerm;
    private final String balanceUnit;
    //

    public ContractDetailsDTO(String contractExpiry, String remoteLocation, double grossSalary, int paymentInstallments, String paymentTerm, String balanceUnit) {
        this.contractExpiry = contractExpiry;
        this.grossSalary = grossSalary;
        this.remoteLocation = remoteLocation;
        this.paymentInstallments = paymentInstallments;
        this.balanceUnit = balanceUnit;
        this.paymentTerm = paymentTerm;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public String getRemoteLocation() {
        return remoteLocation;
    }

    public int getPaymentInstallments() {
        return paymentInstallments;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public String getContractExpiry() {
        return contractExpiry;
    }

    public String getBalanceUnit() {
        return balanceUnit;
    }
}
