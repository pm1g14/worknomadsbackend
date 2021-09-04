package com.worknomads.worknomads.adapters.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import com.worknomads.worknomads.enums.ContractPaymentTerm;
import ethereum.wrappers.EmploymentContract_sol_EmploymentContract;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class RetrieveContractsDAOAdapter implements InputAdapter<EmploymentContract_sol_EmploymentContract, RetrievedContractDO> {


    @Override
    public Optional<RetrievedContractDO> mapDTOtoDO(EmploymentContract_sol_EmploymentContract dto) {
        String contractAddress = dto.getContractAddress();
        CompletableFuture<String> paymentTerm = dto.paymentTerm().sendAsync();
        CompletableFuture<String> name = dto.employeeName().sendAsync();
        CompletableFuture<String> surname = dto.employeeSur().sendAsync();
        CompletableFuture<String> email = dto.employeeEmail().sendAsync();
        CompletableFuture<BigInteger> salary = dto.employeeSalary().sendAsync();
        CompletableFuture<BigInteger> balance = dto.getBalance().sendAsync();
        CompletableFuture<Boolean> isActive = dto.isActiveContract().sendAsync();

        CompletableFuture<Optional<RetrievedContractDO>> contractsDOFut = paymentTerm.thenCompose(
            (String term) ->
                name.thenCompose( (String n) ->
                    surname.thenCompose( (String sur) ->
                        email.thenCompose( (String em) ->
                            salary.thenCompose( (BigInteger sal) ->
                                balance.thenCompose( (BigInteger bal) ->
                                    isActive.thenApply((Boolean active) -> validateOrEmptyOptional(n, sur, em, term, sal, bal, active, contractAddress)
                                    )
                                )
                            )
                        )
                    )
                )
            );
        return contractsDOFut.join();
    }


    Optional<RetrievedContractDO> validateOrEmptyOptional(
        String name,
        String surname,
        String email,
        String term,
        BigInteger salary,
        BigInteger balance,
        Boolean isActive,
        String contractAddress) {

            if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || term.isEmpty() || contractAddress.isEmpty() || salary.equals(BigInteger.ZERO)) {
                return Optional.empty();
            }

            try {
                ContractPaymentTerm paymentTerm = ContractPaymentTerm.valueOf(term);
                return Optional.of(
                   new RetrievedContractDO(contractAddress, "son", name, surname, email, paymentTerm, salary.doubleValue(), balance.doubleValue(), isActive)
                );
            } catch (IllegalArgumentException ex) {
                return Optional.empty();
            }
        }

}
