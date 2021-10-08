package com.worknomads.worknomads.ethereum.utils;

import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.ethereum.EthNetworkAPI;
import com.worknomads.worknomads.ethereum.constants.EnvironmentConstants;
import com.worknomads.worknomads.ethereum.gasprovider.CustomGasProvider;
import com.worknomads.worknomads.ethereum.wrappers.EmploymentContract_sol_EmploymentContract;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public class ContractTransactionUtils {

    private static Logger logger = LoggerFactory.getLogger(EthNetworkAPI.class);

    public static Optional<Credentials> loadCredentials(String password, String sourceFile) {

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
        CustomGasProvider gasProvider = new CustomGasProvider();

        BigInteger gasPrice = gasProvider.getGasPrice();
        BigInteger gasLimit = gasProvider.getGasLimit(functionToCall);
        RawTransaction transaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, contractAddress, encodedFunction);
        byte[] signedMessage = TransactionEncoder.signMessage(transaction, networkChainId, credentials);
        return Numeric.toHexString(signedMessage);
    }

    public static Optional<Credentials> getSignWalletCredentials() {
        String sourceFile = "C:\\Users\\panosmav\\AppData\\Roaming\\Ethereum\\testnet\\keystore\\UTC--2021-08-16T19-46-41.527495000Z--816f37f9d8088b7ec15808b5c0811b217849614d.json";
        String password = "paokaraoleG41";
        return ContractTransactionUtils.loadCredentials(password, sourceFile);
    }

    public static void sucessOrRollbackContractCreation(String from, String to, Throwable ex, Credentials credentials, TransactionReceipt receipt, Web3j web3j) {
        if (ex != null) {
            loadAndDestroyContract(from, to, credentials, web3j);
            web3j.shutdown();
        }
        else logger.debug("Successfully created and topped up contract, transaction hash: "+receipt.getTransactionHash());
    }

    public static void handleNonRetrievableCredentials(Optional<Credentials> credentials) throws TransactionException {
        if (!credentials.isPresent()) throw new TransactionException("Wallet credentials could not be retrieved, can't sign transaction.");
    }

    public static Credentials createCredentialsFromPassword(String password) throws TransactionException {
        if (StringUtils.isEmpty(password)) throw new TransactionException("Credentials could not be created for empty password");
        return Credentials.create(EnvironmentConstants.walletPrivate);
    }

    public static EmploymentContract_sol_EmploymentContract loadContractFromAddress(String contractAddress, Web3j web3, Credentials credentials) {
        return EmploymentContract_sol_EmploymentContract.load(
                contractAddress, web3, credentials, new DefaultGasProvider());
    }

    public static void transferBalanceToNewContract(ContractDO contractContents, Web3j web3j, Credentials credentials, TransactionReceipt receipt) {
        try {
            BigInteger nonce = ContractTransactionUtils.getNonceForAccount(web3j, EnvironmentConstants.signWalletGanache);
            //TODO remove these and add separate transaction wallets for each company

            RawTransaction transaction = RawTransaction.createEtherTransaction(nonce, new CustomGasProvider().getGasPrice(), new CustomGasProvider().getGasLimit(), receipt.getContractAddress(), BigDecimal.valueOf(contractContents.getContractDetails().getGrossSalary()).toBigInteger());
            String signed = new RawTransactionManager(
                    web3j,
                    credentials,
                    EmploymentContract_sol_EmploymentContract.GANACHE_CHAIN_ID).sign(transaction);
            web3j.ethSendRawTransaction(signed).sendAsync();
        } catch (Throwable t) {
            ContractTransactionUtils.sucessOrRollbackContractCreation(EnvironmentConstants.signWalletGanache, receipt.getContractAddress(), t, credentials, receipt, web3j);
            web3j.shutdown();
        }
    }

    private static void loadAndDestroyContract(String from, String to, Credentials credentials, Web3j web3j) {
        EmploymentContract_sol_EmploymentContract contractInstance = loadContractFromAddress(to, web3j, credentials);
        contractInstance.kill(from);
    }
}
