package com.worknomads.worknomads.services.contracts.impl;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.dtos.ContractDetailsDTO;
import com.worknomads.worknomads.enums.BalanceUnit;
import com.worknomads.worknomads.services.contracts.RetrieveContractsService;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

@Service
public class RetrieveContractsServiceImpl implements RetrieveContractsService {

    @Override
    public void retrieveContracts(String cid) {

    }

    @Override
    public ContractDTO retrieveContract(String cid, String eid) {
        //TODO to be replaced by a DAO call to the db
        return new ContractDTO("", "", "", "", "", "", "", new ContractDetailsDTO("1", "Y", 1.1, 0, "monthly", BalanceUnit.USD_TETHER.unit), "");
    }

}
