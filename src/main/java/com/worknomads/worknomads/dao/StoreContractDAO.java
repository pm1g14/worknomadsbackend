package com.worknomads.worknomads.dao;

import com.worknomads.worknomads.dos.ContractDO;

public interface StoreContractDAO {

    boolean storeContractDetails(ContractDO contractDO, String receipt);
}
