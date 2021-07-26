package com.worknomads.worknomads.adapters.io.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dos.ContractDOs;
import com.worknomads.worknomads.dtos.ContractDTOs;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RetrieveContractsIOAdapter implements InputAdapter<ContractDTOs, ContractDOs> {


    @Override
    public Optional<ContractDTOs> mapDOtoDTO(ContractDOs Do) {
        return null;
    }
}
