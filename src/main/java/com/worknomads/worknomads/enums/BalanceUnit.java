package com.worknomads.worknomads.enums;

public enum BalanceUnit {

    ETHEREUM("ETH"),
    USDT("USDT");

    public final String unit;

    BalanceUnit(String unit) {
        this.unit = unit;
    }
}
