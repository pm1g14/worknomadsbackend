package com.worknomads.worknomads.dao.impl;

import com.worknomads.worknomads.dao.Contracts2Repository;
import com.worknomads.worknomads.dao.RetrieveContractsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RetrieveContractsDAOImpl implements RetrieveContractsDAO {

    @Autowired
    private Contracts2Repository contractsRepository;

    @Override
    public List<String> retrieveContractAddressesForWallet(String walletAddress) {
        return contractsRepository.findByBusinessPartnerWalletAddress(walletAddress);
    }
}
