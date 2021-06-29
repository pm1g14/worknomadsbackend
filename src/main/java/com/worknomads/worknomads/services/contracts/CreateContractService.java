package com.worknomads.worknomads.services.contracts;

import com.worknomads.worknomads.dtos.ContractDTO;

@FunctionalInterface
public interface CreateContractService {

    void createContract(ContractDTO contract, String cid);
}
