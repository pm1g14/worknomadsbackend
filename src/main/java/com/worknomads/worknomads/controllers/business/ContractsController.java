package com.worknomads.worknomads.controllers.business;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.dtos.ContractDTOList;
import com.worknomads.worknomads.services.contracts.CreateContractService;
import com.worknomads.worknomads.services.contracts.RetrieveContractsService;
import com.worknomads.worknomads.validators.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

@RestController
public class ContractsController {


    @Autowired
    private InputValidator<ContractDTO> validator;
    @Autowired
    private CreateContractService service;
    @Autowired
    private RetrieveContractsService retrieveContractsService;

    @RequestMapping(value = "/app/v1/{companyId}/contracts/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean createContract(
       @PathVariable("companyId") String cid,
       @RequestBody ContractDTO contract) throws ExecutionException, InterruptedException {

            if (validator.validate(contract)) {
                return service.createContract(contract, cid);
            }
            return false;
    }


    @RequestMapping(value = "/app/v1/{companyId}/contracts/get", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ContractDTOList getAllContracts(@PathVariable("companyId") String cid) {
        return new ContractDTOList(Collections.emptyList());

    }


    @RequestMapping(value = "/app/v1/{companyId}/employeeId/{employeeId}/contract/get", method = RequestMethod.GET)
    @ResponseBody
    public ContractDTO getContractForId(
       @PathVariable("companyId") String cid,
       @PathVariable("employeeId") String eid) {

        return retrieveContractsService.retrieveContract(cid, eid);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String contractNotCreated(TransactionReceipt ex) {
        return "";
    }

}
