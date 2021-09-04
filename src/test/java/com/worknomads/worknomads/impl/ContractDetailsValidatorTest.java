package com.worknomads.worknomads.impl;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.dtos.ContractDetailsDTO;
import com.worknomads.worknomads.validators.impl.ContractDetailsValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@ContextConfiguration(classes = { ContractDetailsValidator.class })
public class ContractDetailsValidatorTest {

    @Autowired
    private ContractDetailsValidator validator;

    private LocalDate lcd = LocalDate.now().plusDays(5);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String formattedString = lcd.format(formatter);

    @Test
    public void invokingValidate_shouldReturnTrueForValidContractDTOInput() {
        Assertions.assertTrue(validator.validate(getContractDTO("Monthly", "USDT", formattedString)));
    }

    @Test
    public void invokingValidate_shouldReturnFalseForInvalidBalanceUnitOrPaymentTerm() {

        Assertions.assertFalse(validator.validate(getContractDTO(null, "USDT", formattedString)));
        Assertions.assertFalse(validator.validate(getContractDTO("Monthly", "null", formattedString)));
        Assertions.assertFalse(validator.validate(getContractDTO("", "", formattedString)));
    }

    @Test
    public void invokingValidate_shouldReturnFalseForInvalidContractExpiry() {
        Assertions.assertFalse(validator.validate(getContractDTO("Monthly", "USDT", "2016-0:07:21Z")));
        Assertions.assertFalse(validator.validate(getContractDTO("Monthly", "USDT", null)));
    }

    @Test
    public void invokingValidate_shouldReturnFalseForEmptyContractDetails() {
        Assertions.assertFalse(validator.validate(new ContractDTO(
             "a",
             "b",
             "c",
             "d",
             "e",
             "697896850422",
             "address",
             null,
             "addr"
        )));

    }



    private ContractDTO getContractDTO(String paymentTerm, String balanceUnit, String contractExpiry) {
        var contractDetails = new ContractDetailsDTO(
                contractExpiry, "b", 1.0, 5, paymentTerm, balanceUnit
        );
        return new ContractDTO(
            "a",
            "b",
            "c",
            "d",
            "e",
            "697896850422",
            "address",
            contractDetails,
            "addr"
        );
    }
}
