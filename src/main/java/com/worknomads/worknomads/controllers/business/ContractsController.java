package com.worknomads.worknomads.controllers.business;

import com.worknomads.worknomads.dtos.*;
import com.worknomads.worknomads.services.PayContractService;
import com.worknomads.worknomads.services.contracts.CreateContractService;
import com.worknomads.worknomads.services.contracts.RetrieveContractsService;
import com.worknomads.worknomads.validators.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

@RestController
public class ContractsController {


    @Autowired
    private InputValidator<ContractDTO> contractValidator;
    @Autowired
    private InputValidator<PayContractDTO> payValidator;
    @Autowired
    private CreateContractService service;
    @Autowired
    private RetrieveContractsService retrieveContractsService;
    @Autowired
    private PayContractService payService;


    @RequestMapping(value = "/app/v1/contracts/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean createContract(
       @RequestBody ContractDTO contract) throws ExecutionException, InterruptedException {

            if (contractValidator.validate(contract)) {
                try {
                    return service.createContract(contract);
                } catch (TransactionException e) {
                    return false;
                }
            }
            return false;
    }


    @RequestMapping(value = "/app/v1/{walletAddress}/contracts/get", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ContractDTOs getPartnerContracts(@PathVariable("walletAddress") String walletAddress) {
        return retrieveContractsService.retrieveContracts(walletAddress);

    }


    @RequestMapping(value = "/app/v1/{companyId}/employeeId/{employeeId}/contract/get", method = RequestMethod.GET)
    @ResponseBody
    public RetrievedContractDTO getContractForEmployee(
       @PathVariable("companyId") String cid,
       @PathVariable("employeeId") String eid) {

        return retrieveContractsService.retrieveContract(cid, eid);
    }

   // @CrossOrigin(origins = "https://work-nomads.netlify.app")
  //  @CrossOrigin(origins = "http://localhost:80")
    @RequestMapping(value = "app/v1/contract/pay", method = RequestMethod.POST)
    @ResponseBody
    public boolean payContract(@RequestBody PayContractDTO payContractDetails) {
        if (payValidator.validate(payContractDetails)) {
            return payService.payContract(payContractDetails);
        } else return false;
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String contractNotCreated(TransactionReceipt ex) {
        return "The contract was not created";
    }

}
