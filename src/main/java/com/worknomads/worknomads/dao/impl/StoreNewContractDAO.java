package com.worknomads.worknomads.dao.impl;

import com.worknomads.worknomads.dao.Contracts2Repository;
import com.worknomads.worknomads.dao.StoreContractDAO;
import com.worknomads.worknomads.enums.ContractStatus;
import com.worknomads.worknomads.models.SmartContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreNewContractDAO implements StoreContractDAO {

    @Autowired
    private Contracts2Repository contractsRepository;


    @Override
    public boolean storeContractDetails(String companyWalletAddress, String contractAddress) {

        if (!contractAddress.isEmpty() && !companyWalletAddress.isEmpty()) {
            var smartContract = new SmartContract(contractAddress, ContractStatus.ACTIVE.toString(), companyWalletAddress);
            contractsRepository.save(smartContract);
            return true;
        }
        return false;
    }
}
