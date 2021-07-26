package com.worknomads.worknomads.services.contracts;

import com.worknomads.worknomads.dtos.ContractDTOs;
import com.worknomads.worknomads.dtos.RetrievedContractDTO;

public interface RetrieveContractsService {

    ContractDTOs retrieveContracts(String walletAddress);

    RetrievedContractDTO retrieveContract(String cid, String eid);
}
