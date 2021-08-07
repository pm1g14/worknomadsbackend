package com.worknomads.worknomads.dao.impl;

import com.worknomads.worknomads.dao.RetrieveContractsDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RetrieveContractsDAOImpl implements RetrieveContractsDAO {

    @Override
    public List<String> retrieveContractAddressesForWallet(String walletAddress) {
        //TODO actual implementation
        ArrayList<String> results = new ArrayList<>();
        results.add("0x0ffc6b8d803fe1f632c04188e8bdcf59c3a003a0");
        return results;
    }
}
