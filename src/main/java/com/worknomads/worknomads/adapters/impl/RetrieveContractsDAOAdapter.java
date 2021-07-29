package com.worknomads.worknomads.adapters.impl;

import com.worknomads.worknomads.adapters.InputAdapter;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import com.worknomads.worknomads.enums.ContractPaymentTerm;
import ethereum.wrappers.EmploymentContract_sol_EmploymentContract;

import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class RetrieveContractsDAOAdapter implements InputAdapter<EmploymentContract_sol_EmploymentContract, RetrievedContractDO> {


    @Override
    public Optional<RetrievedContractDO> mapDTOtoDO(EmploymentContract_sol_EmploymentContract dto) {
        CompletableFuture<String> paymentTerm = dto.paymentTerm().sendAsync();
        CompletableFuture<String> name = dto.employeeName().sendAsync();
        CompletableFuture<String> surname = dto.employeeSur().sendAsync();
        CompletableFuture<String> email = dto.employeeEmail().sendAsync();
        CompletableFuture<BigInteger> salary = dto.employeeSalary().sendAsync();
        CompletableFuture<BigInteger> balance = dto.getBalance().sendAsync();
        CompletableFuture<Boolean> isActive = dto.isActiveContract().sendAsync();

        CompletableFuture<RetrievedContractDO> contractsDOFut = paymentTerm.thenCompose(
            (String term) ->
                name.thenCompose( (String n) ->
                    surname.thenCompose( (String sur) ->
                        email.thenCompose( (String em) ->
                            salary.thenCompose( (BigInteger sal) ->
                                balance.thenCompose( (BigInteger bal) ->
                                    isActive.thenApply((Boolean active) ->
                                        new RetrievedContractDO(n, sur, em, ContractPaymentTerm.valueOf(term), sal.doubleValue(), bal.doubleValue(), active)
                                    )
                                )
                            )
                        )
                    )
                )
            );
        return Optional.of(contractsDOFut.join());
    }
}
