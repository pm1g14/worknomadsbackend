package ethereum.impl;

import com.worknomads.worknomads.dos.ContractDO;
import ethereum.EthNetworkAPI;
import ethereum.wrappers.EmploymentContract_sol_EmploymentContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.CompletableFuture;

public class EthNetworkAPIImpl implements EthNetworkAPI {


    @Autowired
    private Environment env;
    private Logger logger = LoggerFactory.getLogger(EthNetworkAPI.class);

    @Override
    public CompletableFuture<TransactionReceipt> createAndPublishContract(ContractDO contractContents, String cid) {
        //TODO investigate how to create wallets on the go
        //Optional<File> walletFileLocation = Optional.of(new File(env.getProperty("employee.wallet.location")));
        //   createWallet(password, walletFileLocation.orElseThrow(FileNotFoundException::new));

        Web3j web3 = getConnection();
        TransactionManager transactionManager = new ClientTransactionManager(web3, contractContents.getCompanyWalletAddr());

        return EmploymentContract_sol_EmploymentContract.deploy(
                web3,
                transactionManager,
                new DefaultGasProvider(),
                cid,
                contractContents.getEmployeeName(),
                contractContents.getEmployeeSur(),
                contractContents.getCountryOfResidence(),
                contractContents.getContractDetails().getPaymentTerm().term,
                contractContents.getContractDetails().getBalanceUnit().unit,
                BigInteger.valueOf(contractContents.getContractDetails().getContractExpiry().toEpochSecond())
        ).sendAsync().thenApply(this::tryGettingReceiptOrThrow);
    }

    @Override
    public void createWallet(String password, File location) {
        try {
            WalletUtils.generateNewWalletFile(password, location);
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private TransactionReceipt tryGettingReceiptOrThrow(EmploymentContract_sol_EmploymentContract contract) {
        logger.debug("receiving contract receipt...");
        TransactionReceipt receipt = null;
        try {
            receipt = contract.getTransactionReceipt().orElseThrow(
                    () -> new TransactionException("Employment contract was not created.")
            );
        } catch (TransactionException e) {
            e.getMessage();
        }
        logger.debug("received transaction receipt: "+receipt);
        return receipt;
    }

}
