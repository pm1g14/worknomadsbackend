package ethereum.utils;

import ethereum.EthNetworkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Optional;

public class ContractTransactionUtils {

    private static Logger logger = LoggerFactory.getLogger(EthNetworkAPI.class);

    public static Optional<Credentials> loadCredentials() {
        String sourceFile = "C:\\Users\\panosmav\\AppData\\Roaming\\Ethereum\\testnet\\keystore\\UTC--2021-08-16T19-46-41.527495000Z--816f37f9d8088b7ec15808b5c0811b217849614d.json";
        String password = "paokaraoleG41";
        Credentials credentials = null;
        try {
            logger.debug("Invoking credentials...");
            return Optional.of(WalletUtils.loadCredentials(password, sourceFile));
        } catch (IOException e) {
            logger.debug("File was not found, returning empty...");

        } catch (CipherException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static BigInteger getNonceForAccount(Web3j web3j, String account) {
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                account, DefaultBlockParameterName.LATEST).sendAsync().join();

        return ethGetTransactionCount.getTransactionCount();
    }

    public static String signMessage(BigInteger nonce, String encodedFunction, String contractAddress, int networkChainId, Credentials credentials, String functionToCall) {
        DefaultGasProvider gasProvider = new DefaultGasProvider();

        BigInteger gasPrice = gasProvider.getGasPrice();
        BigInteger gasLimit = gasProvider.getGasLimit(functionToCall);
        RawTransaction transaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, contractAddress, encodedFunction);
        byte[] signedMessage = TransactionEncoder.signMessage(transaction, networkChainId, credentials);
        return Numeric.toHexString(signedMessage);
    }
}
