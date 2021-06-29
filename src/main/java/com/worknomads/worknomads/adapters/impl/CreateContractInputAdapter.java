package com.worknomads.worknomads.adapters.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dtos.ContractDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateContractInputAdapter implements InputAdapter<ContractDTO, ContractDO> {

    @Override
    public ContractDO mapDTOtoDO(ContractDTO dto) {
        return null;
    }
}
