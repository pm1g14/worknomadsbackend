package com.worknomads.worknomads.validators.impl;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.validators.InputValidator;
import org.springframework.stereotype.Component;

@Component
public class ContractDetailsValidator implements InputValidator<ContractDTO> {

    @Override
    public boolean validate(ContractDTO toBeValidated) {
        return true; //TODO provide an implementation for the validator
    }
}
