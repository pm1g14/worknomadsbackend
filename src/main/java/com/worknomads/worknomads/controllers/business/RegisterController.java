package com.worknomads.worknomads.controllers.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @RequestMapping(value = "/app/v1/company/{companyName}/register/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registerCompany(@PathVariable("companyName") String companyName) {

    }


}
