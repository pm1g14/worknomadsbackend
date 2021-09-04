package com.worknomads.worknomads.validators.impl;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.enums.BalanceUnit;
import com.worknomads.worknomads.enums.ContractPaymentTerm;
import com.worknomads.worknomads.validators.InputValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class ContractDetailsValidator implements InputValidator<ContractDTO> {

    @Override
    public boolean validate(ContractDTO toBeValidated) {
        if (toBeValidated == null) return false;

        boolean validExpiry = false;
        boolean validPaymentTerm = false;
        if (Optional.ofNullable(toBeValidated.getContractDetails()).isPresent()) {
            validExpiry = handleExpiryDate(toBeValidated.getContractDetails().getContractExpiry());
            validPaymentTerm = handlePaymentTermAndUnit(
                toBeValidated.getContractDetails().getPaymentTerm(),
                toBeValidated.getContractDetails().getBalanceUnit()
            );
        }
        return validExpiry && validPaymentTerm;
    }

    private boolean handleExpiryDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            var zdt = LocalDate.parse(dateString, formatter);
            var now = LocalDate.now();
            if (zdt.isBefore(now)) return false;
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean handlePaymentTermAndUnit(String term, String unit) {
        try {
            ContractPaymentTerm.valueOf(term);
            BalanceUnit.valueOf(unit);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
