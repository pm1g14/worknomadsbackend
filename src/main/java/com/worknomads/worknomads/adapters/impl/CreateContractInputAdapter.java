package com.worknomads.worknomads.adapters.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dos.ContractDetailsDO;
import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.dtos.ContractDetailsDTO;
import com.worknomads.worknomads.enums.BalanceUnit;
import com.worknomads.worknomads.enums.ContractPaymentTerm;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

@Component
public class CreateContractInputAdapter implements InputAdapter<ContractDTO, ContractDO> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    @Override
    public Optional<ContractDO> mapDTOtoDO(ContractDTO dto) {
        return Optional.of(new ContractDO(
                dto.getEmployeeName(),
                dto.getEmployeeSur(),
                dto.getAddress(),
                dto.getCountryOfResidence(),
                dto.getEmail(),
                dto.getPhoneNum(),
                dto.getCompanyWalletAddress(),
                dto.getEmployeeWalletAddress(),
                getContractDetailsDOFromDTO(dto)
        ));
    }

    @Override
    public Optional<ContractDTO> mapDOtoDTO(ContractDO Do) {
        return Optional.empty();
    }


    private ContractDetailsDO getContractDetailsDOFromDTO(ContractDTO dto) {
        ContractDetailsDTO contractDetailsDTO = dto.getContractDetails();
        ContractDetailsDO contractDetailsDO = new ContractDetailsDO(
                ZonedDateTime.parse(contractDetailsDTO.getContractExpiry(), formatter),
                new Locale(contractDetailsDTO.getRemoteLocation()),
                contractDetailsDTO.getGrossSalary(),
                contractDetailsDTO.getPaymentInstallments(),
                ContractPaymentTerm.valueOf(contractDetailsDTO.getPaymentTerm()),
                BalanceUnit.valueOf(contractDetailsDTO.getBalanceUnit())
        );
        return contractDetailsDO;
    }
}
