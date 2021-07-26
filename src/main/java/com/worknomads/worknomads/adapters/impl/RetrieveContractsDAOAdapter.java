package com.worknomads.worknomads.adapters.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dos.ContractDOs;
import ethereum.wrappers.EmploymentContract_sol_EmploymentContract;

import java.util.Optional;

public class RetrieveContractsDAOAdapter implements InputAdapter<EmploymentContract_sol_EmploymentContract, ContractDOs> {

    @Override
    public Optional<ContractDOs> mapDTOtoDO(EmploymentContract_sol_EmploymentContract dto) {
        return Optional.empty();
    }
}
