package com.worknomads.worknomads.services.contracts;

import com.worknomads.worknomads.dtos.ContractDTO;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface CreateContractService {

    boolean createContract(ContractDTO contract, String cid) throws ExecutionException, InterruptedException;
}
