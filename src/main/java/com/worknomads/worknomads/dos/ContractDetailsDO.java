package com.worknomads.worknomads.dos;

import com.worknomads.worknomads.enums.BalanceUnit;
import com.worknomads.worknomads.enums.ContractPaymentTerm;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Locale;

public class ContractDetailsDO {

    private final ZonedDateTime contractExpiry;
    private final ZonedDateTime dateOfCreation;
    private final double grossSalary;
    private final Locale remoteLocation;
    private final int paymentInstallments;
    private final BalanceUnit balanceUnit;
    private final ContractPaymentTerm paymentTerm;


    public ContractDetailsDO(ZonedDateTime contractExpiry, Locale remoteLocation, double grossSalary, int paymentInstallments, ContractPaymentTerm paymentTerm, BalanceUnit balanceUnit) {
        this.contractExpiry = contractExpiry;
        this.grossSalary = grossSalary;
        this.remoteLocation = remoteLocation;
        this.paymentInstallments = paymentInstallments;
        this.paymentTerm = paymentTerm;
        this.balanceUnit = balanceUnit;
        this.dateOfCreation = ZonedDateTime.now();
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public Locale getRemoteLocation() {
        return remoteLocation;
    }

    public int getPaymentInstallments() {
        return paymentInstallments;
    }

    public ContractPaymentTerm getPaymentTerm() {
        return paymentTerm;
    }

    public ZonedDateTime getContractExpiry() {
        return contractExpiry;
    }

    public ZonedDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public Duration getRemainingTime() {
        return Duration.between(contractExpiry, dateOfCreation);
    }

    public BalanceUnit getBalanceUnit() {
        return balanceUnit;
    }
}
