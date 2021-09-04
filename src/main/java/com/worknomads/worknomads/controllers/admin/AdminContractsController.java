package com.worknomads.worknomads.controllers.admin;

import com.worknomads.worknomads.dtos.ContractDTOs;
import com.worknomads.worknomads.services.contracts.RetrieveContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminContractsController {

    @Autowired
    private RetrieveContractsService retrieveContractsService;

    @CrossOrigin(origins = "https://work-nomads.netlify.app")
    @RequestMapping(value = "/app/v1/contracts/get", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ContractDTOs getAllContracts() {
        return retrieveContractsService.retrieveContracts("");
    }
}
