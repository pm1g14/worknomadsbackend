package com.worknomads.worknomads.enums;

import org.web3j.abi.datatypes.primitive.Char;

public enum  ContractPaymentTerm {

    Daily("Daily"),
    Weekly("Weekly"),
    Monthly("Monthly"),
    Quarterly("3 Months"),
    Semiannually("6 Months"),
    Yearly("Yearly");

    public final String term;

    ContractPaymentTerm(String term) {
        this.term = term;
    }


}
