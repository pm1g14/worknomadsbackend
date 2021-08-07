package com.worknomads.worknomads.services;

import com.worknomads.worknomads.dtos.PayContractDTO;

public interface PayContractService {

    boolean payContract(PayContractDTO transactionDetails);
}
