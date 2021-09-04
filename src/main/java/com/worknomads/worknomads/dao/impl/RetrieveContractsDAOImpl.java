package com.worknomads.worknomads.dao.impl;

import com.worknomads.worknomads.dao.Contracts2Repository;
import com.worknomads.worknomads.dao.RetrieveContractsDAO;
import com.worknomads.worknomads.models.SmartContract;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class RetrieveContractsDAOImpl implements RetrieveContractsDAO {

    @Autowired
    private Contracts2Repository contractsRepository;

    @Override
    public List<String> retrieveContractAddressesForWallet(String walletAddress) {
        return contractsRepository.findByBusinessPartnerWalletAddress(walletAddress);
    }

    @Override
    public List<String> retrieveAllContractAddresses() {
        Iterable<SmartContract> contracts = contractsRepository.findAll();
        Iterator<SmartContract> it = contracts.iterator();
        List<String> contractAddresses = new ArrayList<>();

        while (it.hasNext()) {
            String contractAddress = it.next().getAddress();
            if (StringUtils.isNotEmpty(contractAddress))
                contractAddresses.add(contractAddress);
        }
        return contractAddresses;
    }
}
