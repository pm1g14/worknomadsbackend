package com.worknomads.worknomads.ethereum.utils;

import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.util.function.Function;

public class AmountConversionUtils {

    public static Function<BigDecimal, BigDecimal> convertEthToWei = (a) -> Convert.toWei(a, Convert.Unit.ETHER);
}
