package com.worknomads.worknomads.services.contracts.impl;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.dtos.ContractDetailsDTO;
import com.worknomads.worknomads.services.contracts.RetrieveContractsService;
import org.springframework.stereotype.Service;

@Service
public class RetrieveContractsServiceImpl implements RetrieveContractsService {

    @Override
    public void retrieveContracts(String cid) {

    }

    @Override
    public ContractDTO retrieveContract(String cid, String eid) {
        //TODO to be replaced by a DAO call to the db
        return new ContractDTO("", "", "", "", "", "", new ContractDetailsDTO(1, "Y", "", 0.0, 5, "monthly"));
    }

}
