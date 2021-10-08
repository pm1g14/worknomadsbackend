package com.worknomads.worknomads.ethereum;

import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import com.worknomads.worknomads.ethereum.constants.EnvironmentConstants;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;


public interface EthNetworkAPI {

    default Web3j getConnection() {
        return Web3j.build(new HttpService(EnvironmentConstants.ethServiceUrl));
    }

    CompletableFuture<TransactionReceipt> createAndPublishContract(ContractDO contractContents) throws TransactionException;

    RetrievedContractDO getContractDetailsFromAddress(String contractAddress, String businessPartnerName) throws TransactionException;

    void createWallet(String password, File location);

    String payContract(String contractAddress, BigInteger amount, String toWallet) throws TransactionException;

}
