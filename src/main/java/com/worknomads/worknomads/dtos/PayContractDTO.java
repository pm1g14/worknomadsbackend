package com.worknomads.worknomads.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayContractDTO {

    private final String contractAddress;
    private final double amount;
    private final String paymentUnit;
    private final String toWallet;

    @JsonCreator
    public PayContractDTO(
            @JsonProperty("contractAddress") String contractAddress,
            @JsonProperty("amount") double amount,
            @JsonProperty("paymentUnit") String paymentUnit,
            @JsonProperty("toWallet") String toWallet) {
        this.contractAddress = contractAddress;
        this.amount = amount;
        this.paymentUnit = paymentUnit;
        this.toWallet = toWallet;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentUnit() {
        return paymentUnit;
    }

    public String getToWallet() {
        return toWallet;
    }
}
