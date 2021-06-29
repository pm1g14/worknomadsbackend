package com.worknomads.worknomads.controllers.business;

import com.worknomads.worknomads.dtos.ContractDTO;
import com.worknomads.worknomads.dtos.ContractDTOList;
import com.worknomads.worknomads.services.contracts.CreateContractService;
import com.worknomads.worknomads.services.contracts.RetrieveContractsService;
import com.worknomads.worknomads.validators.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

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
    public void createContract(
       @PathVariable("companyId") String cid,
       @RequestBody ContractDTO contract) {

            if (validator.validate(contract)) {
                service.createContract(contract, cid);
            }

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
}
