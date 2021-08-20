package com.worknomads.worknomads.controllers.employee;

import com.worknomads.worknomads.controllers.models.RegisterEmployeeRequest;
import com.worknomads.worknomads.dtos.EmployeeDTO;
import com.worknomads.worknomads.services.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody final RegisterEmployeeRequest request){

        this.employeeService.createEmployee(new EmployeeDTO(
                request.getEmployeeName(),
                request.getEmployeeSur(),
                request.getAddress(),
                request.getCountryOfResidence(),
                request.getEmail(),
                request.getPhoneNum(),
                request.getEmployeeWalletAddress()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/{walletAddress}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String walletAddress){
        var result = this.employeeService.getEmployeeByWalletAddress(walletAddress);

        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEmployee(@RequestBody final RegisterEmployeeRequest request){
        this.employeeService.updateEmployee(
                new EmployeeDTO(
                        request.getEmployeeName(),
                        request.getEmployeeSur(),
                        request.getAddress(),
                        request.getCountryOfResidence(),
                        request.getEmail(),
                        request.getPhoneNum(),
                        request.getEmployeeWalletAddress()));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{walletAddress}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmployee(@PathVariable String walletAddress){
        this.employeeService.deleteEmployee(walletAddress);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
