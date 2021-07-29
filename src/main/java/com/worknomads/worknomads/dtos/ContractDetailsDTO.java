package com.worknomads.worknomads.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ContractDetailsDTO {

    private final String contractExpiry;
    private final double grossSalary;
    private final String remoteLocation;
    private final int paymentInstallments;
    private final String paymentTerm;
    private final String balanceUnit;

    @JsonCreator
    public ContractDetailsDTO(
            @JsonProperty("contractExpiry") String contractExpiry,
            @JsonProperty("remoteLocation") String remoteLocation,
            @JsonProperty("grossSalary") double grossSalary,
            @JsonProperty("paymentInstallments") int paymentInstallments,
            @JsonProperty("paymentTerm") String paymentTerm,
            @JsonProperty("balanceUnit") String balanceUnit) {
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
