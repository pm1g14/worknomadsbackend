package com.worknomads.worknomads.impl;

import com.worknomads.worknomads.dtos.PayContractDTO;
import com.worknomads.worknomads.validators.impl.PayContractValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { PayContractValidator.class })
public class PayContractValidatorTest {

    @Autowired
    private PayContractValidator validator;

    @Test
    public void invokingValidate_shouldReturnTrueForValidInputObject() {
        PayContractDTO dto = new PayContractDTO("abcd", 1.0, "", "ad");
        Assertions.assertTrue(validator.validate(dto));
    }

    @Test
    public void invokingValidate_shouldReturnFalseForSameRecipientAndContractAddresses() {
        PayContractDTO dto = new PayContractDTO("abcd", 1.0, "", "abcd");
        Assertions.assertFalse(validator.validate(dto));
    }

    @Test
    public void invokingValidate_shouldReturnFalseForEmptyRecipientOrContractAddresses() {
        PayContractDTO dto = new PayContractDTO("", 1.0, "", "abcd");
        Assertions.assertFalse(validator.validate(dto));

        PayContractDTO dto2 = new PayContractDTO("a", 1.0, "", "");
        Assertions.assertFalse(validator.validate(dto2));
    }

    @Test
    public void invokingValidate_shouldReturnFalseForZeroAmount() {
        PayContractDTO dto = new PayContractDTO("abcd", 0.0, "", "acd");
        Assertions.assertFalse(validator.validate(dto));
    }

}
