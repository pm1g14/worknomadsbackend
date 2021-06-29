package com.worknomads.worknomads.dos;

import com.worknomads.worknomads.enums.ContractPaymentTerm;

import java.time.ZonedDateTime;
import java.util.Locale;

public class ContractDetailsDO {

    private final int duration;
    private final String term;
    private final double grossSalary;
    private final Locale remoteLocation;
    private final int paymentInstallments;
    private final ContractPaymentTerm paymentTerm;
    private final ZonedDateTime dateOfCreation;

    public ContractDetailsDO(int duration, String term, Locale remoteLocation, double grossSalary, int paymentInstallments, ContractPaymentTerm paymentTerm) {
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

    public Locale getRemoteLocation() {
        return remoteLocation;
    }

    public int getPaymentInstallments() {
        return paymentInstallments;
    }

    public ContractPaymentTerm getPaymentTerm() {
        return paymentTerm;
    }
}
