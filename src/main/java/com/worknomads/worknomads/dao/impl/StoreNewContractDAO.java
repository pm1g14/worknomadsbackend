package com.worknomads.worknomads.dao.impl;

import com.worknomads.worknomads.dao.StoreContractDAO;
import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dos.ContractDetailsDO;
import org.springframework.stereotype.Component;

@Component
public class StoreNewContractDAO implements StoreContractDAO {


    @Override
    public boolean storeContractDetails(ContractDO contractDO, String receipt) {
        return false;
    }
}
