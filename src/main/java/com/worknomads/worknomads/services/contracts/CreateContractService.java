package com.worknomads.worknomads.services.contracts;

import com.worknomads.worknomads.dtos.ContractDTO;
import org.web3j.protocol.exceptions.TransactionException;

import java.util.concurrent.ExecutionException;

@FunctionalInterface
public interface CreateContractService {

    boolean createContract(ContractDTO contract) throws ExecutionException, InterruptedException, TransactionException;
}
