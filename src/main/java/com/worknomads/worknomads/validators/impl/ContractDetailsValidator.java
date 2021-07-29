package com.worknomads.worknomads.validators.impl;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.dtos.ContractDetailsDTO;
import com.worknomads.worknomads.enums.BalanceUnit;
import com.worknomads.worknomads.enums.ContractPaymentTerm;
import com.worknomads.worknomads.validators.InputValidator;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class ContractDetailsValidator implements InputValidator<ContractDTO> {

    @Override
    public boolean validate(ContractDTO toBeValidated) {
        if (toBeValidated == null) return false;

        boolean validExpiry = false;
        boolean validPaymentTerm = false;
        if (Optional.of(toBeValidated.getContractDetails()).isPresent()) {
            validExpiry = handleExpiryDate(toBeValidated.getContractDetails().getContractExpiry());
            validPaymentTerm = handlePaymentTermAndUnit(
                toBeValidated.getContractDetails().getPaymentTerm(),
                toBeValidated.getContractDetails().getBalanceUnit()
            );
        }
        return validExpiry && validPaymentTerm;
    }

    private boolean handleExpiryDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC"));

        try {
            ZonedDateTime.parse(dateString, formatter);
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }

    private boolean handlePaymentTermAndUnit(String term, String unit) {
        try {
            ContractPaymentTerm.valueOf(term);
            BalanceUnit.valueOf(unit);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

}
