package com.worknomads.worknomads.services.contracts;

import com.worknomads.worknomads.dtos.ContractDTO;

public interface RetrieveContractsService {

    void retrieveContracts(String cid);

    ContractDTO retrieveContract(String cid, String eid);
}
