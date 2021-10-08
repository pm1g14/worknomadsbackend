package com.worknomads.worknomads.ethereum.gasprovider;

import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

public class CustomGasProvider implements ContractGasProvider {


    public CustomGasProvider() {
    }

    @Override
    public BigInteger getGasPrice(String s) {
        return getGasPrice();
    }

    @Override
    public BigInteger getGasPrice() {
        return BigInteger.valueOf(20000000000L);
    }

    @Override
    public BigInteger getGasLimit(String s) {
        return getGasLimit();
    }

    @Override
    public BigInteger getGasLimit() {return BigInteger.valueOf(6721975L);
    }
}
