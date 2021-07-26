package com.worknomads.worknomads.dao;

import java.util.List;

public interface RetrieveContractsDAO {

    List<String> retrieveContractAddressesForWallet(String walletAddress);
}
