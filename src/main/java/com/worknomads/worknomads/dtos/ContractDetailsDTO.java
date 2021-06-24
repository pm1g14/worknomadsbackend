package com.worknomads.worknomads.dtos;

import java.time.ZonedDateTime;

public final class ContractDetailsDTO {

    private final int duration;
    private final String term;
    private final double grossSalary;
    private final String remoteLocation;
    private final int paymentInstallments;
    private final String paymentTerm;
    private final ZonedDateTime dateOfCreation;

    public ContractDetailsDTO(int duration, String term, String remoteLocation, double grossSalary, int paymentInstallments, String paymentTerm) {
        this.duration = duration;
        this.grossSalary = grossSalary;
        this.term = term;
        this.remoteLocation = remoteLocation;
        this.paymentInstallments = paymentInstallments;
        this.paymentTerm = paymentTerm;
        this.dateOfCreation = ZonedDateTime.now();
    }

    public int getDuration() {
        return duration;
    }

    public String getTerm() {
        return term;
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
}
