package com.worknomads.worknomads.controllers.business;

import com.worknomads.worknomads.controllers.models.RegisterCompanyRequest;
import com.worknomads.worknomads.dtos.BusinessPartnerDTO;
import com.worknomads.worknomads.dtos.Contract2DTO;
import com.worknomads.worknomads.services.businesspartner.IBusinessPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BusinessPartnerController {

    @Autowired
    private IBusinessPartnerService businessPartnerService;

    @RequestMapping(value = "/business-partner/create", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody final RegisterCompanyRequest request){

        businessPartnerService.createBusinessPartner(new BusinessPartnerDTO(
                request.getName(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone(),
                request.getWalletAddress(), new ArrayList<Contract2DTO>()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "https://localhost:44333")
    @RequestMapping(value = "/business-partner/index", method = RequestMethod.GET)
    public ResponseEntity<List<BusinessPartnerDTO>> getBusinessPartners(){
        var result = businessPartnerService
                .getAll();

        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/business-partner/{walletAddress}", method = RequestMethod.GET)
    public ResponseEntity<BusinessPartnerDTO> getBusiness(@PathVariable String walletAddress){
        var result = businessPartnerService
                .getBusinessPartnerByWalletAddress(walletAddress);

        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/business-partner", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateBusiness(@RequestBody final RegisterCompanyRequest rc){
        businessPartnerService.updateBusinessPartner(
                new BusinessPartnerDTO(rc.getName(),
                        rc.getAddress(),
                        rc.getEmail(),
                        rc.getPhone(),
                        rc.getWalletAddress(),
                        new ArrayList<Contract2DTO>()));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/business-partner/{walletAddress}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBusiness(@PathVariable String walletAddress){
        businessPartnerService.deleteBusinessPartner(walletAddress);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
