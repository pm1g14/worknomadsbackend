package ethereum.impl;

import com.worknomads.worknomads.dos.ContractDO;
import ethereum.EthNetworkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.tx.RawTransactionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class EthNetworkAPIImpl implements EthNetworkAPI {


    @Autowired
    private Environment env;
    Logger logger = LoggerFactory.getLogger(EthNetworkAPI.class);

    @Override
    public void createAndPublishContract(ContractDO contractContents, String cid) {
        //TODO investigate how to create wallets on the go
        //Optional<File> walletFileLocation = Optional.of(new File(env.getProperty("employee.wallet.location")));
        Web3j web3 = getConnection();
//        try {
            //createWallet(password, walletFileLocation.orElseThrow(FileNotFoundException::new));
//            EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.PENDING).send();
//
//            BigInteger nonce =  ethGetTransactionCount.getTransactionCount();
//            String encodedConstructor =
//                    FunctionEncoder.encodeConstructor(
//                            Arrays.asList(
//                                    new Type(cid),
//                                    new Type(contractContents.getEmployeeName()),
//                                    new Type(contractContents.getEmployeeSur()),
//                                    new Type(contractContents.getContractDetails().getDuration()),
//                                    new Type(contractContents.getContractDetails().getTerm()),
//                                    new Type(contractContents.getCountryOfResidence()),
//                                    new Type(contractContents.getContractDetails().getPaymentTerm())
//                            )
//                    );
//            RawTransaction rawTransaction = RawTransaction.createContractTransaction(
//                    nonce,
//                    web3.ethGasPrice,
//
//
//            );
//            RawTransactionManager transactionManager = new RawTransactionManager(web3, credentials);
//
//            EthSendTransaction transaction = transactionManager.signAndSend(rawTransaction);
//            logger.debug("transaction hash = {}", transaction.getTransactionHash());

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

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

}
