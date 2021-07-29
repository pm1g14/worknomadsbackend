package com.worknomads.worknomads.adapters.io.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dos.ContractDOs;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import com.worknomads.worknomads.dtos.ContractDTOs;
import com.worknomads.worknomads.dtos.RetrievedContractDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RetrieveContractsIOAdapter implements InputAdapter<ContractDTOs, ContractDOs> {


    @Override
    public Optional<ContractDTOs> mapDOtoDTO(ContractDOs Do) {
        List<RetrievedContractDTO> contractDTOs = new ArrayList<>();
        for (RetrievedContractDO contractDO: Do.getContractList()) {
            RetrievedContractDTO contractDTO = new RetrievedContractDTO(
                    contractDO.getEmployeeName(),
                    contractDO.getEmployeeSur(),
                    contractDO.getEmployeeEmail(),
                    contractDO.getTerm().term,
                    contractDO.getNextPaymentAmount(),
                    contractDO.getRemainingBalance(),
                    contractDO.isActive()
            );
            contractDTOs.add(contractDTO);
        }
        return Optional.of(new ContractDTOs(contractDTOs));
    }
}
