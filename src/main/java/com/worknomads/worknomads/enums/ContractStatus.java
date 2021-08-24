package com.worknomads.worknomads.enums;

public enum ContractStatus {


    ACTIVE("active"),
    EXPIRED("expired"),
    VOIDED("voided");

    public final String status;

    ContractStatus(String status) {
            this.status = status;
        }

}
