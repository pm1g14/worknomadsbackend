package com.worknomads.worknomads.enums;

import org.web3j.abi.datatypes.primitive.Char;

public enum  ContractPaymentTerm {

    DAILY("DA"),
    WEEKLY("WE"),
    MONTHLY("MO"),
    QUARTERLY("3MO"),
    SEMIANNUALLY("6MO"),
    ANNUALLY("YE");

    public final String term;

    ContractPaymentTerm(String term) {
        this.term = term;
    }


}
