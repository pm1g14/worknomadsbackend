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
        results.add("0xd8b934580fcE35a11B58C6D73aDeE468a2833fa8");
        return results;
    }
}
