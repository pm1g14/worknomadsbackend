package com.worknomads.worknomads.services.contracts.impl;

import com.worknomads.worknomads.dtos.PayContractDTO;
import com.worknomads.worknomads.services.PayContractService;
import ethereum.EthNetworkAPI;
import ethereum.impl.EthNetworkAPIImpl;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

@Service
public class PayContractServiceImpl implements PayContractService {

    private EthNetworkAPI ethNetworkService = new EthNetworkAPIImpl();

    @Override
    public boolean payContract(PayContractDTO transactionDetails) {
        BigInteger amount = BigDecimal.valueOf(transactionDetails.getAmount()).toBigInteger();
        CompletableFuture<TransactionReceipt> receipt = ethNetworkService.payContract(
            transactionDetails.getContractAddress(),
            amount,
            transactionDetails.getToWallet()
        );
        return receipt.toString().isEmpty();
    }
}
