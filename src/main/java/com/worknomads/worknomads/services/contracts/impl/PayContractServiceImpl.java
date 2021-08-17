package com.worknomads.worknomads.services.contracts.impl;

import com.worknomads.worknomads.dtos.PayContractDTO;
import com.worknomads.worknomads.services.PayContractService;
import ethereum.EthNetworkAPI;
import ethereum.impl.EthNetworkAPIImpl;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class PayContractServiceImpl implements PayContractService {

    private EthNetworkAPI ethNetworkService = new EthNetworkAPIImpl();

    @Override
    public boolean payContract(PayContractDTO transactionDetails) {
        BigInteger amount = BigDecimal.valueOf(transactionDetails.getAmount()).toBigInteger();
        try {
            String receipt = ethNetworkService.payContract(
                transactionDetails.getContractAddress(),
                amount,
                transactionDetails.getRecipientWalletAddress()
            );
            return StringUtils.isNotEmpty(receipt);
        } catch (Exception e) {
            return false;
        }
    }
}
