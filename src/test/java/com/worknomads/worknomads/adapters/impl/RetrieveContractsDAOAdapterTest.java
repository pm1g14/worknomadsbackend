package com.worknomads.worknomads.adapters.impl;

import com.worknomads.worknomads.dos.RetrievedContractDO;
import com.worknomads.worknomads.enums.ContractPaymentTerm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.Optional;

@SpringBootTest
@ContextConfiguration(classes = { RetrieveContractsDAOAdapter.class })
public class RetrieveContractsDAOAdapterTest {

    @Value("${eth.network.url}")
    String ethServiceUrl = "http://localhost:8545";


    Web3j getConnection() {
        return Web3j.build(new HttpService(ethServiceUrl));
    }

    @Autowired
    private RetrieveContractsDAOAdapter daoAdapter;

    @Test
    public void validateOrEmptyOptional_shouldReturnExpectedDOForValidInput() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "b", "c", "Monthly", new BigInteger("100000"), new BigInteger("1000000"), true, "sdf", "");
        var expected = new RetrievedContractDO(
                "sdf", "", "a", "b", "c", ContractPaymentTerm.Monthly, 100000.0, 1000000.0, true);
        Assertions.assertEquals(actual.get().getEmployeeEmail(), expected.getEmployeeEmail());
        Assertions.assertEquals(actual.get().getEmployeeName(), expected.getEmployeeName());
        Assertions.assertEquals(actual.get().getEmployeeSur(), expected.getEmployeeSur());
        Assertions.assertEquals(actual.get().getNextPaymentAmount(), expected.getNextPaymentAmount());
        Assertions.assertEquals(actual.get().getRemainingBalance(), expected.getRemainingBalance());
        Assertions.assertEquals(actual.get().getTerm(), expected.getTerm());
        Assertions.assertEquals(actual.get().isActive(), expected.isActive());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnEmptyOptionalForMissingName() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("", "b", "c", "Monthly", new BigInteger("100000"), new BigInteger("1000000"), true,"sdf", "");
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnEmptyOptionalForMissingSurname() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "", "c", "Monthly", new BigInteger("100000"), new BigInteger("1000000"), true, "sdf", "");
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnEmptyOptionalForMissingEmail() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "b", "", "Monthly", new BigInteger("100000"), new BigInteger("1000000"), true, "sdf", "");
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnEmptyOptionalForMissingContractAddress() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "b", "", "Monthly", new BigInteger("100000"), new BigInteger("1000000"), true, "", "");
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnEmptyOptionalForMissingTerm() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "b", "c", "", new BigInteger("100000"), new BigInteger("1000000"), true, "sdf", "");
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnEmptyOptionalForMissingSalary() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "b", "c", "Monthly", BigInteger.ZERO, new BigInteger("1000000"), true, "sdf", "");
        Assertions.assertFalse(actual.isPresent());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnExpectedDOForZeroContractBalance() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "b", "c", "Monthly", new BigInteger("100000"), BigInteger.ZERO, true, "sdf", "");
        var expected = new RetrievedContractDO(
                "sdf", "", "a", "b", "c", ContractPaymentTerm.Monthly, 100000.0, 0.0, true);
        Assertions.assertEquals(actual.get().getEmployeeEmail(), expected.getEmployeeEmail());
        Assertions.assertEquals(actual.get().getEmployeeName(), expected.getEmployeeName());
        Assertions.assertEquals(actual.get().getEmployeeSur(), expected.getEmployeeSur());
        Assertions.assertEquals(actual.get().getNextPaymentAmount(), expected.getNextPaymentAmount());
        Assertions.assertEquals(actual.get().getRemainingBalance(), expected.getRemainingBalance());
        Assertions.assertEquals(actual.get().getTerm(), expected.getTerm());
        Assertions.assertEquals(actual.get().isActive(), expected.isActive());
    }

    @Test
    public void validateOrEmptyOptional_shouldReturnEmptyOptionalForInvalidPaymentTerm() {
        Optional<RetrievedContractDO> actual = daoAdapter.validateOrEmptyOptional("a", "b", "c", "M", new BigInteger("100000"), BigInteger.ZERO, true, "sdf", "");
        Assertions.assertFalse(actual.isPresent());
    }
}
