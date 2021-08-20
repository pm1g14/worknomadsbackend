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

@RestController
public class BusinessPartnerController {

    @Autowired
    private IBusinessPartnerService businessPartnerInterface;

    @RequestMapping(value = "/business-partner/create", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody final RegisterCompanyRequest rc){

        this.businessPartnerInterface.createBusinessPartner(new BusinessPartnerDTO(
                rc.getName(),
                rc.getAddress(),
                rc.getEmail(),
                rc.getPhone(),
                rc.getWalletAddress(), new ArrayList<Contract2DTO>()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/business-partner/{walletAddress}", method = RequestMethod.GET)
    public ResponseEntity<BusinessPartnerDTO> getBusiness(@PathVariable String walletAddress){
        var result = this.businessPartnerInterface.getBusinessPartnerByWalletAddress(walletAddress);

        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/business-partner", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateBusiness(@RequestBody final RegisterCompanyRequest rc){
        this.businessPartnerInterface.updateBusinessPartner(
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
        this.businessPartnerInterface.deleteBusinessPartner(walletAddress);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
