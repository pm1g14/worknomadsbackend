package com.worknomads.worknomads.enums;

import org.web3j.abi.datatypes.primitive.Char;

public enum  ContractPaymentTerm {

    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    QUARTERLY("3 Months"),
    SEMIANNUALLY("6 Months"),
    ANNUALLY("Yearly");

    public final String term;

    ContractPaymentTerm(String term) {
        this.term = term;
    }


}
