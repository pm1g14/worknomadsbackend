package com.worknomads.worknomads.services.contracts.impl;

import com.worknomads.worknomads.dtos.PayContractDTO;
import com.worknomads.worknomads.enums.BalanceUnit;
import com.worknomads.worknomads.services.PayContractService;
import com.worknomads.worknomads.ethereum.EthNetworkAPI;
import com.worknomads.worknomads.ethereum.impl.EthNetworkAPIImpl;
import com.worknomads.worknomads.ethereum.utils.AmountConversionUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class PayContractServiceImpl implements PayContractService {

    private EthNetworkAPI ethNetworkService = new EthNetworkAPIImpl();

    @Override
    public boolean payContract(PayContractDTO transactionDetails) {
        if (transactionDetails == null) return false;
        BigDecimal amount = BigDecimal.valueOf(transactionDetails.getAmount());
        BalanceUnit unit = BalanceUnit.valueOf(transactionDetails.getPaymentUnit());
        BigInteger amountToWei;

        if (BalanceUnit.ETHEREUM.equals(unit))
            amountToWei = AmountConversionUtils.convertEthToWei.apply(amount).toBigInteger();
        else
            amountToWei = amount.toBigInteger();

        try {
            String receipt = ethNetworkService.payContract(
                transactionDetails.getContractAddress(),
                amountToWei,
                transactionDetails.getRecipientWalletAddress()
            );
            return StringUtils.isNotEmpty(receipt);
        } catch (Exception e) {
            return false;
        }
    }
}
