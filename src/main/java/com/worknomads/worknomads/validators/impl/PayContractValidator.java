package com.worknomads.worknomads.validators.impl;

import com.worknomads.worknomads.dtos.PayContractDTO;
import com.worknomads.worknomads.validators.InputValidator;
import org.springframework.stereotype.Component;

@Component
public class PayContractValidator implements InputValidator<PayContractDTO> {

    @Override
    public boolean validate(PayContractDTO toBeValidated) {
        boolean sameAdresses = toBeValidated.getContractAddress().equals(toBeValidated.getRecipientWalletAddress());
        return (!(toBeValidated.getContractAddress().isEmpty() ||
                toBeValidated.getRecipientWalletAddress().isEmpty() ||
                sameAdresses ||
                toBeValidated.getAmount() == 0.0));
    }
}
