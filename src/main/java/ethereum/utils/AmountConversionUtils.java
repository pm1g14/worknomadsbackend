package ethereum.utils;

import java.math.BigInteger;
import java.util.function.Function;

public class AmountConversionUtils {

    public static Function<BigInteger, BigInteger> convertEthToWei = (a) -> {
        BigInteger oneWeiToEth = new BigInteger("1000000000000000000");
        return a.multiply(oneWeiToEth);
    };
}
